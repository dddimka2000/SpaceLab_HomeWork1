package Äç1.Structural.FlyWeight;

public class Main {
    public static void main(String[] args) {
        FlyWeight flyWeight=new FlyWeight();
        Tea tea1=flyWeight.getTea("black");
        Tea tea2=flyWeight.getTea("black");
        Tea tea3=flyWeight.getTea("green");
        System.out.println(tea1.color+"\n"+tea1);
        System.out.println(tea2.color+"\n"+tea2);
        System.out.println(tea3.color+"\n"+tea3);

    }
}
