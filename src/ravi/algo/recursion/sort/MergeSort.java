package ravi.algo.recursion.sort;



public class MergeSort {
public static void main(String str[]){
    MergeSort mergeSort=new MergeSort();
   // int[] array = {10, 3, 8, 15, 6, 12, 18, 2};
    int[] array = {10, 3,8,15,12, 11, 13, 5, 6, 7};
    mergeSort.mergeSort(array,0,array.length-1);
    printArray(array);
}

public void merge(int[] arr,int left, int mid, int right){

    int n1=mid-left+1;
    int n2=right-mid;
    int[] templeft=new int[n1];
    int[] tempRight=new int[n2];

    for(int i=0;i<n1;i++){
        templeft[i]=arr[left+i];
    }

    for(int i=0;i<n2;i++){
        tempRight[i]=arr[mid+i+1];
    }

    int i=0,j=0;
    int k=left;

    while(i<n1 && j<n2){
        if(templeft[i]<tempRight[j]){
            arr[k]=templeft[i];
            i++;
        }else{
            arr[k]=tempRight[j];
            j++;
        }
        k++;
    }

    for(int m=i;m<n1;m++){
        arr[k]=templeft[m];

        k++;
    }

    for(int m=j;m<n2;m++){
        arr[k]=tempRight[m];
        k++;
    }


}

public void mergeSort(int[] arr, int left, int right){
    if(left<right){
        int mid=left+(right-left)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);

        merge(arr,left,mid,right);

    }
}

    // Utility function to print the array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
