package stack;

import java.util.Optional;

public abstract class Stack<T> {
	// Abstract methods to be implemented by derived classes
	public abstract boolean push(T item);

	public abstract Optional<T> pop();

	public abstract T peek();

	public abstract boolean isEmpty();

	public abstract int size();

	public abstract boolean isFull();
}
