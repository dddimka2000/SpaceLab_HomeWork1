package Äç1.Behavioral.Momento;

public class Originator {
    String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Originator(String state) {
        this.state = state;
    }

    Momento getMomento(){
        return new Momento(state);
    }
    void getDataFromMomento(Momento momento){
        state= momento.state;
    }
}
