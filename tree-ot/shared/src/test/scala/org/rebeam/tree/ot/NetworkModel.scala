package org.rebeam.tree.ot

import cats.data.State
import org.rebeam.tree.ot.ServerMessage.{ServerConfirmation, ServerRemoteOp}

import scala.collection.immutable.Queue

object NetworkModel {

  case class NetworkClient(state: ClientState[Char], fromServer: Queue[ServerMessage[Char]], toServer: Queue[OpRev[Char]]) {
    def queueFromServer(msg: ServerMessage[Char]): NetworkClient = copy(fromServer = fromServer.enqueue(msg))
    def queueToServer(op: OpRev[Char]): NetworkClient = copy(toServer = toServer.enqueue(op))

    def dequeueFromServer: Option[(ServerMessage[Char], NetworkClient)] =
      fromServer.dequeueOption.map{ case (msg, queue) => (msg, copy(fromServer = queue)) }

    def dequeueToServer: Option[(OpRev[Char], NetworkClient)] =
      toServer.dequeueOption.map{ case (op, queue) => (op, copy(toServer = queue)) }
  }

  case class Network(server: ServerState[Char], clients: List[NetworkClient]) {
    def updatedClient(i: Int, c: NetworkClient): Network = copy(clients = clients.updated(i, c))
    def updatedServer(s: ServerState[Char]): Network = copy(server = s)

    def purgeFirst: NetworkState[Boolean] = purgeFrom(0)

    def purgeFrom(i: Int, fromServerFirst: Boolean = true): NetworkState[Boolean] = {
      val rotatedClients: List[NetworkClient] = if (i == 0) {
        clients
      } else {
        val r = i % clients.size
        clients.drop(r) ++ clients.take(r)
      }

      val firstClientWithMessage = rotatedClients.indexWhere(c => c.fromServer.nonEmpty || c.toServer.nonEmpty)
      if (firstClientWithMessage > -1) {
        val c = clients(firstClientWithMessage)
        val fromServer = c.fromServer.nonEmpty
        val toServer = c.toServer.nonEmpty
        if ((fromServer && !toServer) || (fromServer && toServer && fromServerFirst)) {
          ClientOps.receiveAndReply(firstClientWithMessage).map(_ => true)
        } else {
          ServerOps.receiveAndReply(firstClientWithMessage).map(_ => true)
        }
      } else {
        State.pure(false)
      }
    }
  }

  object Network{
    def apply(list: List[Char], clientCount: Int): Network = {
      val listRev = ListRev(list, Rev(0))

      //Server
      val server = ServerState[Char](list, Nil)
      val client = NetworkClient(ClientState(server = listRev, local = list, pendingOp = None, buffer = None), Queue.empty, Queue.empty)

      Network(server, List.fill(clientCount)(client))
    }
  }

  type NetworkState[A] = State[Network, A]

  object ClientOps {
    /**
      * Perform an edit on a client, updating the client and producing an optional message for the server
      * @param i  The index of the client
      * @param op The operation to perform on the client
      * @return   NetworkState for the action, returning any resulting OpRev
      */
    def edit(i: Int, op: Operation[Char]): NetworkState[Option[OpRev[Char]]] = State.apply( s => {
      val client = s.clients(i)
      val clientState = client.state
      val (newState, clientOp) = clientState.withClientOp(op)
      val newClient = client.copy(state = newState)
      (
        s.updatedClient(i, newClient),
        clientOp
      )
    })

    /**
      * Add a message from a client to the server queue
      * @param i  The index of the client
      * @param op The operation to add to the queue (optional)
      * @return   NetworkState for the action
      */
    def send(i: Int, op: Option[OpRev[Char]]): NetworkState[Unit] = State.modify( s => {
      val client = s.clients(i)
      val newClient = op.fold(client)(client.queueToServer)
      s.updatedClient(i, newClient)
    })

    /**
      * Perform a client operation, and queue any resulting message for the server
      * @param i  The index of the client
      * @param op The operation to perform on the client
      * @return   NetworkState for the action, returning any resulting OpRev (which has already been queued for the server)
      */
    def editAndSend(i: Int, op: Operation[Char]): NetworkState[Option[OpRev[Char]]] = for {
      opRev <- edit(i, op)
      _ <- send(i, opRev)
    } yield opRev


    /**
      * Perform a client operation, and queue any resulting message for the server
      * @param i  The index of the client
      * @param atoms The atoms to build an operation to perform on the client
      * @return   NetworkState for the action, returning any resulting OpRev (which has already been queued for the server)
      */
    def editAndSend(i: Int, atoms: Atom[Char]*): NetworkState[Option[OpRev[Char]]] = editAndSend(i, Operation.fromAtoms(atoms.toList, i))

