package Äç1.Structural.Bridge;

public class Black extends Color{
    public Black(BridgeSet bridgeSet) {
        super(bridgeSet);
    }

    @Override
    void show() {
        System.out.println("Black");
    }
}
