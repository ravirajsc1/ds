package ravi.algo.concepts;
import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class TopologicalSort {

    public static void main(String[] str){

// Compilation Order
        ArrayList<ArrayList<ArrayList<Character>>> dependencies = new ArrayList<ArrayList<ArrayList<Character>>>() {
            {
                add(new ArrayList<ArrayList<Character>>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('B', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('C', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('D', 'C')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'D')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'B')));
                    }
                });
                add(new ArrayList<ArrayList<Character>>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('B', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('C', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('D', 'B')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'B')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'D')));
                        add(new ArrayList<Character>(Arrays.asList('E', 'C')));
                        add(new ArrayList<Character>(Arrays.asList('F', 'D')));
                        add(new ArrayList<Character>(Arrays.asList('F', 'E')));
                        add(new ArrayList<Character>(Arrays.asList('F', 'C')));
                    }
                });
                add(new ArrayList<ArrayList<Character>>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('A', 'B')));
                        add(new ArrayList<Character>(Arrays.asList('B', 'A')));
                    }
                });
                add(new ArrayList<ArrayList<Character>>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('B', 'C')));
                        add(new ArrayList<Character>(Arrays.asList('C', 'A')));
                        add(new ArrayList<Character>(Arrays.asList('A', 'F')));
                    }
                });
                add(new ArrayList<ArrayList<Character>>() {
                    {
                        add(new ArrayList<Character>(Arrays.asList('C', 'C')));
                    }
                });
            }
        };
        for(int i = 0; i < dependencies.size(); i++){
            System.out.println(i + 1 + ".\tdependencies: " + dependencies.get(i));
            System.out.println("\tCompilation Order: " + findCompilationOrder(dependencies.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        //Alien Dictionary
        List<List<String>> words = Arrays.asList(
                Arrays.asList("mzosr", "mqov", "xxsvq", "xazv", "xazau", "xaqu", "suvzu", "suvxq", "suam", "suax", "rom", "rwx", "rwv"),
                Arrays.asList("vanilla", "alpine", "algor", "port", "norm", "nylon", "ophellia", "hidden"),
                Arrays.asList("passengers", "to", "the", "unknown"),
                Arrays.asList("alpha", "bravo", "charlie", "delta"),
                Arrays.asList("jupyter", "ascending")
        );
        for (int i = 0; i < words.size(); i++) {
            System.out.println(i + 1 + ".\twords = " + words.get(i));
            alienOrder(words.get(i));
            System.out.println("\tDictionary = \"" + alienOrder(words.get(i)) + "\"");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Verifying an Alien Dictionary

        String[][] wordsVerify = {
                {"alpha", "bravo", "charlie", "delta"},
                {"apple", "app"},
                {"martian"},
                {"jupyter", "ascending"},
                {"passengers", "to", "the", "unknown"}
        };
        String[] order = {
                "abcdefghijklmnopqrstuvwxyz",
                "abcdefghijklmnopqrstuvwxyz",
                "mabcdefghijklnopqrstuvwxyz",
                "jabcdefghiklmnopqrstuvwxyz",
                "ptuhabcdefghijklmnoqrsvwxyz"
        };
        for (int i = 0; i < order.length; i++) {
            System.out.print(i + 1);
            System.out.print(".\tWords : " + Arrays.toString(wordsVerify[i]));
            System.out.print("\n\tOrder : " + order[i]);
            System.out.println("\n\tAlien Dictionary verified: " + verifyAlienDictionary(wordsVerify[i], order[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[]n = {4, 5, 2, 4, 7};
        int[][][]prerequisites = {
                {{1, 0}, {2, 0}, {3, 1}, {3, 2}},
                {{1, 0}, {2, 0}, {3, 1},{4, 3}},
                {{1, 0}}, {{1, 0}, {2, 0}, {3, 1}, {3, 2}},
                {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}}};
        for(int i=0; i<n.length; i++){
            System.out.print(i+1);
            System.out.println(".\tPrerequisites: "+Arrays.deepToString(prerequisites[i])+"\n\tTotal number of courses, n = "+n[i]);
            List<Integer> result = findOrder(n[i], prerequisites[i]);
            System.out.println("\tValid courses order: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Build a Matrix with Conditions
        int[] inputK = {3, 3, 2, 3, 4};

        List<int[][]> inputRowConditions = Arrays.asList(
                new int[][]{{1, 2}, {2, 3}},
                new int[][]{{1, 2}, {2, 3}, {3, 1}},
                new int[][]{{1, 2}},
                new int[][]{{1, 2}},
                new int[][]{{1, 2}, {2, 3}, {3, 4}}
        );

        List<int[][]> inputColConditions = Arrays.asList(
                new int[][]{{2, 1}, {3, 2}},
                new int[][]{{1, 2}},
                new int[][]{{2, 1}},
                new int[][]{{2, 1}},
                new int[][]{{1, 3}, {3, 4}, {2, 1}}
        );

        for (int i = 0; i < inputK.length; i++) {
            System.out.println((i + 1) + ". Input:");
            System.out.println("\t- k = " + inputK[i]);

            // Print Row Conditions
            System.out.print("\t- Row Conditions = {");
            int[][] rowConditions = inputRowConditions.get(i);
            for (int j = 0; j < rowConditions.length; j++) {
                System.out.print("{" + rowConditions[j][0] + ", " + rowConditions[j][1] + "}");
                if (j < rowConditions.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");

            // Print Column Conditions
            System.out.print("\t- Column Conditions = {");
            int[][] colConditions = inputColConditions.get(i);
            for (int j = 0; j < colConditions.length; j++) {
                System.out.print("{" + colConditions[j][0] + ", " + colConditions[j][1] + "}");
                if (j < colConditions.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");

            int[][] output = buildMatrix(inputK[i], inputRowConditions.get(i), inputColConditions.get(i));
            System.out.println("\n   Matrix:");
            if (output.length > 0) {
                for (int[] row : output) {
                    System.out.println("\t" + Arrays.toString(row));
                }
            } else {
                System.out.println("\t[]");
            }
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

        // Longest Path With Different Adjacent Characters
        List<Object[]> testCases = Arrays.asList(
                new Object[]{3, new int[][]{{1,3},{2,3}},             new int[]{3,2,5}},
                new Object[]{5, new int[][]{{1,5},{2,5},{3,5},{4,5}}, new int[]{1,2,3,4,5}},
                new Object[]{5, new int[][]{{1,2},{1,3},{3,4},{2,4},{4,5}}, new int[]{1,2,3,4,5}},
                new Object[]{4, new int[][]{},                       new int[]{5,5,5,5}},
                new Object[]{6, new int[][]{{1,2},{2,3},{3,4},{2,5},{5,6}}, new int[]{2,2,2,2,2,2}}
        );


        int idx = 1;
        for (Object[] tc : testCases) {
            int nt = (int)tc[0];
            int[][] relations = (int[][])tc[1];
            int[] time = (int[])tc[2];
            System.out.printf("%d.\tn = %d, relations = %s, time = %s%n",
                    idx, nt, Arrays.deepToString(relations), Arrays.toString(time));
            int result = minimumTime(nt, relations, time);
            System.out.printf("\tMinimum time required: %d%n", result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
            idx++;
        }
        
    }



    // Find All Possible Recipes from Given Supplies

    public static List<String> findAllRecipes (String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String,List<String>> graph=new HashMap<>();
        Map<String,Integer> indegree=new HashMap<>();
        // Initialize indegree for each recipe
        for (String recipe : recipes) {
            indegree.put(recipe, 0);
        }

        for(int i=0;i<ingredients.size();i++){
            String recipe=recipes[i];
            for(String ing:ingredients.get(i)){
                graph.computeIfAbsent(ing,k->new ArrayList<>()).add(recipe);
                indegree.put(recipe,indegree.getOrDefault(recipe,0)+1);
            }

        }

        Queue<String> source=new LinkedList<>(Arrays.asList(supplies));


        List<String> result = new ArrayList<>();
        while(!source.isEmpty()){
            String ingrdient=source.poll();
            if(graph.containsKey(ingrdient)){
                for(String nextRecipe:graph.get(ingrdient)){
                    indegree.put(nextRecipe,indegree.get(nextRecipe)-1);
                    if(indegree.get(nextRecipe)==0){
                        source.add(nextRecipe);
                        result.add(nextRecipe);
                    }
                }
            }

        }

        return result;
    }

// Parallel Courses III
    public static int minimumTime(int n, int[][] relations, int[] time) {

        if(relations.length==0){
            return Arrays.stream(time).max().getAsInt();
        }
       List<List<Integer>> adj=new ArrayList<>();
        int[] inDegree=new int[n+1];
        int[] dp=new int[n+1];   // The minimum total time required to finish course i, including all its prerequisites.

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<relations.length;i++){
            int parent=relations[i][0];
            int child=relations[i][1];
            adj.get(parent).add(child);
            inDegree[child]++;
        }


        Queue<Integer> source=new LinkedList<>();
        for(int course=1; course<=n ;course++){
            if(inDegree[course]==0){
                source.add(course);
                dp[course]=time[course-1];
            }
        }


        while(!source.isEmpty()){
            int parent=source.poll();
            for(int child:adj.get(parent)){
                dp[child]=Math.max(dp[child],dp[parent]+time[child-1]);
                if(--inDegree[child]==0){
                  source.add(child);
                }

            }
        }

        int ans=0;
        for(int i=1;i<=n;i++){
            ans=Math.max(dp[i],ans);

        }
        // Replace the following placeholder return statement with your code
        return ans;
    }


    // Longest Path With Different Adjacent Characters

    public static int longestPath(int[] parent, String s) {
        int n=parent.length;
        int[] inDegree=new int[n];
        int[][] longestChains=new int[n][2];

        for(int i=1;i<n;i++){
            inDegree[parent[i]]++;  // The number of children each node has (in this tree context).
        }

        int longestPathLenght=1;
        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                queue.offer(i);
                longestChains[i][0]=1;
            }

        }

        while(!queue.isEmpty()){
            int current=queue.poll();
            int par=parent[current];
            if(par!=-1){
                int longestchainFromCurrent=longestChains[current][0];
                if(s.charAt(current)!=s.charAt(par)) {
                    if (longestchainFromCurrent > longestChains[par][0]) {
                        longestChains[par][1] = longestChains[par][0];
                        longestChains[par][0] = longestchainFromCurrent;
                    } else if (longestchainFromCurrent > longestChains[par][1]) {
                        longestChains[par][1] = longestchainFromCurrent;

                    }
                }

                longestPathLenght=Math.max(longestPathLenght,longestChains[par][0]+longestChains[par][1]+1);

                inDegree[par]--;
                if(inDegree[par]==0){
                    queue.offer(par);
                    longestChains[par][0]++;
                }

            }

        }



        // Replace the following return statement with your code
        return longestPathLenght;
    }

    // Build a Matrix with Conditions
    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder=topSort(k,rowConditions);
        List<Integer> colOrder=topSort(k,colConditions);

        if(rowOrder.isEmpty() || colOrder.isEmpty()){
            return new int[0][0];
        }

        Map<Integer,Integer> rowMap=new HashMap<>();
        Map<Integer,Integer> colMap=new HashMap<>();

        for(int i=0;i<k;i++){
            rowMap.put(rowOrder.get(i),i);
            colMap.put(colOrder.get(i),i);
        }

        int[][] result=new int[k][k];
        for(int i=1;i<k;i++){
            result[rowMap.get(i)][colMap.get(i)]=i;
        }

        // Replace this placeholder return statement with your code
        return result;
    }

    private static List<Integer> topSort(int k, int[][] conditions) {
        Map<Integer, List<Integer>> adList = new HashMap<>();
        int[] inDegree = new int[k + 1];

        // Initialize adjacency list for all nodes
        for (int i = 1; i <= k; i++) {
            adList.put(i, new ArrayList<>());
        }

        // Build graph
        for (int[] cond : conditions) {
            int parent = cond[0];
            int child = cond[1];
            adList.get(parent).add(child);
            inDegree[child]++;
        }

        // Find all sources
        Queue<Integer> source = new ArrayDeque<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                source.offer(i);
            }
        }

        // BFS
        List<Integer> res = new ArrayList<>();
        while (!source.isEmpty()) {
            int item = source.poll();
            res.add(item);
            for (int child : adList.get(item)) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    source.offer(child);
                }
            }
        }

        return (res.size() == k) ? res : new ArrayList<>();
    }


    private static List<Integer> topSortDFS(int k, int[][] conditions) {
        HashMap<Integer,List<Integer>> adList=new HashMap<>();
        int[] visited=new int[k+1];
        List<Integer> res=new ArrayList<>();


        // Initialize adjacency list for all nodes
        for (int i = 1; i <= k; i++) {
            adList.put(i, new ArrayList<>());
        }

        // Build graph: parent -> child
        for (int[] cond : conditions) {
            int parent = cond[0];
            int child = cond[1];
            adList.get(parent).add(child);
        }

        // dfs
        for(int i=1;i<=k;i++){
            if(visited[i]==0){
                if(dfs(i,adList,visited,res)){
                    return new ArrayList<>();
                }
            }
        }
        Collections.reverse(res);
        return res;

    }
    // Course Schedule II

    // DFS helper
    private static boolean dfs(int node, Map<Integer, List<Integer>> adList,
                               int[] visited, List<Integer> res) {
        visited[node]=1;
        for(int child:adList.get(node)){
            if(visited[child]==1){
                return true;
            }
            if(visited[child]==0){
                if(dfs(child,adList,visited,res))
                    return true;
            }
        }
        visited[node]=2;
        res.add(node);
        return false;
    }

    public static List <Integer> findOrder(int n, int[][] prerequisites) {

        HashMap<Integer,List<Integer>> graph=new HashMap<>();
        HashMap<Integer,Integer> inDegree=new HashMap<>();

        //intialize;
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<>());
            inDegree.put(i,0);
        }

        for(int j=0;j<prerequisites.length;j++){
            int parent=prerequisites[j][1];
            int child=prerequisites[j][0];
            graph.get(parent).add(child);
            inDegree.put(child,inDegree.get(child)+1);
        }

        Deque<Integer> source=new LinkedList<>();

        for(Integer key:inDegree.keySet()){
            if(inDegree.get(key)==0){
                source.add(key);
            }
        }

        List<Integer> res=new ArrayList<>();
        while(!source.isEmpty()){
            int item=source.poll();
            res.add(item);
            for(int c=0;c<graph.get(item).size();c++){
                Integer child=graph.get(item).get(c);
                inDegree.put(child,inDegree.get(child)-1);
                if(inDegree.get(child)==0)
                    source.add(child);
            }

        }

        if(res.size()!=n){
            return new ArrayList<>();
        }

        // Replace this placeholder return statement with your code
        return res;
    }


    // Verifying an Alien Dictionary
    public static boolean verifyAlienDictionary(String[] words, String order) {

        if (words.length == 1)
            return true;

        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        // Replace this placeholder return statement with your code
        for(int i=0;i<words.length-1;i++){
            String firstWord=words[i];
            String secondWord=words[i+1];
            for(int j=0;j<Math.min(firstWord.length(),secondWord.length());j++){

                char firstChar=firstWord.charAt(j);
                char secondChar=secondWord.charAt(j);
                if(firstChar!=secondChar){
                    if(orderMap.get(firstChar)>orderMap.get(secondChar))
                        return false;

                    break;
                }


            }
            if(firstWord.length()>secondWord.length() && firstWord.startsWith(secondWord))
                return false;

        }
        // Replace this placeholder return statement with your code
        return true;
    }





//Alien Dictionary
    public static String alienOrder(List<String> words) {

        // Replace this placeholder return statement with your code
        HashMap<Character,List<Character>> adjList=new HashMap<>();
        HashMap<Character,Integer> inDegree=new HashMap<>();

        for(String word:words){
            for(char ch:word.toCharArray()){
                inDegree.put(ch,0);
            }
        }

        Set<Character> characters = inDegree.keySet();

        for(int i=0;i<words.size()-1;i++) {
            String word1 = words.get(i);
            String word2 = words.get(i + 1);
            int j=0;
            for ( j = 0; j < word1.length() && j < word2.length(); j++) {
                char c = word1.charAt(j);
                char d = word2.charAt(j);
                if (c != d) {
                    if (adjList.get(c) == null)
                        adjList.put(c, new ArrayList<Character>());

                    if (adjList.get(d) == null)
                        adjList.put(d, new ArrayList<Character>());

                    boolean found = false;
                    for (int child = 0; child < adjList.get(c).size(); child++) {
                        char ch = adjList.get(c).get(child);
                        if (ch == d) {
                            found = true;
                        }

                    }
                    if (!found) {
                        adjList.get(c).add(d);
                        inDegree.put(d, inDegree.get(d) + 1);
                    }
                    break;

                }


            }

            // check prefix
            if(j>=word1.length() || j>=word2.length()){
                if(word2.length()<word1.length()){
                    return "";
                }
            }

        }
        StringBuilder order = new StringBuilder();
            Deque<Character> source=new LinkedList<>();
            for(char key:inDegree.keySet()){
                if(inDegree.get(key)==0){
                    source.add(key);
                }
            }


            while(!source.isEmpty()){
                char item=source.poll();
                order.append(item);

                for(int child=0;child<adjList.getOrDefault(item, new ArrayList<>()).size();child++){
                    char ch=adjList.get(item).get(child);
                    inDegree.put(ch,inDegree.get(ch)-1);
                    if(inDegree.get(ch)==0){
                        source.add(ch);
                    }
                }

            }

            if(order.length()!= characters.size()){
                return "";
            }


        return order.toString();

    }


    // Compilation Order
    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies) {

        List<Character> sortedList=new ArrayList<>();
        HashMap<Character,List<Character>> graph=new HashMap<>();
        HashMap<Character,Integer> inDegree=new HashMap<>();

        //initilzie the graph and InDegree

        for(int i=0;i<dependencies.size();i++){
            char parent=dependencies.get(i).get(1);
            char child=dependencies.get(i).get(0);
            graph.put(parent,new ArrayList<>());
            graph.put(child,new ArrayList<>());
            inDegree.put(parent,0);
            inDegree.put(child,0);

        }

        for(int i=0;i<dependencies.size();i++){
            char parent=dependencies.get(i).get(1);
            char child=dependencies.get(i).get(0);
            graph.get(parent).add(child);
            inDegree.put(child,inDegree.get(child)+1);

        }


        Queue<Character> source=new LinkedList<>();

        for(char key:inDegree.keySet()){
            if(inDegree.get(key)==0){
                source.add(key);
            }
        }


        while(!source.isEmpty()){
            char item=source.poll();
            sortedList.add(item);

            for(int child=0;child<graph.get(item).size();child++){
                char childNode=graph.get(item).get(child);
                inDegree.put(childNode,inDegree.get(childNode)-1);
                if(inDegree.get(childNode)==0){
                    source.add(childNode);
                }
            }

        }

        if(sortedList.size()!=graph.size()){
            return new ArrayList<>();
        }
        // populate the maps

        // Replace this placeholder return statement with your code
        return sortedList;
    }
}
