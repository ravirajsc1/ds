package ravi.algo.concepts;


import java.util.*;

import static java.util.Collections.swap;
/*
| Time Complexity | Type                        | Example Problems                                                        |
| --------------- | --------------------------- | ----------------------------------------------------------------------- |
| `2^n`           | Subset / Binary Choice      | Subsets, Letter Case Permutation, Generate Parentheses, Climbing Stairs |
| `n!`            | Permutations / Arrangements | Permutations, Anagram, N-Queens, TSP                                    |

 */
public class Subset {

    public static void main(String[] args) {
        int[][] inputSets = {
                {},
                {2, 5, 7},
                {1, 2},
                {1, 2, 3, 4},
                {7, 3, 1, 5}
        };

        for (int i = 0; i < inputSets.length; i++) {
            int[] set = inputSets[i];
            System.out.println((i + 1) + ". Set: " + Arrays.toString(set));
            List<List<Integer>> subsets = findAllSubsets(set);
            System.out.println("   Subsets: " + subsets);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        String[] inputWord = {"ab", "bad", "abcd"};
        for (int index = 0; index < inputWord.length; index++)
        {
            ArrayList <String> permutedWords = permuteWord(inputWord[index]);
            System.out.println(index + 1 + ".\t Input string: '" + inputWord[index] + "'");
            System.out.println("\t All possible permutations are: " + permutedWords);

        }



        String[] digitsArray = {"23", "73", "426", "78", "925", "2345"};
        for(int i = 0; i < digitsArray.length; i++){
            System.out.println((i + 1)+ ".\tAll letter combinations for  "+digitsArray[i]+ ": "+ letterCombinations(digitsArray[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        ArrayList<String> result = new ArrayList<String>();
        int[] n = {1, 2, 3, 4, 5};
        for (int i = 0; i < n.length; i++) {

            System.out.println (i+1 + ".\tn = "+ n[i]);
            System.out.println ("\tAll combinations of valid balanced parentheses:");
            result = generateCombinations(n[i]);
            for (int j = 0; j < result.size(); j++) {
                System.out.println("\t\t" + result.get(j));
            }
           // System.out.println(PrintHyphens.repeat("-", 100));
        }


    }


    /*
backtrack(0, "")                        // index = 0, digit = '2'
├── append 'a' → path = "a"
│   └── backtrack(1, "a")              // index = 1, digit = '3'
│       ├── append 'd' → path = "ad"
│       │   └── backtrack(2, "ad") → ✅ add "ad"
│       │   └── delete 'd' → path = "a"
│       ├── append 'e' → path = "ae"
│       │   └── backtrack(2, "ae") → ✅ add "ae"
│       │   └── delete 'e' → path = "a"
│       ├── append 'f' → path = "af"
│       │   └── backtrack(2, "af") → ✅ add "af"
│       │   └── delete 'f' → path = "a"
│   └── delete 'a' → path = ""
├── append 'b' → path = "b"
│   └── backtrack(1, "b")              // index = 1, digit = '3'
│       ├── append 'd' → path = "bd"
│       │   └── backtrack(2, "bd") → ✅ add "bd"
│       │   └── delete 'd' → path = "b"
│       ├── append 'e' → path = "be"
│       │   └── backtrack(2, "be") → ✅ add "be"
│       │   └── delete 'e' → path = "b"
│       ├── append 'f' → path = "bf"
│       │   └── backtrack(2, "bf") → ✅ add "bf"
│       │   └── delete 'f' → path = "b"
│   └── delete 'b' → path = ""
├── append 'c' → path = "c"
│   └── backtrack(1, "c")              // index = 1, digit = '3'
│       ├── append 'd' → path = "cd"
│       │   └── backtrack(2, "cd") → ✅ add "cd"
│       │   └── delete 'd' → path = "c"
│       ├── append 'e' → path = "ce"
│       │   └── backtrack(2, "ce") → ✅ add "ce"
│       │   └── delete 'e' → path = "c"
│       ├── append 'f' → path = "cf"
│       │   └── backtrack(2, "cf") → ✅ add "cf"
│       │   └── delete 'f' → path = "c"
│   └── delete 'c' → path = ""

     */


    public static List<String> letterCombinations(String digits){

        List<String> combinations=new ArrayList<>();
        if(digits.length()==0)
            return combinations;

        // Replace this placeholder return statement with your code
        Map<Character, String[]> digitsMapping = new HashMap<>();
        digitsMapping.put('1', new String[]{""});
        digitsMapping.put('2', new String[]{"a", "b", "c"});
        digitsMapping.put('3', new String[]{"d", "e", "f"});
        digitsMapping.put('4', new String[]{"g", "h", "i"});
        digitsMapping.put('5', new String[]{"j", "k", "l"});
        digitsMapping.put('6', new String[]{"m", "n", "o"});
        digitsMapping.put('7', new String[]{"p", "q", "r", "s"});
        digitsMapping.put('8', new String[]{"t", "u", "v"});
        digitsMapping.put('9', new String[]{"w", "x", "y", "z"});

        backtrack(0,new StringBuilder(),digits,digitsMapping,combinations);


        return combinations;
    }


    /*
    backtrack(2, 0, 0, [])
├── add '(' → output = ['(']
│   └── backtrack(2, 1, 0, ['('])
│       ├── add '(' → output = ['(', '(']
│       │   └── backtrack(2, 2, 0, ['(', '('])
│       │       ├── add ')' → output = ['(', '(', ')']
│       │       │   └── backtrack(2, 2, 1, ['(', '(', ')'])
│       │       │       ├── add ')' → output = ['(', '(', ')', ')']
│       │       │       │   └── ✅ Base case → add "(())"
│       │       │       └── remove ')' → output = ['(', '(', ')']
│       │       └── remove ')' → output = ['(', '(']
│       └── remove '(' → output = ['(']
│       ├── add ')' → output = ['(', ')']
│       │   └── backtrack(2, 1, 1, ['(', ')'])
│       │       ├── add '(' → output = ['(', ')', '(']
│       │       │   └── backtrack(2, 2, 1, ['(', ')', '('])
│       │       │       ├── add ')' → output = ['(', ')', '(', ')']
│       │       │       │   └── ✅ Base case → add "()()"
│       │       │       └── remove ')' → output = ['(', ')', '(']
│       │       └── remove '(' → output = ['(', ')']
│       └── remove ')' → output = ['(']
└── remove '(' → output = []


    * */

    public static ArrayList<String> generateCombinations(int n) {

        // Replace this placeholder return statement with your code

        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Character> output=new ArrayList<>();
        backtrakParam(n,0,0,output,result);

        return result;
    }

    private static void backtrakParam(int n, int leftCounter,int rightCounter, ArrayList<Character> output, ArrayList<String> result) {

        // Base case where count of left and right braces is n
        if(leftCounter>=n && rightCounter>=n){
            String outputStr=output.toString();
            result.add(outputStr.substring(1,outputStr.length()-1).replace(", ",""));
        }

        // Case where we can still add left braces

        if(leftCounter<n){
            output.add('(');
            backtrakParam(n,leftCounter+1,rightCounter,output,result);
            output.remove(output.size()-1);
        }



        // Case where we add right braces if the current count
        // of right braces is less than the count of left braces
        if(rightCounter<leftCounter){
            output.add(')');
            backtrakParam(n,leftCounter,rightCounter+1,output,result);
            output.remove(output.size()-1);
        }

    }


    private static void backtrack(int index, StringBuilder path, String digits, Map<Character, String[]> digitsMapping, List<String> combinations) {

        if(path.length()==digits.length()){
            combinations.add(path.toString());
            return;
        }

        char digit=digits.charAt(index);
        for(String strDigit : digitsMapping.get(digit)){
            path.append(strDigit);
            backtrack(index+1,path,digits,digitsMapping,combinations);
            path.deleteCharAt(path.length()-1);
        }

    }


    // permuation

    /*
    * permuteStringRec("ABC", 0)
 ├── swap(0,0) → "ABC"
 │   ├── swap(1,1) → "ABC" → ✅
 │   └── swap(1,2) → "ACB" → ✅
 ├── swap(0,1) → "BAC"
 │   ├── swap(1,1) → "BAC" → ✅
 │   └── swap(1,2) → "BCA" → ✅
 └── swap(0,2) → "CBA"
     ├── swap(1,1) → "CBA" → ✅
     └── swap(1,2) → "CAB" → ✅
     *
     *
   permuteStringRec("ABC", 0)
├── swap(0,0) → "ABC"
│   └── permuteStringRec("ABC", 1)
│       ├── swap(1,1) → "ABC"
│       │   └── permuteStringRec("ABC", 2) → ✅ Add "ABC"
│       └── swap(1,2) → "ACB"
│           └── permuteStringRec("ACB", 2) → ✅ Add "ACB"
├── swap(0,1) → "BAC"
│   └── permuteStringRec("BAC", 1)
│       ├── swap(1,1) → "BAC"
│       │   └── permuteStringRec("BAC", 2) → ✅ Add "BAC"
│       └── swap(1,2) → "BCA"
│           └── permuteStringRec("BCA", 2) → ✅ Add "BCA"
└── swap(0,2) → "CBA"
    └── permuteStringRec("CBA", 1)
        ├── swap(1,1) → "CBA"
        │   └── permuteStringRec("CBA", 2) → ✅ Add "CBA"
        └── swap(1,2) → "CAB"
            └── permuteStringRec("CAB", 2) → ✅ Add "CAB"

*
    * */

    public static ArrayList<String> permuteWord(String word) {
        ArrayList<String> result=new ArrayList<>();
        // Replace this placeholder return statement with your code
        permuteStringRec(word,0,result);

        return result;
    }

    private static void permuteStringRec(String word, int currentIndex, ArrayList<String> result) {

        if(currentIndex==word.length()-1){
            result.add(word);
            return;
        }

         for(int index=currentIndex;index<word.length();index++){
                String swappedWord=swapChar(word,currentIndex,index);
                permuteStringRec(swappedWord,currentIndex+1,result);

          }

    }

    private static String swapChar(String word, int currentIndex, int index) {
        char[] chars=word.toCharArray();

        char temp=chars[currentIndex];
        chars[currentIndex]=chars[index];
        chars[index]=temp;

        return new String(chars);
    }


    /*


    1 << j gives you a number where only the j-th bit is 1, and all others are 0.


| `i` | Binary | getBit(i, 0) | getBit(i, 1) | getBit(i, 2) | Subset      |
| --- | ------ | ------------ | ------------ | ------------ | ----------- |
| 0   | `000`  | 0            | 0            | 0            | `[]`        |
| 1   | `001`  | 1 (✔ 5)      | 0            | 0            | `[5]`       |
| 2   | `010`  | 0            | 1 (✔ 7)      | 0            | `[7]`       |
| 3   | `011`  | 1 (✔ 5)      | 1 (✔ 7)      | 0            | `[5, 7]`    |
| 4   | `100`  | 0            | 0            | 1 (✔ 9)      | `[9]`       |
| 5   | `101`  | 1 (✔ 5)      | 0            | 1 (✔ 9)      | `[5, 9]`    |
| 6   | `110`  | 0            | 1 (✔ 7)      | 1 (✔ 9)      | `[7, 9]`    |
| 7   | `111`  | 1 (✔ 5)      | 1 (✔ 7)      | 1 (✔ 9)      | `[5, 7, 9]` |

 sss
| `j` | `(1 << j)` (Decimal) | `(1 << j)` (Binary) | `i & (1 << j)` (Binary) | Result | Bit Set?                        |
| --- | -------------------- | ------------------- | ----------------------- | ------ | ------------------------------- |
| 0   | 1                    | 0001                | 0001                    | 1      | ✅ Yes (`nums[0]` included)      |
| 1   | 2                    | 0010                | 0000                    | 0      | ❌ No (`nums[1]` skipped)        |
| 2   | 4                    | 0100                | 0100                    | 4      | ✅ Yes (`nums[2]` included)      |
| 3   | 8                    | 1000                | 0000                    | 0      | ❌ No (`nums[3]` does not exist) |

(1 << j) is the same as 2^j, both in meaning and in value.

    ✅ High-Level Explanation in Simple Language:
    Yes — the outer loop (i) goes through all possible combinations of subsets (there are 2^n total).

    And the inner loop (j) checks each element in the original array to decide whether or not to include it in the current subset, based on the binary representation of i.
    ✅ What’s happening exactly:
Every value of i (from 0 to 2^n - 1) represents one subset.

The binary form of i tells us which elements to include in the subset:

If bit at position j is 1, include nums[j]

If bit at position j is 0, skip nums[j]

So getBit(i, j) is just checking if the j-th bit in i is 1 or 0.

    ✅ Summary:
Expression	What it does	Example (bit = 2)	Result
1 << bit	Makes a bitmask with only bit-th bit ON	1 << 2 → 0100	4

    SO we are

    */


    public static List<List<Integer>> findAllSubsets(int[] nums) {

        // Replace this placeholder return statement with your code
        List<List<Integer>> setsList = new ArrayList<>();
       if(nums.length!=0){
        int totalSubset=(int)Math.pow(2,nums.length);
        for(int i=0;i<totalSubset;i++){
            List<Integer> subset=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if(getBit(i,j)==1){
                    subset.add(nums[j]);
                }
            }
            setsList.add(subset);

        }
       }else{
           List<Integer> emptylist=new ArrayList<>();
           setsList.add(emptylist);

       }


        return setsList;
    }

    private static int getBit(int subset, int elmentinSubset) {

        int temp=(1<<elmentinSubset);
        temp= temp & subset;
        if(temp==0){
            return 0;
        }

        return 1;
    }


}
