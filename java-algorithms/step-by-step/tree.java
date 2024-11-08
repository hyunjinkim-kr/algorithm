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


        //        BinarySearchTree.java (이진트리 구현 add,remove, contains, size) tree.java (시연 클래스)
        //
        //## 문제
        // - 이진트리 구현
        //
        //## 해결책
        // - 자바 treeSet의 기본기능구현을 목표로, 이진트리를 구현한다.
        // - add, remove, size, contains
        //
        //### 세부 사항
        // - root : 부모가 없는 노드(초기 노드)
        //   - Node : value, left, right, parent를 가지는 이진트리의 구성요소
        //   - value : 노드의 값
        // - left : 노드의 왼쪽자식
        // - right : parent : 부모 노드
        // - current : 현재 보고있는 Node
        //
        //## 알고리즘 설명
        //  1. add
        //      1-1. root 가 없는경우, root 를 생성한다.
        //      1-2. root 가 있는경우, root 부터 시작해서, 부모를 root로 바라보고 그 아래 애들을 탐색한다.
        //      1-3. current를 parent로 하고, 그 아래 왼쪽과 오른쪽 노드를 체크한다.
        //      1-4. 추가된 값이 current 보다 작을때 왼쪽, 클때 오른쪽으로. 노드가 없을때까지 반복한다
        //
        //  2. remove
        //      2-1. 전체 트리를 순회하며, 제거할 값을 찾는다.
        //      2-2. 삭제할 Node 가 자식이 없는경우, 바로 삭제한다.
        //      2-3. 삭제할 Node 가 한쪽만 자식이 있는경우, 삭제된 위치를 자식으로 바꾼다.
        //      2-4. 삭제된 Node 가 자식이 모두 있는경우, 오른쪽 서브트리의 최소값으로 대체한다.
        //
        //  3. size 출력
        //  4. 트리 형태 출력
        //
        //
        //
        //## 시간복잡도 : -


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

