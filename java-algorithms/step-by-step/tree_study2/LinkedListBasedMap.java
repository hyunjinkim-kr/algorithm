package tree_study2;

import list_study2.DoublyLinkedList;

import java.util.Optional;

public class LinkedListBasedMap<K extends Comparable<K>, V> implements Map<K, V> {
    //TODO : 지금 map을 orderdmap으로 바꾸고, Comparable<K>를 인터페이스에 K extends Comparable<K>를 정의
    //키 순서대로 정렬을 하기위해 Comparable

    //노드 T 자리에 튜플을 넣는거임
    /// Node< Tuple<K,V> >
    private class Tuple {
        public final K key;
        public V value;

        public Tuple(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    private DoublyLinkedList<Tuple> list; // Tuple<K, V> 를 서도대고.. 중첩클래스로 Tuple 써도댐

    public LinkedListBasedMap() {
        this.list = new DoublyLinkedList<>();
    }

    @Override
    public Optional<V> put(K key, V value) {
        //Tuple<K, V> tuple = new Tuple<>(key, value);
        Tuple tuple = new Tuple(key, value);

        DoublyLinkedList.Node<Tuple> cursor = list.head;
        int index = 0;

        // TODO : 링크드리스트이기 떄문에 i를 찾을떄마다 다시 0부터 찾기떄문에 N^2 복잡도임
        // TODO : GET(I)를 했을때 실제 노드를 가리키도록(커서 : 노드를 데리고있으면 됨) SET도 마찬가지
        while (cursor != null) {
            Tuple current = cursor.item;
            int cmp = key.compareTo(current.key);

            if (cmp == 0) {
                // 업데이트
                V oldValue = current.value;
                current.value = value;
                return Optional.of(oldValue);
            } else if (cmp < 0) {
                list.add(index, tuple);  // 삽입
                return Optional.empty();
            }

            cursor = cursor.next;
            index++;
        }
//        for (int i = 0; i < list.size(); i++) {
//            //Tuple<K, V> current = list.get(i);
//            //int cmp = key.compareTo(current.key);
//
//            Tuple current = list.get(i);   // 타입 파라미터 제거!
//            int cmp = key.compareTo(current.key);
//
//            if (cmp == 0) {
//                // 키가 존재할때 덮어써도 대긴 하는데 업데이트로 뺼거임 -> 이름떔시 걍 같이함..
//                V oldValue = current.value;
//                list.set(i, tuple);
//                return Optional.of(oldValue);
//            } else if (cmp < 0) {
//                // 오름차순 정렬: 현재보다 작으면 여기 삽입
//                list.add(i, tuple);
//                return Optional.empty();
//            }
//        }

        // 맨 뒤에 추가
        list.addLast(tuple);
        return Optional.empty();
    }

    /*
    @Override
    public boolean update(K key, V value) {
        //Tuple<K, V> tuple = new Tuple<>(key, value);
        Tuple tuple = new Tuple(key,value);

        for (int i = 0; i < list.size(); i++) {
            //Tuple<K, V> current = list.get(i);
            Tuple current = list.get(i);
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                // 키가 일치하면 덮어쓰자
                list.set(i, tuple);
                return true;
            }
        }
        return false;
    }
    */

    @Override
    public Optional<V> get(K key) {
        DoublyLinkedList.Node<Tuple> cursor = list.head;

        while (cursor != null) {
            Tuple current = cursor.item;
            int cmp = key.compareTo(current.key);

            if (cmp == 0) {
                return Optional.of(current.value);
            } else if (cmp < 0) {
                return Optional.empty(); // 정렬되어 있으니 더 볼 필요 없음
            }

            cursor = cursor.next;
        }

        return Optional.empty();
    }

//    public Optional<V> get(K key) {
//        if (list.size() == 0) {
//            return Optional.empty();
//        }
//        for (int i = 0; i < list.size(); i++) {
//            //Tuple<K, V> current = list.get(i);
//            Tuple current = list.get(i);
//            if (key.compareTo(current.key) == 0) {
//                return Optional.of(current.value);
//            }
//        }
//        return Optional.empty();
//    }

    @Override
    public Optional<V> remove(K key) {
        DoublyLinkedList.Node<Tuple> cursor = list.head;
        int index = 0;

        while (cursor != null) {
            Tuple current = cursor.item;
            int cmp = key.compareTo(current.key);

            if (cmp == 0) {
                list.remove(index);
                return Optional.of(current.value);
            } else if (cmp < 0) {
                return Optional.empty();
            }

            cursor = cursor.next;
            index++;
        }

        return Optional.empty();
    }

//    public Optional<V> remove(K key) { //delete
//        if (isEmpty()) {
//            return Optional.empty();
//        }
//
//        //TODO : K가 정렬되어있는데 정렬된 사실을
//        for (int i = 0; i < list.size(); i++) {
//            //Tuple<K, V> current = list.get(i);
//            Tuple current = list.get(i);
//            if (key.compareTo(current.key) == 0) {
//                list.remove(i);
//                return Optional.of(current.value);
//            }
//
//            if (key.compareTo(current.key) < 0) {
//                return Optional.empty();  // key가 current.key보다 작으면 더 이상 찾을 필요 없음
//            }
//        }
//        return Optional.empty();
//    }

    @Override
    public boolean containsKey(K key) {
        return get(key).isPresent();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

