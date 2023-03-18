package Дз1.Creational.AbstractFactory;

public class Cafe {
    public static void main(String[] args) {
        System.out.println("Зашли в пиццерию");
        Staff pizza_staff=new Pizza_Staff();
        pizza_staff.getChef().cook();
        pizza_staff.getWaiter().serve();
        System.out.println("\nЗашли в Суширию");
        Staff sushi_staff=new Sushi_Staff();
        sushi_staff.getChef().cook();
        sushi_staff.getWaiter().serve();
    }
}
