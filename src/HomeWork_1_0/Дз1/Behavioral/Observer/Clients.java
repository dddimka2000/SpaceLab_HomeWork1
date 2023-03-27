package HomeWork_1_0.Äç1.Behavioral.Observer;

import java.util.List;

public class Clients implements Observer{
    String name;

    public Clients(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> drinks) {
        System.out.println("Dear "+name+"\n"+"drinks: "+ drinks+"\n");
    }
}
