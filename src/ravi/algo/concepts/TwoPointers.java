package ravi.algo.concepts;


import java.util.*;

public class TwoPointers {

    public static void main(String[] args) {
        TwoPointers tp=new TwoPointers();
        char[] palindrome =new char[]{'k','a','Y','a','k'};
        System.out.println("is Palindrome "+tp.isPalindrome(palindrome));

               // Given an array of integers, move all zeros to the end of the array.
        int[] arrayReverse= new int[]{15,2,6,0,2,1,5,0,0,0,6,3,9,0,1};
        int[] arrayReverse2= new int[]{7,0,1,4,0,0,5};
        System.out.println("Given an array of integers, move all zeros to the end of the array");
        Arrays.stream(tp.moveZero(arrayReverse)).forEach(System.out::print);
        System.out.println(" ");
        System.out.println("Given an integer array nums, find and return all unique triplets [nums[i], nums[j], nums[k]], where the indexes satisfy i");
        int[] threeSumArray= new int[]{-1,0,1,2,-1,-4};
        tp.threeSumBetter(threeSumArray).forEach(p->{
            System.out.println("Sum of three zero "+p.toString());
        });

        System.out.println("Remove Nth Node from End of List");
        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(9);
        linkedList.add(12);
        linkedList.add(3);
        linkedList.forEach(System.out::print);
      //  tp.removeNNode(linkedList,2);
        System.out.println("Remove Nth Node from End of List  Result");
        linkedList.forEach(System.out::print);


        //Given a sentence, reverse the order of its words without affecting the order of letters within the given word.
        System.out.println("Trim :  "+tp.reverseWords("World"));

       // Valid Word Abbreviation
        System.out.println("validWordAbbreviation :  "+validWordAbbreviationBetter("minimum","mi3um"));




    }


    public static boolean validWordAbbreviationBetter(String word, String abbr) {

        int startWord=0;
        int startAbbr=0;

        char[] wordsArray=word.toCharArray();
        char[] abbrArray=abbr.toCharArray();

        while(startAbbr<abbrArray.length ){

            if(Character.isDigit(abbrArray[startAbbr])){
                if(abbrArray[startAbbr]=='0'){
                    return false;
                }

                int num=0;
                while(startAbbr<abbr.length() && Character.isDigit(abbrArray[startAbbr]) ){
                    num=10*num+(abbrArray[startAbbr]-'0');
                    startAbbr++;

                }

                startWord=startWord+num;

            }else{
                if(startWord>=word.length() || wordsArray[startWord]!=abbrArray[startAbbr]){
                    return false;
                }
                startAbbr++;
                startWord++;

            }
        }
        return startWord==word.length() && startAbbr==abbr.length();

    }
    public static boolean validWordAbbreviation(String word, String abbr) {
        char[] wordCharArray=word.toCharArray();
        char[] abbrCharArray=abbr.toCharArray();

        int left=0;
        int right=abbrCharArray.length-1;

        int rightWord=wordCharArray.length-1;
        boolean result=false;
        while(left<right){

            if((!Character.isDigit(abbrCharArray[left]) && wordCharArray[left]!=abbrCharArray[left]) ||
                    (!Character.isDigit(abbrCharArray[right]) && wordCharArray[rightWord]!=abbrCharArray[right]) ){
                return false;
            }
            if(!Character.isDigit(abbrCharArray[left])){
                left++;
            }
            if(!Character.isDigit(abbrCharArray[right])){
                right--;
                rightWord--;
            }



        }
        int targetNum=Integer.valueOf(abbr.substring(left,right+1));
        if(( rightWord+1-left)==targetNum){
            result=true;
        }
        // Replace the following return statement with your code
        return result;
    }
    //Given a sentence, reverse the order of its words without affecting the order of letters within the given word.

    public static String reverseWordsUsingInbuilt(String sentence) {
        sentence = sentence.trim();
        String[] words = sentence.split("\\s+");
        int left = 0, right = words.length - 1;

        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }



