package tony.report.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tony.report.demo.service.MathService;

import java.util.Arrays;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    @Autowired
    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/fibonacci/{n}")
    public String fibonacci(@PathVariable int n) {
        int[] memo = new int[n + 1];
        long t0 = System.currentTimeMillis();
        int fibonacciTabulation = mathService.fibonacciTabulation(n);
        long t1 = System.currentTimeMillis();
        int fibonacciMemoization = mathService.fibonacciMemoization(n);
        long t2 = System.currentTimeMillis();
        int fibonacciLoop = mathService.fibonacciLoop(n);
        long t3 = System.currentTimeMillis();
        int fibonacciRecursive = mathService.fibonacciRecursive(n);
        long t4 = System.currentTimeMillis();

        String ret = "Calculate fibonacci number: ";
        ret += "; \tDynamic Programming - Tabulation, takes time " + (t1 - t0) + ", result " + fibonacciTabulation;
        ret += "; \tDynamic Programming - Memoization" + ", takes time " + (t2 - t1) + ", result " + fibonacciMemoization;
        ret += "; \tLoop method, takes time " + (t3 - t2) + ", result " + fibonacciLoop;
        ret += "; \tRecursive method, takes time " + (t4 - t3) + ", result " + fibonacciRecursive;
        return ret;
    }

    @GetMapping("/count-character/{str}")
    public String countCharacter(@PathVariable String str) {
        return mathService.countCharacter(str).toString();
    }

    @GetMapping("/second-largest/{str}")
    public int secondLargest(@PathVariable String str) throws Exception {
        String[] strArray = str.split(",");
        int[] intArray = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();
        return mathService.secondLargest(intArray);
    }
}
