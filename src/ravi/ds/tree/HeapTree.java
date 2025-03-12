package ravi.ds.tree;

import org.w3c.dom.xpath.XPathResult;

public class HeapTree {

    private int[] heap;
    private int size;
    private int capacity;

    public HeapTree(int capacity){
        this.capacity=capacity;
        this.size=0;
        this.heap=new int[capacity];
    }

    private int parent(int i) {return (i-1)/2;}
    private int leftChild(int i) {return 2*i+1;}
    private int rightChild(int i) {return 2*i+2;}

    public void insert(int key){

        if(this.capacity==this.size){
            System.out.println("we are full ");
            return;
        }
        int current=this.size;
        heap[current]=key;
        this.size++;

        //heapify
        while(current>0 && heap[current]>heap[parent(current)]){
            swap(current,parent(current));
            current=parent(current);
        }

    }

    public void swap(int source, int dest){
        int temp=heap[dest];
        heap[dest]=heap[source];
        heap[source]=temp;

    }

    public static void main(String[] args) {
        HeapTree heapTree=new HeapTree(10);
        heapTree.insert(10);
        heapTree.insert(3);
        heapTree.insert(5);
        heapTree.insert(2);
        heapTree.insert(7);
        heapTree.insert(9);
        heapTree.insert(11);
        heapTree.insert(1);
        heapTree.insert(17);
        heapTree.insert(0 );


        heapTree.printArray();
    }

    public  void printArray(){
        for(int i=0;i<this.heap.length;i++){
            System.out.print(" "+this.heap[i]);

        }
    }

}