        return String.join(" ", words);
    }



    public  String reverseWords(String sentence) {
        List<String> str=trim(sentence);
        int left=0;
        int right=str.size()-1;
        while(left<right){
            String temp=str.get(left);
            str.set(left,str.get(right));
            str.set(right,temp);
            left++;
            right--;
        }

        StringBuilder result=new StringBuilder();
        for(int i=0;i<str.size();i++){
            result.append(str.get(i));
            if(i!=str.size()-1){
                result.append(" ");
            }
        }
        return result.toString();
    }

    public List<String> trim(String sentence) {
        char[] trimedString=sentence.toCharArray();
        List<String> str=new ArrayList();
        char prev=trimedString[0];
        StringBuilder stringBuilder=new StringBuilder();
        //char[] trimed=new char[]{};
        int j=0;
        for(int i=0;i<trimedString.length;i++) {
            char current=trimedString[i];
            if(prev==' ' && current==' ') {
                prev=trimedString[i];
                continue;
            }
            if(current!=' '){
                stringBuilder.append(current);
                if(i==trimedString.length-1){
                    str.add(stringBuilder.toString());

                }
            }else {
                if(i<trimedString.length-1){
                    str.add(stringBuilder.toString());
                    j++;
                    stringBuilder = new StringBuilder();

                }else{
                    str.add(stringBuilder.toString());

                }
            }
            prev=trimedString[i];

        }
        // Replace this placeholder return statement with your code
        return str;

    }


/*
Given the head of a singly linked list, remove the nth nth  node from the end of the list and return its head.
 */
//    private void removeNNode(ListNode<Integer> linkedList, int n) {
//
//        linkedList.remove(linkedList.size()-n);
//
//    }

    //  Given an integer array nums, find and return all unique triplets [nums[i], nums[j], nums[k]], where the indexes satisfy i
// -3 -2 -1 0 1 2 3

    public  List<List<Integer>> threeSumBetter(int[] nums) {
        if(nums==null || nums.length<3){
            throw new RuntimeException("Not valid ");
        }
        Arrays.sort(nums);
        List<List<Integer>> arrayList=new ArrayList<>();

        for(int i=0; i<nums.length-2;i++){

            int left=i+1;
            int right=nums.length-1;
            if(i>0  && nums[i-1]==nums[i]){
                continue;
            }

            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    arrayList.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                } else if (sum>0){
                    right--;

                }else{
                    left++;

                }
            }

        }
        return arrayList;
    }

    //  Given an integer array nums, find and return all unique triplets [nums[i], nums[j], nums[k]], where the indexes satisfy i
// -3 -2 -1 0 1 2 3

    public  List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length<3){
            throw new RuntimeException("Not valid ");
        }
        int[] sorted=Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> arrayList=new ArrayList<>();

        for(int i=0;sorted[i]<=0 && i<sorted.length-1;i++){

            int left=i+1;

            if(i>0  && sorted[i-1]==sorted[i]){
                continue;
            }
            int right=sorted.length-1;

            while(left<right){
                if(left>i+1 && sorted[left-1]==sorted[left] ){
                    left++;
                    continue;
                }
                if(right<sorted.length-1 && sorted[right+1]==sorted[right]){
                    right--;
                    continue;
                }

                if(sorted[i]+sorted[left]+sorted[right]==0){
                    List<Integer> match=new ArrayList<>();
                    match.add(sorted[i]);
                    match.add(sorted[left]);
                    match.add(sorted[right]);
                    arrayList.add(match);
                    right--;
                    if(sorted[right+1]==sorted[right]){
                        right--;
                    }
                } else if (sorted[i]+sorted[left]+sorted[right]>0){
                    right--;

                }else{
                    left++;

                }
            }

        }
        return arrayList;
    }



    private boolean isPalindrome(char[] palindrome) {

        if(palindrome==null || palindrome.length<1){
            return false;
        }
        for(int i=0,j=palindrome.length-1;i<j;i++,j--){
            if(palindrome[i]!=palindrome[j]){
                return false;
            }
        }
        return true;

    }

    // Given an array of integers, move all zeros to the end of the array.

    private int[] moveZero(int[] array){

        if(array==null || array.length<=1){
            return array;
        }
        int firstPointer ;
        int secondPointer;

        for(int i=array.length-1,j=array.length-2; i >= 0 && j >= 0;){
            firstPointer=array[i];
            secondPointer = array[j];

            if(firstPointer==0){
                j--;
                i--;
            }else if(secondPointer==0){
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                j--;
                i--;

            }else{
                j--;
            }


         }


        return array;

    }

}
