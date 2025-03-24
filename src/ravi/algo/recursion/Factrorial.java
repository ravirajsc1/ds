package ravi.algo.recursion;

public class Factrorial {
    public static void main(String[] args) {
        System.out.println(calulateFactorial(10));
    }

    private static Integer calulateFactorial(int i) {
        return i>0?i*calulateFactorial(i-1):1;
    }
}
