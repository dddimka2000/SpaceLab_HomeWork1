package ��1.Structural.Bridge;

public abstract class Car {
    BridgeSet bridgeSet;
    public Car(BridgeSet bridgeSet) {
        this.bridgeSet = bridgeSet;
    }

    abstract void drive();
}
