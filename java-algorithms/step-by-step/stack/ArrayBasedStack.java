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

	private int topIdx;
	private int[] arr = new int[SIZ];

	public int maxSize() {
		return SIZ;
	}

	public ArrayBasedStack() {
		topIdx = -1;
	};

	@Override
	public boolean push(Integer item) {
		if (isFull())
			resize();
			//return false;

		topIdx++;
		arr[topIdx] = item;
		return true;
	}

	private void resize() {
		int newSize = arr.length * 2;
		int[] newArr = new int[newSize];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
		System.out.println("resize 수행 : " + arr.length + ", top : " + topIdx);
	}

	@Override
	public void pop() {
		if (!isEmpty()) {
			topIdx--;
		}
	}

	@Override
	public Integer peek() {
		if (isEmpty()) {
			throw new IllegalStateException("스택이 비어있습니다.");
		}
		return arr[topIdx];
	}

	@Override
	public int size() {
		return topIdx + 1;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

//	@Override
//	public boolean isFull() {
//		return topIdx == SIZ - 1;
//	}
	public boolean isFull() {
	return size() == arr.length;
}
}
