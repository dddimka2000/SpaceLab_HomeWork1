package Äç1.Behavioral.ChainOfResponsibility;

public class FilePrinter extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("File: "+message);
    }
}
