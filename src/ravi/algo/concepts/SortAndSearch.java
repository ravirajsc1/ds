package ravi.algo.concepts;

import java.beans.Introspector;
import java.util.*;

public class SortAndSearch {

    public static void main(String[] str){


        //Find the Distance Value Between Two Arrays
        int[][][] testCases = {
                { {3, 5, 7, 9}, {1, 2, 3, 4}, {2} },
                { {-3, -5, -7, -9}, {-1, -2, -3, -4}, {2} },
                { {3, -5, 7, -9}, {-1, 2, -3, 4}, {4} },
                { {100, 200, 300}, {400, 500, 600}, {100} },
                { {0, -2, 4, -6}, {-8, 10, -12, 14}, {1} },
                { {5}, {3}, {1} },
                { {10}, {-5, -10, -15, -20, -25}, {5} }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] arr1 = testCases[i][0];
            int[] arr2 = testCases[i][1];
            int d = testCases[i][2][0];

            System.out.println((i + 1) + ".\t arr1: " + Arrays.toString(arr1) + ", arr2: " + Arrays.toString(arr2) + ", d: " + d);
            int result = findTheDistanceValue(arr1, arr2, d);
            System.out.println("\t Distance value: " + result);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

        // Longest Subsequence With Limited Sum
        int[][] numsList = {
                {4, 5, 2, 1},
                {2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {10, 20, 30},
                {7, 3, 9, 2}
        };

        int[][] queriesList = {
                {3, 10, 21},
                {1},
                {10, 15, 5},
                {25, 50, 5},
                {5, 10, 20}
        };

        for (int i = 0; i < numsList.length; i++) {
            int[] nums = numsList[i];
            int[] queries = queriesList[i];
            int[] result = answerQueries(nums, queries);
            System.out.println((i + 1) + ".\tnums: " + Arrays.toString(nums));
            System.out.println("\tqueries: " + Arrays.toString(queries));
            System.out.println("\n\tResult: " + Arrays.toString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // Find Target Indices After Sorting Array
        int[][] numsArray = {
                {1, 2, 3, 4},
                {3, 7, 2},
                {5},
                {8, 1, 4, 2, 1, 4, 8},
                {10, 20, 30}
        };
        int[] targetArray = {4, 7, 5, 8, 20};

        for (int idx = 0; idx < numsArray.length; idx++) {
            int[] nums = numsArray[idx];
            int target = targetArray[idx];

            List<Integer> result = targetIndices(nums, target);

            System.out.println((idx + 1) + ".\tnums: " + Arrays.toString(nums));
            System.out.println("\ttarget: " + target);
            System.out.println("\tresult: " + result);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
        int[][] nums1Cases = {
                {10, 20, 30},
                {5, 7, 9, 11, 23},
                {5, 5, 5},
                {1},
                {1, 2},
                {3, 5, 1, 7}
        };
        int[][] nums2Cases = {
                {1, 2, 3},
                {9, 11, 20, 44, 24},
                {5, 5, 5},
                {1},
                {2, 1},
                {1, 6, 2, 3}
        };

        for (int i = 0; i < nums1Cases.length; i++) {
            System.out.println((i + 1) + ".\tnums1: " + Arrays.toString(nums1Cases[i]));
            System.out.println("\tnums2: " + Arrays.toString(nums2Cases[i]));
            int result = countPairs(nums1Cases[i], nums2Cases[i]);
            System.out.println("\n\tNumber of valid pairs: " + result);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

        int[][] testCasest = {
                {4,6,7,10},
                {3, 5, 7, 9},
                {4, 2, 3, 4},
                {0, 0, 0},
                {6, 4, 9, 7, 8},
                {100, 200, 300, 400},
                {5},
                {10, 10, 10, 10}
        };

        for (int i = 0; i < testCasest.length; i++) {
            System.out.print((i + 1) + ".\t nums: [ ");
            for (int num : testCasest[i]) {
                System.out.print(num + " ");
            }
            System.out.println("]");

            int result = triangleNumber(testCasest[i]);
            System.out.println("\t Result: " + result);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

// Minimum Operations to Make All Array Elements Equal
        int[][] numsListM = {
                {4, 5, 2, 1},
                {2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {10, 20, 30},
                {7, 3, 9, 2}
        };
        int[][] queriesListM = {
                {3, 10, 21},
                {1},
                {10, 15, 5},
                {25, 50, 5},
                {5, 8, 4}
        };

        for (int i = 0; i < numsListM.length; i++) {
            int[] nums = numsListM[i];
            int[] queries = queriesListM[i];
            System.out.println((i + 1) + ".\tnums: " + Arrays.toString(nums));
            System.out.println("\tqueries: " + Arrays.toString(queries));
            List<Long> result = minOperations(nums, queries);
            System.out.println("\n\tResult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Sum of Mutated Array Closest to Target
        int[][] testCasesMutate = {
                {4, 9, 3},       // Example 1: Small array
                {2, 3, 5, 6, 7}, // Example 2: Medium array
                {1, 1, 1, 1},    // Example 3: Uniform array
                {2, 3, 5, 10},   // Example 4: Mixed values
                {1, 2, 23, 24, 34} // Example 5: Larger array
        };

        int[] targets = {10, 17, 4, 13, 110};

        for (int i = 0; i < testCasesMutate.length; i++) {
            int[] arr = testCasesMutate[i];
            int target = targets[i];

            int value = findBestValue(arr, target);

            System.out.println((i + 1) + ".\tarr: " + Arrays.toString(arr));
            System.out.println("\ttarget: " + target + "\n\n\tvalue: " + value);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Range Sum of Sorted Subarray Sums
        int[][] numsArrayT = {
                {1, 2, 3, 4},
                {3, 7, 2},
                {5},
                {8, 1, 4, 2},
                {10, 20, 30}
        };
        int[] nArray = {4, 3, 1, 4, 3};
        int[] leftArray = {1, 2, 1, 4, 1};
        int[] rightArray = {5, 6, 1, 8, 4};

        for (int idx = 0; idx < numsArrayT.length; idx++) {
            int[] nums = numsArrayT[idx];
            int n = nArray[idx];
            int left = leftArray[idx];
            int right = rightArray[idx];

            int result = rangeSum(nums, n, left, right);
            System.out.println((idx + 1) + ".\tnums: " + Arrays.toString(nums));
            System.out.println("\tn: " + n + ", left: " + left + ", right: " + right);
            System.out.println("\tRange sum of subarrays: " + result);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

        // Magnetic Force Between Two Balls

        int[][] arrs = {
                {1, 2, 3, 7, 11},
                {9, 8, 7, 3},
                {1, 3, 7, 9, 14},
                {1000, 1},
                {5, 10, 15, 20, 25, 30}
        };
        int[] ms = {2, 3, 5, 2, 4};

        for (int i = 0; i < arrs.length; ++i) {
            System.out.print(i + 1 + ".\tposition: [");
            for (int j = 0; j < arrs[i].length; ++j) {
                System.out.print(arrs[i][j]);
                if (j < arrs[i].length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("\tk: " + ms[i]);
            System.out.println("\n\tMagnetic force: " + maxDistance(arrs[i], ms[i]));
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }

        // Find K-th Smallest Pair Distance

        int[][] arrsM = {
                {1, 2, 3},
                {3, 3, 3},
                {1000, 0},
                {2, 4, 8, 12, 2},
                {500, 400, 300, 200, 100, 200, 300, 400, 500}
        };
        int[] ks = {1, 2, 1, 9, 36};

        for (int i = 0; i < arrsM.length; ++i) {
            System.out.print((i + 1) + ".\tnums: [");
            for (int j = 0; j < arrsM[i].length; ++j) {
                System.out.print(arrsM[i][j]);
                if (j < arrsM[i].length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("\tk: " + ks[i]);
            System.out.println("\n\tSmallest distance: " + smallestDistancePair(arrsM[i], ks[i]));
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }

        // Minimum Space Wasted from Packaging
        int[][] testPackages = {
                {3,6,9},
                {2, 3, 5},
                {5, 3, 2},
                {3, 5, 8, 10, 11, 12},
                {1, 2, 3, 4},
                {4, 8, 10}
        };

        int[][][] testBoxes = {
                {{1,2},{3,4}},
                {{4, 8}, {2, 8}},
                {{1, 4}, {2, 3}, {3, 4}},
                {{12}, {11, 9}, {10, 5, 14}},
                {{1, 3, 5}, {2, 4, 6}},
                {{5, 10}, {6, 8, 15}}
        };

        for (int i = 0; i < testPackages.length; i++) {
            System.out.println((i + 1) + ".\tPackages: " + Arrays.toString(testPackages[i]));
            System.out.println("\tBoxes: "+ Arrays.deepToString(testBoxes[i]));
            int result = minWastedSpace(testPackages[i], testBoxes[i]);
            System.out.println("\n\tResult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Russian Doll Envelopes



        int[][][] envelopes = {
                {{1, 4}, {6, 4}, {9, 5}, {3, 3}},
                {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}},
                {{4, 4}, {4, 4}, {4, 4}},
                {{3, 1}, {5, 8}, {5, 9}, {3, 1}, {9, 1}},
                {{9, 8}, {3, 1}, {4, 5}, {2, 1}, {5, 7}}
        };

        for (int i = 0; i < envelopes.length; i++) {
            System.out.print(i + 1 + ".\tEnvelopes: [");
            for (int j = 0; j < envelopes[i].length; j++) {
                System.out.print(Arrays.toString(envelopes[i][j]));
                if (j < envelopes[i].length - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("\n\tMaximum number of envelopes which can be Russian-dolled: " + maxEnvelopes(envelopes[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Put Marbles in Bags

        int[][] testCasesSS = {
                {5},
                {1, 7, 23, 29, 47},
                {1, 2, 3, 5},
                {1, 2, 3, 5},
                {1, 13, 17, 19, 23, 29, 31}
        };
        int[] kss = {1, 3, 4, 2, 4};

        for (int i = 0; i < testCasesSS.length; i++) {
            System.out.println((i + 1) + ".\tweights: " + Arrays.toString(testCasesSS[i]) + ", k: " + kss[i]);
            long result = putMarbles(testCasesSS[i], kss[i]);
            System.out.println("\tMaximum score difference: " + result);
            System.out.println("-".repeat(100));
        }

        List<int[]> testCasesC = Arrays.asList(
                new int[]{3, 0, 6, 1, 5},
                new int[]{1, 3, 1},
                new int[]{0, 0, 0, 0},
                new int[]{25, 8, 5, 3, 3},
                new int[]{5, 5, 5, 5, 5}
        );

        int[] expected = {3, 1, 0, 3, 5};

        for (int i = 0; i < testCasesC.size(); i++) {
            int[] citations = testCasesC.get(i);

            System.out.print((i + 1) + ".\tCitations: " + Arrays.toString(citations) + "\n");
            int result = hIndex(citations);
            System.out.println("\tH-Index: " + result);
            System.out.println("-".repeat(100));
        }

        // Two Sum Less Than K


    }



    // Maximum Number of Integers to Choose from a Range I

    public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bans = new HashSet<>();
        for (int num : banned) {
            bans.add(num);
        }

        int sum=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(!bans.contains(i)){
                if(sum+i<maxSum) {
                    sum += i;
                    count++;
                }else{
                    break;
                }

            }


        }
        // Replace this placeholder return statement with your code
        return count;
    }

    // Two Sum Less Than K

    public int twoSumLessThanK(int[] nums, int k) {

        Arrays.sort(nums);

        int left=0;
        int right=nums.length-1;
        int max=0;
        while(left<right){
            if(nums[left]+nums[right]<k){
                max=Math.max(left,nums[left]+nums[right]);
                left++;
            }else{
                right--;
            }

        }

        return max;
    }

// H-Index

    public static int hIndex(int[] citations)
    {

        int n=citations.length;
        int[] papers=new int[n+1];
        for(int c:citations){
            papers[Math.min(c,n)]+=1;
        }

        int k=n;
        int s=papers[n];


        while(s<k){
            k--;
            s+=papers[k];

        }

        // Replace this placeholder return statement with your code
        return k;
    }


// Put Marbles in Bags
    public static long putMarbles(int[] weights, int k) {
        int n=weights.length;
        int[] pair=new int[n-1];
        for(int i=0;i<n-1;i++){
            pair[i]=weights[i]+weights[i+1];
        }

        Arrays.sort(pair);
        int min=0;
        int max=0;
        for(int i=0;i<k-1;i++){
            min+=pair[i];
            max+=pair[n-i-2];
        }


        // Replace the following placeholder return statement with your code
        return max-min;
    }



// Russian Doll Envelopes

    public static int maxEnvelopes(int[][] envelopes) {

        // Replace this placeholder return statement with your code
        Arrays.sort(envelopes,((int [] a,int[] b)-> (a[0]==b[0])? b[1]-a[1]: a[0]-b[0] ));
        List<Integer> lis=new ArrayList<>();

        for(int env=0;env<envelopes.length;env++){
            int postion=findPossition(lis,envelopes[env][1]);

            if(postion==lis.size()){
                lis.add(envelopes[env][1]);
            }else{
                lis.set(postion,envelopes[env][1]);
            }

        }

        return lis.size();
    }

    private static int findPossition(List<Integer> lis, int env) {
        int left=0;
        int right=lis.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(lis.get(mid)==env){
                return mid;
            }else if(lis.get(mid)>env){
                right=mid-1;
            }else{
                left=mid+1;
            }

        }

        return left;
    }

    // Minimum Space Wasted from Packaging

    public static int minWastedSpace (int[] packages, int[][] boxes) {

        // Replace this placeholder return statement with your code

        long minWaste=Integer.MAX_VALUE;
        Arrays.sort(packages);
        int totalPackageSsize=Arrays.stream(packages).sum();

        for(int supplier=0;supplier<boxes.length;supplier++){
            Arrays.sort(boxes[supplier]);
            if(packages[packages.length-1]> boxes[supplier][boxes[supplier].length-1]){
                continue;
            }

            long totalSpaceUsed = 0;
            int startIndex=0;
            for(int box=0;box< boxes[supplier].length;box++){
                int endIndex=nearestVal(packages,boxes[supplier][box],startIndex);
                int numPackages=endIndex-startIndex;
                totalSpaceUsed+=(long)numPackages*boxes[supplier][box];
                startIndex=endIndex;
            }
            minWaste=Math.min(minWaste,totalSpaceUsed-totalPackageSsize);

        }

        return (minWaste!=Integer.MAX_VALUE)?(int)minWaste% 1_000_000_007:-1;
    }

    private static int nearestVal(int[] packages, int target, int start) {

        int left=start;
        int right=packages.length-1;


        while (left<=right){


            int mid=left+(right-left)/2;
            if(packages[mid]<=target){
                left=mid+1;
            }else{
                right=mid-1;

            }

        }
        return left;

    }

    // Find K-th Smallest Pair Distance

    public static int smallestDistancePair(int[] nums, int k) {

        // Replace this placeholder return statement with your code

        Arrays.sort(nums);
        int left=0;
        int right=nums[nums.length-1]-nums[0];
        int minDist=0;
        while(left<right){
            int mid=left+(right-left)/2;
            if(canPair(mid,nums,k)){
              //  minDist=left;
                left=mid+1;
            }else{
                right=mid;
            }


        }

        return left;
    }

    private static boolean canPair(int dist, int[] nums, int k) {

        int totalPair=0;
        for(int left=0,right=1;right<nums.length && totalPair<k;right++){
            while(nums[right]-nums[left]>dist)
                left++;

            totalPair+=right-left;

        }

        return totalPair>=k;

    }


    // Range Sum of Sorted Subarray Sums, brute force

    public static int rangeSum(int[] nums, int n, int left, int right) {
        // Replace the following placeholder return statement with your code
        List<Integer> subarrys=new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=sum+nums[j];
                subarrys.add(sum);
            }

        }
        Collections.sort(subarrys);
        int total=0;
        for(int i=left-1;i<=right-1 && i<=subarrys.size();i++){
            total+=subarrys.get(i);
        }

        return (int)(total % 1_000_000_007);
    }


    // Magnetic Force Between Two Balls
    public static int maxDistance(int[] position, int m) {
         int n=position.length;
         Arrays.sort(position);

         int left=1;
         int right=(position[n-1]-position[0])/(m-1);
         int force=0;
         while(left<=right){
             int mid=left+(right-left)/2;
             if(canDistribute(mid,m,position)){
                 force=mid;
                 left=mid+1;
             }else{
                 right=mid-1;
             }

         }

        // Replace this placeholder return statement with your code
        return force;
    }

    private static boolean canDistribute(int dist, int m,int[] position) {

        int balls=1;
        int prev=position[0];
        for(int i=1;i<position.length && balls<m;i++){
            int curr=position[i];
            if(curr-prev>=dist){
                balls++;
                prev=curr;
            }

        }
        return (balls==m);
    }

    // Range Sum of Sorted Subarray Sums, brute force

    public static int rangeSumHeap(int[] nums, int n, int left, int right) {
        // Replace the following placeholder return statement with your code
        PriorityQueue<int[]>  priorityQueue=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for(int i=0;i<n;i++){
            priorityQueue.offer(new int[]{nums[i],i,i+1});
        }

        int count=0;
        int ans=0;
        while(!priorityQueue.isEmpty() && count<right) {
            int[] curr = priorityQueue.poll();
            int currSum=curr[0];
            int currIndex=curr[1];
            int nextIndex=curr[2];

            count++;


            if(count>=left){
                ans=(ans+currSum) % 1_000_000_007;
            }

            if(nextIndex<n){
                priorityQueue.offer(new int[]{currSum+nums[nextIndex],currIndex,nextIndex+1});
            }

        }



        return (int)(ans % 1_000_000_007);
    }

    // Sum of Mutated Array Closest to Target
    public static int findBestValue(int[] arr, int target) {

        int n=arr.length;
        int prefix=0;
        for(int i=0;i<n;i++) {
            int remainingCount = n - i;
            int maxifCap = arr[i] * remainingCount;
            if (prefix + maxifCap >= target) {
                double cap =(double) (target - prefix) / remainingCount;
                return (cap - (int) cap == 0.5) ? (int) cap : (int)Math.round(cap);

            }

            prefix += arr[i];
        }
        return arr[n-1];
    }

    // Minimum Operations to Make All Array Elements Equal

    public static List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n=nums.length;
        int m=queries.length;
        long[] prefixSum=new long[n+1];
        for(int i=0;i<n;i++){
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }

        List<Long> result=new ArrayList<>();

        for(int i=0;i<m;i++){
            int query=queries[0];
            int pointer=binarySearchMinOperation(nums,query);
            long left=(long)query*pointer-prefixSum[pointer];
            long right=(prefixSum[n]-prefixSum[pointer])-(long)query*(n-pointer);
            result.add(left+right);

        }

        return result;

    }

    private static int binarySearchMinOperation(int[] nums, int query) {
        int low=0;
        int high=nums.length-1;
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(query>nums[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return low;
    }

    // Valid Triangle Number
    public static int triangleNumber (int[] nums) {

        int count=0;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=2;i--){
            int right=i-1;
            int left=0;
            while(left<right){
                if(nums[left]+nums[right]>nums[i]){
                    count+=right-left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return count;
    }




    // Count Pairs in Two Arrays
    public static int countPairs(int[] nums1, int[] nums2) {
        int[] diff=new int[nums1.length];

        for(int i=0;i<nums1.length;i++) {
            diff[i]=nums1[i]-nums2[i];

        }

        Arrays.sort(diff);
        int count=0;
        int n=diff.length;
        for(int i=0;i<n;i++){
            if(diff[i]>0){
                count+=n-i-1;

            }else{
                int left=i+1;
                int right=n-1;
                while(left<=right){
                    int mid=left+(right-left)/2;
                    if(diff[i]+diff[mid]>0){
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }

                count+=n-left;
            }


        }


        // Replace this placeholder return statement with your code
        return count;
    }


    // Find Target Indices After Sorting Array

    public static List<Integer> targetIndices(int[] nums, int target) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }

        return result;
    }


    // Longest Subsequence With Limited Sum
    public static int[] answerQueries(int[] nums, int[] queries) {

        int[] prefixSum=new int[nums.length];
        int[] ans=new int[queries.length];

        Arrays.sort(nums);
        prefixSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }

        for(int i=0;i<queries.length;i++){
            int position=0;
            if(queries[i]>=prefixSum[0] && queries[i]<=prefixSum[prefixSum.length-1]){
                position=binarySearchAnswerQuery(prefixSum,queries[i]);
            }else if(queries[i]>prefixSum[prefixSum.length-1] ){
                position=prefixSum.length;
            }
            ans[i]=position;

        }


        // Replace this placeholder return statement with your code
        return ans;
    }

    private static int binarySearchAnswerQuery(int[] prefixSum, int query) {

        int left=0;
        int right=prefixSum.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(prefixSum[mid]<=query){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }
        return left;
    }

    // Find the Distance Value Between Two Arrays
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d)
    {

        int distance=0;
        Arrays.sort(arr2);

        for(int num1:arr1){
            boolean valid=true;
            int left=0;
            int right=arr2.length-1;

            while(left<=right){
                int mid=left+(right-left)/2;
                if(arr2[mid]==num1){
                    valid = false;
                    break;
                } else if(arr2[mid]<num1){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            if(left<arr2.length && Math.abs(num1-arr2[left])<=d){
                valid=false;
            }

            if(right>=0 && Math.abs(num1-arr2[right])<=d){
                valid=false;
            }

            if(valid)
                distance++;


        }

        // Replace this placeholder return statement with your code
        return distance;
    }
}
