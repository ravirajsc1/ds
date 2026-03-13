package ravi.algo.concepts;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T> {
    TreeNode<T> root;

    public BinaryTree(List<TreeNode<T>> listOFnodes){
        root=createBinaryTree(listOFnodes);
    }

    private TreeNode<T> createBinaryTree(List<TreeNode<T>> listOFnodes) {

        if(listOFnodes.isEmpty())
            return null;

        TreeNode<T> root=new TreeNode<>(listOFnodes.get(0).value);

        Queue<TreeNode<T>> q=new LinkedList<>();
        q.add(root);

        int i=1;
        while(i<listOFnodes.size()){
            TreeNode<T> curr=q.remove();

            if(listOFnodes.get(i)!=null){
                curr.left=new TreeNode<>(listOFnodes.get(i).value);
                q.add(curr.left);
            }

            i++;

            if(i<listOFnodes.size() && listOFnodes.get(i)!=null){
                curr.right=new TreeNode(listOFnodes.get(i).value);
                q.add(curr.right);

            }
            i++;
        }

        return root;

    }
    public TreeNode<T> find(T value) {
        return findRec(root, value);
    }

    public TreeNode<T> findRec(TreeNode<T> root, T value) {
        if (root == null || root.value.equals(value))
            return root;

        TreeNode<T> leftResult = findRec(root.left, value);
        if (leftResult != null)
            return leftResult;

        TreeNode<T> rightResult = findRec(root.right, value);
        if (rightResult != null)
            return rightResult;

        return null;
    }

}
