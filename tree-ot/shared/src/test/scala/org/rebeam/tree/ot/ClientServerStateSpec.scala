package org.rebeam.tree.ot

import org.rebeam.tree.ot.Atom._
import org.scalatest._
import org.scalatest.prop.Checkers

/**
  * Test ClientState and ServerState together
  */
class ClientServerStateSpec extends WordSpec with Matchers with Checkers {

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
      val clientA0 = ClientState(server = lr0, local = l0, pendingOp = None, buffer = None)

      //First client edits. We are simulating a long lag, so this doesn't make it to the
      //server yet...
      val opA0 = Operation[Char](List(Retain(5), Insert(" World!".toList)))
      val (clientA1, revOpA0) = clientA0.withClientOp(opA0)

      //This should produce the expected operation against revision 0
      assert(revOpA0.contains(OpRev(opA0, Rev(0))))

      //Client A optimistically assumes its operation will succeed
      assert(clientA1.local == "Hello World!".toList)

      //Client A has the right pending op
      assert(clientA1.pendingOp.contains(opA0))

      //Second client - starts up to date with server
      val clientB0 = ClientState(server = lr0, local = l0, pendingOp = None, buffer = None)

      //Second client edits - produces new client state and operation for server
      val opB0 = Operation[Char](List(Retain(5), Insert("o".toList)))
      val (clientB1, revOpB0) = clientB0.withClientOp(opB0)

      // Client B produces expected op
      assert(revOpB0.contains(OpRev(opB0, Rev(0))))

      //Client B optimistically assumes its operation will succeed
      assert(clientB1.local == "Helloo".toList)

      //Server processes (note we already asserted that revOp0 is not None)
      val (server1, p0) = server0.updated(revOpB0.get)

      //Server has produced the expected op to send to clients
      assert(p0 == revOpB0.get)

      //Server has the expected list data
      assert(server1.list == "Helloo".toList)

      //Server has added the op to history
      assert(server1.history == List(revOpB0.get.op))

      //Client B receives confirmation - it has no buffered op so no message for server
      val (clientB2, revOpB2) = clientB1.withServerPendingConfirmation
      assert(revOpB2.isEmpty)

      //Client B has correct data after confirmation
      assert(clientB2.local == "Helloo".toList)

      //Client A receives client B's remote operation from server
      val clientA2 = clientA1.withServerRemoteOp(revOpB0.get.op)

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
      assert(server2.history == List(revOpB0.get.op, p1.op))

      //Client A receives confirmation, no op to send
      val (clientA3, revOpA3) = clientA2.withServerPendingConfirmation
      assert(revOpA3.isEmpty)

      //Client A has correct data after confirmation, and no pending or buffer ops
      assert(clientA3.local == "Helloo World!".toList)
      assert(clientA3.server == ListRev("Helloo World!".toList, Rev(2)))
      assert(clientA3.pendingOp.isEmpty)
      assert(clientA3.buffer.isEmpty)

      //Server sends remote op from Client A to Client B
      val clientB3 = clientB2.withServerRemoteOp(p1.op)
      //Client B3 has correct data after confirmation, and no pending or buffer ops
      assert(clientB3.local == "Helloo World!".toList)
      assert(clientB3.server == ListRev("Helloo World!".toList, Rev(2)))
      assert(clientB3.pendingOp.isEmpty)
      assert(clientB3.buffer.isEmpty)
    }
  }

}
