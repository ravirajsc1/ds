package ravi.sort;



public class MergeSort {
public static void main(String str[]){


}

public void merge(int[] arr,int p, int q, int r){

    int n1=q-p+1;
    int n2=r-q;
    int[] L= new int[n1];
    int[] R= new int[n2];
    for(int i=0;i<n1;i++){
        L[i]=arr[p+i];
    }
    for(int j=0;j<n2;j++){
        R[j]=arr[q+1+j];
    }
    L[n1+1]=0;
    R[n2+1]=0;
    int i=0;
    int j=0;
    for (int k=p;k<=r;k++){
        if(L[i]<=R[j]){
            arr[k]=L[i];
            i=i+1;
        }
        else{
            arr[k]=R[j];
            j=j+1;

        }

    }

}

public void mergeSort(int[] arr, int p, int r){
    if(p<r) {
        int q = p + (r-p) / 2;
        System.out.println("P: +"+p+"Q: +"+q+"R: +"+r);
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);
        merge(arr, p, q, r);
    }
}

}
