package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {

    private final Map<Integer, Long> memo = new HashMap<>();

    public int secondLargest(int[] input) throws Exception {
        if (input.length > 1) {
            Arrays.sort(input);
            for (int i = input.length - 1; i > -1; i--)
                if (input[i] < input[input.length - 1])
                    return input[i];
        }

        throw new Exception("There is no second largest number");
    }

    public Map<Character, Integer> countCharacter(String input) {
        Map<Character, Integer> charCounts = new HashMap<>();
        char[] charArray = input.toCharArray();

        for (char c : charArray) {
            if (charCounts.containsKey(c)) {
                charCounts.put(c, charCounts.get(c) + 1);
            } else {
                charCounts.put(c, 1);
            }
        }
        return charCounts;
    }

    /**
     * Dynamic Programming - Tabulation
     * Time Complexity: O(N)
     * Auxiliary Space: O(N)
     */
    public long fibonacciTabulation(int n)
    {
        // Declare an array to store
        // Fibonacci numbers.
        // 1 extra to handle case, n = 0
        int[] f = new int[n + 2];

        int i;

        // 0th and 1st number of
        // the series are 0 and 1
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {

            // Add the previous 2 numbers
            // in the series and store it
            f[i] = f[i - 1] + f[i - 2];
        }

        // Nth Fibonacci Number
        return f[n];
    }

    /**
     * Memoization
     * Time Complexity: O(N)
     * Auxiliary Space: O(N)
     */
    public long fibonacciMemoization(int n)
    {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        long result = fibonacciMemoization(n - 1) + fibonacciMemoization(n - 2);
        memo.put(n, result);
        return result;
    }

    /**
     * Loop
     * Time Complexity: O(N)
     * Auxiliary Space: O(1)
     */
    public long fibonacciLoop(int n)
    {
        if (n <= 1) {
            return n; // Base cases: fib(0) = 0, fib(1) = 1
        }

        long f0 = 0, f1 = 1, f = 1;

        for (int i = 2; i <= n; i++) {
            // Swap
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return f;
    }

    /**
     * Recursive
     * Time Complexity: O(2**N)
     * Auxiliary Space: O(n)
     */
    public long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n; // Base cases: fib(0) = 0, fib(1) = 1
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

}

