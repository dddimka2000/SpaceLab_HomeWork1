package Дз1.Creational.Singelton;

public class Program_start {
    public static void main(String[] args) {
        System.out.println("Проверка на работу синглтона");
        System.out.println( Singelton.getSingelton());
        System.out.println( Singelton.getSingelton());

        Singelton.getSingelton().addLogInfo("1-st");
        Singelton.getSingelton().addLogInfo("2-nd");
        Singelton.getSingelton().addLogInfo("3-th");
        Singelton.getSingelton().showLogFile();

    }
}
