package HomeWork_1_0.Äç1.Behavioral.Command;

import java.util.ArrayList;
import java.util.List;

public class Drinks {
    private List<Drink> drinks=new ArrayList();

    public void addDrinks(Drink drink) {
        this.drinks.add(drink);
    }
    public void Run(){
        for(Drink drink:drinks){
            drink.drink();
        }
    }
}
