package ravi.algo.concepts;
import jdk.jshell.execution.JdiDefaultExecutionControl;

import java.util.*;
import java.util.LinkedList;

public class Matrix {
    public static void main(String[] args) {

        //    Set Matrix Zeroes

        int[][][] mat = {
                {{1, 1, 0}, {1, 0, 1}, {1, 1, 1}},
                {{1, 1, 1, 1, 1}, {0, 0, 1, 1, 1}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}},
                {{3, 5, 2, 0}, {1, 0, 4, 6}, {7, 3, 2, 4}},
                {{1, 2, 3, 4}, {4, 5, 6, 7}, {8, 9, 4, 6}},
                {{2, 6, 5, 4, 9, 1}, {7, 2, 0, 0, 5, 4}, {1, 1, 1, 1, 0, 1}, {9, 8, 2, 0, 1, 3}, {7, 8, 6, 5, 4, 3}, {9, 8, 1, 2, 5, 6}}
        };

        for (int i = 0; i < mat.length; i++) {
            System.out.println((i + 1) + ". \tOriginal Matrix:");
            // Print.printMatrix(mat[is]);
            int[][] result = setMatrixZeros(mat[i]);
            System.out.println("\n\tMatrix with Zeroes:");
            //Print.printMatrix(result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Rotate Image


        int[][][] inputs = {
                {{1}},
                {{6, 9}, {2, 7}},
                {{2, 14, 8}, {12, 7, 14}, {3, 3, 7}},
                {{3, 1, 1, 7}, {15, 12, 13, 13}, {4, 14, 12, 4}, {10, 5, 11, 12}},
                {{10, 1, 14, 11, 14}, {13, 4, 8, 2, 13}, {10, 19, 1, 6, 8}, {20, 10, 8, 2, 12}, {15, 6, 8, 8, 18}}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tMatrix:");
            //    Print.printMatrix(inputs[is]);

            System.out.println("\n\tRotated matrix:");
            //    Print.printMatrix(rotateImage(inputs[is]));

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[][][] inputsS = {
                {{1}},
                {{6}, {2}},
                {{2, 14, 8}, {12, 7, 14}},
                {{3, 1, 1}, {15, 12, 13}, {4, 14, 12}, {10, 5, 11}},
                {{10, 1, 14, 11, 14}, {13, 4, 8, 2, 13}, {10, 19, 1, 6, 8}, {20, 10, 8, 2, 12}, {15, 6, 8, 8, 18}}
        };

        for (int i = 0; i < inputsS.length; i++) {
            System.out.println((i + 1) + ".\tMatrix:");
            //Print.printMatrix(inputsS[is]);

            System.out.println("\n\tSpiral order: " + spiralOrder(inputsS[i]));

            System.out.println();
            //System.out.println(Print.repeat("-", 100));
        }

        int[][][] grids = {
                {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}},
                {{1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1}, {-1, -1, 1, -1, -1, 1, -1, -1, 1, -1, -1, 1}, {1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1}, {-1, -1, -1, 1, 1, -1, -1, -1, -1, 1, 1, -1}},
                {{-1, -1, -1, -1}, {1, 1, 1, 1}, {-1, -1, -1, -1}, {1, 1, 1, 1}},
                {{1}},
                {{-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}}
        };

        for (int i = 0; i < grids.length; i++) {
            System.out.println("Test Case #" + (i + 1) + "\n\nInput grid:");
            printMatrix(grids[i]);
            int[] output = findExitColumn(grids[i]);
            System.out.print("\nOutput: " + Arrays.toString(output));
            System.out.println("\n" + new String(new char[100]).replace('\0', '-'));
        }
// transpose


        /// = Count Negative Numbers in a Sorted Matrix

        int[][][] inputList = {
                {{10, 5, 2, -1}, {6, 3, -2, -4}, {4, 1, -3, -6}, {-1, -2, -5, -7}},
                {{7, 3, 1, -2}, {6, 2, -1, -3}, {4, 1, -2, -5}, {2, 0, -4, -6}},
                {{12, 9, 5, 2}, {8, 6, 4, 1}, {7, 5, 3, 0}, {4, 2, 0, -3}},
                {{-10, -11, -12, -13}, {-20, -21, -22, -23}, {-30, -31, -32, -33}, {-40, -41, -42, -43}},
                {{5, 3, -2, -3}, {4, 2, -3, -4}, {3, 1, -4, -5}, {2, 0, -5, -6}}
        };

        for (int i = 0; i < inputList.length; i++) {
            int[][] grid = inputList[i];
            int result = countNegatives(grid);

            System.out.print((i + 1) + ".\tInput: grid = ");
            System.out.print("[");
            for (int r = 0; r < grid.length; r++) {
                if (r > 0) {
                    System.out.print(", ");
                }
                System.out.print("[");
                for (int c = 0; c < grid[r].length; c++) {
                    if (c > 0) {
                        System.out.print(", ");
                    }
                    System.out.print(grid[r][c]);
                }
                System.out.print("]");
            }
            System.out.println("]");

            System.out.println("\tCount of Negative Numbers: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        List<List<List<String>>> lands = Arrays.asList(
                Arrays.asList(Arrays.asList(".", ".", ".", "X", "*"), Arrays.asList("S", "X", ".", ".", "X"), Arrays.asList(".", ".", "X", ".", "*"), Arrays.asList("D", ".", "*", ".", "*")),
                Arrays.asList(Arrays.asList("X", ".", "S", "X", ".", "D"), Arrays.asList(".", "*", ".", ".", "*", "."), Arrays.asList(".", ".", ".", "*", ".", ".")),
                Arrays.asList(Arrays.asList("S", ".", ".", "X", "X", ".", "X", "X"), Arrays.asList(".", ".", "X", ".", ".", ".", "X", "*"), Arrays.asList(".", ".", ".", ".", "D", ".", ".", "X")),
                Arrays.asList(Arrays.asList("*", "S", ".", "*", ".", "."), Arrays.asList(".", "X", "*", "*", ".", "."), Arrays.asList("D", ".", ".", ".", ".", ".")),
                Arrays.asList(Arrays.asList("X", ".", "*", "X", ".", "D"), Arrays.asList(".", "X", "*", ".", ".", "."), Arrays.asList("X", ".", "*", ".", ".", "."), Arrays.asList(".", "X", "*", ".", ".", "S"))
        );

        for (int i = 0; i < lands.size(); i++) {
            System.out.println((i + 1) + ".\tLand:");
            for (List<String> row : lands.get(i)) {
                System.out.println("\t  " + row);
            }
            System.out.println("\n\tNumber of second(s) to reach the destination: " + minimumSeconds(lands.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // Smallest Rectangle Enclosing Black Pixels
        List<Object[]> testCases = Arrays.asList(
                new Object[]{new char[][]{{'0', '0', '1', '0'}, {'0', '1', '1', '0'}, {'0', '0', '1', '0'}}, 1, 2},
                new Object[]{new char[][]{{'0', '0', '0', '0'}, {'0', '1', '1', '1'}, {'0', '1', '1', '1'}, {'0', '1', '1', '1'}, {'0', '0', '0', '0'}}, 2, 1},
                new Object[]{new char[][]{{'0', '0', '0', '0'}, {'0', '1', '0', '0'}, {'1', '1', '1', '0'}, {'0', '0', '0', '0'}}, 2, 1},
                new Object[]{new char[][]{{'1', '0', '0', '0'}, {'0', '1', '0', '0'}, {'0', '0', '1', '0'}, {'0', '0', '0', '1'}}, 1, 1},
                new Object[]{new char[][]{{'0', '1', '0', '0', '0'}, {'1', '1', '1', '0', '0'}, {'0', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}, 1, 2}
        );

        for (int i = 0; i < testCases.size(); i++) {
            Object[] testCase = testCases.get(i);
            char[][] image = (char[][]) testCase[0];
            int x = (int) testCase[1];
            int y = (int) testCase[2];

            System.out.println((i + 1) + ".\t");
            printImage(image);
            System.out.println("\tCoordinates: x = " + x + ", y = " + y);
            int area = minArea(image, x, y);
            System.out.println("\n\tThe area of the smallest enclosing rectangle is: " + area);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        int[][][] testCasesS = {
                {
                        {0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0}
                },
                {
                        {1}
                },
                {
                        {1, 0},
                        {0, 1}
                },
                {
                        {1, 1}
                },
                {
                        {1, 0, 0, 1}
                }
        };

        for (int i = 0; i < testCasesS.length; i++) {
            int[][] grid = testCasesS[i];
            System.out.println((i + 1) + ".\tGrid:" + Arrays.deepToString(grid));
            int perimeter = islandPerimeter(grid);
            System.out.println("\n\tPerimeter: " + perimeter);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Convert 1D Array Into 2D Array

        Object[][] testCasesN = {
                {new int[]{1, 2, 3, 4}, 2, 2},
                {new int[]{1, 2, 3}, 1, 3},
                {new int[]{1, 2, 3, 4, 5}, 2, 3},
                {new int[]{10, 20, 30, 40}, 4, 1},
                {new int[]{7, 8, 9, 10, 11, 12}, 2, 3}
        };

        int i = 0;
        for (Object[] testCase : testCasesN) {
            int[] original = (int[]) testCase[0];
            int m = (int) testCase[1];
            int n = (int) testCase[2];

            System.out.println((i + 1) + ".\toriginal: " + Arrays.toString(original) + ", m: " + m + ", n: " + n);

            int[][] result = construct2DArray(original, m, n);

            System.out.println("\n\tConstructed 2D Array:");
            if (result.length > 0) {
                for (int[] row : result) {
                    System.out.println("\t" + Arrays.toString(row));
                }
            } else {
                System.out.println("\t[]");
            }
            System.out.println(new String(new char[100]).replace("\0", "-"));
            i++;
        }

// Spiral Matrix II

        int[] ns = {1, 2, 3, 4, 5};

        int is = 0;
        for (int n : ns) {
            System.out.println((is + 1) + ".\tn: " + n);
            int[][] result = generateMatrix(n);
            System.out.println("\n\tSpiral Matrix:");

            for (int[] row : result) {
                System.out.print("\t[[ ");
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println("]]");
            }
            System.out.println(new String(new char[100]).replace("\0", "-"));
            is++;
        }

        int[][][] matrices = {
                {{0, 1}, {1, 0}},
                {{0, 0}, {1, 1}},
                {{0}, {1}, {0}},
                {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}},
                {{1, 0}, {1, 1}, {0, 0}, {1, 0}}
        };

        for (int it = 0; it < matrices.length; it++) {
            System.out.print((it + 1) + ".\tmatrix: [");
            for (int j = 0; j < matrices[it].length; j++) {
                System.out.print("[");
                for (int k = 0; k < matrices[it][j].length; k++) {
                    System.out.print(matrices[it][j][k]);
                    if (k < matrices[it][j].length - 1)
                        System.out.print(", ");
                }
                System.out.print("]");
                if (j < matrices[it].length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");


            System.out.println("\tMaximum number of rows: " + maxEqualRowsAfterFlips(matrices[it]));
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }

//Number of Spaces Cleaning Robot Cleaned

        int[][][] testCases2 = {
                {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}},
                {{0, 1}, {0, 0}},
                {{0, 0, 0, 0}, {1, 1, 1, 0}},
                {{0, 0}, {0, 0}},
                {{0, 1, 1}, {1, 0, 1}, {1, 1, 1}},
                {{0, 0, 1, 0, 0, 0, 1, 0},
                        {0, 1, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 1, 0},
                        {1, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 1}},
                {{0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
                        {0, 1, 1, 0, 1, 1, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
                        {0, 1, 0, 1, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1, 0, 0, 1, 1, 0},
                        {0, 1, 0, 0, 0, 1, 0, 0, 0, 0}}
        };

        for (int itrn = 0; itrn < testCases2.length; itrn++) {
            System.out.println((itrn + 1) + ".\tInput room:");
            for (int[] row : testCases2[itrn]) {
                System.out.println("\t" + Arrays.toString(row));
            }
            int[][] roomCopy = Arrays.stream(testCases2[itrn]).map(int[]::clone).toArray(int[][]::new);
            int result = numberOfCleanRooms(roomCopy);
            System.out.println("\n\tOutput: " + result);
            System.out.println("-" + new String(new char[100]).replace('\0', '-') + "\n");
        }

    }

// Number of Spaces Cleaning Robot Cleaned
    public static int numberOfCleanRooms(int[][] room) {

        // Replace this placeholder return statement with your code
        return -1;
    }



    //Flip Columns For Maximum Number of Equal Rows
    public static int maxEqualRowsAfterFlips(int[][] matrix) {

        Map<String,Integer> map=new HashMap<>();
        for(int[] row:matrix){
            StringBuilder stringBuilder=new StringBuilder();
            for(int i=0;i<row.length;i++){
                    if(row[i]==row[0]){
                        stringBuilder.append("T");
                    }else{
                        stringBuilder.append("F");
                    }
            }
            String str=stringBuilder.toString();
            map.put(str,map.getOrDefault(str,0)+1);

        }
        int max=0;
        for(String key:map.keySet()){
            max=Math.max(max,map.get(key));
        }

        // Replace this placeholder return statement with your code
        return max;
    }

    // Spiral Matrix II
    public static int[][] generateMatrixIdeal(int n) {

        int[][] result=new int[n][n];
        int count=1;

        for(int layer=0;layer<(n+1)/2;layer++){

            for(int i=layer;i<n-layer;i++){
                result[layer][i]=count;
                count++;
            }

            for(int i=layer+1;i<n-layer;i++){
                result[i][n-layer-1]=count;
                count++;
            }

            for(int i=n-layer-2;i>=layer;i--){
                result[n-layer-1][i]    =count;
                count++;
            }


            for(int i=n-layer-2;i>layer;i--){
                result[i][layer]=count;
                count++;
            }

        }
        return result;

    }



// Spiral Matrix II
    public static int[][] generateMatrix(int n)
    {
        // Replace this placeholder return statement with your code
        int[][] result=new int[n][n];
        int direction=1;
        int rows=n;
        int cols=n;
        int val=0;
        int row=0;
        int col=-1;

        while (rows > 0 && cols > 0) {

            for(int j=0;j<cols;j++){
                col+= direction;
                result[row][col]=++val;
            }
            rows--;
            for(int j=0;j<rows;j++){
                row+= direction;
                result[row][col]=++val;
            }
            cols--;

            direction*=-1;

        }


        return result;
    }


    // Convert 1D Array Into 2D Array
    public static int[][] construct2DArray(int[] original, int m, int n) {

        int[][] result=new int[m][n];
        int row=0;
        int col=0;

        if(original.length!=m*n)
            return new int[][]{};
        for(int i=0;i<original.length;i++){
            if(col==n){
                col=0;
                row+=1;

            }
            if(row<m && col<n)
                result[row][col]=original[i];


            col++;
        }

        // Replace this placeholder return statement with your code
        return result;
    }


    public static int islandPerimeter(int[][] grid) {

        int permiter=0;
        // Replace this placeholder return statement with your code

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    permiter+=4;

                    if(i>0 && grid[i-1][j]==1)
                        permiter-=2;

                    if(j>0 && grid[i][j-1]==1)
                        permiter-=2;
                }

            }

        }

        return permiter;
    }

    private static void printImage(char[][] image) {
        System.out.print("Image: [");
        for (int i = 0; i < image.length; i++) {
            System.out.print("[");
            for (int j = 0; j < image[i].length; j++) {
                System.out.print("'" + image[i][j] + "'");
                if (j < image[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (i < image.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Smallest Rectangle Enclosing Black Pixels
    public static int minArea(char[][] image, int x, int y) {
        int left = binarySearchA(0, y, mid -> containsBlackPixelInColumn(image, mid));
        int right = binarySearchA(y + 1, image[0].length, mid -> !containsBlackPixelInColumn(image, mid)) - 1;
        int top = binarySearchA(0, x, mid -> containsBlackPixelInRow(image, mid));
        int bottom = binarySearchA(x + 1, image.length, mid -> !containsBlackPixelInRow(image, mid)) - 1;

        return (right - left + 1) * (bottom - top + 1);
    }

    private static boolean containsBlackPixelInRow(char[][] image, int mid) {

        for(char c:image[mid]){
            if(c=='1'){
                return true;
            }
        }
        return false;
    }

    private static boolean containsBlackPixelInColumn(char[][] image, int mid) {

        for(char[] rows:image){
            if(rows[mid]=='1'){
                return true;
            }
        }
        return false;
    }

    private static int binarySearchA(int left, int right, java.util.function.Predicate<Integer> checkFunc) {
        while(left<right){
            int mid=left+(right-left)/2;
            if(checkFunc.test(mid)){
                right=mid;
            }else{
                left=mid+1;
            }


        }
        return left;

    }


    // Minimum Time Takes to Reach Destination Without Drowning

    public static int minimumSeconds(List<List<String>> land) {
        int m = land.size();
        int n = land.get(0).size();
        Queue<int[]> flood=new LinkedList<>();
        Queue<int[]> move=new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String cell=land.get(i).get(j);
                if(cell.equals("S")){
                    move.add(new int[]{i,j});
                }
                if(cell.equals("*")){
                    flood.add(new int[]{i,j});
                }
            }

        }

        int second=0;
        int[][] distance=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        while(!move.isEmpty()){
            int fsize = flood.size();
            int msize = move.size();
            for(int i=0;i<fsize;i++){
                int[] nfloods=flood.poll();
                int x_Flood=nfloods[0];
                int y_Flood=nfloods[1];


                for(int[] dist:distance){
                    int x_new_Flood=x_Flood+dist[0];
                    int y_new_Flood=y_Flood+dist[1];
                    if(x_new_Flood>=0 && x_new_Flood<m && y_new_Flood>=0 && y_new_Flood<n && land.get(x_new_Flood).get(y_new_Flood).equals(".")){
                            land.get(x_new_Flood).set(y_new_Flood,"*");
                        flood.add(new int[]{x_new_Flood,y_new_Flood});
                    }
                }
            }


            for(int i=0;i<msize;i++){
                int[] nMovie=move.poll();
                int x_move=nMovie[0];
                int y_move=nMovie[1];
                if(land.get(x_move).get(y_move).equals("D")){
                    return second;
                }
                for(int[] dist:distance){

                    int x_new_movie=x_move+dist[0];
                    int y_new_movie=y_move+dist[1];


                    if(x_new_movie>=0 && x_new_movie<m && y_new_movie>=0 && y_new_movie<n && (land.get(x_new_movie).get(y_new_movie).equals(".") || land.get(x_new_movie).get(y_new_movie).equals("D"))) {
                        if(!land.get(x_new_movie).get(y_new_movie).equals("D")){
                            land.get(x_new_movie).set(y_new_movie,"*");
                        }
                        move.offer(new int[]{x_new_movie,y_new_movie});

                    }
                }
            }
            second++;
        }
        return -1;
    }

   // Count Negative Numbers in a Sorted Matrix -- when row and colum wise sorted
    public static int countNegativesSorted(int[][] grid) {

        int count=0;
        int m=grid[0].length;
        int currentIndex=m-1;
        for(int[] row:grid) {

            while(currentIndex>=0 && row[currentIndex]<0){
                currentIndex--;
            }
            count+=m-currentIndex-1;


        }


        // Replace this placeholder return statement with your code
        return count;
    }




// Count Negative Numbers in a Sorted Matrix
    public static int countNegatives(int[][] grid) {

        int count=0;
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++){
            int target=0;
            int left=0;
            int right=m-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(grid[i][mid]>=target){
                    left=mid+1;
                }else{
                    right=mid;
                }

            }

            count+=m-left;


        }
        // Replace this placeholder return statement with your code
        return count;
    }


    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }



// transpose
    public static int[][] transposeMatrix(int[][] matrix) {

        int rowSize=matrix.length;
        int colSize=matrix[0].length;
        int[][] result=new int[colSize][rowSize];
        for(int row=0;row<rowSize;row++){
            for(int col=0;col<colSize;col++){
                result[col][row]=matrix[row][col];
            }
        }
        // Replace this placeholder return statement with your code
        return result;
    }

    // Where Will the Ball Fall
    public static int[] findExitColumn(int[][] grid) {

        int[] result=new int[grid[0].length];
         Arrays.fill(result,-1);

        for(int col=0;col<grid[0].length;col++){
            int currentCol=col;
            for(int row=0;row<grid.length;row++){
                int nextCol=currentCol+grid[row][currentCol];

                if(nextCol<0 || nextCol> grid[0].length-1 || grid[row][currentCol]!=grid[row][nextCol])
                    break;

                if(row== grid.length-1){
                    result[col]=nextCol;
                }
                currentCol=nextCol;
            }
        }
        // Replace this placeholder return statement with your code
        return result;
    }

    // Rotate Image
    public static int[][] rotateImage(int[][] matrix) {
        int n=matrix.length;
        for(int row=0;row<n/2;row++){
            for(int col=row;col< (n-row-1);col++){
                int temp=matrix[row][col];
                matrix[row][col]=matrix[col][n-1-row];
                matrix[col][n-1-row]=temp;

                int temp1=matrix[row][col];
                matrix[row][col]=matrix[n-1-row][n-1-col];
                matrix[n-1-row][n-1-col]=temp1;


                int temp2=matrix[row][col];
                matrix[row][col]=matrix[n-1-col][row];
                matrix[n-1-col][row]=temp2;

            }

/*
🔹 Quick mnemonic to remember

Clockwise rotation: (row, col) → (col, n-1-row)

Anti-clockwise rotation: (row, col) → (n-1-col, row)
 */
        }

        // Replace this placeholder return statement with your code
        return matrix;
    }

// Spiral Matrix

    public static List<Integer> spiralOrder(int[][] matrix) {

        // Replace this placeholder return statement with your code

        List<Integer> result=new ArrayList<>();
        int rows=matrix.length;
        int cols=matrix[0].length;
        int col=-1;
        int row=0;
        int direction=1;

        while(rows>0 && cols>0){

            for(int i=0;i<cols;i++){
                col+=direction;
                result.add(matrix[row][col]);
            }

            rows--;

            for(int i=0;i<rows;i++){
                row+=direction;
                result.add(matrix[row][col]);
            }
            cols--;

            direction*=-1;
        }



        return result;



    }

    //



    // Set Matrix Zeroes

    public static int[][] setMatrixZeros(int[][] mat) {
        //
        boolean frow=false;
        boolean fcol=false;
        int rl=mat.length;
        int cl=mat[0].length;

        for(int i=0;i<rl;i++){
            if(mat[i][0]==0){
                fcol=true;
                break;
            }
        }

        for(int i=0;i<cl;i++){
            if(mat[0][i]==0){
                frow=true;
            }
        }

        for(int i=1;i<rl;i++){
            for(int j=1;j<cl;j++){
                if(mat[i][j]==0){
                    mat[i][0]=0;
                    mat[0][j]=0;
                }
            }
        }

        for(int i=1;i<rl;i++){
            if(mat[i][0]==0){
                Arrays.fill(mat[i],0);
            }
        }

        for(int i=1;i<cl;i++){
            if(mat[0][i]==0){
                for(int j=1;j<rl;j++)
                    mat[j][i]=0;
            }
        }


        if(frow){
            Arrays.fill(mat[0],0);
        }

        if(fcol){
            for(int i=0;i<rl;i++){
                mat[i][0]=0;
            }

        }

        return mat;
    }

}
