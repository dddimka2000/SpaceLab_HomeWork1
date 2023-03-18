package Äç1.Behavioral.ChainOfResponsibility;

public class Console extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("Console: "+message);
    }
}
