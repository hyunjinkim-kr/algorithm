package stack;

import java.util.Random;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		// TODO : 링크드리스트 타입에 대한 테스트 코드를 만들어서 고치기
		simpleTest();
		System.out.println("Simple passed.");

		smoke();
		System.out.println("Smoke passed.");
	}

	public static void simpleTest() {
		Stack<Integer> javaStack = new Stack<>();
		LinkedListBasedStack<Integer> linkedListBasedStack = new LinkedListBasedStack();
		ArrayBasedStack<Integer> arrayBasedStack = new ArrayBasedStack();

		javaStack.push(1);
		javaStack.push(2);
		javaStack.push(3);
		linkedListBasedStack.push(1);
		linkedListBasedStack.push(2);
		linkedListBasedStack.push(3);
		arrayBasedStack.push(1);
		arrayBasedStack.push(2);
		arrayBasedStack.push(3);

		assert javaStack.size() == 3;
		assert linkedListBasedStack.size() == 3;
		assert arrayBasedStack.size() == 3;

		javaStack.pop();
		javaStack.pop();
		linkedListBasedStack.pop();
		linkedListBasedStack.pop();
		arrayBasedStack.pop();
		arrayBasedStack.pop();


		assert javaStack.peek().equals(1);
		assert linkedListBasedStack.peek().equals(1);
		assert arrayBasedStack.peek().equals(1);

		System.out.println("javaStack.peek() : " + javaStack.peek());
		System.out.println("linkedListBasedStack.peek() : " + linkedListBasedStack.peek());
		System.out.println("arrayBasedStack.peek() : " + arrayBasedStack.peek());
	}

	public static void smoke() {
		final int N = 1000000;
		Stack<Integer> javaStack = new Stack<>();
		LinkedListBasedStack<Integer> linkedListBasedStack = new LinkedListBasedStack();

		Random rd = new Random();

		for (int i = 0; i < N; i++) {
			assert javaStack.size() == linkedListBasedStack.size();

			boolean goPush = rd.nextBoolean();

			if (goPush) {
				int v = rd.nextInt();
				javaStack.push(v);
				linkedListBasedStack.push(v);
			} else {
				boolean isEmpty = javaStack.isEmpty();
				assert isEmpty == linkedListBasedStack.isEmpty();

				if (isEmpty) continue;
				assert javaStack.peek().equals(linkedListBasedStack.peek());

				javaStack.pop();
				linkedListBasedStack.pop();
			}
		}
	}
}
