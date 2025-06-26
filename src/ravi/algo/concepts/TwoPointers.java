package ravi.algo.concepts;


import java.util.*;
import java.util.LinkedList;


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


       // Strobogrammatic Number

        System.out.println("isStrobogrammatic :  "+isStrobogrammaticBetter("d"));

        //Minimum Number of Moves to Make Palindrome

        System.out.println("minMovesToMakePalindrome :  "+minMovesToMakePalindrome("eggeekgbbeg"));
        System.out.println("minMovesToMakePalindrome :  "+minMovesToMakePalindromeBetter("eggeekgbbeg"));

        //Next Palindrome Using Same Digits


        System.out.println("findNextPalindrome of 23143034132 is :  "+findNextPalindromeBetter("55"));


        MyBTree myBTree=new MyBTree();
        //4,3,6,2,1,7,5
        myBTree.add(12);
        myBTree.add(7);
        myBTree.add(1);
        myBTree.add(9);
        myBTree.add(10);
        myBTree.add(15);
        myBTree.add(2);
        myBTree.add(5);
//LowestCommonAncestor
//
        System.out.println("LowestCommonAncestor of [4,3,6,2,1,7,5] is :  "+lowestCommonAncestorTwoPointerBetter(myBTree,5,10).value);

     //   Count Pairs Whose Sum is Less than Target
        List<Integer> nums= new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(4);
        nums.add(5);
        int target=6;
        System.out.println("countPairs  is :  "+countPairs(nums,target));

        //Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.


        System.out.println("countPairs  is :  "+isPalindrome("madeame"));

        System.out.println("countPairs  is :  "+validPalindrome("madeame"));
    }

    //Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.

    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try skipping either left or right character
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true; // It's already a palindrome
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
    public static boolean isPalindrome(String string) {
        char[] charArr=string.toCharArray();
        int right=charArr.length-1;
        int left=0;
        int count=0;
        while(left<right){
            if(charArr[left]!=charArr[right]) {
                if (charArr[left] == charArr[right - 1]) {
                    right--;
                    count++;
                } else if (charArr[left + 1] == charArr[right]) {
                    left++;
                    count++;
                } else {
                    return false;
                }

            }else{
                right--;
                left++;
            }
        }



        // Replace this placeholder return statement with your code

        return count==1?true:false;
    }
    public static int countPairs (List<Integer> nums, int target) {
        Collections.sort(nums);
        int high=nums.size()-1;
        int low=0;
        List<int[]> pairArray=new ArrayList<>();
        while(low<high){
            if(nums.get(low)+nums.get(high)<target){
                for(int i=high;i>low;i--){
                    pairArray.add(new int[]{nums.get(low),nums.get(i)});
                }
                low++;
            }else{
                high--;
            }
        }
        // Replace this placeholder return statement with your code
        return pairArray.size();
    }
    private static MyBTree.Node lowestCommonAncestorTwoPointerBetter(MyBTree myTree, int left,int right) {


        MyBTree.Node node1= myTree.lookup(left);
        MyBTree.Node node2= myTree.lookup(right);
        MyBTree.Node itr1=node1;
        MyBTree.Node itr2=node2;

        while(node1!=null && node2!=null && itr1.value!=itr2.value){
            itr1= itr1.parent;
            if(itr1==null){

                itr1=node2;
            }
            itr2= itr2.parent;
            if(itr2==null){
                itr2=node1;
            }

            System.out.println("-->"+itr1.value+"<--"+"-->"+itr2.value+"<--");
        }
        return itr1;

    }


    private static MyBTree.Node lowestCommonAncestorBetter(MyBTree myTree, int left,int right) {


        MyBTree.Node node1= myTree.lookup(left);
        MyBTree.Node node2=  myTree.lookup(right);

        while(node1!=null && node2!=null && node1.value!=node2.value){
            node1= node1.parent;
            node2= node2.parent;
        }
        return node1;

    }

    private static MyBTree.Node lowestCommonAncestor(MyBTree myTree, int left,int right) {

       List<MyBTree.Node> lookupH1=  findHirerecyOftree(myTree,left);
       List<MyBTree.Node> lookupH2=  findHirerecyOftree(myTree, right);

       /* with no parent
       Collections.reverse(lookupH1);
       Collections.reverse(lookupH2);


        for(MyBTree.Node n1:lookupH1){
           for(MyBTree.Node n2:lookupH2){
                if(n1.value==n2.value){
                    return n1;
                }

           }

       }*/

        MyBTree.Node prev = myTree.getHead();
        for(int i=0,j=0;(i<lookupH1.size() || j<lookupH2.size());i++,j++){
            if(lookupH1.get(i).equals(lookupH2.get(j))){
                prev= lookupH1.get(i);
            }else{
                break;
            }
        }
        return prev;
    }

    private static List<MyBTree.Node> findHirerecyOftree(MyBTree tree,int value) {
        List<MyBTree.Node> result=new ArrayList();
        MyBTree.Node current=tree.getHead();
        if(tree.getHead().value==value){
            result.add(tree.getHead());
            return result;
        }
        while(current!=null){
            result.add(current);
            if(current.value>=value){
                current=current.left;

            }else{
                current=current.right;
            }

            if(current!=null && current.value==value){
                result.add(current);
                break;
            }
        }

        return result;

    }


    //  Next Palindrome Using Same Digits
    public static String findNextPalindromeBetter(String numStr) {
        char[] strArray=numStr.toCharArray();
        if(numStr.length()==1){
            return "";
        }
        int firtHalfIndex=strArray.length/2-1;


        char middle = 0;
        List<Character> list=new ArrayList<>();
        for(int m=0;m<=firtHalfIndex;m++){
            list.add(strArray[m]);
        }

        int i=firtHalfIndex-1;
        while(i>=0 && list.get(i)>=list.get(i+1)){
            i--;
        }

        if(i==-1){
            return "";
        }

                
        int j=firtHalfIndex;
        while(j>i && list.get(i)>=list.get(j)){
            j--;
        }

        Collections.swap(list,i,j);
        Collections.reverse(list.subList(i+1,firtHalfIndex+1));

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        if(strArray.length%2!=0){
            middle=strArray[firtHalfIndex+1];
            sb.append(middle);
        }


        Collections.reverse(list);
        for (char c : list) {
            sb.append(c);
        }


        // Replace the following return statement with your code

        if(sb.toString().compareTo(numStr)>0){
            return sb.toString();
        }

        return "";
    }

  //  Next Palindrome Using Same Digits
    public static String findNextPalindrome(String numStr) {
        char[] strArray=numStr.toCharArray();
        int first=strArray.length/2-1;
        int i=first;
        int mov=0;
        while(i>0){

                if(strArray[i]>strArray[i-1]) {
                    int lower = 0;

                    for (int k = i - 1; k < first; k++) {
                        lower = k + 1;
                        for (int m = k + 2; m <= first; m++) {
                            if (strArray[lower] > strArray[m]) {
                                lower = m;
                            }
                        }
                        mov++;
                        char tempfirst = strArray[lower];
                        strArray[lower] = strArray[k];
                        strArray[k] = tempfirst;

                        int secondLower=strArray.length-lower-1;
                        int l=strArray.length-k-1;
                        char tempsecond = strArray[secondLower];
                        strArray[secondLower] = strArray[l];
                        strArray[l] = tempsecond;
                    }
                    break;
                }

            i--;
        }

        // Replace the following return statement with your code
      return mov==0?"":new String(strArray);
    }


    //Minimum Number of Moves to Make Palindrome

    //Minimum Number of Moves to Make Palindrome

    public static int minMovesToMakePalindromeBetter(String str) {

        char[] charArray=str.toCharArray();
        int mov=0;
        for(int i=0,j=charArray.length-1;i<j;i++,j--){
            int k=j;
            for(;k>i;){
                if(charArray[k]==charArray[i]){
                    for(int l=k;l<j;l++){
                        char temp=charArray[l];
                        charArray[l]=charArray[l+1];
                        charArray[l+1]=temp;
                        mov++;
                    }
                    break;
                }
                k--;
                if(k==i){
                    mov=mov+charArray.length/2-i;
                }
            }

        }


        return mov;

    }

    public static int minMovesToMakePalindrome(String str) {
        char[] charArray=str.toCharArray();
        int left=0;
        int right=charArray.length-1;
        int mov=0;
        while(left<=right) {
            if (charArray[left] != charArray[right]){
                int middle = right;
                while (middle >= left + 1) {
                    if (charArray[left] == charArray[middle]) {
                        for (int i = middle; i < right; i++) {
                            char temp = charArray[i];
                            charArray[i] = charArray[i + 1];
                            charArray[i + 1] = temp;
                            mov++;

                        }
                        break;
                    }else{
                        if(middle==left+1){
                            char temp = charArray[middle];
                            charArray[middle] = charArray[left];
                            charArray[left] = temp;
                            mov++;
                        }
                    }
                    middle--;

                }


            }
                left++;
                right--;

        }
        System.out.println("charArray : "+charArray.toString());

        // Replace this placeholder return statement with your code
        return mov;
    }
    //Strobogrammatic Number

    public static boolean isStrobogrammaticBetter (String num) {

      if(num==null){
        return false;
      }
        Map<Character ,Character> dict=new HashMap<>();
        dict.put('0','0');
        dict.put('1','1');
        dict.put('8','8');
        dict.put('6','9');
        dict.put('9','6');
        char[] numArray=num.toCharArray();
        int left=0;
        int right=numArray.length-1;

        if(left<=right){
            if(!dict.containsKey(numArray[left]) || !dict.containsKey(numArray[right]) ||  !dict.get(numArray[left]).equals(numArray[right])) {
                return false;
            }
        }

        return true;
    }
    public static boolean isStrobogrammatic (String num)
    {

        char[] numArray=num.toCharArray();
        int left=0;
        int right=numArray.length-1;

        while(left<=right){
            if(numArray[left]=='1' || numArray[left]=='6' || numArray[left]=='9'|| numArray[left]=='8' || numArray[left]=='0'
               || numArray[right]=='1' || numArray[right]=='6' || numArray[right]=='9'|| numArray[right]=='8' || numArray[right]=='0'){
                if((numArray[left]=='6' && numArray[right]=='9')
                    || (numArray[left]=='9' && numArray[right]=='6')){

                    right--;
                    left++;;
                }else if((numArray[left]=='1' || numArray[left]=='8' || numArray[left]=='0') && numArray[left]==numArray[right]){

                    right--;
                    left++;;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }



        // Replace this placeholder return statement with your code
        return true;
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
