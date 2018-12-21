## Overview

Server and client both:
 1. Hold copies of the same data (client may have partial data)
 2. Have same functions to update the data (transactions).
 
The server is authoritative, it:
 1. Holds the current authoritative state of the data
 2. Sends the initial state of the data to new clients
 3. Orders transactions from all clients into a sequence, applies these to update the data state, and relays the sequence of transactions to all clients.
 
The client is optimistic, it holds:
 1. The most recently received authoritative state of the data from the server
 2. The list of transactions it wishes to commit
 3. The result of applying those transactions to the server state - this is the local state it displays

The client edits the data by producing a sequence of transactions (the transactions a client produces itself are termed local below, other client's transactions are termed remote). The process is:

 1. User requests an edit.
 2. Client produces a transaction carrying the intent of the user.
 3. Client sends the transaction to the server.
 4. Client adds the local transaction to its pending list.
 5. Client updates its optimistic local data state with the new local transaction, and displays this to the user.
 6. Server receives the transaction.
 7. Server assigns the transaction a position in the sequence of transactions from all clients.
 8. Server updates the authoritative data state with the new transaction.
 9. Server relays the transaction to all clients, including the originator.
 10. Client receives back the transaction, along with other client's (remote) transactions.
 11. Client updates the previous server data state it holds with the new transactions to produce a new server data state.
 12. Client removes the local transaction from the pending list, now it has been applied.
 13. Client produces a new optimistic data state using the new authoritative data state and any remaining pending local transactions.
 
In theory the server can reject transactions and inform clients - in practice transactions should be designed so that they can always be attempted, and will do nothing if they cannot be applied. This is why they should carry the intent of the user rather than an exact delta to the data - they should be capable of observing the actual state of the data on the server when they are executed, and if necessary adapting to this new state. For example, if a transaction edits an element in a list, that element should be referenced by some persistent identifier, rather than as an index in teh list, so that if the list has been reordered, the correct element is still edited, rather than the element that happens to be at the same index. The implementation of this is left to individual transactions at present, however in future the system may also provide support for operational transformation, by allowing deltas to see remote deltas that have been applied between their original point of application on the client, and their new point of application on the server.
Note this is NOT the same as an optimistic transaction system used for enhanced concurrency - the transactions are always applied exactly once on the server, and are not run concurrently by the server.
The optimistic aspect of the application is on the clients - they initially assume that their transactions will be applied on the server exactly as they are on the client, with no other clients' transactions interleaved.
This allows for apparently instant editing on each client. When interleaved remote transactions are received, the client state is updated to reflect this, and so data is eventually consistent on the server and client.

Transactions must be designed so that they preserve the intent of the user when reordered, including doing nothing if the original intent is no longer possible (e.g. editing a deleted item).

The system could be enhanced in future to support operational transformation - the server is responsible for sequencing transactions, and so may rewrite those transactions when sequencing them, and then relay the required transformed transaction to clients (possibly just the transformation to the originator).

For efficiency, the server can send the originating client a reference to its own local transactions, but clients require the full contents of other clients' remote transactions.

### Implementation

All data is immutable.

At the top level, we have a key-value store, where all keys are identifiers of type `Id[A]` for values of type `A`.

Instances of this store are immutable, and transactions produce new instances of the store. These are termed revisions. Each value is annotated with the last revision where it was altered, allowing us to efficiently check whether a value has changed, for example when rendering with React.

This store is essentially an STM (software transactional memory). Transactions operate on this using an algebra `STMOps`, using:
 1. put: Put a new value into the store, with an automatically produced new id.
 2. get: Get the value for an id
 2. modify: Modify the value for an id, essentially using a transformation `A => A` (actually `A=>F[A]`, more details later)

When operating on values, it's convenient to introduce a `Delta[A]` type, which is essentially just a pure function `A => A` - it transforms an old data item to a new data item.
The simplest Delta is `ValueDelta[A]`, which is essentially just `A` - a new value not based on the old one.
Deltas can be transformed neatly using a `Lens` - given a `Delta[A]` and a `Lens[A, B]` we can produce a `Delta[B]`, and similarly for other monocle types like `Optional`. This provides most of what we need to easily support editing of immutable data structures.

We can easily convert a `Delta[A]` to a transaction just by associating it with an `Id` - this produces a transaction modifying the value at that `Id` with the `Delta`.

The `STMOps` algebra is implemented in a tagless style using a Monad. This means that `Delta[A]` actually provides `A=>F[A]`, and this is accepted by `STMOps.modify`.

### Functional UI

One way to provide a user interface for editing such a data structure is to use pure functions to render it. This is the same approach used by React.
Essentially at the top level, we just provide a function that accepts a revision of the STM store and a configuration, and produces some rendering of it as a user interface.
For example we could accept the store and an `Id[A]`, and render the value at that Id to a text description. 
This would be a final tagless function like `Id[A] => F[String]`, producing a value of F that could be "run" with a revision of a store to produce a String describing the data.
On each new revision, this would be run again. The disadvantage here is that without memoization it will be inefficient - the entire value is re-rendered each time the function is called.
To improve this, we can use a different output type - rather than just `String` we could model a tree of rendered elements, where one of the types of elements is itself a suspended render function.
There is a simple example of this at 

## Ids

### STM ids.
 * Globally unique (with high probability) would be useful
 * NOT secure - may be easy to guess, having one cannot be used as permission to view it (need additional permissions layer for this)
 * Not ordered
 * Probably not great for database key
 * Colour/pattern/text hash to allow user-visible difference between items

Just use UUIDS? Need to look at generation, ideally can be repeatably generated by client, implies PRNG seeded from transaction context (so time and transaction id - additional data could be used as long as it is sent through with transaction for server to reuse). Intent here is just to avoid collision by poor seed, not to make this secure. Could check guid is unique on server side fairly easily, thus completely avoiding collisions but requiring us to send the altered guid back to client. 

### Transaction ids
 * Don't need to be globally unique, just unique to server.
 * NOT secure - very easy to guess
 * Ordered (incrementing index for clients, transaction on client)
 * Should just be an implementation detail? Used to check whether transaction is local or remote to a client.
 * Used to seed GUID generation on client? We would know we don't have this part of the seed the same between different any pair of transactions.
 * Not to be used in database ids?
