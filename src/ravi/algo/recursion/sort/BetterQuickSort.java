package ravi.algo.recursion.sort;

import java.util.Arrays;

public class BetterQuickSort {

    public static void main(String[] args) {
        BetterQuickSort quickSort = new BetterQuickSort();
        int[] array = {10, 3, 8, 15, 12, 11, 13, 5, 6, 7};

        System.out.println("Original array: " + Arrays.toString(array));
        quickSort.quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    private void quickSort(int[] array, int start, int end) {
        if (start < end) {  // ✅ Correct base case
            int pivotIndex = partition(array, start, end);
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end]; // ✅ Choosing the last element as pivot
        int i = start - 1;  // ✅ Index of smaller elements

        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, end); // ✅ Place pivot in the correct position
        return i + 1; // ✅ Return pivot index
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
