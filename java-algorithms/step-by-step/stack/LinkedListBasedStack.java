package stack;

import list.DoublyLinkedList;

import java.util.Optional;

public class LinkedListBasedStack<T> implements LinkedListStack<T> {
    //TODO 타입을 Integer가 아닌, T에 대해서 처리하도록,
    // ++ 인터페이스로 구현


    private DoublyLinkedList<T> list;


    public LinkedListBasedStack() {
        list = new DoublyLinkedList<>();
    }

    @Override
    public boolean push(T item) {
        list.addFirst(item);
        return true;
    }

    @Override
    public Optional<T> pop() {
        if (isEmpty()) {
            return Optional.empty();
        }
        T item = list.get(0);
        list.removeFirst();
        return Optional.of(item);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어있습니다.");
        }
        return list.get(0);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
