package ravi.algo.concepts;

import java.util.*;
import java.util.LinkedList;

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
            double[] output = medianSlidingWindowCorrect(arr[i], ks[i]);
            System.out.println("\tMedians = " + Arrays.toString(output));
         //   System.out.println(PrintHyphens.repeat("-", 100));

        }


        // Schedule Tasks on Minimum Machines
        int[][][] inputTasksList = {
                {{12, 13}, {13, 15}, {17, 20}, {13, 14}, {19, 21}, {18, 20}},
                {{1, 7}, {1, 7}, {1, 7}, {1, 7}, {1, 7}, {1, 7}},
                {{1, 7}, {8, 13}, {5, 6}, {10, 14}, {6, 7}},
                {{1, 3}, {3, 5}, {5, 9}, {9, 12}, {12, 13}, {13, 16}, {16, 17}},
                {{12, 13}, {13, 15}, {17, 20}, {13, 14}, {19, 21}, {18, 20}}
        };

        for (int i = 0; i < inputTasksList.length; ++i) {
            System.out.print((i + 1) + ".\t Tasks: [");
            int[][] tasks = inputTasksList[i];
            for (int j = 0; j < tasks.length; ++j) {
                System.out.print("[" + tasks[j][0] + ", " + tasks[j][1] + "]");
                if (j < tasks.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            System.out.println("\t Minimum number of machines: " + minimumMachines(tasks));
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }

        // Meeting Rooms III
        int[][][] meetings = {
                {{0, 10}, {1, 11}, {2, 12}, {3, 13}, {4, 14}, {5, 15}},
                {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}},
                {{1, 2}, {0, 10}, {2, 3}, {3, 4}},
                {{0, 2}, {1, 2}, {3, 4}, {2, 4}},
                {{1, 9}, {2, 8}, {3, 7}, {4, 6}, {5, 11}}
        };

        int[] rooms = {3, 3, 2, 4, 3};

        for (int i = 0; i < meetings.length; i++) {
            System.out.println((i + 1) + ".\tMeetings: " + Arrays.deepToString(meetings[i]));
            System.out.println("\tRooms: " + rooms[i]);
            int bookedRoom = mostBooked(meetings[i], rooms[i]);
            System.out.println("\tRoom that held the most meetings: " + bookedRoom);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Largest Number After Digit Swaps by Parity
        int[] testCases = {1234, 65875, 4321, 2468, 98123};
        for (int num : testCases) {
            System.out.println("\tInput number: " + num);
            System.out.println("\tOutput number: " + largestInteger(num));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[][][] testCasesS = {
                {{1, 2}},
                {{3, 4}, {2, 3}, {1, 2}},
                {{1, 4}, {2, 3}, {3, 4}},
                {{5, 6}, {1, 2}, {3, 4}},
                {{1, 3}, {2, 4}, {3, 5}, {4, 6}},
        };

        for (int i = 0; i < testCasesS.length; i++) {
            System.out.println((i + 1) + "\tintervals: " + Arrays.deepToString(testCasesS[i]));
            int[] result = findRightInterval(testCasesS[i]);
            System.out.println("\n\tOutput: " + Arrays.toString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Minimum Cost to Connect Sticks
        int[][] testCasesM = {
                {2, 4, 3},
                {1, 8, 3, 5},
                {5},
                {1, 2, 3, 4, 5},
                {7, 6, 8, 10}
        };

        for (int i = 0; i < testCasesM.length; i++) {
            int[] sticks = testCasesM[i];
            System.out.println((i + 1) + ".\tsticks: " + java.util.Arrays.toString(sticks));
            System.out.println("\tMinimum cost: " + connectSticks(sticks));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Longest Happy String
        int[][] testCasesHappy = {
                {1, 1, 7},
                {2, 2, 1},
                {7, 2, 0},
                {0, 0, 0},
                {10, 5, 3},
                {3, 3, 3}
        };

        int testCaseNum = 1;
        for (int[] testCase : testCasesHappy) {
            int a = testCase[0], b = testCase[1], ch = testCase[2];
            System.out.println(testCaseNum++ + ".\t a: " + a + ", b: " + b + ", c: " + ch);
            String result = longestDiverseString(a, b, ch);
            System.out.println("\n\t Longest Happy String: " + result);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

    }


     // Longest Happy String
    public static String longestDiverseString(int a,  int b, int c)
    {
        int total=a+b+c;
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<total;i++){
            if(a>2) {
                stringBuilder.append("a");
                stringBuilder.append("a");
                a--;
                a--;
            }else if(a==1){
                stringBuilder.append("a");
                a--;
            }
            if(b>2) {
                stringBuilder.append("b");
                stringBuilder.append("b");
                b--;
                b--;
            }else if(b==1){
                stringBuilder.append("b");
                b--;
            }

            if(c>2) {
                stringBuilder.append("c");
                stringBuilder.append("c");
                c--;
                c--;
            }else if(c==1){
                stringBuilder.append("c");
                c--;
            }

        }
        // Replace this placeholder return statement with your code
        return stringBuilder.toString();
    }



    // Minimum Cost to Connect Sticks

    public static int connectSticks (int[] sticks) {
         PriorityQueue<Integer> minHeap=new PriorityQueue<>();
         for(int stick:sticks){
             minHeap.offer(stick);
         }

         if(minHeap.isEmpty()){
            return -1;
        }
         int totalEffort=0;

        while(!minHeap.isEmpty()){
            int first=minHeap.poll();
            int tempEffort =0;
            if(!minHeap.isEmpty()) {
                int second = minHeap.poll();
                tempEffort = first +  second;
                minHeap.offer(tempEffort);

                totalEffort+=tempEffort;
            }

        }
// Replace this placeholder return statement with your code
        return totalEffort;
    }


    public static int[] findRightInterval (int[][] intervals) {

        // Replace this placeholder return statement with your code
        PriorityQueue<int []> startHeap= new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int []> endHeap= new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));


        for(int i=0;i<intervals.length;i++){
            startHeap.offer(new int[]{intervals[i][0],i});
            endHeap.offer(new int[]{i,intervals[i][1]});
        }

        int[] result=new int[intervals.length];
        Arrays.fill(result, -1);
        while(!endHeap.isEmpty()){
            int[] interval=endHeap.poll();
            int end=interval[1];
            int index=interval[0];

            while(!startHeap.isEmpty() && startHeap.peek()[0]<end){
                startHeap.poll();
            }

            if(!startHeap.isEmpty()){
               result[index]=startHeap.peek()[1];
            }


        }

        return result;
    }

    // Largest Number After Digit Swaps by Parity
    public static int largestInteger(int num) {
        String numStr = Integer.toString(num);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }

        PriorityQueue<Integer> oddHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> evenHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int d : digits) {
            if (d % 2 == 0) {
                evenHeap.add(d);
            } else {
                oddHeap.add(d);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int d : digits) {
            if (d % 2 == 0) {
                result.append(evenHeap.poll());
            } else {
                result.append(oddHeap.poll());
            }
        }

        return Integer.parseInt(result.toString());
    }

// // Meeting Rooms III

    public static int mostBooked(int[][] meetings, int rooms) {

        PriorityQueue<long[]> usedRooms=new PriorityQueue<>((a,b)-> a[0]!=b[0]?Long.compare(a[0],b[0]):Long.compare(a[1],b[1]));
        PriorityQueue<Integer> available=new PriorityQueue<>();
        int[] count=new int[rooms];
        for(int i=0;i<rooms;i++)
            available.offer(i);

        for(int i=0;i<meetings.length;i++){
            long start_time = meetings[i][0];
            long end_time = meetings[i][1];


            while(!usedRooms.isEmpty() && usedRooms.peek()[0]<=start_time){
                int room=(int)usedRooms.poll()[1];
                available.offer(room);
            }

            if(available.isEmpty()){
                long end=usedRooms.peek()[0];
                int room=(int)usedRooms.peek()[1];
                end_time=end+(end_time-start_time);
                available.offer(room);

             }

            int avaiableRoom=available.poll();
            usedRooms.offer(new long[]{end_time,avaiableRoom});
            count[avaiableRoom]++;


        }

        int maxCountI=0;

        for (int i=0;i<count.length;i++){
            if(count[i]>count[maxCountI]){
                maxCountI=i;
            }

        }

        return maxCountI;
    }


    //Schedule Tasks on Minimum Machines

    public static int minimumMachines(int[][] tasks) {

        Arrays.sort(tasks,Comparator.comparingInt(task->task[0]));


        PriorityQueue<int[]> minHeapSecond=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));

        int[] prev=tasks[0];

        minHeapSecond.offer(prev);
        for(int i=1;i<tasks.length;i++){

            if(
                    (!minHeapSecond.isEmpty() && tasks[i][0]>=minHeapSecond.peek()[1])  ){

                minHeapSecond.poll();
            }
            minHeapSecond.offer(tasks[i]);


        }



        // Replace this placeholder return statement with your code
        return minHeapSecond.size();
    }

    // IP0

    //
    // Sliding Window Median
    public static double[] medianSlidingWindowCorrect(int[] nums, int k) {


        if(nums.length<k){
            return null;
        }
        // Replace this placeholder return statement with your code
        PriorityQueue<Integer> largeList=new PriorityQueue<>();  //large
        PriorityQueue<Integer> smallList=new PriorityQueue<>((a,b)->Integer.compare(b,a));   //small
        for(int i=0;i<k;i++)
                smallList.offer(nums[i]);


        for(int i=0;i<k/2;i++)
                largeList.offer(smallList.poll());


        int balance=0;
        int i=k;
        List<Double> medians=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();

        while(true){

            if((k & 1)==1){
                medians.add((double)smallList.peek());
            }else{

                medians.add((double)((long)largeList.peek()+(long)smallList.peek())*0.5);
            }

            if(i>= nums.length)
                break;

            int outNum=nums[i-k];
            int inNum=nums[i];

            i++;


            if(outNum<=smallList.peek()){
                balance-=1;
            }else{
                balance+=1;
            }

            if(map.containsKey(outNum))
                map.put(outNum,map.get(outNum)+1);
            else
                map.put(outNum,1);

            // add new item

            if(!smallList.isEmpty() && inNum<=smallList.peek()){
                smallList.offer(inNum);
                balance++;
            }else{
                balance--;
                largeList.offer(inNum);
            }

            // rebalance
            if(balance<0)
                smallList.offer(largeList.poll());
            else if(balance>0)
                largeList.offer(smallList.poll());


            balance=0;

            while(!smallList.isEmpty() && map.containsKey(smallList.peek()) && map.get(smallList.peek())>0){
                map.put(smallList.peek(),map.get(smallList.poll())-1);
            }


            while(!largeList.isEmpty() && map.containsKey(largeList.peek()) && map.get(largeList.peek())>0){
                map.put(largeList.peek(),map.get(largeList.poll())-1);
            }

        }



        double[] arr=medians.stream().mapToDouble(Double::doubleValue).toArray();
        return arr;
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
