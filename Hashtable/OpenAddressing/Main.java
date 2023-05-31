package Hashtable.OpenAddressing;

import Hashtable.IHashTable;
import Hashtable.OpenAddressing.impl.HashTableOpenAddressingImpl;


public class Main {
    public static void main(String[] args) {
        IHashTable<Integer, Integer> hashTable = new HashTableOpenAddressingImpl<>();
        hashTable.put(1, 1);
        hashTable.put(11, 1);
        hashTable.put(21, 1);
        hashTable.put(32, 1);
        hashTable.put(42, 1);
        hashTable.print();
        hashTable.put(45, 1);
        hashTable.print();
        hashTable.delete(21);
        hashTable.print();

    }
}
