package org.rebeam.tree.ot

import cats.data.State
import cats.implicits._
import org.rebeam.tree.ot.Atom.{Delete, Insert, Retain}
import org.rebeam.tree.ot.NetworkModel.ClientOps.{edit, send}
import org.rebeam.tree.ot.NetworkModel.{Network, NetworkOps, NetworkState}
import org.scalacheck.Gen
import org.scalacheck.Gen.{choose, containerOfN}

object OTGen {

  implicit def genRetain[A]: Gen[Retain[A]] =
    Gen.choose(1, 10).map(Retain[A])

  implicit def genDelete[A]: Gen[Delete[A]] =
    Gen.choose(1, 10).map(Delete[A])

  implicit def genInsert[A: Gen]: Gen[Insert[A]] =
    Gen.choose(1, 10).flatMap(
      n => containerOfN[List, A](n, implicitly[Gen[A]])
    ).map(l => Insert(l))

  implicit def genAtom[A: Gen]: Gen[Atom[A]] =
    Gen.oneOf[Atom[A]](genRetain[A], genDelete[A], genInsert[A])

  implicit def genInsertOrDelete[A: Gen]: Gen[Atom[A]] =
    Gen.oneOf[Atom[A]](genDelete[A], genInsert[A])

  implicit val genInt: Gen[Int] = choose(0, Integer.MAX_VALUE)

  implicit val genChar: Gen[Char] = Gen.alphaNumChar

  case class AtomsAndInput[A](atoms: List[Atom[A]], input: List[A])

  // Generate a list of atoms, and a list with the correct length to be an
  // input for an operation on those atoms.
  // We produce a list of atoms so we can test building an operation with
  // those atoms against the atoms themselves
  implicit def genAtomListAndInput[A: Gen]: Gen[AtomsAndInput[A]] = for {
    n <- Gen.choose(1, 100)
    atoms <- containerOfN[List, Atom[A]](n, genAtom[A])
    inputSize = atoms.foldLeft(0){case (sum, atom) => sum + atom.inputLengthDelta}
    elements <- containerOfN[List, A](inputSize, implicitly[Gen[A]])
  } yield AtomsAndInput(atoms, elements)

  case class AtomAndPosition[A](atom: Atom[A], pos: Int)

  implicit def genInsertOrDeleteAndPosition[A: Gen]: Gen[AtomAndPosition[A]] = for {
    atom <- genInsertOrDelete
    pos <- genInt
  } yield AtomAndPosition(atom, pos)

  // Generate an operation on an input length n. This is formed by starting with a retain
  // of all elements, and then folding in from 1 to n/2 + 1 insert or delete operations
  // at random positions.
  private def genOperationN[A: Gen](n: Int, priority: Int): Gen[Operation[A]] = genPotentialOperationN[A](n/2 + 1, priority).map(po => po.operation(n))

  // A pair of operations and an input, where we can apply either operation to the input
  case class OperationPairAndInput[A](a: Operation[A], b: Operation[A], input: List[A])

  implicit def genOperationPairAndInput[A: Gen]: Gen[OperationPairAndInput[A]] = for {
    n <- Gen.choose(1, 100)
    input <- containerOfN[List, A](n, implicitly[Gen[A]])
    a <- genOperationN(n)
    b <- genOperationN(n)
  } yield OperationPairAndInput(a, b, input)


  // A pair of operations and an input, where we can apply a then b to the input
  case class OperationComposePairAndInput[A](a: Operation[A], b: Operation[A], input: List[A])

  implicit def genOperationComposePairAndInput[A: Gen]: Gen[OperationComposePairAndInput[A]] = for {
    n <- Gen.choose(1, 100)
    input <- containerOfN[List, A](n, implicitly[Gen[A]])
    a <- genOperationN(n)
    b <- genOperationN(a.outputSize)
  } yield OperationComposePairAndInput(a, b, input)

  /**
    * Represents a potential operation, having a list of atoms and positions that can be used to generate
    * an operation on a list of a length given later.
    * @param atomsAndPositions  The atoms (inserts and deletes) and positions (these are non-negative ints to be
    *                           used modulo the length of the list the atoms are applied to).
    * @tparam A                 The type of element
    */
  case class PotentialOperation[A](atomsAndPositions: List[AtomAndPosition[A]], priority: Int) {
    /**
      * Generate an operation to be applied to a list of length n
      * @param n  The length of input list of the operation
      * @return   An operation based on atoms and positions. Note this is always the same for a given value of n
      */
    def operation(n: Int): Operation[A] = atomsAndPositions.foldLeft(OperationBuilder[A].retainIfPositive(n).build(priority)) {
      case (op, atomAndPos) =>
        // We will compose a new operation with current one (op), we want
        // to perform the operation we have at a valid position in the
        // output of the current operation
        atomAndPos.atom match {
          case Insert(l) =>
            // Insert can happen from 0 to length of input, inclusive (at pos = length, we are appending to end)
            val pos = atomAndPos.pos % (op.outputSize + 1)
            // We can have retain of 0 elements in either call - so use retainIfPositive
            val newOp = OperationBuilder[A].retainIfPositive(pos).insert(l).retainIfPositive(op.outputSize - pos).build(priority)
            op.compose(newOp)

          case Delete(d) if op.outputSize > 0 =>
            // Delete can happen from 0 to length of input - 1, inclusive (i.e. we need at least one input
            // element left to delete) - we will truncate delete length as necessary
            val pos = atomAndPos.pos % op.outputSize
            // Can only delete what is left
            val d2 = Math.min(d, op.outputSize - pos)
            // We can have retain of 0 elements in either call - so use retainIfPositive
            val newOp = OperationBuilder[A].retainIfPositive(pos).delete(d2).retainIfPositive(op.outputSize - pos - d2).build(priority)
            op.compose(newOp)

          // We don't generate retains, so just ignore
          case _ => op
        }
    }
  }

