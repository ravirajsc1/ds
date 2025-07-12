package ravi.algo.concepts;

import java.util.*;

/*

| **Goal**                                                                               | **Loop Condition**     | **Condition (`if`)**  | **Assignment**                         | **Return After Loop**         |
| -------------------------------------------------------------------------------------- | ---------------------- | --------------------- | -------------------------------------- | ----------------------------- |
| **Find exact match**                                                                   | `while (low <= high)`  | `if (mid == target)`  | `low = mid + 1` or `high = mid - 1`    | Usually `mid` (when match)    |
| **Find first index where condition is true** <br> (Lower bound / Min value that works) | `while (low < high)`   | `if (condition(mid))` | `high = mid`                           | `low` (first valid index)     |
| **Find last index where condition is true** <br> (Upper bound / Max value that works)  | `while (low < high)`   | `if (condition(mid))` | `left = mid + 1`                       | `left - 1` (last valid index) |
| **Find maximum value that satisfies condition**                                        | `while (left < right)` | `if (condition(mid))` | `left = mid`<br>`else right = mid - 1` | `left`                        |
| **Find minimum value that satisfies condition**                                        | `while (left < right)` | `if (condition(mid))` | `right = mid`<br>`else left = mid + 1` | `left`                        |
x
 */

public class ModifiedBinarySearch {
    public static void main(String[] args) {

        // binary search

        int[][] numsLists = {
                {1},
                {0, 1},
                {1, 2, 3},
                {-1, 0, 3, 5, 9, 12},
                {-100, -67, -55, -50, -49, -40, -33, -22, -10, -5}
        };

        int[] targetList = {12, 1, 3, 9, -22};

        for (int i = 0; i < numsLists.length; i++) {
            int[] nums = numsLists[i];
            int target = targetList[i];
            int index = binarySearch(nums, target);
            System.out.println((i + 1) + ".\tArray to search: " + Arrays.toString(nums));
            System.out.println("\tTarget: " + target);
            if (index != -1) {
                System.out.println("\t" + target + " exists in the array at index " + index);
            } else {
                System.out.println("\t" + target + " does not exist in the array, so the return value is " + index);
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Search in Rotated Sorted Array

            int[][] numArrays = {
                    {5, 6, 7, 1, 2, 3, 4},
                    {40, 50, 60, 10, 20, 30},
                    {47, 58, 69, 72, 83, 94, 12, 24, 35},
                    {77, 82, 99, 105, 5, 13, 28, 41, 56, 63},
                    {48, 52, 57, 62, 68, 72, 5, 7, 12, 17, 21, 28, 33, 37, 41}
            };

            int[] targetArray = {1, 50, 12, 56, 5};

            for (int i = 0; i < targetArray.length; i++) {
                System.out.println((i + 1) + ".\tRotated array: " + Arrays.toString(numArrays[i]) +
                        "\n\ttarget " + targetArray[i] +
                        " found at index " + binarySearchRotated(numArrays[i], targetArray[i]));
                System.out.println(new String(new char[100]).replace('\0', '-'));
            }

        int[] versions = {6, 8, 9, 11, 8};
        int[] badVersions = {3, 5, 1, 11, 4};

        for (int i = 0; i < versions.length; i++) {
            BadVersion badVersion=new BadVersion(badVersions[i]);
            System.out.println((i + 1) + ".\tNumber of versions: " + versions[i]);
            System.out.println("\n\tFirst bad version: " + firstBadVersion(badVersion,versions[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //  Find K Closest Elements

        int[][] inputs={
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5},
                {1, 2, 4, 5, 6},
                {1, 2, 3, 4, 5, 10}
        };
        int[] k = {4, 4, 2, 3};
        int[] x = {4, 3, 10, -5};
        for(int i=0; i<k.length; i++){
            List<Integer> kList = findClosestElements(inputs[i], k[i], x[i]);
            System.out.print(i+1);
            System.out.println(".\tThe "+k[i]+" closest elements for the number "+x[i]+ " in the array "+ Arrays.toString(inputs[i])+ " are: ");
            System.out.print("\t[");
            for(int j = 0; j < k[i]-1; j++) {
                System.out.print(kList.get(j) + ", ");
            }
            System.out.println(kList.get(k[i]-1) + "]");
           // System.out.println(PrintHyphens.repeat("-", 100));
        }

        // single

        int[][] inputsSingle = {
                {1, 2, 2, 3, 3, 4, 4},
                {1, 1, 2, 2, 3, 4, 4, 5, 5},
                {1, 1, 2, 3, 3},
                {1, 1, 2},
                {0, 2, 2, 3, 3, 4, 4, 5, 5}
        };
        for (int i = 0; i < inputsSingle.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput array: " + Arrays.toString(inputsSingle[i]));
            System.out.println("\n\tSingle element found: " + singleNonDuplicate(inputsSingle[i]));
           // System.out.println(PrintHyphens.repeat("-", 100));        }
    }


        // Maximum Value at a Given Index in a Bounded Array
        int[][] inputList = {
                {6, 3, 18},
                {4, 2, 6},
                {3, 0, 3},
                {5, 3, 15},
                {7, 4, 20}
        };

        for (int i = 0; i < inputList.length; i++) {
            int n = inputList[i][0];
            int index = inputList[i][1];
            int maxSum = inputList[i][2];
            int result = maxValue(n, index, maxSum);
            System.out.println((i + 1) + ".\tInput: n = " + n + ", index = " + index + ", maxSum = " + maxSum);
            System.out.println("\tMaximum mid at index " + index + ": " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // The K Weakest Rows in a Matrix

        int[][][] matrixList = {
                {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}},
                {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 1, 1, 1}, {1, 1, 0, 0}},
                {{1, 1}, {1, 1}, {0, 0}, {1, 0}, {1, 1}},
                {{1, 0, 0, 0}, {1, 1, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}},
                {{1, 0, 0}, {0, 0, 0}, {1, 1, 1}, {1, 1, 0}}
        };
        int[] kValues = {2, 3, 3, 2, 1};

        for (int i = 0; i < matrixList.length; i++) {
            System.out.println((i + 1) + ".\tInput matrix: \n\tmatrix = " + Arrays.deepToString(matrixList[i]) + "\n\tk = " + kValues[i]);
            int[] weakestRows = findKWeakestRows(matrixList[i], kValues[i]);
            System.out.println("\n\tIndexes of the " + kValues[i] + " weakest rows: " + Arrays.toString(weakestRows));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }


        // Split Array Largest Sum
        int[][] splits = {
                {3, 4, 6, 3},
                {2, 7, 8, 9, 2, 1, 4},
                {12, 53, 43, 67, 35},
                {4, 6, 4, 6, 4, 6},
                {11, 11, 11, 11, 11}
        };
        int[] ksplit = {3, 6, 5, 4, 2};


        //  // Find Minimum in Rotated Sorted Array II
        for (int i = 0; i < splits.length; i++) {
            System.out.println((i + 1) + ".\tInput Array: " + java.util.Arrays.toString(splits[i]));
            System.out.println("\tk: " + ksplit[i]);
            System.out.println("\tLargest minimized sum: " + splitArray(splits[i], ksplit[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[][] arrs = {
                {4, 5, 6, 7, 0, 1, 4},
                {8},
                {500, 600, 700, 800, 900, 1000},
                {-5, -3, -2, 0, 2, 3, 5, 7, 11, -11, -7},
                {64, 128, 256, 256, 512, 2, 4, 8, 16, 16, 16, 32, 64}
        };


        for (int i = 0; i < arrs.length; ++i) {
            System.out.print((i + 1) + ".\tnums: [");
            for (int j = 0; j < arrs[i].length; ++j) {
                System.out.print(arrs[i][j]);
                if (j < arrs[i].length - 1) System.out.print(", ");
            }
            System.out.println("]\n");
            System.out.println("\tMinimum element: " + findMin(arrs[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[][] testCases = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {0, 10, 20, 30, 40, 50, 60, 70, 80, 90},
                {0, 3, 8, 14, 25, 27, 35, 47, 58, 72},
                {0, 8, 15, 37, 45, 52, 68, 95, 123, 150, 178, 221, 260, 321, 389, 398, 412, 464, 531, 600},
                {5, 8, 15, 25, 40, 60, 68, 74, 104, 116, 121, 130, 134, 159, 177, 179, 195, 206, 220, 233}
        };

        int[] kValuesS = {9, 5, 3, 19, 5};

        for (int i = 0; i < testCases.length; i++) {
            int[] stations = testCases[i];
            int ks = kValuesS[i];

            double result = minimizeGasDistance(stations, ks);
            System.out.print((i + 1) + ":\tStations = " + Arrays.toString(stations) + ", k = " + ks);
            System.out.println("\n\tMinimum possible penalty = " + String.format("%.5f", result));
            System.out.println("-".repeat(100));
        }

        // Divide Chocolate

        List<int[]> testCasesChochlet = Arrays.asList(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                new int[]{5},
                new int[]{1, 2, 2, 1, 2, 2, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}
        );

        int[] ks = {5, 0, 3, 6, 20};

        for (int i = 0; i < testCasesChochlet.size(); i++) {
            int[] sweetness = testCasesChochlet.get(i);
            int kc = ks[i];

            System.out.println((i + 1) + ".\tsweetness = " + Arrays.toString(sweetness));
            System.out.println("\tk = " + kc);

            int result = maximizeSweetness(sweetness, kc);
            System.out.println("\n\toutput: " + result);
            System.out.println("----------------------------------------------------------------------------------------------------");
        }


    }
//
    public static boolean search(int[] arr, int target) {

        // Replace this placeholder return statement with your code
        int left=0;
        int right=arr.length-1;

        while(left<=right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] == arr[left] && arr[mid] == arr[right]) {
                right--;
                left++;
            } // right sie is sorted
            else if (arr[mid] <= arr[right]) {
                if ((target > arr[mid] && target <= arr[right]))
                    left = mid + 1;
                else {
                    right = mid - 1;
                }
            } else {  //left side is stored
                if ((target >= arr[left] && target < arr[mid]))
                    right = mid - 1;
                else {
                    left = mid + 1;
                }
            }

        }

        return false;
    }


// Divide Chocolate
    public static int maximizeSweetness(int[] sweetness, int k) {
        int totalSum=Arrays.stream(sweetness).sum();
        int left=1;
        int right=totalSum/(k+1);
        int result = left;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canDevide(sweetness,k,mid)){
                result=mid;
                left=mid+1;

            }else{
               right=mid-1;
            }
        }


        // Replace this placeholder return statement with your code
        return result;
    }

    private static boolean canDevide(int[] sweetness, int k, int mid) {
        int sum=0;
        int pieces=0;

        for(int sweet:sweetness){
            sum+=sweet;
            if(sum>=mid){
                pieces++;
                sum=0;
            }
        }
        return pieces>=k+1;
    }

    public static double minimizeGasDistance(int[] stations, int k) {
        double left=0.0;
        double right=stations[stations.length-1]-stations[0];
        final double epsilon=1e-6;

        while(right-left>epsilon){
            double mid=(left+right)/2;
            if(isFeasibleMaxGap(stations,k,mid)){
                right=mid;
            }else{
                left=mid;
            }

        }


        // Replace this placeholder return statement with your code
        return left;
    }


    /*
 Example Diagram (assume d = 10):
    stations = [0,      10,       30]
gaps:          10      20

For gap 10: no station needed, there is already gap of distance 10 between all gaps
For gap 20: 20 / 10 = 2 → need 1 station

Total needed: 1 ≤ k=2 ✅ it's possible!
stations = [0, 10, 30]
k = 1   //
| Iter | `left` | `right` | `mid`   | IsPossible(`mid`) | Why?                                                                               | Update          |
| ---- | ------ | ------- | ------- | ----------------- | ---------------------------------------------------------------------------------- | --------------- |
| 1    | 0.0    | 30.0    | 15.0    | ✅ Yes             | gap 10 → 0 stations, gap 20 → 1 station (20/15 = 1.33 → floor = 1) → total 1 ≤ k ✅ | right = 15      |
| 2    | 0.0    | 15.0    | 7.5     | ❌ No              | gap 10 → 1 (10/7.5 = 1.33), gap 20 → 2 (20/7.5 = 2.66) → total 3 > k ❌             | left = 7.5      |
| 3    | 7.5    | 15.0    | 11.25   | ✅ Yes             | 10/11.25 = 0, 20/11.25 = 1 → total 1 ≤ k ✅                                         | right = 11.25   |
| 4    | 7.5    | 11.25   | 9.375   | ❌ No              | 10/9.375 = 1, 20/9.375 = 2 → total = 3 > k                                         | left = 9.375    |
| 5    | 9.375  | 11.25   | 10.3125 | ✅ Yes             | 10/10.3125 = 0, 20/10.3125 = 1.93 → floor = 1 → total = 1 ≤ k ✅                    | right = 10.3125 |


we have to flip the qestion if we split the gap will any gap will be more then mid
“Can I break this gap into segments that are all ≤ distance?”

     */
    private static boolean isFeasibleMaxGap(int[] stations, int k, double distance) {
        int requiredStation=0;
        for(int i=1;i<stations.length;i++){
            double gap=stations[i]-stations[i-1];
            requiredStation+=(int)(gap/distance);  // how many station you need for distance.
            if(requiredStation>k){
                return false;
            }
        }
        return true;
    }



    /*
    | Update Pattern    | Use Mid Formula                    |
| ----------------- | ---------------------------------- |
| `left = mid`      | `mid = right - (right - left) / 2` |
| `left = mid + 1`  | `mid = left + (right - left) / 2`  |
| `right = mid - 1` | Either is OK                       |
| `right = mid`     | `mid = left + (right - left) / 2`  |

     */

    // Maximum Running Time of N Computers
    public static int maxRunTime(int[] batteries, int n) {
        // Replace this placeholder return statement with your code
        int totalSum=0;
        for(int battery:batteries){
            totalSum+=battery;

        }

        int left=0;
        int right=totalSum/n;

        while(left<right){
            int mid=right-(right-left)/2;

            int usable=0;
            for(int battery:batteries){
                usable+=Math.min(battery,mid);
            }

            if(usable>= mid*n){
                left=mid;
            }else{
                right=mid-1;
            }

        }

        return left;
    }


    // Find Minimum in Rotated Sorted Array II


    public static int findMin(int[] nums) {

        int left=0;
        int right=nums.length-1;

        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[right]){
                right=mid;
            }else if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right--;
            }

        }

        // Replace this placeholder return statement with your code
        return nums[left];
    }


    // Split Array Largest Sum
    /* Doing Binary Search on the Possible Values of the Largest Subarray Sum
You're not doing binary search on indices or elements of the array.

You're doing binary search on the range of possible answers — the range of values that the largest subarray sum could be.

The canSplit function checks if it’s possible to split the array into k or fewer subarrays such that no subarray’s sum exceeds mid (the current guess for the largest allowed sum).

If canSplit returns true, it means we can try to find an even smaller largest sum (so we move the search space left/down).

If it returns false, it means mid is too small to split properly, so we need to increase it (move right/up).
*/

    public static int splitArray(int[] nums, int k) {

        int totalSum=0;
        int highest=0;
        for(int num:nums){
            totalSum+=num;
            highest=Math.max(highest,num);
        }

        int left=highest;
        int right=totalSum;
        while(left<right){
            int mid=left+(right-left)/2;
            if(canSplit(nums,mid,k)){
                right=mid;  // mid is also possible vaue
            }else{
                left=mid+1;
            }


        }
        // Replace this placeholder return statement with your code
        return left;
    }

    private static boolean canSplit(int[] nums, int mid, int k) {
        int subarrays = 1;
        int currentSum = 0;

        for(int num:nums){
            if(currentSum+num>mid){
                subarrays++;
                currentSum=num;
                if(subarrays>k){
                    return false;
                }
            }else{
                currentSum+=num;
            }

        }
        return true;
    }


    // The K Weakest Rows in a Matrix

    public static int[] findKWeakestRows(int[][] matrix, int k) {

        // Replace the following return statement with your code
        int[] result = new int[k];
        PriorityQueue<int []> maxHeap=new PriorityQueue<>((a,b)->b[0]!=a[0]? b[0]-a[0]:b[1]-a[1] );
        for(int i=0;i<matrix.length;i++){
            int binarySearch=binnarySearchWeakestRows(matrix[i]);
            maxHeap.offer(new int[]{binarySearch,i});
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }


        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll()[1];
        }


        return result;
    }

    /*
| What you want                            | Use `left = mid + 1` or `right = mid - 1`? | Loop condition  | Return        |
| ---------------------------------------- | ------------------------------------------ | --------------- | ------------- |
| Find first index where something is true | `right = mid`                              | `left < right`  | `left`        |
| Find last index where something is true  | `left = mid + 1`                           | `left <= right` | `right`       |
| Find exact index/value (classic binary)  | `left = mid + 1` / `right = mid - 1`       | `left <= right` | `mid` or flag |
     */

    /*
    * | Goal                            | While Condition | Mid Calculation                     | Move `left`      | Move `right`      | Final Return |
| ------------------------------- | --------------- | ----------------------------------- | ---------------- | ----------------- | ------------ |
| **Lower bound** (first true)    | `left < right`  | `mid = left + (right - left)/2`     | `left = mid + 1` | `right = mid`     | `left`       |
| **Upper bound - 1** (last true) | `left < right`  | `mid = left + (right - left + 1)/2` | `left = mid`     | `right = mid - 1` | `left`       |
| **Last true** (alternative)     | `left <= right` | `mid = left + (right - left)/2`     | `left = mid + 1` | `right = mid - 1` | `answer`     |

    *
    * */
    private static int binnarySearchWeakestRows(int[] row) {
        int left=0;
        int right=row.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(row[mid]==1){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }

    // Maximum Value at a Given Index in a Bounded Array


    public static int calculate(int index,int mid, int n){
        int count=0;

        if(mid>index){
            count+=(mid+(mid-index))*(index+1)/2;
        }else{
            count+=(mid+1)*mid/2+(mid-index+1);
        }

        if(mid>=n-index){
            count+=(mid+(mid-n+1+index))*(n-index)/2;

        }else{
            count+=(mid+1)*mid/2 +(n-index-mid);
        }

        return count-mid;
    }



    public static int maxValue(int n, int index, int maxSum) {

        int left=0;
        int right=maxSum;

        while(left<right){
            int mid=(right+left+1)/2;
            if(maxSum>=calculate(index,mid,n)){
                left=mid;
            }else{
                right=mid-1;
            }

        }
            // Replace this placeholder return statement with your code
        return left;
    }

    // singleNonDuplicate
    public static int singleNonDuplicate(int[] nums) {

        int left=0;
        int right=nums.length-1;

        while(left<right){

            int mid=left+(right-left)/2;

            if(mid%2==1){
                mid--;
            }

            if(nums[mid]==nums[mid+1]){
                left=mid+2;
            }else{
                right=mid;
            }

        }


        // Replace this placeholder return statement with your code
        return nums[left];
    }

    //  Find K Closest Elements
    public static List<Integer> findClosestElements(int[] nums, int k, int target) {
        List<Integer> closedElements = new ArrayList<>();
        // first if it is of same leth
        if(nums.length==k){
            for(int num:nums){
                closedElements.add(num);
            }
            return closedElements;
        }

        // check if it on left
        if(target<=nums[0]){
            for(int i=0;i<k;i++){
                closedElements.add(nums[i]);
            }
            return closedElements;
        }
       // check if it on right
        if(target>=nums[nums.length-1]){
            for (int i = nums.length - k; i < nums.length; i++) {
                closedElements.add(nums[i]);
            }
            return closedElements;
        }
        // within array
        int closest=binarySearchInt(nums,target);
        int leftWindow=closest-1;
        int rightWindow=leftWindow+1;
         while((rightWindow-leftWindow -1)  < k){
             if(leftWindow==-1){
                 rightWindow++;
                 continue;
             }
             if(rightWindow==nums.length || Math.abs(target-nums[leftWindow]) <= Math.abs(target-nums[rightWindow])){
                 leftWindow--;
             }else{
                 rightWindow++;
             }
        }

         for(int i=leftWindow+1;i<rightWindow;i++){
             closedElements.add(nums[i]);
         }


        return closedElements;
    }

    public static int binarySearchInt(int[] nums, int target){
        int left=0;
        int right=nums.length-1;

        while(left< right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }
        return left;
    }
    // bad version

    public static int firstBadVersion(BadVersion badVersion, int n) {
        int first=0;
        int last=n;

        if(first<=last){
            int mid=first+(last-first)/2;
            if(badVersion.isBadVersion(mid)){

            }
        }

        // Replace this placeholder return statement with your code
        return 0;
    }

    // Search in Rotated Sorted Array

    public static int binarySearchRotated(int[] nums, int target) {

        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[left]<nums[mid]){
                if(nums[left]<= target && target <nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(nums[mid]< target && target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }

            }


        // Replace this placeholder return statement with your code
        return -1;
    }


    //binary search
    public static int binarySearch (int [] nums, int target) {

        int left=0;
        int right=nums.length-1;


        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }

        // Replace this placeholder return statement with your code
        return -1;
    }


}


