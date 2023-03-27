package HomeWork_1_0.Äç1.Behavioral.Command;

public class Command {
    public static void main(String[] args) {
        Drinks drinks=new Drinks();
        drinks.addDrinks(new Coffee());
        drinks.addDrinks(new Tea());
        drinks.Run();
    }
}
