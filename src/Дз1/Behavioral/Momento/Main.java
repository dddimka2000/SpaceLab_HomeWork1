package Äç1.Behavioral.Momento;

public class Main {
    public static void main(String[] args) {
        Originator originator=new Originator("Originator");
        CareTaker careTaker=new CareTaker();
        careTaker.setMomento(new Momento("Momento"));
        System.out.println(careTaker.getMomento().state);
        System.out.println(originator.getState());
    }
}
