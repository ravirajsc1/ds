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

}
