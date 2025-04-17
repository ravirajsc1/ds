package ravi.algo.concepts;

import jdk.jshell.execution.JdiExecutionControl;
import ravi.ds.linkedlist.Mylinkedlist;

import java.util.*;

public class SlowFastPointer {
    public static void main(String[] args) {

        // is a happy number.
        System.out.println(" sumOfSquare?" + sumOfSquare(1234));

        System.out.println("is Happy Number?" + isHappyNumberBetter(1));

        //Linked List Cycle
        Mylinkedlist<Integer> linkedList = new Mylinkedlist<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        //linkedList.getLast().next= linkedList.getFirst();
        System.out.println("is detectCycle ?" + detectCycle(linkedList.getFirst()));

        //Middle of the Linked List
        System.out.println("is detectCycle ?" + middleNode(linkedList.getFirst()));

        //Circular Array Loop
        int[] nums=new int[]{1, 2, 1, 1, 2};
        System.out.println("is Circular Array ?"+circularArrayLoop(nums));
        nums=new int[]{1, 2, 1, 1, 2};

        System.out.println("is Circular Array ?"+circularArrayLoopBetter(nums));

        //Find the Duplicate Number
        nums=new int[]{1,3,6,2,7,3,5,4};
        System.out.println("is findDuplicate ?"+findDuplicate(nums));

        //Palindrome Linked List


        Mylinkedlist<Integer> mylinkedlist = new Mylinkedlist<>();
        mylinkedlist.addLast(3);
        mylinkedlist.addLast(4);
        mylinkedlist.addLast(5);
        //     mylinkedlist.addLast(6);
        mylinkedlist.addLast(5);
        mylinkedlist.addLast(4);
        mylinkedlist.addLast(3);
        //linkedList.getLast().next= linkedList.getFirst();

        System.out.println("is palindrome ?" + palindromeBetter(mylinkedlist.getFirst()));

    }

    public static boolean palindromeBetter(Mylinkedlist.Node head) {
        // find middle
        Mylinkedlist.Node slow=head;
        Mylinkedlist.Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Mylinkedlist.Node reveredData=reverseLinkedList(slow);
        boolean check=compareTwoHalves(head,reveredData);
        reverseLinkedList(reveredData);

        if(check){
            return true;
        }
        //reverse last half

        //compare
        //reverse last half
        return false;

    }

    private static boolean compareTwoHalves(Mylinkedlist.Node head, Mylinkedlist.Node reveredData) {
        Mylinkedlist.Node firstHalf=head;
        Mylinkedlist.Node secondHalf=reveredData;
        while(secondHalf!=null){
            if(firstHalf.value!=secondHalf.value){
                return false;
            }
            firstHalf=firstHalf.next;
            secondHalf=secondHalf.next;

        }
        return true;
    }

    private static Mylinkedlist.Node reverseLinkedList(Mylinkedlist.Node slow) {

        Mylinkedlist.Node prev=null;
        Mylinkedlist.Node curr=slow;
        Mylinkedlist.Node next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    //Palindrome Linked List
    public static boolean palindrome(Mylinkedlist.Node head) {
        Mylinkedlist.Node slow=head;
        Mylinkedlist.Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        Mylinkedlist.Node current=slow;
        Mylinkedlist.Node prev=null;
        Mylinkedlist.Node next=null;
        Mylinkedlist.Node last=null;

        while(current!=null){
            next=current.next;
            if(current.next==null)
                last=current;
            current.next=prev;
            prev=current;
            current=next;
        }

        current=head;

        while(current!=slow){
            if(prev.value!=current.value){
                return false;
            }
            prev=prev.next;
            current=current.next;

        }

        current=last;
        prev=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

        // Replace this placeholder return statement with your code
        return true;
    }

    //Find the Duplicate Number
    public static int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[nums[0]];

        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        // Replace this placeholder return statement with your code
        return fast;
    }
    //
    public static boolean circularArrayLoopBetter(int[] nums) {
        int n = nums.length;
        for (int start=0;start<n;start++){
            int slow=start;
            int fast=start;
            boolean direction=nums[start]>0;
            while(true){
                slow=nextStep(slow,nums[slow],n);
                if(isNotCycle(nums, direction,slow))
                    break;

                fast=nextStep(fast,nums[fast],n);
                if(isNotCycle(nums, direction,fast))
                    break;

                fast=nextStep(fast,nums[fast],n);
                if(isNotCycle(nums, direction,fast))
                    break;


                if(slow==fast){
                    return true;
                }
            }


        }

        return false;  // No cycle found
    }