    /**
      * Receive a message from the server (remove it from the queue)
      * @param i  The index of the client
      * @return   The message (if any)
      */
    private[ClientOps] def receive(i: Int): NetworkState[Option[ServerMessage[Char]]] = State.apply( s => {
      val client = s.clients(i)

      client.dequeueFromServer.fold(
        //No message
        (s, None: Option[ServerMessage[Char]])
      ){
        case (serverMessage, newClient) => {
          (s.updatedClient(i, newClient), Some(serverMessage))
        }
      }
    })

    /**
      * Process a message from the server (if any)
      * @param i  The index of the client
      * @return   The response message (if any)
      */
    private[ClientOps] def process(i: Int, serverMsg: Option[ServerMessage[Char]]): NetworkState[Option[OpRev[Char]]] = State.apply( s => {
      val client = s.clients(i)

      serverMsg.fold(
        (s, None: Option[OpRev[Char]])
      )(
        msg => {
          val (newState, optionalOpRev) = client.state.withServerMessage(msg)
          (s.updatedClient(i, client.copy(state = newState)), optionalOpRev)
        }
      )

    })

    /**
      * Receive (pull form queue) and process a message, if one is available. Send (queue) a reply for server
      * if there was a message and it needed a reply.
      * @param i  The index of the client
      * @return   The response message (if any)
      */
    def receiveAndReply(i: Int): NetworkState[Option[OpRev[Char]]] = for {
      msg <- receive(i)
      reply <- process(i, msg)
      _ <- send(i, reply)
    } yield reply

  }

  object ServerOps {
    /**
      * Add a message from the server to all client queues.
      * @param confirmClientIndex The client at this index will receive the operation as a ServerConfirmation, the others
      *                           will receive the op in a ServerRemoteOp
      * @param optionalOp         The operation to send
      * @return                   NetworkState for the action
      */
    private[ServerOps] def send(confirmClientIndex: Int, optionalOp: Option[OpRev[Char]]): NetworkState[Unit] = State.modify( s => {
      optionalOp.fold(
        s
      )(
        op => {
          val newClients = s.clients.zipWithIndex.map{
            case (client, i) =>
              val msg: ServerMessage[Char] = if (i == confirmClientIndex) ServerConfirmation() else ServerRemoteOp(op.op)
              client.queueFromServer(msg)
          }
          s.copy(clients = newClients)
        }
      )
    })

    /**
      * Receive a message from the specified client(remove it from the queue)
      * @param i  The index of the client
      * @return   The message (if any)
      */
    private[ServerOps] def receive(i: Int): NetworkState[Option[OpRev[Char]]] = State.apply( s => {
      val client = s.clients(i)

      client.dequeueToServer.fold(
        //No message
        (s, None: Option[OpRev[Char]])
      ){
        case (clientMessage, newClient) =>
          (s.updatedClient(i, newClient), Some(clientMessage))
      }
    })

    /**
      * Process a message from a specified client (if any)
      * @param i  The index of the client
      * @return   The response message (if any)
      */
    private[ServerOps] def process(i: Int, clientMessage: Option[OpRev[Char]]): NetworkState[Option[OpRev[Char]]] = State.apply( s => {
      clientMessage.fold(
        (s, None: Option[OpRev[Char]])
      )(
        msg => {
          val (newState, serverMessage) = s.server.updated(msg)
//          println(newState.list.mkString)
          (s.updatedServer(newState), Some(serverMessage))
        }
      )
    })

    /**
      * Receive (pull form queue) and process a message from specificed client, if one is available.
      * Send (queue) a reply for all clients if there was a message and it needed a reply.
      * @param i  The index of the client to receive from (will send to all)
      * @return   The response message (if any)
      */
    def receiveAndReply(i: Int): NetworkState[Option[OpRev[Char]]] = for {
      msg <- receive(i)
      reply <- process(i, msg)
      _ <- send(i, reply)
    } yield reply

  }

  object NetworkOps {

    /**
      * Purge a single message (if there is one), starting from a given client, and then checking round-robin.
      * @param i                The first client index to check for messages to purge
      * @param fromServerFirst  If true, messages from server to client will be purged first, otherwise client to server
      *                         messages will be purged first.
      * @return
      */
    def purgeFrom(i: Int, fromServerFirst: Boolean = true): NetworkState[Boolean] = for {
      n <- State.get[Network]
      done <- n.purgeFrom(i, fromServerFirst)
    } yield done

    /**
      * Purge all messages, in order of increasing client index, handling server messages before clients
      * @return NetworkState purging all messages
      */
    def purgeAllMessages: NetworkState[Unit] = purgeFrom(0).flatMap(b =>
      if (b) {
        purgeAllMessages
      } else {
        State.pure(())
      }
    )

  }

}
