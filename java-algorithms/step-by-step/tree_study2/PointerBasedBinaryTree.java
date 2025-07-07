package tree_study2;

import java.util.Optional;

public class PointerBasedBinaryTree<K extends Comparable<K>, V> implements Map<K, V> {
    // 기본적으로 아까 만든 이진트리 맵 방식이 포인터기반인듯
    // 노드랑 키밸류 기반으로 왔다갔다
    // 부모만 추가해보자

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        Node parent;

        Node(K key, V value, Node parent) {
            this.key = key;
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
    public Optional<V> put(K key, V value) {
        if (root == null) {
            // 노드 만들기
            root = new Node(key, value, null);
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
                    current.left = new Node(key, value, current);
                    size++;
                    return Optional.empty();
                }
                current = current.left;
            } else { // 크면 오른쪽
                if (current.right == null) {
                    current.right = new Node(key, value, current);
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
        Node target = findNode(root, key);
        if (target != null) {
            Optional<V> value = Optional.of(target.value);
            deleteNode(target);
            size--;
            return value;
        }
        return Optional.empty();
    }

    private Node findNode(Node node, K key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) return node;
            else if (cmp < 0) node = node.left;
            else node = node.right;
        }
        return null;
    }

    private void deleteNode(Node node) {
        if (node.left == null && node.right == null) {
            replaceInParent(node, null);
        } else if (node.left == null) {
            replaceInParent(node, node.right);
        } else if (node.right == null) {
            replaceInParent(node, node.left);
        } else {
            Node min = findMin(node.right);
            node.key = min.key;
            node.value = min.value;
            deleteNode(min);
        }
    }

    private void replaceInParent(Node node, Node newNode) {
        if (node.parent == null) {
            root = newNode;
            if (newNode != null) newNode.parent = null;
        } else if (node == node.parent.left) {
            node.parent.left = newNode;
            if (newNode != null) newNode.parent = node.parent;
        } else {
            node.parent.right = newNode;
            if (newNode != null) newNode.parent = node.parent;
        }
    }

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
