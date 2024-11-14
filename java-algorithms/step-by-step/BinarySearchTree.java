public class BinarySearchTree<E extends Comparable<E>> {

  //        트리셋과 동일한 함수명으로 만들어보자
  //        TreeSet<Integer> set1 = new TreeSet<>();
  //        set1.add(); 루트를 생성함 or 자식 노드를 더함
  //        set1.remove(); 특정노드 찾아서 삭제하기
  //        set1.size(); 크기재기 (노드 숫자)
  //        set1.contains(); 찾기

  class Node<E> {

    E value;
    Node<E> left;
    Node<E> right;
    Node<E> parent;

    // 루트노드
    Node(E value) {
      this(value, null);
    }

    // 새끼노드
    Node(E value, Node<E> parent) {
      this.value = value;
      this.parent = parent;
      this.right = null;
      this.left = null;
    }
  }

  private Node<E> root; // 루트 노드
  private int size; // 노드 개수

  // 단일 생성자 - 기본 정렬 기준 사용
  public BinarySearchTree() {
    this.root = null;
    this.size = 0;
  }

  public boolean add(E value) {
    if (root == null) {
      root = new Node<>(value);
      size++;
      return true;
    } else {
      Node<E> current = root;
      Node<E> parent = null;

      // root 부터 시작해서, 부모를 root로 바라보고 그 아래 애들을 탐색한다.
      // current를 parent로 하고, 그 아래 왼쪽과 오른쪽 노드를 체크한다.
      // 추가된 값이 current 보다 작을때 왼쪽, 클때 오른쪽으로. 노드가 없을때까지 반복한다
      while (current != null) {
        parent = current;
        int cmp = value.compareTo(current.value);

        if (cmp < 0) { // 왼쪽으로 이동
          current = current.left;
          if (current == null) {
            parent.left = new Node<>(value, parent);
            size++;
            return true;
          }
        } else if (cmp > 0) { // 오른쪽으로 이동
          current = current.right;
          if (current == null) {
            parent.right = new Node<>(value, parent);
            size++;
            return true;
          }
        } else {
          return false; // 중복된 값이므로 추가하지 않음
        }
      }
    }
    return false;
  }

  public boolean remove(E value) {
    Node<E> parent = null;
    Node<E> current = root;

    // 삭제할 노드를 찾기 위한 반복문
    while (current != null && current.value != value) {
      parent = current;
      int cmp = value.compareTo(current.value);

      current = (cmp < 0) ? current.left : current.right;
    }

    // 값이 없는 경우
    if (current == null) {
      return false;
    }

    // 삭제할 노드가 자식이 없는 경우 (leaf 노드)
    if (current.left == null && current.right == null) {
      if (current == root) {
        root = null;
      } else if (parent.left == current) {
        parent.left = null;
      } else {
        parent.right = null;
      }
    }
    // 삭제할 노드가 오른쪽 자식만 있는 경우
    else if (current.left == null) {
      if (current == root) {
        root = current.right;
      } else if (parent.left == current) {
        parent.left = current.right;
      } else {
        parent.right = current.right;
      }
    }
    // 삭제할 노드가 왼쪽 자식만 있는 경우
    else if (current.right == null) {
      if (current == root) {
        root = current.left;
      } else if (parent.left == current) {
        parent.left = current.left;
      } else {
        parent.right = current.left;
      }
    }
    // 삭제할 노드가 두 자식을 모두 가지고 있는 경우
    else {
      // 오른쪽 서브트리에서 가장 작은 값을 찾아 현재 노드를 대체
      Node<E> parentNode = current;
      Node<E> child = current.right;

      // 오른쪽 서브트리에서 최소값(가장 왼쪽 노드)을 찾음
      while (child.left != null) {
        parentNode = child;
        child = child.left;
      }

      // 찾은 최소값을 삭제할 노드의 값으로 대체
      current.value = child.value;

      // 최소값 노드의 부모와 연결을 조정하여 최소값 노드를 제거
      if (parentNode.left == child) {
        parentNode.left = child.right;
      } else {
        parentNode.right = child.right;
      }
    }
    size--;
    return true;
  }

  // 트리 크기 확인 메서드
  public int size() {
    return size;
  }

  // 요소 조회(contains) 메서드
  public boolean contains(E value) {
    Node<E> current = root; // 루트에서 시작

    while (current != null) {
      int cmp = value.compareTo(current.value); // 현재 노드와 비교
      if (cmp < 0) {
        // 찾는 값이 현재 노드보다 작으면 왼쪽으로 이동
        current = current.left;
      } else if (cmp > 0) {
        // 찾는 값이 현재 노드보다 크면 오른쪽으로 이동
        current = current.right;
      } else {
        // 찾는 값을 발견한 경우 true 반환
        return true;
      }
    }

    // 값을 찾지 못하면 false 반환
    return false;
  }

  // 트리 출력 메서드
  public void printTree() {
    printTreeRecursive(root, 0);
  }

  private void printTreeRecursive(Node<E> node, int depth) {
    if (node != null) {
      printTreeRecursive(node.right, depth + 1);
      System.out.println(" ".repeat(depth * 4) + node.value); // 깊이에 따라 들여쓰기
      printTreeRecursive(node.left, depth + 1);
    }
  }
}
