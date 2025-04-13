package ravi.algo.concepts;

import ravi.ds.linkedlist.Mylinkedlist;

import java.util.DuplicateFormatFlagsException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SlowFastPointer {
    public static void main(String[] args) {

        // is a happy number.
        System.out.println(" sumOfSquare?"+sumOfSquare(1234));

        System.out.println("is Happy Number?"+isHappyNumberBetter(1));

        //Linked List Cycle
        Mylinkedlist<Integer> linkedList=new Mylinkedlist<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        //linkedList.getLast().next= linkedList.getFirst();
        System.out.println("is detectCycle ?"+detectCycle(linkedList.getFirst()));

        //Middle of the Linked List
        System.out.println("is detectCycle ?"+middleNode(linkedList.getFirst()));
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
