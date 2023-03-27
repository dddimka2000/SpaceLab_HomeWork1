package HomeWork_1_0.Äç1.Creational.Factory;

public class BlackGardenFactory implements GardenFactory {
    @Override
    public Garden createGarden() {
        return new BlackGarden();
    }
}
