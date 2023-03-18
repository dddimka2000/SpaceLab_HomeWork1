package Äç1.Creational.Factory;

public class Creational{
    public static void main(String[] args) {
        GardenFactory gardenFactory1=new BlackGardenFactory();
        gardenFactory1.createGarden().plant();
        GardenFactory gardenFactory2=new GreenGardenFactory();
        gardenFactory2.createGarden().plant();

    }
}