  // Generate a potential operation with between 1 and n operations, each a random insert or delete.
  private def genPotentialOperationN[A: Gen](n: Int, priority: Int): Gen[PotentialOperation[A]] = for {
    // Choose a number of inserts and deletes
    atomCount <- Gen.choose(1, n)

    // Now generate the atoms and positions - note we will wrap the position to lie in the
    // input at each stage
    atomsAndPositions <- containerOfN[List, AtomAndPosition[A]](atomCount, genInsertOrDeleteAndPosition)

    // Start from an operation just retaining everything (note we may have an empty input, so retainIfPositive)
  } yield PotentialOperation(atomsAndPositions, priority)

  /**
    * Network state to perform a client operation, and queue any resulting message for the server
    * @param i  The index of the client
    * @param po The potential operation to perform on the client
    * @return   NetworkState for the action, returning any resulting OpRev (which has already been queued for the server)
    */
  private def editAndSendPotential(i: Int, po: PotentialOperation[Char]): NetworkState[Option[OpRev[Char]]] = for {
    n <- State.get[Network]
    opRev <- edit(i, po.operation(n.clients(i).state.local.size))
    _ <- send(i, opRev)
  } yield opRev

  private def genNetworkStateEdit(clients: Int, maxAtomCount: Int): Gen[NetworkState[Unit]] = for {
    // Choose a number of inserts and deletes up to maxAtomCount and a client index
    atomCount <- Gen.choose(1, maxAtomCount)
    clientIndex <- Gen.choose(0, clients - 1)

    // Generate atoms an positions for our potential edit
    atomsAndPositions <- containerOfN[List, AtomAndPosition[Char]](atomCount, genInsertOrDeleteAndPosition[Char])

  } yield {
//    println(s"edit $clientIndex, $atomCount atoms")
    val po = PotentialOperation(atomsAndPositions)
    editAndSendPotential(clientIndex, po).map(_ => ())
  }

  private def genNetworkStatePurge(clients: Int): Gen[NetworkState[Unit]] = for {
    clientIndex <- Gen.choose(0, clients - 1)
    fromServerFirst <- Gen.oneOf(true, false)
  } yield {
//    println(s"purge $clientIndex, ${ if (fromServerFirst) "S" else "C" }")
    NetworkOps.purgeFrom(clientIndex, fromServerFirst).map(_ => ())
  }

  /**
    * Generate a single network state, choosing randomly from purge and edit.
    * Weight purge to occur (clients + 1) times per edit, as required on average for
    * network to keep up to date (each edit produces one message from client to server,
    * and a message back from the server to each client). Since the purges start from random
    * clients and occur at random points we should still simulate a range of "latencies"
    * @param clients    Number of clients
    * @param maxAtomCount The maximum number of insert/delete atoms in each edit
    * @return NetworkState implementing edit sequence
    */
  private def genNetworkState(clients: Int, maxAtomCount: Int): Gen[NetworkState[Unit]] = Gen.frequency(
    clients + 1 -> genNetworkStatePurge(clients),
    1 -> genNetworkStateEdit(clients, maxAtomCount)
  )

  /**
    * Generate a sequence of edits and purges on a Network, as a NetworkState, followed by a purge
    * of all messages to complete.
    * @param clients      The number of clients in the network
    * @param operations   The average number of edits to make - this will vary since we produce
    *                     a random sequence of edits and purges
    * @param maxAtomCount The maximum number of inser/delete atoms in each edit
    * @return NetworkState implementing edit sequence
    */
  def genNetworkStateSequence(clients: Int, operations: Int, maxAtomCount: Int): Gen[NetworkState[Unit]] = for {
    states <- containerOfN[List, NetworkState[Unit]](operations * (clients + 2), genNetworkState(clients, maxAtomCount))
  } yield {
//    println("Number of operations " + states.size)
    states.reduce[NetworkState[Unit]]{case (a, b) => a >> b} >> NetworkOps.purgeAllMessages
  }

}
