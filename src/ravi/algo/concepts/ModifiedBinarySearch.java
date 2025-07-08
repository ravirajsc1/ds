package ravi.algo.concepts;

import java.util.*;

public class ModifiedBinarySearch {
    public static void main(String[] args) {

        // binary search

        int[][] numsLists = {
                {1},
                {0, 1},
                {1, 2, 3},
                {-1, 0, 3, 5, 9, 12},
                {-100, -67, -55, -50, -49, -40, -33, -22, -10, -5}
        };

        int[] targetList = {12, 1, 3, 9, -22};

        for (int i = 0; i < numsLists.length; i++) {
            int[] nums = numsLists[i];
            int target = targetList[i];
            int index = binarySearch(nums, target);
            System.out.println((i + 1) + ".\tArray to search: " + Arrays.toString(nums));
            System.out.println("\tTarget: " + target);
            if (index != -1) {
                System.out.println("\t" + target + " exists in the array at index " + index);
            } else {
                System.out.println("\t" + target + " does not exist in the array, so the return value is " + index);
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Search in Rotated Sorted Array

            int[][] numArrays = {
                    {5, 6, 7, 1, 2, 3, 4},
                    {40, 50, 60, 10, 20, 30},
                    {47, 58, 69, 72, 83, 94, 12, 24, 35},
                    {77, 82, 99, 105, 5, 13, 28, 41, 56, 63},
                    {48, 52, 57, 62, 68, 72, 5, 7, 12, 17, 21, 28, 33, 37, 41}
            };

            int[] targetArray = {1, 50, 12, 56, 5};

            for (int i = 0; i < targetArray.length; i++) {
                System.out.println((i + 1) + ".\tRotated array: " + Arrays.toString(numArrays[i]) +
                        "\n\ttarget " + targetArray[i] +
                        " found at index " + binarySearchRotated(numArrays[i], targetArray[i]));
                System.out.println(new String(new char[100]).replace('\0', '-'));
            }

        int[] versions = {6, 8, 9, 11, 8};
        int[] badVersions = {3, 5, 1, 11, 4};

        for (int i = 0; i < versions.length; i++) {
           // Solution solution = new Solution(badVersions[i]);
            System.out.println((i + 1) + ".\tNumber of versions: " + versions[i]);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

    // bad version

    public static int firstBadVersion(int n) {

        // Replace this placeholder return statement with your code
        return 0;
    }

    // Search in Rotated Sorted Array

    public static int binarySearchRotated(int[] nums, int target) {

        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[left]<nums[mid]){
                if(nums[left]<= target && target <nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(nums[mid]< target && target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }

            }


        // Replace this placeholder return statement with your code
        return -1;
    }


    //binary search
    public static int binarySearch (int [] nums, int target) {

        int left=0;
        int right=nums.length-1;


        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }

        // Replace this placeholder return statement with your code
        return -1;
    }


}


