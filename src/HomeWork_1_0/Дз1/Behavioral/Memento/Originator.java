package HomeWork_1_0.Äç1.Behavioral.Memento;

public class Originator {
    String state;

    public Originator(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }


    Memento getMomento() {
        return new Memento(state);
    }

    void getDataFromMomento(Memento memento) {
        state = memento.state;
    }
}
