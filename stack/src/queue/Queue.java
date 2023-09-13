package queue;

import java.util.Optional;

public abstract class Queue<T> {

	public abstract boolean enqueue(T item);

	public abstract Optional<T> dequeue();

	public abstract T peek();

	// ??

	public abstract boolean isEmpty();

	public abstract int size();

	public abstract boolean isFull();
}
