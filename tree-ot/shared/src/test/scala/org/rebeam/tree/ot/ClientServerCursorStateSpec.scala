package org.rebeam.tree.ot

import cats.data.State
import org.rebeam.tree.ot.NetworkModel._
import org.scalatest._
import org.scalatest.prop.Checkers

/**
  * Test ClientState and ServerState together
  */
class ClientServerCursorStateSpec extends WordSpec with Matchers with Checkers {

  "CursorState" should {

    "update cursor during multi-client concurrent edits" in {
      //Initial data state
      val l0 = "Hello".toList

      //Initial network state
      val n0 = Network(l0, 2)

      //Make some edits, leaving some network traffic in both directions on each client
      val test = for {

        // Client 1 moves cursor after "Hel"
        _ <- CursorOps.moveCursor(1, 3)

        // Client 0 inserts some text
        _ <- CursorOps.insertAndSend(0, "First ")

        // Server handles insertion, client 0 receives confirmation
        _ <- ServerOps.receiveAndReply(0)
        _ <- ClientOps.receiveAndReply(0)

        // Client 1 inserts "p " - it is not yet aware of the Client 0 insertion, but this will be resolved by server
        _ <- CursorOps.insertAndSend(1, "p ")

        // Get the network state to check later - "First Hello"
        n1 <- State.get

        // Get clients up to date and get state - "First Help lo"
        _ <- NetworkOps.purgeAllMessages
        n2 <- State.get

        // Client 1 should still be after the "p " it has inserted, so move and make another insertion
        _ <- CursorOps.moveCursor(1, 2)
        _ <- CursorOps.insertAndSend(1, "cation")

        // Get clients up to date and get state - "First Help Location"
        _ <- NetworkOps.purgeAllMessages
        n3 <- State.get

        // Now we'll use Client 1 to delete the "First " prefix, which should move Client 1's cursor back to the start
        _ <- CursorOps.moveCursor(1, -100) //Note the cursor position is limited to min 0
        _ <- CursorOps.deleteAndSend(1, 6)

        // Get clients up to date and get state - "Help location"
        _ <- NetworkOps.purgeAllMessages
        n4 <- State.get

        // Client 1 can now insert something else - note this will move client 1's cursor along, but NOT client 0's
        _ <- CursorOps.insertAndSend(1, "Second ")

        // Get clients up to date and get state
        _ <- NetworkOps.purgeAllMessages

        // Final state - "Second Help location"
        n5 <- State.get

      } yield (n1, n2, n3, n4, n5)

      // Run the test and get our final network state
      val (n1, n2, n3, n4, n5) = test.run(n0).value._2

      //Check the states are as expected
      assert(n1.server.list == "First Hello".toList)
      assert(n1.clients(0).cursorState.cursorIndex == 6)    // "First _Hello"
      assert(n1.clients(1).cursorState.cursorIndex == 5)    // "Help _lo"

      assert(n2.server.list == "First Help lo".toList)
      assert(n2.clients(0).cursorState.cursorIndex == 6)    // "First _Help lo"
      assert(n2.clients(1).cursorState.cursorIndex == 11)   // "First Help _lo"

      assert(n3.server.list == "First Help location".toList)
      assert(n3.clients(0).cursorState.cursorIndex == 6)    // "First _Help location"
      assert(n3.clients(1).cursorState.cursorIndex == 19)   // "First Help location_"

      assert(n4.server.list == "Help location".toList)
      assert(n4.clients(0).cursorState.cursorIndex == 0)    // "_Help location"
      assert(n4.clients(1).cursorState.cursorIndex == 0)   // "_Help location"

      assert(n5.server.list == "Second Help location".toList)
      assert(n5.clients(0).cursorState.cursorIndex == 0)    // "_Second Help location"
      assert(n5.clients(1).cursorState.cursorIndex == 7)   // "Second _Help location"

      assert(n5.clients(0).state.local == "Second Help location".toList)
      assert(n5.clients(1).state.local == "Second Help location".toList)

    }
  }
}
