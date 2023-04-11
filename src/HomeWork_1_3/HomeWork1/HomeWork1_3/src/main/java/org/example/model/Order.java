package org.example.model;

public class Order {
    int id;
    String products;
    int total_price;
    int user_id;

    public Order(User user) {
        this.user_id = user.getUserId();
    }

    Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
