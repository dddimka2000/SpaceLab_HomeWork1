package Äç1.Structural.Decorator;

public class ComputerB extends ComputerDecorator{
    public ComputerB(Computer computer) {
        super(computer);
    }

    private String turnOnB(){
        return "Computer B ";
    }

    @Override
    public String turnOn() {
        return super.turnOn()+turnOnB();
    }
}
