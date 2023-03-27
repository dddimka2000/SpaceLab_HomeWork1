package HomeWork_1_0.Äç1.Structural.Bridge;

public class Bridge {
    public static void main(String[] args) {
        Car car = new Audi(new CarBridge());
        car.drive();
        Color color = new Black(new ColorBridge());
        color.bridgeSet.set_method();
        color.show();

    }
}
