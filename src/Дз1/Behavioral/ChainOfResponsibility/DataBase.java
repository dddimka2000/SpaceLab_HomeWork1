package ��1.Behavioral.ChainOfResponsibility;

public class DataBase extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("DataBase: "+ message);
    }
}
