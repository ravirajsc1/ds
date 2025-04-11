package ravi.algo.concepts;

import java.util.DuplicateFormatFlagsException;
import java.util.HashSet;
import java.util.Set;

public class SlowFastPointer {
    public static void main(String[] args) {

        // is a happy number.
        System.out.println(" sumOfSquare?"+sumOfSquare(1234));

        System.out.println("is Happy Number?"+isHappyNumberBetter(1));
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
