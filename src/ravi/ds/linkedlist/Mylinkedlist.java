package ravi.ds.linkedlist;

import java.util.LinkedList;

public class Mylinkedlist<K> {

    public class Node<K>{
        K value;
        Node<K> next;

        public Node(K k) {
            this.value=k;
            this.next=null;

        }
    }

    private Node<K> first;
    private Node<K> last;
    private int size;

    public void Mylinkedlist(){
        this.first=null;
        this.size=0;
    }

    public void addFirst(K k){
        Node<K> f=this.first;
        Node<K> newNode=new Node<>(k);
        if(f==null){
            this.first=newNode;
            newNode.next=null;
            this.last=this.first;
        }else{
            newNode.next=f;
            this.first=newNode;
        }
        this.size++;

    }

    public void addLast(K k){
        Node<K> l=this.last;
        Node<K> newNode=new Node<>(k);
        if(l==null){
            this.last=newNode;
            newNode.next=null;
            this.first=this.last;
        }else{
            l.next=newNode;
            this.last=newNode;

        }
        this.size++;
    }

    public void insert(int index, K k){
        if(index<1){
            addFirst(k);
        }else if(index>=this.size){
            addLast(k);
        }else{
            int i=0;
            Node<K> newNode=new Node<>(k);
            Node<K> current=this.first;
            while(i<index-1){
                current=current.next;
                i++;
            }
            newNode.next=current.next;
            current.next=newNode;
            this.size++;

        }


    }

    public Mylinkedlist<K>  reverse(){
        Mylinkedlist<K> reverse=new Mylinkedlist<>();
        for(Node<K> current=this.first;current!=null;current=current.next){
            reverse.addFirst(current.value);
        }
       //® reverse.addFirst(this.last.value);
        return reverse;

    }
    public void remove(int index){
       if(index>=0 && index<size-1) {
           Node<K> prev = this.first;

           for (int i = 0; i < index - 1; i++) {
               prev = prev.next;
           }
           prev.next = prev.next.next;
           this.size--;
       }else{
           System.out.println("Wrong input");
       }
    }

    public static void main(String[] args) {
        Mylinkedlist<String> test=new Mylinkedlist<>();
        test.addFirst("Raj");
        test.addFirst("Ravi");
        test.addLast("Singh");
        test.addLast("Chundawat");
        test.printList(test);
        test.insert(2,"middle");
        test.printList(test);
        test.remove(1);
        test.printList(test);

        test.printList(test.reverse());

    }

    public void  printList(Mylinkedlist mylinkedlist){
        StringBuilder stringBuilder=new StringBuilder();
        if(mylinkedlist!=null){
            Node<String> curr=mylinkedlist.first;
            while(curr!=null){
                stringBuilder.append(curr.value);
                stringBuilder.append(" ");
                curr=curr.next;
            }
        }
        System.out.println("Name LinkedList "+stringBuilder.toString());
    }


}
