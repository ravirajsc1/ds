package ravi.algo.concepts;

import java.util.*;

public class TreeDFS {

    private static final String MARKER = "M";
    private static int m = 1;
    TreeNode<Integer> prev=null;


    public static void main(String[] args) {
        // Create a list of list of TreeNode objects to represent binary trees
        List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(3), new TreeNode<Integer>(2), new TreeNode<Integer>(17), new TreeNode<Integer>(1), new TreeNode<Integer>(4), new TreeNode<Integer>(19), new TreeNode<Integer>(5)),
                Arrays.asList(new TreeNode<Integer>(7), new TreeNode<Integer>(6), new TreeNode<Integer>(5), new TreeNode<Integer>(4), new TreeNode<Integer>(3), new TreeNode<Integer>(2), null, new TreeNode<Integer>(1)),
                Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(4), new TreeNode<Integer>(6), new TreeNode<Integer>(3), new TreeNode<Integer>(2), new TreeNode<Integer>(7), new TreeNode<Integer>(8), new TreeNode<Integer>(1), new TreeNode<Integer>(9)),
                Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(2), new TreeNode<Integer>(1), new TreeNode<Integer>(6), new TreeNode<Integer>(10), new TreeNode<Integer>(11), new TreeNode<Integer>(44)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(5), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(6)),
                Arrays.asList(new TreeNode<Integer>(-1), new TreeNode<Integer>(-2), null, new TreeNode<Integer>(-5), new TreeNode<Integer>(1), new TreeNode<Integer>(2), null, new TreeNode<Integer>(-6))
        );

        // Create the binary trees using the BinaryTree class
        List<BinaryTree<Integer>> inputTrees = new ArrayList<BinaryTree<Integer>>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTrees) {
            BinaryTree<Integer> tree = new BinaryTree<Integer>(ListOfNodes);
            inputTrees.add(tree);
        }

        // Print the input trees
        int x = 1;
        for (BinaryTree<Integer> tree : inputTrees) {
            System.out.println(x + ".\tBinary tree:");
          //  Print.displayTree(tree.root, null);
            System.out.println("\n\tFlattened tree:");
           // Print.displayTree(flattenTree(tree.root), null);
           // Print.displayTree(flattenTree(tree.root), null);
            x++;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Diameter of Binary Tree

        List<List<TreeNode<Integer>>> lists = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(2), new TreeNode<Integer>(1), new TreeNode<Integer>(4), new TreeNode<Integer>(3), new TreeNode<Integer>(5), new TreeNode<Integer>(6), new TreeNode<Integer>(7)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(5), new TreeNode<Integer>(6), new TreeNode<Integer>(7), new TreeNode<Integer>(8), new TreeNode<Integer>(9)),
                Arrays.asList(new TreeNode<Integer>(45), new TreeNode<Integer>(32), new TreeNode<Integer>(23), new TreeNode<Integer>(21), new TreeNode<Integer>(19), new TreeNode<Integer>(18), new TreeNode<Integer>(1)),
                Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(6), new TreeNode<Integer>(7), new TreeNode<Integer>(8), new TreeNode<Integer>(9)),
                Arrays.asList(new TreeNode<Integer>(9), new TreeNode<Integer>(7), null, null, new TreeNode<Integer>(1), new TreeNode<Integer>(8), new TreeNode<Integer>(10), null, new TreeNode<Integer>(12))
        );

        for (int i = 0; i < lists.size(); i++) {
            BinaryTree<Integer> t = new BinaryTree<Integer>(lists.get(i));
            System.out.println((i + 1) + ".\tBinary Tree");
          //  Print.displayTree(t.root);
            System.out.println(
                    "\n\tDiameter of Tree: " + diameterOfBinaryTree(t.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // Serialize and Deserialize Binary Tree

        List<List<TreeNode<Integer>>> listOfTreesSerDes = Arrays.asList(
                Arrays.asList( new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(350)),
                Arrays.asList( new TreeNode<Integer>(100), new TreeNode<Integer>(200), new TreeNode<Integer>(75), new TreeNode<Integer>(50), new TreeNode<Integer>(25), new TreeNode<Integer>(350)),
                Arrays.asList( new TreeNode<Integer>(200), new TreeNode<Integer>(350), new TreeNode<Integer>(100), new TreeNode<Integer>(25), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25)),
                Arrays.asList( new TreeNode<Integer>(25), new TreeNode<Integer>(50), new TreeNode<Integer>(75), new TreeNode<Integer>(100), new TreeNode<Integer>(200), new TreeNode<Integer>(350)),
                Arrays.asList( new TreeNode<Integer>(350), new TreeNode<Integer>(75), new TreeNode<Integer>(25), new TreeNode<Integer>(200), new TreeNode<Integer>(50), new TreeNode<Integer>(100)),
                Arrays.asList( new TreeNode<Integer>(1), null, new TreeNode<Integer>(2), null, new TreeNode<Integer>(3), null, new TreeNode<Integer>(4), null, new TreeNode<Integer>(5)),
                Arrays.asList()
        );

        List<BinaryTree<Integer>> inputTreesSerDes = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTreesSerDes) {
            BinaryTree<Integer> tree = new BinaryTree<>(ListOfNodes);
            inputTrees.add(tree);
        }

        int ifrist = 0;
        for (BinaryTree<Integer> tree : inputTrees) {
            if (ifrist > 0) {
                System.out.print("\n");
            }
            System.out.println((ifrist + 1) + ".\tBinary tree:");


            ifrist++;
            System.out.println("\n\tMarker used for NULL nodes in serialization/deserialization: " + MARKER);

            // Serialization
            List<String> ostream = serialize(tree.root);
            System.out.println("\n\tSerialized integer list:");
            System.out.println("\t"+ostream);

            // Deserialization
            TreeNode<Integer> deserializedRoot = deserialize(ostream);
            System.out.println("\n\tDeserialized binary tree:");

            System.out.println(new String(new char[100]).replace('\0', '-'));
            m = 1;
        }

        // Invert Binary Tree

        List<List<TreeNode<Integer>>> listOfTreesInvery = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(125), new TreeNode<Integer>(350)),
                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(110), new TreeNode<Integer>(125), new TreeNode<Integer>(350)),
                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(90), new TreeNode<Integer>(350)),
                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(200), new TreeNode<Integer>(300), new TreeNode<Integer>(400), new TreeNode<Integer>(500)),
                Arrays.asList(new TreeNode<Integer>(350), new TreeNode<Integer>(125), new TreeNode<Integer>(100), new TreeNode<Integer>(75), new TreeNode<Integer>(50), new TreeNode<Integer>(25)),
                Arrays.asList(new TreeNode<Integer>(100)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), null, new TreeNode<Integer>(3), null, new TreeNode<Integer>(4)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), new TreeNode<Integer>(4), null, null, new TreeNode<Integer>(5)),
                Arrays.asList()
        );

        List<BinaryTree<Integer>> inputTreesInvert = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTreesInvery) {
            BinaryTree<Integer> tree = new BinaryTree<>(ListOfNodes);
            inputTreesInvert.add(tree);
        }

        int i_invert = 0;
        for (BinaryTree<Integer> tree : inputTreesInvert) {
            System.out.println((i_invert + 1) + ".\tBinary Tree");
       //     Print.displayTree(tree.root);
            i_invert++;
            invertTreeSimpler(tree.root);
            System.out.println("\n\tMirrored binary tree: ");
         //   Print.displayTree(tree.root);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Binary Tree Maximum Path Sum

        List<List<TreeNode<Integer>>> listOfTreesSum = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(-8), new TreeNode<Integer>(2), new TreeNode<Integer>(17), new TreeNode<Integer>(1), new TreeNode<Integer>(4), new TreeNode<Integer>(19), new TreeNode<Integer>(5)),
                Arrays.asList(new TreeNode<Integer>(7), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(-1), new TreeNode<Integer>(-3)),
                Arrays.asList(new TreeNode<Integer>(-10), new TreeNode<Integer>(9), new TreeNode<Integer>(20), new TreeNode<Integer>(30), new TreeNode<Integer>(16), new TreeNode<Integer>(15), new TreeNode<Integer>(7)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3)),
                Arrays.asList(new TreeNode<Integer>(0)),
                Arrays.asList(new TreeNode<Integer>(-10), new TreeNode<Integer>(9), new TreeNode<Integer>(20), null, null, new TreeNode<Integer>(15), new TreeNode<Integer>(7)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(-3), new TreeNode<Integer>(3),  new TreeNode<Integer>(5), null, null, new TreeNode<Integer>(-5))
        );

        List<BinaryTree<Integer>> inputTreesSum = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTreesSum) {
            BinaryTree<Integer> tree = new BinaryTree<>(ListOfNodes);
            inputTreesSum.add(tree);
        }


        int iSum = 0;
        for (BinaryTree<Integer> tree : inputTreesSum) {
            System.out.println((iSum + 1) + ".\tBinary Tree");
        //    Print.displayTree(tree.root);
            iSum++;
            System.out.println("\n\tMaximum path sum: " + maxPathSum(tree.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Convert Sorted Array to Binary Search Tree

        int[][] nums = {
                {11, 22, 33, 44, 55, 66, 77, 88},
                {25, 50, 75, 100, 125, 350},
                {1, 2, 3},
                {1, 2, 3, 4},
                {-10, -3, 0, 5, 9},
                {1, 3}
        };

        int indx = 1;
        for (int[] inputArray : nums) {
            System.out.println(indx + ".\tSorted Array: " + Arrays.toString(inputArray));

            indx++;
            TreeNode<Integer> tr = sortedArrayToBST(inputArray);

            System.out.println("\n\tBinary search tree:");
        //    Print.displayTree(tr);

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Build Binary Tree from Preorder and Inorder Traversal

        int[][] pOrder = {
                {3, 9, 20, 15, 7},
                {-1},
                {10, 20, 40, 50, 30, 60},
                {1, 2, 4, 5, 3, 6},
                {1, 2, 4, 7, 3},
                {1, 2, 4, 8, 9, 5, 3, 6, 7}
        };

        int[][] iOrder = {
                {9, 3, 15, 20, 7},
                {-1},
                {40, 20, 50, 10, 60, 30},
                {4, 2, 5, 1, 6, 3},
                {4, 2, 7, 1, 3},
                {8, 4, 9, 2, 5, 1, 6, 3, 7}
        };

        int index = 0;
        for (int iiorder = 0; iiorder < pOrder.length; iiorder++) {
            System.out.println((index + 1) + ".\tPre order: " + Arrays.toString(pOrder[index]));
            System.out.println("\tIn order: " + Arrays.toString(iOrder[index]));
            TreeNode<Integer> tree = buildTree(pOrder[index], iOrder[index]);
            index++;
            System.out.println("\n\tBinary tree:");
         //   Print.displayTree(tree);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        // Binary Tree Right Side View

        List<List<TreeNode<Integer>>> input = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), null, null, new TreeNode<Integer>(4), new TreeNode<Integer>(5)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), null, new TreeNode<Integer>(3), null, new TreeNode<Integer>(4)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(5), new TreeNode<Integer>(6), new TreeNode<Integer>(7), new TreeNode<Integer>(8)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(5), new TreeNode<Integer>(6), null, new TreeNode<Integer>(8)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), null, new TreeNode<Integer>(3), new TreeNode<>(4))
        );

        List<BinaryTree<Integer>> inputTreesRight = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : input) {
            BinaryTree<Integer> tree = new BinaryTree<Integer>(ListOfNodes);
            inputTreesRight.add(tree);
        }

        int y = 1;
        for (BinaryTree<Integer> tree : inputTreesRight) {
            System.out.println(y++ + ". Binary tree:");
         //   Print.displayTree(tree.root);
            System.out.print("\n   Right side view: [");
            List<Integer> result = rightSideView(tree.root);
            // Print the right side view
            for (int ir = 0; ir < result.size(); ir++) {
                System.out.print(result.get(ir));
                if (ir != result.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            System.out.println(new String(new char[100]).replace('\0', '-'));

        }

        // Lowest Common Ancestor of a Binary Tree

        List<List<TreeNode<Integer>>> inputTreesLow = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(350)),
                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(200), new TreeNode<Integer>(75), new TreeNode<Integer>(50), new TreeNode<Integer>(25), new TreeNode<Integer>(350)),
                Arrays.asList(new TreeNode<Integer>(350), new TreeNode<Integer>(100), new TreeNode<Integer>(75), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25)),
                Arrays.asList(new TreeNode<Integer>(100), new TreeNode<Integer>(50), new TreeNode<Integer>(200), new TreeNode<Integer>(25), new TreeNode<Integer>(75), new TreeNode<Integer>(350)),
                Arrays.asList(new TreeNode<Integer>(25), new TreeNode<Integer>(50), new TreeNode<Integer>(75), new TreeNode<Integer>(100), new TreeNode<Integer>(200), new TreeNode<Integer>(350))
        );

        int[][] inputNodes = {
                {25, 75},
                {50, 350},
                {100, 200},
                {50, 25},
                {350, 200}
        };

        for (int ilow = 0; ilow < inputTreesLow.size(); ilow++) {
          //
            BinaryTree<Integer> tree = new BinaryTree<>(inputTreesLow.get(ilow));
            System.out.println((ilow + 1) + ".\tBinary tree:");
    //
            //        Print.displayTree(tree.root);
            System.out.println("\tp = " + inputNodes[ilow][0]);
            System.out.println("\tq = " + inputNodes[ilow][1]);
            TreeNode<Integer> lca = lowestCommonAncestor(tree.root, tree.find(inputNodes[ilow][0]), tree.find(inputNodes[ilow][1]));
      //      System.out.println("\n\tLowest common ancestor: " + lca.value);
            System.out.println(new String(new char[100]).replace('\0', '-'));

        }
        // Validate Binary Search Tree
        List<List<TreeNode<Integer>>> listOfTreesValidate = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(4), new TreeNode<Integer>(2), new TreeNode<Integer>(7), new TreeNode<Integer>(1), new TreeNode<Integer>(5), new TreeNode<Integer>(6), new TreeNode<Integer>(9)),
                Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(3), new TreeNode<Integer>(2), new TreeNode<Integer>(6), new TreeNode<Integer>(4)),
                Arrays.asList(new TreeNode<Integer>(6), new TreeNode<Integer>(2), new TreeNode<Integer>(5), new TreeNode<Integer>(4), new TreeNode<Integer>(7)),
                Arrays.asList(new TreeNode<Integer>(4), new TreeNode<Integer>(2), new TreeNode<Integer>(5), new TreeNode<Integer>(1), new TreeNode<Integer>(3)),
                Arrays.asList(new TreeNode<Integer>(7), new TreeNode<Integer>(2), new TreeNode<Integer>(5), new TreeNode<Integer>(4), new TreeNode<Integer>(8)),
                Arrays.asList(new TreeNode<Integer>(9), new TreeNode<Integer>(5), new TreeNode<Integer>(7), new TreeNode<Integer>(1), new TreeNode<Integer>(3)),
                Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(3), new TreeNode<Integer>(8), new TreeNode<Integer>(2), new TreeNode<Integer>(4),
                        null, new TreeNode<Integer>(9))
        );

        List<BinaryTree<Integer>> inputTreesValidate = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTreesValidate) {
            BinaryTree<Integer> tree = new BinaryTree<Integer>(ListOfNodes);
            inputTreesValidate.add(tree);
        }

        int xValidate = 1;
        for (BinaryTree<Integer> tree : inputTreesValidate) {
            System.out.println(xValidate + ".\tInput Tree:");
           // Print.displayTree(tree.root);
            xValidate++;
            System.out.println("\n\tValid BST: " + validateBst(tree.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // Nested List Weight Sum II
        List<String> nestedIntegerStrings = new ArrayList<>();
        nestedIntegerStrings.add("[1, [2, 3], 4]");
        nestedIntegerStrings.add("[[1, 1], 2, [1, [2, [1]]]]");
        nestedIntegerStrings.add("[[1, 2], [3, 4], [5, 6]]");
        nestedIntegerStrings.add("[1, [2, [3, [4, [5]]]]]");
        nestedIntegerStrings.add("[[[[[[1]]]]]]");

        for (int i = 0; i < nestedIntegerStrings.size(); ++i) {
            List<NestedInteger> nestedInteger = NestedIntegerParser.createNestedInteger(nestedIntegerStrings.get(i));
            System.out.println((i + 1) + ".\tNested list: " + nestedIntegerStrings.get(i));
            System.out.println("\tWeighted sum: " + weightedDepthSum(nestedInteger));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

        // Inorder Successor in BST
        Integer[][] inputs = {
                {18, 15, 13, 19, 5, 14},
                {1, 2, 3, 4, 5, 6},
                {100, 200, 50, 40, 30, 80, 90},
                {10},
                {1, 2},
                {-10, -20, -30, -40, -50, -60, -70}
        };
        Integer[] p = {5, 6, 40, 10, 1, -60};

        for (int i = 0; i < inputs.length; i++) {
            BinarySearchTree<Integer> inputTree = new BinarySearchTree<>(inputs[i]);
            System.out.println((i + 1) + ".\tGiven Tree:");
           // Print.displayTree(inputTree.root);

        //    Solution solution = new Solution();
            TreeNode<Integer> pNode = new TreeNode<>(p[i]);
            TreeNode<Integer> result = inorderSuccessor(inputTree.root, pNode);

            System.out.println("\n\tp Node: " + p[i]);

            if (result != null) {
                int res = result.value;
                System.out.println("\n\tInorder Successor: " + res);
            } else {
                String res_2 = "Null";
                System.out.println("\n\tInorder Successor: " + res_2);
            }

            System.out.println(new String(new char[100]).replace("\0", "-"));
        }

        ///  Height of Binary Tree After Subtree Removal Queries
        List<List<TreeNode<Integer>>> listOfTreesSub = Arrays.asList(
                Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(3), null, null, new TreeNode<>(4), null, null, new TreeNode<>(5)),
                Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(3), new TreeNode<>(4), new TreeNode<>(5), new TreeNode<>(6), new TreeNode<>(7)),
                Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(3), new TreeNode<>(4), new TreeNode<>(5)),
                Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(3), new TreeNode<>(4), null, new TreeNode<>(5)),
                Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(3), new TreeNode<>(4), null, new TreeNode<>(5), new TreeNode<>(6), new TreeNode<>(7))
        );

        List<int[]> queriesList = Arrays.asList(
                new int[]{2, 4, 5},
                new int[]{2, 4, 6},
                new int[]{2, 4, 5},
                new int[]{2, 4, 5},
                new int[]{2, 5, 7}
        );
        TreeDFS treeDFS=new TreeDFS();
        int usib = 1;
        for (int i = 0; i < listOfTreesSub.size(); i++) {

            BinaryTree<Integer> binaryTree = new BinaryTree<>(listOfTreesSub.get(i));
            int[] queries = queriesList.get(i);

            int[] updatedHeights = treeDFS.heightsAfterQueries(binaryTree.root, queries);

            System.out.println(usib + " .\tInput binary tree:");
           // Print.displayTree(binaryTree.root); // Implement this method to display the tree

            System.out.println("\n\tQueries: " + Arrays.toString(queries));
            System.out.println("\n\tHeight of the tree after each subtree removal: " + Arrays.toString(updatedHeights));
            System.out.println(new String(new char[100]).replace('\0', '-'));
            System.out.println("\n");
            usib++;
        }

        // Delete Nodes And Return Forest

        List<List<TreeNode<Integer>>> listOfTreesDel = Arrays.asList(
                Arrays.asList(new TreeNode<>(3), new TreeNode<>(2), new TreeNode<>(17), new TreeNode<>(1), new TreeNode<>(4), new TreeNode<>(19), new TreeNode<>(5)),
                Arrays.asList(new TreeNode<>(7), new TreeNode<>(6), new TreeNode<>(5), new TreeNode<>(4), new TreeNode<>(3), new TreeNode<>(2), null, new TreeNode<>(1)),
                Arrays.asList(new TreeNode<>(5), new TreeNode<>(4), new TreeNode<>(6), new TreeNode<>(3), new TreeNode<>(2), new TreeNode<>(7), new TreeNode<>(8), new TreeNode<>(1), new TreeNode<>(9)),
                Arrays.asList(new TreeNode<>(5), new TreeNode<>(2), new TreeNode<>(1), new TreeNode<>(6), new TreeNode<>(10), new TreeNode<>(11), new TreeNode<>(44)),
                Arrays.asList(new TreeNode<>(1), new TreeNode<>(2), new TreeNode<>(5), new TreeNode<>(3), new TreeNode<>(4), new TreeNode<>(6))
        );

        List<List<Integer>> deleteNodes = Arrays.asList(
                Arrays.asList(2, 17),
                Arrays.asList(5, 1),
                Arrays.asList(5, 6, 9),
                Arrays.asList(1, 44),
                Arrays.asList(2)
        );

        List<BinaryTree> inputTreesDel = new ArrayList<>();
        for (List<TreeNode<Integer>> listOfNodes : listOfTrees) {
            BinaryTree tree = new BinaryTree(listOfNodes);
            inputTreesDel.add(tree);
        }

        int xDel = 1;
        for (int i = 0; i < inputTreesDel.size(); i++) {
            System.out.println(xDel + ".\tInput Tree:");
          //  Print.displayTree(inputTreesDel.get(i).root, null);
          /*      System.out.println("\n\tNode(s) to delete: " + deleteNodes.get(i));
               List<TreeNode<Integer>> res = returnForest(inputTreesDel.get(i).root, deleteNodes.get(i));
            System.out.println("\n\tReturned forest:");
            for (TreeNode<Integer> root : res) {
                System.out.println("\t");
           //     Print.displayTree(root, null);
                System.out.println("\n");
            }
            xDel++;
            System.out.println(new String(new char[100]).replace('\0', '-'));*/
        }

        //Sum of Distances in a Tree


        int[][][] testEdges = {
                {{0, 1}, {1, 2}},
                {{0, 1}, {0, 2}, {2, 3}},
                {{0, 1}, {1, 2}, {1, 3}, {3, 4}},
                {{0, 1}, {0, 2}, {2, 3}},
                {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}}
        };

        int[] testNs = {3, 4, 5, 4, 6};

        for (int i = 0; i < testNs.length; i++) {
            int n = testNs[i];
            int[][] edges = testEdges[i];

            int[] result = treeDFS.sumOfDistancesInTree(n, edges);

            System.out.println((i + 1) + ". edges  : " + Arrays.deepToString(edges));
            System.out.println("   Sum of distances for each node: " + Arrays.toString(result));
            System.out.println("_".repeat(100));
        }

        // Recover a Tree From Preorder Traversal
        String[] arr = {
                "1-2-3",
                "1",
                "2-4--6--8-3--5--7",
                "100-200--300---400-500",
                "1000-500--250---125--62---31"
        };

        TreeDFS sol = new TreeDFS();
        for (int i = 0; i < arr.length; ++i){
            System.out.println((i + 1) + ".\ttraversal: \"" + arr[i] + "\"");
            TreeNode<Integer> tree = sol.recoverFromPreorder(arr[i]);
            System.out.print("\tOutput: ");
        //    Print.displayLevelOrderArray(tree);
            System.out.println("\n\tBinary Tree: \n");
       //     Print.displayTree(tree);
            System.out.println("-".repeat(100));
        }

    }


    // Recover a Tree From Preorder Traversal

    public TreeNode<Integer> recoverFromPreorder(String traversal) {

        // Replace this placeholder return statement with your code

        int[] index={0};
        int depth=0;
        return dfsRecoerFromPreorder(traversal,index,depth);

   }

    private TreeNode<Integer> dfsRecoerFromPreorder(String traversal, int[] index, int depth) {
        int n=traversal.length();
        int j=index[0],d=0;

        while(j<n && traversal.charAt(j)=='-'){
            j++;
            d++;
        }

        if(d!=depth){
            return null;
        }

        index[0]=j;

        int val=0;

        while(index[0]<n && Character.isDigit(traversal.charAt(index[0]))){
            val=val*10+ Integer.valueOf(traversal.charAt(index[0]));
            index[0]++;
        }

        TreeNode<Integer> treeNode=new TreeNode(val);

        treeNode.left=dfsRecoerFromPreorder(traversal,index,depth+1);
        treeNode.right=dfsRecoerFromPreorder(traversal,index,depth+1);
        return treeNode;


    }


    // Sum of Distances in a Tree
    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }


        for(int[] edge:edges){
            int parent=edge[0];
            int child=edge[1];
            adj.get(parent).add(child);
            adj.get(child).add(parent);
        }
        int[] answer=new int[n];
        int[] count=new int[n];

        Arrays.fill(count,1);

        dfsSumDist1(0,-1,adj,answer,count);
        dfsSumDist2(0,-1,adj,answer,count,n);

        
        // Replace this placeholder return statement with your code
        return answer;
    }

    private void dfsSumDist1(int current, int parent, List<List<Integer>> adj, int[] answer, int[] count) {
        for(int child:adj.get(current)){
            if(child!=parent){
                dfsSumDist1(child,current,adj,answer,count);
                count[current]+=count[child];
                answer[current]+=answer[child]+count[child];

            }

        }
    }


    private void dfsSumDist2(int current, int parent, List<List<Integer>> adj, int[] answer, int[] count, int n) {
        for(int child:adj.get(current)){
            if(child!=parent){
                answer[child]=answer[current]-count[child]+(n-count[child]);
                dfsSumDist2(child,current,adj,answer,count,n);

            }

        }
    }



    // Delete Nodes And Return Forest

    public static List<TreeNode<Integer>> returnForest(TreeNode<Integer> root, List<Integer> deleteNodes) {
        List<TreeNode<Integer>> forest = new ArrayList<>();
        if(root==null)
            return forest;

        Set<Integer> toDelete=new HashSet<>(deleteNodes);

        java.util.Stack<TreeNode<Integer>> stack=new java.util.Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode<Integer> curr=stack.pop();

            if(curr.left!=null){
                stack.push(curr.left);
                if(toDelete.contains(curr.left.value)){
                    curr.left=null;
                }

            }

            if(curr.right!=null){
                stack.push(curr.right);
                if(toDelete.contains(curr.right.value)){
                    curr.right=null;
                }

            }

            if(toDelete.contains(curr.value)){
                if ( curr.left != null) {
                    forest.add(curr.left);
                }
                if (curr.right != null) {
                    forest.add(curr.right);
                }
            }

        }

        if(!toDelete.contains(root.value))
            forest.add(root);
        // Replace this placeholder return statement with your code
        return forest;
    }


    public  Map<Integer,Integer> nodeDepth=new HashMap<>();
    public  Map<Integer,Integer> nodeHeight=new HashMap<>();
           //Height of Binary Tree After Subtree Removal Queries
    public  int[] heightsAfterQueries(TreeNode<Integer> root, int[] queries) {
    treeDFS(root,0);

    Map<Integer,List<int[]>> depthGroups=new HashMap<>();

    for(Map.Entry<Integer,Integer> entry:nodeDepth.entrySet()){
        int value=entry.getKey();
        int depth=entry.getValue();
        depthGroups.computeIfAbsent(depth,x->new ArrayList<>()).add(new int[]{nodeHeight.get(value),value});
    }


    for(List<int[]> group:depthGroups.values()){
        Collections.sort(group,(a,b)->b[0]-a[0]);
        if(group.size()>2)
            group.subList(2,group.size()).clear();
    }

    int[] result=new int[queries.length];
    for(int i=0;i<queries.length;i++){
        int q=queries[i];
        int qDepth=nodeDepth.get(q);
        List<int[]>  qDepthGroup=depthGroups.get(qDepth);

        if(qDepthGroup.size()==1){
            result[i]=qDepth-1;
        }else if(qDepthGroup.get(0)[1]==q){
            result[i]=qDepthGroup.get(1)[0]+qDepth;
        }else{
            result[i]=qDepthGroup.get(0)[0]+qDepth;
        }



    }

    // Replace this placeholder return statement with your code
        return result;
    }

    private int treeDFS(TreeNode<Integer> root, int i) {
        if(root==null)
            return -1;

        nodeDepth.put(root.value,i);
        int leftH=treeDFS(root.left,i+1);
        int rightH=treeDFS(root.right,i+1);
        int height=Math.max(leftH,rightH)+1;
        nodeHeight.put(root.value,height);
        return height;
    }


    // Inorder Successor in BST

    public static TreeNode<Integer> inorderSuccessor(TreeNode<Integer> root, TreeNode<Integer> p) {
        TreeNode<Integer> successor = null;
        while(root!=null){
            if(p.value>=root.value){
                root=root.right;
            }else{
                successor=root;
                root=root.left;
            }

        }

        return successor;
    }

  


    // Nested List Weight Sum II

    public static int findMaxDepth(List<NestedInteger> nestedList){
        int maxDepth=0;
        for(NestedInteger nested:nestedList){
            if(!nested.isInteger() && !nested.getList().isEmpty()){
                int localMax=1+findMaxDepth(nested.getList());
                maxDepth=Math.max(maxDepth,localMax);
            }
        }
        return maxDepth;
    }

    public static int weightedDepthSum(List<NestedInteger> nestedList) {
        int maxDepth=findMaxDepth(nestedList);
        return dfsWetDepSum(nestedList,0,maxDepth);
    }

    private static int dfsWetDepSum(List<NestedInteger> nestedList, int depth, int maxDepth) {

        int result=0;
        for(NestedInteger nested:nestedList) {
            if(nested.isInteger()) {
                result += nested.getInteger() * (maxDepth - depth + 1);
            }else {
                result+= dfsWetDepSum(nested.getList(),depth+1,maxDepth);
            }

        }
        return result;
    }


    // Validate Binary Search Tree
    public static boolean validateBst (TreeNode<Integer> root) {

        int[] prev={Integer.MIN_VALUE};
        // Replace this placeholder return statement with your code
        return dfsValidate(root,prev);
    }

    private static boolean dfsValidate(TreeNode<Integer> root,int[] prev) {
        if(root==null ){
            return true;
        }

        if(!dfsValidate(root.left,prev))
            return false;

        if(root.value<=prev[0])
            return false;

        prev[0]=root.value;



        return dfsValidate(root.right,prev);

    }

    // Lowest Common Ancestor of a Binary Tree
    public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {


        // Replace this placeholder return statement with your code
        return dfsLowestCommonAncestor(root,p,q);
    }

    private static TreeNode<Integer> dfsLowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {

        if(root==null)
            return null;

        if(root.value==p.value || root.value==q.value)
            return root;

        TreeNode<Integer> left=dfsLowestCommonAncestor(root.left,p,q);
        TreeNode<Integer> right=dfsLowestCommonAncestor(root.right,p,q);


        if(right!=null && left!=null){
            return root;
        }

        return (left!=null?left:right);

    }

    // Binary Tree Right Side View
    public static List<Integer> rightSideView(TreeNode<Integer> root) {

        List<Integer> rside=new ArrayList<>();
        dfsRightSideView(root,0,rside);

        return rside;
    }

    private static void dfsRightSideView(TreeNode<Integer> root, int level, List<Integer> rside) {
        if(root==null)
            return;

        if(level==rside.size())
            rside.add(root.value);

        List<TreeNode<Integer>> chidrens=new ArrayList<>();
        chidrens.add(root.right);
        chidrens.add(root.left);

        for(TreeNode<Integer> child:chidrens){
            if (child != null) {
                dfsRightSideView(child, level + 1, rside);
            }
        }

    }

    // Build Binary Tree from Preorder and Inorder Traversal
    public static TreeNode<Integer> buildTree(int[] pOrder, int[] iOrder) {

        Map<Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<iOrder.length;i++){
            inMap.put(iOrder[i],i);
        }

        int[] pIndex = {0};
        // Replace this placeholder return statement with your code
        return  dfsBuildTree(pOrder,iOrder,0,iOrder.length-1,inMap,pIndex);
    }

    private static TreeNode<Integer> dfsBuildTree(int[] pOrder, int[] iOrder, int low, int high, Map<Integer, Integer> inMap,int[] pIndex ) {

        if(low>high)
            return null;


        int first=pOrder[pIndex[0]];
        pIndex[0]++;

        // If this node has no children then return


        int mid =inMap.get(first);

        TreeNode<Integer> root=new TreeNode<>(first);

        if (low == high) {
            return root;
        }

        root.left=dfsBuildTree(pOrder,iOrder,low,mid-1,inMap,pIndex );
        root.right=dfsBuildTree(pOrder,iOrder,mid+1,high,inMap,pIndex );

        return root;
    }




    // Convert Sorted Array to Binary Search Tree

    public static TreeNode<Integer> sortedArrayToBST(int[] nums) {

                     // Replace this placeholder return statement with your code
        return dfsSorttedArraytoBst(nums,0,nums.length-1);
    }

    private static TreeNode<Integer> dfsSorttedArraytoBst(int[] nums, int left,int right) {

        if(left>right){
            return null;
        }

        int mid=left+ (right-left)/2;

        int val=nums[mid];

        TreeNode<Integer> node=new TreeNode<>(val);

        node.left=dfsSorttedArraytoBst(nums,left,mid-1);
        node.right=dfsSorttedArraytoBst(nums,mid+1,right);
        return node;


    }


    // Binary Tree Maximum Path Sum

    public static int maxPathSum(TreeNode<Integer> root) {


        int[] max=new int[1];
        maxPathSumDFS(root,max);
        return max[0];
    }

    private static int maxPathSumDFS(TreeNode<Integer> root, int[] max) {
        if(root==null)
            return 0;

        int left=root.value+Math.max(0,maxPathSumDFS(root.left,max));
        int right=root.value+Math.max(0,maxPathSumDFS(root.right,max));



        max[0]=Math.max(max[0],left+right-root.value);

        return Math.max(left,right);

    }

    // Invert Binary Tree

    public static TreeNode<Integer> invertTreeSimpler(TreeNode<Integer> root){

        if(root==null)
            return null;

        if(root.left!=null)
              invertTreeSimpler(root.left);

        if(root.right!=null)
            invertTreeSimpler(root.right);

        TreeNode<Integer> temp=root.left;
        root.left=root.right;
        root.right=temp;

        return root;

    }

    public static TreeNode<Integer> invertTree(TreeNode<Integer> root){
        List<String> streams=new ArrayList<>();
        invertTreeSerDfs(root,streams);

        int[] index=new int[1];
        return invertTreeDerDfs(streams,index);
    }

    private static TreeNode<Integer>  invertTreeDerDfs(List<String> streams, int[] index) {

        if(index[0]>=streams.size()){
            return null;
        }

        String val=streams.get(index[0]);
        index[0]++;

        if("null".equals(val)){
            return null;

        }

        TreeNode<Integer> node=new TreeNode<>(Integer.valueOf(val));
        node.right=invertTreeDerDfs(streams,index);
        node.left=invertTreeDerDfs(streams,index);
        return node;

    }

    private static void invertTreeSerDfs(TreeNode<Integer> root, List<String> streams) {
        if(root==null){
            streams.add("null");
            return;
        }
        streams.add(String.valueOf(root.value));
        invertTreeSerDfs(root.left,streams);
        invertTreeSerDfs(root.right,streams);

    }

    //   /Serialize and Deserialize Binary Tree


    public static List<String> serialize(TreeNode<Integer> root) {
        List<String> result=new ArrayList<>();

        dfsSeriliaze(root,result);

        // Replace this placeholder return statement with your code
       return result;
    }

    private static void dfsSeriliaze(TreeNode<Integer> root,List<String> result) {

        if(root==null) {
            result.add("null");
            return;
        }

        result.add(String.valueOf(root.value));
        dfsSeriliaze(root.left,result);
        dfsSeriliaze(root.right,result);

    }

    public  static TreeNode<Integer> dfsDesearlize(List<String> stream,int[] index ){

        if(index[0]>=stream.size()){
            return null;
        }

        String val=stream.get(index[0]);
        index[0]++;

        if("null".equals(val))
            return null;

        TreeNode<Integer> node=new TreeNode<>(Integer.valueOf(val));

        node.left=dfsDesearlize(stream,index);
        node.right=dfsDesearlize(stream,index);

        return node;



    }

    public static TreeNode<Integer> deserialize(List<String> stream){

        int[] index=new int[1];
        return dfsDesearlize(stream,index);


    }

    // Diameter of Binary Tree


    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        int[] daimeter=new int[1];
        dfsDaimeterofBinaryTree(root,daimeter);
        return daimeter[0];
    }

    private static int dfsDaimeterofBinaryTree(TreeNode<Integer> root,int[] daimeter) {
        if(root==null)
            return 0;

        int left=dfsDaimeterofBinaryTree(root.left,daimeter);
        int right=dfsDaimeterofBinaryTree(root.right,daimeter);
        daimeter[0]=Math.max(daimeter[0],left+right);
        return 1+Math.max(left,right);

    }

    public static TreeNode<Integer> flattenTree(TreeNode<Integer> root) {
        if(root==null)
            return null;

        TreeNode<Integer> current=root;

        while(current!=null){

            if(current.left!=null){
                TreeNode<Integer> last=current.left;

                while(last.right!=null)
                    last=last.right;

                last.right=current.right;
                current.right=current.left;
                current.left=null;

            }
            current=current.right;

        }
        return root;

    }




}
