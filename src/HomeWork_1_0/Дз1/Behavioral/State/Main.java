package HomeWork_1_0.��1.Behavioral.State;

public class Main {
    public static void main(String[] args) {
        Person person=new Person(new Eat());
        for (int i=0;i<10;i++){
        person.changeActivity();
        person.doSomething();
        }
    }
}
