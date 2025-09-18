abstract class Transportation {
    protected String name;
    protected int capacity;

    public Transportation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public abstract void move();

    public void displayInfo() {
        System.out.println("Name: " + name + ", Capacity: " + capacity);
    }
}

abstract class AirTransport extends Transportation {
    public AirTransport(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public void move() {
        System.out.println(name + " is flying in the sky.");
    }
}

class Helicopter extends AirTransport {
    public Helicopter(int capacity) {
        super("Helicopter", capacity);
    }
}

class Airplane extends AirTransport {
    public Airplane(int capacity) {
        super("Airplane", capacity);
    }
}

class SpaceShuttle extends AirTransport {
    public SpaceShuttle(int capacity) {
        super("Space Shuttle", capacity);
    }
}

abstract class LandTransport extends Transportation {
    public LandTransport(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public void move() {
        System.out.println(name + " is driving on land.");
    }
}

class Truck extends LandTransport {
    public Truck(int capacity) {
        super("Truck", capacity);
    }
}

class SUV extends LandTransport {
    public SUV(int capacity) {
        super("SUV", capacity);
    }
}

class Tricycle extends LandTransport {
    public Tricycle(int capacity) {
        super("Tricycle", capacity);
    }
}

class Motorcycle extends LandTransport {
    public Motorcycle(int capacity) {
        super("Motorcycle", capacity);
    }
}

class Kariton extends LandTransport {
    public Kariton(int capacity) {
        super("Kariton", capacity);
    }
}

abstract class WaterTransport extends Transportation {
    public WaterTransport(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public void move() {
        System.out.println(name + " is sailing on water.");
    }
}

class Boat extends WaterTransport {
    public Boat(int capacity) {
        super("Boat", capacity);
    }
}

class Submarine extends WaterTransport {
    public Submarine(int capacity) {
        super("Submarine", capacity);
    }
}

public class Transportation {
    public static void main(String[] args) {
        Helicopter helicopter = new Helicopter(5);
        Airplane airplane = new Airplane(150);
        SpaceShuttle spaceShuttle = new SpaceShuttle(7);

        Truck truck = new Truck(3);
        SUV suv = new SUV(7);
        Tricycle tricycle = new Tricycle(2);
        Motorcycle motorcycle = new Motorcycle(2);
        Kariton kariton = new Kariton(1);

        Boat boat = new Boat(20);
        Submarine submarine = new Submarine(10);

        helicopter.displayInfo();
        helicopter.move();

        airplane.displayInfo();
        airplane.move();

        spaceShuttle.displayInfo();
        spaceShuttle.move();

        truck.displayInfo();
        truck.move();

        suv.displayInfo();
        suv.move();

        tricycle.displayInfo();
        tricycle.move();

        motorcycle.displayInfo();
        motorcycle.move();

        kariton.displayInfo();
        kariton.move();

        boat.displayInfo();
        boat.move();

        submarine.displayInfo();
        submarine.move();
    }
}