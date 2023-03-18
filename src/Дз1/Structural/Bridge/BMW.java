package Äç1.Structural.Bridge;

public class BMW extends Car{
    public BMW(BridgeSet bridgeSet) {
        super(bridgeSet);
    }

    @Override
    void drive() {
        System.out.println("Drive BMW");
    }
}
