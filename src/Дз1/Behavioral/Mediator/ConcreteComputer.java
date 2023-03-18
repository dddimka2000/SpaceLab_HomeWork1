package Äç1.Behavioral.Mediator;

public class ConcreteComputer implements Computer{
    boolean status;
    Mediator mediator;

    public ConcreteComputer(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setFalse() {
        status=false;
        System.out.println("False");
    }

    @Override
    public void setTrue() {
        status=true;
        System.out.println("True");
    }

    @Override
    public void changeStatus() {
        mediator.requestAll(this);
    }
}
