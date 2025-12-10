package ravi.algo.concepts;

import java.util.ArrayList;
import java.util.*;
import java.util.LinkedList;
import java.util.Stack;

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
            System.out.println("\t number of nodes 'nva' = " + n[i]);
            System.out.println("\t starting node 'k' = " + k[i] + "\n");
            System.out.println("\t Minimum amount of time required = " + networkDelayTime(times[i], n[i], k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // Paths in Maze That Lead to Same Room
        int[] nList = {5, 4, 5, 5, 4};
        int[][][] corridorsList = {
                {{1, 2}, {5, 2}, {4, 1}, {2, 4}, {3, 1}, {3, 4}},
                {{1, 2}, {3, 4}},
                {{1, 2}, {5, 2}, {4, 1}, {3, 1}, {3, 4}},
                {{1, 2}, {5, 2}, {4, 1}, {2, 4}, {3, 1}, {3, 4}, {1, 5}},
                {{1, 2}, {2, 3}, {3, 4}}
        };

        for (int i = 0; i < nList.length; i++) {
            System.out.println((i + 1) + ".\t nva: " + nList[i]);
            System.out.println("\t corridors: " + Arrays.deepToString(corridorsList[i]));
            System.out.println("\t cycles: " + numberOfPaths(nList[i], corridorsList[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //
        int[][][] data = {
                {{2, 3}, {1, 3}, {1, 2}},
                {{2, 4}, {1, 3}, {2, 4}, {1, 3}},
                {{2, 5}, {1, 3}, {2, 4}, {3, 5}, {1, 4}},
                {{2}, {1}},
                {{2, 6}, {1, 3}, {2, 4}, {3, 5}, {4, 6}, {1, 5}},
                {{}}
        };

        for (int i = 0; i < data.length; i++) {
            Node node1 = GraphUtility.createGraph(data[i]);
            System.out.println((i + 1) + ".\t Original Graph: " + GraphUtility.create2DList(node1) + "\n");
            GraphUtility.printGraph(node1);
            System.out.println();
            Node clonedRoot = clone(node1);
            System.out.println("\t Cloned Graph: " + GraphUtility.create2DList(clonedRoot) + "\n");
            GraphUtility.printGraph(node1);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

// Graph Valid Tree

        int[] nva = {3, 4, 5, 5, 6};
        int[][][] edges = {
                {{0, 1}, {0, 2}, {1, 2}},
                {{0, 1}, {0, 2}, {0, 3}},
                {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {3, 4}},
                {{0, 1}, {0, 2}, {0, 3}, {3, 4}},
                {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {0, 5}}
        };

        for (int i = 0; i < nva.length; i++) {
            System.out.println((i + 1) + ". nva = " + nva[i]);
            System.out.println("   Edges = " + Arrays.deepToString(edges[i]));
            System.out.println("   Is the given graph a valid tree: " + validTree(nva[i], edges[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


    }


    // Graph Valid Tree

    public static boolean validTree(int n, int[][] edges) {

        // Replace this placeholder return statement with your code
       if(edges.length!=(n-1)){
           return false;
       }

       List<List<Integer>> adj=new ArrayList<>();
       for(int i=0;i<n;i++){
           adj.add(i,new ArrayList<>());
       }

       for(int[] edge:edges){
           int first=edge[0];
           int second=edge[1];
           adj.get(first).add(second);
           adj.get(second).add(first);
       }

       Set<Integer> visted=new HashSet<>();
       Stack<Integer> stack=new Stack<>();

       visted.add(0);
       stack.push(0);

       while(!stack.isEmpty()){
           int curr=stack.pop();
           List<Integer> kids=adj.get(curr);
           for(int kid:kids){
               if(!visted.contains(kid)){
                   visted.add(kid);
                   stack.push(kid);
               }
           }

       }

       return visted.size()==n;
    }

//Clone Graph

    public static Node clone(Node root) {
        Map<Node,Node> nodeMap=new HashMap<>();
        return dsfNode(root,nodeMap);
    }

    private static Node dsfNode(Node root, Map<Node, Node> nodeMap) {

        if(root==null){
            return null;
        }

        Node clonnedNode=new Node(root.data);
        nodeMap.put(root,clonnedNode);

        for(Node node:root.neighbors){
            Node x=nodeMap.get(node);
            if(x==null){
                clonnedNode.neighbors.add(dsfNode(node,nodeMap));
            }else{
               clonnedNode.neighbors.add(x);
            }

        }
        return clonnedNode;
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

// Paths in Maze That Lead to Same Room
    public static int numberOfPaths(int n, int[][] corridors) {

        Map<Integer,Set<Integer>> adj=new HashMap<>();
        int cycles = 0;

        for(int[] item:corridors ){

            adj.computeIfAbsent(item[0], x-> new HashSet<>()).add(item[1]);
            adj.computeIfAbsent(item[1], x-> new HashSet<>()).add(item[0]);
            cycles+=intersectionLength(adj.get(item[0]),adj.get(item[1]));
        }
        // Replace this placeholder return statement with your code
        return cycles;
    }

    private static int intersectionLength(Set<Integer> set1, Set<Integer> set2) {
        int count=0;
        for(Integer item:set1){
            if(set2.contains(item)){
                count++;
            }
        }
        return count;
    }

}
