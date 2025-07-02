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

public class ArrayBasedStack<T> implements Stack<T> {
	public static final int SIZ = 500;
	//TODO : resize 상수가 2라고 하면 SIZ와 마찬가지로 변수로 떼어놓기
	public static final int RE_SIZ = 2;

	private int topIdx;
	//private int[] arr = new int[SIZ];
	private T[] arr;

	//	public int maxSize() {
	//		return arr.length;
	//	}//TODO : resize가 있는데 왜 고정된 크기를. -> 삭제처리

	//	public ArrayBasedStack() {
	//		topIdx = -1;
	//	};
	@SuppressWarnings("unchecked")
	public ArrayBasedStack() {
		this.topIdx = -1;
		this.arr = (T[]) new Object[SIZ];
	}

	@Override
	public boolean push(T item) {
		if (isFull())
			resize();
			//return false;

		topIdx++;
		arr[topIdx] = item;
		return true;
	}

	private void resize() {
		int newSize = arr.length * RE_SIZ;
		//int[] newArr = new int[newSize];
		T[] newArr = (T[]) new Object[newSize];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
		System.out.println("resize 수행 : " + arr.length + ", top : " + topIdx);
	}

	@Override
	public Optional<T> pop() {
		// TODO : 실제로 POP이 적용되었는지 알 방법이 없음
		//  ++ empty일때 처리 추가 optional로 하던가..
		if (isEmpty()) {
			return Optional.empty();
		}
		T item = arr[topIdx];
		topIdx--;
		return Optional.of(item);
	}

	@Override
	public T peek() {
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
