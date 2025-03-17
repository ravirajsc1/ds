package ravi.algo.recursion.sort;

import java.util.Arrays;


public class BetterHeapSort {

    public static void main(String str[]){
        int[] arr = {2, 4, 5, 7, 1, 2, 3, 6};
        BetterHeapSort sort = new BetterHeapSort();
        sort.printArray(arr);
        System.out.println("\nHeapSort: ");
        sort.heapSort(arr);
        sort.printArray(arr);
    }

    // Swap function
    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Heapify function to maintain the max-heap property
    public void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }
    //int[] arr = {2, 4, 5, 7, 1, 2, 3, 6};

    2
    4 5
    7 1 2 3
    6


    // Build heap (max heap)
    public void buildMaxHeap(int[] array) {
        int n = array.length;
        // Start from the last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
    }

    // Main HeapSort function
    public void heapSort(int[] array) {
        int n = array.length;

        // Build a max-heap
        buildMaxHeap(array);

        // One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (max element) with the last element
            swap(array, 0, i);

            // Call heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    // Function to print the array
    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }
}
