package ravi.ds.tree;

public class MyTree{
    public class Node{
        Node left;
        Node right;
        int value;
        public Node(int value){
            this.left=null;
            this.right=null;
            this.value=value;
        }

    }
    static final int COUNT = 1;
    private Node top;
    private int length;

    public MyTree(){
        this.top=null;
        this.length=0;
    }
    
    public void insert(int v){
        Node newNode=new Node(v);
        Node current=this.top;
        if(this.length==0){
            this.top=newNode;

        }else{
            while(current!=null){
                if(current.value >= newNode.value){
                    if(current.left==null) {
                        current.left = newNode;
                        break;
                    }
                    current = current.left;

                }else{
                    if(current.right==null) {
                        current.right=newNode;
                        break;
                    }
                    current = current.right;
                }


            }
        }
        length++;

    }

    public Node LookUp(int v){
        Node current=this.top;
        Node result=null;
        while(current!=null) {
            if (current.value < v) {
                current = current.right;
            } else if (current.value > v) {
                current = current.left;
            } else {
                result = current;
                break;
            }
        }
        return result;
    }


    public void remove(int v){
        this.removeRec(this.top,v);
    }

    //         10
//                 30
//   4   6      20             50
//
    public Node removeRec(Node current,int v){
        if(v<current.value){
            current.left=  removeRec(current.left,v);
        }else if(v> current.value){
            current.right= removeRec(current.right,v);
        }else{
            if(current.left==null && current.right==null){
                return null;
            }else if(current.left==null){
                return current.right;
            }else if(current.right==null){
                return current.left;
            }else{
                Node sucessor = findMin(current.right);
                current.value=sucessor.value;
                current.right=removeRec(current.right,sucessor.value);
            }
        }
        return current;
    }

    private Node findMin(Node current) {
        while(current.left!=null){
            current=current.left;
        }
        return current;
    }

    public void delete(int v){

        Node current=this.top;
        Node parent=null;
         while(current!=null) {

            if (current.value == v) {
                //d
                if(parent.value<v) {
                    restructureTree(parent, current);
                }else{
                    restructureTreeLeft(parent, current);
                }
                break;

            } else if (current.value < v) {
                parent=current;
                current = current.right;

            } else if (current.value > v) {
                parent=current;
                current = current.left;
            }
        }

    }
//         10
//     5           30
//   4   6      20             50
//                       40          60
//                    35   45     55     70  75
    private void restructureTree(Node parent, Node current) {
        parent.right=current.right;
        Node next=current.right;
        if(next!=null) {
            restructureTree(next,next);
            next.left=current.left;
        }

    }

    private void restructureTreeLeft(Node parent, Node current) {
        parent.left=current.left;
        Node next=current.left;
        if(next!=null) {
            restructureTree(next,next);
            next.right=current.right;
        }

    }

    public static void main(String[] args) {
        MyTree intTree=new MyTree();
        intTree.insert(10);
        intTree.insert(30);
        intTree.insert(5);
        intTree.insert(4);
        intTree.insert(6);
        intTree.insert(50);
        intTree.insert(20);
        intTree.insert(4);
        intTree.insert(60);
        intTree.insert(40);
        intTree.insert(70);
        intTree.insert(35);
        intTree.insert(45);
        intTree.insert(55);
        intTree.insert(75);
        printTree(intTree.top, 0);
       // intTree.printTree(intTree.top);
        System.out.println("LookValue:"+intTree.LookUp(50).value);

        intTree.remove(30);
     //   printTree(intTree.top, 0);

        intTree.remove(5);
        printTree(intTree.top, 0);

    }

    public static void printTree(Node root, int level) {
        if (root == null) {
            return;
        }
        // First, process the right subtree so it appears on top
        printTree(root.right, level + 1);

        // Print indentation corresponding to the current level
        for (int i = 0; i < level; i++) {
            System.out.print("    ");  // 4 spaces per level
        }
        // Print the current node's value
        System.out.println(root.value);

        // Then process the left subtree so it appears at the bottom
        printTree(root.left, level + 1);
    }
//            10
//     5           50
//   4   6      20             60
//                       40          70
//                    35   45     55

    public void printTree(Node current){
        if(current==null){
            return;
        }

        printTree(current.left);
        System.out.print(current.value + " ");
        printTree(current.right);


    }





}
