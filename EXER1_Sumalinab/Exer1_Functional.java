import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exer1_Functional{
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        Predicate<String> startsAfterB = name -> name.compareToIgnoreCase("C") >= 0;

        List<String> processedNames = names.stream()
            .filter(startsAfterB)
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        processedNames.forEach(System.out::println);
    }
}
