import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exer1_Declarative {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 4, 6);

        List<Integer> evenSorted = numbers.stream()
            .filter(n -> n % 2 == 0)      // Select even numbers
            .sorted()                    // Sort them
            .collect(Collectors.toList()); // Collect into a new list

        evenSorted.forEach(System.out::println); // Display result
    }
}
