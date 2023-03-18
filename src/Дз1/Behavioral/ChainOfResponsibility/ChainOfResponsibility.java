package Äç1.Behavioral.ChainOfResponsibility;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        MessagePrinter messagePrinter=new Console();
        DataBase dataBase=new DataBase();
        messagePrinter.setNextMessagePrinter(dataBase);
        dataBase.setNextMessagePrinter(new FilePrinter());
        messagePrinter.print("hello");
    }
}
