package HomeWork_1_0.Äç1.Structural.Bridge;

public class Audi extends Car{
    public Audi(BridgeSet bridgeSet) {
        super(bridgeSet);
    }

    @Override
    void drive() {
        System.out.println("Drive Audi");

    }
}
