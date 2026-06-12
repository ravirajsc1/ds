package ravi.algo.concepts;

import java.util.*;
import java.util.ArrayList;

public class Bucket {
    // Initialize bucket here

    private List<Pair<Integer,Integer>>  bucket;
    public Bucket() {
            bucket=new ArrayList<>();
    }

    // put value in bucket
    public void update(int key, int value) {
        boolean found=false;
        for(Pair<Integer,Integer> bc:bucket){
            if(key==bc.getKey()){
                    bc.value=value;
                    found=true;
                    break;
            }

        }
        if(!found){
            bucket.add(new Pair<>(key,value));
        }

    }
    // get value from bucket
    public int get(int key) {
        // Write your code here
        for(int i=0;i< bucket.size();i++){
            if(key==bucket.get(i).getKey()){
                return bucket.get(i).getValue();
            }

        }
        return - 1;
    }
    // delete value from bucket
    public void remove(int key) {
        for(int i=0;i< bucket.size();i++){
            if(key==bucket.get(i).getKey()){
                bucket.remove(i);
                break;
            }

        }

        // Write your code here
    }
}

// Define Pair class to store key-value pairs
class Pair<K,V>{
    K key;
    V value;

    Pair(K k, V v){
        this.key=k;
        this.value=v;

    }
    // Getter methods for key and value
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }


}