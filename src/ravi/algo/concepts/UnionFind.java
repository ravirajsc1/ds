package ravi.algo.concepts;

import java.util.*;

public class UnionFind {

    int parent[];
    int rank[];
    int size[];
    int maxSize=1;

    public UnionFind(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
            size[i]=1;
        }
    }

    public int find(int x){

        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }


    public boolean unionByRank(int x,int y){
         int px=find(x);
         int py=find(y);

         if(px==py)
             return false;


         if(rank[px]>rank[py]){
             parent[py]=px;

         }else{
             parent[px]=py;
             if(rank[px]==rank[py]){
                 rank[py]++;
             }


         }

        return true;
    }

    public boolean unionBySize(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py)
            return false;


        if(size[px]>size[py]){
            parent[py]=px;
            size[px]+=size[py];
        }else{
            parent[px]=py;
            size[py]+=size[px];

        }
        maxSize=Math.max(maxSize,Math.max(size[px],size[py]));

        return true;
    }

    public int getMaxSize()
    {
        return this.maxSize;
    }


    public static void main(String[] args) {


        // Redundant Connection
        int[][][] edges = {
                {{1, 2}, {1, 3}, {2, 3}},
                {{1, 2}, {2, 3}, {1, 3}},
                {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}},
                {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {2, 4}},
                {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 4}, {2, 5}}
        };

        for (int i = 0; i < edges.length; i++) {
            System.out.println((i + 1) + ".\tEdges: " + Arrays.deepToString(edges[i]));
            System.out.println("\n\tThe redundant connection in the graph is: " + Arrays.toString(redundantConnection(edges[i])));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }


        //Number of Islands

        List<List<Character>> grid1 = Arrays.asList(
                Arrays.asList('1', '1', '1'),
                Arrays.asList('0', '1', '0'),
                Arrays.asList('1', '0', '0'),
                Arrays.asList('1', '0', '1')
        );

        List<List<Character>> grid2 = Arrays.asList(
                Arrays.asList('1', '1', '1', '1', '0'),
                Arrays.asList('1', '0', '0', '0', '1'),
                Arrays.asList('1', '0', '0', '1', '1'),
                Arrays.asList('0', '1', '0', '1', '0'),
                Arrays.asList('1', '1', '0', '1', '1')
        );

        List<List<Character>> grid3 = Arrays.asList(
                Arrays.asList('1', '1', '1', '1', '0'),
                Arrays.asList('1', '0', '0', '0', '1'),
                Arrays.asList('1', '1', '1', '1', '1'),
                Arrays.asList('0', '1', '0', '1', '0'),
                Arrays.asList('1', '1', '0', '1', '1')
        );

        List<List<Character>> grid4 = Arrays.asList(
                Arrays.asList('1', '0', '1', '0', '1'),
                Arrays.asList('0', '1', '0', '1', '0'),
                Arrays.asList('1', '0', '1', '0', '1'),
                Arrays.asList('0', '1', '0', '1', '0'),
                Arrays.asList('1', '0', '1', '0', '1')
        );

        List<List<Character>> grid5 = Arrays.asList(
                Arrays.asList('1', '0', '1'),
                Arrays.asList('0', '0', '0'),
                Arrays.asList('1', '0', '1')
        );

        List<List<List<Character>>> inputs = Arrays.asList(grid1, grid2, grid3, grid4, grid5);

        for (int i = 0; i < inputs.size(); i++) {
            System.out.println((i + 1) + ".\t Grid: ");
            printGrid(inputs.get(i));
    //        System.out.println("\n\t Output: " + numIslands(inputs.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Most Stones Removed with Same Row or Column
        int[][][] stones = {
                {{0, 0}, {0, 1}, {1, 2}, {2, 2}, {3, 3}},
                {{0, 0}, {2, 2}, {3, 3}},
                {{0, 1}, {2, 1}, {3, 0}},
                {{1, 0}, {2, 1}, {2, 3}, {3, 1}, {3, 3}},
                {{1, 2}, {2, 0}, {2, 2}, {3, 3}}
        };

        for (int i = 0; i < stones.length; i++) {
            System.out.println((i + 1) + ".\tMaximum stones which can be removed from " +
                    Arrays.deepToString(stones[i]) + " are: " + removeStones(stones[i]));
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }

        //Longest Consecutive Sequence

        int[][] inputNums = {
                {150, 14, 200, 1, 3, 2},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 3, 5, 7},
                {7, 6, 5, 4, 3, 2, 1},
                {7, 6, 5, 1}
        };

        for (int i = 0; i < inputNums.length; i++) {
            System.out.println((i + 1) + ".\tnums = " + Arrays.toString(inputNums[i]));
            System.out.println("\tThe length of the longest consecutive sequence is: " + longestConsecutiveSequence(inputNums[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Last Day Where You Can Still Cross

        // Regions Cut by Slashes
        String[][] inputs = {
                {
                        "/\\",
                        "\\/"
                },
                {
                        " /",
                        "  "
                },
                {
                        " /",
                        "/ "
                },
                {
                        " /\\",
                        "\\/ ",
                        " \\ "
                },
                {
                        " \\/",
                        " /\\",
                        "\\/ "
                }
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
      //      System.out.println(".\tInput list of strings: " + Print.printGrid(inputs[i]));
            System.out.println("\tOutput: " + regionsBySlashes(inputs[i]));
       //     System.out.println(Print.repeat("-", 100));
        }

        // Accounts Merge
        List<List<List<String>>> allAccounts = new ArrayList<>();
        allAccounts.add(Arrays.asList(
                Arrays.asList("Emma", "emma@mail.com", "emma_work@mail.com"),
                Arrays.asList("Bob", "bob_home@mail.com", "bob123@mail.com"),
                Arrays.asList("Emma", "emma_art@mail.com", "emma_work@mail.com"),
                Arrays.asList("Bob", "bob321@mail.com")
        ));
        allAccounts.add(Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
        ));
        allAccounts.add(Arrays.asList(
                Arrays.asList("Sarah", "sarah@mail.com", "sh@mail.com"),
                Arrays.asList("Sarah", "sarah1@mail.com", "sarahh@mail.com"),
                Arrays.asList("Sarah", "sh3@mail.com")
        ));
        allAccounts.add(Arrays.asList(
                Arrays.asList("Alice", "alice@mail.com"),
                Arrays.asList("Alice", "alice_alice@mail.com", "alice@mail.com"),
                Arrays.asList("Alice", "alice@mail.com", "alice123@mail.com", "aalicee@mail.com")

        ));
        allAccounts.add(Arrays.asList(
                Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"),
                Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"),
                Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"),
                Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"),
                Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co" )
        ));

        for (int i = 0; i < allAccounts.size(); ++i) {
            System.out.println(i + 1 + ". \tAccounts:\n\t[");
            print2DArray(allAccounts.get(i));
            System.out.println("\t]");

            List<List<String>> merged = accountsMerge(allAccounts.get(i));

            if (merged.isEmpty()) {
                System.out.println("Error!\nAccounts sharing some email(s) should have the same names.\n");
                return;
            }

            System.out.println("\n\tMerged accounts:\n\t[");
            print2DArray(merged);
            System.out.println("\t]\n");
            System.out.println("-" + new String(new char[100]).replace('\0', '-') + "\n");
        }
    }

    // Helper method to print a 2D array
    private static void print2DArray(List<List<String>> array) {
        for (List<String> row : array) {
            System.out.println("\t\t" + row);
        }
    }

    // Accounts Merge

    public static List<List<String>> accountsMerge(List<List<String>> accounts){

        // Replace this placeholder return statement with your code
        return new ArrayList<>();
    }

// Regions Cut by Slashes

    public static int regionsBySlashes(String[] grid) {
        int N=grid.length;
        UnionFind uf=new UnionFind(N*N*4);

        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                char ch=grid[r].charAt(c);
                int root=4*(r*N+c);
                if(ch=='/' || ch==' ' ){
                    uf.unionByRank(root+0,root+1);
                    uf.unionByRank(root+2,root+3 );
                }

                if(ch=='\\' || ch==' '){
                    uf.unionByRank(root+0,root+2);
                    uf.unionByRank(root+1,root+3 );
                }

                if(r+1<N)
                    uf.unionByRank(root+3, (root+4*N)+0);

              //  if(r-1>=0)
                //    uf.unionByRank(root+0, (root-4*N)+3);

                if(c+1<N)
                    uf.unionByRank(root+2, (root+4+1));

                //if(c-1>=0)
                  //  uf.unionByRank(root+1, (root-4+2));

            }

        }

        int count=0;
        for(int i=0;i<4*N*N;i++){
            if(uf.find(i)==i){
                count++;
            }

        }


        return count;
    }

    // Last Day Where You Can Still Cross

    public static int lastDayToCross(int rows, int cols, int[][] waterCells) {

        // replace this placeholder return statement with your code
        return -1;
    }

    //Longest Consecutive Sequence
    public static int longestConsecutiveSequence(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        int index=0;
        for(int num:nums){
            map.put(num,index++);
        }
        int n=nums.length;
        UnionFind uf=new UnionFind(n);

        for(int i=0;i<nums.length;i++){
            int num=nums[i];

            if(map.containsKey(num+1)){
                uf.unionByRank(map.get(num),map.get(num+1));
            }
        }
        return uf.getMaxSize();
    }

    // Most Stones Removed with Same Row or Column
    public static int removeStones(int[][] stones) {
        int offset=10000;
        UnionFindList uf=new UnionFindList();
        for(int[] stone:stones){
            int x=stone[0];
            int y=stone[1];
            uf.union(x,y+offset);
        }

        Set<Integer> groups=new HashSet<>();
        Map<Integer,Integer> parents=uf.getParents();

        for(Map.Entry<Integer,Integer> entry:parents.entrySet()) {
            groups.add(uf.find(entry.getKey()));
        }
            // Replace this placeholder return statement with your code
        return stones.length-groups.size();
    }

    public static void printGrid(List<List<Character>> grid) {
        for (int i = 0; i < grid.size(); i++) {
            System.out.print("\t\t[");
            for (int j = 0; j < grid.get(i).size() - 1; j++) {
                System.out.print("'" + grid.get(i).get(j) + "', ");
            }
            System.out.println("'" + grid.get(i).get(grid.get(i).size() - 1) + "']");
        }
    }

    //Number of Islands

    public static int numIslands(char[][] grid) {

        int rows=grid.length;
        int cols=grid[0].length;

        int noIsland=0;
        UnionFind uf=new UnionFind(rows*cols);

        // Initialize every cell
        for(int r=0;r<rows;r++){
           for(int c=0;c<cols;c++){
               int i=r*cols+c;
               uf.parent[i]=i;
               if(grid[r][c]==1)
                   noIsland++;
           }
        }



        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++) {
                if(grid[r][c]=='0')
                    continue;

                if(c+1<cols && grid[r][c+1]=='1' ){
                    if(uf.unionByRank(r*cols+c, r*cols+(c+1))){
                        noIsland--;
                    }

                }

                if(r+1<rows && grid[r+1][c]=='1'){
                    if(uf.unionByRank(r*cols+c,(r+1)*cols+c)){
                        noIsland--;
                    }

                }
            }
        }



                return noIsland;
    }



    // Redundant Connection
    public static int[] redundantConnection(int[][] edges) {

        UnionFind uf=new UnionFind(edges.length);
        for(int[] edge:edges ){
            int l=edge[0];
            int r=edge[1];

            if(!uf.unionBySize(l,r)){
                return edge;
            }

        }
        return new int[]{};
    }


}
