package Äç1.Creational.AbstractFactory;

public class Pizza_Staff implements Staff {
    @Override
    public Chef getChef() {
        return new Pizza_chef();
    }

    @Override
    public Waiter getWaiter() {
        return new Pizza_waiter();
    }
}
