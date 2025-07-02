package queue_study2;


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

public class ArrayBasedQueue<T> implements Queue<T> {
	public static final int SIZ = 2;
	//TODO : resize 상수가 2라고 하면 SIZ와 마찬가지로 변수로 떼어놓기
	public static final int RE_SIZ = 2;

	//private int topIdx;
	private int size;
	private int front;
	private int rear;
	private T[] arr;

	//TODO : 환형까지 구현해서(SIZE가 꽉 찼을떄만 RESIZE)
	@SuppressWarnings("unchecked")
	public ArrayBasedQueue() {
		this.size = 0;
		this.front = 0;
		this.rear = 0;
		this.arr = (T[]) new Object[SIZ];
	}


	@Override
	public void enqueue(T item) {
		if (isFull())
			resize();

		arr[rear] = item;
		rear = (rear + 1) % arr.length; // 환형
		size++;
	}

	@Override
	public Optional<T> dequeue() {

		if(isEmpty()){
			return Optional.empty();
		}
		T item = arr[front];
		front = (front + 1) % arr.length; // 환형
		size--;
		return Optional.of(item);
	}

	@Override
	public Optional<T> tail() {
		if(isEmpty()){
			return Optional.empty();
		}
		T item = arr[rear-1];
		return Optional.of(item);
	}

	@Override
	public Optional<T> head() {
		if(isEmpty()){
			return Optional.empty();
		}
		T item = arr[front];
		return Optional.of(item);
	}


	private void resize() {
		int newSize = arr.length * RE_SIZ;
		//int[] newArr = new int[newSize];
		T[] newArr = (T[]) new Object[newSize];
		//System.arraycopy(arr, 0, newArr, 0, arr.length);
		System.out.println("resize 이전 : " + arr.length + ", front : " + front + ", rear : " + rear + ", size : " + size);
		for (int i = 0; i < size; i++) {
			newArr[i] = arr[(front + i) % arr.length];
		}

		arr = newArr;
		front = 0;
		rear = size; // size 만큼 뒤에 붙음
		System.out.println("resize 수행 : " + arr.length + ", front : " + front + ", rear : " + rear + ", size : " + size);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return (rear + 1) % arr.length == front;
	}
}
