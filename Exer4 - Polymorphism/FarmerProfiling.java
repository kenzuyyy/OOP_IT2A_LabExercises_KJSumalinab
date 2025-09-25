public class FarmerProfiling {
    private String name;
    private int age;
    private String farmLocation;
    private String cropType;

    public FarmerProfiling(String name, int age, String farmLocation, String cropType) {
        this.name = name;
        this.age = age;
        this.farmLocation = farmLocation;
        this.cropType = cropType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFarmLocation() {
        return farmLocation;
    }

    public void setFarmLocation(String farmLocation) {
        this.farmLocation = farmLocation;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public void setCropType(int cropCode) {
        switch (cropCode) {
            case 1:
                this.cropType = "Corn";
                break;
            case 2:
                this.cropType = "Wheat";
                break;
            case 3:
                this.cropType = "Rice";
                break;
            default:
                this.cropType = "Unknown";
        }
    }

    public String describeCrop() {
        return "This farmer grows " + cropType;
    }
}

class CornFarmer extends FarmerProfiling {
    public CornFarmer(String name, int age, String farmLocation) {
        super(name, age, farmLocation, "Corn");
    }

    @Override
    public String describeCrop() {
        return "This farmer grows Corn - used for food and animal feed.";
    }
}

class WheatFarmer extends FarmerProfiling {
    public WheatFarmer(String name, int age, String farmLocation) {
        super(name, age, farmLocation, "Wheat");
    }

    @Override
    public String describeCrop() {
        return "This farmer grows Wheat - important for bread and flour.";
    }
}

class RiceFarmer extends FarmerProfiling {
    public RiceFarmer(String name, int age, String farmLocation) {
        super(name, age, farmLocation, "Rice");
    }

    @Override
    public String describeCrop() {
        return "This farmer grows Rice - a staple food in many countries.";
    }
}
