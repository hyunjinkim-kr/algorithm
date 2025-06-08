package stack;

import list.DoublyLinkedList;

public class LinkedListBasedStack extends LinkedListStack<Integer> {

    public static final int SIZ = 500;

    private DoublyLinkedList<Integer> list;

    public int maxSize() {
        return SIZ;
    }

    public LinkedListBasedStack() {
        list = new DoublyLinkedList<>();
    }

    @Override
    public boolean push(Integer item) {
        list.addFirst(item);
        return true;
    }

    @Override
    public void pop() {
        if (!isEmpty()) {
            list.removeFirst();
        }
    }

    @Override
    public Integer peek() {
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
