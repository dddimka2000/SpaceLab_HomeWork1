package HomeWork_1_0.��1.Behavioral.Memento;

public class Main {
    public static void main(String[] args) {
        Originator originator=new Originator("Originator");
        CareTaker careTaker=new CareTaker();
        careTaker.setMomento(new Memento("Memento"));
        System.out.println(careTaker.getMomento().state);
        System.out.println(originator.getState());
    }
}
