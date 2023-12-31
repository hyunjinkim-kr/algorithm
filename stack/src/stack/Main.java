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

		assert s.isEmpty();

		if (s.maxSize() > 3) {
			s.push(1);
			s.push(2);
			s.push(3);

			assert s.size() == 3;
			assert !s.isFull();

			Integer a = s.pop().get();
			Integer b = s.pop().get();
			Integer c = s.pop().get();

			assert a.equals(3);
			assert b.equals(2);
			assert c.equals(1);
		}
	}

	public static void fullTest() {
		ArrayBasedStack s = new ArrayBasedStack();

		for (int i = 0; i < s.maxSize(); i++) {
			s.push(i);
		}

		assert s.size() == s.maxSize();
		assert s.isFull();
	}

	public static void smoke() {
		final int N = 1000000;
		Stack<Integer> javaStack = new Stack<>();
		ArrayBasedStack myStack = new ArrayBasedStack();

		Random rd = new Random();

		for (int i = 0; i < N; i++) {
			assert javaStack.size() == myStack.size();

			boolean goPush = rd.nextBoolean();

			if (goPush) {
				int v = rd.nextInt();
				javaStack.push(v);
				boolean succ = myStack.push(v);

				if (!succ) {
					javaStack.pop();
				}
			} else {
				boolean isEmpty = javaStack.isEmpty();
				assert isEmpty == myStack.isEmpty();

				if (isEmpty) {
					continue;
				}

				assert javaStack.pop().intValue() == myStack.pop().get().intValue();
			}
		}
	}
}
