package Äç1.Structural.Decorator;

public class ComputerA extends ComputerDecorator{
    public ComputerA(Computer computer) {
        super(computer);
    }

    private String turnOnA(){
        return "Computer A ";
    }

    @Override
    public String turnOn() {
        return super.turnOn()+turnOnA();
    }
}
