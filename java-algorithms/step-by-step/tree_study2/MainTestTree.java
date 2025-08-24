package tree_study2;

import java.util.Optional;

public class MainTestTree {
	public static void main(String[] args) {
		BinaryTree<Integer> myArrTree = new ArrayBasedBinaryTree<>();
		BinaryTree<Integer> myPointerTree = new PointerBasedBinaryTree<>();

		simpleTreeTest(myArrTree, myPointerTree);

		System.out.println("테스트 통과");
	}

	public static void simpleTreeTest(BinaryTree<Integer> myArrTree, BinaryTree<Integer> myPointerTree) {
		int[] values = {5, 2, 8, 1, 7};

		for (int v : values) {
			myArrTree.insert(v);
			myPointerTree.insert(v);
		}

		// 루트 비교
		Optional<Integer> root1 = myArrTree.getRoot();
		Optional<Integer> root2 = myPointerTree.getRoot();
		System.out.println("Root: arr=" + root1 + ", pointer=" + root2);
		assert root1.equals(root2);

		// 전체 값 비교
		for (int i = 1; i <= values.length; i++) {
			Optional<Integer> v1 = myArrTree.get(i);
			Optional<Integer> v2 = myPointerTree.get(i);
			System.out.println("Index " + i + ": arr=" + v1 + ", pointer=" + v2);
			assert v1.equals(v2);
		}

		// swap(1, 2)
		myArrTree.swap(1, 2);
		myPointerTree.swap(1, 2);

		System.out.println("Swap 후 Index 1: arr=" + myArrTree.get(1) + ", pointer=" + myPointerTree.get(1));
		System.out.println("Swap 후 Index 2: arr=" + myArrTree.get(2) + ", pointer=" + myPointerTree.get(2));
		assert myArrTree.get(1).equals(myPointerTree.get(1));
		assert myArrTree.get(2).equals(myPointerTree.get(2));

		// removeLast
		Optional<Integer> removed1 = myArrTree.removeLast();
		Optional<Integer> removed2 = myPointerTree.removeLast();
		System.out.println("RemoveLast: arr=" + removed1 + ", pointer=" + removed2);
		assert removed1.equals(removed2);

		// size 비교
		System.out.println("Size: arr=" + myArrTree.size() + ", pointer=" + myPointerTree.size());
		assert myArrTree.size() == myPointerTree.size();
	}
}
