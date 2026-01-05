package builtin;

import AgriConnect.Farmers;
import AgriConnect.Marketplace;
import AgriConnect.Product;

public class Main {
    public static void main(String[] args) {

        Farmers farmer1 = new Farmers("Juan Dela Cruz", "Davao Oriental");
        farmer1.displayInfo();

        Product rice = new Product("Rice", 45.0);
        Product corn = new Product("Corn", 30.0);

        Marketplace market = new Marketplace();
        market.addProduct(rice);
        market.addProduct(corn);

        market.showProducts();
    }
}
