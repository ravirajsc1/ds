package ravi.algo.recursion.sort;

import java.util.Arrays;

public class BasicSorting {

    public static void main(String[] args) {
        int[] array=new int[]{4,8,2,4,9,5,3,9,3,1};
        BasicSorting sorting=new BasicSorting();
        printArray(array);
        Arrays.stream(array).forEach(System.out::print);
        System.out.println("");
        System.out.println("Bubble:-");
        printArray(sorting.bubbleSortFn(array));
        System.out.println("");
        int[] arra2 = {10, 3, 8, 15, 6, 12, 2, 18, 7, 5};
        int[] arr3={10, 3, 8, 15, 6, 12, 2, 18, 7, 5};;
        System.out.println("Selection:-");
        printArray(sorting.selectioSortFn(arra2));

        System.out.println("insertion:-");
        printArray(sorting.selectioSortFn(arr3));
        int[] arry3={10, 3, 8, 15, 6, 12, 2, 18};;
     }
    public int[] bubbleSortFn(int[] array){

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }

    public int[] selectioSortFn(int[] array){
       // int[] arra2 = {10, 3, 8, 15, 6, 12, 2, 18, 7, 5};
        for(int i=0;i<array.length;i++){
            int minIndex=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j] < array[minIndex]){
                    minIndex=j;
                }
            }
            int temp=array[minIndex];
            array[minIndex]=array[i];
            array[i]=temp;

        }
        return array;
    }


    // int[] arra2 = {10, 3, 15, 8, 6, 12, 2, 18, 7, 5};
//3,10,15

    public int[] insertionSortfn(int[] array){
        for(int i=1;i<array.length;i++){
            int key=array[i];//
            int j=i-1;
            while(j>=0 && key<array[j] ){
                    array[j+1] = array[j];
                    j--;
            }
            array[j+1]=key;
        }
        return array;
    }


    // Utility function to print the array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
