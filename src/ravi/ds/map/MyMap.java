package ravi.ds.map;

import java.util.Objects;

public class MyMap<K,V> {

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }


    }

    private static final int size = 16;
    private Node<K, V>[] table;

    @SuppressWarnings("unchecked")
    public MyMap() {
        table = new Node[size];
    }

    private int getBucketIndex(K key) {
        return (key == null) ? 0 : (key.hashCode() & (size - 1));
    }


    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Node<K, V> newNode = new Node<>(key, value);

        if (table[index] == null) {
            table[index] = newNode;
            return;
        }
        Node current = table[index];
        while (true) {
            if (Objects.equals(current.key, key)) {
                current.value = value;
                return;
            }
            if (current.next == null) {
                current.next = newNode;
                return;
            }
            current = current.next;
        }

    }

    public Object get(K key) {
        int index = getBucketIndex(key);
        if (index != 0) {
            Node current = this.table[index];
            while (current!=null) {
                if (Objects.equals(current.key, key)) {
                    return current.value;
                }
                current = current.next;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        MyMap<String,Integer> map=new MyMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        System.out.println("One : "+map.get("one"));
        System.out.println("Two : "+map.get("two"));
        System.out.println("Three : "+map.get("three"));

    }
}


