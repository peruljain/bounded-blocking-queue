## Implement a bounded blocking queue with the following operations:

1. enqueue(value): Add a value to the queue. If the queue is full, wait until there is space available.
2. dequeue(): Remove and return the front element from the queue. If the queue is empty, wait until there is an element available.
3. size(): Return the current size of the queue.
The goal is to design a thread-safe, bounded blocking queue that ensures proper synchronization and efficient use of resources.

Requirements:

1. The queue has a maximum capacity 'capacity' specified during initialization.
2. The enqueue operation should block if the queue is full, and it should resume when space becomes available.
3. The dequeue operation should block if the queue is empty, and it should resume when an element becomes available.
4. Ensure thread safety to prevent race conditions and maintain the integrity of the queue.