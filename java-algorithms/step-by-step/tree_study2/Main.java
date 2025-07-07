package tree_study2;

import java.util.Optional;
import java.util.Random;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		simpleTest();
		System.out.println("Simple passed.");

		smoke();
		System.out.println("Smoke passed.");
	}

	public static void simpleTest() {
		TreeMap<Integer, String> javaMap = new TreeMap<>();
		LinkedListBasedMap<Integer, String> myMap = new LinkedListBasedMap<>();

		// ------- Put 테스트 -------
		Optional<String> myOld = myMap.put(2, "둘");

		String javaOld = javaMap.put(2, "둘");

		if (javaOld == null) {
			assert myOld.isEmpty();
		} else {
			assert myOld.isPresent();
			assert javaOld.equals(myOld.get());
		}

		myOld = myMap.put(1, "하나");
		javaOld = javaMap.put(1, "하나");
		assert myOld.isEmpty() && javaOld == null;

		myOld = myMap.put(3, "셋");
		javaOld = javaMap.put(3, "셋");
		assert myOld.isEmpty() && javaOld == null;

		// 같은 키로 덮어쓰기
		myOld = myMap.put(2, "둘둘");
		javaOld = javaMap.put(2, "둘둘");
		if (javaOld == null) {
			assert myOld.isEmpty();
		} else {
			assert myOld.isPresent();
			assert javaOld.equals(myOld.get());
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
			assert myRemoved.isPresent();
			assert javaRemoved.equals(myRemoved.get());
		}

		// ------- Size & containsKey -------
		assert myMap.size() == javaMap.size();
		assert myMap.containsKey(1) == javaMap.containsKey(1);
		assert myMap.containsKey(3) == javaMap.containsKey(3);
		assert myMap.containsKey(100) == javaMap.containsKey(100);

		assert myMap.size() == 2;
		assert javaMap.size() == 2;

		assert !myMap.isEmpty();
		assert !javaMap.isEmpty();
	}

	public static void smoke() {
		final int N = 10_000;

		TreeMap<Integer, Integer> javaMap = new TreeMap<>();
		LinkedListBasedMap<Integer, Integer> myMap = new LinkedListBasedMap<>();

		Random rd = new Random();

		for (int i = 0; i < N; i++) {
			assert javaMap.size() == myMap.size();

			int key = rd.nextInt(100);
			int value = rd.nextInt();

			Integer oldJavaVal = javaMap.put(key, value);
			Optional<Integer> oldMyVal = myMap.put(key, value);

			System.out.println("[PUT] key=" + key + ", value=" + value +
					", javaOld=" + oldJavaVal + ", myOld=" + oldMyVal);


			if (oldJavaVal == null) {
				assert oldMyVal.isEmpty();
			} else {
				assert oldMyVal.isPresent() && oldJavaVal.equals(oldMyVal.get());
			}

			// -------- 삭제 테스트 --------
			boolean doDelete = rd.nextInt(10) == 0; // 10% 확률로 삭제

			if (doDelete) {
				boolean javaHasKey = javaMap.containsKey(key);
				Integer removedJavaVal = javaMap.remove(key);

				Optional<Integer> removedMyVal = myMap.remove(key);

				if (removedJavaVal == null) {
					assert removedMyVal.isEmpty();
				} else {
					assert removedMyVal.isPresent() && removedJavaVal.equals(removedMyVal.get());
				}

				// 추가로 키가 있으면 값이 맞아야 함
				assert javaHasKey == removedMyVal.isPresent();
			}

			// -------- 랜덤 키 값 비교 --------
			int randomKey = rd.nextInt(1000);

			Integer javaVal = javaMap.get(randomKey);
			Optional<Integer> myVal = myMap.get(randomKey);

			if (javaVal == null) {
				assert myVal.isEmpty();
			} else {
				assert myVal.isPresent() && javaVal.equals(myVal.get());
			}



			// -------- containsKey 동기화 --------
			assert javaMap.containsKey(randomKey) == myMap.containsKey(randomKey);
		}
	}


}
