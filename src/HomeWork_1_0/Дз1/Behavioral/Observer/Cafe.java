package HomeWork_1_0.Äç1.Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

public class Cafe implements Observed {
    List<String> drinks = new ArrayList<>();
    List<Observer> clients = new ArrayList<>();

    public void addDrinks(String drinks) {
        this.drinks.add(drinks);
        notifyObservers();
    }

    public void removeDrinks(String drinks) {
        this.drinks.remove(drinks);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        clients.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        clients.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : clients) {
            observer.handleEvent(drinks);
        }
    }
}
