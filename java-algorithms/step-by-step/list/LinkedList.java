package list;

public abstract class LinkedList<E> {

	// 삽입 메소드 (인덱스 기반)
	public abstract void addFirst(E value);
	public abstract void addLast(E value);
	public abstract void add(int index, E value);
	public abstract boolean add(E value); // addLast와 동일하게 동작할 수 있음

	// 조회 메소드
	public abstract E get(int index);

	// 수정 메소드
	public abstract void set(int index, E value);

	// 삭제 메소드
	public abstract E remove();
	public abstract E removeFirst();
	public abstract E remove(int index);
	public abstract boolean remove(Object value);
	public abstract E removeLast();

	// 출력용 toString
	@Override
	public abstract String toString();
}
