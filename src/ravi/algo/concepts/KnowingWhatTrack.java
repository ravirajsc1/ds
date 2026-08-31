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

        String[][] inputWords = {
                {"ab", "cd", "ef", "gh", "ab", "cd", "ef", "gh"},
                {"aa", "bb", "cc", "dd", "ee"},
                {"ab", "bc", "cd", "dc", "aa", "dd"},
                {"ae", "pq", "qp", "cd", "ee", "ea"},
                {"xx", "yy", "xy", "yx", "zz", "zz"}
        };

        for (int i = 0; i < inputWords.length; i++) {
            System.out.println((i + 1) + ".\twords = " + Arrays.toString(inputWords[i]).replace(", ", ", \"").replace("[", "[\"").replace("]", "\"]"));
            System.out.print("\tThe length of the longest palindrome by concatenating two-letter words is: ");
            System.out.println(longestPalindrome(inputWords[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    //Rank Teams by Votes
        String[][] rankings = new String[][] {
                {"XYZ", "ZXY", "XZY"},
                {"MNOPQ"},
                {"AB", "BA"},
                {"SING", "SIGN", "NIGS", "GINS"},
                {"QWERTYUIOPASDFGHJKLZXCVBNM", "ZXCVBNMASDFGHJKLQWERTYUIOP"}
        };


        for (int i = 0; i < rankings.length; ++i) {
            System.out.print((i + 1) + ".\tVotes: [");
            for (int j = 0; j < rankings[i].length; ++j) {
                System.out.print("\"" + rankings[i][j] + "\"");
                if (j < rankings[i].length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("\tRanking: \"" + rankTeams(rankings[i]) + "\"");
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }


        // Pairs of Songs With Total Durations Divisible by 60

        int[][] testCases = {
                {30, 20, 150, 100, 40},
                {60, 60, 60},
                {10, 50, 90, 30},
                {20, 40, 60, 80, 100},
                {15, 75, 45, 30, 105, 120}
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println((i + 1) + "\ttime: " + Arrays.toString(testCases[i]));
            int result = numPairsDivisibleBy60(testCases[i]);
            System.out.println("\tResult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //    //Minimum Number of Pushes to Type Word II

        String[] words = {"wave", "skyskysky", "abbcdeefghhi", "mmmmmmmmmm", "abcdefghijklmnopqrstuvwxyz"};

        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            System.out.println((index + 1) + ".\tword: \"" + word + "\"");
            System.out.println("\tMinimum pushes: " + minimumPushes(word));
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }

        //Task Scheduler

        char[][] allTasks = {
                {'A', 'A', 'B', 'B'},
                {'A', 'A', 'A', 'B', 'B', 'C', 'C'},
                {'S', 'I', 'V', 'U', 'W', 'D', 'U', 'X'},
                {'M', 'A', 'B', 'M', 'A', 'A', 'Y', 'B', 'M'},
                {'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B', 'D', 'C', 'O', 'Z', 'D', 'E', 'Q'}};

        int[] allNs = {2, 1, 0, 3, 3};

        for (int i = 0; i < allTasks.length; i++) {
            System.out.print((i + 1) + ".\tTasks: ");
            char[] tasks = allTasks[i];
            for(int j = 0; j < tasks.length; j++) {
                System.out.print(tasks[j]);
                if (j != tasks.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("\n\tn: " + allNs[i]);

            int minTime = leastInterval(allTasks[i], allNs[i]);
            System.out.println("\tMinimum time required to execute the tasks: " + minTime);
            System.out.println('-' + String.join("", Collections.nCopies(100, "-")) + '\n');
        }

        // Max Consecutive Ones
        int[][] testCasesM = {
                {1, 1, 0, 1, 1, 1},   // longest streak at end
                {0, 0, 0, 0},         // all zeros
                {1, 1, 1, 1},         // all ones
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1}, // longest streak at start
                {1, 0, 1, 0, 1, 1, 0, 1}  // scattered ones
        };

        for (int i = 0; i < testCasesM.length; i++) {
            System.out.println("\tnums: " + java.util.Arrays.toString(testCasesM[i]));
            int result = findMaxConsecutiveOnes(testCasesM[i]);
            System.out.println("\tresult: " + result);
            System.out.println("----------------------------------------------------------------------------------------------------");
        }

        //Count and Say

        int[] testCasesT = {1, 4, 7, 9, 10, 11};


        for (int i = 0; i < testCasesT.length; i++) {
            int mt = testCasesT[i];
            String result = countAndSay(mt);

            System.out.println((i + 1) + ".\tInput n: " + mt);
            System.out.println("\tCount-and-say sequence: \"" + result + "\"");
            System.out.println("-".repeat(100));
        }

        // Find Words That Can Be Formed by Characters


        String[][] wordsArr = {
                {"abc", "def", "ghi"},
                {"a", "bb", "ccc"},
                {"dog", "god", "good"},
                {"zen", "zone", "no"},
                {"apple", "plea", "pale"},
        };
        String[] charsArr = {
                "abcdefghi",
                "abc",
                "dogoo",
                "zenon",
                "aelpp",
        };

        for (int i = 0; i < wordsArr.length; i++) {
            int result = countCharacters(wordsArr[i], charsArr[i]);
            System.out.println((i + 1) + ".\twords: " + Arrays.toString(wordsArr[i]));
            System.out.println("\tchars: \"" + charsArr[i] + "\"");
            System.out.println("\n\tOutput: " + result);
            System.out.println("-".repeat(100));
        }

        // Check if One String Swap Can Make Strings Equal


        String[][] testCasesSol = {
                {"abcd", "abdc"},
                {"hello", "world"},
                {"aa", "aa"},
                {"ab", "ba"},
                {"abcdef", "abcfed"},
        };

        for (int idx = 0; idx < testCasesSol.length; idx++) {
            String s1 = testCasesSol[idx][0];
            String s2 = testCasesSol[idx][1];
            boolean result = areAlmostEqual(s1, s2);
            System.out.println((idx + 1) + ".\tInput s1: \"" + s1 + "\"");
            System.out.println("\tInput s2: \"" + s2 + "\"");
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }

        // Find Pivot Index



        int[][] testCasesTT = {
                {2,3,5,3,2},
                {10, -5, 5, 0},
                {5, 2, 3, 1, 4, 5},
                {-1, -1, -1, 0, 1, 1},
                {1000, -1000, 0, 1000, -1000},
                {3, 3, 3, 3, 3},
        };

        for (int idx = 0; idx < testCases.length; idx++) {
            int[] nums = testCasesTT[idx];
            int result = pivotIndex(nums);
            System.out.println((idx + 1) + ".\tInput array: " + Arrays.toString(nums));
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }

        //Sort Array by Increasing Frequency

        int[][] testCasesSort = {
                {5, 5, 5, 1, 2, 2},
                {4, 4, 1, 1, 3, 3, 7},
                {-3, -3, -1, -1, -1, 0, 2},
                {10, 10, -10, -10, 5, 5, 5, 0},
                {100, -100, 100, -100, 50, 50, 50, -50},
        };

        String separator = "-".repeat(100);

        for (int i = 0; i < testCasesSort.length; i++) {
            int[] nums = testCasesSort[i];

            int[] result = frequencySort(nums.clone());

            System.out.println((i + 1) + ".\tInput array: " + Arrays.toString(nums));
            System.out.println("\tResult: " + Arrays.toString(result));
            System.out.println(separator);
        }

        // Concatenation of Array
        int[][] testCasesArray = {
                {5},
                {3, 7, 2, 8, 4},
                {10, 20, 30},
                {1000, 999, 1, 500},
                {4, 4, 4, 4, 4, 4},
        };

        for (int idx = 0; idx < testCasesArray.length; idx++) {
            int[] result = getConcatenation(testCasesArray[idx]);
            System.out.println((idx + 1) + ".\tnums: " + Arrays.toString(testCasesArray[idx]));
            System.out.println("\tans: " + Arrays.toString(result));
            System.out.println("-".repeat(100));
        }

// Zigzag Conversion
        Object[][] testCasesZigzag = {
                {"ABCDEFGHIJ", 4},
                {"HELLOWORLD", 3},
                {"ZIGZAGCONVERSION", 5},
                {"ABCDE", 2},
                {"THEQUICKBROWNFOX", 6},
        };

        for (int i = 0; i < testCasesZigzag.length; i++) {
            String s = (String) testCasesZigzag[i][0];
            int numRows = (int) testCasesZigzag[i][1];
            String result = convertBetter(s, numRows);

            System.out.println((i + 1) + ".\ts:" + s);
            System.out.println("\tnumRows: " + numRows);
            System.out.println("\n\tResult: " + result);
            System.out.println("-".repeat(100));
        }


        //Zero Array Transformation I



        int[][][] numsList = {
                {{2, 1, 3}},
                {{0, 0, 0}},
                {{3, 2, 1, 1}},
                {{1, 2, 3, 4, 5}},
                {{5, 5, 5}}
        };

        int[][][][] queriesList = {
                {{{0, 2}, {1, 2}, {0, 1}}},
                {{{0, 1}}},
                {{{0, 3}, {0, 2}, {0, 1}}},
                {{{0, 4}, {1, 4}, {2, 4}, {3, 4}, {4, 4}}},
                {{{0, 1}, {1, 2}}}
        };

        for (int idx = 0; idx < numsList.length; idx++) {
            int[] nums = numsList[idx][0];
            int[][] queries = queriesList[idx][0];
            boolean result = isZeroArray(nums, queries);

            System.out.print((idx + 1) + ".\tInput array: " + Arrays.toString(nums));
            System.out.println();
            System.out.print("\tTarget: [");
            for (int i = 0; i < queries.length; i++) {
                System.out.print(Arrays.toString(queries[i]));
                if (i + 1 < queries.length) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }


        // Count Binary Substrings


        String[] testCasesBin = {
                "000111",
                "0011",
                "110100",
                "00001111",
                "011011"
        };



        for (int idx = 0; idx < testCasesBin.length; idx++) {
            String s = testCasesBin[idx];
            int res = countBinarySubstrings(s);
            System.out.println((idx + 1) + ".\ts: \"" + s + "\"");
            System.out.println("\tResult: " + res);
            System.out.println("-".repeat(100));
        }
    }




    // Count Binary Substrings

    public static int countBinarySubstrings(String s)
    {
        int prevGroup=0;
        int currGroup=1;
        int count=0;


        for(int i=1;i<s.length();i++){

            if(s.charAt(i)!=s.charAt(i-1)){
                count+=Math.min(prevGroup,currGroup);
                prevGroup=currGroup;
                currGroup=1;
            }else{
                currGroup++;
            }


        }
        count+=Math.min(prevGroup,currGroup);
        return count;
    }


    //Zero Array Transformation I

    public static boolean isZeroArray(int[] nums, int[][] queries)
    {

        int n=nums.length;

        int[] diff=new int[n+1];

        for(int[] query:queries){
            diff[query[0]]++;
            diff[query[1]+1]--;
        }

        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=diff[i];
            if(nums[i]>=sum)
                return false;
        }


        return true;
    }

// Zigzag Conversion




    public static String convertBetter(String s, int numRows)
    {

            if(numRows>=s.length() || numRows==1){
                return s;
            }

            List<StringBuilder> sbList=new ArrayList<>();

            for(int i=0;i<numRows;i++){
                  sbList.add(new StringBuilder());
            }

            boolean goingDown=false;
            int curRow=0;
            for(char ch:s.toCharArray()){
                sbList.get(curRow).append(ch);

                if(curRow==0 || curRow==numRows-1){
                    goingDown=!goingDown;
                }

                curRow+=goingDown?1:-1;


            }

            StringBuilder result=new StringBuilder();

            for(StringBuilder sbt:sbList){
                result.append(sbt);
            }


            return result.toString();

    }


    public static String convert(String s, int numRows)
    {

        char[] chars=s.toCharArray();

        Map<Integer,List<Character>> track=new HashMap<>();
        int index=1;
        boolean straight=true;

        track.computeIfAbsent(0, x -> new ArrayList<>()).add(chars[0]);
        while(index<chars.length){
            if(straight) {
                for (int i = 1; i < numRows && index<chars.length;i++ ) {
                    char ch = chars[index];
                    track.computeIfAbsent(i, x -> new ArrayList<>()).add(ch);
                    index++;

                }
            }else{

                for (int i = numRows-2; i >= 0 && index<chars.length;i-- ) {
                    char ch = chars[index];
                    track.computeIfAbsent(i, x -> new ArrayList<>()).add(ch);
                    index++;

                }

            }
              straight=!straight;

        }


        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < numRows ;i++ ) {
            for(char ch:track.get(i))
                sb.append(ch);
        }

        return sb.toString();
    }

    // Concatenation of Array

    public static int[] getConcatenation(int[] nums)
    {
        int n=nums.length;
        int[] res=new int[2*n];
        for(int i=0;i<n;i++){

            res[i]=nums[i];
            res[i+n]=nums[i];

        }

        return res;
    }


    //Sort Array by Increasing Frequency
    public static int[] frequencySort(int[] nums)
    {

        Map<Integer,Integer> freq=new HashMap<>();


        int max=Integer.MIN_VALUE;

        for(int num:nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Map<Integer,List<Integer>> freqList=new HashMap<>();
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()) {
            int key=entry.getKey();
            int fq=entry.getValue();

            freqList.computeIfAbsent(fq,x->new ArrayList<>()).add(key);
            max=Math.max(max,fq);
        }



        int m=0;
        int[] result=new int[nums.length];
        for(int i=1;i<=max;i++){
            if(freqList.containsKey(i)){
                List<Integer> list=freqList.get(i);
                Collections.sort(list,(a,b)->(b-a));

                 for(int num:list){
                     for(int k=0;k<freq.get(num);k++) {
                         result[m] = num;
                         m++;
                     }
                 }
                }

        }


        return result;
    }

    // Find Pivot Index
    public static int pivotIndex(int[] nums)
    {

        int total=Arrays.stream(nums).sum();
        int left=0;

        for(int i=0;i<nums.length;i++){
            int right=total-left-i;

            if(left==right){
                return i;
            }
            left+=nums[i];

        }
        return -1;
    }
    // Check if One String Swap Can Make Strings Equal

    public static boolean areAlmostEqual(String s1, String s2)
    {
        int[] incorrectIndex=new int[2];
        int count=0;

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
                if(count>2){
                    return false;
                }
                incorrectIndex[count-1]=i;
            }
        }

        if(count==0){
            return true;
        }else if(count==1){
            return false;
        }else{
            if( (s1.charAt(incorrectIndex[0]) == s2.charAt(incorrectIndex[1]))  &&
                    (s1.charAt(incorrectIndex[1]) == s2.charAt(incorrectIndex[0]))
            ){
                return true;
            }
        }

        return false;
    }



    // Find Words That Can Be Formed by Characters

    public static int countCharacters(String[] words, String chars)
    {


        int[] freq=new int[26];

        for(char ch:chars.toCharArray()){
            freq[ch-'a']++;
        }
        int count=0;
        for(String word:words){

            int[] wordFreq=new int[26];
            for(char ch:word.toCharArray()){
                wordFreq[ch-'a']++;
            }

            boolean canCount=true;
            for(int i=0;i<26;i++){
                if(wordFreq[i]!=0 && wordFreq[i]>freq[i]){
                    canCount=false;
                   break;
                }
            }
            if(canCount)
                count+=word.length();

        }

        // Replace this placeholder return statement with your code
        return count;
    }


// Ransom Note

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] mag=new int[26];

        for(char ch:magazine.toCharArray()){
            mag[ch-'a']++;
        }

        for(char ch:ransomNote.toCharArray()){
            if(mag[ch-'a']<1) {
                return false;
            }else{
                mag[ch-'a']--;
             }
        }
        // Replace this placeholder return statement with your code
        return true;
    }


    //Count and Say


    public static String countAndSay(int n) {
        String result= "1";

        for(int i=2;i<=n;i++){

            StringBuilder sb=new StringBuilder();

            int count=1;

            for(int j=1;j<result.length();j++){

                if(result.charAt(j)==result.charAt(j-1)){
                    count++;
                }else{
                    sb.append(count).append(result.charAt(j-1));
                    count=1;
                }

            }
            sb.append(count).append(result.charAt(result.length() - 1));

            result = sb.toString();
        }
        return result;

    }



    //Max Consecutive Ones

    public static int findMaxConsecutiveOnes(int[] nums) {

        int max=0;
        int sum=0;
        for(int num:nums){
            if(num!=1){
                max=Math.max(sum,max);
                sum=0;
            }
            sum+=num;
        }
        max=Math.max(sum,max);
        return max;
    }
    //Task Scheduler

    public static int leastInterval(char[] tasks, int n) {

        int[] freq=new int[26];

        for(char task:tasks){
            freq[task-'A']++;
        }


        freq=Arrays.stream(freq).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int maxFreq=freq[0];
        int maxGap=maxFreq-1;

        int idleSlots=n*maxGap;

        for(int i=1;i<26;i++){
            idleSlots-= Math.min(freq[i],maxGap);

        }


        idleSlots = Math.max(0, idleSlots);


        return tasks.length+idleSlots;
    }


    //Minimum Number of Pushes to Type Word II

    public static int minimumPushes(String word) {

        int[] freq=new int[26];

        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        for(int i=0,j=freq.length-1; i<j ;i++,j-- ){
            int temp=freq[i];
            freq[i]=freq[j];
            freq[j]=temp;

        }

        int count=0;
        for(int i=0;i<freq.length;i++){
            if (freq[i] == 0)
                break;
             count+=(i/8+1)*freq[i];
        }

        return count;
    }

    // Pairs of Songs With Total Durations Divisible by 60

    public static int numPairsDivisibleBy60(int[] times) {
        int[] reminders=new int[60];
        int count=0;
        for(int i=0;i<times.length;i++){
            int reminder=times[i]%60;


            if(reminder==0){
                count+=reminders[0];
            }else{
                count+=reminders[60-reminder];
            }

            reminders[reminder]++;

        }

        return count;
    }


    //Rank Teams by Votes

    public static String rankTeams(String[] votes) {

       int[][] counts=new int[26][27];

        for(int i=0;i<26;i++){
            counts[i][26]='A'+i;
        }

        for(String vote:votes){
            for(int j=0;j<vote.length();j++){
                char c=vote.charAt(j);
                --counts[c-'A'][j];
            }

        }

        int teams = votes[0].length();

        Arrays.sort(counts, 0, teams, (a,b)->{
            for(int i=0;i<26;i++){
                if(a[i]!=b[i]){
                    return Integer.compare(a[i], b[i]);
                }
            }
            return Integer.compare(a[26], b[26]);
        });

        
        StringBuilder sb=new StringBuilder();


        for(int i = 0; i < votes[0].length(); i++){
            sb.append((char)counts[i][26]);
        }
    return sb.toString();

    }

    //
    public static int longestPalindrome(String[] words) {

        Map<String,Integer> freq=new HashMap<>();

        for(String word:words){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }

        boolean central=false;
        int len=0;
        for(String word:freq.keySet()){
            char a = word.charAt(0);
            char b = word.charAt(1);


            if(a==b){
                int count=freq.get(word);
                len += (count / 2) * 4;

                if(count%2==1){
                    central=true;
                }

            }else if(a<b){

                String reverse=b+""+a;
                int count =Math.min(freq.getOrDefault(reverse,0),freq.get(word));
                len+= count*4;


            }

        }

        if(central)
            len+=2;
        return len;
    }

    // Find All Anagrams in a String

    public static List<Integer> findAnagrams(String a, String b) {

        List<Integer> result=new ArrayList<>();
        if(b.length()>a.length())
            return  result;



        int[] anaCount=new int[26];
        int[] window=new int[26];


        for(int i=0;i<b.length();i++){
            anaCount[b.charAt(i)-'a']++;
            window[a.charAt(i)-'a']++;

        }

        if(Arrays.equals(anaCount,window)){
            result.add(0);
        }

        for(int i=b.length();i<a.length();i++){

            window[a.charAt(i)-'a']++;
            window[a.charAt(i-b.length())-'a']--;


            if(Arrays.equals(anaCount,window)){
                result.add(i-b.length()+1);
            }

        }


        return result;
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
