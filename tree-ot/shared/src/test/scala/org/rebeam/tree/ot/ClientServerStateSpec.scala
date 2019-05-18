package org.rebeam.tree.ot

import org.rebeam.tree.ot.Atom._
import org.scalatest._
import org.scalatest.prop.Checkers
import NetworkModel._
import org.scalacheck.Prop._
import OTGen._

/**
  * Test ClientState and ServerState together
  */
class ClientServerStateSpec extends WordSpec with Matchers with Checkers {

  "Client and Server network model" should {

    "run arbitrary network sequence to produce matching server and client results" in {
      val clients = 5
      val operations = 1000
      val maxAtomCount = 5
      check (
        forAll(genNetworkStateSequence(clients, operations, maxAtomCount)) {
          s: NetworkState[Unit] => {
            //Initial data state
            val l0 = "Hello".toList

            //Initial network state
            val n0 = Network(l0, clients)

            val n1 = s.run(n0).value._1

            val serverList = n1.server.list
            val serverRev = Rev(n1.server.history.size)

            n1.clients.forall( c =>
              c.toServer.isEmpty &&
              c.fromServer.isEmpty &&
              c.state.pendingOp.isEmpty &&
              c.state.buffer.isEmpty &&
              c.state.local == serverList &&
              c.state.server.a == serverList &&
              c.state.server.rev == serverRev
            )

          }
        },
          MinSuccessful(100)
        )
    }

    "have no messages left after editing then purging" in {
      //Initial data state
      val l0 = "Hello".toList

      //Initial network state
      val n0 = Network(l0, 2)

      //Make some edits, leaving some network traffic in both directions on each client
      val fill: NetworkState[Unit] = for {

        //Client 0 edits (from initial revision to "Hello World!")
        _ <- ClientOps.editAndSend(0, Retain(5), Insert(" World!".toList))

        //Client 1 edits (from initial revision to "Helloo"). This client has the higher index and so priority, and
        //so will insert before client 0, even though client 0's message will be processed first. This is why we
        //end up with "HellooO World!!" rather than "Hello World!!oO"
        _ <- ClientOps.editAndSend(1, Retain(5), Insert("o".toList))

        //Server responds to first client first
        _ <- ServerOps.receiveAndReply(0)

        //Client 0 edits again
        _ <- ClientOps.editAndSend(0, Retain(12), Insert("!".toList))

        //Client 1 edits (Add another "O")
        _ <- ClientOps.editAndSend(1, Retain(6), Insert("O".toList))

      } yield ()

      // Run the test and get our "full" network state
      val n1 = fill.run(n0).value._1

      //Check we have traffic
      //Each client has one message - reply from server to client 0's message
      assert (n1.clients(0).fromServer.size == 1)
      assert (n1.clients(1).fromServer.size == 1)

      //Client 0 has had a message processed
      assert (n1.clients(0).toServer.isEmpty)
      //Client 1's message is still waiting
      assert (n1.clients(1).toServer.size == 1)

      //Purge the traffic
      val n2 = NetworkOps.purgeAllMessages.run(n1).value._1

      //Check traffic is empty and data is correct
      val l2 = "HellooO World!!".toList
      val revisionCount2 = 4

      // Check server has correct final list and revision count
      assert(n2.server.list == l2)
      assert(n2.server.history.size == revisionCount2)

      // Check network clients have expected list on server and locally, with no waiting or buffered ops, and
      // no pending network activity
      assert(n2.clients.forall(
        nc =>
          nc.state.local == l2 &&
            nc.state.server == ListRev(l2, Rev(revisionCount2)) &&
            nc.state.pendingOp.isEmpty &&
            nc.state.buffer.isEmpty &&
            nc.toServer.isEmpty &&
            nc.fromServer.isEmpty
      ))

    }

    "run a simple set of edits" in {
      //Initial data state
      val l0 = "Hello".toList

      //Initial network state
      val n0 = Network(l0, 2)

      //Run our tests
      val test: NetworkState[Unit] = for {

        //Client 0 edits (from initial revision to "Hello World!")
        _ <- ClientOps.editAndSend(0, Retain(5), Insert(" World!".toList))

        //Client 1 edits (from initial revision to "Helloo")
        _ <- ClientOps.editAndSend(1, Retain(5), Insert("o".toList))

        //Server processes Client 1's edit first (and notifies both clients)
        _ <- ServerOps.receiveAndReply(1)

        //Client 1 receives confirmation of its own edit
        _ <- ClientOps.receiveAndReply(1)

        //Client 0 receives remote operation from Client 1, updates its waiting op
        _ <- ClientOps.receiveAndReply(0)

        //Server processes Client 1's edit (and notifies both clients)
        _ <- ServerOps.receiveAndReply(0)

        //Client 0 receives confirmation
        _ <- ClientOps.receiveAndReply(0)

        //Client 1 receives confirmation
        _ <- ClientOps.receiveAndReply(1)

      } yield ()

      // Run the test and get our final network state
      val n1 = test.run(n0).value._1

      // Check contents of network
      val l1 = "Helloo World!".toList
      val revisionCount = 2

      // Check server has correct final list and revision count
      assert(n1.server.list == l1)
      assert(n1.server.history.size == revisionCount)

      // Check network clients have expected list on server and locally, with no waiting or buffered ops, and
      // no pending network activity
      assert(n1.clients.forall(
        nc =>
          nc.state.local == l1 &&
          nc.state.server == ListRev(l1, Rev(revisionCount)) &&
          nc.state.pendingOp.isEmpty &&
          nc.state.buffer.isEmpty &&
          nc.toServer.isEmpty &&
          nc.fromServer.isEmpty
      ))

    }
  }

