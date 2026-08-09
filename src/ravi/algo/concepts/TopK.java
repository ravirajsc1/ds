package ravi.algo.concepts;
import java.math.BigInteger;
import java.util.*;
import java.util.LinkedList;

public class TopK {
    public static void main(String[] args) {

        int[] nums = {3, 6, 9, 10};
        int[] temp = {3, 6, 9, 10};
        System.out.print("Initial stream: ");
        printArray(nums);
        System.out.println("\nk: " + 3);
        KthLargest kLargest = new KthLargest(3,nums);
        int[] val = {4, 7, 10, 8, 15};
        for (int i = 0; i < val.length; i++) {
            System.out.println("\tAdding a new number " + val[i] + " to the stream");
            temp = Arrays.copyOf(temp, temp.length + 1);
            temp[temp.length - 1] = val[i];
            System.out.print("\tNumber stream: ");
            printArray(temp);
            System.out.println("\n\tKth largest element in the stream: " + kLargest.add(val[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        //  Reorganize String

        String[] inputs = {
                "programming",
                "hello",
                "fofjjb",
                "abbacdde",
                "aba",
                "awesome",
                "aaab",
                "aab"
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput string: \"" + inputs[i] + "\"");

            String output = reorganizeString(inputs[i]);
            output = (output.length() == 0) ? "''" : output;

            System.out.println("\tReorganized string: \"" + output + "\"");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        int[][][] pointsArr = {
                {{1, 3}, {3, 4}, {2, -1}},
                {{1, 3}, {2, 4}, {2, -1}, {-2, 2}, {5, 3}, {3, -2}},
                {{1, 3}, {5, 3}, {3, -2}, {-2, 2}},
                {{2, -1}, {-2, 2}, {1, 3}, {2, 4}},
                {{1, 3}, {2, 4}, {2, -1}, {-2, 2}, {5, 3}, {3, -2}, {5, 3}, {3, -2}}
        };

        int[] kArr = {2, 3, 1, 4, 5};


        for (int i = 0; i < pointsArr.length; i++) {
            System.out.print((i + 1) + ".\tpoints: [");
            for (int j = 0; j < pointsArr[i].length; j++) {
                System.out.print("[" + pointsArr[i][j][0] + ", " + pointsArr[i][j][1] + "]");
                if (j < pointsArr[i].length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("\tk: " + kArr[i] + "\n");

            int[][] result = kClosestDiff(pointsArr[i], kArr[i]);
            System.out.print("\t" + kArr[i] + " closest point(s) to origin: [");
            for (int j = 0; j < result.length; j++) {
                System.out.print("[" + result[j][0] + ", " + result[j][1] + "]");
                if (j < result.length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("-".repeat(100));
        }

        int[][] inputsS = {
                {1, 3, 5, 12, 11, 12, 11, 12, 5},
                {1, 3, 5, 14, 18, 14, 5},
                {2, 3, 4, 5, 6, 7, 7},
                {9, 8, 7, 6, 6, 5, 4, 3, 2, 1},
                {2, 4, 3, 2, 3, 4, 5, 4, 4, 4},
                {1, 1, 1, 1, 1, 1},
                {2, 3}
        };
        int[] inputK = {3, 2, 1, 1, 3, 1, 2};
        for (int i = 0; i < inputK.length; i++) {
            List<Integer> result = topKFrequentBetter(inputsS[i], inputK[i]);
            System.out.print(i + 1);
            System.out.println(".\tInput: (" + Arrays.toString(inputsS[i]) + ", " + inputK[i] + ")");
            System.out.println("\n\tTop " + inputK[i] + " frequent elements: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));

        }

        int[][] inputsSmallest = {
                {1, 5, 12, 2, 11, 9, 7, 30, 20},
                {5, 2, 9, -3, 7},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 4, 6, 0, 2},
                {3, 5, 2, 3, 8, 5, 3}
        };

        int[] K = {3, 1, 9, 1, 4};

        for(int i=0; i<K.length; i++){
            System.out.print(i+1);
            System.out.println(".\tInput array: "+ Arrays.toString(inputsSmallest[i]));
            System.out.println("\tValue of k: "+ K[i]);
            System.out.println("\tkth largest element: " + findKthLargest(inputsSmallest[i], K[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[][] testCases = {
                {3, 2, 1},
                {1, 2},
                {2, 2, 3, 1},
                {5, 5, 4, 3, 2},
                {1, 1, 1, 1}
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.print((i + 1) + ".\tnums: " + Arrays.toString(testCases[i]));
            System.out.println("\n\tThe third maximum is: " + thirdMax(testCases[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[][] testCasesS = {
                {3, 4, 3, 3},
                {2, 1, 3, 3},
                {-1, -2, 3, 4},
                {1, 2, 3, 4, 5},
                {9, -1, -3, 8, 7}
        };
        int[] ks = {2, 2, 3, 3, 2};

        for (int i = 0; i < testCasesS.length; i++) {
            int[] numsSmall = testCasesS[i];
            int k = ks[i];

            System.out.println((i + 1) + "\tnums = " + Arrays.toString(numsSmall) + ", k = " + k);
            int[] result = maxSubsequence(numsSmall, k);
            System.out.println("\n\tResult: " + Arrays.toString(result) + "\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[][] qualities = {
                {10, 20, 5},
                {3, 1, 10, 10, 1},
                {4, 5, 6},
                {2, 3, 1},
                {10, 10, 10}
        };

        int[][] wages = {
                {70, 50, 30},
                {4, 8, 2, 2, 7},
                {8, 10, 12},
                {5, 6, 2},
                {50, 60, 70}
        };

        int[] k_values = {2, 3, 2, 2, 2};

        for (int i = 0; i < qualities.length; i++) {
            System.out.println((i + 1) + ".\tqualities: " + Arrays.toString(qualities[i]));
            System.out.println("\twages: " + Arrays.toString(wages[i]));
            System.out.println("\tk: " + k_values[i]);
            double result = minCostToHireWorkers(qualities[i], wages[i], k_values[i]);
            System.out.println("\n\tMinimum cost to hire " + k_values[i] + " workers = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[][] testCasesK = {
                {12, 18, 24, 6},
                {7, 14, 3},
                {50, 20, 15, 10, 5},
                {8, 16, 5, 12, 3, 7},
                {50, 50, 50, 50, 50, 50, 50, 50}
        };
        int[] ksk = {3, 2, 4, 3, 5};

        for (int i = 0; i < testCasesK.length; i++) {
            System.out.println((i + 1) + ".\tnums: " + Arrays.toString(testCasesK[i]));
            System.out.println("\tk: " + ksk[i]);
            int result = maxScore(testCasesK[i], ksk[i]);
            System.out.println("\n\tMaximum Score: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        String[][] testCasesString = {
                {"3", "6", "7", "10"},
                {"2", "21", "12", "1"},
                {"0", "0"},
                {"100", "200", "300", "400"},
                {"10", "100", "1000", "10000"}
        };

        int[] kValues = {4, 3, 2, 2, 1};


        for (int i = 0; i < testCasesString.length; i++) {
            String[] numsStrting = testCasesString[i];
            int k = kValues[i];

            String result = kthLargestInteger(numsStrting, k);

            System.out.println((i + 1) + ".\t nums: " + Arrays.toString(numsStrting) + ", k: " + k);
            System.out.println("\t kth largest integer: " + result);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

        int[][][] testCasesPerformance = {
                {{6}, {2, 10, 3, 1, 5, 8}, {5, 4, 3, 9, 7, 2}, {2}},
                {{1}, {1}, {1}, {1}},
                {{3}, {1, 2, 3}, {3, 2, 1}, {3}},
                {{4}, {5, 5, 5, 5}, {1, 2, 3, 4}, {2}},
                {{5}, {10, 1, 10, 1, 10}, {9, 1, 9, 1, 9}, {3}}
        };

        for (int i = 0; i < testCasesPerformance.length; i++) {
            int n = testCasesPerformance[i][0][0];
            int[] speed = testCasesPerformance[i][1];
            int[] efficiency = testCasesPerformance[i][2];
            int k = testCasesPerformance[i][3][0];

            int result = maxPerformance(n, speed, efficiency, k);
            System.out.println((i + 1) + ".\tn: " + n);
            System.out.println("\tspeed: " + Arrays.toString(speed));
            System.out.println("\tefficiency: " + Arrays.toString(efficiency));
            System.out.println("\tk: " + k);
            System.out.println("\n\tOutput: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        //

        List<List<List<Integer>>> testCasesHard = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(4, 10, 15, 24, 26),
                        Arrays.asList(0, 9, 12, 20),
                        Arrays.asList(5, 18, 22, 30)
                ),
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 2, 3)
                ),
                Arrays.asList(
                        Arrays.asList(1, 5),
                        Arrays.asList(3, 7),
                        Arrays.asList(4, 6)
                ),
                Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(3, 4),
                        Arrays.asList(8, 9)
                ),
                Arrays.asList(
                        Arrays.asList(1, 5, 10),
                        Arrays.asList(2, 4, 6),
                        Arrays.asList(3, 8, 15)
                )
        );

        int testCaseNumber = 1;
        for (List<List<Integer>> numsHard : testCasesHard) {
            System.out.print(testCaseNumber++ + ".\tnums: ");
            for (List<Integer> list : numsHard) {
                System.out.print(list + " ");
            }
            System.out.println();

            int[] result = smallestRange(numsHard);
            System.out.println("\tSmallest Range: [" + result[0] + ", " + result[1] + "]");
            System.out.println("-".repeat(100));
        }

        List<List<Integer>> arr1List = new ArrayList<>();
        arr1List.add(Arrays.asList(1, 4, 2));
        arr1List.add(Arrays.asList(10, 15, 30));
        arr1List.add(Arrays.asList(1, 1, 1));
        arr1List.add(Arrays.asList(5, 7));
        arr1List.add(Arrays.asList(1, 2, 3));

        List<List<Integer>> arr2List = new ArrayList<>();
        arr2List.add(Arrays.asList(3, 6, 5));
        arr2List.add(Arrays.asList(20, 25, 10));
        arr2List.add(Arrays.asList(1, 1, 1));
        arr2List.add(Arrays.asList(8, 3));
        arr2List.add(Arrays.asList(4, 5, 6));

        List<Integer> kList = Arrays.asList(3, 2, 2, 1, 3);

        for (int i = 0; i < arr1List.size(); i++) {
            List<Integer> arr1 = arr1List.get(i);
            List<Integer> arr2 = arr2List.get(i);
            int k = kList.get(i);

            System.out.println((i + 1) + ".\t arr1: " + arr1 + ", arr2: " + arr2 + ", k: " + k);


            List<Integer> result = maxCombinations(arr1, arr2, k);

            System.out.println("\n\t Top " + k + " Maximum Sums: " + result);
            System.out.println("-".repeat(100));
        }

        // K Empty Slots

        int[][] testBulbs = {
                {1, 3, 2},
                {1, 2, 3},
                {2, 5, 1, 4, 3},
                {3, 1, 5, 4, 2},
                {2, 4, 1, 3}
        };

        int[] ksb = {1, 1, 1, 1, 0};

        for (int i = 0; i < testBulbs.length; i++) {
            int[] bulbs = testBulbs[i];
            int k = ksb[i];
            System.out.print((i + 1) + ".\tbulbs: [ ");
            for (int b : bulbs) System.out.print(b + " ");
            System.out.println("], k: " + k);

            int result = kEmptySlotsBetter(bulbs, k);
            System.out.println("\tEarliest Day: " + result);
            System.out.println("-".repeat(100));
        }



        // Maximum Product After K Increments
        List<int[]> numsList = Arrays.asList(
                new int[]{3, 3, 3, 3, 0},
                new int[]{1, 2, 3},
                new int[]{0, 0, 0, 0, 0},
                new int[]{1, 5, 1, 1},
                new int[]{2, 2, 2, 2}
        );

        int[] kValuesM = {1, 3, 10, 3, 4};

        for (int i = 0; i < numsList.size(); i++) {
            int[] numsM = numsList.get(i);
            int k = kValuesM[i];

            System.out.printf("%d.\tnums = %s, k = %d\n", i + 1, Arrays.toString(numsM), k);
            int result = maximumProduct(numsM, k);
            System.out.printf("\tMaximum Product: %d\n", result);
            System.out.println("-".repeat(100));
        }

    }



    public static long kSum(int[] nums, int k) {
        // Replace this placeholder return statement with your code
        long maxSum=0L;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                maxSum+=nums[i];
            }else{
                nums[i]=-nums[i];
            }
        }

        Arrays.sort(nums);
        PriorityQueue<long[]> minHeap=new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        minHeap.offer(new long[]{0L,0L});
        for(int i=0;i<k-1;i++){
            long[] smallest=minHeap.poll();
            long currentSum=smallest[0];
            int index=(int)smallest[1];

            if(index<nums.length){
                minHeap.offer(new long[]{currentSum+nums[index],index+1});
                if(index>0){
                    minHeap.offer(new long[]{currentSum+nums[index]-nums[index-1],index+1});
                }
            }

        }

        return maxSum-minHeap.peek()[0];
    }


// Maximum Product After K Increments

    public static int maximumProduct(int[] nums, int k)
    {
        // Replace this placeholder return statement with your code
        final int MOD = 1_000_000_007;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            minHeap.offer(nums[i]);
        }
        long product=1;
        for(int i=0;i<k;i++){
            int min=minHeap.poll();
            minHeap.offer(min+1);
        }

        while(!minHeap.isEmpty()){
            product=(product*minHeap.poll())/MOD;
        }
        return (int)product;
    }


    // k Empty slot



// bulb 2 4 1 3
// days 3 1 4 2
// index 0 1 2 3

    public static int kEmptySlotsBetter(int[] bulbs, int k) {
        int n=bulbs.length;
        int[] days=new int[n];

        for(int day=0;day<n;day++){
            days[bulbs[day]-1]=day+1;
        }

        MInHeap pq=new MInHeap();

        int result=n;
        for(int i=0;i<n;i++){
            pq.append(days[i]);
            if(i>=k && i< n-1){
                pq.popleft();

                if(k==0 || (days[i-k] < pq.min() && days[i+1] < pq.min())){
                    int ans=Math.max(days[i-k],days[i+1]);
                    result=Math.min(result,ans);
                }

            }
        }

        return result<n?result:-1;
    }

    public static int kEmptySlots(int[] bulbs, int k)
    {

        int n=bulbs.length;
        int[] days=new int[n];
// bulb 2 4 1 3
// days 3 1 4 2
// index 0 1 2 3

        for(int i=0;i<n;i++){
            days[bulbs[i]-1]=i+1;
        }

        Deque<Integer> dq=new LinkedList<>();
        int result=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){

            while(!dq.isEmpty() && days[dq.peekFirst()]> days[i]){
                dq.pollFirst();
            }
            dq.offerFirst(days[i]);

            if(i>k+1){
                int left=i-k-1;
                int right=i+1;

                if(dq.peekFirst()==left+1){
                    dq.pollFirst();
                }

                if(days[left]<days[dq.peekFirst()] && days[right] < days[dq.peekFirst()]){
                    result=Math.min(result,Math.max(days[left],days[right]));
                }


            }

        }

        // Replace this placeholder return statement with your code
        return (result==Integer.MAX_VALUE)?-1:result;
    }

    public static List<Integer> maxCombinations(List<Integer> arr1, List<Integer> arr2, int k)
    {
        Collections.sort(arr1,Collections.reverseOrder());
        Collections.sort(arr2,Collections.reverseOrder());

        PriorityQueue<int []> maxHeap=new PriorityQueue<>(Comparator.comparingInt((int[] a)->a[0]).reversed());
        maxHeap.offer(new int[]{(arr1.get(0)+arr2.get(0)),0,0});

        List<Integer> results=new ArrayList<>();
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        while(!maxHeap.isEmpty() && k-->0){
            int[] largest=maxHeap.poll();
            int sum=largest[0];
            int i=largest[1];
            int j=largest[2];

            results.add(sum);

            if(i+1<arr1.size() && visited.add((i+1)+","+j)){
                maxHeap.offer(new int[]{(arr1.get(i+1)+arr2.get(j)),i+1,j});
            }


            if(j+1 < arr2.size() && visited.add(i+","+(j+1))){
                maxHeap.offer(new int[]{(arr1.get(i)+arr2.get(j+1)),i,j+1});
            }

        }



        // Replace this placeholder return statement with your code
        return results;
    }


    static class Element implements Comparable<Element>{

        int value;
        int listIndex;
        int elementIndex;

        public Element(int value,int listIndex,int elementIndex){
            this.value=value;
            this.listIndex=listIndex;
            this.elementIndex=elementIndex;
        }
        @Override
        public int compareTo(Element o) {
            return Integer.compare(this.value,o.value);
        }
    }
    public static int[] smallestRange(List<List<Integer>> nums)
    {

        int maxVal=Integer.MIN_VALUE;
        int startRange=0;
        int endRange=Integer.MAX_VALUE;
        PriorityQueue<Element> minHeap=new PriorityQueue<>();
        for(int i=0;i<nums.size();i++){

            minHeap.offer(new Element(nums.get(i).get(0),i,0));
            maxVal=Math.max(maxVal,nums.get(i).get(0));
        }


        while(nums.size()==minHeap.size()){

            Element smallest=minHeap.poll();
            int minVal=smallest.value;
            if(maxVal-minVal<endRange-startRange){
                startRange=minVal;
                endRange=maxVal;

            }

            int nextIndex=smallest.elementIndex+1;
            if(nextIndex<nums.get(smallest.listIndex).size()){
                int nextValue=nums.get(smallest.listIndex).get(nextIndex);
                minHeap.offer(new Element(nextValue,smallest.listIndex,nextIndex));
                maxVal=Math.max(maxVal,nextValue);
            }else{
                break;
            }
        }



        // Replace this placeholder return statement with your code
        return new int[]{startRange,endRange};
    }


    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        final int MOD = (int)1e9 + 7;
        List<int []> efficList= new ArrayList<>();
        for(int i=0;i<speed.length;i++){
            efficList.add(new int[]{efficiency[i],speed[i]});
        }

        efficList.sort(Comparator.comparingInt((int[] a)->a[0]).reversed());
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(Comparator.comparingInt(a->a));
        long totalSpeed=0;
        long maxPeformance=0;
        for(int i=0;i<efficList.size();i++){
            int leff=efficList.get(i)[0];
            int lSpeed=efficList.get(i)[1];

            minHeap.offer(lSpeed);
            totalSpeed+=lSpeed;

            if(minHeap.size()>k){
                totalSpeed-=minHeap.poll();

            }
            maxPeformance=Math.max(maxPeformance,leff*totalSpeed);
          }


        // Replace this placeholder return statement with your code
        return (int)maxPeformance%MOD;

    }



    public static String kthLargestInteger (String[] nums, int k)
    {

        PriorityQueue<BigInteger> minHeap= new PriorityQueue<>();

        for(String num:nums){
            BigInteger bigInteger=new BigInteger(num);
            minHeap.offer(bigInteger);
            if(minHeap.size()>k)
                minHeap.poll();

        }
         return minHeap.peek().toString();
    }

    public static int maxScore (int[] nums, int k) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.comparingInt((Integer a)->a).reversed());
        // Replace this placeholder return statement with your code

        for(int n:nums)
            maxHeap.offer(n);

        int totalProfit=0;
        for(int i=0;i<k;i++){
            if(maxHeap.isEmpty())
                break;

            int max=maxHeap.poll();
            totalProfit+=max;
            int next=(int)Math.ceil((double)max/3);
            maxHeap.offer(next);

        }
        return totalProfit;
    }


    public static double ratio(double quality,double wages){
        return wages/quality;
    }

    public static double minCostToHireWorkers(int[] quality, int[] wage, int k) {



        PriorityQueue<Double> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        List<double []> workers=new ArrayList<>();
        for(int i=0; i<quality.length;i++) {
            workers.add(new double[]{ratio(quality[i],wage[i]),(double)quality[i]});
        }
        Collections.sort(workers,Comparator.comparingDouble((double[] a)-> a[0]));
        double sumofQuality=0;
        double minCost=Double.MAX_VALUE;
        for(int i=0;i<workers.size();i++){
            double ratio=workers.get(i)[0];
            double qual=workers.get(i)[1];
            maxHeap.add(qual);
            sumofQuality+=qual;
            if(maxHeap.size()>k){
                sumofQuality-= maxHeap.poll();
            }
            if(maxHeap.size()==k){
                minCost=Math.min(minCost,sumofQuality*ratio);
            }

        }

        return minCost;
    }


    public static int[] maxSubsequence (int[] nums, int k) {

        // Replace this placeholder return statement with your code
        PriorityQueue<int[]> numbers=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));


        for(int i=0;i<nums.length;i++){

            numbers.offer(new int[]{nums[i],i});
            if(numbers.size()>k){
                numbers.poll();
            }


        }


        List<int []> finalList=new ArrayList<>(numbers);
        finalList.sort(Comparator.comparingInt(a-> a[1]));

        int[] res=new int[numbers.size()];
        for(int i=0;i<finalList.size();i++){
            res[i]=finalList.get(i)[0];
        }
        return res ;
    }

    public static int thirdMax (int[] nums)
    {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        Set<Integer> unique=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(unique.contains(nums[i])){
               continue;
            }

            if(minHeap.size()==3){
                if(minHeap.peek()<nums[i]){
                    unique.remove(minHeap.poll());
                    minHeap.offer(nums[i]);
                    unique.add(nums[i]);
                }
            }else{
                minHeap.offer(nums[i]);
                unique.add(nums[i]);
            }



        }

        if(minHeap.size()==2){
            int first=minHeap.poll();
            return Math.max(first,minHeap.peek());
        }


        return minHeap.peek();
    }


    public static int findKthLargest(int[] nums, int k) {

        // Replace this placeholder return statement with your code
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            minHeap.offer(nums[i]);
        }

        for(int i=k;i<nums.length;i++){
            if(nums[i]>minHeap.peek()){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }


        return minHeap.peek();
    }




    public static List<Integer> topKFrequentBetter(int[] arr, int k) {

        // Replace this placeholder return statement with your code
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.getValue()));


        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }

       for (Map.Entry<Integer,Integer> entry:countMap.entrySet()) {
           minHeap.add(entry);
           if(minHeap.size()>k)
               minHeap.poll();

        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()){
            result.add(minHeap.poll().getKey());
        }


        return result;
    }


    public static List<Integer> topKFrequent(int[] arr, int k) {

        // Replace this placeholder return statement with your code
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.getValue()));


        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }

        int i=0;
        for (Integer key : new ArrayList<>(countMap.keySet())) {
            minHeap.offer(new AbstractMap.SimpleEntry<>(key, countMap.get(key)));
            countMap.remove(key);
            i++;
            if(i==k)
                break;
        }


        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(new AbstractMap.SimpleEntry<>(key, countMap.get(key)));
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()){
            result.add(minHeap.poll().getKey());
        }


        return result;
    }



