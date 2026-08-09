package ravi.algo.concepts;
import java.util.*;

public class CyclingSort {

    public static void main(String[] args) {



        List<int[]> testCases = Arrays.asList(
                new int[]{3, 1, 5, 4, 2},
                new int[]{4, 3, 2, 1, 5, 6},
                new int[]{1},
                new int[]{1, 2, 3, 4, 5},
                new int[]{5, 4, 3, 2, 1}
        );

        for (int i = 0; i < testCases.size(); i++) {
            int[] nums = testCases.get(i);
            System.out.println((i + 1) + ". Input:  " + Arrays.toString(nums));

            cyclicSort(nums);

            System.out.println("   Output: " + Arrays.toString(nums));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Missing Number

        int[][] inputNumbers = {
                {4, 0, 3, 1},
                {8, 3, 5, 2, 4, 6, 0, 1},
                {1, 2, 3, 4, 6, 7, 8, 9, 10, 5},
                {0},
                {1, 2, 3, 0, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23}
        };

        for (int i = 0; i < inputNumbers.length; i++) {
            System.out.print(i + 1 + ".\tnums: [");

            for (int j = 0; j < inputNumbers[i].length - 1; j++) {
                System.out.print(inputNumbers[i][j]);
                System.out.print(", ");
            }

            System.out.println(inputNumbers[i][inputNumbers[i].length - 1] + "]");

            System.out.println("\n\tMissing number: " + findMissingNumber(inputNumbers[i]));
         //   System.out.println(PrintHyphens.repeat("-", 100));
        }

        int[][] A = {
                {1, 2, 3, 4},
                {-1, 3, 5, 7, 1},
                {1, 5, 4, 3, 2},
                {-1, 0, 2, 1, 4},
                {1, 4, 3}
        };
        for (int i = 0; i < A.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tThe first missing positive integar in the list " + Arrays.toString(A[i]) + " is:");
            System.out.println("\t" + firstMissingPositiveInteger(A[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[][] array = {{3, 1, 2, 5, 2},
                {3, 1, 2, 3, 6, 4},
                {4, 1, 2, 1, 6, 3},
                {4, 3, 4, 5, 1},
                {5, 3, 5, 6, 2, 1}};

        for (int i = 0; i < array.length; i++) {
            System.out.print(i + 1);
            System.out.print(".\tGiven array: " + Arrays.toString(array[i]));
            System.out.print("\n\tCorrupt pair: ");
            System.out.print(findCorruptPair(array[i])[0]);
            System.out.print(", ");
            System.out.println(findCorruptPair(array[i])[1]);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }



        // Test cases
        int[][] testCasesD = {
                {3, 6, 7, 10},
                {2, 21, 12, 1},
                {0, 0, 1, 1},
                {100, 200, 300, 400},
                {10, 100, 1000, 10000}
        };

        for (int i = 0; i < testCasesD.length; i++) {
            System.out.println((i + 1) + ".\t nums: " + Arrays.toString(testCasesD[i]));
            int[] result = sortArrayByParityII(testCasesD[i]);
            System.out.println("\t Output: " + Arrays.toString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        int[] test=new int[]{1,2,3,4,5};
        firstKMissingNumbers(test,6);
    }

    // Find the First K Missing Positive Numbers

    public static List<Integer> firstKMissingNumbers(int[] arr, int k) {


        // Replace this placeholder return statement with your code
        List<Integer> result=new ArrayList<>();
        int n=arr.length;
        int i=0;
        while(i<n){
            int correct=arr[i]-1;
            if(arr[i]>0 && arr[i]<=n && arr[correct]!=arr[i]){
                swapElements(arr,i,correct);
            }else{
                i++;
            }

        }

    // step 2 add missing value from 1 to n
        for(int j=0;result.size()<k;j++){
            if(arr[j]!=j+1){
                result.add(j+1);
            }
        }

        Set<Integer> set=new HashSet<>();

        for(int num:arr){
            if(num>0){
                set.add(num);
            }
        }

        int nexNum=n+1;

        while(result.size()<k){
            if(!set.contains(nexNum)){
                result.add(nexNum);
            }
            nexNum++;
        }

        // Replace this placeholder return statement with your code
        return result;

    }

    public static int[] sortArrayByParityII (int[] nums)
    {

        int even=0,odd=1;
        int n=nums.length;
        while(even<n && odd<n){
            if(nums[even]%2==0){
                even+=2;
            }else if(nums[odd]%2==1){
                odd+=2;
            }else{
                swapElements(nums,even,odd);
                even+=2;
                odd+=2;
            }

        }
        // Replace this placeholder return statement with your code
        return nums;
    }


    public static int[] findCorruptPair(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correctIndex=nums[i]-1;
            if(nums[i]!=nums[correctIndex]){
                swapElements(nums,i,correctIndex);
            }else{
                i++;
            }

        }

        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                return new int[]{j+1,nums[j]};
            }
        }

        // Replace this placeholder return statement with your code
        return new int[]{0, 0};
    }

    public static int firstMissingPositiveInteger(int[] nums) {

        int i=0;

        while(i<nums.length){
            int correctIndex=nums[i]-1;

            if(correctIndex>=0 && correctIndex<nums.length && nums[i]!=nums[correctIndex]){
                swapElements(nums,i,correctIndex);
            }else{
                i++;
            }
        }

        for(int j=0;j<nums.length;j++){
            if(j+1!=nums[j]){
                return j+1;
            }
        }
        return  nums.length + 1;

    }


    public static int[] cyclicSort(int[] nums)
    {
        int i=0;

       while(i<nums.length){
           int correctIndex=nums[i]-1;
           if(nums[correctIndex]!=nums[i]){
               swapElements(nums,correctIndex,i);
           }else{
               i++;
           }


       }
        // Replace this placeholder return statement with your code
        return nums;
    }

    private static void swapElements(int[] nums, int index1, int index2) {
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }

    // Missing Number

    public static int findMissingNumber(int[] arr) {

        // Your code will replace this placeholder return statement
        int i=0;

        while(i<arr.length){

            if(i!=arr[i] && arr[i]<arr.length) {
                swapElements(arr, i, arr[i]);
            }else{
                i++;
            }

        }

        for(int j=0;j<arr.length;j++){
            if(j!=arr[j])
                return j;
        }
        return -1;
    }


}
