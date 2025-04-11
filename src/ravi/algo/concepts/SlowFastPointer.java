package ravi.algo.concepts;

import java.util.HashSet;
import java.util.Set;

public class SlowFastPointer {
    public static void main(String[] args) {

        // is a happy number.
        System.out.println("is Happy Number?"+isHappyNumber(1));
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
