import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        FunctionalInterfaceDemo demo = new FunctionalInterfaceDemo();
        demo.consumerFunctionDemo();
        demo.predicateFunctionDemo();
        demo.supplierFunctionDemo();

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
        Supplier<Double> randomValue = Math::random;
        System.out.println(randomValue.get());
    }
}
