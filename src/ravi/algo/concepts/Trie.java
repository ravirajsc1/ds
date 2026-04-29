package ravi.algo.concepts;
import java.util.*;

public class Trie {
    public static void main(String[] args) {
        //Implement Trie (Prefix Tree)

        List < String > keys = Arrays.asList("the", "a", "there", "answer");
        Trie trieOfKeys = new Trie();
        int num = 1;
        for (String x: keys) {
            System.out.println(num + ".\tInserting key: '" + x + "'");
            trieOfKeys.insert(x);
            num += 1;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        List < String > search = Arrays.asList("a", "answer", "xyz", "an");
        for (String y: search) {
            System.out.println(num + ".\tSearching key: '" + y + "'");
            System.out.println("\tKey found? " + trieOfKeys.search(y));
            num += 1;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        List < String > searchPrefix = Arrays.asList("b", "an");
        for (String z: search) {
            System.out.println(num + ".\tSearching prefix: '" + z + "'");
            System.out.println("\tPrefix found? " + trieOfKeys.searchPrefix(z));
            num += 1;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Search Suggestions System

        String[] products = {"bat", "bag", "bassinet", "bread", "cable",
                "table", "tree", "tarp"};
        String[] searchWordList = {"ba", "in", "ca", "t"};

        for(int i=0; i<searchWordList.length; i++){
            Trie obj = new Trie();
            System.out.println((i+1)+ ".\tProducts:"+ Arrays.toString(products));
            System.out.println("\tSearch keyword: "+ searchWordList[i]);
            System.out.println("\tSuggested Products: " + obj.suggestedProducts(products, searchWordList[i]));
          //  System.out.println(PrintHyphens.repeat("-", 100));

        }



        // repalce words

        Trie s = new Trie();
        String[] sentence = {
                "where there is a will there is a way",
                "the quick brown fox jumps over the lazy dog",
                "oops there is no matching word in this sentence",
                "i was born on twenty ninth february",
                "i dont know where you are but i will find you eventually"
        };
        List<List<String>> dictionary = Arrays.asList(Arrays.asList("wi", "wa", "w"),
                Arrays.asList("qui", "f", "la", "d"),
                Arrays.asList("oops", "there", "is", "no", "matching", "word", "in", "this", "sentence"),
                Arrays.asList("wa", "w", "a", "ty", "nint", "nin", "n", "feb", "februa", "f"),
                Arrays.asList("cool", "how", "sunday", "sun", "x"));

        for (int i = 0; i < sentence.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput sentence: '" + sentence[i] + "'");
            System.out.println("\tDictionary words: '" + dictionary.get(i) + "'");
            System.out.println("\tAfter replacing words: '" + s.replaceWords(sentence[i], dictionary.get(i)) + "'");
          //  System.out.println(PrintHyphens.repeat("-", 100));
        }


        //Design Add and Search Words Data Structure


    }



    // Design Add and Search Words Data Structure



    NodeT nodeT1=new NodeT();
    // Replace Words
    public  String replaceWords(String sentence, List<String> dictionary) {
        nodeT1 = new NodeT(); //  RESET TRIE
        for(String dic:dictionary){
            insertReplaceWords(dic);
        }

        // Replace this placeholder return statement with your code
        return getReplacedSentenceDiff(sentence.split(" "));
    }

    private String getReplacedSentence(String[] sentence) {
        StringBuilder result = new StringBuilder();

        for (String str : sentence) {
            NodeT trieNode = this.nodeT1;
            StringBuilder sub = new StringBuilder();
            boolean found = false;

            for (char ch : str.toCharArray()) {
                int index = ch - 'a';

                if (index < 0 || index >= 26 || trieNode.child[index] == null) {
                    break;
                }

                trieNode = trieNode.child[index];
                sub.append(ch);

                if (trieNode.isWord) {
                    result.append(sub);
                    found = true;
                    break;
                }
            }

            if (!found) {
                result.append(str); // ✅ always full word
            }

            result.append(" ");
        }

        return result.toString().trim();
    }

    private String getReplacedSentenceDiff(String[] sentence) {
        List<String> res=new ArrayList<>();

        for (String str : sentence) {
            res.add(replace(str));
        }

        return String.join(" " ,res);
    }

//(root "")
// ├── 'a' → nodeA (isWord = true)
// └── 'c' → nodeC
//          └── 'a' → nodeCA
//                   └── 't' → nodeCAT (isWord = true)

    public String replace(String str) {
        NodeT temp = this.nodeT1;;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            int id = str.charAt(i) - 'a';
            if(Objects.isNull(temp.child[id])) {
                return str;
            }
            temp = temp.child[id];
            sb.append(str.charAt(i));
            if(temp.isWord) {
                return sb.toString();
            }
        }
        return str;
    }


    private  void insertReplaceWords(String dic) {

        NodeT trieNode=this.nodeT1;
        for(char ch:dic.toCharArray()){

            int index=ch-'a';

            if(trieNode.child[index]==null){
                trieNode.child[index]=new NodeT();
            }

            trieNode=trieNode.child[index];


        }
        trieNode.isWord=true;


    }


    // Search Suggestions System

    NodeT nodeT=new NodeT();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for(String product:products){
            insertProduct(product);

        }
        return searchProducts(searchWord);
    }

    private void insertProduct(String product) {
        NodeT trieNode=nodeT;

        for(char ch:product.toCharArray()){
            int index=ch-'a';
            if(trieNode.child[index]==null){
                trieNode.child[index]=new NodeT();
            }
            trieNode=trieNode.child[index];
            trieNode.searchWords.offer(product);
            if(trieNode.searchWords.size()>3){
                trieNode.searchWords.pollLast();
            }
        }
    }

    private List<List<String>> searchProducts(String searchWord) {
        NodeT trieNode=nodeT;
        List<List<String>> result=new ArrayList<>();
        for(char ch:searchWord.toCharArray()){
            int index=ch-'a';

            if(trieNode.child[index]!=null){
                trieNode=trieNode.child[index];
            }
            result.add(trieNode==null? Arrays.asList(): nodeT.searchWords);


        }
        return result;
    }


    TrieNode root;

    public Trie() {
        // Write your code here
        root = new TrieNode();
    }

    // inserting string in trie
    public void insert(String word) {
        // Write your code here

        TrieNode trieNode=root;

        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!trieNode.childrens.containsKey(ch)){
                trieNode.childrens.put(ch,new TrieNode());
            }
            trieNode=trieNode.childrens.get(ch);
        }
        trieNode.isWord=true;

    }

    // searching for a string
    public boolean search(String word) {
        // Replace this placeholder return statement with your code

        TrieNode trieNode=root;

        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!trieNode.childrens.containsKey(ch)){
                return false;
            }
            trieNode=trieNode.childrens.get(ch);

        }
        return trieNode.isWord;
    }

    // searching for a prefix
    public boolean searchPrefix(String prefix) {
        // Replace this placeholder return statement with your code

        TrieNode trieNode=root;

        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(!trieNode.childrens.containsKey(ch)){
                return false;
            }
            trieNode=trieNode.childrens.get(ch);

        }
        return true;
    }


}
