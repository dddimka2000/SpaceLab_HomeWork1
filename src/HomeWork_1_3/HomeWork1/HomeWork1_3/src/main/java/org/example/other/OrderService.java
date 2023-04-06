package org.example.other;
import java.util.ArrayList;

public class OrderService {
    String name;
    ArrayList<String> products;

    public OrderService(String name, ArrayList<String> products) {
        this.name = name;
        this.products = products;
    }

}
