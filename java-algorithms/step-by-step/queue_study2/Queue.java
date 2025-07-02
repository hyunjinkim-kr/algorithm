package queue_study2;
import java.util.Optional;
interface Queue<T> {
    void enqueue(T item);
    Optional<T> dequeue();
    Optional<T> head();
    Optional<T> tail();

    boolean isEmpty();

    int size();
}
