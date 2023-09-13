package stack;

import java.util.Optional;

//다항 시간 (polynomial)
//O(1): "빅오원" "컨스탄트 타임" "상수시간에 된다"
//O(log n): "빅오로그엔" "로그시간에 된다"
//O(n): "빅오엔" "리니어 타임"
//O(n^2): "빅오엔제곱" "스퀘어 타임"
//O(n log n)

//지수 시간 (exponential)
//O(n!)
//O(2^n)

public class ArrayBasedStack extends Stack<Integer> {
	public static final int SIZ = 500;

	private int top;
	private int[] backBone = new int[SIZ];

	public int maxSize() {
		return SIZ;
	}

	public ArrayBasedStack() {
		top = 0;
	};

	@Override
	public boolean push(Integer item) {
		if (isFull())
			return false;

		backBone[top] = item;
		top++;
		return true;
	}

	@Override
	public Optional<Integer> pop() {
		if (isEmpty()) {
			return Optional.empty();
		}

		top--;
		return Optional.of(backBone[top]);
	}

	@Override
	public Integer peek() {
		return backBone[top];
	}

	@Override
	public int size() {
		return top;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean isFull() {
		return top == SIZ;
	}
}
