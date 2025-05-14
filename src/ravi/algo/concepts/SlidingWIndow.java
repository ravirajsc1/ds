package ravi.algo.concepts;

import java.util.*;
import java.util.stream.Stream;

public class SlidingWIndow {
    public static void main(String[] args) {




        //A DNA sequence consists of nucleotides represented by the letters ‘A’, ‘C’, ‘G’, and ‘T’ only. For example, “ACGAATTCCG” is a valid DNA sequence.
        List<String> testCases = Arrays.asList(
                "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
                "AAAAAAAAAAAAA",
                "ACGTACGTACGTACGTACGTACGTACGTACGT",
                "GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG",
                "GTACGTACGTACGCCCCCCCCGGGGG"
        );

        for (int i = 0; i < testCases.size(); i++) {
            System.out.println((i + 1) + ".\tInput: \"" + testCases.get(i) + "\"");
            System.out.println("\n\tInitial Rolling Hash: " + findRepeatedDnaSequences(testCases.get(i)));
            System.out.println("-" + new String(new char[100]).replace('\0', '-') + "\n");
        }

        //  Sliding Window Maximum Given an integer list, nums, find the maximum values in all the contiguous subarrays (windows) of size w.

        int windowSizes [] = {3, 3, 3, 3, 2, 4, 3, 2, 3, 6};
        int [][] numLists = {
                {2,5,3,6,7,4,1,10},
                {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                {1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30},
                {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67},
                {4, 5, 6, 1, 2, 3},
                {9, 5, 3, 1, 6, 3},
                {2, 4, 6, 8, 10, 12, 14, 16},
                {-1, -1, -2, -4, -6, -7},
                {4, 4, 4, 4, 4, 4}
        };

        for (int i = 0; i < numLists.length; i++) {
            System.out.println(i + 1 + ".\tInput array:\t" + Arrays.toString(numLists[i]));
            System.out.println("\tWindow size:\t" + windowSizes[i]);
            System.out.println("\n\tMaximum in each sliding window:\t" + Arrays.toString(findMaxSlidingWindow(numLists[i], windowSizes[i])));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }

        // Minimum Window Subsequence Given two strings, str1 and str2, find the shortest substring in str1 such that str2 is a subsequence of that substring.
        // Driver code
        String[] str1 = {
                "aaaaaaaaaa", "abcdebdde", "zxcvnhss", "alpha", "beta"
        };

        String[] str2 = {
                "aa", "bde", "css", "la", "ab"
        };
        for (int i = 0; i < str1.length; i++) {
            System.out.println(i + 1 + ".\tInput String: " + "(" + str1[i] + ", " + str2[i] + ")");
            System.out.println("\tSubsequence string: " + minWindow(str1[i], str2[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //Longest Repeating Character Replacement
//aaacbbbaabab
        List<String> inputStrings = Arrays.asList("aaaaaaaaaa", "abbcb", "abccde", "abbcab", "bbbbbbbbb");
        List<Integer> k = Arrays.asList(2, 1, 1, 2, 4);

        for (int i = 0; i < inputStrings.size(); ++i) {
            System.out.println((i + 1) + ".\tInput String: '" + inputStrings.get(i) + "'");
            System.out.println("\tk: " + k.get(i));
            System.out.println("\tLength of the longest substring with repeating characters: "
                    + longestRepeatingCharacterReplacement(inputStrings.get(i), k.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
            System.out.println("\tLength of the longest substring with repeating characters: "
                    + longestRepeatingCharacterReplacementBetter(inputStrings.get(i), k.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

    }
    //Longest Repeating Character Replacement
    public static int longestRepeatingCharacterReplacementBetter(String s, int k) {
        // Replace this placeholder return statement with your code
        int stringLength=s.length();
        int lengthfMaxSubstring=0;
        int start=0;
        Map<Character, Integer> charFreq = new HashMap<>();
        int mostFreqChar = 0;
        for (int end = 0; end < stringLength; ++end) {
            char currentChar = s.charAt(end);
            charFreq.put(currentChar,charFreq.getOrDefault(currentChar,0)+1);
            mostFreqChar=Math.max(mostFreqChar, charFreq.get(currentChar));
            if(end-start+1 -mostFreqChar > k){
                charFreq.put(s.charAt(start),charFreq.get(s.charAt(start))-1);
                start++;
            }
            lengthfMaxSubstring=Math.max(lengthfMaxSubstring,end-start+1);

        }
        return lengthfMaxSubstring;

    }

    //Longest Repeating Character Replacement
    public static int longestRepeatingCharacterReplacement(String s, int k) {
        // Replace this placeholder return statement with your code

        int longestStringLenth=0;
        int mostfrequent=0;
        int start=0,end=0;
        Map<Character,Integer> map=new HashMap<>();
        while(end<s.length()){


            longestStringLenth=mostfrequent+k;
            if(longestStringLenth>s.length()){
                longestStringLenth=s.length();
            }

            if(end-start>longestStringLenth){
                int oldCount=map.get(s.charAt(start))-1;
                if(oldCount>0) {
                    map.put(s.charAt(start), oldCount);
                }else{
                    map.remove(s.charAt(start));
                }
                start++;
            }
            if(map.get(s.charAt(end))==null){
                map.put(s.charAt(end),1);
                if(mostfrequent<1){
                    mostfrequent=1;
                }

            }else{


                //add new count
                int newCount =0;
                if(map.get(s.charAt(end))!=null) {
                    newCount = map.get(s.charAt(end)) + 1;
                    map.put(s.charAt(end), newCount);
                }
                // remove old count


                if(newCount>mostfrequent){
                    mostfrequent=newCount;
                }

            }


            end++;




        }
        return longestStringLenth;
    }


    // Minimum Window Subsequence Given two strings, str1 and str2, find the shortest substring in str1 such that str2 is a subsequence of that substring.
    // Driver code

    public static String minWindowB(String str1, String str2) {
        int sizeStr1 = str1.length();
        int sizeStr2 = str2.length();


        float minSubLen = sizeStr1+1;
        String minSubsequence = "";
        int start=0,end=0;
        int s1Index=0,s2Index=0;
        while(s1Index<sizeStr1){
            if(str1.charAt(s1Index)==str2.charAt(s2Index)) {
                s2Index++;

                if(s2Index==sizeStr2) {
                    start=s1Index;
                    end=s1Index;
                    s2Index--;
                    while(s2Index>=0) {
                        if(str1.charAt(start)==str2.charAt(s2Index)) {
                            s2Index--;
                        }
                        start--;
                    }
                    start++;

                   if(end-start+1<minSubLen){
                        minSubLen=end-start+1;
                        minSubsequence=str1.substring(start,end+1);
                    }
                    s1Index=start;
                    s2Index=0;


                }

            }

            s1Index++;
        }


        return minSubsequence;
    }

    // Minimum Window Subsequence Given two strings, str1 and str2, find the shortest substring in str1 such that str2 is a subsequence of that substring.
    // Driver code
    public static String minWindow(String s, String t) {
        char[] s1chars=s.toCharArray();
        char[] s2chars=t.toCharArray();
        List<String> listOfString=new ArrayList<>();



        int s1Index=0,s2Index=0;
        while(s1Index<s1chars.length){


            int start=0,end=0;
            if(s1chars[s1Index]==s2chars[s2Index]) {
                if(s2Index==s2chars.length-1) {
                    start=s1Index-1;
                    end=s1Index;
                    s2Index--;
                    while(s2Index>=0) {
                        if(s1chars[start]==s2chars[s2Index]) {
                            s2Index--;
                        }
                        start--;
                    }

                    listOfString.add(s.substring(start+1,end+1));
                    s1Index=start+1;
                    s2Index=0;


                }else {
                    s2Index++;
                }



            }

            s1Index++;




        }


        int min=s.length();
        String minString="";
        for(String str:listOfString){
           if(min>=str.length()){
               min=str.length();
               minString=str;
           }
        }


        // Replace this placeholder return statement with your code

        return minString;
    }


//  Sliding Window Maximum Given an integer list, nums, find the maximum values in all the contiguous subarrays (windows) of size w.
    public static int[] findMaxSlidingWindow(int[] nums, int w) {


        Deque<Integer> currentWindow=new ArrayDeque<>();

        int[] output=new int[nums.length-w+1];

        for(int current=0;current<w;current++){
              currentWindow=  cleanup(current,currentWindow,nums);
              currentWindow.add(current);
        }

        output[0]=nums[currentWindow.getFirst()];


        for(int current=w;current<nums.length;current++){

            cleanup(current,currentWindow,nums);
            if(!currentWindow.isEmpty() && currentWindow.getFirst()<= (current-w)){
                currentWindow.removeFirst();
            }
            currentWindow.add(current);
          output[current-w+1]=nums[currentWindow.getFirst()];
        }


        // Replace this placeholder return statement with your code

        return output;
    }

    private static Deque<Integer> cleanup(int i,Deque<Integer> currentWindow,int[] nums) {

        while(currentWindow.size()!=0 && nums[i]>= nums[currentWindow.getLast()]){
            currentWindow.removeLast();
        }
        return currentWindow;

    }


    //A DNA sequence consists of nucleotides represented by the letters ‘A’, ‘C’, ‘G’, and ‘T’ only. For example, “ACGAATTCCG” is a valid DNA sequence.

    public static List<String> findRepeatedDnaSequences(String s) {

        // Replace this placeholder return statement with your code
        Map<Character,Integer> toInt=new HashMap<>();
        toInt.put('A', 0);
        toInt.put('C', 1);
        toInt.put('G', 2);
        toInt.put('T', 3);

        List<Integer> ecodeSequence=new ArrayList<>();
        char[] chars=s.toCharArray();
        for(Character c:chars){
            ecodeSequence.add(toInt.get(c));
        }

        int h=0;
        int a=4;
        int a_k=1;
        int k=10;
        int n=s.length();
        if(n<=k){
            return new ArrayList<>();
        }
        for(int i=0;i<k;i++){
            h=h*a+ecodeSequence.get(i);
            a_k=a_k*a;
        }

        // Sets to track hashes and repeated sequences
        Set<Integer> seenHashes = new HashSet<>();
        seenHashes.add(h);
        Set<String> output = new HashSet<>();

         for(int start=1;start<=n-k;start++){
             h=h*a -ecodeSequence.get(start-1)*a_k+ecodeSequence.get(start+k-1);
             if(seenHashes.contains(h)){
                 output.add(s.substring(start,start+k));
             }else{
                 seenHashes.add(h);
             }
         }
        return new ArrayList<>(output);
    }




}
