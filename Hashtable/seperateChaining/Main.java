package Hashtable.seperateChaining;

import Hashtable.IHashTable;
import Hashtable.seperateChaining.impl.HashTableSeperateChainingImpl;

public class Main {

    public static void main(String[] args) {
        IHashTable<Integer, Integer> hashTable = new HashTableSeperateChainingImpl<>();
        hashTable.put(1, 1);
        hashTable.put(11, 1);
        hashTable.put(21, 1);
        hashTable.put(12, 1);
        hashTable.put(22, 1);
        hashTable.print();
        hashTable.delete(21);
        hashTable.print();

    }
}
