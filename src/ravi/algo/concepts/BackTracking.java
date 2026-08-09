package ravi.algo.concepts;
import java.util.*;
import java.util.LinkedList;


public class BackTracking {

    public static void main(String[] args) {


// N-Queens II
        int[] nValues = {4, 5, 6, 7, 8};

        for (int i = 0; i < nValues.length; i++) {
            int n = nValues[i];
            System.out.printf("%d.\tQueens: %d, Chessboard: (%dx%d)%n", i + 1, n, n, n);
            int res = totalNQueens(n);
            System.out.printf("%n\tTotal solutions count for %d queens on a %dx%d chessboard: %d%n", n, n, n, res);
            System.out.println("-".repeat(100) + "\n");
        }


        // Word Search

        char[][][] grids = {
                {{'E', 'D', 'X', 'I', 'W'},
                        {'P', 'U', 'F', 'M', 'Q'},
                        {'I', 'C', 'Q', 'R', 'F'},
                        {'M', 'A', 'L', 'C', 'A'},
                        {'J', 'T', 'I', 'V', 'E'}},

                {{'E', 'D', 'X', 'I', 'W'},
                        {'P', 'A', 'F', 'M', 'Q'},
                        {'I', 'C', 'A', 'S', 'F'},
                        {'M', 'A', 'L', 'C', 'A'},
                        {'J', 'T', 'I', 'V', 'E'}},

                {{'h', 'e', 'c', 'm', 'l'},
                        {'w', 'l', 'i', 'e', 'u'},
                        {'a', 'r', 'r', 's', 'n'},
                        {'s', 'i', 'i', 'o', 'r'}},

                {{'C', 'Q', 'N', 'A'},
                        {'P', 'S', 'E', 'I'},
                        {'Z', 'A', 'P', 'E'},
                        {'J', 'V', 'T', 'K'}},

                {{'O', 'Y', 'O', 'I'},
                        {'B', 'Y', 'N', 'M'},
                        {'K', 'D', 'A', 'R'},
                        {'C', 'I', 'M', 'I'},
                        {'Z', 'I', 'T', 'O'}}
        };
        String[] words = {"EDUCATIVE", "PACANS", "warrior", "SAVE", "DYNAMIC"};
        for(int i=0;i<words.length;i++){
            System.out.print(i+1);
            System.out.println(".\tGrid = ");
            printGrid(grids[i]);
            System.out.println("\tWord = "+ words[i]);

            Boolean result = wordSearch(grids[i], words[i]);
            if(result == true){
                System.out.println("\n\tSearch result = Found Word");
            }
            else{
                System.out.println("\n\tSearch result = Word could not be found");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        // Restore IP Addresses

        String[] inputs = {
                "0000",
                "25525511135",
                "12121212",
                "113242124",
                "199219239",
                "121212",
                "25525511335"
        };
        for (int i = 0; i < inputs.length; i++) {

            List < String > result = restoreIpAddresses(inputs[i]);
            System.out.print(i + 1);
            System.out.println(".\tInput Addresses: " + inputs[i]);
            System.out.println("\n\tPossible valid IP Addresses are: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // flood fill
        int[][][] gridsFlood = {
                {{1, 1, 0, 1, 0},
                        {0, 0, 0, 0, 1},
                        {0, 0, 0, 1, 1},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0}},

                {{1, 1, 0, 1},
                        {0, 0, 0, 0},
                        {0, 0, 0, 1},
                        {1, 1, 1, 1}},

                {{9, 9, 6, 9},
                        {6, 9, 9, 6},
                        {6, 9, 9, 9},
                        {9, 9, 9, 9}},

                {{1, 1, 0, 1},
                        {0, 1, 0, 0},
                        {0, 1, 1, 0},
                        {1, 0, 1, 1}},

                {{1, 2, 0, 0},
                        {3, 1, 3, 6},
                        {7, 2, 1, 5},
                        {1, 9, 2, 1}}
        };

        int[] sr = {4, 2, 2, 2, 1};
        int[] sc = {3, 3, 1, 3, 1};
        int[] target = {3, 2, 1, 0, 4};

        for (int i = 0; i < gridsFlood.length; i++) {
            System.out.println((i + 1) + ".\t Grid before flood fill: " + Arrays.deepToString(gridsFlood[i]));
            System.out.println("\t Starting row and column are: (" + sr[i] + ", " + sc[i] + ")");
            System.out.println("\t Target value: " + target[i]);

            int[][] result = floodFill(gridsFlood[i], sr[i], sc[i], target[i]);
            System.out.println("\t After perform flood fill: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[][][] gridsMove = {
                {
                        {1, 1, 1},
                        {1, 2, 3},
                        {0, 0, 0}
                },
                {
                        {8, 1, 0},
                        {0, 0, 0},
                        {0, 0, 0}
                },
                {
                        {2, 2, 2},
                        {1, 1, 1},
                        {0, 0, 0}
                },
                {
                        {3, 0, 0},
                        {3, 0, 0},
                        {3, 0, 0}
                },
                {
                        {1, 0, 1},
                        {3, 0, 0},
                        {0, 4, 0}
                }
        };

        for (int i = 0; i < gridsMove.length; i++) {
            System.out.println((i + 1) + ".\tInput grid: ");
            draw2DArray(gridsMove[i]);
            System.out.println("\n\tMinimum number of moves: " + minimumMoves(gridsMove[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // House Robber III

        List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
                Arrays.asList( new TreeNode<Integer>(10), new TreeNode<Integer>(9), new TreeNode<Integer>(20), new TreeNode<Integer>(15), new TreeNode<Integer>(7)),
                Arrays.asList( new TreeNode<Integer>(7), new TreeNode<Integer>(9), new TreeNode<Integer>(10), new TreeNode<Integer>(15), new TreeNode<Integer>(20)),
                Arrays.asList( new TreeNode<Integer>(8), new TreeNode<Integer>(2), new TreeNode<Integer>(17), new TreeNode<Integer>(1), new TreeNode<Integer>(4), new TreeNode<Integer>(19), new TreeNode<Integer>(5)),
                Arrays.asList( new TreeNode<Integer>(7), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(1), new TreeNode<Integer>(3)),
                Arrays.asList( new TreeNode<Integer>(9), new TreeNode<Integer>(5), new TreeNode<Integer>(7), new TreeNode<Integer>(1), new TreeNode<Integer>(3)),
                Arrays.asList( new TreeNode<Integer>(9), new TreeNode<Integer>(7), null, null, new TreeNode<Integer>(1), new TreeNode<Integer>(8), new TreeNode<Integer>(10), null, new TreeNode<Integer>(12))
        );

        List<BinaryTree<Integer>> inputTrees = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTrees) {
            BinaryTree<Integer> tree = new BinaryTree<>(ListOfNodes);
            inputTrees.add(tree);
        }


        int x = 1;
        for (BinaryTree<Integer> tree : inputTrees) {
            System.out.println(x + ".\tInput Tree:");
            //  Print.displayTree(tree.root);
            //  Print.displayTree(tree.root);
            x++;
            System.out.println("\n\tMaximum amount we can rob without getting caught: " + rob(tree.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        List<List<TreeNode<Integer>>> listOfTreesS = Arrays.asList(
                Arrays.asList(new TreeNode<>(3), new TreeNode<>(2), new TreeNode<>(17), new TreeNode<>(1), null, new TreeNode<>(19), new TreeNode<>(5)),
                Arrays.asList(new TreeNode<>(7), new TreeNode<>(6), new TreeNode<>(5), new TreeNode<>(4), new TreeNode<>(3), new TreeNode<>(2), null, new TreeNode<>(1)),
                Arrays.asList(new TreeNode<>(5), new TreeNode<>(4), new TreeNode<>(6), new TreeNode<>(3), new TreeNode<>(2), new TreeNode<>(7), new TreeNode<>(8), null, new TreeNode<>(9)),
                Arrays.asList(new TreeNode<>(5), new TreeNode<>(2), new TreeNode<>(1), new TreeNode<>(6), new TreeNode<>(10), null, new TreeNode<>(44)),
                Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(5), new TreeNode<>(3), new TreeNode<>(4), new TreeNode<>(6))
        );

        List<BinaryTree> inputTreesS = new ArrayList<>();
        for (List<TreeNode<Integer>> listOfNodes : listOfTreesS) {
            BinaryTree tree = new BinaryTree(listOfNodes);
            inputTreesS.add(tree);
        }


        int xs = 1;
        for (int i = 0; i < inputTreesS.size(); i++) {
            System.out.println(xs + ".\tInput Tree:");
//            Print.displayTree(inputTrees.get(i).root,null);
            List<String> res = binaryTreePaths(inputTreesS.get(i).root);
            System.out.println("\n\tPaths: " + Arrays.toString(res.toArray()));
            xs++;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // binary watch
        int[] inputsWatch = {1, 2, 0, 3, 10};

        for (int i = 0; i < inputsWatch.length; i++) {
            System.out.println((i + 1) + ".\tenabled: " + inputsWatch[i] + "\n");
            List<String> result = readBinaryWatch(inputsWatch[i]);
            System.out.print("\tPossible times: [");
            for (int j = 0; j < result.size(); j++) {
                System.out.print("\"" + result.get(j) + "\"");
                if (j < result.size() - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }
// Optimal Account Balancing
        int[][][] transactionsList = {
                {{0, 1, 40}, {1, 2, 15}, {0, 3, 30}, {4, 5, 10}, {2, 5, 10}},
                {{1, 0, 10}, {2, 0, 30}, {3, 0, 40}, {2, 0, 15}},
                {{0, 1, 10}, {1, 2, 20}, {2, 3, 30}, {3, 4, 40}, {4, 5, 50}, {5, 6, 60}},
                {{0, 1, 10}, {0, 2, 20}, {0, 3, 30}, {0, 4, 40}, {5, 0, 100}},
                {{0, 1, 10}, {1, 0, 10}}
        };

        for (int i = 0; i < transactionsList.length; i++) {
            System.out.print(i + 1 + ".\tTransactions: ");
         //   Print.print2DArray(transactionsList[i]);
            System.out.println("\n\tMinimum number of transactions to settle all debts: " +     minTransfers(transactionsList[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Split a String Into the Max Number of Unique Substrings

        String[] testCases = {"ababccc", "aba", "abcabc", "aabbcc", "abcdef"};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println((i + 1) + ".\tInput string: '" + testCases[i] + "'");
            int result = maxUniqueSplit(testCases[i]);
            System.out.println("\tMaximum unique splits: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // All Paths From Source to Target

        int[][][] testCasesS = {
                {{1, 2}, {3}, {3}, {}},
                {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}},
                {{1}, {2}, {3}, {}},
                {{1, 2}, {3}, {3}, {4}, {}},
                {{1}, {2}, {}, {}}
        };

        for (int i = 0; i < testCasesS.length; i++) {
            System.out.println((i + 1) + ".\tgraph: " + Arrays.deepToString(testCasesS[i]));
            System.out.println("\toutput: " + allPathsSourceTarget(testCasesS[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        //  //Remove Invalid Parentheses
        String[] testCasesP = {
                "()())()",
                "(a)())()",
                ")(",
                "(a(b(c)d)",
                "((()())(()"
        };

        for (int i = 0; i < testCasesP.length; i++) {
            List<String> result = removeInvalidParentheses(testCasesP[i]);
            System.out.println((i + 1) + ".\tInput: " + testCasesP[i]);
            System.out.println("\tValid Outputs: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        printBoard(board);

        solveSudoku(board);

        // Print the solved board
        printBoard(board);


        // Matchsticks to Square
        int[] matchsticks = {1, 1, 2, 2, 2};
        System.out.println(matchsticksToSquare(matchsticks)); // Output: true
        int[] matchsticks1 = {3, 3, 3, 3, 4};
        System.out.println(matchsticksToSquare(matchsticks1));


        int[] matchsticks2 = {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
        System.out.println(matchsticksToSquare(matchsticks2)); // Output: true


    int[] nArr = {2, 1, 4};

    for (int i = 0; i < nArr.length; ++i) {
        System.out.println((i + 1) + "\tn: " + nArr[i]);
        List<List<String>> answer = solveNQueens(nArr[i]);
        System.out.print("\n\tQueens' arrangements:\n\n\t[");
        for (int j = 0; j < answer.size(); ++j) {
            if (j > 0)
                System.out.print("\t");
            System.out.print("[");
            for (int k = 0; k < answer.get(j).size(); ++k) {
                System.out.print("\"" + answer.get(j).get(k) + "\"");
                if (k < answer.get(j).size() - 1)
                    System.out.print(", ");
            }
            System.out.print("]");
            if (j < answer.size() - 1)
                System.out.print(",\n");
        }
        System.out.println("]");
        System.out.println("\n" + "-".repeat(100));
    }

}


//  N-Queens

public static List<List<String>> solveNQueens(int n) {
        Set<Integer> daig=new HashSet<>();
        Set<Integer> antiDiag=new HashSet<>();
        Set<Integer> cols=new HashSet<>();
        List<List<String>> result=new ArrayList<>();
        char[][] path=new char[n][n];
        for(char[] chars:path)
            Arrays.fill(chars,'.');
        backtrackNQueen(n,0,daig,antiDiag,cols,path, result);

    // Replace this placeholder return statement with your code
    return result;
}

    private static void backtrackNQueen(int n, int row, Set<Integer> daigset, Set<Integer> antiDiagSet, Set<Integer> cols, char[][] path, List<List<String>> result) {


        if(row==n){
            List<String> options=new ArrayList<>();
            for(char[] chars:path) {
                options.add(new String(chars));
            }
            result.add(options);

            return;
        }

        for(int col=0;col<n;col++){
            int daig=row-col;
            int antiDaig=row+col;

            if(isValidQueen(col,daig,antiDaig,daigset,antiDiagSet,cols)){
                daigset.add(daig);
                antiDiagSet.add(antiDaig);
                cols.add(col);
                path[row][col]='Q';
                backtrackNQueen(n,row+1,daigset,antiDiagSet,cols,path,result);
                path[row][col]='.';
                daigset.remove(daig);
                antiDiagSet.remove(antiDaig);
                cols.remove(col);
            }

        }

    }

    private static boolean isValidQueen( int col, int daig, int antiDaig, Set<Integer> daigset, Set<Integer> antiDiagSet, Set<Integer> cols) {
            if(cols.contains(col) || daigset.contains(daig) || antiDiagSet.contains(antiDaig)){
                return false;
            }

            return true;
    }


    //  Matchsticks to Square

    public static boolean matchsticksToSquare(int[] matchsticks) {

        int totalSum=Arrays.stream(matchsticks).sum();
        if (totalSum % 4 != 0) {
            return false;
            // number is divisible by 4
        }
        // Replce this placeholder return statement with your code
        int target= (totalSum)/4;

        Arrays.sort(matchsticks);

        for(int i=0,j=matchsticks.length-1;i<j;i++,j--){
            int temp=matchsticks[i];
            matchsticks[i]=matchsticks[j];
            matchsticks[j]=temp;
        }

        int[] sides = new int[4];
        return backtrackMatchStick(matchsticks,0,target,sides);


    }

    private static boolean backtrackMatchStick(int[] matchsticks, int index,  int target, int[]  sides) {

        if(index==matchsticks.length){
            return (sides[0]==target && sides[1]==target && sides[2]==target && sides[3]==target);
        }

        int stick=matchsticks[index];

       // for each stick you are checking which block to put so for each strick you are check each block in eachgh recurson
        for(int i=0;i<4;i++){
            if(sides[i]+stick<=target){
                sides[i]+=stick;
                if(backtrackMatchStick(matchsticks,index+1,target,sides)){
                    return true;
                }
                sides[i]-=stick;
            }
            if(sides[i]==0) break;

        }

        return false;

    }


    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }


    // Sudoku Solver

    public static char[][] solveSudoku(char[][] board) {
        backtrackSudoku(board);
        // Replace this placeholder return statement with your code
        return board;
    }

    private static boolean backtrackSudoku(char[][] board) {

        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){

                if(board[row][col]!='.'){
                    continue;
                }

                for(char ch='1';ch<='9';ch++){
                    if(isValidSudexo(board,row,col,ch)){
                        board[row][col]=ch;
                        if(backtrackSudoku(board))
                            return true;

                        board[row][col]='.';
                    }

                }

                return false;
            }

        }
        return true;
    }

    private static boolean isValidSudexo(char[][] board, int row, int col, char ch) {

        for(int i=0;i<9;i++){

            if(board[row][i]==ch)
                return false;

            if(board[i][col]==ch)
                return false;

            int booardRow=3*(row/3)+i/3;
            int boardCol=3*(col/3)+i%3;
            if(board[booardRow][boardCol]==ch)
                return false;
        }

        return true;
    }


    //Remove Invalid Parentheses

    public static List<String> removeInvalidParentheses (String s) {
        Set<String> result=new HashSet<>();
        int lefttoRemove=0;
        int rightToRemove=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                lefttoRemove++;
            }else if(ch==')'){
                if(lefttoRemove>0){
                    lefttoRemove--;
                }else{
                    rightToRemove++;
                }
            }
        }

        backtrackParenthis(s,0,0,0,new StringBuilder(),lefttoRemove,rightToRemove,result);

        // Replace this placeholder return statement with your code
        return new ArrayList<String>(result);
    }

    private static void backtrackParenthis(String s, int leftCount, int righCount, int index, StringBuilder path, int lefttoRemove, int rightToRemove, Set<String> result) {

        if(index==s.length()){
            if(lefttoRemove==0 && rightToRemove==0 && leftCount == righCount){
                result.add(path.toString());
            }
            return;
        }

        char ch=s.charAt(index);
        int len=path.length();

        if(ch=='('){
            if(lefttoRemove>0){
                backtrackParenthis(s,leftCount,righCount,index+1,path,lefttoRemove-1,rightToRemove,result);
            }
            path.append(ch);
            backtrackParenthis(s,leftCount+1,righCount,index+1,path,lefttoRemove,rightToRemove,result);
            path.setLength(len);
        }else if(ch==')'){
            if(rightToRemove>0){
                backtrackParenthis(s,leftCount,righCount,index+1,path,lefttoRemove,rightToRemove-1,result);
            }
            if(leftCount>righCount){
                path.append(ch);
                backtrackParenthis(s,leftCount,righCount+1,index+1,path,lefttoRemove,rightToRemove,result);
                path.setLength(len);
            }

        }else{
            path.append(ch);
            backtrackParenthis(s,leftCount,righCount,index+1,path,lefttoRemove,rightToRemove,result);
            path.setLength(len);
        }


    }


    // All Paths From Source to Target
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result=new ArrayList<>();
        int target=graph.length-1;
        backtrackPaths(graph,0,new ArrayList<Integer>(Arrays.asList(0)),result,target);
        // Replace this placeholder return statement with your code
        return result;
    }

    private static void backtrackPaths(int[][] graph, int index, List<Integer> path,List<List<Integer>> result,int target) {



        if(index==target){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<graph[index].length;i++) {
             int neibour=graph[index][i];
             path.add(neibour);
             backtrackPaths(graph, neibour, path, result,target);
             path.remove(path.size()-1);

        }

    }

    /*
    *backtrack("abab", start=0, seen={})
├── Pick "a" (seen={a})
│   └── backtrack(start=1)
│       ├── Pick "b" (seen={a, b})
│       │   └── backtrack(start=2)
│       │       ├── Pick "a" ❌ already in seen
│       │       ├── Pick "ab" (seen={a, b, ab})
│       │       │   └── backtrack(start=4) ✅ return 0
│       │       └── return 1 (from 1 + 0)
│       ├── Pick "ba" (seen={a, ba})
│       │   └── backtrack(start=3)
│       │       ├── Pick "b" (seen={a, ba, b})
│       │       │   └── backtrack(start=4) ✅ return 0
│       │       └── return 1
│       ├── Pick "bab" (seen={a, bab})
│       │   └── backtrack(start=4) ✅ return 0
│       └── return max of above = 2
├── Pick "ab" (seen={ab})
│   └── backtrack(start=2)
│       ├── Pick "a" (seen={ab, a})
│       │   └── backtrack(start=3)
│       │       ├── Pick "b" (seen={ab, a, b}) ✅ return 0
│       │       └── return 1
│       ├── Pick "ab" ❌ already in seen
│       └── return 2
├── Pick "aba" (seen={aba})
│   └── backtrack(start=3)
│       ├── Pick "b" (seen={aba, b}) ✅ return 0
│       └── return 1
├── Pick "abab" (seen={abab}) → ✅ return 0

    * */

// Split a String Into the Max Number of Unique Substrings
    public static int maxUniqueSplit(String s) {
        Set<String> sets=new HashSet<>();

        // Replace the following placeholder return statement with your code
        return backTrackUuniqeSplit(s,0,sets);
    }

    private static int backTrackUuniqeSplit(String str, int start,  Set<String> sets) {
        if(start==str.length()){
            return 0;
        }

        int count=0;
        for(int end=start+1;end<=str.length();end++){
            String subString=str.substring(start,end);
            if(!sets.contains(subString)){
                sets.add(subString);
                count = Math.max(count,1+ backTrackUuniqeSplit(str, end, sets));
                sets.remove(subString);
            }

        }

        return count;
    }


    // Optimal Account Balancing

/*
* dfs(current = 0, balance = [5, -10, 5])
└── Try settling current(0)=5 with next(1)=-10
    ├── Update: balance[1] += 5 → -5
    ├── New balance: [5, -5, 5]
    └── dfs(current = 1)
        └── Skip current=1 (balance=-5 still)
        └── current=1
            └── Try next(2)=5
                ├── Update: balance[2] += -5 → 0
                ├── New balance: [5, -5, 0]
                └── dfs(current = 2)
                    └── Skip current=2 (balance=0)
                    └── current=3 → ✅ All settled → return 2 moves
                └── Backtrack: balance[2] -= -5 → 5
        └── Backtrack: balance[1] -= 5 → -10

*
* dfs(current = 0, balance = [5, -10, 5])
└── Try settling current(0)=5 with next(2)=5 ❌ (same sign) → skip

* */
    public static int minTransfers(int[][] transactions) {

        // Replace this placeholder return statement with your code
        Map<Integer,Integer> balanceMap=new HashMap<>();
        for(int[] transaction:transactions){
            int from=transaction[0];
            int to=transaction[1];
            int amount=transaction[2];
            balanceMap.put(from,balanceMap.getOrDefault(from,0)- amount);
            balanceMap.put(to,balanceMap.getOrDefault(to,0)+ amount);

        }


        List<Integer> balanceList=new ArrayList<>();
        for(int amount: balanceMap.values()){
            if(amount!=0){
                balanceList.add(amount);
            }

        }

        int[] balance=new int[balanceList.size()];


        for(int i=0;i<balanceList.size();i++){
            balance[i]=balanceList.get(i);
        }


        int n=balance.length;
        return bacKTrackBalamnce(0,n,balance);
    }

    private static int bacKTrackBalamnce(int current, int size, int[] balance) {

        if(current<size && balance[current]==0){
            current++;
        }

        if(current==size){
            return 0;
        }

        int cost=Integer.MAX_VALUE;

        for(int next=current+1;next<size;next++){
            if(balance[current]*balance[next]<0){
                balance[next]+=balance[current];
                cost=Math.min(cost,1+bacKTrackBalamnce(current+1,size,balance));
                balance[next]-=balance[current];

            }

        }
        return cost;
    }


//Binary Watch

    /*

    Position: 0, Hours: 0, Minutes: 0, LEDs left: 2
│
├── Turn ON LED 0 (hour += 1)
│   └── binaryWatchRec(1, 1, 0, 1)
│       ├── Turn ON LED 1 (hour += 2)
│       │   └── binaryWatchRec(2, 3, 0, 0)
│       │       └── ✅ Base case → add "3:00"
│       ├── Turn ON LED 2 (hour += 4)
│       │   └── binaryWatchRec(3, 5, 0, 0)
│       │       └── ✅ Add "5:00"
│       ├── Turn ON LED 4 (minute += 1)
│       │   └── binaryWatchRec(5, 1, 1, 0)
│       │       └── ✅ Add "1:01"
│       └── etc...
│
├── Turn ON LED 1 (hour += 2)
│   └── binaryWatchRec(2, 2, 0, 1)
│       ├── Turn ON LED 2 → binaryWatchRec(3, 6, 0, 0)
│       │   └── ✅ Add "6:00"
│       ├── Turn ON LED 5 → binaryWatchRec(6, 2, 2, 0)
│       │   └── ✅ Add "2:02"
│       └── etc...
│
├── Turn ON LED 4 (minute += 1)
│   └── binaryWatchRec(5, 0, 1, 1)
│       ├── Turn ON LED 0 (hour += 1) → binaryWatchRec(1, 1, 1, 0)
│       │   └── ✅ Add "1:01"
│       └── Turn ON LED 5 (minute += 2) → binaryWatchRec(6, 0, 3, 0)
│           └── ✅ Add "0:03"
│
└── ... (continues for all 10 positions)

     */

    public static List<String> readBinaryWatch(int enabled) {

        // Replace this placeholder return statement with your code
        List<String> result=new ArrayList<>();
        backTrackWatch(0,0,0,enabled,result);

        return result;
    }

    private static void backTrackWatch(int hours, int mins, int possition, int enabled, List<String> result) {

        if(enabled==0){
            if(hours<=11 && mins<=59){
                String time=hours+":"+(mins<10?"0":"")+mins;
                result.add(time);
            }
        }

        for(int i=possition;i<10;i++){
            int h=hours;
            int m=mins;

            if(i<=3){
                hours+=(int)Math.pow(2,i);
            }else{
                mins+=(int)Math.pow(2,i-4);
            }


            backTrackWatch(hours,mins,i+1,enabled-1,result);

            hours=h;
            mins=m;

        }

    }


    public static void printGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.print("\t\t[");
            for (int j = 0; j < grid[0].length; j++) {
                if (j < grid[0].length - 1)
                    System.out.print("'" + grid[i][j] + "', ");
                else
                    System.out.print("'" + grid[i][j] + "'");
            }
            System.out.println("]");
        }
        System.out.println("\n");

    }

    public static List<String> binaryTreePaths(TreeNode<Integer> root) {

        List<String> finalResult=new ArrayList<>();
        backTrackTree(root,"",finalResult);
        return finalResult;
    }

    private static void backTrackTree(TreeNode<Integer> root, String sb, List<String> finalResult) {
        if(root!=null) {

            sb+=root.value;
            if(root.left==null && root.right==null){
                finalResult.add(sb.toString());
            }else{
                sb+="->";
                backTrackTree(root.left,sb,finalResult);
                backTrackTree(root.right,sb,finalResult);
            }
        }

    }


    private static void draw2DArray(int[][] grid) {
        for (int[] row : grid) {
            System.out.print("\t| ");
            for (int cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println();
        }
    }

    // Minimum Moves to Spread Stones Over Grid


    public static int minimumMoves(int[][] grid) {
        int total=0;
        for(int[] row:grid){
            for(int col:row){
                total+=col;
            }
        }
        if(total!=9){
            return -1;
        }
        List<int []> extras=new ArrayList<>();
        List<int []> zeros=new ArrayList<>();


        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    zeros.add(new int[]{i,j});
                }else if (grid[i][j] > 1) {
                    extras.add(new int[]{i,j,grid[i][j]-1});
                }
            }
          }

        if(zeros.size()==0){
            return 0;
        }
        return solve(extras,zeros,0,0);
    }

    private static int solve(List<int[]> extras, List<int[]> zeros, int index, int count) {
        if(index>=zeros.size()){
            return count;
        }
        int minMoves = Integer.MAX_VALUE;

        for(int i=0;i<extras.size();i++){
            if(extras.get(i)[2]!=0){
                extras.get(i)[2]--;
                int dis=Math.abs(extras.get(i)[0]-zeros.get(index)[0])+Math.abs(extras.get(i)[1]-zeros.get(index)[1]);
                int result=solve(extras,zeros,index+1,dis+count);
                minMoves = Math.min(result,minMoves);
                extras.get(i)[2]++;
            }

        }
        return minMoves;
    }

    // flood fill

    public static void dfs(int[][] grid, int row, int col, int oldTarget, int newTarget) {
        int gridLength = grid.length;
        int totalCells = grid[0].length;

        // Base case
        if (row < 0 || col < 0 || row >= gridLength || col >= totalCells || grid[row][col] != oldTarget) {
            return;
        }

        // Paint the current cell
        grid[row][col] = newTarget;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] dir : directions) {
            dfs(grid, row + dir[0], col + dir[1], oldTarget, newTarget);
        }
    }

    public static int[][] floodFill(int[][] grid, int sr, int sc, int target) {
        int oldTarget = grid[sr][sc];
        if (oldTarget != target) {
            dfs(grid, sr, sc, oldTarget, target);
        }
        return grid;
    }

    public static boolean isValid(String segment){
        int m=segment.length();
        if(m>3)
            return false;
        return segment.charAt(0)!='0'?(Integer.valueOf(segment)<=255):(m==1);
    }

    public static void updateSegment(int curDot, LinkedList<String> segments, List<String> result,String str){
        int size=str.length();

        String segment=str.substring(curDot+1,size);
        if(isValid(segment)){
            segments.add(segment);
            String ip=String.join(".",segments);
            result.add(ip);
            segments.removeLast();
        }
    }

    // Restore IP Addresses
    public static List<String> restoreIpAddresses(String s) {
        int size=s.length();
        LinkedList<String> segments=new LinkedList<>();
        List<String> results=new ArrayList<>();

        backTrackIp(-1,3,s,segments,results,size);
        // Replace this placeholder return statement with your code
        return results;
    }

    private static void backTrackIp(int prevDot, int dots, String str, LinkedList<String> segments, List<String> results, int size) {

        int maxPos=Math.min(size-1,prevDot+4);
        for(int curDot=prevDot+1;curDot<maxPos;curDot++){
            String segment=str.substring(prevDot+1,curDot+1);
            if(isValid(segment)){
                segments.add(segment);

                if (dots - 1 == 0) {
                    updateSegment(curDot,segments,results,str);
                }else {
                    backTrackIp(curDot, dots - 1, str, segments, results, size);
                }
                segments.removeLast();
            }
        }

    }

    // House Robber III
    public static int rob(TreeNode<Integer> root) {
        int[] result=heist(root);

        // Replace this placeholder return statement with your code
        return Math.max(result[0],result[1]);
    }

    private static int[] heist(TreeNode<Integer> root) {

        if(root==null){
            return new int[]{0,0};
        }
        int leftSubtree[]=heist(root.left);
        int rightSubTree[]=heist(root.right);

        int includeRoot= root.value+leftSubtree[1]+rightSubTree[1];
        int excludeRoot= Math.max(leftSubtree[0],leftSubtree[1])+Math.max(rightSubTree[1],rightSubTree[0]);

        return new int[]{includeRoot,excludeRoot};


    }

    // N-Queens II

    public static int totalNQueens(int n) {


        // Replace this placeholder return statement with your code
        return  backtrackTotalNQueens(n,0,new HashSet<>(),new HashSet<>(),new HashSet<>());
    }

// Word Search
    public static boolean wordSearch(char[][] grid, String word) {

        // Replace this placeholder return statement with your code

        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(backtrackWordSearch(row,col,word,0,grid)) {
                    return true;
                }
            }

        }

        return  false;
    }

    public static boolean backtrackWordSearch(int row, int col,String word,int index,char[][] grid){

        if(word.length()==index){
            return true;
        }

        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || word.charAt(index)!=grid[row][col]){
            return false;
        }

        char temp=grid[row][col];
        grid[row][col]='*';

        int[][] offset=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        boolean result=false;
        for(int i=0;i<offset.length;i++){
            result = backtrackWordSearch(row+offset[i][0],col+offset[i][1],word,i+1,grid);
            if(result)
                break;

        }
        grid[row][col]=temp;


        return result;
    }



    public static int backtrackTotalNQueens(int size,int row,Set<Integer> cols, Set<Integer> daignols, Set<Integer> antiDaigonals ){

        if(size==row){
            return 1;
        }

        int solutions=0;

        for(int col=0;col<size;col++){

            if(cols.contains(col) || daignols.contains(row-col) || antiDaigonals.contains(row+col)){
                continue;
            }
            cols.add(col);
            daignols.add(row-col);
            antiDaigonals.add(row+col);


            solutions+=backtrackTotalNQueens(size,row+1,cols,daignols,antiDaigonals);

            cols.remove(col);
            daignols.remove(row-col);
            antiDaigonals.remove(row+col);



        }
        return solutions;
    }



}
