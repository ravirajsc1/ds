package ravi.algo.concepts;

import java.beans.PropertyEditorSupport;
import java.util.*;
public class DesignHashMap {

    Bucket bucket[];
    int keySpace;

    // initailization of requests hash map
    private HashMap<String, Integer> requests;
    int limit;
    public DesignHashMap() {
        keySpace = 2069;
        bucket = new Bucket[keySpace];
        for (int i = 0; i < keySpace; i++) {
            bucket[i] = new Bucket();
        }
    }

    public DesignHashMap(int limit) {
        keySpace = 2069;
        bucket = new Bucket[keySpace];
        for (int i = 0; i < keySpace; i++) {
            bucket[i] = new Bucket();
        }
        requests = new HashMap<String, Integer> ();
        this.limit = limit;
    }

    public void put(int key, int value) {
        // Write your code here
        int haskkey = key % keySpace;
        bucket[haskkey].update(key, value);

    }

    public int get(int key) {
        // Replace this placeholder return statement with your code
        int haskkey = key % keySpace;
        return bucket[haskkey].get(key);
    }

    public void remove(int key) {
        int haskkey = key % keySpace;
        bucket[haskkey].remove(key);
    }

    // Main method to demonstrate the usage of the HashMap
    public static void main(String args[]) {

        DesignHashMap inputHashMap = new DesignHashMap();
        List<Integer> keys = Arrays.asList(5, 2069, 2070, 2073, 4138, 2068);
        List<Integer> keysList = new ArrayList<>(Arrays.asList(5, 2069, 2070, 2073, 4138, 2068));
        List<Integer> values = Arrays.asList(100, 200, 400, 500, 1000, 5000);
        List<String> funcs = Arrays.asList("Get", "Get", "Put", "Get", "Put", "Get", "Get", "Remove", "Get", "Get", "Remove", "Get");
        List<List<Integer>> funcKeys = Arrays.asList(
                Arrays.asList(5),
                Arrays.asList(2073),
                Arrays.asList(2073, 50),
                Arrays.asList(2073),
                Arrays.asList(121, 110),
                Arrays.asList(121),
                Arrays.asList(2068),
                Arrays.asList(2069),
                Arrays.asList(2069),
                Arrays.asList(2071),
                Arrays.asList(2071),
                Arrays.asList(2071)
        );

        for (int i = 0; i < keys.size(); i++) {
            inputHashMap.put(keys.get(i), values.get(i));
        }

        for (int i = 0; i < funcs.size(); i++) {
            if (funcs.get(i) == "Put") {
                System.out.println(i + 1 + ".\t put(" + funcKeys.get(i).get(0) + ", " + funcKeys.get(i).get(1) + ")");
                if (!(keysList.contains(funcKeys.get(i).get(0)))) {
                    keysList.add(funcKeys.get(i).get(0));
                }
                inputHashMap.put(funcKeys.get(i).get(0), funcKeys.get(i).get(1));
            } else if (funcs.get(i) == "Get") {
                System.out.println(i + 1 + ".\t get(" + funcKeys.get(i).get(0) + ")");
                System.out.println("\t Value returned: " + inputHashMap.get(funcKeys.get(i).get(0)));
            } else if (funcs.get(i) == "Remove") {
                System.out.println(i + 1 + ". \t remove(" + funcKeys.get(i).get(0) + ")");
                inputHashMap.remove(funcKeys.get(i).get(0));
            }

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // Fraction to Recurring Decimal
        int[][] inputs = {{0, 4}, {4, 2}, {5, 333}, {2, 3}, {47, 18}, {93, 7}, {-5, 333}, {47, -18},
                {-4, -2}};
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1 + ".\tInput: fraction_to_decimal(");
            for (int j = 0; j < inputs[i].length - 1; j++) {
                System.out.print(inputs[i][j]);
                System.out.print(", ");
            }
            System.out.println(inputs[i][inputs[i].length - 1] + ")");
            String result = fractionToDecimal(inputs[i][0], inputs[i][1]);
            System.out.println("\tOutput: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Logger Rate Limiter
        int[] times = { 1, 5, 6, 7, 15 };
        String[] messages = {
                "good morning",
                "hello world",
                "good morning",
                "good morning",
                "hello world"
        };
        DesignHashMap obj = new DesignHashMap(7);
        for (int i = 0; i<messages.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tTime, message: {" + times[i] + ", '" + messages[i] + "'}");
            System.out.println("\tMessage request decision: " + obj.messageRequestDecision(times[i], messages[i]));
          //  System.out.println(PrintHyphens.repeat("-", 100));
        }

        // Next Greater Element I


        int[][] A = {
                {2, 4},
                {3, 2, 5},
                {14, 45, 52},
                {1, 3, 2},
                {4, 2},
                {0}
        };
        int[][] B = {
                {1, 2, 3, 4},
                {2, 3, 5, 1},
                {52, 14, 45, 65},
                {1, 3, 2, 4, 5},
                {1, 2, 4, 3},
                {0}
        };

        int x = 1;
        for (int i = 0; i < A.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tNums 1 = " + Arrays.toString(A[i]));
            System.out.println("\tNums 2 = " + Arrays.toString(B[i]));
            System.out.print("");
            System.out.println("\tThe Next Greater Element Array = " + Arrays.toString(nextGreaterElement(A[i], B[i])));
         //   System.out.println(PrintHyphens.repeat("-", 100));
        }
        // Isomorphic Strings
        String[] AI = {"egg", "foo", "paper", "badc", "aaeaa"};
        String[] BI = {"all", "bar", "title", "baba", "uuxyy"};
        for (int i = 0; i < AI.length; i++) {
            System.out.println((i + 1) + ".\tString 1 = " + AI[i]);
            System.out.println("\tString 2 = " +   BI[i]);
            System.out.println("\n\tIsomorphic String ? " + isIsomorphic(AI[i], BI[i]));
            //System.out.println(PrintHyphens.repeat("-", 100));
        }

        // Find Duplicate File in System
        List<String[]> inputList = new ArrayList<>();
        inputList.add(new String[]{
                "home/user1 1.txt(hello) 2.txt(world)",
                "home/user2 3.txt(hello)",
                "home/user3/docs 4.txt(world)",
                "home/user3/docs 5.txt(greetings)"
        });
        inputList.add(new String[]{
                "data 1.csv(data1) 2.csv(data2)",
                "data/2021 3.csv(data1) 4.csv(data3)",
                "data/2022 5.csv(data2)",
                "data/2021/backup 6.csv(data3)"
        });
        inputList.add(new String[]{
                "reports/jan 1.doc(report1) 2.doc(report2)",
                "reports/feb 3.doc(report1)",
                "reports/mar 4.doc(report2)",
                "reports/apr 5.doc(report3)"
        });
        inputList.add(new String[]{
                "docs 1.doc(text1) 2.doc(text2)",
                "docs/2020 3.doc(text1)",
                "docs/2021 4.doc(text2)",
                "docs/2021/backup 5.doc(text3)"
        });
        inputList.add(new String[]{
                "csv 1.csv(123) 2.csv(456)",
                "csv/2022 3.csv(123)",
                "csv/2023 4.csv(456) 5.csv(789)",
                "csv/backup 6.csv(789)"
        });

        for (int i = 0; i < inputList.size(); i++) {
            System.out.println((i + 1) + ".\tInput string:");
            for (String path : inputList.get(i)) {
                System.out.println("\t\t" + path);
            }

            List<List<String>> duplicates = findDuplicate(inputList.get(i));

            System.out.println("\n\tDuplicate files: ");
            for (List<String> group : duplicates) {
                System.out.println("\t\t" + String.join(", ", group));
            }
            System.out.println();
        }

        //Dot Product of Two Sparse Vectors

// High Five

        int[][][] testCases = {
                {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}},
                {{1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}},
                {{3, 70}, {4, 60}, {3, 80}, {4, 90}, {3, 100}, {4, 85}, {3, 90}, {4, 100}, {3, 75}, {4, 95}},
                {{5, 60}, {6, 50}, {5, 90}, {6, 70}, {5, 80}, {6, 60}, {5, 70}, {6, 80}, {5, 100}, {6, 100}},
                {{8, 88}, {8, 77}, {9, 85}, {8, 95}, {9, 100}, {8, 100}, {9, 95}, {9, 80}, {8, 92}, {9, 88}}
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.print((i + 1) + ".\titems: ");
            for (int[] item : testCases[i]) {
                System.out.print("[" + item[0] + ", " + item[1] + "] ");
            }
            System.out.print("\n\tThe top five averages are: ");
            int[][] result = highFive(testCases[i]);
            for (int[] res : result) {
                System.out.print("[" + res[0] + ", " + res[1] + "] ");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Bulls and Cows
        String[][] testCasesCow = {
                {"5567", "5675"},
                {"1123", "0111"},
                {"1234", "1243"},
                {"9876", "9876"},
                {"5567", "5675"}
        };

        for (int i = 0; i < testCasesCow.length; i++) {
            String secret = testCasesCow[i][0];
            String guess = testCasesCow[i][1];
            System.out.println((i + 1) + ".\tSecret: \"" + secret + "\", Guess: \"" + guess + "\"");
            System.out.println("\n\tHint: \"" + getHint(secret, guess) + "\"");
            System.out.println(new String(new char[100]).replace('\0', '-')); // prints 100 dashes
        }

        // Custom Sort String

        String[][] testCasesSort = {
                {"cba", "abcd"},
                {"xyz", "abcdef"},
                {"bca", "xyz"},
                {"edcba", "abcde"},
                {"abc", "aabbcc"},
                {"abc", "xyz"},
                {"wo", "meow"}
        };

        for (int i = 0; i < testCasesSort.length; i++) {
            String order = testCasesSort[i][0];
            String s = testCasesSort[i][1];
            System.out.println((i + 1) + ".\torder = \"" + order + "\"");
            System.out.println("\ts = \"" + s + "\"");
            System.out.println("\n\tresult = \"" + customSortString(order, s) + "\"");
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }

    // Custom Sort String

    public static String customSortString(String order, String s) {

        // Replace this placeholder return statement with your code
        return "";
    }

// Bulls and Cows

    public static String getHint (String secret, String guess)
    {
        HashMap<Character,Integer> map=new HashMap<>();
        int bull=0;
        int cow=0;
        char[] secrects=secret.toCharArray();
        char[] guesses=guess.toCharArray();
        for(int i=0;i<secrects.length;i++){

            char s=secrects[i];
            char g=guesses[i];
            if(s==g){
                bull++;
            }else{

                if(map.getOrDefault(s,0)<0) cow++;
                if(map.getOrDefault(g,0)>0) cow++;


                map.put(s,map.getOrDefault(s,0)+1);
                map.put(g,map.getOrDefault(g,0)-1);


            }



        }
        return bull+"A"+cow+"B";
    }




    // High Five

    public static int[][] highFive(int[][] items) {

        Map<Integer,PriorityQueue<Integer>> scoreMap=new TreeMap<>();

        for(int[] scores:items){
                int studentID=scores[0];
                int score=scores[1];
                if(!scoreMap.containsKey(studentID)){
                    PriorityQueue<Integer> queue=new PriorityQueue<>();
                    scoreMap.put(studentID,queue);
                }
                scoreMap.get(studentID).offer(score);
                if(scoreMap.get(studentID).size()>5){
                    scoreMap.get(studentID).poll();
                }
        }

        int[][] result =new int[scoreMap.size()][2];
        int i=0;
        for(Map.Entry<Integer,PriorityQueue<Integer>> entry: scoreMap.entrySet()){
            PriorityQueue<Integer> queue=(PriorityQueue<Integer>)entry.getValue();
            int aggregation=queue.stream().mapToInt(Integer::intValue)
                    .sum()/queue.size();
            result[i][0]=(int)entry.getKey();
            result[i][1]=aggregation;
            i++;

        }
        // Replace this placeholder return statement with your code
        return result;
    }

    // Dot Product of Two Sparse Vectors

    public  Map<Integer,Integer> getSparseVector(int[] nums) {
        Map<Integer,Integer> hashMap= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                hashMap.put(i, nums[i]);
            }
        }
        return hashMap;
    }

    public int dotProduct(Map<Integer,Integer> hashMap1,Map<Integer,Integer> hashMap2) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap1.entrySet()) {
            int i = entry.getKey();
            int n = entry.getValue();
            if (hashMap2.containsKey(i)) {
                sum += n * hashMap2.get(i);
            }
        }
        return sum;
    }

    // Find Duplicate File in System


    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map=new HashMap<>();
        List<List<String>> result=new ArrayList<>();

        for(String path:paths) {
            String[] values = path.split(" ");
            String dir = values[0];
            for(int i=1;i<values.length;i++) {
                String[] fileAndClass = values[i].split("\\(");
                String fileName = fileAndClass[1];
                String file = fileAndClass[0];
                String cls = fileName.substring(0, fileName.length() - 1);
                map.computeIfAbsent(cls, x -> new ArrayList<>()).add(dir + "/" + file);
            }
        }

        for(Map.Entry<String,List<String>> keyValue:map.entrySet()){
            if(keyValue.getValue().size()>1){
                result.add(keyValue.getValue());
            }

        }
        return result;
    }

    // Isomorphic Strings

    public static boolean isIsomorphic(String string1, String string2) {
        // Replace this placeholder return statement with your code
        Map<Character,Character> map1=new HashMap<>();
        Map<Character,Character> map2=new HashMap<>();
        int n=string1.length();
        for(int i=0;i<n;i++){
            char ch1=string1.charAt(i);
            char ch2=string2.charAt(i);
            if(map1.containsKey(ch1) && !map1.get(ch1).equals(ch2)){
                return false;
            }

            if(map2.containsKey(ch2) && !map2.get(ch2).equals(ch1)){
                return false;
            }

            map1.putIfAbsent(ch1,ch2);
            map2.putIfAbsent(ch2,ch1);
        }
        return true;
    }

    // Next Greater Element I
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {


        int[] ans=new int[nums1.length];
        Map<Integer,Integer> map=new HashMap<>();
        java.util.Stack<Integer> stack=new java.util.Stack<Integer>();

        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[i]>stack.peek()){
                int key=stack.pop();
                map.put(key,nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }

        for(int i=0;i<nums1.length;i++){

            ans[i]=map.get(nums1[i]);
        }

        // Replace this placeholder return statement with your code
        return ans;
    }

    // Logger Rate Limiter


    public boolean messageRequestDecision(int timestamp, String request) {

        if(!requests.containsKey(request)){
            requests.put(request,timestamp);
            return true;
        }

        if(timestamp-requests.get(request)>=this.limit){
            this.requests.put(request,timestamp);
            return true;
        }else{
            return false;
        }

    }


    //Fraction to Recurring Decimal

    public static String fractionToDecimal(int numerator, int denominator) {

        // Replace this placeholder return statement with your code
        String result = "";
        Map<Long, Integer> reminderMap = new HashMap<>();

        if (numerator == 0) {
            return "0";
        }

        if (numerator < 0 || denominator < 0) {
            result += "-";
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long quotient = num / den;
        long reminder = (num % den) * 10;

        result += quotient;

        if (reminder == 0) {
            return result;
        } else {
            result += ".";
            while (reminder != 0) {
                if (reminderMap.containsKey(reminder)) {
                    int beginning = reminderMap.get(reminder);
                    result = result.substring(0, beginning) + "(" + result.substring(beginning) + ")";
                    break;
                } else {
                    reminderMap.put(reminder, result.length());
                    quotient = reminder / den;
                    reminder = (reminder % den) * 10;
                    result += quotient;
                }

            }

            return result;
        }


    }
}