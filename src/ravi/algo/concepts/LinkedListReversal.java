package ravi.algo.concepts;

import java.util.LinkedList;

public class LinkedListReversal {
    public static ListNode[] reverseLinkedList(ListNode node,int k){
        ListNode curr=node;
        ListNode prev=null;
        ListNode next=null;
        for(int i=0;i<k;i++){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return new ListNode[]{prev,curr};

    }
}
