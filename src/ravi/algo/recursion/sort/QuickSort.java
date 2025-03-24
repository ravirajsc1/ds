package ravi.algo.recursion.sort;



public class QuickSort
{

    public static void main(String[] args) {
        QuickSort quickSort=new QuickSort();
        // int[] array = {10, 3, 8, 15, 6, 12, 18, 2};
        //int[] array = {10, 3,8,15,12, 11, 13, 5, 6, 7};
      //  int[] array = {4, 10, 3, 8, 15, 12, 11, 13, 5, 6, 7};
        int[] array = {5, 3, 8, 3, 9, 3, 10, 3, 1};  // Completely reversed array
        quickSort.quickSorfun(array,0,array.length-1);
        printArray(array);
    }

    private void quickSorfun(int[] array,int start, int end) {

            if(end>start){
                int keyIndex=end;
                int length=end-start;

                for(int i=start;i<=keyIndex;){
                    if(array[i]>array[keyIndex]){
                        int temp1=array[i];
                      //  int temp2=array[keyIndex-1];
                        array[i]=array[keyIndex-1];
                        array[keyIndex-1]=array[keyIndex];
                        array[keyIndex]=temp1;
                        keyIndex--;
                    }else{
                        i++;
                    }
                }

                System.out.println("hold");

                quickSorfun(array,start,keyIndex-1);
                quickSorfun(array,keyIndex+1,end);
            }

    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
