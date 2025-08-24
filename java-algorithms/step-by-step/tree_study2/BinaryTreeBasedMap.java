package tree_study2;

import java.util.Optional;

// 이진트리로 감
// TODO : MAP - > BST -> POINTER, ARRAY
public class BinaryTreeBasedMap<K extends Comparable<K>, V, T extends BinarySearchTree<K, V>> implements Map<K, V> {
    private final T tree;

    public BinaryTreeBasedMap(T tree) {
        this.tree = tree;
    }

    @Override
    public Optional<V> put(K key, V value) {
        Optional<V> old = get(key);
        tree.insert(key, value);
        return old;
    }

    @Override
    public Optional<V> get(K key) {
        return tree.find(key);
    }

    @Override
    public Optional<V> remove(K key) { //delete
        Optional<V> value = get(key);
        if (value.isPresent()) {
            tree.delete(key);
        }
        return value;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key).isPresent();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public int size() {
        return tree.size();
    }

    public Optional<K> getMinKey() {
        return tree.getMinKey();
    }

    @Override
    public String toString() {
        return tree.toString();
    }
}
