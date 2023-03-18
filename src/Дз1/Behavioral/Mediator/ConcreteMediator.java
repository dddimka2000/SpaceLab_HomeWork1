package Äç1.Behavioral.Mediator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator{
    List<Computer> computerList=new ArrayList<>();

    public void addComputerList(Computer computer) {
        computerList.add(computer);
    }

    @Override
    public void requestAll(Computer computer) {
        computer.setTrue();
        for(Computer comp:computerList){
            if (comp!=computer){
                comp.setFalse();
            }
        }

    }
}
