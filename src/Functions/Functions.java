package Functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Functions {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> pureFunction = (number, times) -> number *times;
        System.out.println(pureFunction.apply(9, 2));
        System.out.println("=====");
        int[] array = new int[]{10, 20, 30, 5, 9};
        final int[] greaterThanTen = greaterThanNumber(array, number -> number > 10);

        for (int i : greaterThanTen) {
            System.out.println(i);
        }
        System.out.println("=====");
        final int[] evenNumbers = greaterThanNumber(array, number -> number % 2 == 0);

        for (int i : evenNumbers) {
            System.out.println(i);
        }
        System.out.println("=====");
        final int[] oddNumbers = greaterThanNumber(array, number -> number % 2 != 0);

        for (int i : oddNumbers) {
            System.out.println(i);
        }

        System.out.println("=====");

        List<String> numbers = List.of("1", "2", "3", "4", "5");
        int sum = numbers.stream()
                        .mapToInt(Integer::valueOf)
                        .sum();
        System.out.println(sum);
    }

    public static int[] greaterThanNumber(int[] numbers, GreaterThanNumber greaterThanNumber) {
        return Arrays.stream(numbers)
                     .filter(greaterThanNumber::apply)
                     .toArray();
    }
}

/**
 * GreaterThanNumber
 */
interface GreaterThanNumber {
    public boolean apply(int number);
}
