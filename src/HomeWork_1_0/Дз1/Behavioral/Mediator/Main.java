package HomeWork_1_0.��1.Behavioral.Mediator;

public class Main {
    public static void main(String[] args) {
        ConcreteMediator concreteMediator=new ConcreteMediator();
        concreteMediator.addComputerList(new ConcreteComputer(concreteMediator));
        concreteMediator.addComputerList(new ConcreteComputer(concreteMediator));
        ConcreteComputer concreteComputer=new ConcreteComputer(concreteMediator);
        concreteMediator.addComputerList(concreteComputer);
        concreteMediator.requestAll(concreteComputer);
    }
}
