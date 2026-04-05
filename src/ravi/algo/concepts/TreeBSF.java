package ravi.algo.concepts;
import java.beans.Introspector;
import java.util.*;
import java.util.LinkedList;

public class TreeBSF {

    public static void main(String[] args) {

        // Binary Tree Level Order Traversal
        List<TreeNode<Integer>> testCasesRoots = new ArrayList<>();

        List<TreeNode<Integer>> input1 = Arrays.asList(
                new TreeNode<>(100),
                new TreeNode<>(50),
                new TreeNode<>(200),
                new TreeNode<>(25),
                new TreeNode<>(75),
                new TreeNode<>(350)
        );
        BinaryTree<Integer> tree1 = new BinaryTree<>(input1);
        testCasesRoots.add(tree1.root);

        List<TreeNode<Integer>> input2 = Arrays.asList(
                new TreeNode<>(25),
                new TreeNode<>(50),
                null,
                new TreeNode<>(100),
                new TreeNode<>(200),
                new TreeNode<>(350)
        );
        BinaryTree<Integer> tree2 = new BinaryTree<>(input2);
        testCasesRoots.add(tree2.root);

        List<TreeNode<Integer>> input3 = Arrays.asList(
                new TreeNode<>(350),
                null,
                new TreeNode<>(100),
                null,
                new TreeNode<>(50),
                new TreeNode<>(25)
        );
        BinaryTree<Integer> tree3 = new BinaryTree<>(input3);
        testCasesRoots.add(tree3.root);

        BinaryTree<Integer> tree4 = new BinaryTree<>(Arrays.asList(new TreeNode<>(100)));
        testCasesRoots.add(tree4.root);

        testCasesRoots.add(null);

        for (int i = 0; i < testCasesRoots.size(); i++) {
            if (i > 0) {
                System.out.println("\n");
            }
            System.out.println(i + 1 + ".\tBinary Tree");
            // Print.displayTree(testCasesRoots.get(i));
            System.out.print("\n\tLevel order traversal: ");
            System.out.println(levelOrderTraversalBetter(testCasesRoots.get(i)) + "\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // Binary Tree Zigzag Level Order Traversal
        List<List<TreeNode<Integer>>> lists = Arrays.asList(

                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(350)),
                Arrays.asList(new TreeNode<Integer>(25), new TreeNode<Integer>(50), new TreeNode<Integer>(75), new TreeNode<Integer>(100), new TreeNode<Integer>(200), new TreeNode<Integer>(350)),
                Arrays.asList(new TreeNode<Integer>(350), new TreeNode<Integer>(200), new TreeNode<Integer>(100), new TreeNode<Integer>(75), new TreeNode<Integer>(50), new TreeNode<Integer>(25)),
                Arrays.asList(new TreeNode<Integer>(100)),
                Arrays.asList(new TreeNode<Integer>(null))
        );

        for (int i = 0; i < lists.size(); i++) {
            BinaryTree<Integer> t = new BinaryTree<Integer>(lists.get(i));
            System.out.println((i + 1) + ".\tBinary Tree");
           // Print.displayTree(t.root);
            System.out.println("\n\t The zigzag level order traversal is: " + zigzagLevelOrder(t.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    //Populating Next Right Pointers in Each Node

        // Initializing the binary tree
        List<EduTreeNode<Integer>> inputs = Arrays.asList(new EduTreeNode<Integer>(100), new EduTreeNode<Integer>(50), new EduTreeNode<Integer>(200), new EduTreeNode<Integer>(25), new EduTreeNode<Integer>(75), new EduTreeNode<Integer>(300), new EduTreeNode<Integer>(10));

        EduBinaryTree<Integer> tree = new EduBinaryTree<Integer>(inputs);

        // Function call to populate next pointers
        populateNextPointers(tree.root);
        int indexVal = 0;
        System.out.println("Binary tree:");
     //pxp
        //
        // ssPrint.displayTree(tree.root);
        System.out.println();
        for (EduTreeNode<Integer> nodeValue : inputs) {
            indexVal++;
            // Function call to find current node and get its next node using next pointer
            EduTreeNode<Integer> tmp = tree.getNextNode(tree.root, nodeValue.data);
            String sibNode = "null";
            if (tmp != null) {
                sibNode = String.valueOf(tmp.data);
            }
            System.out.print(indexVal + ".");
            System.out.println("\tCurrent Node Value: " + nodeValue.data);
            System.out.println("\tNext Node Value: " + sibNode);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Vertical Order Traversal of a Binary Tree
        List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(300), new TreeNode<Integer>(10), new TreeNode<Integer>(350), new TreeNode<Integer>(15)),
                Arrays.asList(new TreeNode<Integer>(20), new TreeNode<Integer>(40), new TreeNode<Integer>(50), new TreeNode<Integer>(90), new TreeNode<Integer>(67), new TreeNode<Integer>(94)),
                Arrays.asList(new TreeNode<Integer>(-10), new TreeNode<Integer>(-23), new TreeNode<Integer>(45), new TreeNode<Integer>(25), new TreeNode<Integer>(46)),
                Arrays.asList(new TreeNode<Integer>(9), new TreeNode<Integer>(7), null, null, new TreeNode<Integer>(1), new TreeNode<Integer>(8), new TreeNode<Integer>(10), null, new TreeNode<Integer>(12)),
                Arrays.asList(new TreeNode<Integer>(3), new TreeNode<Integer>(2), new TreeNode<Integer>(3), null, new TreeNode<Integer>(3), null, new TreeNode<Integer>(1))
        );

        List<BinaryTree<Integer>> inputTrees = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTrees) {
            BinaryTree<Integer> treeV = new BinaryTree<>(ListOfNodes);
            inputTrees.add(treeV);
        }

        int x = 1;
        for (BinaryTree<Integer> treevs : inputTrees) {
            System.out.println(x + ".\tInput Tree:");
         //   Print.displayTree(treevs.root);
            x++;
            System.out.println("\n\tVertical order: " + verticalOrder(treevs.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //Symmetric Tree

        List< List <TreeNode <Integer>>> listOfTreesS = Arrays.asList(
                Arrays.asList(new TreeNode <Integer> (1), new TreeNode <Integer> (2), new TreeNode <Integer> (2), new TreeNode <Integer> (3), new TreeNode <Integer> (4), new TreeNode <Integer> (4), new TreeNode <Integer> (3)),
                Arrays.asList(new TreeNode <Integer> (18), new TreeNode <Integer> (21), new TreeNode <Integer> (21), new TreeNode <Integer> (47), new TreeNode <Integer> (20), new TreeNode <Integer> (21), new TreeNode <Integer> (47)),
                Arrays.asList(new TreeNode <Integer> (25), new TreeNode <Integer> (4), new TreeNode <Integer> (67), new TreeNode <Integer> (2), new TreeNode <Integer> (3), new TreeNode <Integer> (3), new TreeNode <Integer> (2)),
                Arrays.asList(new TreeNode <Integer> (1), new TreeNode <Integer> (2), new TreeNode <Integer> (2), new TreeNode <Integer> (3), null, null, new TreeNode <Integer> (3)),
                Arrays.asList(new TreeNode <Integer> (1), new TreeNode <Integer> (2), new TreeNode <Integer> (2), null, new TreeNode <Integer> (3), new TreeNode <Integer> (3), null, new TreeNode <Integer> (4), new TreeNode <Integer> (5), new TreeNode <Integer> (5), new TreeNode <Integer> (4))
        );

        List<BinaryTree<Integer>> inputTreesS = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTreesS) {
            BinaryTree<Integer> treeS = new BinaryTree<Integer>(ListOfNodes);
            inputTrees.add(treeS);
        }

        int y = 1;
        for (BinaryTree<Integer> treeS : inputTreesS) {
            System.out.println(y++ + " .\tInput Tree:");
          //  Print.displayTree(tree.root);
            System.out.print("\n\tResult: ");
            boolean result = isSymmetric(treeS.root);
            System.out.println(result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //Word Ladder

        List<List<String>> wordsList = Arrays.asList(
                Arrays.asList("hog", "dot", "pot", "pop", "mop", "map", "cap", "cat"),
                Arrays.asList("hot", "dot", "lot", "log", "cog"),
                Arrays.asList("hot", "not", "dot", "lot", "cog"),
                Arrays.asList("hog", "dot", "pot", "pop", "mop", "map", "cap", "cat"),
                Arrays.asList("hot", "dot", "lot", "log", "cog","com","cam","frog")
        );
        List<String> srcList = Arrays.asList("dog", "hit", "hat", "dog", "dog");
        List<String> destList = Arrays.asList("cat", "cog", "log", "cat", "frog");

        for (int i = 0; i < srcList.size(); i++) {
            System.out.println((i + 1) + ".\tsrc: \"" + srcList.get(i) + "\"");
            System.out.println("\tdest: \"" + destList.get(i) + "\"");
            System.out.print("\tAvailable words: ");
            System.out.println(wordsList.get(i));
            System.out.println("\n\tLength of shortest chain is: " + wordLadder(srcList.get(i), destList.get(i), wordsList.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

// Two Sum IV - Input Is a BST

        List<List<TreeNode<Integer>>> trees = Arrays.asList(
                Arrays.asList(new TreeNode<>(7), new TreeNode<>(3), new TreeNode<>(13), new TreeNode<>(2), new TreeNode<>(5), null, new TreeNode<>(19)),
                Arrays.asList(new TreeNode<>(8), new TreeNode<>(4), null, new TreeNode<>(0), null, new TreeNode<>(-11)),
                Arrays.asList(new TreeNode<>(1), null, new TreeNode<>(2), null, new TreeNode<>(3), null, new TreeNode<>(4)),
                Arrays.asList(new TreeNode<>(900)),
                Arrays.asList(new TreeNode<>(0), new TreeNode<>(-200), new TreeNode<>(500), new TreeNode<>(-300), new TreeNode<>(-100), new TreeNode<>(400), new TreeNode<>(600))
        );

        List<Integer> ks = Arrays.asList(18, 4, 5, 900, 500);

        for (int i = 0; i < trees.size(); i++) {
            BinaryTree<Integer> treeB = new BinaryTree<>(trees.get(i));
            System.out.println((i + 1) + ".\tk = " + ks.get(i));
            System.out.println("\tBST: ");
         //   Print.displayTree(tree.root);
            System.out.println("\n\tDo two elements exist in this BST whose sum equals " + ks.get(i) + "? " + (findTarget(treeB.root, ks.get(i)) ? "Yes" : "No"));
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }

        // Find Minimum Diameter After Merging Two Trees

        int[][][] testCases1 = {
                {{0, 1}, {1, 2}},
                {{0, 1}, {1, 2}},
                {{0, 1}, {1, 2}, {2, 3}, {3, 4}},
                {{0, 1}, {1, 2}, {2, 3}},
                {{0, 1}, {1, 2}, {1, 3}}
        };

        int[][][] testCases2 = {
                {{0, 1}, {1, 2}},
                {{0, 1}},
                {{0, 1}, {1, 2}},
                {{0, 1}},
                {{0, 1}, {1, 2}, {1, 3}}
        };
        TreeBSF treeBSF=new TreeBSF();

        for (int i = 0; i < testCases1.length; i++) {
            int[][] edges1 = testCases1[i];
            int[][] edges2 = testCases2[i];
            int result = treeBSF.minimumDiameterAfterMerge(edges1, edges2);

            System.out.println((i + 1) + ".     edges1  : " + edgeListToString(edges1));
            System.out.println("       edges2  : " + edgeListToString(edges2));
            System.out.println("\n       Minimum possible diameter: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // Closest Node to Path in Tree


        int[] nArr = {3, 6, 7, 6, 9};

        int[][][] edgesArr = {
                {{0, 1}, {1, 2}},
                {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}},
                {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}},
                {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}},
                {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {2, 5}, {5, 6}, {6, 7}, {6, 8}}
        };

        int[][][] queryArr = {
                {{0, 2, 1}},
                {{1, 5, 2}, {2, 3, 4}},
                {{3, 4, 6}},
                {{0, 5, 3}},
                {{0, 4, 8}}
        };

        for (int i = 0; i < nArr.length; ++i) {
            System.out.println((i + 1) + ".\tn: " + nArr[i]);
            System.out.print("\tedges: ");
            System.out.println(Arrays.deepToString(edgesArr[i]));
            System.out.print("\tquery: ");
            System.out.println(Arrays.deepToString(queryArr[i]));

            int[] result = treeBSF.closestNode(nArr[i], edgesArr[i], queryArr[i]);

            System.out.print("\n\tanswer: " + Arrays.toString(result));
            System.out.println("\n" + "-".repeat(100));
        }
// Frog Position After T Seconds



        int[] nArrF = {4, 6, 4, 5, 3};
        int[][][] edgesArrF = {
                {{1, 2}, {2, 3}, {3, 4}},
                {{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}},
                {{1, 2}, {1, 3}, {2, 4}},
                {{1, 2}, {1, 3}, {3, 4}, {4, 5}},
                {{1, 2}, {1, 3}}
        };
        int[] tArr = {4, 2, 2, 2, 0};
        int[] targetArr = {4, 6, 2, 5, 1};

        for (int i = 0; i < nArrF.length; i++) {
            System.out.printf("%d.\tn: %d%n", i + 1, nArrF[i]);
            System.out.print("\tedges: [");
            for (int j = 0; j < edgesArrF[i].length; j++) {
                System.out.print(Arrays.toString(edgesArrF[i][j]));
                if (j + 1 < edgesArrF[i].length) System.out.print(", ");
            }
            System.out.println("]");
            System.out.printf("\tt: %d, target: %d%n", tArr[i], targetArr[i]);

            double ans = treeBSF.frogPosition(nArrF[i], edgesArrF[i], tArr[i], targetArr[i]);
            System.out.printf("%n\tanswer: %.5f%n", ans);
            System.out.println("\n" + "-".repeat(100));
        }

        List<List<TreeNode<Integer>>> listoftreess = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(300), new TreeNode<Integer>(10), new TreeNode<Integer>(350), new TreeNode<Integer>(15)),
                Arrays.asList(new TreeNode<Integer>(20), new TreeNode<Integer>(40), new TreeNode<Integer>(50), new TreeNode<Integer>(90), new TreeNode<Integer>(67), new TreeNode<Integer>(94)),
                Arrays.asList(new TreeNode<Integer>(-10), new TreeNode<Integer>(-23), new TreeNode<Integer>(45), new TreeNode<Integer>(25), new TreeNode<Integer>(46)),
                Arrays.asList(new TreeNode<Integer>(9), new TreeNode<Integer>(7), null, null, new TreeNode<Integer>(1), new TreeNode<Integer>(8), new TreeNode<Integer>(10), null, new TreeNode<Integer>(12)),
                Arrays.asList(new TreeNode<Integer>(3), new TreeNode<Integer>(2), new TreeNode<Integer>(3), null, new TreeNode<Integer>(3), null, new TreeNode<Integer>(1))
        );

        List<BinaryTree<Integer>> inputTreesss = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listoftreess) {
            BinaryTree<Integer> treess = new BinaryTree<>(ListOfNodes);
            inputTreesss.add(treess);
        }

        int xs = 1;
        for (BinaryTree<Integer> treess : inputTreesss) {
            System.out.println(xs + ".\tfnput Tree:");
     //       Print.displayTree(treess.root);
            xs++;
            List<Double> ans = averageOfLevels(treess.root);
       //     System.out.println("\n\tAverage of Levels: " + Print.toString5dp(ans));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        
    }


    // Open the Lock

        public int openLock(String[] deadends, String target)


        {


            // Replace this placeholder return statement with your code


            return -1;

            //Average of Levels in Binary Tree
        }

        public static List<Double> averageOfLevels(TreeNode<Integer> root) {
        List<Double> ans=new ArrayList<>();

        Queue<TreeNode<Integer>> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            int size=queue.size();
            double sum=0.0;
            for(int i=0;i<size;i++){
                TreeNode<Integer> curr=queue.poll();
                sum+=curr.value;

                if(curr.left!=null)
                    queue.offer(curr.left)   ;

                  if(curr.right!=null)
                      queue.offer(curr.right) ;

            }
            ans.add(sum);


        }


        // Replace the following placeholder return statement with your code
        return ans;
    }


    // Frog Position After T Seconds
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Integer,List<Integer>> adj=new HashMap<>();

        for(int[] edg:edges){
            int u=edg[0];
            int v=edg[1];
            adj.computeIfAbsent(u,z->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,z->new ArrayList<>()).add(u);
        }

        Queue<Map.Entry<Double,Integer>> queue=new LinkedList<>();
        queue.offer(new AbstractMap.SimpleEntry<Double,Integer>(1.0,1));
        int time=0;
        Set<Integer> visted=new HashSet<>();
        visted.add(1);
        while(!queue.isEmpty() && time<=t){

            int size=queue.size();
            for(int i=0;i<size;i++) {
                Map.Entry<Double, Integer> node = queue.poll();
                Double prop = node.getKey();
                Integer num = node.getValue();
                List<Integer> childs = adj.getOrDefault(num, new ArrayList<>());
                int count=0;
                for (int ch : childs) {
                    if (!visted.contains(ch)) {
                        count++;
                    }

                }

                if (num == target ) {
                    if(time==t || count==0)
                        return prop;
                    else{
                        return 0.0;
                    }
                }
                for (int ch : childs) {
                    if (!visted.contains(ch)) {
                        visted.add(ch);
                        queue.offer(new AbstractMap.SimpleEntry<Double, Integer>(prop * (1.0 / count), ch));
                    }
                }

            }
            time++;
        }




        // Write your code here
        return 0.0;
    }


    // Closest Node to Path in Tree
    public int[] closestNode(int n, int[][] edges, int[][] query) {

        // Replace this placeholder return statement with your code

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            adj.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            adj.computeIfAbsent(end, x -> new ArrayList<>()).add(start);
        }

        int[] ans = new int[query.length];

        for (int i = 0; i < query.length; i++) {

            int start = query[i][0];
            int end = query[i][1];
            int node = query[i][2];

            Queue<Integer> q1 = new LinkedList<>();
            q1.offer(start);
            int[] parent = new int[n];
            Arrays.fill(parent, -1);
            boolean[] visited = new boolean[n];
            visited[start] = true;

            while (!q1.isEmpty()) {

                int curr = q1.poll();
                if (curr == end)
                    break;
                for (int next : adj.get(curr)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        parent[next] = curr;
                        q1.offer(next);
                    }
                }
            }


        List<Integer> path = new ArrayList<>();
        int curr = end;

        while(curr!=-1){
            path.add(curr);
            curr=parent[curr];
        }

        Collections.reverse(path);

      int dist[]= new int[n];
      Arrays.fill(dist,Integer.MAX_VALUE);
      Queue<Integer> q2=new LinkedList<>();
      q2.offer(node);
      dist[node]=0;

      while(!q2.isEmpty()){
          int u=q2.poll();
          for(int v:adj.get(u)){
              if (dist[v] == Integer.MAX_VALUE) {   // If 'v' is
                  dist[v]=dist[u]+1;
                  q2.offer(v);
              }
          }
      }

      int maxDistance=Integer.MAX_VALUE;
      int answer=-1;

      for(int p:path){

          if(dist[p]<maxDistance || (dist[p]==maxDistance && p< answer)){
              maxDistance=dist[p];
              answer=p;
          }
      }

      ans[i]=answer;




    }


        return ans;
    }

    // Print a 2D edge list nicely
    private static String edgeListToString(int[][] edges) {
        StringBuilder sb = new StringBuilder();
        for (int[] edge : edges) {
            sb.append("[").append(edge[0]).append(",").append(edge[1]).append("] ");
        }
        return sb.toString().trim();
    }

// Find Minimum Diameter After Merging Two Trees

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {

        Map<Integer,List<Integer>> adj1=getAdjList(edges1);
        Map<Integer,List<Integer>> adj2=getAdjList(edges2);

        int d1= getDaimeter(adj1);
        int d2= getDaimeter(adj2);

        int mergeDaiber= (int) Math.ceil(d1/2.0) +(int) Math.ceil(d2/2.0)+1;

        return Math.max(d1,Math.max(d2,mergeDaiber));

    }

    private int getDaimeter(Map<Integer, List<Integer>> adj1) {

        int nodeA=getFurtherestNode(0,adj1)[0];
        return getFurtherestNode(nodeA,adj1)[1];

    }

    private int[] getFurtherestNode(int start, Map<Integer, List<Integer>> adj1) {

        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{start,0});
        Set<Integer> visited=new HashSet<>();
        int furtherestNode=start;
        int maxDist=0;
        while(!queue.isEmpty()){
            int[] next=queue.poll();
            int node=next[0];
            int dist=next[1];

            if(dist>maxDist){
                furtherestNode=node;
                maxDist=dist;

            }


            for(int neighbor : adj1.getOrDefault(node,Collections.emptyList())){
                if(!visited.contains(neighbor)) {
                    queue.offer(new int[]{neighbor, dist + 1});
                    visited.add(neighbor);
                }
            }
        }
        return new int[]{furtherestNode,maxDist};
    }

    private Map<Integer, List<Integer>> getAdjList(int[][] edges1) {
        Map<Integer, List<Integer>> adj=new HashMap<>();

        for(int[] edj:edges1){
            int u=edj[0];
            int v=edj[1];
            adj.computeIfAbsent(u,x->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,x->new ArrayList<>()).add(u);


        }

        return adj;
    }


    // Two Sum IV - Input Is a BST

    public static boolean findTarget(TreeNode<Integer> root, int k) {
        Set<Integer>  myset=new HashSet<>();

        Queue<TreeNode<Integer>> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
                TreeNode<Integer> node = queue.poll();

                if (myset.contains(node.value)) {
                    return true;
                } else {
                    myset.add(k - node.value);
                }
                if(node.left!=null)
                    queue.offer(node.left);

                if(node.right!=null)
                    queue.offer(node.right);


            }
        // Replace this placeholder return statement with your code
        return false;
    }

