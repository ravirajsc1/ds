package ravi.algo.recursion;

import java.util.Arrays;

public class Fibanocci {
    public static void main(String[] args) {
     //   Arrays.stream(calculateFibanocci(10)).forEach(System.out::println);
        int n = 10; // Number of terms
        for (int i = 0; i < n; i++) {
            System.out.print(calculateFibanocciRec(i) + " ");
        }
    }

    private static int[] calculateFibanocci(Integer current) {
        int[] fib=new int[10];
        fib[0]=0;
        fib[1]=1;

        for(int i=2;i<10;i++){
            fib[i]=fib[i-1]+fib[i-2];
        }

        return fib;
    }

    private static int calculateFibanocciRec(int n) {
        return (n<=1)?n:calculateFibanocciRec(n-1)+calculateFibanocciRec(n-2);
    }

}
