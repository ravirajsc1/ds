package ravi.algo.concepts;

import java.util.*;
import java.util.LinkedList;

class EduBinaryTree<T> {
    EduTreeNode<T> root;

    EduBinaryTree(List<EduTreeNode<T>> ListOfNodes) {
        root = createBinaryTree(ListOfNodes);
    }

    private EduTreeNode<T> createBinaryTree(List<EduTreeNode<T>> ListOfNodes) {
        if (ListOfNodes.isEmpty()) {
            return null;
        }

        // Create the root node of the binary tree
        EduTreeNode<T> root = new EduTreeNode<>(ListOfNodes.get(0).data);

        // Create a queue and add the root node to it
        Queue<EduTreeNode<T>> q = new LinkedList<>();
        q.add(root);

        // Start iterating over the list of ListOfNodes starting from the second node
        int i = 1;
        while (i < ListOfNodes.size()) {
            // Get the next node from the queue
            EduTreeNode<T> curr = q.remove();

            // If the node is not null, create a new EduTreeNodeobject for its left child,
            // set it as the left child of the current node, and add it to the queue
            if (ListOfNodes.get(i) != null) {
                curr.left = new EduTreeNode<>(ListOfNodes.get(i).data);
                q.add(curr.left);
            }

            i++;

            // If there are more ListOfNodes in the list and the next node is not null,
            // create a new EduTreeNode object for its right child, set it as the right child
            // of the current node, and add it to the queue
            if (i < ListOfNodes.size() && ListOfNodes.get(i) != null) {
                curr.right = new EduTreeNode<>(ListOfNodes.get(i).data);
                q.add(curr.right);
            }

            i++;
        }

        // Return the root of the binary tree
        return root;
    }

    // Function to find the given node and return its next node
    public static EduTreeNode<Integer> getNextNode(EduTreeNode<Integer> root, int nodeData) {
        Queue<EduTreeNode<Integer>> queue = new java.util.LinkedList<>();
        queue.add(root); // Use a queue for level-order traversal

        while (!queue.isEmpty()) {
            EduTreeNode<Integer> current = queue.poll();

            if (current.data == nodeData) {
                return current.next;
            }

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return null;
    }
}
