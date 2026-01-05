package AgriConnect;

public class Farmers {

    private final String name;
    private final String location;

    public Farmers(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void displayInfo() {
        System.out.println("\nFarmer Name: " + name);
        System.out.println("Location: " + location);
    }
}
