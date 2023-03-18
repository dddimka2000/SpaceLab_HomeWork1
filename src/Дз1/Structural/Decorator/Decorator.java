package Äç1.Structural.Decorator;

public class Decorator {
    public static void main(String[] args) {
        Computer computer1=new ComputerA(new ComputerB(new ComputerC(new ComputerMain())));
        System.out.println(computer1.turnOn());
        Computer computer2=new ComputerC(new ComputerB(new ComputerA(new ComputerMain())));
        System.out.println(computer2.turnOn());
    }
}
