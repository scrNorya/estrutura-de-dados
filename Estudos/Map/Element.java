package Estudos.Map;

/**
 *
 * @author Ayron
 * @param <K> key
 * @param <V> value
 */
public class Element<K, V> {
    final private K key;
    private V value;
    
    public Element(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
    
}
