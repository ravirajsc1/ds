package ravi.ds.array.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SumArrayElement {
    public static void main(String[] args) {
        Integer[] sortedArray = new Integer[]{1, 2 ,5, 9};
        Integer[] unSorrtedArray = new Integer[]{6, 5, 4, 9,4};
         System.out.println("does it contain two numbers with sum 8 = "+checkSumSorted(sortedArray,8));
        System.out.println("does it contain two numbers with sum  8 = " + checkSumBetterNonSorted(unSorrtedArray, 8));


    }

    private static Boolean checkSumSorted(Integer[] inputArray, int sumVal) {
        if (Objects.nonNull(inputArray) && inputArray.length > 0) {
            int low = 0;
            int high = inputArray.length - 1;
            while (low < high) {

                int sum = inputArray[low] + inputArray[high];
                System.out.println("Low : " + low + " High " + high + " sum " + sum);

                if (sum == sumVal) {
                    return true;

                } else if (sum < sumVal) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return false;
    }


    private static Boolean checkSumBetterNonSorted(Integer[] inputArray, int sumVal) {
        Boolean result = false;
        if (Objects.nonNull(inputArray) && inputArray.length > 0) {
            Set<Integer> complements = new HashSet<>();
            return Arrays.stream(inputArray).anyMatch(num -> validateSum(num, complements, sumVal));
        }
        return false;
    }

    private static boolean validateSum(Integer num, Set<Integer> complements, int sumVal) {
        System.out.println("complements: "+complements+" complements.contains( - num)):"+complements.contains(num));
        if (complements.contains(num)) {

            return true;
        } else {
            complements.add(sumVal-num);
        }
    //    System.out.println("complements "+complements);
        return false;
    }

}
