package ravi.algo.concepts;

import java.util.ArrayList;
import java.util.*;

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

         Map<Integer, List<int[]>> adlist=new HashMap<>();
         for(int[] time:times){
             int from=time[0];
             int to=time[1];
             int cost=time[2];
             adlist.computeIfAbsent(from,key->new ArrayList<>()).add(new int[]{to,cost});
         }

         PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
         pq.offer(new int[]{0,k});

         Set<Integer> visted=new HashSet<>();
         int maxDelay=0;

         while(!pq.isEmpty()){
             int[] top=pq.poll();
             int node=top[1];
             int time=top[0];

             if(visted.contains(node))
                 continue;

             visted.add(node);

             maxDelay=Math.max(maxDelay,time);

             List<int[]> niebours=adlist.getOrDefault(node,new ArrayList<>());

             for(int[] nieb:niebours){
                 int toNieb=nieb[0];
                 int toCost=nieb[1];
                 if(!visted.contains(toNieb)) {
                     int totalCpst = toCost + time;
                     pq.offer(new int[]{totalCpst,toNieb});
                 }
             }
         }

        if(visted.size()==n){
            return maxDelay;
        }


        // Replace this placeholder return statement with your code
        return -1;
    }
}
