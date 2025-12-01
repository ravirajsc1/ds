package ravi.algo.concepts;

import java.util.Arrays;

public class Graph {

    public static void main(String[] args) {

        // Network Delay Time
        int[][][] times = {
                { {2, 1, 1}, {3, 2, 1}, {3, 4, 2} },
                { {2, 1, 1}, {1, 3, 1}, {3, 4, 2}, {5, 4, 2} },
                { {1, 2, 1}, {2, 3, 1}, {3, 4, 1} },
                { {1, 2, 1}, {2, 3, 1}, {3, 5, 2} },
                { {1, 2, 2} }
        };

        int[] n = {4, 5, 4, 5, 2};
        int[] k = {3, 1, 1, 1, 2};

        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + ".\t times = " + Arrays.deepToString(times[i]));
            System.out.println("\t number of nodes 'n' = " + n[i]);
            System.out.println("\t starting node 'k' = " + k[i] + "\n");
            System.out.println("\t Minimum amount of time required = " + networkDelayTime(times[i], n[i], k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }


    //Network Delay Time
    public static int networkDelayTime(int[][] times, int n, int k) {

        // Replace this placeholder return statement with your code
        return -1;
    }
}
