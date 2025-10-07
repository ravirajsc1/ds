package ravi.algo.concepts;

import java.util.Stack;
import java.util.*;

public class StackDSA {
    public static boolean dbg;
    public static void main(String[] args) {
        // basic calculator

        String[] input = {
                "4 + (52 - 12) + 99",
                "(31 + 7) - (5 - 2)",
                "(12 - 9 + 4) + ( 7 - 5)",
                "8 - 5 + (19 - 11) + 6 + (10 + 3)",
                "56 - 44 - (27 - 17 - 1) + 7"
        };

        for (int i = 0; i < input.length; i++) {
            // Set to False to suppress line-by-line trace
            dbg = true;
            System.out.println((i + 1) + "." + "\tGiven Expression: " + input[i]);
            if (dbg)
                System.out.println("\n\t\tProcessing...");
            System.out.println("\tThe result is:  " + calculator(input[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Remove All Adjacent Duplicates In String
        String[] inputs = {
                "g",
                "ggaabcdeb",
                "abbddaccaaabcd",
                "aannkwwwkkkwna",
                "abbabccblkklu"
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tRemove duplicates from string: '" + inputs[i] + "'");
            String resultingString = removeDuplicates(inputs[i]);
            System.out.println("\tString after removing duplicates: " + resultingString);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Minimum Remove to Make Valid Parentheses


        List<String> inputsL = Arrays.asList("ar)ab(abc)abd(", "a)rt)lm(ikgh)", "aq)xy())qf(a(ba)q)",
                "(aw))kk())(w(aa)(bv(wt)r)",  "(qi)(kl)((y(yt))(r(q(g)s)");
        for (int i = 0; i < inputsL.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ". Input: " + inputsL.get(i));
            System.out.println("   Valid parentheses, after minimum removal: "
                    + minRemoveParentheses(inputsL.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Exclusive Time of Functions

        List<List<String>> events = Arrays.asList(
                Arrays.asList("0:start:0", "1:start:2", "1:end:3", "2:start:4", "2:end:7", "0:end:8"),
                Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"),
                Arrays.asList("0:start:0", "1:start:5", "1:end:6", "0:end:7"),
                Arrays.asList("0:start:0", "1:start:5", "2:start:8", "3:start:12", "4:start:15", "5:start:19", "5:end:22", "4:end:24", "3:end:27", "2:end:32", "1:end:35", "0:end:36"),
                Arrays.asList("0:start:0", "1:start:3", "1:end:6", "0:end:10")
        );
        List<Integer> n = Arrays.asList(3, 2, 2, 6, 2);
        int x = 1;
        for (int i = 0; i<n.size(); i++) {
            System.out.println(x + ".\tn = " + n.get(i));
            System.out.println("\tevents = " + events.get(i));
            System.out.println("\tOutput: " + exclusiveTime(n.get(i), events.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            x += 1;
        }


        //Daily Temperatures
        int[][] testCases = {
                {73, 74, 75, 71, 69, 72, 76, 73},
                {30, 40, 50, 60},
                {30, 60, 90},
                {90, 60, 30},
                {30, 30, 30, 30},
        };

        // Loop through the test cases and print the results
        for (int i = 0; i < testCases.length; i++) {
            int[] temperatures = testCases[i];
            System.out.println((i + 1) + "\ttemperature: " + Arrays.toString(temperatures));
            System.out.println("\n\toutput: " + Arrays.toString(dailyTemperatures(temperatures)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //
        // Decode String

        String[] s = {"3[a]2[bc]", "3[a2[char]]", "2[abc]3[cd]ef", "10[a]", "2[ab3[cd]]4[e]"};
        for (int i = 0; i < s.length; i++) {
            System.out.println((i + 1) + ".\tString: " + s[i]);
            System.out.println("\tDecoded string: " + decodeString(s[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //Minimum String Length After Removing Substrings
        String[] testCasesMmin = {
                "ABFCACDB",
                "ACBBD",
                "ABCD",
                "AABBCDDC",
                "AAAABBBB"
        };

        for (int i = 0; i < testCasesMmin.length; i++) {
            System.out.println((i + 1) + "\tString: " + testCasesMmin[i]);
            int result = minLength(testCasesMmin[i]);
            System.out.println("\n\tResult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Number of Valid Subarrays

        int[][] testCasesSub = {
                {1, 4, 2, 5, 3},
                {2, 4, 3, 1, 5},
                {2, 2, 2},
                {5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5}
        };

        for (int i = 0; i < testCasesSub.length; i++) {
            int result = validSubarrays(testCasesSub[i]);
            System.out.println((i + 1) + ".\tnums: " + Arrays.toString(testCasesSub[i]));
            System.out.println("\tresult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //Number of Visible People in a Queue




    }

    //Number of Visible People in a Queue


    // Number of Valid Subarrays

    public static int validSubarrays(int[] nums) {

        Stack<Integer> stack=new Stack<>();
        int ans=0;
        for(int i=0;i<nums.length;i++){

            while(!stack.isEmpty() && nums[i]<nums[stack.peek()]){
                int top=stack.pop();
                ans+=i-top;

            }
            stack.push(i);

        }

        while(!stack.isEmpty()){
            int top=stack.pop();
            ans+=nums.length-top;
        }
        return ans;
    }
    //Minimum String Length After Removing Substrings

    public static int minLength (String s) {

        Deque<Character> stack=new ArrayDeque<>();

        for(char ch:s.toCharArray()){

            if(!stack.isEmpty()){
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append(stack.peek());
                stringBuilder.append(ch);
                if("AB".equals(stringBuilder.toString()) || "CD".equals(stringBuilder.toString())){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }else{
                stack.push(ch);
            }

        }

        // Replace this placeholder return statement with your code
        return stack.size();
    }


    // Decode String

    public static String decodeString(String s) {
        Stack<String> stringStack=new Stack<>();
        Stack<Integer> countStack=new Stack<>();
        StringBuilder current=new StringBuilder();

        int k=0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                k=k*10+Character.getNumericValue(ch);
            }else if(ch=='['){
                stringStack.push(current.toString());
                countStack.push(k);
                k=0;
                current.setLength(0);
            }else if(ch==']'){
                StringBuilder topString=new StringBuilder(stringStack.pop());
                int topNum=countStack.pop();

                for(int i=0;i<topNum;i++){
                    topString.append(current);
                }
                current=topString;

            }else{
                current.append(ch);
            }



        }

        // Replace this placeholder return statement with your code
        return current.toString();
    }

    // Daily Temperatures
    public static int[] dailyTemperatures(int[] temperatures) {


        Deque<Integer> stack=new ArrayDeque<>();
        int[] result=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){

            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int lastIndex=stack.pop();
                result[lastIndex]=i-lastIndex;
            }
            stack.push(i);
        }
        // Replace this placeholder return statement with your code
        return result;
    }


// Exclusive Time of FunctionsX`

    public static List<Integer> exclusiveTime(int n, List<String> events) {
        Deque<Event> stack=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>(Collections.nCopies(n,0));

        for(String event:events){
            Event ev=new Event(event);

            if(ev.getIsStart()){
                stack.push(ev);

            }else{
                Event lastEvent=stack.pop();
                res.set(ev.getId(),res.get(ev.getId())+ (ev.getTime()-lastEvent.getTime()+1));
                if(!stack.isEmpty()){
                    res.set(stack.peek().getId(),res.get(stack.peek().getId())- (ev.getTime()-lastEvent.getTime()+1));
                }
            }

        }



        // Replace this placeholder return statement with your code
        return res;
    }

    // Minimum Remove to Make Valid Parentheses

    public static String minRemoveParentheses(String s) {
        Stack<int[]> stack=new Stack<>();
        char[] chars=s.toCharArray();

        for(int i=0;i<chars.length;i++){
            char c=chars[i];
            if(!stack.isEmpty() && stack.peek()[0]=='(' && c==')'){
                stack.pop();
            }else if(c=='(' || c==')'){
                stack.push(new int[]{c,i});
            }

        }

        while(!stack.isEmpty()){
            chars[stack.pop()[1]]=' ';
        }

        StringBuilder sb=new StringBuilder();

        for(char ch:chars){
            if(ch!=' '){
                sb.append(ch);
            }
        }
        // Replace this placeholder return statement with your code
        return sb.toString();
    }
    // Remove All Adjacent Duplicates In String

    public static String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();

        for(char c: s.toCharArray() ){
            if(!stack.isEmpty() && stack.peek()==c){
                stack.pop();
            }else{
                stack.push(c);

            }
        }

        StringBuilder res=new StringBuilder();

        while (!stack.isEmpty()){
            res.append(stack.pop());
        }


        // Replace this placeholder return statement with your code
        return res.reverse().toString();
    }

    public static int calculator(String expression) {
        // basic calculator
        int sign=1;
        int number=0;
        int result=0;
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);

            if(Character.isDigit(c)){
                number=number*10+ Character.getNumericValue(c);
            }else if(c=='+' || c=='-'){
                result=result+sign*number;
                number=0;
                if(c=='+'){
                    sign=1;
                }else{
                    sign=-1;
                }
            }else if(c=='('){
                stack.push(result);
                stack.push(sign);
                number=0;
                result=0;
                sign=1;

            }else if(c==')'){
                result+=sign*number;
                number=0;
                int prevSign = stack.pop();     // sign
                int prevResult = stack.pop();   // result before '('
                result = prevResult + prevSign * result;
            }else if (c == ' ') {
                continue; // skip whitespace
            }

          }

        return result+number*sign;
    }





}
