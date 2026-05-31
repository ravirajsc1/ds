package ravi.algo.concepts;

import java.util.*;

class TrieNodeTopK {
    TrieNodeTopK[] children;
    String word;

    public TrieNodeTopK() {
        children = new TrieNodeTopK[26];
        word = null;
    }
}

class TrieTopK {
    TrieNodeTopK root;

    public TrieTopK() {
        root = new TrieNodeTopK();
    }

    public void addWord(String word) {
        TrieNodeTopK cur = root;
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNodeTopK();
                }
                cur = cur.children[c - 'a'];
            }
        }
        cur.word = word;
    }


    public void getWords(TrieNodeTopK node, List<String> ans) {
      if(node==null)
          return;

      if(node.word!=null){
          ans.add(node.word);
      }


      for(int i=0;i<26;i++){
          if(node.children[i]!=null){
              getWords(node.children[i],ans);
          }
      }

    }

}

