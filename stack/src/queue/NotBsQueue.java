package queue;

import java.util.Optional;

public class NotBsQueue extends Queue<Integer> {

//	숙제. 복잡도가 N이 아닌, O(1)인 큐 구현.
	public static final int SIZ = 500;
	private int tail;
	private int head;
	private int[] backBone = new int[SIZ];

	public NotBsQueue() {
		head = 0;
		tail = 0;
	};

	public int maxSize() {
		return SIZ;
	}

	@Override
	public boolean enqueue(Integer item) {

		if (isFull()) {
			return false;
		}
		backBone[tail % SIZ] = item;
		tail++;

		return true;
	}

	@Override
	public Optional<Integer> dequeue() {
		if (isEmpty()) {
			return Optional.empty();
		}

		int dequeueVal = backBone[head % SIZ];
		head++;

		return Optional.of(dequeueVal);
	}

	@Override
	public Integer peek() {
		return backBone[head % SIZ];
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return Math.abs(head % SIZ - tail % SIZ);
	}

	@Override
	public boolean isFull() {
		return size() == SIZ;
	}
}
