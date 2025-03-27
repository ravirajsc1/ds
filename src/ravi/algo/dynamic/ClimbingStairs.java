package ravi.algo.dynamic;

import java.util.HashMap;
import java.util.Map;

/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs=new ClimbingStairs();
        System.out.println("climbStaris "+climbingStairs.climbStars(2));
        System.out.println("climbStaris "+climbingStairs.climbStars(3));
        System.out.println("climbStaris "+climbingStairs.climbStars(5));
        System.out.println("climbStarisDP "+climbingStairs.climbStarsDP(2));
        System.out.println("climbStarisDP "+climbingStairs.climbStarsDP(3));
        System.out.println("climbStarisDP "+climbingStairs.climbStarsDP(5));

        System.out.println("climbStairsOptimized "+climbingStairs.climbStairsOptimized(2));
        System.out.println("climbStairsOptimized "+climbingStairs.climbStairsOptimized(3));
        System.out.println("climbStairsOptimized "+climbingStairs.climbStairsOptimized(5));

    }


    private Map<Integer,Integer> steps=new HashMap<>();
    public int climbStars(int n){
            if(n==1 || n==2){
                return n;

            }
            return climbStars(n-1)+climbStars(n-2);

    }

    public int climbStarsDP(int n) {
        if (n == 1 || n == 2) {
            return n;

        }
        if (steps.containsKey(n)) {
            return steps.get(n);
        } else {
            int result = climbStarsDP(n - 1) + climbStarsDP(n - 2);
            steps.put(n, result);
            return result;

        }
    }

    public int climbStairsOptimized(int n) {
        if (n == 1 || n == 2) {
            return n;

        }
        int first=1;
        int second=2;
        int result=0;
        for(int i=3;i<=n;i++){
            result= first+second;
            first=second;
            second=result;
         }
        return result;
    }
}
