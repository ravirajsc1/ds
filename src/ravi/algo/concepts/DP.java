package ravi.algo.concepts;

import java.util.*;

public class DP {

    public static long[] factorials;
    public static long[] inverses;
    public static final int MOD = 1000000007;

    public static void main(String[] args) {


        // Knapsack

        int[][] weights = {
                {1, 2, 3, 5},
                {4},
                {2},
                {3, 6, 10, 7, 2},
                {3, 6, 10, 7, 2, 12, 15, 10, 13, 20}
        };

        int[][] values = {
                {1, 5, 4, 8},
                {2},
                {3},
                {12, 10, 15, 17, 13},
                {12, 10, 15, 17, 13, 12, 30, 15, 18, 20}
        };

        int[] capacity = {6, 3, 3, 10, 20};

        // Let's uncomment this to see the benefit of using dynamic programming with tabulation

        // int newWeights[][] = Arrays.copyOf(weights, weights.length + 1);
        // newWeights[weights.length] = new int[]{63,  55,  47,  83,  61,  82,   6,  34,   9,  38,   6,  69,  17,
        //     50,   7, 100, 101,   4,  41,  28, 119,  78,  98,  38,  75,  35,
        //      8,  10,  16,  93,  34,  23,  51,  79, 118,  86,  85, 109,  88,
        //     72,  99,  36,  21,  80,  42,  44,  62,   7,  54,   7,   6,   0,
        //     65,  25,  44,  86,  76,  18,  11,  10, 104,  17,  36,  91,  78,
        //     88,  79, 103,   1,   4,  34,  94,  73,  21,   8,   9,  79,  25,
        //    106,  76,  39,  78,   1,  92, 104,  84,  40, 100, 116,  84,  23,
        //     79, 109,  79,  71,  72, 116,  90,  79,  26};
        // weights = newWeights;

        // int newValues[][] = Arrays.copyOf(values, values.length + 1);
        // newValues[values.length] = new int[]{35,  47,   8, 103,  83,  71,  11, 107,   9,  34,  41,  54,  73,
        //     72, 108, 100,  46,  27,  79,  98,  49,  63,  41, 116,  57,  86,
        //     51,  47,  88, 118,  65,   0,  64,  11,  45,  47,  36,  50, 114,
        //     90, 105,  55,  93,  12,  73,  96,  50,  27,  36,  97,  12,  21,
        //    107,  34, 106,  37,  84,  38, 110,  60,  34, 104,  92,  56,  94,
        //    109,  81,  17,  24, 106,  50,  68,  90,  73,  46,  99,   5,   5,
        //     22,  27,  58,  24,  20,  80,  37,   1,  16,  39,  26,  32,  12,
        //     47,  22,  28,  50,  95,   6, 105, 101,  20};
        // values = newValues;

        // int newCapacity[] = Arrays.copyOf(capacity, capacity.length + 1);
        // newCapacity[capacity.length] = 1000;
        // capacity = newCapacity;

        for (int i = 0; i < values.length; ++i) {
            System.out.print(i + 1);
            System.out.println(". We have a knapsack of capacity " + capacity[i] + " and we are given the following list of item values and weights:");
            System.out.println(new String(new char[30]).replace('\0', '-'));
            System.out.println("Weights   |     Values");
            System.out.println(new String(new char[30]).replace('\0', '-'));
            for (int j = 0; j < values[i].length; ++j)
                System.out.printf("%-10d|%6d\n", weights[i][j], values[i][j]);
            int result = findMaxKnapsackProfit(capacity[i], weights[i], values[i]);
            System.out.println("\nThe maximum we can earn is: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println();
        }

        int[][] coins = {{2, 3, 4, 5},
                {1, 4, 6, 9},
                {6, 7, 8},
                {1, 2, 3, 4, 5},
                {14, 15, 18, 20}};
        int[] total = {7, 11, 27, 41, 52};
        for (int i = 0; i < total.length; i++) {
            System.out.println(i + 1 + ".\tThe minimum number of coins required to find " + total[i] + " from " + Arrays.toString(coins[i]) + " is: " + coinChange(coins[i], total[i]));
            //         System.out.println(PrintHyphens.repeat("-", 100));
        }


        // N-th Tribonacci Number
        int[] inputList = {4, 5, 25};
        int index = 0;
        for (int input : inputList) {
            System.out.println((++index) + ". The " + input + "th Tribonacci number is:  "
                    + findTribonacciBottomUp(input));
            //    System.out.println(PrintHyphens.repeat("-", 100));

        }

        //   // Partition Equal Subset SumAditlet ping
        int[][] input = {
                {1, 2, 5},
                {3, 1, 1, 2, 2, 1},
                {1, 3, 7, 3}, {1, 2, 3},
                {1, 2, 5}, {1, 3, 4, 8},
                {1, 2, 3, 2, 3, 5},
                {1, 5, 3, 2, 3, 19, 3},
                {1, 2, 3, 5, 3, 2, 1}
        };

        for (int i = 0; i < input.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tGiven array: " + Arrays.toString(input[i]));
            Boolean result = canPartitionArray(input[i]);
            System.out.print("\n\tCan we partition the array into equal sum arrays?: " + result + "\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[] inputBits = {1, 2, 3, 4, 5, 10};

        for (int i = 0; i < inputBits.length; ++i) {
            System.out.println((i + 1) + ".\t Bits: " + inputBits[i]);
            int[] result = countingBits(inputBits[i]);
            System.out.println("\t Counting bits: " + java.util.Arrays.toString(result));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

        int[][][] input_bits = {
                {{0, 1}, {1, 1}},
                {{0, 0, 1}, {0, 1, 1}, {1, 0, 1}},
                {{0, 0, 0}, {0, 1, 0}, {1, 0, 1}},
                {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}},
                {{0, 1, 0, 1}, {1, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}
        };

        for (int i = 0; i < input_bits.length; i++) {
            System.out.println((i + 1) + ".\t Input matrix:");
            //   Print.printMatrix(input_bits[i]);

            int[][] updatedMatrix = updateMatrix(input_bits[i]);

            System.out.println("\n\t Distance matrix:");
            // Print.printMatrix(updatedMatrix);

            //    System.out.println(Print.repeat("-", 100));
        }

        int[][] inputs = {{2, 3, 2}, {1, 2, 3, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
                {7, 4, 1, 9, 3}, {}};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tHouses: " + Arrays.toString(inputs[i]));
            System.out.println("\n\tMaximum loot: " + houseRobber(inputs[i]));
            System.out.println("-" + new String(new char[100]).replace('\0', '-') + "\n");
        }

        int[][] inputbits = {
                {-2, 0, -1},
                {2, 3, -2, 4},
                {2, -5, 3, 1, -4, 0, -10, 2},
                {1, 2, 3, 0, 4},
                {5, 4, 3, 10, 4, 1}
        };

        for (int i = 0; i < inputbits.length; i++) {
            System.out.printf("%d.\t Input array: %s%n", i + 1, Arrays.toString(inputbits[i]));

            System.out.printf("%n\t Maximum product: %d%n", maxProduct(inputbits[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        int[][] nums = {
                {2, 3, 5},
                {3, 6, 7, 8},
                {4, 5, 6, 9},
                {20, 25, 30, 35, 40},
                {3, 5, 7}
        };
        int[] targets = {5, 15, 11, 40, 15};

        for (int i = 0; i < nums.length; i++) {
            System.out.println((i + 1) + ". \tnums: " + Arrays.toString(nums[i]));
            System.out.println("\tTarget: " + targets[i]);

            List<List<Integer>> combinations = combinationSum(nums[i], targets[i]);

            System.out.println("\tCombinations: " + combinations);
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }

        //Word Break
        List<String> s = new ArrayList<>(Arrays.asList(
                "vegancookbook", "catsanddog", "highwaycrash",
                "pineapplepenapple", "screamicecream", "educativecourse"
        ));

        List<String> wordDict = new ArrayList<>(Arrays.asList(
                "ncoo", "kboo", "inea", "icec", "ghway", "and", "anco", "hi", "way", "wa",
                "amic", "ed", "cecre", "ena", "tsa", "ami", "lepen", "highway", "ples",
                "ookb", "epe", "nea", "cra", "lepe", "ycras", "dog", "nddo", "hway",
                "ecrea", "apple", "shp", "kbo", "yc", "cat", "tsan", "ganco", "lescr",
                "ep", "penapple", "pine", "book", "cats", "andd", "vegan", "cookbook"
        ));

        // Palindromic Substrings
        List<String> strings = new ArrayList<>(Arrays.asList("cat", "lever", "xyxxyz", "wwwwwwwwww", "tattarrattat"));

        for (int i = 0; i < strings.size(); i++) {
            System.out.println((i + 1) + ".\t Input string: '" + strings.get(i) + "'");
            int result = countPalindromicSubstringsE(strings.get(i));
            System.out.println("\t Number of palindromic substrings: " + result);
            //   Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }

        // Longest Common Subsequence

        String[] firstStrings = {"qstw", "setter", "abcde", "partner", "freedom"};
        String[] secondStrings = {"gofvn", "bat", "apple", "park", "redeem"};

        for (int i = 0; i < firstStrings.length; i++) {
            System.out.println((i + 1) + ".\tstr1: " + firstStrings[i] + "\n\t" + "str2: " + secondStrings[i] + "\n\n\t"
                    + "The length of the longest common subsequence is: "
                    + longestCommonSubsequence(firstStrings[i], secondStrings[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //Word Break II
        String[] s2 = {"vegancookbook", "catsanddog", "highwaycrash", "pineapplepenapple", "screamicecream", "educativecourse"};

        List<String> wordDict2 = Arrays.asList("oghi", "ncoo", "kboo", "inea",
                "icec", "ghway", "tsand", "anco", "eame", "ghigh", "hi", "way", "wa",
                "amic", "mi", "ed", "cecre", "pple", "reamicecreamed", "ena", "tsa", "ami", "hwaycrashpineapplepenapplescreamicecreamed", "lepen", "okca", "highway", "ples", "atsa", "oghig", "ookb", "epe", "ookca", "nea", "cra", "lepe", "vegancookbookcatsandd",
                "kc", "ra", "le", "ay", "crashpineapple", "ycras", "vegancookbookcatsanddoghighwaycrashpineapplepenapplescre", "doghi", "nddo", "hway", "vegancookbookcatsanddoghi", "vegancookbookcatsanddoghighwaycr", "at", "mice", "nc", "d", "enapplescreamicecreamed", "h",
                "ecrea", "nappl", "shp", "kbo", "yc", "vegancookbookcatsanddoghighwaycrashpineapplepenapplescream", "cat", "waycrashpineapplepenapplescreamicecreamed", "tsan", "vegancookbookcatsanddoghighwaycrashpineap", "ganco", "lescr", "sand", "applescreamicecreamed", "vegancookbookcatsanddoghig", "pi", "vegancookbookcatsanddoghighwaycrashpineapp", "cookb", "okcat", "neap", "nap", "oghighwaycrashpineapplepenapplescreamicecreamed", "crashpineapplepenapplescreamicecreamed",
                "ashpi", "ega", "escreamicecreamed", "hwa", "rash", "cre", "micecreamed", "plepe", "coo", "epen", "napp", "wayc", "vegancookbookcatsanddoghighwaycrashpinea", "vegancookbookcatsanddogh", "plep", "ice", "ple", "gh", "ghw", "cook", "pl", "app", "ic", "pinea", "hello", "dog", "vegancookbookcat", "eamed", "ook", "lesc", "ddog", "ca", "vegancookbookcatsanddoghighwaycrashpineapplepenapplescreamice", "c", "escr", "penap", "boo", "eami", "ecreamed", "vegancookbookcatsanddoghighwaycrashpi", "igh", "mic", "ganc", "vegancookbookcatsanddoghighwaycrashpineapplepenap",
                "eappl", "vegancookbookcatsanddoghighway", "ep", "penapple", "b", "ycrashpineapplepenapplescreamicecreamed", "pin", "book", "p", "sa", "okb", "andd", "ayc", "sh", "vegan", "cookbook");

        System.out.println(
                "The list of words we can use to break down the strings are:\n");
        System.out.println(wordDict + "\n");

        for (int i = 0; i < s2.length; i++) {
            System.out.print((i + 1) + ".\tThe possible strings from the string: "
                    + s2[i] + " are the following combinations:\n");
            System.out.println("\n\t" + wordBreak(s2[i], wordDict));
            // System.out.println(PrintHyphens.repeat("-", 100));
        }

        List<String> decodeStr = Arrays.asList("124", "123456", "11223344", "0", "0911241", "10203", "999901");

        for (int i = 0; i < decodeStr.size(); ++i) {
            System.out.println((i + 1) + ".\t There are " + numOfDecodingsBetter(decodeStr.get(i))
                    + " ways in which we can decode the string: '" + decodeStr.get(i) + "'");
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

        ////Count the Number of Good Subsequences
        String[] inputListG = {"aqw", "aabbcc", "aaa", "abbc", "abbb"};

        for (int i=0; i<inputListG.length; i++) {
            System.out.print(i+1);

            System.out.println(".\tInput string: " + inputListG[i]);
       //     System.out.println("\tNumber of good subsequences: " + countGoodSubsequences(inputListG[i]));

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Binary Tree Cameras
        List<List<TreeNode<Integer>>> trees = Arrays.asList(
                Arrays.asList(new TreeNode<>(0), null, new TreeNode<>(0), new TreeNode<>(0), new TreeNode<>(0)),
                Arrays.asList(new TreeNode<>(0), new TreeNode<>(0), new TreeNode<>(0), new TreeNode<>(0), new TreeNode<>(0), new TreeNode<>(0), new TreeNode<>(0)),
                Arrays.asList(new TreeNode<>(0)),
                Arrays.asList(new TreeNode<>(0), new TreeNode<>(0), null, new TreeNode<>(0)),
                Arrays.asList(new TreeNode<>(0), new TreeNode<>(0), null, null, new TreeNode<>(0), new TreeNode<>(0), null, null, new TreeNode<>(0))
        );


        for (int i = 0; i < trees.size(); ++i) {
            BinaryTree<Integer> tree = new BinaryTree<>(trees.get(i));
            System.out.println((i + 1) + "\tTree: ");
        //    Print.displayTree(tree.root);
            System.out.println("\n\tMinimum number of cameras: " + minCameraCover(tree.root));
            System.out.println("-".repeat(100));
        }

        // Number of Ways to Form Target String Given a Dictionary
        String[][] wordsList = {
                {"acca", "bbbb", "caca"},
                {"abc", "def", "ghi"},
                {"aaa", "aaa", "aaa"},
                {"abc"},
                {"abcd", "efgh", "ijkl"}
        };

        String[] targetsRun = {
                "aba",
                "adg",
                "aaa",
                "abc",
                "aei"
        };

        for (int i = 0; i < wordsList.length; ++i) {
            String[] words = wordsList[i];
            String target = targetsRun[i];

            int result = numWays(words, target);

            System.out.print((i + 1) + ".\tWords: [");
            for (int j = 0; j < words.length; ++j) {
                System.out.print("\"" + words[j] + "\"");
                if (j < words.length - 1) System.out.print(", ");
            }
            System.out.println("]\n\tTarget: " + target);
            System.out.println("\n\tNumber of Ways: " + result);
            System.out.println("-".repeat(100));
        }

        // Climbing Stairs




    }


// Climbing Stairs
    public static int climbStairs(int n) {


        int prev2=1;
        int prev1=1;

        for(int i=2;i<=n;i++){
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        // Replace this placeholder return statement with your code
        return prev1;
    }
    /*
    For each column in the word matrix (left to right),
try to extend the number of ways to build prefixes of target (back to front),
using characters available in that column.
What the variables mean
dp[k] = number of ways to form the first k characters of target
using the columns processed so far.

freq[col][letter] = how many words have letter at position col.

We loop over col (columns in the words) and try to match target chars.

| Column | Before Iteration | After Iteration |
| ------ | ---------------- | --------------- |
| 0      | \[1, 0, 0]       | \[1, 2, 0]      |
| 1      | \[1, 2, 0]       | \[1, 2, 0]      |
| 2      | \[1, 2, 0]       | \[1, 2, 4]      |

     */

    // Number of Ways to Form Target String Given a Dictionary
    public static int numWays(String[] words, String target) {
        final int MOD = 1_000_000_007;

        int m = words[0].length();     // number of columns (all words have same length)
        int t = target.length();       // length of target string

        // freq[i][c] = how many times character 'c' appears in column i
        int[][] freq = new int[m][26];
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                char ch = word.charAt(i);
                freq[i][ch - 'a']++;
            }
        }

        // dp[j] = number of ways to form the first j characters of the target
        long[] dp = new long[t + 1];
        dp[0] = 1; // base case: 1 way to form empty target

        // Traverse each column of the word matrix (left to right)
        for (int col = 0; col < m; col++) {

            // Update dp from right to left to prevent overwriting needed values
            for (int j = t - 1; j >= 0; j--) {
                char targetChar = target.charAt(j);
                int charIndex = targetChar - 'a';

                // If this column contains the character needed for target[j]
                if (freq[col][charIndex] > 0) {
                    // Add the number of ways to form target[0..j] and use this column's character
                    dp[j + 1] = (dp[j + 1] + dp[j] * freq[col][charIndex]) % MOD;
                }
            }
        }

        // Final answer: number of ways to form entire target string
        return (int) dp[t];
    }


    //   public static int minCameraCover(TreeNode<Integer> root) {
/*

| Return Value | Meaning             |
| ------------ | ------------------- |
| `-1`         | Node needs a camera |
| `0`          | Node has a camera   |
| `1`          | Node is covered     |

 */
    private static int cameras=0;
    public static int minCameraCoverBetter(TreeNode<Integer> root) {
        cameras=0;
        if(minCameraCheck(root)==-1){
            cameras++;
        }
        return cameras;
    }

    private static int minCameraCheck(TreeNode<Integer> root) {
        if(root==null){
            return 1;
        }

        int left=minCameraCheck(root.left);
        int right=minCameraCheck(root.right);

        if(left==-1 || right == -1){
            cameras++;
            return 0;
        }


        if(left==0 || right==0){
            return 1;
        }
        return -1;
    }

    // dp0: node is not covered
// dp1: node is covered, no camera here
// dp2: node has a camera
    // Binary Tree Cameras
    public static int minCameraCover(TreeNode<Integer> root) {

        List<Integer> res=recurse(root);
        // Replace this placeholder return statement with your code
        return Math.min(res.get(1),res.get(2));
    }

    private static List<Integer> recurse(TreeNode<Integer> root) {
        if(root==null){
            return Arrays.asList(0,0,Integer.MAX_VALUE);
        }

        List<Integer> left=recurse(root.left);
        List<Integer> right=recurse(root.right);

        int leftCost=Math.min(left.get(1),left.get(2));
        int rightCost=Math.min(right.get(1),right.get(2));

        long d0=(long) left.get(1)+right.get(1);
        long d1=  Math.min((long) left.get(2)+rightCost, (long) right.get(2)+leftCost);
        long d2= 1+Math.min((long) left.get(0),leftCost)+Math.min((long) right.get(0),rightCost);

        d0=Math.min(d0,Integer.MAX_VALUE);
        d1=Math.min(d1,Integer.MAX_VALUE);
        d2=Math.min(d2,Integer.MAX_VALUE);
        return Arrays.asList((int)d0,(int)d1,(int)d2);
    }


    //Count the Number of Good Subsequences

    public static int countGoodSubsequences(String s) {

        final int N=s.length()+1;
        factorials=new long[N];
        inverses=new long[N];

        factorials[0]=1;
        inverses[0]=1;

        for(int i=0;i<N;i++){
            factorials[i]=factorials[i-1]*i%MOD;
            inverses[i]=quickModularInverse(factorials[i],MOD-2,MOD );
         }

        int[] frequencyCount=new int[26];

        int maxCount=0;

        for(int i=0;i<s.length();i++){
            maxCount=Math.max(maxCount,++frequencyCount[s.charAt(i)-'a']);
        }

        long finalCount=0;

        for(int i=1;i<=maxCount;i++){
            long count=1;
            for(int j=0;j<26;j++){
                if(frequencyCount[j]>i){
                    count=count*(combination(frequencyCount[j],i))%MOD;
                }
            }
            finalCount=(finalCount+count-1)%MOD;
        }

        return (int)finalCount;
    }

    public static long quickModularInverse(long base, long exponent, long modulas){

        long result=1;
        while(exponent!=0){
            if((exponent & 1) ==1){
                result=result*base%modulas;
            }
            exponent>>=1;
            base=base*base%modulas;
        }

        return result;
    }

    public static long combination(int n,int k){
        return (factorials[n]*inverses[k]%MOD)*inverses[n-k]%MOD;
    }

    /*
| **Concept**     | **Definition**                                                                        | **Examples (for `"abc"`)**              | **Contiguous?**    | **Order Matters?**       | **Common Problem Type**      |
            | --------------- | ------------------------------------------------------------------------------------- | --------------------------------------- | ------------------ | ------------------------ | ---------------------------- |
            | **Subset**      | Any combination of elements from a **set** (ignores order, no duplicates)             | `[], [a], [b], [a,b], [a,c], [a,b,c]`   | ❌ (Not contiguous) | ❌ (Order doesn't matter) | Bitmasking, recursion        |
            | **Substring**   | A **contiguous** sequence of characters                                               | `"a", "ab", "abc", "b", "bc", "c"`      | ✅                  | ✅                        | Sliding window, nested loops |
            | **Subsequence** | Characters from original string in the **same order**, but not necessarily contiguous | `"a", "ac", "abc", "b", "bc", "c"`      | ❌                  | ✅                        | DP, recursion                |
            | **Partition**   | Divide the string into **contiguous chunks**                                          | `["a","b","c"], ["ab","c"], ["a","bc"]` | ✅                  | ✅                        | Backtracking, recursion, DP  |
*/
// Decode Ways

    public static int numOfDecodings(String decodeStr) {
         int[] dp=new int[decodeStr.length()+1];
         dp[0]=1;

         if(decodeStr.charAt(0)!='0'){
             dp[1]=1;
         }else{
             return 0;
         }

         for(int i=2;i<=decodeStr.length();i++){

             if(decodeStr.charAt(i-1)!='0'){
                 dp[i]+=dp[i-1];
             }
             if( (decodeStr.charAt(i-1)<='6' && decodeStr.charAt(i-2)=='2') || (decodeStr.charAt(i-2)=='1')){
                 dp[i]+=dp[i-2];
             }
         }

        // Replace this placeholder return statement with your code
        return dp[decodeStr.length()];
    }


// Decode Ways better

    public static int numOfDecodingsBetter(String decodeStr) {
        //int[] dp=new int[decodeStr.length()+1];
        int prev2=1;
        int prev1;
        if(decodeStr.charAt(0)!='0'){
            prev1=1;
        }else{
            return 0;
        }

        for(int i=2;i<=decodeStr.length();i++){
            int curr=0;
            if(decodeStr.charAt(i-1)!='0'){
                curr+=prev1;
            }
            if( (decodeStr.charAt(i-1)<='6' && decodeStr.charAt(i-2)=='2') || (decodeStr.charAt(i-2)=='1')){
                curr+=prev2;
            }
            prev2=prev1;
            prev1=curr;

        }

        // Replace this placeholder return statement with your code
        return prev1;
    }
    //Word Break II

    public static List<String> wordBreak2(String s, List<String> WordDict) {

        Set<String> wordset=new HashSet<>(WordDict);
        List<List<String>> dp=new ArrayList<>();
        for(int i=0;i<s.length()+1;i++){
            dp.add(new ArrayList<>());
        }
        dp.get(0).add("");



        for(int i=1;i<=s.length();i++){
            String prefix=s.substring(0,i);
            List<String> temp = new ArrayList<>();

            for(int j=0;j<i;j++){
                String suffix=prefix.substring(j);
                if(wordset.contains(suffix)){
                    for(String substring:dp.get(j)){
                        temp.add(substring+(substring.isEmpty()?"":" ")+suffix);
                    }
                }
            }
            dp.set(i,temp);
        }

        // Replace this placeholder return statement with your code
        return dp.get(dp.size()-1);
    }


/*
We loop i from 1 to str1.length()

We loop j from 1 to str2.length()

Compare str1[i-1] with str2[j-1]:

If they match: extend LCS by 1 →
dp[i][j] = 1 + dp[i-1][j-1]

If they don’t match: LCS is max of:

Without current char of str1 → dp[i-1][j]

Without current char of str2 → dp[i][j-1]
 */
    // Longest Common Subsequence buttom up
    public static int longestCommonSubsequencebottonmup(String str1, String str2) {
        // Replace this placeholder return statement with your code
        int[][] dp=new int[str1.length()+1][str2.length()+1];

        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                      dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }

            }
        }
        return dp[str1.length()][str2.length()];
    }

    // Longest Common Subsequence buttom up
    public static int longestCommonSubsequencebottonmupBest(String str1, String str2) {
        // Replace this placeholder return statement with your code
        int[] dp=new int[str2.length()+1];

        for(int i=1;i<=str1.length();i++){
            int prev=0;
            for(int j=1;j<=str2.length();j++){
                int temp=dp[j];
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[j]=1+prev;
                }else{

                    dp[j]=Math.max(dp[j-1],dp[j]);
                }
                prev=temp;

            }
        }
        return dp[str2.length()];
    }

    // Longest Common Subsequence
    public static int longestCommonSubsequence(String str1, String str2) {
        // Replace this placeholder return statement with your code
        int[][] dp=new int[str1.length()][str2.length()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return longestCommonSubsequenceHelper(str1,str2,0,0,dp);
    }

    private static int longestCommonSubsequenceHelper(String str1, String str2, int i, int j, int[][] dp) {

        if(str1.length()==i || str2.length()==j) {
            return 0;

        }else if(dp[i][j]==-1){
            if(str1.charAt(i)==str2.charAt(j)){
                dp[i][j]=1+longestCommonSubsequenceHelper(str1,str2,i+1,j+1,dp);
            }else{
                dp[i][j]=Math.max(longestCommonSubsequenceHelper(str1,str2,i,j+1,dp),longestCommonSubsequenceHelper(str1,str2,i+1,j,dp));
            }
        }

        return dp[i][j];

    }


    // Palindromic Substrings efficient
    public static int countPalindromicSubstringsE(String s) {
        int count=0;
        boolean[][] dp=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
            count++;
        }

        // handloing two

        for(int i=0;i<s.length()-1;i++){
            dp[i][i+1]=(s.charAt(i)==s.charAt(i+1));
            count+=(dp[i][i+1])?1:0;
        }

        // hadling more then 3
        for(int len=3;len<=s.length();len++){
            for(int i=0,j=len-1; j<s.length();i++,j++){
                dp[i][j]= ((s.charAt(i)==s.charAt(j)) && dp[i+1][j-1]);
                count+=(dp[i][j])?1:0;
            }

        }


        return count;

    }
    // Palindromic Substrings



    public static int countPalindromicSubstrings(String s) {

        Set<String> hashset=new HashSet<>();
        int count=0;
        if(s.length()==1){
            return 1;
        }
        for(int i=1;i<= s.length();i++){
            for(int j=0;j<i;j++){
                String temp=s.substring(j,i);
                if(hashset.contains(temp)){
                    count++;
                }else if(isValidPalindrome(temp)){
                    hashset.add(temp);
                    count++;

                }
            }
        }

        // Replace this placeholder return statement with your code

        return count;
    }

    private static boolean isValidPalindrome(String temp) {

        int left=0;
        int right=temp.length()-1;
        while(left<right){
            if(temp.charAt(left)!=temp.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

//Word Break

    public static boolean wordBreak (String s, List<String> wordDict ) {
        int n=s.length();
        Set<String> wordset=new HashSet<>(wordDict);

        boolean[] dp=new boolean[n+1];
        dp[0]=true;

        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordset.contains(s.substring(j,i))){ // “If the string up to index j can be broken into valid words (dp[j] == true) AND the substring from j to i (s.substring(j, i)) is also a valid word, then the string up to i (dp[i]) is also breakable.”
                    dp[i]=true;
                    break;
                }
            }
        }


        // Replace this placeholder return statement with your code
        return dp[n];
    }


// Build up all combinations of numbers that sum to each value from 1 to target, iteratively (bottom-up), storing partial combinations at each step.

    // For each number from 1 to target, you're checking:
    //
    //“Can I build i by adding nums[j] to some smaller valid combination (i - nums[j])?”
    //
    //If yes, then add nums[j] to those combinations.
    public static List<List<Integer>> combinationSum(int[] nums, int target) {

        // Replace this placeholder return statement with your code
        List<List<List<Integer>>>  dp=new ArrayList<>(target+1);
        dp.add(new ArrayList<>());
        dp.get(0).add(new ArrayList<>());

        for(int i=1;i<target+1;i++){
            dp.add(new ArrayList<>());
            for(int j=0;j<nums.length;j++){
                if(i>=nums[j]){
                    for(List<Integer> prev:dp.get(i-nums[j])){
                        List<Integer> temp=new ArrayList<>(prev);
                        temp.add(nums[j]);
                        temp.sort(null);
                        if(!dp.get(i).contains(temp)){
                            dp.get(i).add(temp);
                        }

                    }

                }

            }
        }


        return dp.get(target);
    }


    public static int maxProduct(int [] nums) {

        int maxProduct=nums[0];
        int minProduct=nums[0];
        int result=nums[0];

        for(int i=1;i<nums.length;i++){

            int prevMaxProduct=maxProduct;
            maxProduct=Math.max(nums[i],Math.max(maxProduct*nums[i],minProduct*nums[i]));
            minProduct=Math.min(nums[i],Math.min(prevMaxProduct*nums[i],minProduct*nums[i]));
            result=Math.max(result,maxProduct);
        }
        // Replace this placeholder return statement with your code

        return result;
    }

    public static int houseRobber(int[] money) {

        if(money.length==0)
            return 0;

        if(money.length==1)
            return money[0];


        int maxFirst=calcualteArrayMaxSpace(Arrays.copyOfRange(money,0,money.length-1));
        int maxSecond=calcualteArrayMaxSpace(Arrays.copyOfRange(money,1,money.length));
        // Replace this placeholder return statement with your code
        return Math.max(maxFirst,maxSecond);
    }

    private static int calcualteArrayMax(int[] ints) {
        int[] dp=new int[ints.length+1];
        dp[0]=0;
        dp[1]=ints[0];
        for(int i=2;i<=ints.length;i++){
            int firstOption=ints[i-1]+dp[i-2];
            int secondOption=dp[i-1];
            dp[i]=Math.max(firstOption,secondOption);

        }
        return dp[ints.length];

    }



    private static int calcualteArrayMaxSpace(int[] ints) {

        int prev=0;
        int curr=ints[0];
        for(int i=1;i<ints.length;i++){
            int firstOption=ints[i]+prev;
            int secondOption=curr;
            curr=Math.max(firstOption,secondOption);
            prev=secondOption;

        }
        return curr;

    }


    // 01 Matrix
    public static int[][] updateMatrix(int[][] mat) {

        // Replace this placeholder return statement with your code


        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] > 0) {
                    int up = (i > 0) ? mat[i - 1][j] : Integer.MAX_VALUE;
                    int left = (j > 0) ? mat[i][j - 1] : Integer.MAX_VALUE;
                    mat[i][j] = Math.min(up, left) + 1;
                }
            }
        }


        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (mat[i][j] > 0) {
                    int bottom = (i < n - 1) ? mat[i + 1][j] : Integer.MAX_VALUE;
                    int right = (j < m - 1) ? mat[i][j + 1] : Integer.MAX_VALUE;

                    int minDist = Math.min(bottom, right) + 1;
                    mat[i][j] = Math.min(mat[i][j], minDist);


                }
            }
        }

        return mat;
    }

    // countingBits
    public static int[] countingBits(int n) {
        // Replace this placeholder return statement with your code
        int[] dp=new int[n+1];

        dp[0]=0; // 1
        dp[1]=1;  // 2
        for(int i=2;i<=n;i++){
            if(i%2==0){
                dp[i]=dp[i/2];
            }else{
                dp[i]=dp[i/2]+1;
            }

        }


        return dp;
    }


    // Partition Equal Subset Sum
    public static boolean canPartitionArrayBottomUp(int[] arr) {
        // Replace this placeholder return statement with your code
        int sum= Arrays.stream(arr).sum();
        if(sum%2!=0)
            return false;

        int target=sum/2;

        boolean[][] dp=new boolean[arr.length+1][target+1]; // dp[i][j] == true means: "There exists a subset among the first j numbers that sums to i."
        // Rows (i) as different target sums you're trying to build.
        //Columns (j) as gradually increasing your available toolbox of numbers

        for(int i=0;i<=arr.length;i++ ){
            dp[i][0 ]=true;
        }


        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=target;j++){
                boolean exclude=dp[i-1][j];
                // “Is the current target sum j big enough to include the current number nums[i - 1]?”  if nums[-1]
                boolean include= (j >= arr[i-1])?dp[i-1][j-arr[i-1]]:false;                                        // ✅ Include the current element → can we make the reduced sum j - nums[i-1] from the previous row? → dp[i-1][j - nums[i-1]];
                dp[i][j]=exclude || include;
            }

        }
        return dp[arr.length][target];
    }


    public static boolean canPartitionArrayBottomUpEfficnt(int[] arr) {
        // Replace this placeholder return statement with your code
        int sum= Arrays.stream(arr).sum();
        if(sum%2!=0)
            return false;

        int target=sum/2;

        boolean[] dp=new boolean[target+1]; // dp[i][j] == true means: "There exists a subset among the first j numbers that sums to i."
        // Rows (i) as different target sums you're trying to build.
        //Columns (j) as gradually increasing your available toolbox of numbers
        dp[0]=true;


        for(int i=0;i<arr.length;i++){
            for(int j=target;j>=arr[i];j--){                                                       // ✅ Include the current element → can we make the reduced sum j - nums[i-1] from the previous row? → dp[i-1][j - nums[i-1]];
                dp[j]= dp[j] || dp[j-arr[i]];
            }

        }
        return dp[target];
    }



    // Partition Equal Subset Sum
    public static boolean canPartitionArray(int[] arr) {
        // Replace this placeholder return statement with your code
        int sum= Arrays.stream(arr).sum();
        if(sum%2!=0)
            return false;

        int target=sum/2;

        Boolean[][] memo=new Boolean[arr.length][target+1];
        return canPartitionArrayTopDown(arr,0,target,memo);

    }



// Can I pick a subset of numbers that add up to target = sum / 2? Try both including and excluding each number.

    /*
    (0, 11)
├── include 1 → (1, 10)
│   ├── include 5 → (2, 5)
│   │   ├── include 5 → (3, 0) ✅ FOUND
│   │   └── exclude 5 → (3, 5)
│   │       ├── include 11 → (4, -6)
│   │       └── exclude 11 → (4, 5) ❌
│   └── exclude 5 → (2, 10)
│       ├── include 5 → (3, 5)  ✅ REPEATED!
│       └── exclude 5 → (3, 10)
├── exclude 1 → (1, 11)
    ├── include 5 → (2, 6)
    ├── exclude 5 → (2, 11)

     */
    private static boolean canPartitionArrayTopDown(int[] arr, int index, int target,Boolean[][] cache) {
        if(target==0)
               return true;

        if(target<0 || index>= arr.length)
                return false;

        if(cache[index][target]!=null)  // We are caching the result of whether it's possible to make a given target sum using elements from a certain index onward.
            return cache[index][target];

        boolean include=canPartitionArrayTopDown(arr,index+1,target-arr[index],cache);
        boolean exlude=canPartitionArrayTopDown(arr,index+1,target,cache);

        cache[index][target]=include || exlude;

        return cache[index][target];
    }

    public static int findTribonacciBottomUp(int n) {
        // N-th Tribonacci Number

        if (n == 3)
            return n==0?0:1;

        int firstNum=0;
        int secondNum=1;
        int thirdNum=1;
        int temp;
        for(int i=3;i<=n;i++){
            temp=firstNum+secondNum+thirdNum;
            firstNum=secondNum;
            secondNum=thirdNum;
            thirdNum=temp;

        }
        return thirdNum;

    }

    public static int findTribonacciTopDowm(int n) {


        int[] tribnoci=new int[n+1];
        Arrays.fill(tribnoci,-1);
        return calculateTribonncciValue(n,tribnoci);
    }

    private static int calculateTribonncciValue(int n, int[] dp) {

        if(n==0)
            return 0;
        if(n==1 || n==2)
            return 1;

        if(dp[n]!=-1){
            return dp[n];
        }
            dp[n]=calculateTribonncciValue(n-1,dp)+calculateTribonncciValue(n-2,dp)+calculateTribonncciValue(n-3,dp);

         return dp[n];

    }

    // Knapsack
    public static int findMaxKnapsackProfit(int capacity, int [] weights, int [] values){
        int n=weights.length;
        int[] dp=new int[capacity+1];

        Arrays.fill(dp,0);

        for (int i = 0; i < n; i++) {
            int currWeight = weights[i];
            int currValue = values[i];

            // Go backwards to avoid using the same item more than once
            for (int j = capacity; j >= currWeight; j--) {
                // Check if including current item gives a better value
                dp[j] = Math.max(dp[j], currValue + dp[j - currWeight]);  //  dp[j - currWeight] “If I spend currWeight space on this item, how much value can I get in the remaining space?”  dp[j - currWeight] tells you “How good was the bag before this item took up currWeight space?”
            }
        }
        return dp[capacity];
    }


    public static int coinChange(int [] coins, int total) {

        if(total<1)
            return 0;

        int[] counter=new int[total+1];
        Arrays.fill(counter,Integer.MAX_VALUE);

        return calculateMinumCoinTopDown(coins,total,counter);
    }


    /*.

    calc(5)
├── coin 1 → calc(4)
│   ├── coin 1 → calc(3)
│   │   ├── coin 1 → calc(2)
│   │   │   ├── coin 1 → calc(1)
│   │   │   │   ├── coin 1 → calc(0) ✅ returns 0
│   │   │   │   └── coin 2 → calc(-1) ❌ invalid
│   │   │   └── coin 2 → calc(0) ✅ returns 0
│   │   └── coin 2 → calc(1) [already seen]
│   └── ...
├── coin 2 → calc(3) [will be memoized later]
└── coin 5 → calc(0) ✅ base case — return 0

     */
    private static int calculateMinumCoinTopDown(int[] coins, int remainingAmount, int[] counter) {
        if(remainingAmount<0)
            return -1;
        if(remainingAmount==0)
            return 0;

        if(counter[remainingAmount]!=Integer.MAX_VALUE)
            return counter[remainingAmount];

        int minumum=Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++){

            int result=calculateMinumCoinTopDown(coins, remainingAmount-coins[i],counter);
            if(result>=0 && result<minumum){
                minumum=1+result;
            }
        }

        if(minumum!=Integer.MAX_VALUE){
            counter[remainingAmount]=minumum;
        }else{
            counter[remainingAmount]=-1;
        }

        return counter[remainingAmount];

    }

/*

| Amount (i) | dp\[i] | Explanation                                 |
| ---------- | ------ | ------------------------------------------- |
| 0          | 0      | Base case                                   |
| 1          | 1      | min(dp[1], dp\[1-1]+1) = 0+1              dp[1]=infintee         |
| 2          | 1      | min(dp\[2-1]+1, dp\[2-2]+1) = 1,1 → 1       |
| 3          | 1      | min(dp\[3-1]+1, dp\[3-2]+1, dp\[3-3]+1) = 1 |
| 4          | 2      | min(dp\[3]+1, dp\[2]+1, dp\[1]+1) = 1+1 = 2 |
| 5          | 2      | min(dp\[4]+1, dp\[3]+1, dp\[2]+1) = 2       |

✔️ Inner loop direction → tells if items are reusable
✔️ Min or Max → tells what you're optimizing
✔️ Transition formula → the specific recurrence relation
✔️ Initialization (e.g., dp[0] = 0, others ∞ or 0)

 */
    public static int calculateMinumCoinTopDown(int[] coins,int total){

        int[] dp=new int[total+1];
        Arrays.fill(dp,total+1); // use Total+1 as infinity

        dp[0]=0; // base case

        for(int amount=1;amount<=total;amount++){
            for(int coin:coins){
                if(coin<=amount)
                    dp[amount]=Math.min(dp[amount],1+dp[amount-coin]);  //  "To make up amount, either keep the current best, or use one more coin after making amount - coin."
            }

        }
        return dp[total]>total?-1:dp[total];
    }

    /*.
    *| Part                    | Meaning                                             |
| ----------------------- | --------------------------------------------------- |
| `dp[amount]`            | Current known minimum coins to make this amount     |
| `dp[amount - coin] + 1` | If we use this coin, how many total coins we'd need |
| `Math.min(...)`         | Pick the better (smaller) option                    |

    * */


}