  "Client and Server state" should {

    // This test goes through the server-client communications in a fairly
    // manual way, for a pair of concurrent edits on two clients, to show the
    // workings
    // Note this does not test buffer ops
    "run a simple set of edits" in {

      //Initial data state
      val l0 = "Hello".toList
      val lr0 = ListRev(l0, Rev(0))

      //Server
      val server0 = ServerState(l0, Nil)

      //First client - starts up to date with server
      val clientA0 = ClientState(priority = 0, server = lr0, local = l0, pendingOp = None, buffer = None)

      //First client edits. We are simulating a long lag, so this doesn't make it to the
      //server yet...
      val opA0 = Operation[Char](List(Retain(5), Insert(" World!".toList)))
      val (clientA1, revOpA0) = clientA0.withClientOp(opA0)

      //This should produce the expected operation against revision 0, priority 0
      assert(revOpA0.contains(OpRev(opA0, 0, Rev(0))))

      //Client A optimistically assumes its operation will succeed
      assert(clientA1.local == "Hello World!".toList)

      //Client A has the right pending op
      assert(clientA1.pendingOp.contains(opA0))

      //Second client - starts up to date with server
      val clientB0 = ClientState(server = lr0, priority = 1, local = l0, pendingOp = None, buffer = None)

      //Second client edits - produces new client state and operation for server
      val opB0 = Operation[Char](List(Retain(5), Insert("o".toList)))
      val (clientB1, revOpB0) = clientB0.withClientOp(opB0)

      // Client B produces expected op, with priority 1
      assert(revOpB0.contains(OpRev(opB0, 1, Rev(0))))

      //Client B optimistically assumes its operation will succeed
      assert(clientB1.local == "Helloo".toList)

      //Server processes (note we already asserted that revOp0 is not None)
      val (server1, p0) = server0.updated(revOpB0.get)

      //Server has produced the expected op to send to clients
      assert(p0 == revOpB0.get)

      //Server has the expected list data
      assert(server1.list == "Helloo".toList)

      //Server has added the op to history
      assert(server1.history == List(revOpB0.get.toPriorityOperation))

      //Client B receives confirmation - it has no buffered op so no message for server
      val (clientB2, revOpB2) = clientB1.withServerConfirmation
      assert(revOpB2.isEmpty)

      //Client B has correct data after confirmation
      assert(clientB2.local == "Helloo".toList)

      //Client A receives client B's remote operation from server
      val clientA2 = clientA1.withServerRemoteOp(revOpB0.get.toPriorityOperation)

      //Client A updates server and local state
      assert(clientA2.local == "Helloo World!".toList)
      assert(clientA2.server == ListRev("Helloo".toList, Rev(1)))

      //Server receives client A's operation
      val (server2, p1) = server1.updated(revOpA0.get)

      //Server has transformed the expected op to send to clients
      assert(p1 != revOpA0.get)

      //Server-transformed op matches the one client A has transformed locally
      assert(clientA2.pendingOp.contains(p1.op))

      //Server has the expected list data
      assert(server2.list == "Helloo World!".toList)

      //Server has added the op to history
      assert(server2.history == List(revOpB0.get.toPriorityOperation, p1.toPriorityOperation))

      //Client A receives confirmation, no op to send
      val (clientA3, revOpA3) = clientA2.withServerConfirmation
      assert(revOpA3.isEmpty)

      //Client A has correct data after confirmation, and no pending or buffer ops
      assert(clientA3.local == "Helloo World!".toList)
      assert(clientA3.server == ListRev("Helloo World!".toList, Rev(2)))
      assert(clientA3.pendingOp.isEmpty)
      assert(clientA3.buffer.isEmpty)

      //Server sends remote op from Client A to Client B
      val clientB3 = clientB2.withServerRemoteOp(p1.toPriorityOperation)
      //Client B3 has correct data after confirmation, and no pending or buffer ops
      assert(clientB3.local == "Helloo World!".toList)
      assert(clientB3.server == ListRev("Helloo World!".toList, Rev(2)))
      assert(clientB3.pendingOp.isEmpty)
      assert(clientB3.buffer.isEmpty)
    }
  }

}
