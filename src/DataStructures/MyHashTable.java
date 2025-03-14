package DataStructures;

import java.util.ArrayList;
import java.util.StringJoiner;

public class MyHashTable<K, V> {

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private final Entry<K, V>[] table;

    @SuppressWarnings("unchecked")
    public MyHashTable(int size) {
        this.table = (Entry<K, V>[]) new Entry[size];
    }

    public void put(K key, V value) {
        int address = hash(key);
        Entry<K, V> entry = new Entry<>(key, value);
        if (table[address] == null) {
            table[address] = entry;
        } else {
            Entry<K, V> currentEntry = table[address];
            while (currentEntry != null) {
                if (currentEntry.key.equals(key)) {
                    currentEntry.value = value;
                    return;
                }
                if (currentEntry.next == null) {
                    break;
                }
                currentEntry = currentEntry.next;
            }
            if (currentEntry != null) {
                currentEntry.next = entry;
            }
        }
    }

    public V get(K key) {
        int address = hash(key);
        Entry<K, V> currentEntry = this.table[address];
        while (currentEntry != null) {
            if (currentEntry.key.equals(key)) {
                return currentEntry.value;
            }
            currentEntry = currentEntry.next;
        }
        return null;
    }

    public ArrayList<K> getKeys() {
        ArrayList<K> keys = new ArrayList<>();
        for (Entry<K, V> entry : this.table) {
            Entry<K, V> currentEntry = entry;
            while (currentEntry != null) {
                keys.add(currentEntry.key);
                currentEntry = currentEntry.next;
            }
        }
        return keys;
    }

    private int hash(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode() % table.length);
    }

    public void print() {
        StringJoiner printableTable = new StringJoiner(", ", "{ ", " }");
        for (Entry<K, V> entry : this.table) {
            Entry<K, V> currentEntry = entry;
            while (currentEntry != null) {
                printableTable.add(currentEntry.key + ":" + currentEntry.value);
                currentEntry = currentEntry.next;
            }
        }
        System.out.println(printableTable);
    }


    public static void main(String[] args) {
        MyHashTable<String, Integer> myHashTable = new MyHashTable<>(2);

        myHashTable.put("grapes", 10);
        myHashTable.put("apple", 11);
        myHashTable.put("banana", 12);
        myHashTable.print();

        Object grapes = myHashTable.get("banana");
        System.out.println(grapes);

        ArrayList<String> keys = myHashTable.getKeys();
        System.out.println("Keys: " + keys);
    }
}
