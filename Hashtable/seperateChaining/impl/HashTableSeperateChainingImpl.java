package Hashtable.seperateChaining.impl;

import Hashtable.IHashTable;
import Hashtable.seperateChaining.HashNode;

public class HashTableSeperateChainingImpl<K, V> implements IHashTable<K, V> {

    private HashNode[] hashNodes;

    private int capacity;

    private int size;

    public HashTableSeperateChainingImpl() {
        this.capacity = 5;
        hashNodes = new HashNode[capacity];
    }

    public HashTableSeperateChainingImpl(int capacity) {
        this.capacity = capacity;
        hashNodes = new HashNode[capacity];
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    @Override
    public void put(K key, V val) {
        HashNode<K , V> hashNode = new HashNode<>(key, val);
        int index = hash(key);

        HashNode curNode = hashNodes[index];
        HashNode preNode = null;
        if (curNode == null) {
            hashNodes[index] = hashNode;
        } else {
            while (curNode != null) {
                if (curNode.key.equals(key)) {
                    curNode.value = val;
                    return;
                }
                preNode = curNode;
                curNode = curNode.next;
            }
            preNode.next = hashNode;
        }
        size++;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        HashNode curNode = hashNodes[index];
        while (curNode != null) {
            if (curNode.key.equals(key)) {
                return (V) curNode.value;
            }
            curNode = curNode.next;
        }
        return null;
    }

    @Override
    public V delete(K key) {
        int index = hash(key);
        HashNode curNode = hashNodes[index];
        HashNode preNode = null;
        while (curNode != null) {
            if (curNode.key.equals(key)) {
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        if (curNode == null) {
            return null;
        } else if (preNode == null) {
            hashNodes[index] = curNode.next;
        } else {
            preNode.next = curNode.next;
        }
        size--;
        return  (V) curNode.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        for (HashNode<K, V> hashNode : hashNodes) {
            if (hashNode != null) {
                while (hashNode != null) {
                    System.out.print("key : " + hashNode.key + " value : " + hashNode.value + " ->");
                    hashNode = hashNode.next;
                }
                System.out.println("null");
            }
        }
        System.out.println("size : " + size);
    }
}
