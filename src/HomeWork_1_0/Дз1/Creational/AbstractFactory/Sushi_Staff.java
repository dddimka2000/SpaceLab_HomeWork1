package HomeWork_1_0.Äç1.Creational.AbstractFactory;

public class Sushi_Staff implements Staff {
    @Override
    public Chef getChef() {
        return new Sushi_chef();
    }

    @Override
    public Waiter getWaiter() {
        return new Sushi_waiter();
    }
}
