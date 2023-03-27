package HomeWork_1_0.Äç1.Structural.Adapter;

public class AdapterCarWheels extends Wheels implements Wash{

    @Override
    public void wash() {
        clean();
    }
}
