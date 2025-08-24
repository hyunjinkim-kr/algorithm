package list_study2;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		list_study2.SingleLinkedList<Integer> mySingleList = new SingleLinkedList<>();
		list_study2.DoublyLinkedList<Integer> myDoublyList = new DoublyLinkedList<>();

		simpleTest(mySingleList);
		simpleTest(myDoublyList);

		System.out.println("Simple passed.");

		insertDeleteTest(mySingleList);
		insertDeleteTest(myDoublyList);
		System.out.println("Insert/Delete passed.");

		//smoke(mySingleList);
		list_study2.DoublyLinkedList<Integer> myDoublyList2 = new DoublyLinkedList<>();
		smoke(myDoublyList2);
		System.out.println("Smoke passed.");
	}

	public static void simpleTest(list_study2.LinkedList<Integer> myList) { //<LinkedList T>
		// TODO : 링크드리스트 타입에 대한 테스트 코드를 만들어서 고치기
		//리스트가 중복인데
		// mySingleList ,myDoublyList 를 각각 넣어서 중복되는 코드가 혼재함

		myList.add(0, 10);
		myList.add(1, 20);
		myList.add(2, 30);

		assert myList.get(0).equals(10);
		assert myList.get(1).equals(20);
		assert myList.get(2).equals(30);

	}

	public static void insertDeleteTest(list_study2.LinkedList<Integer> myList) {

		myList.addLast(1);
		myList.addLast(2);
		myList.addLast(3);
		myList.addLast(4);
		myList.addLast(5);

		// 삭제 테스트
		assert myList.remove((Integer) 3);
		assert myList.remove((Integer) 1);
		assert myList.remove((Integer) 5);
		assert !myList.remove((Integer) 999);
	}

	public static void smoke(list_study2.LinkedList<Integer> myList) {
		final int N = 10;

		java.util.LinkedList<Integer> javaList = new java.util.LinkedList<>();

		Random rd = new Random();

		for (int i = 0; i < N; i++) {
			boolean insert = rd.nextBoolean();

			if (insert) {
				int v = rd.nextInt(100);
				myList.addLast(v);
				javaList.add(v);
			} else {
				if (!javaList.isEmpty()) {
					int value = javaList.removeFirst();
					myList.remove((Integer) value);
				}
			}
		}

		// 결과 비교
		System.out.println("SingleLinkedList 결과: " + myList);
		System.out.println("Java LinkedList 결과: " + javaList);

		// toString이 잘 만들어져 있으면 여기서 바로 assert 비교 가능
		assert myList.toString().equals(javaList.toString()) : "LinkedList mismatch!";
	}
}
