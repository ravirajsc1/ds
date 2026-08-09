package ravi.algo.concepts;


import javax.swing.*;
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

        // Reorder List
        List<List<Integer>> inputLists = Arrays.asList(
                Arrays.asList(1, 2,3,4,5,6),
                Arrays.asList(1, 1, 2, 2, 3, -1, 10, 12),
                Arrays.asList(10, 20, -22, 21, -12),
                Arrays.asList(1, 1, 1),
                Arrays.asList(-2, -5, -6, 0, -1, -4),
                Arrays.asList(3, 1, 5, 7, -4, -2, -1, -6)
        );

        for (int i = 0; i < inputLists.size(); i++) {
            LinkedList obj = new LinkedList(inputLists.get(i));

            System.out.print((i + 1) + ".\tOriginal list: ");
            PrintList.display(obj.head);

            reorderList(obj.head);

            System.out.print("\tAfter folding: ");
            PrintList.display(obj.head);

           // System.out.println(PrintHyphens.repeat("-", 100));
        }

        List<List<Integer>> inputS = Arrays.asList(
                Arrays.asList(6, 9, 3, 4),
                Arrays.asList(3,2,3,4,5,6,3),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(6, 9, 3, 10, 7, 4, 6),

                Arrays.asList(6, 2, 3, 6, 9),
                Arrays.asList(6, 2)
        );
        int[] ks = {
                2, 3, 2, 3,  3, 1
        };

        for(int i=0; i<inputS.size(); i++){
            System.out.print(i+1);
            LinkedList list = new LinkedList(inputS.get(i));
            System.out.print(".\tOriginal linked list is: ");
            PrintList.display(list.head);
            System.out.println("\tk: "+ks[i]);
            System.out.print("\tLinked list with swapped values: ");
            PrintList.display(swapNodes(list.head,ks[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


        // Reverse Nodes in Even Length Groups

        List<List<Integer>> inputListsr = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(10, 11, 12, 13, 14),
                Arrays.asList(15),
                Arrays.asList(16, 17)
        );

        for (int i = 0; i < inputListsr.size(); i++) {
            LinkedList inputLinkedLists = new LinkedList(inputListsr.get(i));

            System.out.print((i + 1) + ".\tIf we reverse the even length groups of the linked list: ");
            PrintList.display(inputLinkedLists.head);

            System.out.print("\n\n\twe will get: ");
            PrintList.display(reverseEvenLengthGroups(inputLinkedLists.head));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

/// Remove Duplicates from Sorted List
        List<List<Integer>> inputListD = Arrays.asList(
                Arrays.asList(1, 2, 2, 3, 3, 3),
                Arrays.asList(-21, -21, -21, -21, -21, -21, -21),
                Arrays.asList(3, 7, 9),
                Arrays.asList(-100, -100, -100, -10, -10, 0, 10, 10, 100, 100, 100),
                Arrays.asList(-77, -77, -7, -7, -7, -7, 7, 7, 7, 7, 77, 77, 77, 77)
        );

        for (int i = 0; i < inputListD.size(); i++) {
            LinkedList inputLinkedListD = new LinkedList(inputListD.get(i));

            System.out.print((i + 1) + ".\tInput: ");
            PrintList.display(inputLinkedListD.head);

            System.out.print("\n\tOutput: ");
            inputLinkedListD.head = removeDumpSecond(inputLinkedListD.head);
            PrintList.display(inputLinkedListD.head);

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        //Remove Linked List Elements

        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(9, 7, 8, 7, 7, 6),
                Arrays.asList(2, 3, 5, 7, 11),
                Arrays.asList(4, 4, 4, 4, 4),
                Arrays.asList(1, 2, 3, 11, 22, 33),
                Arrays.asList(1, 2, 6, 3, 4, 5, 6)
        );

        int[] ksr = {7, 8, 4, 3, 6};

        for (int i = 0; i < lists.size(); i++) {
            LinkedList inputLinkedListR = new LinkedList(lists.get(i));

            System.out.print((i + 1) + ".\tLinked list: ");
            PrintList.display(inputLinkedListR.head);

            System.out.println("\n\tk: " + ksr[i]);

            System.out.print("\tLinked list after removing elements: ");
            ListNode res = removeElementsAltnerate(inputLinkedListR.head, ksr[i]);
            PrintList.display(res);
            System.out.println("\n");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

        List<List<Integer>> listssplit = Arrays.asList(
                Arrays.asList(1,2,3,4,5,6,7,8,9,10),
                Arrays.asList(9, 7, 8, 7, 7, 6),
                Arrays.asList(4, 4, 4, 4, 4),
                Arrays.asList(1, 2, 3, 11, 22, 33),
                Arrays.asList(1, 2, 6, 3, 4, 5, 6)
        );

        int[] ksSplit = {4, 7, 4, 3, 6};

        for (int i = 0; i < listssplit.size(); i++) {
            LinkedList inputLinkedListSplit = new LinkedList(listssplit.get(i));
            System.out.print((i + 1) + ". \tLinked list: ");
            PrintList.display(inputLinkedList.head);

            System.out.println("\n\tk: " + ksSplit[i]);
            ListNode[] result = splitListToParts(inputLinkedListSplit.head, ksSplit[i]);

            System.out.print("\tLinked list parts: [");
            for (int j = 0; j < result.length; j++) {
                if (result[j] != null) {
                    System.out.print("[");
                    ListNode part = result[j];
                    while (part != null) {
                        System.out.print(part.value);
                        if (part.next != null) System.out.print(", ");
                        part = part.next;
                    }
                    System.out.print("]");
                } else {
                    System.out.print("[]");
                }
                if (j < result.length - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }


// Delete N Nodes After M Nodes of a Linked List
        List<List<Integer>> inputListsDelete = Arrays.asList(
                Arrays.asList(5),
                Arrays.asList(1, 2, 2, 3, 3, 3),
                Arrays.asList(3, 7, 9),
                Arrays.asList(10, 10, 100, 100, 100),
                Arrays.asList(7, 7, 7, 7, 77, 77, 77, 77)
        );

        int[] allMs = {1, 3, 1, 4, 5};
        int[] allNs = {1, 1, 3, 2, 7};

        for (int i = 0; i < inputListsDelete.size(); i++) {
            LinkedList inputLinkedListDelete = new LinkedList(inputListsDelete.get(i));

            System.out.println((i + 1) + ".\tInput:");
            System.out.print("\t");
            PrintList.display(inputLinkedListDelete.head);
            System.out.println("\tm = " + allMs[i]);
            System.out.println("\tn = " + allNs[i]);

            inputLinkedList.head = deleteNodes(inputLinkedListDelete.head, allMs[i], allNs[i]);
            System.out.println("\n\tOutput:");
            System.out.print("\t");
            PrintList.display(inputLinkedListDelete.head);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        // Insert into a Sorted Circular Linked List

        List<List<Integer>> inputListsED = Arrays.asList(
                Arrays.asList(3, 4, 1),
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2, 2, 2),
                Arrays.asList(5, 1, 3)
        );

        List<Integer> insertVals = Arrays.asList(2, 1, 0,3, 6);

        for (int i = 0; i < inputListsED.size(); i++) {
            List<Integer> lst = inputListsED.get(i);
            int insertVal = insertVals.get(i);

            EduLinkedList inputLinkedListED = new EduLinkedList(lst);
            System.out.print((i + 1) + ". \tInput linked list: ");
            EduLinkedList.display(inputLinkedListED.head, 20);

            System.out.println("\tValue to insert: " + insertVal);

            System.out.print("\n\tUpdated linked list: ");

            EduLinkedList.display(insert(inputLinkedListED.head, insertVal), 20);

            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }

    }


    //
    public static ListNode swapPairs(ListNode head) {

        // Replace this placeholder return statement with your code
        if(head==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=head;
        ListNode next=curr.next;
        while(curr!=null && next!=null){
            next=curr.next;
            ListNode temp=next.next;
            prev.next=next;
            next.next=curr;
            curr.next=temp;
            prev=curr;
            curr=curr.next;

        }
        return dummy.next;
    }


    // Insert into a Sorted Circular Linked List

    public static ListNode insert(ListNode head, int insertVal)
    {
        ListNode listNode=new ListNode(insertVal);
        if(head==null){
            listNode.next=listNode;
            head=listNode;
            return head;
        }

        boolean flag = false;
        ListNode curr=head.next;
        ListNode prev=head;
        while (true) {
            if(prev.value <= insertVal && insertVal<= curr.value){
                flag=true;
            }else if(prev.value > curr.value & (insertVal>prev.value || insertVal<curr.value)){
                flag=true;
            }

            if(flag){
                prev.next=listNode;
                listNode.next=curr;
               return head;
            }

            prev=curr;
            curr=curr.next;

            if(curr==head){
                break;
            }


        }

        prev.next=listNode;
        listNode.next=curr;



       return head;

    }

// Delete N Nodes After M Nodes of a Linked List

    public static ListNode deleteNodes(ListNode head, int m, int n) {

        // Replace this placeholder return statement with your code
        if(head==null){
            return null;
        }

        ListNode curr=head;

        while(curr!=null){

            for(int i=1;i<m && curr!=null ;i++){
                curr=curr.next;
             }

            if(curr==null)
                break;


            ListNode temp=curr.next;
            for(int i=0;i<n && temp!=null;i++){
                temp=temp.next;
            }
           curr.next=temp;
           curr=temp;
        }

        return head;
    }

    // slit into part of k
    public static ListNode[] splitListToParts(ListNode head, int k) {
        int size=0;

        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            size++;
        }


        int remaining=size%k;
        int blockSize=size/k;
        // Replace this placeholder return statement with your code
        ListNode[] ansArray = new ListNode[k];
        curr=head;
        ListNode prev=null;
        for(int i=0;i<k;i++){
            ansArray[i]=curr;
            int newBlockSize=0;
            if(remaining>0){
                newBlockSize=blockSize+1;
                remaining--;
            }else{
                newBlockSize=blockSize;
            }

            for(int j=0;j<newBlockSize;j++){
                if(curr==null){
                    break;
                }
                prev=curr;
                curr=curr.next;

            }

            if (prev != null) {
                prev.next = null;
            }


        }


        return ansArray;
    }


    //Remove Linked List Elements
    public static ListNode removeElementsAltnerate(ListNode head, int k) {


            if(head==null){
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next=head;
            ListNode prev=dummy;
            ListNode curr=head;
            while (curr != null) {
                if (k== curr.value) {
                    prev.next = curr.next;
                } else {
                    prev=curr;
                }
                curr = curr.next;
            }

            // Replace this placeholder return statement with your code
            return head;


    }

    //Remove Linked List Elements
    public static ListNode removeElements(ListNode head, int k) {

        {
            if(head==null){
                return head;
            }
            ListNode curr = head;

            while (curr != null && curr.next != null) {
                if (k== curr.next.value) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }

            if(head.value==k){
                head=null;
            }

            // Replace this placeholder return statement with your code
            return head;
        }

    }
    //Remove Duplicates from Sorted List
    public static ListNode removeDuplicates(ListNode head)
    {
        ListNode curr=head;

       while(curr!=null && curr.next!=null){
           if(curr.value==curr.next.value){
               curr.next=curr.next.next;
           }else{
               curr=curr.next;
           }
       }
        // Replace this placeholder return statement with your code
        return head;
    }

    public static ListNode removeDumpSecond(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy, curr = head;

        while (curr != null) {
            if (curr.value == prev.value) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }


    // Reverse Nodes in Even Length Groups
    public static ListNode reverseEvenLengthGroups(ListNode head) {

        // Replace this placeholder return statement with your code
        ListNode prev=head;
        ListNode node,curr,reverse,currNext,prevNext=null;

        int groupLength=2;
        int nodeNum=0;

        while(prev.next!=null){
            node=prev;
            nodeNum=0;

            for(int i=0;i<groupLength;i++){

                if(node.next==null){
                    break;
                }
                nodeNum=+1;
                node=node.next;
            }

            if(nodeNum%2!=0){
                prev=node;
            }else{
                reverse=node.next;
                curr=prev.next;
                for(int i=0;i<nodeNum;i++){
                    currNext=curr.next;
                    curr.next=reverse;
                    reverse=curr;
                    curr=currNext;
                }
                prevNext=prev.next;
                prev.next=node;
                prev=prevNext;
            }
            groupLength+=1;
        }

        return head;
    }


    //Reorder List
    public static ListNode swapNodes(ListNode head, int k) {

        // Replace this placeholder return statement with your code
        ListNode start=head;
        ListNode last=head;
        //ListNode prevfirst=null;
        //ListNode prevSecond=null;
        for(int i=0;i<k-1;i++){
         //   prevfirst=last;
            last=last.next;
        }

        ListNode first=last;

        while(last.next!=null){
            last=last.next;
          //  prevSecond=start;
            start= start.next;
        }

        ListNode second=start;

        int temp=second.value;
        second.value= first.value;
        first.value= temp;
        return head;
/*

        ListNode second=start;


        ListNode secondNext=second.next;
        ListNode firstNext=first.next;
        prevfirst.next=second;
        first.next=secondNext;
    //    prevSecond.next=first;
        if(prevSecond!=first){
            prevSecond.next=first;
        }

        if(second!=firstNext){
            second.next=firstNext;
        }else{
            second.next=first;
        }
*/



      //  while(head)

    }



    //Reorder List
    public static ListNode reorderList(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode curr=slow;
        ListNode prev=null;
        ListNode next=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        ListNode first=head;
        ListNode second=prev;
        ListNode temp=head;

        while(second.next!=null) {
            temp=temp.next;
            first.next=second;
            second=second.next;
            first.next.next=temp;
            first = first.next.next;
        }



        // Replace this placeholder return statement with your code
        return head;
    }


    // Swapping Nodes in a Linked List


    public static ListNode reverseBetweenSimple(ListNode head, int left, int right)
    {

        // Replace this placeholder return statement with your code
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        for(int i=0;i<left-1;i++){
            prev=prev.next;
        }
        ListNode curr=prev.next;

        for(int i=0;i<right-left;i++){
            ListNode nextNode=curr.next;
            curr.next=nextNode.next;
            nextNode.next=prev.next;
            prev.next=nextNode;
        }



        return dummy.next;
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
