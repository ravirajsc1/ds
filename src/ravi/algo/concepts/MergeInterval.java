package ravi.algo.concepts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeInterval {

    public static void main(String[] args) {

        int[][][] all_intervals = {
                {{3, 7}, {1, 5}, {4, 6}},
                {{1, 5}, {6, 8}, {4, 6}, {11, 15}},
                {{3, 7}, {10, 12}, {6, 8}, {11, 15}},
                {{1, 5}},
                {{1, 9}, {4, 4}, {3, 8}},
                {{1, 2}, {8, 8}, {3, 4}},
                {{1, 5}, {1, 3}},
                {{1, 5}, {6, 9}},
                {{0, 0}, {1, 18}, {1, 3}}
        };

        for (int i = 0; i < all_intervals.length; i++) {
            System.out.println((i + 1) + ". Intervals to merge: " + Arrays.deepToString(all_intervals[i]));
            int[][] result = mergeIntervals(all_intervals[i]);
            System.out.println("   Merged intervals:\t" + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        LinkedList<int[]> results=new LinkedList<>();
        results.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){

            if(intervals[i][0] <= results.getLast()[1]){
                results.getLast()[1]=Math.max(results.getLast()[1],intervals[i][1]);
            }else{
                results.add(intervals[i]);
            }
        }
        return results.toArray(new int[results.size()][]);

    }



}
