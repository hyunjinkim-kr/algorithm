package queue_study2;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		simpleTest();// TODO : 링크드리스트 타입에 대한 테스트 코드를 만들어서 고치기
		System.out.println("Simple passed.");

		smoke();
		System.out.println("Smoke passed.");
	}

	public static void simpleTest() {
		Queue<Integer> javaQueue = new LinkedList<>();
		LinkedListBasedQueue<Integer> linkedQueue = new LinkedListBasedQueue<>();
		ArrayBasedQueue<Integer> arrayQueue = new ArrayBasedQueue<>();

		javaQueue.offer(1);
		javaQueue.offer(2);
		javaQueue.offer(3);

		linkedQueue.enqueue(1);
		linkedQueue.enqueue(2);
		linkedQueue.enqueue(3);

		arrayQueue.enqueue(1);
		arrayQueue.enqueue(2);
		arrayQueue.enqueue(3);

		assert javaQueue.size() == linkedQueue.size();
		assert javaQueue.size() == arrayQueue.size();

		javaQueue.poll();
		javaQueue.poll();

		linkedQueue.dequeue();
		linkedQueue.dequeue();

		arrayQueue.dequeue();
		arrayQueue.dequeue();

		assert javaQueue.peek().equals(linkedQueue.head().get());
		assert javaQueue.peek().equals(arrayQueue.head().get());

		System.out.println("javaQueue.peek()     : " + javaQueue.peek());
		System.out.println("linkedQueue.head()   : " + linkedQueue.head().get());
		System.out.println("arrayQueue.head()    : " + arrayQueue.head().get());
	}

	public static void smoke() {
		final int N = 100_000;
		Queue<Integer> javaQueue = new LinkedList<>();
		LinkedListBasedQueue<Integer> linkedQueue = new LinkedListBasedQueue<>();
		ArrayBasedQueue<Integer> arrayQueue = new ArrayBasedQueue<>();

		Random rd = new Random();

		for (int i = 0; i < N; i++) {
			assert javaQueue.size() == linkedQueue.size();
			assert javaQueue.size() == arrayQueue.size();

			boolean goEnqueue = rd.nextBoolean();

			if (goEnqueue) {
				int v = rd.nextInt();
				javaQueue.offer(v);
				linkedQueue.enqueue(v);
				arrayQueue.enqueue(v);
			} else {
				boolean isEmpty = javaQueue.isEmpty();
				assert isEmpty == linkedQueue.isEmpty();
				assert isEmpty == arrayQueue.isEmpty();

				if (isEmpty) continue;

				Integer javaHead = javaQueue.peek();
				Optional<Integer> linkedHead = linkedQueue.head();
				Optional<Integer> arrayHead = arrayQueue.head();

				assert javaHead.equals(linkedHead.get());
				assert javaHead.equals(arrayHead.get());

				javaQueue.poll();
				linkedQueue.dequeue();
				arrayQueue.dequeue();
			}
		}
	}
}
