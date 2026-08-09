package ravi.algo.concepts;

import java.util.*;

public class KWayMerge {

    public static void main(String[] args) {


        // merge-sorted-array

        int[] m = {9, 2, 3, 1, 8};
        int[] n = {6, 1, 4, 2, 1};
        int[][] nums1 = {
                {23, 33, 35, 41, 44, 47, 56, 91, 105, 0, 0, 0, 0, 0, 0},
                {1, 2, 0},
                {1, 1, 1, 0, 0, 0, 0},
                {6, 0, 0},
                {12, 34, 45, 56, 67, 78, 89, 99, 0}
        };
        int[][] nums2 = {
                {32, 49, 50, 51, 61, 99},
                {7},
                {1, 2, 3, 4},
                {-45, -99},
                {100}
        };
        int k = 1;
        for (int i = 0; i < m.length; i++) {
            System.out.print(k + ".\tnums1: [");
            for (int j = 0; j < nums1[i].length - 1; j++) {
                System.out.print(nums1[i][j] + ", ");
            }
            System.out.println(nums1[i][nums1[i].length - 1] + "], m: " + m[i]);
            System.out.print("\tnums2: [");
            for (int j = 0; j < nums2[i].length - 1; j++) {
                System.out.print(nums2[i][j] + ", ");
            }
            System.out.println(nums2[i][nums2[i].length - 1] + "], n: " + n[i]);
            mergeSorted(nums1[i], m[i], nums2[i], n[i]);
            System.out.println("\tMerged list: None");
            //   System.out.println(PrintHyphens.repeat("-", 100));
            k += 1;
        }

        // Kth Smallest Number in M Sorted Lists

        List<List<List<Integer>>> lists = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(2, 6, 8),
                        Arrays.asList(3, 6, 10),
                        Arrays.asList(5, 8, 11)
                ),
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5),
                        Arrays.asList(6, 7, 8, 15),
                        Arrays.asList(10, 11, 12, 13),
                        Arrays.asList(5, 10)
                ),
                Arrays.asList(
                        Arrays.asList(),
                        Arrays.asList(),
                        Arrays.asList()
                ),
                Arrays.asList(
                        Arrays.asList(1, 1, 3, 8),
                        Arrays.asList(5, 5, 7, 9),
                        Arrays.asList(3, 5, 8, 12)
                ),
                Arrays.asList(
                        Arrays.asList(5, 8, 9, 17),
                        Arrays.asList(),
                        Arrays.asList(8, 17, 23, 24)
                )
        );

        int[] k2 = {5, 50, 7, 4, 8};

        for (int i = 0; i < k2.length; i++) {
            System.out.println(i + 1 + ".\t Input lists: " + lists.get(i) +
                    "\n\t K = " + k2[i] +
                    "\n\t " + k2[i] + "th smallest number from the given lists is: " +
                    kSmallestNumber(lists.get(i), k2[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Find K Pairs with Smallest Sums

        int[][]list1 = {{2, 8, 9},
                {1, 2, 300},
                {1, 1, 2},
                {4, 6},
                {4, 7, 9},
                {1, 1, 2}
        };

        int[][]list2 = {
                {1, 3, 6},
                {1, 11, 20, 35, 300},
                {1, 2, 3},
                {2, 3},
                {4, 7, 9},
                {1}
        };
        int[] k3 = {9, 30, 1, 2, 5, 4};
        for(int i=0; i<k3.length; i++){
            List<List<Integer>> result = kSmallestPairs(list1[i], list2[i], k3[i]);
            System.out.print(i+1);
            System.out.println(".\tInput lists: "+Arrays.toString(list1[i])+ ", "+ Arrays.toString(list2[i]));
            System.out.println("\tK = "+k3[i]);
            System.out.print("\tPairs with smallest sum are: "+ result);
            System.out.println("\n");
          //  System.out.println(PrintHyphens.repeat("-", 100));
        }

        // Merge K Sorted Lists
        List<List<List<Integer>>> inputLists = Arrays.asList(
                Arrays.asList(Arrays.asList(21, 23, 42), Arrays.asList(1, 2, 4)),
                Arrays.asList(Arrays.asList(11, 41, 51), Arrays.asList(21, 23, 42)),
                Arrays.asList(Arrays.asList(2), Arrays.asList(1, 2, 4), Arrays.asList(25, 56, 66, 72)),
                Arrays.asList(Arrays.asList(11, 41, 51), Arrays.asList(2), Arrays.asList(2), Arrays.asList(2), Arrays.asList(1, 2, 4)),
                Arrays.asList(Arrays.asList(10, 30), Arrays.asList(15, 25), Arrays.asList(1, 7), Arrays.asList(3, 9), Arrays.asList(100, 300), Arrays.asList(115, 125), Arrays.asList(10, 70), Arrays.asList(30, 90))
        );

        for (int i = 0; i < inputLists.size(); i++) {
            System.out.println((i + 1) + ".\tInput lists:");
            ListNode[] listNodes = new ListNode[inputLists.get(i).size()];

            for (int j = 0; j < inputLists.get(i).size(); j++) {
                List<Integer> x = inputLists.get(i).get(j);
                LinkedList a = new LinkedList(x); // assuming this builds the linked list from List<Integer>
                listNodes[j] = a.head;
                System.out.print("\t");
                PrintList.display(a.head);
                System.out.println();
            }

            System.out.print("\tMerged list: \n\t");
            PrintList.display(mergeKListsHeap(listNodes));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // Kth Smallest Element in a Sorted Matrix

        int[][][] matrix = {{{2, 6, 8},
                {3, 7, 10},
                {5, 8, 11}},

                {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}},

                {{5}},

                {{2, 5, 7, 9, 10},
                        {4, 6, 8, 12, 14},
                        {11, 13, 16, 18, 20},
                        {15, 17, 21, 24, 26},
                        {19, 22, 23, 25, 28}},

                {{3, 5, 7, 9, 11, 13},
                        {6, 8, 10, 12, 14, 16},
                        {15, 17, 19, 21, 23, 25},
                        {18, 20, 22, 24, 26, 28},
                        {27, 29, 31, 33, 35, 37},
                        {30, 32, 34, 36, 38, 40}}};

        int [] ksm = {3, 4, 1, 10, 15};
        for(int i=0; i<ksm.length; i++){
            System.out.print(i+1);
            System.out.println(".\tInput matrix: "+ Arrays.deepToString(matrix[i]));
            System.out.println("\tK =  "+ksm[i]);
            System.out.println("\tKth smallest number in the matrix is: "+kthSmallestElement(matrix[i], ksm[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // kth-smallest-prime-fraction

        int[][] testCases = {
                {1, 3, 5, 7, 9, 11},
                {1, 7, 23, 29, 47},
                {1, 2, 3, 5},
                {1, 2, 3, 5},
                {1, 13, 17, 19, 23, 29, 31}
        };
        int[] ks = {2, 3, 3, 1, 4};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println((i + 1) + ".\tArray: " + Arrays.toString(testCases[i]) + ", k: " + ks[i]);
            int[] result = kthSmallestPrimeFraction(testCases[i], ks[i]);
            System.out.println("\tKth smallest prime fraction is: [" + result[0] + ", " + result[1] + "]");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[] nValues = {12, 1, 15, 10, 8};
        int[][] primesList = {
                {2, 7, 13, 19},
                {2, 3, 5},
                {3, 5, 7},
                {2, 5, 11},
                {3, 11, 17}
        };

        for (int i = 0; i < nValues.length; i++) {
            System.out.println((i+1)+ ".\tn: " + nValues[i]);
            System.out.println("\tprimes: "+ Arrays.toString(primesList[i]));
            int result = nthSuperUglyNumber(nValues[i], primesList[i]);
            System.out.println("\n\t" + nValues[i] + "th super ugly number is " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }


    // Super Ugly Number

    public static int nthSuperUglyNumber(int n, int[] primes) {

        PriorityQueue<long[]> minHeap=new PriorityQueue<>(Comparator.comparingLong(a->a[0]));

        for(int i=0;i<primes.length;i++){
            minHeap.offer(new long[]{primes[i],primes[i],0});
        }

        List<Integer> ugly=new ArrayList<>();
        ugly.add(1);

        while(ugly.size()<n){
            long[] smallest=minHeap .poll();
            long nexyUgly=smallest[0];
            long prime=smallest[1];
            int index=(int)smallest[2];

            if(nexyUgly!=ugly.get(ugly.size()-1)){
                ugly.add((int)nexyUgly);
            }

            minHeap.offer(new long[]{prime*ugly.get(index+1),prime,index+1});

        }


        // Replace this placeholder return statement with your code
        return ugly.get(n-1);
    }


 // kth-smallest-prime-fraction
    /*
    When you pop a fraction arr[i]/arr[j] from the heap:

You push the next row down from the same column j → which is arr[i+1]/arr[j]

Since arr is sorted:

arr[i+1] > arr[i]

So arr[i+1]/arr[j] > arr[i]/arr[j]

     */

    // Any unvisited fraction will not be smaller than the smallest item currently in the heap.
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        PriorityQueue<double[]> minHeap=new PriorityQueue<>(Comparator.comparingDouble(a->a[0]));

        for(int i=1;i<n;i++){
            minHeap.offer(new double[]{(double)arr[0]/arr[i],0,i});
        }

        for(int i=0;i<k-1;i++){
            double[] smallest=minHeap.poll();
            int numerator=(int)smallest[1];
            int denominator=(int)smallest[2];

            if(numerator+1<denominator){
                minHeap.offer(new double[]{(double)(arr[numerator+1])/arr[denominator],numerator+1,denominator});
            }

        }
        double[] kSmallest=minHeap.poll();
        // Replace the following placeholder return statement with your code
        return new int[]{arr[(int)kSmallest[1]],arr[(int)kSmallest[2]]};
    }


    //
    public static ListNode merge2ListsDAC(ListNode head1, ListNode head2) {

        // Replace this placeholder return statement with your code
        ListNode dummy=new ListNode(-1);

        ListNode prev=dummy;

        while(head1!=null && head2!=null){

            if(head1.value<head2.value){
                prev.next=head1;
                head1=head1.next;
            }else{
                prev.next=head2;
                head2=head2.next;
            }
            prev=prev.next;

        }

        if(head1==null){
            prev.next=head2;
        }else{
            prev.next=head1;
        }

        return dummy.next;
    }


// Kth Smallest Element in a Sorted Matrix

    public static int kthSmallestElement(int[][] matrix, int k) {

        PriorityQueue<int[]> minHeap=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for(int i=0;i<Math.min(matrix.length,k);i++){
            minHeap.offer(new int[]{matrix[i][0],i,0});
        }

        int smallKelement=-1;
        int count=0;
        while(!minHeap.isEmpty()){
            int[] smallest=minHeap.poll();
            smallKelement=smallest[0];
            int rowIndex=smallest[1];
            int colIndex=smallest[2];
            count++;
            if(k==count)
                break;

            int nextColIndex=colIndex+1;
            if(nextColIndex<matrix[rowIndex].length){
                minHeap.offer(new int[]{matrix[rowIndex][nextColIndex],rowIndex,nextColIndex});
            }

        }


        // Replace this placeholder return statement with your code
        return smallKelement;
    }



    // Merge K Sorted Lists
    public static ListNode mergeKListsDAC(ListNode[] lists) {

        // Replace this placeholder return statement with your code
        if(!Objects.isNull(lists) && lists.length>0){
            int step =1;
            while(step<lists.length) {
                for (int i = 0; i < lists.length - step;i+=step*2 ){
                    lists[i]=merge2ListsDAC(lists[i],lists[i+step]);
                }
                step*=2;
            }
            return lists[0];
        }else{
            return null;
        }


    }


    // Merge K Sorted Lists
    public static ListNode mergeKListsHeap(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap=new PriorityQueue<>(Comparator.comparingInt((node)->node.value));
        ListNode dummy=new ListNode(0);
        for(ListNode first:lists){
            if (first != null)
                minHeap.offer(first);
        }
        ListNode current = dummy;
        while(!minHeap.isEmpty()){
            ListNode smallest= minHeap.poll();
            current.next=smallest;
            current=current.next;
            if(smallest.next!=null){
                minHeap.offer(smallest.next);
            }
        }
        // Replace this placeholder return statement with your code
        return dummy.next;
    }

    // Find K Pairs with Smallest Sums
    public static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int target) {

        // Replace this placeholder return statement with your code
        if(Objects.isNull(list1) || Objects.isNull(list2) || list1.length==0 || list2.length==0)
            return null;

       PriorityQueue<int[]> minHeap=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
       List<List<Integer>> result=new ArrayList<>();

       for(int i=0;i<list1.length;i++){
           minHeap.offer(new int[]{list1[i]+list2[0],i,0});
       }
       int count=0;
       while(!minHeap.isEmpty() && count<target){
           int[] smallest=minHeap.poll();
        //   int smallestValue=smallest[0];
           int list1Index=smallest[1];
           int list2Index=smallest[2];
           List<Integer> subResult=new ArrayList<>();
           subResult.add(list1[list1Index]);
           subResult.add(list2[list2Index]);
           result.add(subResult);
           count++;
           int nextList2Index=list2Index+1;
           if(nextList2Index<list2.length){
               minHeap.offer(new int[]{list1[list1Index]+list2[nextList2Index],list1Index,nextList2Index});
           }

       }

       return result;
    }


    // Kth Smallest Number in M Sorted Lists


    public static int kSmallestNumber(List<List<Integer>> lists, int k) {

        // Replace this placeholder return statement with your code
        if(Objects.isNull(lists) && lists.size()==0){
            return -1;
        }
        PriorityQueue<int[]> minHeap=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for(int i=0;i<lists.size();i++){
            if(Objects.isNull(lists.get(i)) || lists.get(i).size()==0){
                continue;
            }else {
                minHeap.offer(new int[]{lists.get(i).get(0), i, 0});
            }
        }



        int numbersChecked = 0, smallestNumber = 0;
        while(!minHeap.isEmpty()){
            int[] elements=minHeap.poll();
            smallestNumber=elements[0];
            int listIndex=elements[1];
            int elementIndex=elements[2];
            numbersChecked++;

            if(numbersChecked==k)
                break;



            if(elementIndex+1<lists.get(listIndex).size()){
                minHeap.offer(new int[]{lists.get(listIndex).get(elementIndex+1),listIndex,elementIndex+1});
            }
        }

        return smallestNumber;
    }


    // merge-sorted-array
    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;

        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }

            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }


        }
        return nums1;
    }

}