    //

    // Word Ladder

    public static int wordLadder(String src, String dest, List<String> words) {

        Set<String> workdset=new HashSet<>(words);
        Queue<String> queue=new LinkedList<>();
        queue.add(src);
        int length=0;
        if(!workdset.contains(dest))
            return 0;

        while(!queue.isEmpty()){
            int size=queue.size();
            length++;
            String curr=queue.poll();

            for(int i=0;i<size;i++){
                String alpha = "abcdefghijklmnopqrstuvwxyz";

                for(int j=0;j<curr.length();j++) {
                    char[] temp=curr.toCharArray();
                    for(int k=0;k<alpha.length();k++){
                        temp[j]=alpha.charAt(k);
                        String newword=new String(temp);
                        if(newword.equals(dest)){
                            return ++length;
                        }

                        if(workdset.contains(newword)){
                            queue.offer(newword);
                            workdset.remove(newword);
                        }
                    }

                }
            }

        }

        // Replace this placeholder return statement with your code
        return 0;
    }

    // Symmetric Tree

    public static boolean isSymmetric(TreeNode<Integer> root) {

        // Replace this placeholder return statement with your code
        Queue<TreeNode<Integer>> queue=new ArrayDeque<>();
        if(root==null)
            return true;

        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            TreeNode<Integer> left=queue.poll();
            TreeNode<Integer> right=queue.poll();

            if(right==null && left==null)
                continue;

            if(right==null ||  left==null)
                return false;

            if(!left.value.equals(right.value))
                return false;


            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }


