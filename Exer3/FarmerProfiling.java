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
}
