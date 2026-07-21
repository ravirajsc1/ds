package ravi.algo.concepts;

import java.util.*;

public class KnowingWhatTrack {

    public static void main(String[] args) {

        //  Palindrome Permutation

        List < String > strArray = Arrays.asList("baefeab", "abc", "xzz", "jjadd", "kllk");
        for (int i = 0; i < strArray.size(); i++) {
            System.out.println(i + 1 + ".\tInput string: " + strArray.get(i));
            boolean result = permutePalindrome(strArray.get(i));
            if (result) System.out.println("\n\tInput string has permutations that are palindromes");
            else System.out.println("\n\tInput string does not have a permutation that's a palindrome");
          //  System.out.println(PrintHyphens.repeat("-", 100));
        }

        // Valid Anagram


        String[] str1List = {"listen", "race", "elbow", "cat", "inch"};
        String[] str2List = {"silent", "cares", "below", "act", "chin"};

        for (int i = 0; i < str1List.length; i++) {
            System.out.print((i + 1) + ".");
            System.out.println("\tstr1: \"" + str1List[i] + "\"");
            System.out.println("\tstr2: \"" + str2List[i] + "\"");
            System.out.println("\t\"" + str2List[i] + "\" is an anagram of \"" + str1List[i] + "\": "
                    + isAnagram(str1List[i], str2List[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }



        //Design Tic-Tac-Toe

        int n = 3;
        System.out.println("Initial state of " + n + " X " + n + " Tic-Tac-Toe board:");
    //    TicTacToe ticTacToe = new TicTacToe(n);
        int win = 0;

        //Group Anagrams

        String[][]titles = {
                {"eat", "beat", "neat", "tea"},
                {"duel", "dule", "speed", "spede", "deul", "cars"},
                {"eat", "tea", "tan", "ate", "nat", "bat"},
                {""},
                {"sword", "swords"}, {"pot", "top", "opt"}};

        for(int i = 0; i < titles.length; i++){
            System.out.print(i + 1);
            System.out.println(".\tThe Grouped Anagrams for the list " + Arrays.toString(titles[i]) + " are:");

            List<List<String>> gt = groupAnagrams(titles[i]);
            System.out.println("\t" + gt);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //Maximum Frequency Stack
            //FreqStack
        //First Unique Character in a String

        String[] string1 = {
                "baefeab",
                "aabbcc",
                "dajhfiuebdafsdhdgaj",
                "xyurtwxwtryua",
                "aeiouqwertyauieotweryqq",
                "awsjuhfajwfnkag"
        };

        for (int i = 0; i < string1.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tString = '" + string1[i] + "'");
            System.out.println("\tFinding a unique character...");
            System.out.println("\tIndex of the first unique character is: " + firstUniqueChar(string1[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //Find All Anagrams in a String

        String[] A = {"abab", "cbaebabacd", "cefecf", "hello", "bro"};
        String[] B = {"ab", "abc", "efc", "olleh", "bro"};
        for (int i = 0; i<A.length; i++) {
            System.out.println((i + 1) + ".\tString a: \"" + A[i] + "\"");
            System.out.println("\tString b: \"" + B[i] + "\"");
            System.out.println("\tAnagrams of string b start at index(es) " + findAnagrams(A[i], B[i]) + " in string a.");
         //   System.out.println(PrintHyphens.repeat("-", 100));
        }

    }

    // Find All Anagrams in a String

    public static List<Integer> findAnagrams(String a, String b) {

        // Replace this placeholder return statement with your code
        return new ArrayList<>();
    }

    //First Unique Character in a String
    public static int firstUniqueChar(String s) {
        Map<Character,Integer> freq=new HashMap<>();
        for(char ch:s.toCharArray())
            freq.put(ch,freq.getOrDefault(ch,0)+1);

        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        // Replace this placeholder return statement with your code
        return -1;
    }

    //Maximum Frequency Stack



    // Group Anagrams

    public static List<List<String>> groupAnagrams(String[] strs){

        Map<String,List<String>> freq=new HashMap<>();


        for(String str:strs){
            int[] valmap=new int[26];
            for(char ch:str.toCharArray()){
                valmap[ch-'a']+=1;
            }
            StringBuilder sb = new StringBuilder();
            for (int count : valmap) {
                sb.append(count).append('#');
            }
            freq.computeIfAbsent(sb.toString(),
                    x->new ArrayList<>()).add(str);

        }

        List<List<String>> list=new ArrayList<>();
        for(List<String> sublist: freq.values()){
            list.add(sublist);
        }

        return list;
    }


    //Design Tic-Tac-Toe



    // Valid Anagram

    public static boolean isAnagram(String str1, String str2) {

        Map<Character,Integer> freq=new HashMap<>();
        for(char ch:str1.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);

        }

        for(char ch:str2.toCharArray()){
            if(freq.containsKey(ch)){
                if(freq.get(ch)<=1){
                    freq.remove(ch);
                }else{
                    freq.put(ch,freq.get(ch)-1);
                }
            }


        }
        return freq.size()==0;
    }

    // Palindrome Permutation

    public static boolean permutePalindrome(String st) {
        int oddCount=0;
        Map<Character,Integer> freq=new HashMap<>();
        for(char ch:st.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);

        }

        for(Integer val: freq.values()){

            if(oddCount>1){
                return false;

            }
            if(val%2==1){
                 oddCount++;
            }
        }

        return true;
    }


}
