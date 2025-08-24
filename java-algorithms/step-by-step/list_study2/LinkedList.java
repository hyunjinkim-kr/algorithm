package list_study2;

public interface LinkedList<T> {

	// 삽입 메소드 (인덱스 기반)
	void addFirst(T value);
	void addLast(T value);
	void add(int index, T value);
	boolean add(T value); // addLast와 동일하게 동작할 수 있음

	// 조회 메소드
	T get(int index);

	// 수정 메소드
	void set(int index, T value);

	// 삭제 메소드
	T remove();
	T removeFirst();
	T remove(int index);
	boolean remove(Object value); //TODO : 아이템 삭제가 목표였으면 제네릭으로 했어야함 T value
	// 자바 유틸 구현과 동일.
	//list.remove(Integer.valueOf(3));
	//list.remove((Object) 3);
	T removeLast();

	// 출력용 toString
	@Override
	String toString();
}
