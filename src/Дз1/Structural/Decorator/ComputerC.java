package Äç1.Structural.Decorator;

public class ComputerC extends ComputerDecorator{
    public ComputerC(Computer computer) {
        super(computer);
    }
    private String turnOnC(){
        return "Computer C ";
    }

    @Override
    public String turnOn() {
        return super.turnOn()+turnOnC();
    }
}
