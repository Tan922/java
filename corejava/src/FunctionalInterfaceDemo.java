import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        FunctionalInterfaceDemo demo = new FunctionalInterfaceDemo();
        demo.consumerFunctionDemo();
        demo.predicateFunctionDemo();
        demo.supplierFunctionDemo();
        demo.functionDemo();
        demo.biFunctionDemo();
    }

    private void consumerFunctionDemo() {
        // Create a Consumer to print a string
        Consumer<String> printConsumer = System.out::println;
        printConsumer.accept("Hello, Consumer!");

        // Create a Consumer to print each number with a prefix
        Consumer<Integer> numberPrinter = (num) -> System.out.println("Number: " + num);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(numberPrinter);

        // Chaining Consumers using andThen(),
        Consumer<String> consumer1 = (s) -> System.out.println("First operation: " + s);
        Consumer<String> consumer2 = (s) -> System.out.println("Second operation: " + s.toUpperCase());
        Consumer<String> chainedConsumer = consumer1.andThen(consumer2);
        chainedConsumer.accept("chained message");
    }

    private void predicateFunctionDemo() {
        // declare the predicate type as string and use lambda expression to create object
        Predicate<String> p = (s) -> s.startsWith("G");

        // create a list of strings
        List<String> list = Arrays.asList("Geek", "GeeksQuiz", "g1", "QA", "Geek2");

        // Filter the list using the Predicate, p.test will be called
        List<String> filteredList = list.stream().filter(p).toList();
        System.out.println("Filtered List is " + filteredList);
    }

    private void supplierFunctionDemo() {
        // Supplier to provide number
        Supplier<Double> randomValue = Math::random;
        System.out.println("Supplier provide number: " + randomValue.get());

        // Supplier to provide a current LocalDateTime object
        Supplier<LocalDateTime> dateTimeSupplier = LocalDateTime::now;
        System.out.println("Supplier provide Date and Time: " + dateTimeSupplier.get());

        // Supplier to provide a formatted current date and time string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Supplier<String> formattedDateTimeSupplier = () -> formatter.format(LocalDateTime.now());
        System.out.println("Supplier provide Formatted Date and Time: " + formattedDateTimeSupplier.get());

        // Supplier to provide a simple string message
        Supplier<String> messageSupplier = () -> "Hello from Supplier!";
        System.out.println("Supplier provide simple string message: " + messageSupplier.get());

        // Using Supplier in a method that conditionally logs a message
        logMessage(() -> "This message is logged only if debug is enabled.");
    }

    // A method that takes a Supplier to provide a message, potentially for logging
    private void logMessage(Supplier<String> messageSupplier) {
        System.out.println("DEBUG: " + messageSupplier.get());
    }

    private void functionDemo() {
        // This function squares the input integer
        Function<Integer, Integer> square = number -> number * number;
        System.out.println("The square of 5 is " + square.apply(5));

        // Function to convert a String to its length
        Function<String, Integer> stringLength = String::length;
        System.out.println("Length of 'Hello World': " + stringLength.apply("Hello World"));
    }

    private void biFunctionDemo() {
        // 1. BiFunction to calculate the sum of two integers
        BiFunction<Integer, Integer, Integer> sumBiFunction = Integer::sum;
        int sumResult = sumBiFunction.apply(10, 20);
        System.out.println("Sum of 10 and 20: " + sumResult); // Output: Sum of 10 and 20: 30

        // 2. BiFunction to concatenate two strings
        BiFunction<String, String, String> concatBiFunction = (s1, s2) -> s1 + " " + s2;
        String concatResult = concatBiFunction.apply("Hello", "World");
        System.out.println("Concatenated string: " + concatResult); // Output: Concatenated string: Hello World

        // 3. BiFunction to multiply an integer by a double
        BiFunction<Integer, Double, Double> multiplyBiFunction = (num, factor) -> num * factor;
        double multiplyResult = multiplyBiFunction.apply(5, 2.5);
        System.out.println("Product of 5 and 2.5: " + multiplyResult); // Output: Product of 5 and 2.5: 12.5

        // 4. Chaining BiFunction with another Function using andThen()
        BiFunction<Integer, Integer, Integer> addAndDouble = Integer::sum;
        addAndDouble = addAndDouble.andThen(result -> result * 2); // Doubles the sum
        int finalResult = addAndDouble.apply(7, 3);
        System.out.println("Doubled sum of 7 and 3: " + finalResult);
    }
}
