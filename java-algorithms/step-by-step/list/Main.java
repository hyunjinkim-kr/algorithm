package list;

import java.util.LinkedList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		simpleTest();
		System.out.println("Simple passed.");

		insertDeleteTest();
		System.out.println("Insert/Delete passed.");

		smoke();
		System.out.println("Smoke passed.");
	}

	public static void simpleTest() {
		list.SingleLinkedList<Integer> mySingleList = new SingleLinkedList<>();
		list.DoublyLinkedList<Integer> myDoublyList = new DoublyLinkedList<>();

		// 단일 연결 리스트 테스트
		mySingleList.add(0, 10);
		mySingleList.add(1, 20);
		mySingleList.add(2, 30);

		assert mySingleList.get(0).equals(10);
		assert mySingleList.get(1).equals(20);
		assert mySingleList.get(2).equals(30);

		// 이중 연결 리스트 테스트
		myDoublyList.add(0, 10);
		myDoublyList.add(1, 20);
		myDoublyList.add(2, 30);

		assert myDoublyList.get(0).equals(10);
		assert myDoublyList.get(1).equals(20);
		assert myDoublyList.get(2).equals(30);
	}

	public static void insertDeleteTest() {
		list.LinkedList<Integer> mySingleList = new SingleLinkedList<>();
		list.LinkedList<Integer> myDoublyList = new DoublyLinkedList<>();

		// 단일 연결 리스트 삽입
		mySingleList.addLast(1);
		mySingleList.addLast(2);
		mySingleList.addLast(3);
		mySingleList.addLast(4);
		mySingleList.addLast(5);

		// 삭제 테스트
		assert mySingleList.remove((Integer) 3);
		assert mySingleList.remove((Integer) 1);
		assert mySingleList.remove((Integer) 5);
		assert !mySingleList.remove((Integer) 999);

		// 이중 연결 리스트 삽입
		myDoublyList.addLast(1);
		myDoublyList.addLast(2);
		myDoublyList.addLast(3);
		myDoublyList.addLast(4);
		myDoublyList.addLast(5);

		// 삭제 테스트
		assert myDoublyList.remove((Integer) 3);
		assert myDoublyList.remove((Integer) 1);
		assert myDoublyList.remove((Integer) 5);
		assert !myDoublyList.remove((Integer) 999);
	}

	public static void smoke() {
		final int N = 10;

		java.util.LinkedList<Integer> javaList = new java.util.LinkedList<>();
		list.LinkedList<Integer> mySingleList = new SingleLinkedList<>();
		list.LinkedList<Integer> myDoublyList = new DoublyLinkedList<>();

		Random rd = new Random();

		for (int i = 0; i < N; i++) {
			boolean insert = rd.nextBoolean();

			if (insert) {
				int v = rd.nextInt(100);
				mySingleList.addLast(v);
				myDoublyList.addLast(v);
				javaList.add(v);
			} else {
				if (!javaList.isEmpty()) {
					int value = javaList.removeFirst();
					mySingleList.remove((Integer) value);
					myDoublyList.remove((Integer) value);
				}
			}
		}

		// 결과 비교
		System.out.println("SingleLinkedList 결과: " + mySingleList);
		System.out.println("DoublyLinkedList 결과: " + myDoublyList);
		System.out.println("Java LinkedList 결과: " + javaList);

		// toString이 잘 만들어져 있으면 여기서 바로 assert 비교 가능
		assert mySingleList.toString().equals(javaList.toString()) : "SingleLinkedList mismatch!";
		assert myDoublyList.toString().equals(javaList.toString()) : "DoublyLinkedList mismatch!";
	}
}
