public class FarmerProfilingTester {
    public static void main(String[] args) {
        FarmerProfiling f1 = new CornFarmer("Jack Stone", 45, "Magsaysay - 1");
        FarmerProfiling f2 = new WheatFarmer("Jack Cooley", 38, "Magapo");
        FarmerProfiling f3 = new RiceFarmer("May Tommy Hotdog", 50, "Riverside");

        f1.setCropType(2);
        f2.setCropType("Corn");
        f3.setCropType(3);

        FarmerProfiling[] farmers = {f1, f2, f3};

        for (FarmerProfiling farmer : farmers) {
            System.out.println(farmer.getName() + ", Age: " + farmer.getAge() +
                    ", Location: " + farmer.getFarmLocation() +
                    ", Crop: " + farmer.getCropType());
            System.out.println("   " + farmer.describeCrop());
        }
    }
}