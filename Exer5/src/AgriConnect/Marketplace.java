package AgriConnect;

import java.util.ArrayList;

public class Marketplace {

    private final ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showProducts() {
        System.out.println("\nMarketplace Products:");
        for (Product p : products) {
            System.out.println("- " + p.getName() + " : " + p.getPrice() + " Pesos");
        }
    }
}
