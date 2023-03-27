package HomeWork_1_0.Äç1.Structural.Bridge;

public abstract class Car {
    BridgeSet bridgeSet;
    public Car(BridgeSet bridgeSet) {
        this.bridgeSet = bridgeSet;
    }

    abstract void drive();
}
