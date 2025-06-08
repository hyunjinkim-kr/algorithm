package list;

import java.util.Objects;

public class DoublyLinkedList<E> extends LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E item, Node<E> prev, Node<E> next) {
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

    private Node<E> search(int index) {
        if (index < (size / 2)) {
            Node<E> x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value, null, head);

        if (head != null)
            head.prev = newNode;
        head = newNode;

        if (tail == null)
            tail = newNode;

        size++;
    }

    @Override
    public void addLast(E value) {
        Node<E> newNode = new Node<>(value, tail, null);

        if (tail != null)
            tail.next = newNode;
        tail = newNode;

        if (head == null)
            head = newNode;

        size++;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }

        Node<E> nextNode = search(index);
        Node<E> prevNode = nextNode.prev;
        Node<E> newNode = new Node<>(value, prevNode, nextNode);

        prevNode.next = newNode;
        nextNode.prev = newNode;
        size++;
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        return search(index).item;
    }

    @Override
    public void set(int index, E value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        search(index).item = value;
    }

    @Override
    public E removeFirst() {
        if (head == null)
            throw new RuntimeException();

        E value = head.item;
        head = head.next;

        if (head != null)
            head.prev = null;
        else
            tail = null;

        size--;
        return value;
    }

    @Override
    public E removeLast() {
        if (tail == null)
            throw new RuntimeException();

        E value = tail.item;
        tail = tail.prev;

        if (tail != null)
            tail.next = null;
        else
            head = null;

        size--;
        return value;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index == 0)
            return removeFirst();

        if (index == size - 1)
            return removeLast();

        Node<E> node = search(index);
        E value = node.item;

        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;

        return value;
    }
    public E remove() {
        return removeFirst();
    }

    @Override
    public boolean remove(Object value) {
        Node<E> node = head;

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
        Node<E> node = head;
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
