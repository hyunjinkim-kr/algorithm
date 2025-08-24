package queue_study2;

import list_study2.DoublyLinkedList;

import java.util.Optional;

public class LinkedListBasedQueue<T> implements Queue<T> {
    //TODO 타입을 Integer가 아닌, T에 대해서 처리하도록,
    // ++ 인터페이스로 구현


    private DoublyLinkedList<T> list;


    public LinkedListBasedQueue() {
        list = new DoublyLinkedList<>();
    }


    @Override
    public void enqueue(T item) {
        list.addFirst(item);
    }

    @Override
    public Optional<T> dequeue() {
        if (isEmpty()) {
            return Optional.empty();
        }
        T item = list.get(list.size()-1);
        list.removeLast();
        return Optional.of(item);
    }

    @Override
    public Optional<T> head() {
        if (isEmpty()){
            return Optional.empty();
        }
        T item = list.get(list.size() - 1);
        return Optional.of(item);
    }

    @Override
    public Optional<T> tail() {
        if (isEmpty()){
            return Optional.empty();
        }
        T item = list.get(0);
        return Optional.of(item);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }
}
