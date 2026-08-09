package ravi.algo.concepts;

public class MyBTree {

    public static void main(String[] args) {
        MyBTree myBTree=new MyBTree();
        //4,3,6,2,1,7,5
        myBTree.add(4);
        myBTree.add(3);
        myBTree.add(6);
        myBTree.add(2);
        myBTree.add(1);
        myBTree.add(7);
        myBTree.add(5);
        System.out.println(" value "+myBTree.lookup(6).value);
    }
    public class Node<Integer>{
        Node left;
        Node right;
        Node parent;
        int value;

        public Node(int value){
            this.left=null;
            this.right=null;
            this.parent=null;
            this.value=value;
        }



    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int size;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    private Node head;

    public MyBTree(){
        this.head=null;
        this.size=0;
    }

    public void add(int value){
        Node newNode=new Node<>(value);
        if(this.head==null){
            this.head=newNode;

        }else {
            Node<Integer> current = this.head;
            while (current != null) {
                if (current.value >= value) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        newNode.parent=current;
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        newNode.parent=current;
                        break;
                    }
                }
            }
        }
        this.size++;
    }

    public Node lookup(int value){
        Node result=null;
        Node current=this.head;
        if(this.head.value==value){
            return this.head;
        }
        while(current!=null){
            if(current.value>=value){
                current=current.left;
            }else{
                current=current.right;
            }

            if(current!=null && current.value==value){
                return current;
            }
        }

        return null;
    }

}
