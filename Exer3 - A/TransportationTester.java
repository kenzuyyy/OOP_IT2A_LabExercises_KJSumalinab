public class TransportationTester {
    public static void main(String[] args) {
        // Air
        Transportation heli = new Helicopter(5);
        Transportation plane = new Airplane(180);
        Transportation shuttle = new SpaceShuttle(7);

        // Land
        Transportation truck = new Truck(3);
        Transportation suv = new SUV(7);
        Transportation tricycle = new Tricycle(3);
        Transportation motor = new Motorcycle(2);
        Transportation kariton = new Kariton(1);

        // Water
        Transportation boat = new Boat(20);
        Transportation sub = new Submarine(50);

        // Test all transports
        Transportation[] transports = {
            heli, plane, shuttle,
            truck, suv, tricycle, motor, kariton,
            boat, sub
        };

        for (Transportation t : transports) {
            t.displayInfo();
            t.move();
            System.out.println("------------------");
        }
    }
}
