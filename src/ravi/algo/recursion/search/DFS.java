package ravi.algo.recursion.search;

import java.util.LinkedList;
import java.util.Queue;

public class DFS {

    public class Node{
        Node left;
        Node right;
        int value;

        public Node(Integer v) {
            this.left=null;
            this.right=null;
            this.value=v;
        }
    }
    private Node root;
    private int size;

    public DFS(){
        this.root=null;
        this.size=0;
    }

    public void add(int v){
        this.root=this.addRecurisve(v,this.root);
        this.size++;
    }

    public Node addRecurisve(int v,Node current){

        if(current==null){
            return new Node(v);
        }
        if(current.value>=v){
            current.left=addRecurisve(v,current.left);
        }else{

            current.right=addRecurisve(v,current.right);

        }
        return current;

    }

    public static void main(String[] args) {
        DFS dfs=new DFS();
        dfs.add(5);
        dfs.add(10);
        dfs.add(8);
        dfs.add(3);
        dfs.add(9);
        //      dfs.add(2);
        dfs.add(6);
        dfs.add(4);
        dfs.add(8);
        dfs.add(1);
        System.out.println("BSF:"+dfs.containValue(2));
//         5
//      3        10
//    1   4     8
//           6       9
//             8
        dfs.traverseDSFInOrder();

    }

    //     5
//      3    10
//     1  4  8  6
    //    9   8

    public boolean containValue(int v){
        return this.root!=null?this.findThroughRecursive(this.root,v):false;
    }

    private boolean findThroughRecursive(Node current, int v) {
        boolean result=false;
        if(current!=null) {
            if (current.value == v) {
                return true;
            }
            if (current.value >= v) {
                result = findThroughRecursive(current.left, v);
            } else {
                result = findThroughRecursive(current.right, v);
            }
        }
        return result;
    }

    public void traverseDSFInOrder(){

    }

    public void traverseDSFPostOrder(Node current,Queue<Node> tempQueue){

    }
    public void traverseDSFPreOrder(Node current,Queue<Node> tempQueue){

    }
}
