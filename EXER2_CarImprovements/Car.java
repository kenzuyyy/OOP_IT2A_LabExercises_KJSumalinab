package EXER2_CarImprovements;

public class Car {
    private String color;
    private String plateNo;
    private String model;
    private String chassisNo;
    private String yearModel;

    public Car() {
        this.color = "";
        this.plateNo = "";
        this.model = "";
        this.chassisNo = "";
        this.yearModel = "";
    }

    public Car(String color, String plateNo, String model, String chassisNo, String yearModel) {
        this.color = color;
        this.plateNo = plateNo;
        this.model = model;
        this.chassisNo = chassisNo;
        this.yearModel = yearModel;
    }

    public void displayInfo() {
        String info = "";
        info += "Color: " + this.color + "\n";
        info += "Plate No: " + this.plateNo + "\n";
        info += "Model: " + this.model + "\n";
        info += "Chassis No: " + this.chassisNo + "\n";
        info += "Year Model: " + this.yearModel + "\n";
        System.out.print(info);
    }
}