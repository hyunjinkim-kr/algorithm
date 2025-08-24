package tree_study2;

import java.util.*;

public class PointerBasedBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    private class Node {
        T value;
        Node left, right, parent;

        Node(T value, Node parent) {
            this.value = value;
            this.parent = parent;
        }
    }

    private Node root;
    private int size;

    public PointerBasedBinaryTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void insert(T value) {
        size++; // 삽입할 위치는 size번째 (1-based)
        if (size == 1) {
            root = new Node(value, null);
            return;
        }

        int index = size;
        Node parent = getNodeByIndex(index / 2);
        Node newNode = new Node(value, parent);
        if (index % 2 == 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }


    @Override
    public Optional<T> getRoot() {
        return root != null ? Optional.of(root.value) : Optional.empty();
    }

    @Override
    public Optional<T> get(int index) {
        Node node = getNodeByIndex(index);
        return node != null ? Optional.of(node.value) : Optional.empty();
    }

    //힙에서 heapify up down 할떄 쓰라고 만들어준 스왑임 순서를 변경함
    @Override
    public void swap(int i, int j) {
        Node a = getNodeByIndex(i);
        Node b = getNodeByIndex(j);
        if (a != null && b != null) {
            T tmp = a.value;
            a.value = b.value;
            b.value = tmp;
        }
    }

    @Override
    public Optional<T> removeLast() {
        if (size == 0) return Optional.empty();
        Node last = getNodeByIndex(size);
        T removed = last.value;

        if (last == root) {
            root = null;
        } else {
            Node parent = last.parent;
            if (parent.right == last) parent.right = null;
            else if (parent.left == last) parent.left = null;
        }

        size--;
        return Optional.of(removed);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    // 완전이진트리 인덱스 기준 노드 찾기 (1-based index)이래야 부모자식 수식이 깔끔해지니까
    private Node getNodeByIndex(int index) {
        return findNode(root, index, 1);
    }

    private Node findNode(Node node, int target, int currentIndex) {
        if (node == null || currentIndex > size) {
            return null;
        }

        //찾음
        if (currentIndex == target) {
            return node;
        }

        Node left = findNode(node.left, target, currentIndex * 2); //왼쪽자식찾기
        if (left != null) {
            return left;
        } else {
            return findNode(node.right, target, currentIndex * 2 + 1); //오른쪽 자식찾기
        }
    }
}
