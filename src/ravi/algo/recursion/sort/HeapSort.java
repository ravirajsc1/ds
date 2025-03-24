package ravi.algo.recursion.sort;

import ravi.ds.tree.HeapTree;

import java.util.Arrays;

public class HeapSort {


    public static void main(String str[]){
        int[] arr ={2,4,5,7,1,2,3,6};
        //
        HeapSort sort=new HeapSort();
        sort.printArray(arr);
        System.out.println("\n heapfy :  ");
        sort.heapsort(arr,arr,0);
        sort.printArray(arr);

    }

    private int parent(int i){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return 2*i+1;
    }

    private int rightChild(int i){
        return 2*i+2;
    }

    public void heapsort(int[] orginalArray,int[] array,int min){
        if(min>=orginalArray.length){
            return;
        }


        int[] heapifedArray=heapify(array);

        orginalArray[min]=heapifedArray[0];
        min++;
        int[] subArray=new int[heapifedArray.length-1];
        for(int i=1;i<heapifedArray.length;i++){
            subArray[i-1]=heapifedArray[i];
        }
        heapsort(orginalArray,subArray,min );

    }

    public int[] heapify(int[] array){
        int[] htree=new int[array.length];
        for(int i=0;i<array.length;i++){
            insertInHeapTree(htree,i,array[i]);
        }
        return htree;
    }

    public void insertInHeapTree(int[] htree,int index,int value){

        htree[index]=value;
        int current=index;
        while(current>=0 && htree[current]>htree[parent(current)]) {
            swap(htree,current,parent(current));
            current=parent(current);
        }

    }


    public void swap(int[] array,int i, int j){
        int temp=array[j];
        array[j]=array[i];
        array[i]=temp;
    }


    public  void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(" "+array[i]);

        }
    }

}