    public static  int sqauaredSum(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
    public static int[][] kClosestDiff(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap=new PriorityQueue<>(Comparator.comparingInt((int[] a) ->sqauaredSum(a)).reversed());
        for(int i=0;i<k;i++){
               maxHeap.offer(points[i]);
        }


        for(int i=k;i< points.length;i++){
            int distance=sqauaredSum(points[i]);

            if(distance<sqauaredSum(maxHeap.peek())){
                maxHeap.poll();
                maxHeap.offer(points[i]);
            }
        }

        int[][] res=new int[k][2];
        int i=0;
        while(!maxHeap.isEmpty()){
            int[] point=maxHeap.poll();
            res[i++]=point;
        }
        // Replace this placeholder return statement with your code
        return res;
    }


    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<double[]> maxHeap=new PriorityQueue<>(Comparator.comparingDouble((double[] a) ->a[0]).reversed());
        for(int i=0;i<k;i++){
            double distance=Math.sqrt(Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
            maxHeap.offer(new double[]{distance,points[i][0],points[i][1]});

        }


        int count=0;
        for(int i=k;i< points.length;i++){
            double distance=Math.sqrt(Math.pow(points[i][0],2)+Math.pow(points[i][1],2));

            if(maxHeap.isEmpty())
                break;

            if(distance<maxHeap.peek()[0]){
                maxHeap.poll();
                maxHeap.offer(new double[]{distance,points[i][0],points[i][1]});
            }
        }


        // Replace this placeholder return statement with your code
        return maxHeap.toArray(new int[maxHeap.size()][]);
    }



    //  Reorganize String
    public static String reorganizeString(String string1) {

        Map<Character,Integer> countMap=new HashMap<>();

        // Replace this placeholder return statement with your code
        for(int i=0;i<string1.length();i++){
            char ch=string1.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap=new PriorityQueue<>(Comparator.comparingInt((Map.Entry<Character,Integer> a)->a.getValue()).reversed());

        StringBuilder stringBuilder=new StringBuilder(string1.length());
        maxHeap.addAll(countMap.entrySet());
        Map.Entry <Character, Integer> previous = null;


        while(!maxHeap.isEmpty() || previous!=null){

            if(maxHeap.isEmpty() && previous!=null){
                break;
            }

            Map.Entry<Character,Integer> top=maxHeap.poll();
            stringBuilder.append(top.getKey());
            int count=top.getValue()-1;

            if(previous!=null){
                maxHeap.offer(previous);
                previous=null;
            }

            if(count!=0)
                maxHeap.offer(new AbstractMap.SimpleEntry<>(top.getKey(),count));


            /*if(stringBuilder.length()>0 &&
                            top.getKey()==stringBuilder.charAt(stringBuilder.length()-1)){
                if(maxHeap.isEmpty())
                    return "";
                Map.Entry<Character,Integer> second=maxHeap.poll();
                stringBuilder.append(second.getKey());
                if(second.getValue()>1) {
                    second.setValue(second.getValue()-1);
                    maxHeap.offer(second);
                }
                maxHeap.offer(top);

            }else{
                stringBuilder.append(top.getKey());
                if(top.getValue()>1) {
                    top.setValue(top.getValue()-1);
                    maxHeap.offer(top);
                }
            }*/
        }

        return stringBuilder.toString();
    }


    //  kth larest element in stream


    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
