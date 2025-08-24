package list_study2;

import java.util.Objects;

public class DoublyLinkedList<T> implements LinkedList<T> {

    public Node<T> head;
    public Node<T> tail;
    public int size;

    public static class Node<T> {
        public T item;
        public Node<T> next;
        public Node<T> prev;

        Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void chkIdx(int index) {
        chkIdx(index, false);  // default: false, 검색이나 삭제일때
    }

    private void chkIdx(int index, boolean isAdd) {
        if(isAdd){
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }
        } else { //빼거나 검색은 사이즈 이내 범위만
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
        }
    }
    private Node<T> search(int index) {
        chkIdx(index);
        if (index < (size / 2)) {
            Node<T> x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public void addFirst(T value) {
        add(0,value);
    }

    @Override
    public void addLast(T value) {
        add(size,value);
    }

    @Override
    public void add(int index, T value) {
        chkIdx(index,true);

        if (index == 0) {
            Node<T> newNode = new Node<>(value, null, head);

            if (head != null)
                head.prev = newNode;
            head = newNode;

            if (tail == null)
                tail = newNode;

            size++;
            return;
        }
        if (index == size) {
            Node<T> newNode = new Node<>(value, tail, null);

            if (tail != null)
                tail.next = newNode;
            tail = newNode;

            if (head == null)
                head = newNode;

            size++;
            return;
        }

        Node<T> nextNode = search(index);
        Node<T> prevNode = nextNode.prev;
        Node<T> newNode = new Node<>(value, prevNode, nextNode);

        prevNode.next = newNode;
        nextNode.prev = newNode;
        size++;
    }

    @Override
    public boolean add(T value) {
        addLast(value);
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        return search(index).item;
    }

    @Override
    public void set(int index, T value) {
        chkIdx(index);

        search(index).item = value;
    }

    @Override
    public T removeFirst() {
        return remove(0);
    }

    @Override
    public T removeLast() {
        return remove(size-1);
    }


    public T remove() {
        return removeLast();
    }

    @Override
    public T remove(int index) {
        chkIdx(index);
        if (index == 0){
            if (head == null)
                throw new RuntimeException();

            T value = head.item;
            head = head.next;

            if (head != null)
                head.prev = null;
            else
                tail = null;

            size--;
            return value;
        }
        if (index == size - 1){
            if (tail == null)
                throw new RuntimeException();

            T value = tail.item;
            tail = tail.prev;

            if (tail != null)
                tail.next = null;
            else
                head = null;

            size--;
            return value;
        }

        Node<T> node = search(index);
        T value = node.item;

        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;

        return value;
    }

    @Override
    public boolean remove(Object value) {
        Node<T> node = head;

        while (node != null) {
            if (Objects.equals(node.item, value)) {
                if (node == head) {
                    removeFirst();
                } else if (node == tail) {
                    removeLast();
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    size--;
                }
                return true;
            }
            node = node.next;
        }
        return false;
    }


    @Override
    public String toString() {
        if (head == null) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> node = head;
        while (node != null) {
            sb.append(node.item);
            if (node.next != null)
                sb.append(", ");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return size;
    }
}
