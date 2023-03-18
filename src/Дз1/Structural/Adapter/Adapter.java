package Äç1.Structural.Adapter;

public class Adapter {
    public static void main(String[] args) {
        Wash car1=new Car();
        car1.wash();
        Wash car2=new AdapterCarWheels();
        car2.wash();
    }
}
