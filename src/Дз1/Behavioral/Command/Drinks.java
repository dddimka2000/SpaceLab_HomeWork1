package Äç1.Behavioral.Command;

import java.util.ArrayList;
import java.util.List;

public class Drinks {
    List<Drink> drinks=new ArrayList();

    public void addDrinks(Drink drink) {
        this.drinks.add(drink);
    }
    public void Run(){
        for(Drink drink:drinks){
            drink.drink();
        }
    }
}
