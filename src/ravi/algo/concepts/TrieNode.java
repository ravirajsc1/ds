package ravi.algo.concepts;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    boolean isWord=false;
    Map<Character, TrieNode> childrens;
    public TrieNode(){
        this.isWord=false;
        this.childrens=new HashMap<Character, TrieNode>();

    }

}
