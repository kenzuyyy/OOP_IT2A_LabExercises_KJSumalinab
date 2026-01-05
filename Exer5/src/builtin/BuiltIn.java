package builtin;

import AgriConnect.Product;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BuiltIn {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            Product rice = new Product("Rice", 45.0);
            Product corn = new Product("Corn", 30.0);
            Product banana = new Product("Banana", 20.0);

            ArrayList<String> productNames = new ArrayList<>();
            productNames.add(rice.getName());
            productNames.add(corn.getName());
            productNames.add(banana.getName());

            Collections.sort(productNames);

            LocalDate today = LocalDate.now();
            
            System.out.print("Enter discount percentage for Rice (e.g., 10 for 10%): ");
            double discountPercent = sc.nextDouble();
            
            double discountedPrice = rice.getPrice() * (1 - discountPercent / 100);

            System.out.println("\nHello, " + name + "!");
            System.out.println("Today's date: " + today);
            System.out.println("Available products (sorted): " + productNames);
            System.out.println("Discounted price of Rice: " + discountedPrice + " Pesos");

        }
    }
}
