import model.*;

public class DynamicProgrammingDemo {
    public static void main(String[] args) {
        int n = 45;
        DynamicProgramming model = new DynamicProgramming();
        long t0 = System.currentTimeMillis();
        long fibonacciTabulation = model.fibonacciTabulation(n);
        long t1 = System.currentTimeMillis();
        long fibonacciMemoization = model.fibonacciMemoization(n);
        long t2 = System.currentTimeMillis();
        long fibonacciLoop = model.fibonacciLoop(n);
        long t3 = System.currentTimeMillis();
        long fibonacciRecursive = model.fibonacciRecursive(n);
        long t4 = System.currentTimeMillis();

        System.out.println("Calculate fibonacci number 45 ");
        System.out.println("\tDynamic Programming - Tabulation, takes time " + (t1 - t0) + ", result " + fibonacciTabulation);
        System.out.println("\tDynamic Programming - Memoization" + ", takes time " + (t2 - t1) + ", result " + fibonacciMemoization);
        System.out.println("\tLoop method, takes time " + (t3 - t2) + ", result " + fibonacciLoop);
        System.out.println("\tRecursive method, takes time " + (t4 - t3) + ", result " + fibonacciRecursive);
    }


}
