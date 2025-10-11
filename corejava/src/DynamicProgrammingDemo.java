import model.*;

public class DynamicProgrammingDemo {
    public static void main(String[] args) {
        int n = 45;
        DynamicProgramming model = new DynamicProgramming();
        int[] memo = new int[n + 1];
        long t0 = System.currentTimeMillis();
        int fibonacciTabulation = model.fibonacciTabulation(n);
        long t1 = System.currentTimeMillis();
        int fibonacciMemoization = model.fibonacciMemoization(n);
        long t2 = System.currentTimeMillis();
        int fibonacciLoop = model.fibonacciLoop(n);
        long t3 = System.currentTimeMillis();
        int fibonacciRecursive = model.fibonacciRecursive(n);
        long t4 = System.currentTimeMillis();

        System.out.println("Calculate fibonacci number 45 ");
        System.out.println("Dynamic Programming - Tabulation, takes time " + (t1 - t0) + ", result " + fibonacciTabulation);
        System.out.println("Dynamic Programming - Memoization" + ", takes time " + (t2 - t1) + ", result " + fibonacciMemoization);
        System.out.println("Loop method, takes time " + (t3 - t2) + ", result " + fibonacciLoop);
        System.out.println("Recursive method, takes time " + (t4 - t3) + ", result " + fibonacciRecursive);
    }


}
