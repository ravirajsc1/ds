package ravi.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main (String str[]){

        int[] arr ={2,4,5,7,1,2,3,6};
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            System.out.println("key ="+arr[i]+" I="+i);
            int j=i-1;
            System.out.println("arr[j] "+arr[j]);
            while(j>=0 && arr[j]<key){
                System.out.println(" BEFROE arr[j+1]=" + arr[j+1]  +" arr[j]="+arr[j]+" j="+j);
                arr[j+1]=arr[j];
                System.out.println( " AFTER arr[j+1]=" + arr[j+1] );

                j=j-1;
            }
            System.out.println( "final  j=" + j );
            arr[j+1]=key;
        }

        for(int i=0;i<arr.length;i++) {

            System.out.println("Sorted Array=" + arr[i]);
        }
    }
}
