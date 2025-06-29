package ravi.algo.concepts;

import java.util.*;

public class Heap {
    public static void main(String[] args) {

        // IP0
        int[] c = {1, 1, 2, 1, 7, 2};
        int[] k = {3, 2, 3, 3, 2, 4};
        int[][] capitals = {
                {0, 1, 2},
                {1, 2, 2, 3},
                {1, 3, 4, 5, 6},
                {1, 2, 3, 4},
                {6, 7, 8, 10},
                {2, 3, 5, 6, 8, 12}
        };
        int[][] profits = {
                {1, 2, 3},
                {2, 4, 6, 8},
                {1, 2, 3, 4, 5},
                {1, 3, 5, 7},
                {4, 8, 12, 14},
                {1, 2, 5, 6, 8, 9}
        };

        for (int i = 0; i < k.length; i++) {
            System.out.println((i + 1) + ".\tProject capital requirements: " + Arrays.toString(capitals[i]));
            System.out.println("\tProject expected profits: " + Arrays.toString(profits[i]));
            System.out.println("\tNumber of projects: " + k[i]);
            System.out.println("\tStart-up capital: " + c[i]);
            System.out.println("\n\tMaximum Capital earned: " + maximumCapital(c[i], k[i], capitals[i], profits[i]));
            //     System.out.println(PrintHyphens.repeat("-", 100));
        }


        // Driver code Find Median from Data Stream
        int[] nums = {35, 22, 30, 25, 1};
        MedianOfStream medianOfAges = null;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i + 1);
            System.out.print(".\tData stream: [");
            medianOfAges = new MedianOfStream();
            for (int j = 0; j <= i; j++) {
                System.out.print(nums[j]);
                if (j != i)
                    System.out.print(", ");
                medianOfAges.insertNum(nums[j]);
            }
            System.out.println("]");
            System.out.println("\tThe median for the given numbers is: " + medianOfAges.findMedian());
            //  System.out.println(PrintHyphens.repeat("-", 100));
        }


        // Sliding Window Median
        int[][] arr = {{1,3,-1,-3,5,3,6,7}, {1, 2}, {4, 7, 2, 21}, {22, 23, 24, 56, 76, 43, 121, 1, 2, 0, 0, 2, 3, 5}, {1, 1, 1, 1, 1}};
        int[] ks = {5, 1, 2, 5, 2};
        for (int i = 0; i < ks.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput array = " + Arrays.toString(arr[i]) + ", k = " + ks[i]);
            double[] output = medianSlidingWindow(arr[i], ks[i]);
            System.out.println("\tMedians = " + Arrays.toString(output));
         //   System.out.println(PrintHyphens.repeat("-", 100));

        }
    }

    // IP0

    //
    // Sliding Window Median
    public static double[] medianSlidingWindowCorrect(int[] nums, int k) {


        if(nums.length<k){
            return null;
        }
        // Replace this placeholder return statement with your code
        PriorityQueue<Integer> minHeapLargerNum=new PriorityQueue<>();
        PriorityQueue<Integer>maxHeapSmallerNum=new PriorityQueue<>((a,b)->Integer.compare(b,a));


        for(int i=0;i<k;i++){
            if(maxHeapSmallerNum.isEmpty() || maxHeapSmallerNum.peek()>=nums[i]){
                maxHeapSmallerNum.offer(nums[i]);
            }else{
                minHeapLargerNum.offer(nums[i]);
            }

            // rebalance

            if(maxHeapSmallerNum.size()>minHeapLargerNum.size()+1){
                minHeapLargerNum.offer(maxHeapSmallerNum.poll());
            }else if(minHeapLargerNum.size()>maxHeapSmallerNum.size()){
                maxHeapSmallerNum.offer(minHeapLargerNum.poll());
            }

        }

        double median;
        if(k%2==0){
            median = ((double) maxHeapSmallerNum.peek() + minHeapLargerNum.peek()) / 2.0;

        }else{
            median=maxHeapSmallerNum.peek();
        }
        double[] medians=new double[nums.length-k+1];
        medians[0]=median;
        int i=1;
        int j=k;

        Set<Integer> notDeletedMax=new HashSet<>();
        Set<Integer> notDeletedMin=new HashSet<>();

        while(j<nums.length){

            if(maxHeapSmallerNum.isEmpty()  || maxHeapSmallerNum.peek()>nums[j]){
                maxHeapSmallerNum.offer(nums[j]);
            }else{
                minHeapLargerNum.offer(nums[j]);
            }

            // rebalance

            if(maxHeapSmallerNum.size()>minHeapLargerNum.size()+1){
                minHeapLargerNum.offer(maxHeapSmallerNum.poll());
            }else if(minHeapLargerNum.size()>maxHeapSmallerNum.size()){
                maxHeapSmallerNum.offer(minHeapLargerNum.poll());
            }

            if(maxHeapSmallerNum.peek()==nums[i-1] || notDeletedMax.contains(maxHeapSmallerNum.peek()) ) {
                maxHeapSmallerNum.poll();
            }else {
                notDeletedMax.add(nums[i-1]);
            }

            if(minHeapLargerNum.peek()==nums[i-1] || notDeletedMin.contains(minHeapLargerNum.peek())){
                minHeapLargerNum.poll();
            }else{
                notDeletedMin.add(nums[i-1]);
            }

            if(maxHeapSmallerNum.size()>minHeapLargerNum.size()+1){
                minHeapLargerNum.offer(maxHeapSmallerNum.poll());
            }else if(minHeapLargerNum.size()>maxHeapSmallerNum.size()){
                maxHeapSmallerNum.offer(minHeapLargerNum.poll());
            }

            if(k%2==0){
                median = ((double) maxHeapSmallerNum.peek() + minHeapLargerNum.peek()) / 2.0;

            }else{
                median=maxHeapSmallerNum.peek();
            }
            medians[i]=median;
            i++;
            j++;


        }



        return medians;
    }

        // Sliding Window Median
    public static double[] medianSlidingWindow(int[] nums, int k) {


            if(nums.length<k){
                return null;
            }
            // Replace this placeholder return statement with your code
            PriorityQueue<Integer> minHeapLargerNum=new PriorityQueue<>();
            PriorityQueue<Integer>maxHeapSmallerNum=new PriorityQueue<>((a,b)->Integer.compare(b,a));


           for(int i=0;i<k;i++){
               if(maxHeapSmallerNum.isEmpty() || maxHeapSmallerNum.peek()>=nums[i]){
                   maxHeapSmallerNum.offer(nums[i]);
               }else{
                   minHeapLargerNum.offer(nums[i]);
               }

               // rebalance

               if(maxHeapSmallerNum.size()>minHeapLargerNum.size()+1){
                   minHeapLargerNum.offer(maxHeapSmallerNum.poll());
               }else if(minHeapLargerNum.size()>maxHeapSmallerNum.size()){
                   maxHeapSmallerNum.offer(minHeapLargerNum.poll());
               }

           }

            double median;
            if(k%2==0){
                median = ((double) maxHeapSmallerNum.peek() + minHeapLargerNum.peek()) / 2.0;

            }else{
                median=maxHeapSmallerNum.peek();
            }
            double[] medians=new double[nums.length-k+1];
            medians[0]=median;
           int i=1;
           int j=k;

           Set<Integer> notDeletedMax=new HashSet<>();
           Set<Integer> notDeletedMin=new HashSet<>();

            while(j<nums.length){

                if(maxHeapSmallerNum.isEmpty()  || maxHeapSmallerNum.peek()>nums[j]){
                    maxHeapSmallerNum.offer(nums[j]);
                }else{
                    minHeapLargerNum.offer(nums[j]);
                }

                // rebalance

                if(maxHeapSmallerNum.size()>minHeapLargerNum.size()+1){
                    minHeapLargerNum.offer(maxHeapSmallerNum.poll());
                }else if(minHeapLargerNum.size()>maxHeapSmallerNum.size()){
                    maxHeapSmallerNum.offer(minHeapLargerNum.poll());
                }

                if(maxHeapSmallerNum.peek()==nums[i-1] || notDeletedMax.contains(maxHeapSmallerNum.peek()) ) {
                    maxHeapSmallerNum.poll();
                }else {
                    notDeletedMax.add(nums[i-1]);
                }

                if(minHeapLargerNum.peek()==nums[i-1] || notDeletedMin.contains(minHeapLargerNum.peek())){
                    minHeapLargerNum.poll();
                }else{
                    notDeletedMin.add(nums[i-1]);
                }

                if(maxHeapSmallerNum.size()>minHeapLargerNum.size()+1){
                    minHeapLargerNum.offer(maxHeapSmallerNum.poll());
                }else if(minHeapLargerNum.size()>maxHeapSmallerNum.size()){
                    maxHeapSmallerNum.offer(minHeapLargerNum.poll());
                }

                if(k%2==0){
                    median = ((double) maxHeapSmallerNum.peek() + minHeapLargerNum.peek()) / 2.0;

                }else{
                    median=maxHeapSmallerNum.peek();
                }
                medians[i]=median;
                i++;
                j++;


            }



        return medians;
    }

    public static int maximumCapital(int c, int k, int[] capitals,int[] profits) {

        // Replace this placeholder return statement with your code
        PriorityQueue<int[]> minCapitalHeap=new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        for(int i=0;i<capitals.length;i++){
            minCapitalHeap.offer(new int[]{capitals[i],i});
        }

        int capitalInhand=c;
        PriorityQueue<int[]> maxProfitHeap=new PriorityQueue<>((a,b)-> Integer.compare(b[0],a[0]));
        int i=0;
        while(i<k){

            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0]<=capitalInhand){

                int[] capital=minCapitalHeap.poll();
                maxProfitHeap.offer(new int[]{profits[capital[1]],capital[0]});
            }

            if(!maxProfitHeap.isEmpty()) {
                break;
            }
            capitalInhand+=maxProfitHeap.poll()[0];

            i++;
        }



        return capitalInhand;
    }






}
