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

        // Path with Maximum Probability
        int[][][] edgesMax = {
                {{0, 1}, {1, 2}, {0, 2}},
                {{0, 1}, {1, 2}, {0, 2}},
                {{0, 1}, {1, 2}, {2, 3}, {0, 3}},
                {{0, 1}, {1, 2}, {2, 3}, {3, 4}},
                {{0, 1}},
                {{0, 1}, {1, 2}}
        };

        double[][] succProb = {
                {0.5, 0.5, 0.2},
                {0.5, 0.5, 0.3},
                {0.5, 0.6, 0.7, 0.2},
                {0.8, 0.6, 0.7, 0.9},
                {0.1},
                {0.5, 0.0}
        };

        int[] nmax = {3, 3, 4, 5, 2, 3};
        int[] start = {0, 0, 0, 0, 0, 0};
        int[] end = {2, 2, 3, 4, 1, 2};

        for (int i = 0; i < n.length; i++) {
            System.out.println((i + 1) + ".\tNumber of nodes: " + n[i]);
            System.out.println("\tEdges: " + Arrays.deepToString(edgesMax[i]));
            System.out.println("\tSuccess Probabilities: " + Arrays.toString(succProb[i]));
            System.out.println("\tStart: " + start[i] + ", End: " + end[i]);

            double result = maxProbability(n[i], edgesMax[i], succProb[i], start[i], end[i]);
            System.out.println("\n\tOutput: " + result);
            System.out.println("-" + new String(new char[100]).replace('\0', '-') + "\n");
        }


  // Tree Diameter

        int[][][] testCases = {
                {{0, 1}},
                {{0, 1}, {0, 2}},
                {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {4, 5}, {4, 6}},
                {{0, 1}, {1, 2}, {2, 3}, {3, 4}},
                {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {3, 5}}
        };


        int i = 0;
        for (int[][] edgesDia : testCases) {
            System.out.print(" " + (i + 1) + ".\tEdges: {");
            for (int[] edge : edgesDia) {
                System.out.print("{" + edge[0] + ", " + edge[1] + "}");
            }
            System.out.println("}");
            System.out.println("\tTree Diameter: " + treeDiameter(edgesDia));
            System.out.println("-" + new String(new char[100]).replace('\0', '-') + "\n");
            i++;
        }

        // Reorder Routes to Make All Paths Lead to the City Zero
        // Define test cases without using a struct-like object.
        int[][][] testCasesConnections = {
                { {0, 1}, {2, 0} },
                { {0, 1}, {1, 2}, {2, 3} },
                { {0, 1}, {2, 0}, {3, 2}, {4, 3}, {4, 5} },
                { {1, 0}, {2, 0}, {3, 1}, {4, 1}, {5, 3}, {6, 4} },
                { {0, 1}, {1, 2}, {3, 2}, {4, 3}, {5, 3}, {6, 5} }
        };
        int[] ns = { 3, 4, 6, 7, 7 };


        for (int ize = 0; ize < testCasesConnections.length; ize++) {
            int nze = ns[ize];
            int[][] connections = testCasesConnections[ize];
            System.out.println((ize + 1) + ".\tn: " + nze + ", connections: " + java.util.Arrays.deepToString(connections));
            int result = minReorderB(nze, connections);
            System.out.println("\tResult: " + result);
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

        // Minimum Cost to Make at Least One Valid Path in a Grid

        int[][][] gridArr = {
                {{1, 1, 3}, {2, 2, 3}, {1, 1, 4}},
                {{1, 1, 3, 1}, {3, 1, 2, 2}, {1, 4, 1, 1}, {4, 1, 1, 3}},
                {{1, 1}, {1, 1}},
                {{4}},
                {{4, 3, 4, 3}, {3, 4, 3, 4}}
        };

        for (int imin = 0; imin < gridArr.length; ++imin) {
            System.out.print((imin + 1) + ".\tgrid: [");
            for (int j = 0; j < gridArr[imin].length; ++j) {
                System.out.print("[");
                for (int kmin = 0; kmin < gridArr[imin][j].length; ++kmin) {
                    System.out.print(gridArr[imin][j][kmin]);
                    if (kmin < gridArr[imin][j].length - 1)
                        System.out.print(", ");
                }
                System.out.print("]");
                if (j < gridArr[imin].length - 1)
                    System.out.print(", ");
            }
            System.out.println("]\n");
            System.out.println("\tMinimum cost: " + minCost(gridArr[imin]));
            System.out.println("-".repeat(100));
        }

        // Longest Cycle in a Graph
        int[][] testCasesLong = {
                {3, 3, 4, 2, 3},
                {2, -1, 3, 1},
                {1, 2, 3, 4, 0},
                {2, -1, 3, 4, 5, 3},
                {1, 2, 3, 4, 5, 6, 3},
                {
                        1,  // 0 → 1
                        2,  // 1 → 2
                        3,  // 2 → 3
                        0,  // 3 → 0   (cycle length = 4)

                        6,  // 4 → 6
                        -1, // 5
                        4   // 6 → 4   (cycle length = 2)
                }
        };


        for (int ilong = 0; ilong < testCasesLong.length; ilong++) {
            int[] edgeslong = testCasesLong[ilong];
            System.out.print((ilong + 1) + ".\tedges: [");
            for (int j = 0; j < edgeslong.length; j++) {
                System.out.print(edgeslong[j]);
                if (j != edgeslong.length - 1) System.out.print(", ");
            }
            System.out.println("]");

            int output = longestCycle(edgeslong);
            System.out.println("\tOutput: " + output);
            System.out.println(new String(new char[100]).replace('\0', '-'));

        }

// Shortest Cycle in a Graph
        int[][][] testCasesShortest = {
                {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
                {{0, 1}},
                {{0, 1}, {2, 3}},
                {{0, 1}, {1, 2}, {2, 3}, {3, 0}, {1, 3}, {3, 4}, {4, 5}},
                {{0, 1}, {1, 2}, {2, 0}, {3, 4}, {4, 5}, {5, 3}, {2, 3}, {3, 6}, {6, 0}}
        };

        int[] nodeCounts = {4, 2, 5, 6, 7};

        for (int itest = 0; itest < testCasesShortest.length; itest++) {
            int nshort = nodeCounts[itest];
            int[][] edgesShort = testCasesShortest[itest];
            System.out.println((itest + 1) + ".\tInput: nshort = " + nshort + ", edgesShort = " + Arrays.deepToString(edgesShort));
            Graph sol = new Graph();
            System.out.println("\tShortest Cycle Length = " + sol.findShortestCycle(nshort, edgesShort));
            System.out.println("-" + new String(new char[100]).replace('\0', '-') + "\n");
        }

    }


// Shortest Cycle in a Graph


    public int findShortestCycle(int n, int[][] edges) {

      Map<Integer,List<Integer>> adj=new HashMap<>();

      for(int[] edge:edges){
          int u=edge[0];
          int v=edge[1];
          adj.computeIfAbsent(u,x->new ArrayList<>()).add(v);
          adj.computeIfAbsent(v,x->new ArrayList<>()).add(u);
      }

      int[] visited=new int[n];
      Arrays.fill(visited,-1);
      int minCycle=Integer.MAX_VALUE;

      for(int i=0;i<n;i++){
         if(visited[i]==-1) {
             int cycle = bsfFindShortedCycle(adj, i, visited);
             minCycle = Math.min(minCycle, cycle);
         }
      }

      return (minCycle!=Integer.MAX_VALUE)?minCycle:-1;
    }

    private int bsfFindShortedCycle(Map<Integer, List<Integer>> adj, int start, int[] visited) {

        int minCycle=Integer.MAX_VALUE;

        int[] dist=new int[visited.length];
        Arrays.fill(dist,-1);

        Queue<int[]> dq=new LinkedList<>();
        dq.offer(new int[]{start,-1});


        visited[start]=0;
        dist[start]=0;

        while(!dq.isEmpty()){
            int[] current=dq.poll();
            int node=current[0];
            int parent=current[1];
            int currentDist=dist[node];

            for(int neibour :adj.getOrDefault(node,new ArrayList<>())){
                if(neibour==parent)
                    continue;;

                if(dist[neibour]!=-1){  // cycle dected
                    int neibourDist=dist[node]+dist[neibour]+1;
                    minCycle=Math.min(minCycle,neibourDist);
                }else{
                    dist[neibour]=currentDist+1;
                    dq.offer(new int[]{neibour,node});

                }
             }
        }
        return minCycle;
    }
// Longest Cycle in a Graph

    public static int longestCycle(int[] edges) {
        int n = edges.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        int maxCycle = -1;

        for (int i = 0; i < n; i++) {
            if(visited[i]!=-1)
                continue;

            int time = 0;
            Map<Integer, Integer> nodeVisted = new HashMap<>();
            int current = i;

            while (current != -1 && visited[current]==-1) {
                visited[current] = time;
                nodeVisted.put(current, time);
                current = edges[current];
                time++;
                if (nodeVisted.containsKey(current)) {
                    int timeTaken = time - nodeVisted.get(current);
                    maxCycle = Math.max(timeTaken, maxCycle);
                    break;

                }
            }

        }
        return maxCycle;
    }
    // Minimum Cost to Make at Least One Valid Path in a Grid

    public static int minCost(int[][] grid) {

        int n=grid.length, m=grid[0].length;

        int[][] costgrid=new int[n][m];
        for(int[] row:costgrid){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        costgrid[0][0]=0;
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        Deque<int[]> deque=new ArrayDeque<>();
        deque.offerFirst(new int[]{0,0});

        while(!deque.isEmpty()){
            int[] current=deque.pollFirst();
            int row=current[0],col=current[1];

            for(int d=0;d<4;d++){
                int newrow=row+dir[d][0];
                int newcol=col+dir[d][1];
                if(isValidAndImprovable(costgrid,newrow,newcol)){

                    int cost= grid[row][col]!=(d+1)?1:0;
                    if(costgrid[row][col] +cost < costgrid[newrow][newcol] ) {
                        costgrid[newrow][newcol]=costgrid[row][col] +cost;
                        if(cost==1){
                            deque.offerLast(new int[]{newrow,newcol});
                        }else{
                            deque.offerFirst(new int[]{newrow,newcol});
                        }
                    }
                }

            }

        }

        return costgrid[n-1][m-1];
    }

    private static boolean isValidAndImprovable(int[][] costgrid, int newrow, int newcol) {
        return newcol>=0 && newrow>=0 && newrow<costgrid.length && newcol<costgrid[0].length && costgrid[newrow][newcol]!=0;
    }


    // Reorder Routes to Make All Paths Lead to the City Zero


    public static int minReorderB(int n, int[][] connections)
    {

        Map<Integer,List<int[]>> adj=new HashMap<>();

        for(int[] connection:connections){
            int source=connection[0];
            int destination=connection[1];
            adj.computeIfAbsent(source,x->new ArrayList<>()).add(new int[]{destination,1});
            adj.computeIfAbsent(destination,x->new ArrayList<>()).add(new int[]{source,0});
        }

        boolean[] visted=new boolean[n];
        return dfsMinRorder(0,adj,visted);

    }

    private static int dfsMinRorder(int city, Map<Integer, List<int[]>> adj, boolean[] visted) {
        visted[city] = true;
        int reversals = 0;

        for(int[] cities:adj.getOrDefault(city,new ArrayList<>())){
            int nextCity=cities[0];
            int reversal=cities[1];
            if(!visted[nextCity]){
                reversals+=reversal;
                reversals+=dfsMinRorder(nextCity,adj,visted);
            }
        }
        return reversals;
    }


    public static int minReorder(int n, int[][] connections)
    {

        Map<Integer,Set<Integer>> adj=new HashMap<>();

        for(int[] connection:connections){
            int source=connection[0];
            int destination=connection[1];
            adj.computeIfAbsent(source,x->new HashSet<>()).add(destination);
        }

        Set<Integer> corrected=new HashSet<>();
        corrected.add(0);
        int count=0;
        for(int i=0;i<n;i++){
            if(adj.get(i)==null){
                continue;
            }
            if(adj.get(i).stream().anyMatch(corrected::contains)){
                count++;
            }
            corrected.add(i);
        }
        // Replace this placeholder return statement with your code
        return count;
    }


    // Tree Diameter

    public static int treeDiameter(int[][] edges) {
        // Replace this placeholder return statement with your code
        Map<Integer,Set<Integer>> adj=new HashMap<>();
        if (edges.length == 0) return 0;
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.computeIfAbsent(u,x->new HashSet<>()).add(v);
            adj.computeIfAbsent(v,x->new HashSet<>()).add(u);
        }

        boolean[] visited=new boolean[edges.length+1];
        int[] diameter=new int[1];
        dfsTreeDiameter(adj,0,visited,diameter);
        return diameter[0];
    }

    private static int dfsTreeDiameter(Map<Integer, Set<Integer>> adj, int  node, boolean[] visited, int[] diameter) {
        int top1=0;
        int top2=0;
        visited[node]=true;
        for(int next:adj.getOrDefault(node,new HashSet<>())){
            if(visited[next]==false){
                int dist=1+dfsTreeDiameter(adj,next,visited,diameter);
                if(dist>top1){
                    top2=top1;
                    top1=dist;

                }else if(dist>top2){
                    top2=dist;
                }
            }
        }

        diameter[0]=Math.max(diameter[0],top1+top2);
        return top1;

    }


    // Path with Maximum Probability
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer,List<double[]>> adj=new HashMap<>();

        for(int i=0;i<edges.length;i++){
            int src=edges[i][0];
            int dest=edges[i][1];
            double prob=succProb[i];
            adj.computeIfAbsent(src,x->new ArrayList<>()).add(new double[]{dest,prob});
            adj.computeIfAbsent(dest,x->new ArrayList<>()).add(new double[]{src,prob});
       }

        PriorityQueue<double[]> queue =
                new PriorityQueue<>(Comparator.<double[]>comparingDouble(a -> a[0]).reversed());

        queue.offer(new double[]{1.0,start});
     //   boolean[] visited = new boolean[n];
        double[] maxProb=new double[n];
        maxProb[start]=1.0;

        while(!queue.isEmpty()){
            double[] current=queue.poll();
            double probability=current[0];
            int dest=(int)current[1];

            if(dest==end)
                return probability;

            List<double[]> nextpaths=adj.get((int)dest);
            if (nextpaths == null) continue;

            for(double[] nextpath:nextpaths ){
                double nextProbability=nextpath[1];
                int nextDest=(int)nextpath[0];
                double newProb=probability*nextProbability;
                if(newProb>maxProb[nextDest]){
                    maxProb[nextDest]=newProb;
                    queue.offer(new double[]{newProb,nextDest});
                }

            }


        }
        // Replace this placeholder return statement with your code
        return 0.0;
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
