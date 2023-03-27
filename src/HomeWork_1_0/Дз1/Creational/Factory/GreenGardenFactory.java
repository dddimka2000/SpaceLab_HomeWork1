package HomeWork_1_0.Äç1.Creational.Factory;

public class GreenGardenFactory implements GardenFactory {
    @Override
    public Garden createGarden() {
        return new GreenGarden();
    }
}
