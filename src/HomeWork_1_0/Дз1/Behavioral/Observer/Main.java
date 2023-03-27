package HomeWork_1_0.Äç1.Behavioral.Observer;

public class Main {
    public static void main(String[] args) {
        Cafe cafe=new Cafe();

        cafe.addDrinks("Tea");
        Observer client1=new Clients("Dima");
        Observer client2=new Clients("Jack");
        cafe.addObserver(client2);
        cafe.addObserver(client1);
        cafe.addDrinks("Coffee");
        cafe.addDrinks("Green tea");
    }
}
