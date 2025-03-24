package ravi.ds.queue;

import ravi.ds.stack.MyStack;

public class MyQueue<K> {
    public class Node<K> {
        Node<K> next;
        K value;

        public Node(K value) {
            this.value = value;
            this.next = null;
        }
    }
    private Node<K> first;
    private Node<K> last;
    private int lenght;

    public MyQueue(){
            this.first=null;
            this.last=null;
            this.lenght=0;
    }

   public void enQueue(K value){
        Node<K> newNode=new Node<>(value);
        if(this.lenght==0){
            this.first=newNode;
            this.last=newNode;
        }else{
            newNode.next=this.first;
            this.first=newNode;
        }
        this.lenght++;
   }

   public void deQueue(){
        if(this.lenght!=0){
            this.first=this.first.next;

        }
        this.lenght--;
   }

   public K peek(){
       if(this.lenght!=0){
           return this.first.value;

       }
       return null;
   }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue=new MyQueue<>();
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.enQueue(6);
        myQueue.printQueue();
        System.out.println("Peek: "+myQueue.peek());
        myQueue.deQueue();
        System.out.println("Peek: "+myQueue.peek());
        myQueue.deQueue();
        System.out.println("Peek: "+myQueue.peek());

    }

    public void printQueue(){
        Node<K> current=this.first;
        while(current!=null){
            System.out.println("Value : "+current.value);
            current=current.next;
        }
    }
}