    private static boolean isNotCycle(int[] nums, boolean direction, int pointer) {
        if(nums[pointer]>=0!=direction || nums[pointer]%nums.length==0){
            return true;
        }
        return false;
    }

    private static int nextStep(int pointer, int value, int size) {
        int result=(pointer+value)%size;
        if(result<0){
            result+=size;
        }
        return result;
    }

    public static boolean circularArrayLoop(int[] nums) {
        int n=nums.length;

        for(int start=0;start<n;start++){
            if(nums[start]==0){
                break;
            }
            int current=start;
            int step=0;
            boolean directon=nums[start]>0;
            boolean[] visited=new boolean[n];
            while(true){
                current=(current+nums[current])%n;

                if(current<0){
                    current=n-current;
                }
                if(step==0 && current==start){
                    break;
                }

                if((nums[current]>0)!=directon){
                    break;
                }
                if(step>0 && current==start){
                   return true;
                }

                if(visited[current]){
                    break;
                }

                visited[current]=true;
                step++;
            }

            for(int i=0;i<n;i++){
                if(visited[i]){
                    nums[i]=0;
                }
            }
        }


        return false;
    }


    //Middle of the Linked List
    public static Mylinkedlist.Node middleNode(Mylinkedlist.Node head) {
        Mylinkedlist.Node firstPointer=head;
        Mylinkedlist.Node secondPointer=head;
        while(secondPointer!=null && secondPointer.next!=null){
            firstPointer=firstPointer.next;
            secondPointer=secondPointer.next.next;
        }
        // Replace this placeholder return statement with your code
        return firstPointer;
    }


//Linked List Cycle
    public static boolean detectCycle(Mylinkedlist.Node
                                              head) {

        Mylinkedlist.Node firstPointer=head;
        Mylinkedlist.Node secondPointer=head;
        while(firstPointer!=null && secondPointer!=null) {
            firstPointer=firstPointer.next;
            secondPointer=secondPointer.next.next;
            if(firstPointer==secondPointer) {
                return true;
            }
        }

        // Replace this placeholder return statement with your code

        return false;
    }

    /*
    Write an algorithm to determine if a number
 is a happy number.
We use the following process to check if a given number is a happy number
Starting with the given number
, replace the number with the sum of the squares of its digits.
Repeat the process until  The number equals
, which will depict that the given number
 is a happy number. The number enters a cycle, which will depict that the given number
 is not a happy number. Return TRUE if is a happy number, and FALSE if not.
     */

    public static int sumOfSquare(int n) {
        int totalSum=0;
        while(n!=0){
            int digit= n%10;
            totalSum += (Math.pow(digit, 2));
            n=n/10;

        }
        return totalSum;
    }

    public static boolean isHappyNumberBetter(int n) {
        int slowPointer=n;
        int fastPointer=sumOfSquare(n);
        while(fastPointer!=1 && fastPointer!=slowPointer){
            slowPointer=sumOfSquare(slowPointer);
            fastPointer=sumOfSquare(sumOfSquare(fastPointer));
        }

        if(fastPointer==1){
            return true;
        }
        return false;
    }

// navie
    public static boolean isHappyNumber(int n) {
        String numStr=String.valueOf(n);
        char[] numArray=numStr.toCharArray();
        Set<Integer> set=new HashSet();
    //    set.add(n);
        Double sum= 0.0;
        int resultSum=0;
        while(resultSum!=1 || set.contains(resultSum)) {
            sum= 0.0;
            for (int i = 0; i < numArray.length; i++) {
                sum = sum + Math.pow(Double.valueOf(String.valueOf(numArray[i])),2);
            }
            System.out.println(sum);
            resultSum=(int)sum.doubleValue();
            if(set.contains(resultSum)){
                return false;
            }else if(resultSum==1){
                return true;
            }else{
                set.add(resultSum);
                numStr=String.valueOf(resultSum);
                numArray=numStr.toCharArray();

            }
        }

        return false;

    }






}
