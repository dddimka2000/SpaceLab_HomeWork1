package Äç1.Structural.Proxy;

public class Main {
    public static void main(String[] args) {
        Run run=new Project("https://www.google.com.ua/");
        Run run2=new Proxy("https://www.google.com.ua/2");
        run2.run();


    }
}
