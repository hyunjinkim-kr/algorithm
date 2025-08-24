package tree_study2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayBasedBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    private List<T> tree;

    public ArrayBasedBinaryTree() {
        this.tree = new ArrayList<>();
        tree.add(null); // 0번 인덱스는 사용하지 않음
    }

    @Override
    public void insert(T value) {
        tree.add(value);
    }

    @Override
    public Optional<T> getRoot() {
        return tree.size() > 1 ? Optional.of(tree.get(1)) : Optional.empty();
    }

    @Override
    public Optional<T> get(int index) {
        if (index > 0 && index < tree.size()) {
            return Optional.ofNullable(tree.get(index));
        }
        return Optional.empty();
    }

    //힙에서 heapify up down 할떄 쓰라고 만들어준 스왑임 순서를 변경함
    @Override
    public void swap(int i, int j) {
        T temp = tree.get(i);
        tree.set(i, tree.get(j));
        tree.set(j, temp);
    }

    @Override
    public Optional<T> removeLast() {
        if (tree.size() <= 1) return Optional.empty();
        return Optional.of(tree.remove(tree.size() - 1));
    }

    @Override
    public int size() {
        return tree.size() - 1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
