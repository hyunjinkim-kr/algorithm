package tree_study2;

import java.util.Arrays;
import java.util.Optional;

public class ArrayBasedBinaryTree<K extends Comparable<K>, V> implements Map<K, V> {

    public static final int SIZ = 16;  // 초기 크기
    public static final int RE_SIZ = 2; // 배열 확장 배수

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] tree;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayBasedBinaryTree() {
        tree = (Entry<K, V>[]) new Entry[SIZ];
        size = 0;
    }

    private void resize(int minIdx) {
        while (minIdx >= tree.length) {
            tree = Arrays.copyOf(tree, tree.length * RE_SIZ);
        }
    }

    @Override
    public Optional<V> put(K key, V value) {
        int idx = 1;  // root는 1부터 시작

        while (true) {
            resize(idx);

            if (tree[idx] == null) {
                tree[idx] = new Entry<>(key, value);
                size++;
                return Optional.empty();
            }

            int cmp = key.compareTo(tree[idx].key);
            if (cmp == 0) {
                V oldValue = tree[idx].value;
                tree[idx].value = value;
                return Optional.of(oldValue);
            } else if (cmp < 0) {
                idx = idx * 2; // 왼쪽
            } else {
                idx = idx * 2 + 1; // 오른쪽
            }
        }
    }

    @Override
    public Optional<V> get(K key) {
        int idx = 1;

        while (idx < tree.length && tree[idx] != null) {
            int cmp = key.compareTo(tree[idx].key);
            if (cmp == 0) {
                return Optional.of(tree[idx].value);
            } else if (cmp < 0) {
                idx = idx * 2;
            } else {
                idx = idx * 2 + 1;
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<V> remove(K key) {
        Optional<V> value = get(key);
        if (value.isPresent()) {
            deleteNode(1, key);
            size--;
        }
        return value;
    }

    private int findMinIndex(int idx) {
        while (idx * 2 < tree.length && tree[idx * 2] != null) {
            idx = idx * 2;
        }
        return idx;
    }

    private void deleteNode(int idx, K key) {
        if (idx >= tree.length || tree[idx] == null) return;

        int cmp = key.compareTo(tree[idx].key);
        if (cmp < 0) {
            deleteNode(idx * 2, key);
        } else if (cmp > 0) {
            deleteNode(idx * 2 + 1, key);
        } else {
            int leftIdx = idx * 2;
            int rightIdx = idx * 2 + 1;

            if (leftIdx >= tree.length || tree[leftIdx] == null) {
                tree[idx] = (rightIdx < tree.length) ? tree[rightIdx] : null;
                if (rightIdx < tree.length) tree[rightIdx] = null;
            } else if (rightIdx >= tree.length || tree[rightIdx] == null) {
                tree[idx] = tree[leftIdx];
                tree[leftIdx] = null;
            } else {
                int minIdx = findMinIndex(rightIdx);
                tree[idx].key = tree[minIdx].key;
                tree[idx].value = tree[minIdx].value;
                deleteNode(minIdx, tree[minIdx].key);
            }
        }
    }

    @Override
    public boolean containsKey(K key) {
        return get(key).isPresent();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inorder(1, sb);
        return sb.toString();
    }

    private void inorder(int idx, StringBuilder sb) {
        if (idx < tree.length && tree[idx] != null) {
            inorder(idx * 2, sb);
            sb.append("(").append(tree[idx].key).append(":").append(tree[idx].value).append(") ");
            inorder(idx * 2 + 1, sb);
        }
    }
}