        return true;
    }
    // Vertical Order Traversal of a Binary Tree\


    public static List<List<Integer>> verticalOrder(TreeNode<Integer> root) {
        List<List<Integer>> ouput=new ArrayList<>();
        if(root==null){
            return ouput;
        }
        Map<Integer,List<Integer>> nodeList=new HashMap<>();
        Queue<Map.Entry<TreeNode<Integer>,Integer>> queue=new ArrayDeque<>();
        int column=0;

        queue.offer(new AbstractMap.SimpleEntry<TreeNode<Integer>,Integer>(root,column));
        int minColumn=0;
        int maxColumn=0;

        while(!queue.isEmpty()){

           Map.Entry<TreeNode<Integer>,Integer> element= queue.poll();
           root=element.getKey();
           column=element.getValue();

           if(!nodeList.containsKey(column))
               nodeList.put(column,new ArrayList<>());

           nodeList.get(column).add(root.value);

           minColumn=Math.min(minColumn,column);
           maxColumn=Math.min(maxColumn,column);


           if(root.left!=null) queue.offer(new AbstractMap.SimpleEntry<TreeNode<Integer>,Integer>(root.left,column-1));
            if(root.right!=null) queue.offer(new AbstractMap.SimpleEntry<TreeNode<Integer>,Integer>(root.right,column+1));

        }


        for(int i=minColumn;i<=maxColumn;i++){
            ouput.add(nodeList.get(i));
        }



        // Replace this placeholder return statament with your code
        return ouput;
    }

    // Populating Next Right Pointers in Each Node

    public static EduTreeNode<Integer> populateNextPointersB(EduTreeNode<Integer> root) {
        // Replace this placeholder return statement with your code
        if (root == null) {
            return null;
        }

        EduTreeNode<Integer> leftMost=root;

        while(leftMost.left!=null){

            EduTreeNode<Integer> current=leftMost;

            while(current!=null){
                current.left.next=current.right;

                if(current.next!=null){
                    current.right.next=current.next.left;
                }
                current=current.next;


            }

            leftMost=leftMost.left;

        }
        return root;

    }



        public static EduTreeNode<Integer> populateNextPointers(EduTreeNode<Integer> root) {
            // Replace this placeholder return statement with your code

            Queue<EduTreeNode<Integer>> queue=new ArrayDeque<>();
            queue.add(root);

            while(!queue.isEmpty()){

                int size= queue.size();
                EduTreeNode<Integer> prev=null;
                for(int i=0;i<size;i++){

                    EduTreeNode<Integer> node=queue.poll();
                    if(prev!=null)
                        prev.next=node;

                    prev = node;


                    if(node.left!=null) {
                        queue.offer(node.left);
                    }
                    if(node.right!=null) {
                        queue.offer(node.right);
                    }

                }


            }


            return root;
        }

    // Binary Tree Zigzag Level Order Traversal

    public static List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {

        List<List<Integer>> result=new ArrayList<>();
        if (root == null) {
            return result;
        }
        int direction = 1;
        Deque<TreeNode<Integer>> deque=new ArrayDeque<>();
        deque.offerFirst(root);

        while(!deque.isEmpty()){

            int size=deque.size();
            List<Integer> subResult=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode<Integer> node;
                if(direction==1){
                    node=deque.pollFirst();
                    if(node.left!=null)
                        deque.offerLast(node.left);
                    if(node.right!=null)
                        deque.offerLast(node.right);

                } else {
                    node=deque.pollLast();
                    if(node.left!=null)
                        deque.offerFirst(node.left);
                    if(node.right!=null)
                        deque.offerFirst(node.right);

                }
                subResult.add(node.value);
               }

            result.add(subResult);
            direction*=-1;


        }
        // Replace this placeholder return statement with your codepra
        return result;
    }

    public static String levelOrderTraversalBetter(TreeNode<Integer> root) {

        if (root == null) {
            return "None";
        }
        List<String> result = new ArrayList<>();
        Queue<TreeNode<Integer>> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()) {

            int size = que.size();
            List<String> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                TreeNode<Integer> next = que.poll();
                levelNodes.add(String.valueOf(next.value));

                if (next.left != null) {
                    que.add(next.left);
                }

                if (next.right != null) {
                    que.add(next.right);
                }

            }
            result.add(String.join(", ",levelNodes));

          }
        return String.join(" : ",result);
      }


    //Binary Tree Level Order Traversal

    public static String levelOrderTraversal(TreeNode<Integer> root) {

        Queue<Map<Integer,TreeNode<Integer>>> q =new ArrayDeque<>();
        Map<Integer,List<TreeNode<Integer>>> levelMap=new HashMap<>();
        int level=0;
        Map<Integer,TreeNode<Integer>> first=new HashMap<>();

        first.put(level,root);
        List<TreeNode<Integer>> list=new ArrayList<>();
        list.add(root);
        levelMap.put(level,list);
        q.add(first);
        StringBuilder st=new StringBuilder();


        while(!q.isEmpty()){
            Map<Integer,TreeNode<Integer>> next=q.poll();
            Optional<Integer> curLevel=next.keySet().stream().findFirst();
            int nextLevel=0;
            if(curLevel.isPresent()){
                nextLevel=curLevel.get()+1;
                TreeNode<Integer> nextNode=next.get(curLevel.get());

                if(nextNode.left!=null){
                    Map<Integer,TreeNode<Integer>> nextMapLeft=new HashMap<>();
                    nextMapLeft.put(nextLevel,nextNode.left);
                    q.add(nextMapLeft);
                    levelMap.computeIfAbsent(nextLevel,k-> new ArrayList<>()).add(nextNode.left);
                }

                if(nextNode.right!=null){
                    Map<Integer,TreeNode<Integer>> nextMapRight=new HashMap<>();
                    nextMapRight.put(nextLevel,nextNode.right);
                    q.add(nextMapRight);
                    levelMap.computeIfAbsent(nextLevel,k-> new ArrayList<>()).add(nextNode.right);
                }


            }

        }


        for(Integer key:levelMap.keySet()){
            List<TreeNode<Integer>> nodeList=levelMap.get(key);

            for(TreeNode<Integer> node:nodeList){
                st.append(node.value).append(",");
            }
            st.deleteCharAt(st.length()-1);
            st.append(":");
            }
        st.deleteCharAt(st.length()-1);
        // Replace this placeholder return statement with your code
        return st.toString();
    }
}
