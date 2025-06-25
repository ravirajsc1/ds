package ravi.algo.concepts;

import java.rmi.StubNotFoundException;
import java.util.*;

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


        // new internal
        int[][] newIntervals = {
                {1, 10}, {1, 5}, {5, 7}, {8, 9}, {10, 12}, {1, 3}
        };

        int[][][] existingIntervals = {
                {{0, 5}, {3, 7}},
                {{1, 4}, {5, 6}, {7, 8}, {9, 10}},
                {{1, 2}, {3, 5}, {6, 8}},
                {{1, 3}, {5, 7}, {10, 12}},
                {{8, 10}, {12, 15}},
                {{5, 7}, {8, 9}}

        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.println((i + 1) + ".\tExisting intervals: " + Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: " + Arrays.toString(newIntervals[i]));
            int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println("----------------------------------------------------------------------------------------------------");
        }


        //Interval List Intersections

        int[][][] inputIntervalLista = {
                {{1, 2}},
                {{1, 4}, {5, 6}, {9, 15}},
                {{3, 6}, {8, 16}, {17, 25}},
                {{4, 7}, {9, 16}, {17, 28}, {39, 50}, {55, 66}, {70, 89}},
                {{1, 3}, {5, 6}, {7, 8}, {12, 15}}
        };

        int[][][] inputIntervalListb = {
                {{1, 2}},
                {{2, 4}, {5, 7}, {9, 15}},
                {{2, 3}, {10, 15}, {18, 23}},
                {{3, 6}, {7, 8}, {9, 10}, {14, 19}, {23, 33}, {35, 40}, {45, 59}, {60, 64}, {68, 76}},
                {{2, 4}, {7, 10}}
        };

        for (int i = 0; i < inputIntervalLista.length; i++) {
            System.out.println(i + 1 + ".\t Interval List A: " + Arrays.deepToString(inputIntervalLista[i]));
            System.out.println("\t Interval List B: " + Arrays.deepToString(inputIntervalListb[i]));
            System.out.println("\t Intersecting intervals in 'A' and 'B' are: " +
                    Arrays.deepToString(intervalsIntersection(inputIntervalLista[i], inputIntervalListb[i])));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //Employee Free Time
        List<List<List<Interval>>> inputs1 = Arrays.asList(
                Arrays.asList(
                        Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
                        Arrays.asList(new Interval(1, 3)),
                        Arrays.asList(new Interval(4, 10))
                ),
                Arrays.asList(
                        Arrays.asList(new Interval(1, 3), new Interval(6, 7)),
                        Arrays.asList(new Interval(2, 4)),
                        Arrays.asList(new Interval(2, 5), new Interval(9, 12))
                ),
                Arrays.asList(
                        Arrays.asList(new Interval(2, 3), new Interval(7, 9)),
                        Arrays.asList(new Interval(1, 4), new Interval(6, 7))
                ),
                Arrays.asList(
                        Arrays.asList(new Interval(3, 5), new Interval(8, 10)),
                        Arrays.asList(new Interval(4, 6), new Interval(9, 12)),
                        Arrays.asList(new Interval(5, 6), new Interval(8, 10))
                ),
                Arrays.asList(
                        Arrays.asList(new Interval(1, 3), new Interval(6, 9), new Interval(10, 11)),
                        Arrays.asList(new Interval(3, 4), new Interval(7, 12)),
                        Arrays.asList(new Interval(1, 3), new Interval(7, 10)),
                        Arrays.asList(new Interval(1, 4)),
                        Arrays.asList(new Interval(7, 10), new Interval(11, 12))
                ),
                Arrays.asList(
                        Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8)),
                        Arrays.asList(new Interval(2, 3), new Interval(4, 5), new Interval(6, 8))
                ),
                Arrays.asList(
                        Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8), new Interval(9, 10), new Interval(11, 12)),
                        Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8), new Interval(9, 10), new Interval(11, 12)),
                        Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8), new Interval(9, 10), new Interval(11, 12)),
                        Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8), new Interval(9, 10), new Interval(11, 12))
                )
        );

        int i = 1;
        List<List<List<Interval>>> inputs = new ArrayList<>();

        for (int j = 0; j < inputs1.size(); j++) {
            inputs.add(new ArrayList<List<Interval>>());

            for (int k = 0; k < inputs1.get(j).size(); k++) {
                inputs.get(j).add(new ArrayList<Interval>());

                for (int g = 0; g < inputs1.get(j).get(k).size(); g++) {
                    inputs.get(j).get(k).add(inputs1.get(j).get(k).get(g));
                }
            }
        }

        for (int j = 0; j < inputs.size(); j++) {
            System.out.println(i + ".\tEmployee Schedules:\n");

            for (int s = 0; s < inputs.get(j).size(); s++) {
                System.out.println("\t\t" + display(inputs.get(j).get(s)));
            }

            System.out.println("\n\tEmployees' free time " + display(employeeFreeTime(inputs.get(j))));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            i += 1;
        }

        // Count Days Without Meetings

        int[] inputDays = {12, 6, 100000, 3136, 786};
        int[][][] inputMeetings = {
                {{5, 6}, {9, 11}, {1, 3}},
                {{2, 4}, {5, 5}},
                {{1, 100000}},
                {{361, 570}, {420, 1225}, {72, 144}, {987, 1444}},
                {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}, {11, 12}}
        };

   //     Solution sol = new Solution();

        for (int ind = 0; ind < inputDays.length; ind++) {
            System.out.println((i + 1) + ".\tdays: " + inputDays[ind]);
            System.out.println("\tmeetings: " + Arrays.deepToString(inputMeetings[ind]));
         //   System.out.println("\n\tNumber of free days: " + sol.countDays(inputDays[i], inputMeetings[i]));
            System.out.println("\n\tNumber of free days: " + countDays(inputDays[ind], inputMeetings[ind]));
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }

        // Remove Covered Intervals
        int[][][] testCases = {
                {{1, 4}, {3, 6}, {2, 8}},
                {{1, 2}, {1, 4}, {3, 4}},
                {{1, 10}, {2, 9}, {3, 8}, {4, 7}},
                {{1, 3}, {4, 6}, {7, 9}},
                {{1, 5}, {2, 3}, {4, 6}}
        };



        for (int ind = 0; ind < testCases.length; ind++) {
            int[][] intervals = testCases[ind];
            System.out.print((ind + 1) + ".\tIntervals: [");
            for (int j = 0; j < intervals.length; j++) {
                System.out.print("[" + intervals[j][0] + ", " + intervals[j][1] + "]");
                if (j != intervals.length - 1) System.out.print(", ");
            }
            System.out.println("]");

            int result = removeCoveredIntervals(intervals);
            System.out.println("\tResult: " + result);
            System.out.println(new String(new char[100]).replace("\0", "-"));

            int resultSet = findSets(intervals);
            System.out.println("\tResult for find set: " + resultSet);
            System.out.println(new String(new char[100]).replace("\0", "-"));

        }


    }


    // find set
    public static int findSets(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(int[] interval:intervals){
            if(!minHeap.isEmpty() && interval[0]>=minHeap.peek()){
                minHeap.poll();
            }
            minHeap.offer(interval[1]);

        }

        // Replace this placeholder return statement with your code
        return minHeap.size();
    }


        // Remove Covered Intervals

    public static int removeCoveredIntervals(int[][] intervals)
    {
        Arrays.sort(intervals,Comparator.comparingInt((int[] a)-> a[0]).thenComparingInt(a->-a[1]));

        int count=1;
        int maxEnd=intervals[0][1];
        int i=1;
        while(i< intervals.length){
            if(maxEnd<intervals[i][1]){
                count+=1;
                maxEnd=intervals[i][1];
            }

            i++;
        }

        // Replace this placeholder return statement with your code
        return count;
    }
    // Count Days Without Meetings

    public static int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings,Comparator.comparingInt(a->a[0]));
        int i=1;
        int start=meetings[0][0],end=meetings[0][1];
        int sum=0;
        while(i<meetings.length){
            if(meetings[i][0]<end){
                end=Math.max(meetings[i][1],end);
            }else{
                sum+=end-start+1;
                start=meetings[i][0];
                end=meetings[i][1];
            }
            i++;
        }

        sum+=end-start+1;

        // Replace this placeholder return statement with your code
        return days-sum;
    }

    // employee-free-time
    public static String display(List<Interval> l1) {
        if (l1.size() == 0) {
            return "[]";
        }

        String resultStr = "[";

        for (int i = 0; i < l1.size() - 1; i++) {
            resultStr += "[" + l1.get(i).start + ", ";
            resultStr += l1.get(i).end + "], ";
        }

        resultStr += "[" + l1.get(l1.size() - 1).start + ", ";
        resultStr += l1.get(l1.size() - 1).end + "]";
        resultStr += "]";

        return resultStr;
    }

    //Employee Free Time

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {


        // a[0]: the start time of the interval
        // a[1]: the employee index
        // a[2]: the index of the interval within that employee's schedule
        // Replace this placeholder return statement with your code
        //  schedule = [
        // [[1, 3], [6, 7]],     // Employee 0
        //[[2, 4]],             // Employee 1
        // [[5, 6], [8, 9]]      // Employee 2
        //]
        //✅ Corrected version:
        //  Step	Interval Processed	Previous (Before)	Gap Found?	Previous (After)
        //1	[1, 3]	1	       ❌        No	                                3
        //2	[2, 4]	3	       ❌        No	                                4
        //3	[5, 6]	4       	✅       Yes                  → [4, 5]	    6
        //4	[6, 7]	6	        ❌       No	                                  7
        //5	[8, 9]	7	        ✅       Yes                 → [7, 8]	       9

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < schedule.size(); i++) {
            heap.offer(new int[]{schedule.get(i).get(0).start, i, 0});
        }

        int prev = heap.peek()[0];
        List<Interval> results = new ArrayList<>();
        while (!heap.isEmpty()) {

            int[] tuple = heap.poll();

            int employeeIndex = tuple[1];
            int intervalIndex = tuple[2];

            Interval interval = schedule.get(employeeIndex).get(intervalIndex);

            if (interval.start > prev) {
                results.add(new Interval(prev, interval.start));
            }

            prev = Math.max(interval.end, prev);

            if(intervalIndex+1<schedule.get(employeeIndex).size()){
                Interval interval1=schedule.get(employeeIndex).get(intervalIndex+1);
                heap.offer(new int[]{interval1.start,employeeIndex,intervalIndex+1});
            }


        }

        return results;
    }

    //Employee Free Time  alternate, simple mlog(n) vs nlog(n)
    public static List<Interval> employeeFreeTimeAlternate(List<List<Interval>> schedule) {

    //
        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> a.start - b.start);

