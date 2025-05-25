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


        //Minimum Window Substring Given two strings, s and t, find the minimum window substring in s, which has the following properties:

        String[] s = {"PATNERT", "LIFE", "ABRACADABRA", "STRIKER", "DFFDFDFVD"};
        String[] t = {"TTN", "I", "ABC", "RK", "VDD"};

        for (int i = 0; i < s.length; i++) {
            System.out.printf("%d.\ts: %s\n\tt: %s\n\tThe minimum substring containing %s is: %s\n",
                    i + 1, s[i], t[i], t[i], minWindowSubstring(s[i], t[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        //Longest Substring without Repeating Characters Given a string, str, return the length of the longest substring without repeating characters.

        String[] inputs = {
                "abcdbea",
                "pwwkew",
                "bbbbb",
                "ababababa",
                "",
                "ABCDEFGHI",
                "ABCDEDCBA",
                "AAAABBBBCCCCDDDD"
        };
        for (int i = 0; i < inputs.length; i++) {
            int str = findLongestSubstringBetter(inputs[i]);
            System.out.print(i + 1);
            System.out.println("\tInput string: " + inputs[i]);
            System.out.println("\n\tLength of longest substring: " + str);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        //Minimum Size Subarray Sum

        //Given an array of positive integers, nums, and a positive integer, target, find the minimum length of a contiguous subarray whose sum is greater than or equal to the target. If no such subarray is found, return 0.

        int[] target = {7, 4, 11, 10, 5, 15};
        int[][] inputArr = {
                {2, 3, 1, 2, 4, 3},
                {1, 4, 4},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 3, 4},
                {1, 2, 1, 3},
                {5, 4, 9, 8, 11, 3, 7, 12, 15, 44}
        };
        for (int i = 0; i < target.length; i++) {
            int windowSize = minSubArrayLen(target[i], inputArr[i]);
            System.out.print((i + 1) + ".\tInput array: " + Arrays.toString(inputArr[i]));
            System.out.print("\n\tTarget: " + target[i]);
            System.out.println("\n\tMinimum Length of Subarray: " + windowSize);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

    //Minimum Size Subarray Sum

    //Given an array of positive integers, nums, and a positive integer, target, find the minimum length of a contiguous subarray whose sum is greater than or equal to the target. If no such subarray is found, return 0.


    public static int minSubArrayLen(int target, int[] nums) {

        // Replace this placeholder return statement with your code

        int left=0,right=0;
        int minLengh=nums.length+1;
        int sum=nums[0];
        while(left<nums.length){

            if(sum<target && right<nums.length-1){
                right++;
                sum=sum+nums[right];
            }else{
                if(sum>=target  && right-left+1<minLengh){
                    minLengh=right-left+1;
                }
                sum=sum-nums[left];
                left++;

            }
        }


        return  minLengh==nums.length+1?0:minLengh;
    }


    //Longest Substring without Repeating Characters Given a string, str, return the length of the longest substring without repeating characters.

    public static int findLongestSubstringBetter(String str) {

        int left=0,right=0;
        Map<Character,Integer> counts=new HashMap<>();
        int longestString=0;

        for(right=0;right<str.length();right++){
            char c=str.charAt(right);

            if(!counts.containsKey(c) ){
                counts.put(c,right);
            }else{
               int oldIndex=counts.get(c);

                if( counts.get(c)>= left){

                    if(longestString<right-left){
                        longestString=right-left;
                    }
                    left=oldIndex+1;
               }

                counts.replace(c,right);
            }



        }
        if(longestString<right-left){
            longestString=right-left;
        }
        // Replace this placeholder return statement with your code
        return longestString;
    }


    //Longest Substring without Repeating Characters Given a string, str, return the length of the longest substring without repeating characters.

    public static int findLongestSubstring(String str) {

        int left=0,right=0;
        Map<Character,Integer> counts=new HashMap<>();
        String longestString="";

        for(right=0;right<str.length();right++){
            char c=str.charAt(right);
            int ccount=counts.getOrDefault(c,0);
            if(ccount>=1 ){
                if( longestString.length() < right-left){
                    longestString=str.substring(left,right);
                }
                char cleft=str.charAt(left);
                while(cleft!=c){
                    counts.put(cleft,counts.get(cleft)-1);
                    left++;
                    cleft=str.charAt(left);
                 }
                left++;

            }else{
                counts.put(c,ccount+1);
            }



        }
        if( longestString.length() < right-left){
            longestString=str.substring(left,right);
        }
        // Replace this placeholder return statement with your code
        return longestString.length();
    }

    //Minimum Window Substring Given two strings, s and t, find the minimum window substring in s, which has the following properties:
    public static String minWindowBet(String s, String t) {
        // If `t` is empty, return an empty string as no window is possible
        if (t.isEmpty()) {
            return "";
        }

        // Maps to store the required character counts and the current window's character counts
        Map<Character, Integer> reqCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // Populate `reqCount` with the character frequencies of `t`
        for (char c : t.toCharArray()) {
            reqCount.put(c, reqCount.getOrDefault(c, 0) + 1);
        }

        // Variables to track the number of characters that match the required frequencies
        int current = 0; // Count of characters in the current window that meet the required frequency
        int required = reqCount.size(); // Total number of unique characters in `t`

        // Result variables to track the best window
        int[] res = {-1, -1}; // Stores the start and end indices of the minimum window
        int resLen = Integer.MAX_VALUE; // Length of the minimum window

        // Sliding window pointers
        int left = 0; // Left pointer of the window
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If `c` is in `t`, update the window count
            if (reqCount.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // If the frequency of `c` in the window matches the required frequency, update `current`
                if (window.get(c).equals(reqCount.get(c))) {
                    current++;
                }
            }

            // Try to contract the window while all required characters are present
            while (current == required) {
                // Update the result if the current window is smaller than the previous best
                if ((right - left + 1) < resLen) {
                    res[0] = left;
                    res[1] = right;
                    resLen = (right - left + 1);
                }

                // Shrink the window from the left
                char leftChar = s.charAt(left);
                if (reqCount.containsKey(leftChar)) {
                    // Decrement the count of `leftChar` in the window
                    window.put(leftChar, window.get(leftChar) - 1);
                    // If the frequency of `leftChar` in the window is less than required, update `current`
                    if (window.get(leftChar) < reqCount.get(leftChar)) {
                        current--;
                    }
                }
                left++; // Move the left pointer to shrink the window
            }
        }

        // Return the minimum window if found, otherwise return an empty string
        return res[0] == -1 ? "" : s.substring(res[0], res[1] + 1);
    }

    public static String minWindowSubstring(String s, String t) {

        Map<Character,Integer> reqCount=new HashMap<>();
        Map<Character,Integer> window=new HashMap<>();
        int left=0;
        int[] res=new int[]{-1,-1};

        for(char ch:t.toCharArray()){
            reqCount.put(ch,reqCount.getOrDefault(ch,0)+1);

        }

        int required=reqCount.size();
        int current=0;
        int resLegth=s.length()+1;

        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);

            if(reqCount.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c)==reqCount.get(c)){
                    current++;
                }
            }

            while(required==current){
                if(resLegth > right-left+1) {
                    res[0] = left;
                    res[1] = right;
                    resLegth = right - left + 1;
                }


                // remove out of window
                if(window.containsKey(s.charAt(left))){
                    window.put(s.charAt(left),window.getOrDefault(s.charAt(left),0)-1);

                    if(window.get(s.charAt(left))<reqCount.get(s.charAt(left))){
                        current--;
                    }
                }

                left++;

            }
    }
            // Replace this placeholder return statement with your code

        return res[0]!=-1?s.substring(res[0],res[1]+1):"";
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
