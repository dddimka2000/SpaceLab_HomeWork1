package HomeWork_1_0.Äç1.Behavioral.Strategy;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setActivity(new Sleep());
        person.doSomething();
        person.setActivity(new Run());
        person.doSomething();
        person.setActivity(new Eat());
        person.doSomething();
    }

}
