package ravi.ds.stack;
import java.util.Stack;
import java.util.Queue;

public class MyStack<K> {
    public class Node<K>{
        Node<K> down;
        K value;
        public Node(K k) {
            down = null;
            value = k;
        }
    }

    private int length;
    private Node<K> top;
    private Node<K> bottom;

    public MyStack(){

        this.length=0;
        this.top=null;
        this.bottom=null;
    }

    public void push(K k){
        Node<K>  newNode= new Node<>(k);
        if(this.length==0){
            newNode.down=null;
            this.top= newNode;
            this.bottom=newNode;

        }else{
            newNode.down=top;
            this.top=newNode;
        }
        this.length++;


    }

    public void pop() {
        if (this.length != 0) {
            this.top = this.top.down;

        } else {
            System.out.println("Nothing to pop");
        }
        this.length--;
    }

    public K peek() {
        if (this.length != 0) {
            return this.top.value;

        } else {
            System.out.println("Nothing to peek");
        }
        return null;
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack=new MyStack<>();
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(6);
        System.out.println("Peek: "+myStack.peek());
        myStack.pop();
        System.out.println("Peek: "+myStack.peek());
        myStack.pop();
        System.out.println("Peek: "+myStack.peek());

    }
}
