package HomeWork_1_0.��1.Structural.Bridge;

public abstract class Color {
    BridgeSet bridgeSet;
    public Color(BridgeSet bridgeSet) {
        this.bridgeSet = bridgeSet;
    }

    abstract void show();

}
