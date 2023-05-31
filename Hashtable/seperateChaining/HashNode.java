package Hashtable.seperateChaining;

public class HashNode<K, V> {

    public K key;

    public V value;

    public  HashNode next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
