package tree_study2;

import list.DoublyLinkedList;

import java.util.Optional;

public class BinaryTreeBasedMap<K extends Comparable<K>, V> implements Map<K, V> {
    // 이진트리로 감
    // TODO : MAP - > BST -> POINTER, ARRAY
    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public BinaryTreeBasedMap() {
        this.root = null;
        // TODO : 사이즈가 있을 필요가 없음
        this.size = 0;
    }

    @Override
    public Optional<V> put(K key, V value) {
        if (root == null) {
            // 노드 만들기
            root = new Node(key, value);
            size++;
            return Optional.empty();
        }
        // 루트랑 비교해서 위치를 바꾸자
        Node current = root;
        while (true) {
            // 키 비교
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                V oldValue = current.value;
                current.value = value;
                return Optional.of(oldValue);
                //return false; // 키 중복: 삽입 안 함
            } else if (cmp < 0) { //작으면 왼쪽
                if (current.left == null) {
                    current.left = new Node(key, value);
                    size++;
                    return Optional.empty();
                }
                current = current.left;
            } else { // 크면 오른쪽
                if (current.right == null) {
                    current.right = new Node(key, value);
                    size++;
                    return Optional.empty();
                }
                current = current.right;
            }
        }
    }

    /*
    @Override
    public boolean update(K key, V value) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                current.value = value;
                return true;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

     */

    @Override
    public Optional<V> get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                return Optional.of(current.value);
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return Optional.empty();
    }
    @Override
    public Optional<V> remove(K key) { //delete
        Optional<V> value = get(key);
        if (value.isPresent()) {
            root = deleteNode(root, key); //루트부터 재귀하면서 삭제하기
            size--;
        }
        return value;
    }

    private Node deleteNode(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) { //작으면 왼쪽으로 감
            node.left = deleteNode(node.left, key);
        } else if (cmp > 0) { //크면 오른쪽으로 감
            node.right = deleteNode(node.right, key);
        } else { //삭제대상 노드
            if (node.left == null) return node.right; //오른쪽을 왼쪽으로
            if (node.right == null) return node.left; // 왼쪽을 오른쪽으로

            // 양쪽 자식 있으면: 오른쪽 서브트리에서 최소값 가져와서 대체
            // 왼쪽에서 제일 큰놈이나, 오른쪽에서 제일 작은놈이나..
            Node min = findMin(node.right);
            node.key = min.key;
            node.value = min.value;
            node.right = deleteNode(node.right, min.key);
        }
        return node;
    }

    // 노드의 최소값 찾기 : 왼쪽 리프 찾음댐
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    @Override
    public boolean containsKey(K key) {
        return get(key).isPresent();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
        // 또는 return root == null; 도 OK
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inorder(root, sb);
        return sb.toString();
    }

    private void inorder(Node node, StringBuilder sb) {
        if (node != null) {
            inorder(node.left, sb);
            sb.append("(").append(node.key).append(":").append(node.value).append(") ");
            inorder(node.right, sb);
        }
    }
}

