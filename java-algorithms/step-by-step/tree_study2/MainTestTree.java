package tree_study2;

import java.util.Optional;
import java.util.Random;
import java.util.TreeMap;

public class MainTestTree {
	public static void main(String[] args) {


		BinaryTreeBasedMap<Integer, String> myMap = new BinaryTreeBasedMap<>();
		ArrayBasedBinaryTree<Integer, String> myArrTree = new ArrayBasedBinaryTree<>();
		PointerBasedBinaryTree<Integer, String> myPointerTree = new PointerBasedBinaryTree<>();

		simpleTest(myMap);
		simpleTest(myArrTree);
		simpleTest(myPointerTree);
		System.out.println("Simple passed.");

		BinaryTreeBasedMap<Integer, Integer> myMap2 = new BinaryTreeBasedMap<>();
		ArrayBasedBinaryTree<Integer, Integer> myArrTree2 = new ArrayBasedBinaryTree<>();
		PointerBasedBinaryTree<Integer, Integer> myPointerTree2 = new PointerBasedBinaryTree<>();

		smoke(myMap2);
		System.out.println("myMap : Smoke passed.");
		smoke(myPointerTree2);
		System.out.println("myPointerTree : Smoke passed.");
		smoke(myArrTree2);
		System.out.println("myArrTree : Smoke passed.");
	}

	public static void simpleTest(Map<Integer, String> myMap) {
		TreeMap<Integer, String> javaMap = new TreeMap<>();

		// ------- Put 테스트 -------
		Optional<String> myOld = myMap.put(2, "둘");
		String javaOld = javaMap.put(2, "둘");
		if (javaOld == null) {
			assert myOld.isEmpty();
		} else {
			assert myOld.isPresent() && javaOld.equals(myOld.get());
		}

		myOld = myMap.put(1, "하나");
		javaOld = javaMap.put(1, "하나");
		assert myOld.isEmpty() && javaOld == null;

		myOld = myMap.put(3, "셋");
		javaOld = javaMap.put(3, "셋");
		assert myOld.isEmpty() && javaOld == null;

		// 덮어쓰기
		myOld = myMap.put(2, "둘둘");
		javaOld = javaMap.put(2, "둘둘");
		if (javaOld == null) {
			assert myOld.isEmpty();
		} else {
			assert myOld.isPresent() && javaOld.equals(myOld.get());
		}

		// ------- Get 테스트 -------
		Optional<String> myVal = myMap.get(2);
		String javaVal = javaMap.get(2);
		if (javaVal == null) {
			assert myVal.isEmpty();
		} else {
			assert myVal.isPresent() && javaVal.equals(myVal.get());
		}

		myVal = myMap.get(100);
		javaVal = javaMap.get(100);
		if (javaVal == null) {
			assert myVal.isEmpty();
		} else {
			assert myVal.isPresent() && javaVal.equals(myVal.get());
		}

		// ------- Remove 테스트 -------
		Optional<String> myRemoved = myMap.remove(3);
		String javaRemoved = javaMap.remove(3);

		if (javaRemoved == null) {
			assert myRemoved.isEmpty();
		} else {
			assert myRemoved.isPresent() && javaRemoved.equals(myRemoved.get());
		}

		// ------- Size & containsKey -------
		assert myMap.size() == javaMap.size();
		assert myMap.containsKey(1) == javaMap.containsKey(1);
		assert myMap.containsKey(3) == javaMap.containsKey(3);
		assert myMap.containsKey(100) == javaMap.containsKey(100);
	}


	public static void smoke(Map<Integer, Integer> myMap) {
		final int N = 10_000;

		TreeMap<Integer, Integer> javaMap = new TreeMap<>();

		Random rd = new Random();

		for (int i = 0; i < N; i++) {
			assert javaMap.size() == myMap.size();

			int key = rd.nextInt(100);
			int value = rd.nextInt();

			Integer oldJavaVal = javaMap.put(key, value);
			Optional<Integer> oldMyVal = myMap.put(key, value);

			//System.out.println("[PUT] key=" + key + ", value=" + value +
			//		", javaOld=" + oldJavaVal + ", myOld=" + oldMyVal);


			if (oldJavaVal == null) {
				assert oldMyVal.isEmpty();
			} else {
				assert oldMyVal.isPresent() && oldJavaVal.equals(oldMyVal.get());
			}
			// -------- 삭제 테스트 --------
			boolean doDelete = rd.nextInt(10) == 0;

			if (doDelete) {
				boolean javaHasKey = javaMap.containsKey(key);
				Integer javaRemoved = javaMap.remove(key);

				Optional<Integer> myRemoved = myMap.remove(key);

				if (javaRemoved == null) {
					assert myRemoved.isEmpty();
				} else {
					assert myRemoved.isPresent() && javaRemoved.equals(myRemoved.get());
				}

				assert javaHasKey == myRemoved.isPresent();
			}

			// -------- 랜덤 키 비교 --------
			int randomKey = rd.nextInt(1000);

			Integer javaVal = javaMap.get(randomKey);
			Optional<Integer> myVal = myMap.get(randomKey);

			if (javaVal == null) {
				assert myVal.isEmpty();
			} else {
				assert myVal.isPresent() && javaVal.equals(myVal.get());
			}

			assert javaMap.containsKey(randomKey) == myMap.containsKey(randomKey);
		}
	}

}
