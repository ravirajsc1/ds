package ravi.algo.recursion.search;

import java.util.LinkedList;
import java.util.Queue;

public class BSF {

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

    public BSF(){
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
        BSF bsf=new BSF();
        bsf.add(5);
        bsf.add(10);
        bsf.add(8);
        bsf.add(3);
        bsf.add(9);
        //      bsf.add(2);
        bsf.add(6);
        bsf.add(4);
        bsf.add(8);
        bsf.add(1);
        System.out.println("BSF:"+bsf.containValue(2));
//         5
//      3        10
//    1   4     8
//           6       9
//             8
        bsf.traverseBSF();

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

    public void traverseBSF(){
        Queue<Node> qeueue=new LinkedList<>();
        qeueue.add(this.root);
        System.out.println(" traversethroughRecursion :");

        this.traversethroughRecursion(this.root,qeueue);

        Queue<Node> qeueueNew=new LinkedList<>();
        qeueueNew.add(this.root);

        System.out.println(" \n traversethroughNONRecursion :");
        this.traversethroughNONRecursion(this.root,qeueueNew);
    }

    public void traversethroughRecursion(Node current,Queue<Node> tempQueue){

        if(current.left!=null){
            tempQueue.add(current.left);
        }
        if(current.right!=null){
            tempQueue.add(current.right);
        }
            System.out.print(" " + tempQueue.peek().value);
            tempQueue.poll();
        if(tempQueue.peek()!=null) {
            traversethroughRecursion(tempQueue.peek(), tempQueue);
        }
    }
    public void traversethroughNONRecursion(Node current,Queue<Node> tempQueue){

        while(tempQueue.peek()!=null){
            current=tempQueue.peek();
            if(current.left!=null){
                tempQueue.add(current.left);
            }
            if(current.right!=null){
                tempQueue.add(current.right);
            }

            System.out.print(" " + tempQueue.peek().value);

            tempQueue.poll();

        }
    }
}
