package Algorithms;

public class Recursion {

    public int factorialInteractive(int n) {
        if (n < 0) throw new IllegalArgumentException("Factorial is undefined for negative numbers");
        if (n == 0) return 1;
        int sum = 1;
        for (int i=1; i<=n; i++) {
            sum = sum * i;
        }
        return sum;
    }

    public int factorialRecursive(int n) {
        if (n < 0) throw new IllegalArgumentException("Factorial is undefined for negative numbers");
        if (n == 0) return 1;
        return n * factorialRecursive(n - 1);
    }

    public int fibonacciInteractive(int n) {
        if (n < 0) throw new IllegalArgumentException("Fibonacci is undefined for negative numbers");
        if (n < 2) return n;
        Integer[] preCalculated = new Integer[n+1];
        preCalculated[0] = 0;
        preCalculated[1] = 1;
        for (int i = 2; i <= n; i++) {
            preCalculated[i] = preCalculated[i-1] + preCalculated[i-2];
        }
        return preCalculated[n];
    }

    public int fibonacciRecursive(int n) {
        if (n < 0) throw new IllegalArgumentException("Fibonacci is undefined for negative numbers");
        if (n < 2) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println(recursion.fibonacciInteractive(0));
        System.out.println(recursion.fibonacciRecursive(4));
        System.out.println(recursion.factorialInteractive(0));
        System.out.println(recursion.factorialRecursive(0));
    }

}
