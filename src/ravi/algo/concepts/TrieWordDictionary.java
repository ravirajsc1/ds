package ravi.algo.concepts;

import java.util.*;

public class TrieWordDictionary {

    private NodeT trieNode;
    boolean canFind;

    public TrieWordDictionary() {
        // Write your code here
        this.trieNode=new NodeT();
        this.canFind=false;
    }

    public void addWord(String word) {
        // Replace this placeholder retrun statement with your code
        NodeT trie=this.trieNode;
        for(char ch:word.toCharArray()){
            int index=ch-'a';
            if(trie.child[index]==null)
                trie.child[index]=new NodeT();

            trie=trie.child[index];

        }
        trie.isWord=true;
    }

    public boolean search(String word) {
        // Replace this placeholder retrun statement with your code

        this.canFind=false;
        searchHelper(this.trieNode,word, 0);
        return this.canFind;
    }

    private void searchHelper(NodeT trieNode, String word, int i) {
        if (this.canFind) return;
        if(trieNode==null)
            return;

        int n=word.length();

        if(n==i){
            if(trieNode.isWord){
                this.canFind=true;
            }
            return;
        }

        if(word.charAt(i)=='.'){
            for(int j=0;j<26;j++){
                searchHelper(trieNode.child[j],word,i+1);
            }
        }else{
            searchHelper(trieNode.child[word.charAt(i)-'a'],word,i+1);
        }
    }

    public List<String> getWords() {
        List<String> result=new ArrayList<>();
        if (this.trieNode == null)
            return new ArrayList < String > ();


        return DFS(this.trieNode,"",result);
    }

    private List<String> DFS(NodeT node, String word, List<String> wordsList) {

        if(node==null)
            return wordsList;

        if(node.isWord){
            wordsList.add(word);
        }

        for(int i=0;i<26;i++){
            if(node.child[i]!=null) {
                char ch = (char) (i + 'a');
                DFS(node.child[i],word+ch,wordsList);
            }
        }
        return wordsList;

    }

    public static void main(String[] args) {
        TrieWordDictionary obj = new TrieWordDictionary();

        String[] words = {"add", "sky", "hello", "multi", "addition", "sky", "multiply", "table"};
        int i = 1;
        for (String w: words) {
            System.out.println(i + ".\tAdding word: '" + w + "'");
            obj.addWord(w);
        //    System.out.println(PrintHyphens.repeat("-", 100));
            i += 1;
        }

        String[] wordSearch = {"helo", "multiple", "...le", "..llo", "..r"};
        for (String v: wordSearch) {
            System.out.println(i + ".\tSearching word: '" + v + "'");
            System.out.println("\t" + obj.search(v));
        //    System.out.println(PrintHyphens.repeat("-", 100));
            i += 1;
        }

        System.out.println(i + "\tGetting all words: " + String.join(", ", obj.getWords()));
    }


}
