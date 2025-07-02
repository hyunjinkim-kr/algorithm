package stack;

import java.util.Optional;

interface LinkedListStack<T> {
	// Abstract methods to be implemented by derived classes
	boolean push(T item);

	Optional<T> pop();

	T peek();

	boolean isEmpty();

	int size();
}
