package ravi.ds.array.basic;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortedArray {
    public static void main(String str[]) {

        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] sortedArray1 = new int[]{1, 3, 7, 9};
        int[] sortedArray2 = new int[]{2, 4, 6, 7, 8};

        System.out.println("Final Sorted Array :" + mergeSortedArray.sortTwoArray(sortedArray1, sortedArray2));

        Integer[] sortedArray1Integer={1, 3, 7, 9};
        Integer[] sortedArray2Integer={2, 4, 6, 7, 8};
        List<Integer> sortedArray=Stream.concat(Arrays.stream(sortedArray1Integer),Arrays.stream(sortedArray2Integer)).sorted().collect(Collectors.toList());

        System.out.println("java stream Array :" + sortedArray);

    }

    private String sortTwoArray(int[] sortedArray1, int[] sortedArray2) {

        int[] mergedSortedArray = new int[sortedArray1.length + sortedArray2.length];
        int i = 0, j = 0, k = 0;
        while (i< sortedArray1.length && j< sortedArray2.length) {
            if ( sortedArray1[i] < sortedArray2[j]) {
                mergedSortedArray[k] = sortedArray1[i];
                i++;
            } else {
                mergedSortedArray[k] = sortedArray2[j];
                j++;
            }
            k++;
        }

        while(i<sortedArray1.length){
            mergedSortedArray[k]=sortedArray1[i];
            i++;
            k++;
        }
        while(j<sortedArray2.length){
            mergedSortedArray[k]=sortedArray2[j];
            j++;
            k++;
        }
        System.out.println("Merged Array"+Arrays.toString(mergedSortedArray));

        return Arrays.toString(mergedSortedArray);
    }
}

