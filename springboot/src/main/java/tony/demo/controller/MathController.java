package tony.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tony.demo.service.MathService;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    @Autowired
    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/fibonacci/{n}")
    public long fibonacci(@PathVariable int n) {
        long t0 = System.currentTimeMillis();
        long fibonacciTabulation = mathService.fibonacciTabulation(n);
        long t1 = System.currentTimeMillis();

        System.out.println("fibonacci("+n+") = " + fibonacciTabulation);
        System.out.println("\tDynamic Programming - Tabulation, takes time " + (t1 - t0));

        return fibonacciTabulation;
    }

    @GetMapping("/count-character/{str}")
    public Map<Character, Integer> countCharacter(@PathVariable String str) {
        return mathService.countCharacter(str);
    }

    @GetMapping("/second-largest/{str}")
    public int secondLargest(@PathVariable String str) throws Exception {
        String[] strArray = str.split(",");
        int[] intArray = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();
        return mathService.secondLargest(intArray);
    }
}
