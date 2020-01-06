import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * FunctionalInterfaceDemo
 */
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        Consumer<Integer> consumer = (age) -> System.out.println(age);

        consumer
            .andThen((age) -> System.out.println("Functional interface demo. Your age is " + age))
            .accept(23);

        Predicate<Integer> predicate = (number) -> number % 2 == 0;
        System.out.println(predicate.and(n -> n < 50)
                    .and(n -> n > 5)
                    .test(52));

        
        Function<Integer, Integer> function = (a) -> a * 2;
        System.out.println(function
            .andThen(n -> n * 2)
            .andThen(n -> n + 2)
            .apply(5));

        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a * b;
        Double d = biFunction
                        .andThen(area -> area * 0.5)
                        .apply(4, 5);
        System.out.println("area of triangle is " + d);

        Supplier<Integer> supplier = () -> {return new Random().nextInt(100);};
        System.out.println(supplier.get());
    }
}