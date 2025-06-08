package stack;

public abstract class LinkedListStack<T> {
	// Abstract methods to be implemented by derived classes
	public abstract boolean push(T item);

	public abstract void pop();

	public abstract T peek();

	public abstract boolean isEmpty();

	public abstract int size();
}
