package ravi.ds.linkedlist;

public class MyDoublyLinkedList<T> {
    class Node<T>{
        Node<T> prev;
        Node<T> next;
        T data;

        public  Node(T data){
            this.prev=null;
            this.next=null;
            this.data=data;
        }

    }
    private Node<T> first;
    private Node<T> last;
    private int size;
    public MyDoublyLinkedList(){
        this.size=0;
    }

    public void addFirst(T t){
        Node<T> newNode = new Node<>(t);
        newNode.prev=null;
        if(this.first==null){
            newNode.next=null;
            this.first=newNode;
            this.last=this.first;
        }else{
           Node<T> f=this.first;
           newNode.next=f;
           f.prev=newNode;
           this.first=newNode;
        }
        this.size++;

    }

    public void addLast(T t){
        Node<T> newNode=new Node<>(t);
        newNode.next=null;
        if(this.last==null){
            newNode.prev=null;
            this.last=newNode;
            this.first=this.last;
        }else{
            Node<T> l=this.last;
            this.last.next=newNode;
            newNode.prev=l;
            this.last=newNode;
        }
        this.size++;
    }

    public void insert(int index, T data){
        if(index<1){
            addFirst(data);
        }else if(index>this.size-1){
            addLast(data);
        }else{
            Node<T> newNode=new Node<>(data);
            Node<T> cur=this.first;
            int i=0;
            while(cur.next!=null){
                if(i<index){
                    cur=cur.next;
                    i++;

                }else{
                    break;
                }
            }
            Node<T> justprev=cur.prev;

            justprev.next=newNode;
            newNode.prev=justprev;
            newNode.next=cur;
            cur.prev=newNode;
            this.size++;

        }

    }

    public void remove(int index){
        if(index>=0 && index<size-1) {
            Node<T> curr = this.first;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            Node<T> justAfter=curr.next.next;
            Node<T> justPrev=curr;
            justPrev.next=justAfter;
            justAfter.prev=justPrev;
            this.size--;
        }else{
            System.out.println("Wrong input");
        }

    }

    public void remove(T data){
        if(data!=null) {

            for(Node<T> curr = this.first;curr.next!=null;curr=curr.next){
                if(curr.data==data){
                    Node<T> justAfter=curr.next;
                    Node<T> justPrev=curr.prev;
                    justPrev.next=justAfter;
                    justAfter.prev=justPrev;
                    this.size--;
                    break;
                }
            }

        }else{
            System.out.println("Wrong input");
        }

    }
    public static void main(String[] args) {
        MyDoublyLinkedList<String> test=new MyDoublyLinkedList<>();
        test.addFirst("Raj");
        test.addFirst("Ravi");
        test.addLast("Singh");
        test.addLast("Chundawat");
        test.printList(test);
        test.insert(2,"middle");
       test.printList(test);
        test.remove(1);
        test.printList(test);
        test.remove("Singh");
        test.printList(test);


    }
    public void  printList(MyDoublyLinkedList mylinkedlist){
        StringBuilder stringBuilder=new StringBuilder();
        if(mylinkedlist!=null){
            Node<String> curr=mylinkedlist.first;
            while(curr!=null){
                stringBuilder.append(curr.data);
                stringBuilder.append(" ");
                curr=curr.next;
            }
        }
        System.out.println("Name LinkedList "+stringBuilder.toString());
        StringBuilder stringBuilder2=new StringBuilder();

        //traverse in apposite direction
        if(mylinkedlist!=null){
            Node<String> curr=mylinkedlist.last;
            while(curr!=null){
                stringBuilder2.append(curr.data);
                stringBuilder2.append(" ");
                curr=curr.prev;
            }
        }
        System.out.println("Name LinkedList "+stringBuilder2.toString());
    }

}
