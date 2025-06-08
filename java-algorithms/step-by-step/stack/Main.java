package stack;

import java.util.Random;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		simpleTest();
		System.out.println("Simple passed.");

		fullTest();
		System.out.println("Full passed.");

		smoke();
		System.out.println("Smoke passed.");
	}

	public static void simpleTest() {
		ArrayBasedStack s = new ArrayBasedStack();
		LinkedListBasedStack l = new LinkedListBasedStack();

		assert s.isEmpty();

		if (s.maxSize() > 3) {
			s.push(1);
			s.push(2);
			s.push(3);
			l.push(1);
			l.push(2);
			l.push(3);

			assert s.size() == 3;
			assert l.size() == 3;
			assert !s.isFull();

			s.pop();
			s.pop();
			l.pop();
			l.pop();
			assert s.peek().equals(1);
			assert l.peek().equals(1);
		}
		System.out.println("s.peek() : " + s.peek());
		System.out.println("l.peek() : " + l.peek());
	}

	public static void fullTest() {
		ArrayBasedStack s = new ArrayBasedStack();

		for (int i = 0; i < s.maxSize(); i++) {
			s.push(i);
		}

		assert s.size() == s.maxSize();
		assert s.isFull();


		System.out.println("s.size() : " + s.size());
	}

	public static void smoke() {
		final int N = 1000000;
		Stack<Integer> javaStack = new Stack<>();
		ArrayBasedStack myStack = new ArrayBasedStack();
		ArrayBasedStack myLinkedStack = new ArrayBasedStack();

		Random rd = new Random();

		for (int i = 0; i < N; i++) {
			assert javaStack.size() == myStack.size();
			assert javaStack.size() == myLinkedStack.size();

			boolean goPush = rd.nextBoolean();

			if (goPush) {
				int v = rd.nextInt();
				javaStack.push(v);
				boolean succ = myStack.push(v);
				myLinkedStack.push(v);

				if (!succ) {
					javaStack.pop();
				}
			} else {
				boolean isEmpty = javaStack.isEmpty();
				assert isEmpty == myStack.isEmpty();
				assert isEmpty == myLinkedStack.isEmpty();

				if (isEmpty) {
					continue;
				}

				javaStack.pop();
				myStack.pop();
				myLinkedStack.pop();

//				if (!javaStack.isEmpty()) {
//					assert javaStack.peek().equals(myStack.peek());
//					System.out.println("javaStack.peek() : " + javaStack.peek());
//					System.out.println("myStack.peek() : " + myStack.peek());
//					System.out.println("myLinkedStack.peek() : " + myLinkedStack.peek());
//				}
			}
		}
	}
}
