import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exer1_Imparative {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 4, 6);
        List<Integer> evenNumbers = new ArrayList<>();

        // Filter even numbers using a loop
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        // Sort the filtered list
        Collections.sort(evenNumbers);

        // Print the result
        for (int number : evenNumbers) {
            System.out.println(number);
        }
    }
}