// Add all intervals from all employees to the heap
        for(List<Interval> employeeSchedule :schedule) {
                for (Interval interval : employeeSchedule) {
                    heap.offer(interval);
                }
            }

            // Traverse and merge
        List<Interval> result = new ArrayList<>();
        Interval prev = heap.poll();  // Get the first interval

        while(!heap.isEmpty())

            {
                Interval current = heap.poll();

                if (prev.end < current.start) {
                    // Gap found
                    result.add(new Interval(prev.end, current.start));
                    prev = current;  // Move on to next disjoint interval
                } else {
                    // Overlapping intervals; merge
                    prev.end = Math.max(prev.end, current.end);
                }
            }

        return result;
}
    //Interval List Intersections

    public static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {
        // Replace this placeholder return statement with your code
        List<int[]> result=new ArrayList<>();
        int i=0,j=0;
        while(i<intervalLista.length && j<intervalListb.length){

            int latestStart=Math.max(intervalLista[i][0],intervalListb[j][0]);
            int earliestEnd=Math.min(intervalLista[i][1],intervalListb[j][1]);

            if(latestStart<=earliestEnd){
                result.add(new int[]{latestStart,earliestEnd});
            }

            if(intervalLista[i][1]<intervalListb[j][1]){
                i++;
            }else{
                j++;
            }



        }

        return result.toArray(new int[result.size()][]);
    }

    // new interval

    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {

        // Replace this placeholder return statement with your code
        List<int[]> results=new ArrayList<>();
        int i=0;

        // add less then new interval
        while(i<existingIntervals.length && existingIntervals[i][0]<=newInterval[0]){
            results.add(existingIntervals[i]);
            i++;
        }

        if(results.size()>0 && results.get(results.size()-1)[1]>=newInterval[0]){
            results.get(results.size()-1)[1]=Math.max(results.get(results.size()-1)[1],newInterval[1]);
        }else{
            results.add(newInterval);
        }

        while(i<existingIntervals.length){
            if(results.get(results.size()-1)[1]>existingIntervals[i][0]){
                results.get(results.size()-1)[1]=Math.max(existingIntervals[i][1],results.get(results.size()-1)[1]);
            }else{
                results.add(existingIntervals[i]);
            }
            i++;
        }


        return results.toArray(new int[results.size()][]);
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
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
