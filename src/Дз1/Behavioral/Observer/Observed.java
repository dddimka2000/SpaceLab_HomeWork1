package Äç1.Behavioral.Observer;

public interface Observed {
        void addObserver(Observer o);
        void removeObserver(Observer o);
        void notifyObservers();
}
