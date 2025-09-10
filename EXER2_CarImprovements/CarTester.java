package EXER2_CarImprovements;

public class CarTester {
    public static void main(String[] args) {
        Car[] cars = new Car[10];
        cars[0] = new Car("Red", "ABC123", "Toyota Vios", "CHS456789", "2022");
        cars[1] = new Car("Blue", "DEF456", "Honda Civic", "CHS123456", "2021");
        cars[2] = new Car("Black", "GHI789", "Ford Ranger", "CHS987654", "2020");
        cars[3] = new Car("White", "JKL012", "Hyundai Accent", "CHS654321", "2019");
        cars[4] = new Car("Silver", "MNO345", "Mazda 3", "CHS321654", "2018");
        cars[5] = new Car("Green", "PQR678", "Kia Rio", "CHS456123", "2017");
        cars[6] = new Car("Yellow", "STU901", "Chevrolet Spark", "CHS789123", "2016");
        cars[7] = new Car("Orange", "VWX234", "Suzuki Swift", "CHS234567", "2015");
        cars[8] = new Car("Purple", "YZA567", "Nissan Almera", "CHS567890", "2014");
        cars[9] = new Car("Brown", "BCD890", "Mitsubishi Mirage", "CHS890123", "2013");

        for (int i = 0; i < cars.length; i++) {
            System.out.println("Car #" + (i + 1));
            cars[i].displayInfo();
            System.out.println();
        }
    }
}