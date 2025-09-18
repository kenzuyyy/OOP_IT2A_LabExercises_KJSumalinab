public class FarmerProfilingTester {
    public static void main(String[] args) {
        FarmerProfiling f1 = new FarmerProfiling(null, 0, null, null);
        FarmerProfiling f2 = new FarmerProfiling(null, 0, null, null);
        FarmerProfiling f3 = new FarmerProfiling(null, 0, null, null);

        f1.setName("Jack Stone");
        f1.setAge(45);
        f1.setFarmLocation("Magsaysay - 1");
        f1.setCropType("Corn");
        System.out.println("Farmer 1: " + f1.getName() + ", Age: " + f1.getAge() + ", Location: " + f1.getFarmLocation() + ", Crop: " + f1.getCropType());

        f2.setName("Jack Cooley");
        f2.setAge(38);
        f2.setFarmLocation("Magapo");
        f2.setCropType("Wheat");
        System.out.println("Farmer 2: " + f2.getName() + ", Age: " + f2.getAge() + ", Location: " + f2.getFarmLocation() + ", Crop: " + f2.getCropType());

        f3.setName("May Tommy Hotdog");
        f3.setAge(50);
        f3.setFarmLocation("Riverside");
        f3.setCropType("Rice");
        System.out.println("Farmer 3: " + f3.getName() + ", Age: " + f3.getAge() + ", Location: " + f3.getFarmLocation() + ", Crop: " + f3.getCropType());

    }
}

