package queue;

import java.util.Optional;

public class ArrayBasedQueue extends Queue<Integer> {
	public static final int SIZ = 500;
	private int head;
	private int[] backBone = new int[SIZ];

	public ArrayBasedQueue() {
		head = 0;
	};

	public int maxSize() {
		return SIZ;
	}

	@Override
	public boolean enqueue(Integer item) {

		if (isFull()) {
			return false;
		}

		for (int i = head - 1; i >= 0; i--) {
			backBone[i + 1] = backBone[i];
		}
		backBone[0] = item;
		head++;
		return true;
	}

	@Override
	public Optional<Integer> dequeue() {
		if (isEmpty()) {
			return Optional.empty();
		}

		head--;
		return Optional.of(backBone[head]);
	}

	@Override
	public Integer peek() {
		return backBone[head];
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return head;
	}

	@Override
	public boolean isFull() {
		return head == SIZ;
	}

}
