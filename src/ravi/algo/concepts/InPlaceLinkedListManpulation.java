package ravi.algo.concepts;


import java.util.*;

public class InPlaceLinkedListManpulation {

    public static void main(String[] args) {

        // reverse Linked List
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(3, 2, 1),
                Arrays.asList(10),
                Arrays.asList(1, 2)
        );

        for (int i = 0; i < input.size(); i++) {

            LinkedList inputLinkedList = new LinkedList(input.get(i));
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList.display(inputLinkedList.head);
            System.out.print("\n\tReversed linked list: ");
            PrintList.display(reverse(inputLinkedList.head));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // Reverse Nodes in k-Group
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int k = 3;
        LinkedList inputLinkedList = new LinkedList(inputList);

        System.out.print("Linked list: ");
        PrintList.display(inputLinkedList.head);
        System.out.print("\n");
        System.out.println();

        reverseKGroups(inputLinkedList.head, k);

        List<List<Integer>> inputr = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(6, 9, 3, 10, 7, 4, 6),
                Arrays.asList(6, 9, 3, 4),
                Arrays.asList(6, 2, 3, 6, 9),
                Arrays.asList(6, 2)
        );

        int[] left = {1, 3, 2, 1, 1};
        int[] right = {5, 6, 4, 3, 2};
        for(int i=0; i<inputr.size(); i++){
            System.out.print(i+1);
            LinkedList list = new LinkedList(inputr.get(i));
            System.out.print(".\tOriginal linked list:  ");
            PrintList.display(list.head);
            System.out.print("\tLeft: " + left[i] + ", Right: " + right[i] + "\n\n");
            System.out.print("\tReversed linked list:  " );
            PrintList.display(reverseBetween(list.head,left[i],right[i]));
      //      System.out.println(PrintHyphens.repeat("-", 100));
        }

    }

    public static ListNode reverseBetween(ListNode head, int left, int right)
    {

        // Replace this placeholder return statement with your code
        ListNode bckptr=head;
        ListNode dummy=new ListNode(-1);
        if(left==1){
            dummy.next=head;
            bckptr=dummy;
        }

        for(int i=1;i<left-1;i++){
             bckptr= bckptr.next;
        }

        ListNode[] updatedNodes=LinkedListReversal.reverseLinkedList(bckptr.next,right-left+1);
        ListNode previous=updatedNodes[0];
        ListNode current=updatedNodes[1];
        ListNode lastofReversedgroup=bckptr.next;
        bckptr.next=previous;
        lastofReversedgroup.next=current;
        if(bckptr.value==-1){
            head=bckptr.next;
        }

        return head;
    }

    public static ListNode reverse(ListNode head) {
          ListNode prev=null;
          ListNode curr=head;
          ListNode next=null;

          while(curr!=null){
              next=curr.next;
              curr.next=prev;
              prev=curr;
              curr=next;



          }

          head=prev;
        // Replace this placeholder return statement with your code

        return head;
    }

    //Reverse Nodes in k-Group
    public static ListNode reverseKGroups(ListNode head, int k) {

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode ptr=dummy;
        while(ptr!=null){
            ListNode tracker=ptr;

            for(int i=0;i<k;i++){

                if(tracker==null){
                    break;
                }
                tracker=tracker.next;
            }

            if(tracker==null){
                break;
            }

            ListNode[] updatedNodes=LinkedListReversal.reverseLinkedList(ptr.next,k);
            ListNode previous=updatedNodes[0];
            ListNode current=updatedNodes[1];

            ListNode LastNodeofReversedGroup=ptr.next;
            LastNodeofReversedGroup.next=current;
            ptr.next=previous;
            ptr=LastNodeofReversedGroup;



        }


       // Replace this placeholder return statement with your code
        return dummy.next;
    }

}
