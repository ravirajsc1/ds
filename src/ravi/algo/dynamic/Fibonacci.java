package ravi.algo.dynamic;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private Map<Integer,Integer> fibMap=new HashMap<>();
    private int withoutMemry =0;
    private int withMemory=0;

    public static void main(String[] args) {
        Fibonacci fibonacci=new Fibonacci();
        //1 1 2 3 5 8 13 21
        System.out.println("without Memory :"+fibonacci.withRecursion(15));
        System.out.println("without Memory interation :"+fibonacci.withoutMemry);
        System.out.println("with Memory :"+fibonacci.withMemory(15));
        System.out.println("with Memory interation:"+fibonacci.withMemory);
    }

    public int withRecursion(int n){
        withoutMemry++;
        if (n == 0) return 0; // Correct base case for Fibonacci
        if (n == 1) return 1;
        return (withRecursion(n-1)+ withRecursion(n-2));
    }

    public int withMemory(int n){
        int result=0;
        if(fibMap.get(n)!=null){
            result= fibMap.get(n);
        }else{
            withMemory++;
            if (n == 0) return 0; // Correct base case for Fibonacci
            if (n == 1) return 1;
            result=withMemory(n - 1) + withMemory(n - 2);
            fibMap.put(n,result);
        }

        return result;
    }


}
