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

        // bus route

        int[][][] routes = {
                {{2, 5, 7}, {4, 6, 7}},
                {{1, 12}, {4, 5, 9}, {9, 19}, {10, 12, 13}},
                {{1, 12}, {10, 5, 9}, {4, 19}, {10, 12, 13}},
                {{1, 9, 7, 8}, {3, 6, 7}, {4, 9}, {8, 2, 3, 7}, {2, 4, 5}},
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        };
        int[] src = {2, 9, 1, 1, 4};
        int[] dest = {6, 12, 9, 5, 6};

        for (int i = 0; i < routes.length; i++) {
            System.out.print((i + 1) + ".\tBus Routes: ");
            System.out.print(Arrays.deepToString(routes[i]));
            System.out.println();
            System.out.println("\tSource: " + src[i]);
            System.out.println("\tDestination: " + dest[i]);
            System.out.println("\n\tMinimum Buses Required: " + minimumBuses(routes[i], src[i], dest[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // Reconstruct Itinerary
        List<List<List<String>>> ticketsList = Arrays.asList(
                Arrays.asList(Arrays.asList("JFK", "REP")),
                Arrays.asList(Arrays.asList("JFK", "DOC"), Arrays.asList("DOC", "ABT"), Arrays.asList("ABT", "JFK")),
                Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("LAK", "SFO"), Arrays.asList("SFO", "ATL"), Arrays.asList("SFO", "LAK")),
                Arrays.asList(Arrays.asList("JFK", "YUR"), Arrays.asList("YUR", "JFK"), Arrays.asList("JFK", "ATL"), Arrays.asList("ATL", "JFK")),
                Arrays.asList(Arrays.asList("JFK", "ABC"), Arrays.asList("JFK", "ABM"), Arrays.asList("JFK", "ABX"), Arrays.asList("ABX", "WXY"), Arrays.asList("WXY", "OPT"))
        );



        for (int i = 0; i < ticketsList.size(); i++) {
            List<List<String>> tickets = ticketsList.get(i);
            System.out.print((i + 1) + ".\tTickets: [");
            for (int j = 0; j < tickets.size(); j++) {
                List<String> ticket = tickets.get(j);
                System.out.print("['" + ticket.get(0) + "', '" + ticket.get(1) + "']");
                if (j < tickets.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");

            System.out.print("\tFlight Itinerary: [");
            List<String> itinerary = findItinerary(tickets);
            for (int k1 = 0; k1 < itinerary.size(); k1++) {
                System.out.print("'" + itinerary.get(k1) + "'");
                if (k1 < itinerary.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Find the Town Judge

        int[] nValues = {2, 3, 3, 4, 5};
        int[][][] trustArrays = {
                {{1, 2}},
                {{1, 3}, {2, 3}},
                {{1, 3}, {2, 3}, {3, 1}},
                {{1, 3}, {2, 3}, {3, 4}},
                {{1, 4}, {2, 4}, {3, 4}}
        };

        for (int i = 0; i < nValues.length; i++) {
            int nt = nValues[i];
            int[][] trust = trustArrays[i];
            int result = findJudge(nt, trust);
            System.out.println((i + 1) + ".\tInput: n = " + nt + ", trust = " + Arrays.deepToString(trust));
            System.out.println("\tTown Judge: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Find Center of Star Graph

        int[][][] edgesList = {
                {{1, 2}, {2, 3}, {4, 2}},
                {{3, 5}, {3, 2}, {1, 3}, {3, 4}},
                {{4, 1}, {2, 4}, {4, 3}},
                {{6, 4}, {6, 3}, {2, 6}, {6, 1}, {5, 6}},
                {{1, 2}, {3, 1}, {1, 4}, {5, 1}, {1, 6}, {7, 1}}
        };

        for (int i = 0; i < edgesList.length; i++) {
            int[][] edgesStar = edgesList[i];
            System.out.print((i + 1) + ".\tInput = ");
            for (int[] edge : edgesStar) {
                System.out.print(Arrays.toString(edge) + " ");
            }
            System.out.println();
            System.out.println("\n\tCenter of Star Graph = " + findCenter(edgesStar));
            System.out.println("-" + new String(new char[100]).replace('\0', '-') + "\n");
        }

        // Lucky Numbers in a Matrix
    }


// Lucky Numbers in a Matrix
    public static List<Integer> luckyNumbers(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int rLargestMin=Integer.MIN_VALUE;

        for(int i=0;i<m;i++){
            int min= Arrays.stream(matrix[i]).min().getAsInt();
            rLargestMin=Math.max(rLargestMin,min);

        }

        int cSmallestMax=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int max=Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                max=Math.max(max,matrix[j][i]);
            }
            cSmallestMax=Math.min(cSmallestMax,max);


        }

        if(cSmallestMax==rLargestMin){
            return Collections.singletonList(rLargestMin);
        }
        // Replace the following placeholder return statement with your code
        return new ArrayList<>();
    }


// Find Center of Star Graph

    public static int findCenterBetter(int[][] edges) {

        int[] first=edges[0];
        int[] second=edges[1];

        if(Arrays.stream(second).anyMatch(x->x==first[0])){
            return first[0];
        }else{
            return first[1];
        }

    }

    public static int findCenter(int[][] edges) {

        int n=edges.length+1;
        int[] degree=new int[n+1];

        for(int[] edge:edges){
            int first=edge[0];
            int second=edge[1];
            degree[first]++;
            degree[second]++;
        }

        for(int i=1;i<=n;i++){
           if(degree[i]==n-1)
               return i;
        }


        // Replace this placeholder return statement with your code
        return -1;
    }


    // Find the Town Judge
    public static int findJudge(int n, int[][] trust) {
        Map<Integer,Set<Integer>> map=new HashMap<>();
        if(trust.length<n-1)
            return -1;

        int[] inDegree=new int[n+1];
        int[] outDegree=new int[n+1];

        for(int[] pair:trust){
            int a=pair[0];
            int b=pair[1];
            inDegree[b]++;
            outDegree[a]++;
        }


        for(int i=1;i<=n;i++){
            if(inDegree[i]==n-1 && outDegree[i]==0){
                return i;
            }

        }
        return -1;

    }




    // Reconstruct Itinerary


    public static List<String> findItinerary(List<List<String>> tickets) {

        Map<String,List<String>> adj=new HashMap<>();
        List<String> result=new ArrayList<>();
        for(List<String> strs:tickets){
            String source=strs.get(0);
            String destinaton=strs.get(1);
            adj.computeIfAbsent(source,x->new ArrayList<>()).add(destinaton);
        }

       for(List<String> destinations:adj.values()){
           destinations.sort(Collections.reverseOrder());
       }

        DFSFindItinerary("JFK",adj,result);

       Collections.reverse(result);

        return result;
    }

    private static void DFSFindItinerary(String destination, Map<String, List<String>> adj, List<String> result) {
        List<String> destinations=adj.get(destination);
        while(destinations!=null && !destinations.isEmpty()){
            String dest=destinations.remove(destinations.size()-1);
            DFSFindItinerary(dest,adj,result);
        }
        result.add(destination);
    }

    // bus route
    public static int minimumBuses(int[][] busRoutes, int src, int dest) {

        Map<Integer,List<Integer>> adj=new HashMap<>();

        for(int i=0;i<busRoutes.length;i++){
            for(int station:busRoutes[i]){
                adj.computeIfAbsent(station,s->new ArrayList<>()).add(i);
            }
        }

        Deque<int[]> queue=new ArrayDeque<>();
        queue.add(new int[]{src,0});

        Set<Integer> vistedBuses=new HashSet<>();

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int station=current[0];
            int busesTaken=current[1];

            if(dest==station){
                return busesTaken;
            }

            if(adj.containsKey(station)) {
                List<Integer> buses = adj.get(station);

                for (int bus:buses){
                    if(!vistedBuses.contains(bus)){
                        for(int stations:busRoutes[bus]){
                            queue.add(new int[]{stations,busesTaken+1});
                        }
                        vistedBuses.add(bus);
                    }

                }
            }

        }


        // Replace this placeholder return statement with your code
        return -1;
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
