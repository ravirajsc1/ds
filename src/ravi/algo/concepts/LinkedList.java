package ravi.algo.concepts;

import java.util.List;

public class LinkedList {
    ListNode head;

    public LinkedList( ){
        this.head=null;
    }

    public LinkedList(List<Integer> values){
        this.head=null;
        createLinkedList(values);
    }

    private void createLinkedList(List<Integer> values) {
        if (values.isEmpty()) {
            head = null;
            return;
        }
        head = new ListNode(values.get(0));
        ListNode current = head;
        for(int i=1;i<values.size();i++ ){
            current.next=new ListNode(values.get(i));
            current=current.next;
        }

    }




}

class PrintList{

    public static void display(ListNode head){

        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("None");

    }

}