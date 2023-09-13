package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

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
		// ArrayBasedQueue q = new ArrayBasedQueue();
		NotBsQueue q = new NotBsQueue();

		assert q.isEmpty();

		if (q.maxSize() > 3) {
			q.enqueue(1);
			q.enqueue(2);
			q.enqueue(3);

			assert q.size() == 3;
			assert !q.isFull();

			Integer a = q.dequeue().get();
			Integer b = q.dequeue().get();
			Integer c = q.dequeue().get();

			assert a.equals(1);
			assert b.equals(2);
			assert c.equals(3);
		}
	}

	public static void fullTest() {
		ArrayBasedQueue s = new ArrayBasedQueue();

		for (int i = 0; i < s.maxSize(); i++) {
			s.enqueue(i);
		}

		assert s.size() == s.maxSize();
		assert s.isFull();
	}

	public static void smoke() {
		final int N = 1000000;
		Queue<Integer> javaQueue = new LinkedList<>();
		ArrayBasedQueue myQueue = new ArrayBasedQueue();

		Random rd = new Random();

		for (int i = 0; i < N; i++) {
			assert javaQueue.size() == myQueue.size();

			boolean goPush = rd.nextBoolean();

			if (goPush) {
				int v = rd.nextInt();
				boolean succ = myQueue.enqueue(v);

				if (succ) {
					javaQueue.add(v);
				}
			} else {
				boolean isEmpty = javaQueue.isEmpty();
				assert isEmpty == myQueue.isEmpty();

				if (isEmpty) {
					continue;
				}

				int a = javaQueue.remove().intValue();
				int b = myQueue.dequeue().get().intValue();
				assert a == b : a + "__" + b;
			}
		}
	}
}
