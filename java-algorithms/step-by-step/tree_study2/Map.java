package tree_study2;
import java.util.Optional;

public interface Map<K extends Comparable<K>, V> {
    Optional<V> put(K key, V value); //insert

    //boolean update(K key, V value); // put과같이씀

    Optional<V> get(K key);

    Optional<V> remove(K key); //delete

    boolean containsKey(K key);

    int size();

    boolean isEmpty();
}
