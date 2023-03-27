package HomeWork_1_0.��1.Structural.Decorator;

abstract public class ComputerDecorator implements Computer{
    Computer computer;

    public ComputerDecorator(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String turnOn() {
        return computer.turnOn();
    }
}
