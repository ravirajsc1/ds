package ravi.algo.concepts;
import java.util.*;


/*

✅ Use Array when:
only lowercase letters
memory not a concern
want max speed
✅ Use HashMap when:
sparse Trie (few children per node)
large dataset
flexible characters needed

 */
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

        //Word Search II
        char[][] grid0 = {{'B', 'S', 'L', 'I', 'M'},
                {'R', 'I', 'L', 'M', 'O'},
                {'O', 'L', 'I', 'E', 'O'},
                {'R', 'Y', 'I', 'L', 'N'},
                {'B', 'U', 'N', 'E', 'C'}};


        char[][] grid1 = {{'C', 'S', 'L', 'I', 'M'},
                {'O', 'I', 'B', 'M', 'O'},
                {'O', 'L', 'U', 'E', 'O'},
                {'N', 'L', 'Y', 'S', 'N'},
                {'S', 'I', 'N', 'E', 'C'}};

        char[][] grid2 = {{'C', 'O', 'L', 'I', 'M'},
                {'I', 'N', 'L', 'M', 'O'},
                {'A', 'L', 'I', 'E', 'O'},
                {'R', 'T', 'A', 'S', 'N'},
                {'S', 'I', 'T', 'A', 'C'}};

        char[][] grid3 = {{'P', 'S', 'L', 'A', 'M'},
                {'O', 'P', 'U', 'R', 'O'},
                {'O', 'L', 'I', 'E', 'O'},
                {'R', 'T', 'A', 'S', 'N'},
                {'S', 'I', 'T', 'A', 'C'}};

        char[][] grid4 = {{'O', 'A', 'A', 'N'},
                {'E', 'T', 'A', 'E'},
                {'I', 'H', 'K', 'R'},
                {'I', 'F', 'L', 'V'}};

        char[][] grid5 = {{'S', 'T', 'R', 'A', 'C'},
                {'I', 'R', 'E', 'E', 'E'},
                {'N', 'G', 'I', 'T', 'C'},
                {'I', 'T', 'S', 'R', 'A'}};

        char[][] grid6 = {{'A', 'A', 'A'},
                {'A', 'A', 'A'},
                {'A', 'A', 'A'}};

        char[][][] grid = {grid0, grid1, grid2, grid3, grid4, grid5, grid6};
        String[] strings1 = {"BUY", "SLICK", "SLIME", "ONLINE", "NOW"};
        String[] strings2 = {"BUY", "STUFF", "ONLINE", "NOW"};
        String[] strings3 = {"REINDEER", "IN", "RAIN"};
        String[] strings4 = {"TOURISM", "DESTINATIONS", "POPULAR"};
        String[] strings5 = {"OATH", "PEA", "EAT", "RAIN"};
        String[] strings6 = {"STREET", "STREETCAR", "STRING", "STING", "RING", "RACECAR"};
        String[] strings7 = {"A", "AA", "AAA", "AAAA"};
        String[][] words = {strings1, strings2, strings3, strings4, strings5, strings6, strings7};

        for(int i=0; i< grid.length; i++){
            System.out.println((i+1) + ".\t2D grid: \n");
            //printGrid(grid[i]);
            System.out.println("\n\tInput list: "+ Arrays.toString(words[i]));
            System.out.println("\n\tOutput: "+findStrings(grid[i], words[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Top K Frequent Words
        String[][] wordsT = {
                {"apple", "banana", "orange", "banana", "banana"},
                {"cat", "dog", "fish", "bird", "cat", "dog", "fish", "bird"},
                {"python", "python", "python", "python", "python", "python", "python", "python", "python", "python"},
                {"a", "b", "c", "a", "b", "a"},
                {"tree", "bush", "flower", "tree", "bush", "tree", "rock", "rock", "grass"}
        };

        int[] k = {2, 4, 1, 3, 4};

        for (int i = 0; i < wordsT.length; i++) {
            System.out.print((i + 1) + ".\tInput list: ");
       //     printWords(words[i]);
            generateFrequencyMap(wordsT[i]);
            List<String> result = topKFrequentWords(wordsT[i], k[i]);
            System.out.println("\n\tTop " + k[i] + " frequent word(s): " + result);
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }

        // Longest Common Prefix
        String[][] testCases = {
                {"flower", "flow", "flight"},
                {"dog", "racecar", "car"},
                {"interspecies", "interstellar", "interstate"},
                {"throne", "dungeon"},
                {"throne", "throne"},
                {"apple", "app"},
                {"a", "b", "c"},
                {"reflower", "flow", "flight"},
                {"preach", "prevent", "prelude", "press"},
        };

        Trie solution = new Trie();

        for (int i = 0; i < testCases.length; i++) {
            System.out.print(i + 1 + ".\t Input strings: [");
            for (int j = 0; j < testCases[i].length; j++) {
                System.out.print("'" + testCases[i][j] + "'");
                if (j < testCases[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            System.out.println("\t Longest common prefix: '" + solution.longestCommonPrefix(testCases[i]) + "'");
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

// Index Pairs of a String
        String[] texts = {
                "thestoryofeducative",
                "ababa",
                "helloworld",
                "abcxyz",
                "abcdef"
        };

        String[][] wordss = {
                {"story", "of", "educ"},
                {"aba", "ab"},
                {"hello", "world"},
                {"abc", "xyz"},
                {"a", "abc", "def"}
        };

        // Loop through test cases
        for (int i = 0; i < texts.length; i++) {

            int[][] result = solution.indexPairs(texts[i], wordss[i]);
            System.out.println((i + 1) + "\tText: " + texts[i]);
            System.out.print("\tWords: "+ Arrays.toString(wordss[i]));

            System.out.println("\n\tResult: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // K-th Smallest in Lexicographical Order
        int[][] testCasesN = {
                {13, 2},
                {100, 10},
                {1, 1},
                {1000, 100},
                {4289384, 1922239}
        };

        for (int i = 0; i < testCasesN.length; i++) {
            int n = testCasesN[i][0];
            int kN = testCasesN[i][1];
            System.out.println((i + 1) + ".\tInput:\n\tn = " + n + ", k = " + kN);
            System.out.println("\n\tK-th Smallest in Lexicographical Order = " + solution.findKthNumber(n, kN));
            System.out.println("-".repeat(100));
        }

        // Palindrome Pairs


        String[][] arr = {
                {"od", "doll", "car"},
                {"mac", "polo", "cam"},
                {"x", ""},
                {"pqr", "fg", "gf", "eefg", "rpq"},
                {"v", "vv", "vvv"}
        };


        for (int i = 0; i < arr.length; ++i) {
            System.out.print((i + 1) + "\twords: [");
            for (int j = 0; j < arr[i].length; ++j) {
                System.out.print("\"" + arr[i][j] + "\"");
                if (j < arr[i].length - 1)
                    System.out.print(", ");
            }

            List<List<Integer>> pairs = solution.palindromePairs(arr[i]);
            System.out.print("]\n\n\tValid palindrome pairs: [");
            for (int j = 0; j < pairs.size(); ++j) {
                System.out.print("[" + pairs.get(j).get(0) + ", " + pairs.get(j).get(1) + "]");
                if (j < pairs.size() - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("-".repeat(100));
        }

        // Longest Common Suffix Queries

        List<List<String>> wordsContainers = List.of(
                List.of("mango", "ango", "xango"),
                List.of("helloworld", "reworld", "worldworld"),
                List.of("cat", "bat", "rat"),
                List.of("apple", "banana", "cherry"),
                List.of("flight", "night", "light", "tight")
        );

        List<List<String>> wordsQueries = List.of(
                List.of("go", "ango", "xyz"),
                List.of("ld", "preworld", "beyondworld"),
                List.of("at", "t", "dog"),
                List.of("ple", "ana", "xyz"),
                List.of("ight", "t", "zzz")
        );


        for (int i = 0; i < wordsContainers.size(); i++) {
            List<String> container = wordsContainers.get(i);
            List<String> queries   = wordsQueries.get(i);

            // Convert List<String> ➜ String[] for the Solution method
            int[] result = stringIndices(
                    container.toArray(new String[0]),
                    queries.toArray(new String[0])
            );

            System.out.println((i + 1) + "\twordsContainer: " + container);
            System.out.println("\twordsQuery: " + queries);
            System.out.println("\tans: " + Arrays.toString(result));
            System.out.println("-".repeat(100));
        }

        // Map Sum Pairs
        List<String[]> testOps = Arrays.asList(
                new String[]{"MapSum", "insert", "sum"},
                new String[]{"MapSum", "insert", "insert", "insert", "sum"},
                new String[]{"MapSum", "insert", "insert", "insert", "sum", "sum"},
                new String[]{"MapSum", "insert", "insert", "sum"},
                new String[]{"MapSum", "insert", "insert", "sum", "sum"},
                new String[]{"MapSum", "insert", "insert", "sum", "insert", "sum"}
        );

        List<Object[][]> testArgs = Arrays.asList(
                new Object[][]{ {}, {"a", 1}, {"a"} },
                new Object[][]{ {}, {"apple", 2}, {"apple", 5}, {"apple", 1}, {"ap"} },
                new Object[][]{ {}, {"car", 3}, {"cat", 2}, {"cart", 4}, {"ca"}, {"car"} },
                new Object[][]{ {}, {"dog", 5}, {"cat", 7}, {"z"} },
                new Object[][]{ {}, {"a", 3}, {"apple", 2}, {"a"}, {"app"} },
                new Object[][]{ {}, {"book", 6}, {"book", 0}, {"bo"}, {"boot", 4}, {"bo"} }
        );

        for (int idx = 0; idx < testOps.size(); idx++) {
            String[] ops = testOps.get(idx);
            Object[][] args1 = testArgs.get(idx);

            System.out.println("Test Case " + (idx + 1) + ":");
            MapSum mapSum = null;

            for (int j = 0; j < ops.length; j++) {
                String op = ops[j];
                Object[] arg = args1[j];

                switch (op) {
                    case "MapSum":
                        mapSum = new MapSum();
                        System.out.println("\tOperation: " + op + "() → Result: null");
                        break;
                    case "insert":
                        String key = (String) arg[0];
                        int val = (int) arg[1];
                        mapSum.insert(key, val);
                        System.out.println("\tOperation: insert(" + key + ", " + val + ") → Result: null");
                        break;
                    case "sum":
                        String prefix = (String) arg[0];
                        int result = mapSum.sum(prefix);
                        System.out.println("\tOperation: sum(" + prefix + ") → Result: " + result);
                        break;
                }
            }
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
        // Check If a Word is a Prefix of Any Word in a Sentence
        List<String[]> testcases = Arrays.asList(
                new String[]{"i love coding", "lov"},
                new String[]{"hello world", "he"},
                new String[]{"play playground player", "pla"},
                new String[]{"open source ai", "deep"},
                new String[]{"fast reliable secure", "sec"}
        );

        for (int idx = 0; idx < testcases.size(); ++idx) {
            String[] testCase = testcases.get(idx);
            int output = isPrefixOfWord(testCase[0], testCase[1]);
            System.out.println((idx + 1) + ".  sentence = \"" + testCase[0] + "\"");
            System.out.println("    searchWord = \"" + testCase[1] + "\"\n");
            System.out.println("    output = " + output);
            System.out.println(new String(new char[100]).replace("\0", "_"));
        }

        //Longest Word With All Prefixes
        String[][] testCasess = {
                {"w","wo","wor","worl","world"},  // simple growing chain
                {"a","banana","app","appl","ap","apply","apple"}, // apple vs apply
                {"x","xy","xyz","xz"},  // branching with valid path
                {"car","ca","c","cat"}, // tie between car and cat, car is lexicographically smaller
                {"dog","do","d","cat"}  // cat invalid because "c","ca" missing
        };

        // Run tests
        for (int i = 0; i < testCases.length; i++) {
            String result = longestWord(testCases[i]);
            System.out.println((i + 1) + "\tInput = " + Arrays.toString(testCases[i]));
            System.out.println("\tOutput = " + result);
            System.out.println("--------------------------------------------------------------------------------------------");
        }
    }


    public static List<Integer> lexicographicalOrder(int n) {
        int curr=1;
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            result.add(curr);

            if(curr*10 <= n){
                curr=curr*10;
            }else{

                while(curr%10==9 || curr+1>n){
                    curr=curr/10;
                }
                curr=curr+1;
            }
       }
        return result;
    }



    //Longest Word With All Prefixes
    public static String longestWord (String[] words) {

        TrieNode root=new TrieNode();


        for(String word:words){
            TrieNode node=root;
            for(char ch:word.toCharArray()){
                node.childrens.putIfAbsent(ch,new TrieNode());
                node=node.childrens.get(ch);

            }
            node.isWord=true;
        }


        /*
        for(int i=0;i<words.length;i++){
            String word=words[i];

            if(isValidTrie(root,word)){
                if(word.length()>ans.length() || (word.length()==ans.length() && word.compareTo(ans)<0)){
                    ans=word;
                }
            }
        }*/

        // Replace this placeholder return statement with your code
        return  dfsSearch(root,new StringBuilder());
    }

    private static String dfsSearch(TrieNode root,StringBuilder path) {

        String best=path.toString();
        for(char ch='a';ch<='z';ch++){
            TrieNode child=root.childrens.get(ch);
            if(child!=null && child.isWord){
                path.append(ch);
                String candidate=dfsSearch(child,path);
                if(candidate.length()>best.length() ||
                        (candidate.length()==best.length() && candidate.compareTo(best)<0 )){
                    best=candidate;
                }
                path.deleteCharAt(path.length()-1);
            }

        }
        return best;


    }

    private static boolean isValidTrie(TrieNode root, String word) {
        TrieNode node = root;
        for(char ch:word.toCharArray()){
            TrieNode temp=node.childrens.get(ch);
            if(temp==null || !temp.isWord){
                return false;
            }
            node=temp;
        }
        return true;
    }

    // Check If a Word is a Prefix of Any Word in a Sentence
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] wordList=sentence.split(" ");

        Node root=new Node();

        for(int i=0;i<wordList.length;i++){
            if(root.bestLen>i){
                root.bestLen=i;
            }
            Node curr=root;
            for(char ch:wordList[i].toCharArray()){
                curr.child.putIfAbsent(ch,new Node());
                curr=curr.child.get(ch);
                if(curr.bestLen>i){
                    curr.bestLen=i;
                }

            }

        }
        Node curr=root;
        for(char ch:searchWord.toCharArray()){
            if(!curr.child.containsKey(ch)){
               return -1;
            }
            curr=curr.child.get(ch);
        }


        // Replace this placeholder return statement with your code
        return curr.bestLen;
    }


    private static class NodeTotal {
        Map<Character, NodeTotal> child = new HashMap<>();
        int total = 0;                // index of shortest word seen so far

    }

    public static class MapSum {// Map Sum Pairs
        NodeTotal node;
        private Map<String, Integer> map; // stores latest value of each key
            public MapSum() {
                this.node=new NodeTotal();
                map= new HashMap<>();
            }

            public void insert(String key, int val) {
                // Write your code here
                NodeTotal root=node;
                int delta=val-map.getOrDefault(key,0);
                map.put(key,val);

                for(char ch:key.toCharArray()){
                    root.child.putIfAbsent(ch,new NodeTotal());
                    root=root.child.get(ch);
                    root.total+=delta;

                }
            }

            public int sum(String prefix) {
                NodeTotal root=node;

                for(char ch:prefix.toCharArray()){

                    if(root.child.get(ch)==null){
                        return 0;
                    };
                    root=root.child.get(ch);


                }
                return root.total;
            }
    }

    /** Trie node (reversed): children map + best candidate cache. */
    private static class Node {
        Map<Character, Node> child = new HashMap<>();
        int bestIdx = -1;                // index of shortest word seen so far
        int bestLen = Integer.MAX_VALUE; // that word’s length
    }

    // Longest Common Suffix Queries
    public static int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        Node root=new Node();
        for(int i=0;i<wordsContainer.length;i++){
            String word=wordsContainer[i];
            int len=word.length();


            if(len<root.bestLen){
                root.bestLen=len;
                root.bestIdx=i;
            }
            Node curr=root;
            for(int j=len-1;j>=0;j--){
                char ch=word.charAt(j);
                curr.child.putIfAbsent(ch, new Node());
                curr=curr.child.get(ch);
                if(len<curr.bestLen ){
                    curr.bestIdx=i;
                    curr.bestLen=len;
                }
            }

        }

        /* query ohase */

        int[] ans=new int[wordsQuery.length];
        for(int i=0;i<wordsQuery.length;i++){
            String word=wordsQuery[i];
            int len=word.length();
            Node node=root;
            for(int j=len-1;j>=0;j--){
                char ch=word.charAt(j);
                if(node.child.get(ch)==null){
                    break;
                }
                node=node.child.get(ch);
            }
            ans[i]=node.bestIdx;

        }

        return ans;
    }

    // Palindrome Pairs

    public List<List<Integer>> palindromePairs(String[] words) {

        // Replace this placeholder return statement with your code

        List<List<Integer>> res= new ArrayList<>();

        Map<String,Integer> map=new HashMap<>();

        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
        }

        // Empty String Case
        if(map.containsKey("")){
            int blankIdx= map.get("");
            for(int i=0;i <words.length;i++){
                if(i!= blankIdx && isPalindrome(words[i])){
                    res.add(Arrays.asList(blankIdx,i));
                    res.add(Arrays.asList(i,blankIdx));

                }
            }
        }

        //  reflection case

        for(int i=0;i<words.length;i++){
             String word=words[i];
             String reverseWord=new StringBuilder(word).reverse().toString();
             if(map.containsKey(reverseWord)){
                 int index=map.get(reverseWord);
                 if(index!=i){
                     res.add(Arrays.asList(i, index));
                 }
             }
        }


        // tricky case
        for(int i=0;i<words.length;i++){
            String curr=words[i];

            for(int cut=1;cut< curr.length();cut++){
                String left=curr.substring(0,cut);
                String right=curr.substring(cut);
                if(isPalindrome(left)){
                    String reversedRight=new StringBuilder(right).reverse().toString();
                    if(map.containsKey(reversedRight)){
                        res.add(Arrays.asList(map.get(reversedRight),i));
                    }
                }

                if(isPalindrome(right)){
                    String reversedLeft=new StringBuilder(right).reverse().toString();
                    if(map.containsKey(reversedLeft)){
                        res.add(Arrays.asList(i,map.get(reversedLeft)));
                    }

                }



            }


        }
        return res;
    }

    public boolean isPalindrome(String str){
        int n=str.length();
        for(int i=0;i<n/2;i++){
            if(str.charAt(i)!=str.charAt(n-i-1))
                return false;
        }
        return true;
    }
    // K-th Smallest in Lexicographical Order


    public int findKthNumber(int n, int k) {

        k-=1;
        int curr=1;



        while(k>0) {
            int count=countNumbersUnderPrefix(n,curr,curr+1);
            if (k < count) {
                curr = curr * 10;
                k -= 1;
            } else {
                curr = curr + 1;
                k -= count;

            }
        }
        return curr;

    }

    private int countNumbersUnderPrefix(int n, long curr, long next) {
        int count=0;
        while(curr<=n){
            count+=Math.min(n+1L,next)-curr;
            curr*=10;
            next*=10;

        }
        return count;

    }


    // Index Pairs of a String
    public int[][] indexPairs (String text, String[] words) {


        for(String word:words){
            insert(word);
        }

        List<int[]> result=new ArrayList<>();

        for(int i=0;i<text.length();i++){

            TrieNode root=this.root;

            for(int j=i;j<text.length();j++){
                char ch=text.charAt(j);
                if(!root.childrens.containsKey(ch)){
                   break;
                }
                root=root.childrens.get(ch);

                if(root.isWord){
                    result.add(new int[]{i,j});
                }

            }
        }

        int[][] output=new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            output[i]=result.get(i);
        }

        return output;
    }


    // Longest Common Prefix

    public String longestCommonPrefix(String[] strs) {
        this.root=new TrieNode();
        TrieNode root=this.root;

        for(String str:strs){
            this.insert(str);
        }

        StringBuilder sb=new StringBuilder();

        while(root.childrens.size()==1){
            Map.Entry<Character, TrieNode> first =
                    root.childrens.entrySet().iterator().next();
            sb.append(first.getKey());
            root=first.getValue();
        }

        return sb.toString();
    }


    //Top K Frequent Words

    public static List<String> topKFrequentWords(String[] words, int k) {
        Map<String,Integer> frequecyMap=new HashMap<>();

        for(String word:words){
            frequecyMap.put(word,frequecyMap.getOrDefault(word,0)+1);
        }

        TrieTopK[] bucket=new TrieTopK[words.length+1];
        List<String> topk=new ArrayList<>();


        for(Map.Entry<String,Integer> entry:frequecyMap.entrySet()){
            int frequency=entry.getValue();
            String word=entry.getKey();
            if(bucket[frequency]==null){
                bucket[frequency]=new TrieTopK();
            }
            bucket[frequency].addWord(word);
        }


        for(int i=bucket.length-1;i>=0 && topk.size() <k;i--){
            if (bucket[i] != null) {
                List<String> ans = new ArrayList<>();
                bucket[i].getWords(bucket[i].root, ans);

                if (ans.size() < k - topk.size()) {
                    topk.addAll(ans);
                } else {
                    topk.addAll(ans.subList(0, k - topk.size()));
                }

            }

        }

        return topk ;
    }

    public static void generateFrequencyMap(String[] words) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("\n\tFrequency map: ");
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
        }
    }
// Word Search II


    // Function to delete the characters in the searched word that are not shared
    public void removeCharacters(Trie trie, String stringToDelete) {
        TrieNode node=this.root;
        List<TrieNode> childList=new ArrayList<>();

        for(char ch:stringToDelete.toCharArray()){
            childList.add(node);
            node=node.childrens.get(ch);
        }

        for(int i=childList.size()-1;i>=0;i--){
            char childChar=stringToDelete.charAt(i);
            TrieNode parent=childList.get(i);
            TrieNode target=parent.childrens.get(childChar);

            if(!target.childrens.isEmpty())
                return;

            parent.childrens.remove(childChar);

        }

    }


    public static List<String> findStrings(char[][] grid, String[] words){
        Trie trie=new Trie();
        trie.root = new TrieNode();
        List<String> result=new ArrayList<>();

        for(String word:words){
            trie.insert(word);
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dfsFind(trie,trie.root,grid,i,j,result,new String());
            }
        }

        return result;
    }
    private static void dfsFind(Trie trie, TrieNode root, char[][] grid, int row, int col, List<String> result, String word) {


        if(root.isWord){
            result.add(word);
            root.isWord=false;
            trie.removeCharacters(trie,word);

        }


        if(row< grid.length && row >= 0 && col>= 0 && col < grid[0].length ){
            char c=grid[row][col];
            TrieNode child=root.childrens.get(c);
            if(child!=null){
                String newWord=word+c;
                grid[row][col]=0; //visted
                int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
                for (int d = 0; d < dir.length; d++) {

                    int nexRow = row + dir[d][0];
                    int nextCol = col + dir[d][1];
                    dfsFind(trie,child,grid,nexRow,nextCol,result,newWord);

                }
                grid[row][col]=c;
            }

        }
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
    public void
    insert(String word) {
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
