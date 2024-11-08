import java.io.*;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class tree<E> {
    public static void main(String[] args) throws IOException {
        // 자바로 바이너리 트리를 구현해보자.
//        숙제 (내일까지)
//        1. 자바로 바이너리트리 구현하고
//        2. DFS (재귀안쓰고) 스택을 이용해서 잘 구현해보기 (스택 : 돌아갈 주소를 저장하는 용도로 써야함)

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();


        // 값 추가
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);

        // 트리 구조 출력
        System.out.println("트리 구조:");
        tree.printTree();

        // 요소 확인
        System.out.println("트리 contains 7: " + tree.contains(7)); // true
        System.out.println("트리 contains 20: " + tree.contains(20)); // false

        // 요소 삭제
        tree.remove(5);
        System.out.println("5 제거 후 트리 구조:");
        tree.printTree();

        // 트리 크기
        System.out.println("트리 크기: " + tree.size());
    }
}

