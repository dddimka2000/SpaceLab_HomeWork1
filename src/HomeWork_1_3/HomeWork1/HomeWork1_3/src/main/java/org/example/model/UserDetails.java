package org.example.model;

public class UserDetails {

    private int userDetailsId;
    private int age;
    private String car;
    private int userId;

    public UserDetails(int userDetailsId, int age, String car,User user) {
        this.userDetailsId = userDetailsId;
        this.age = age;
        this.car = car;
        this.userId = user.getUserId();
    }

    public UserDetails(int age, String car, User user) {
        this.age = age;
        this.car = car;
        this.userId = user.getUserId();
    }

    public UserDetails() {
    }

    public int getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(int userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public UserDetails(int userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUser(int user) {
        this.userId = userId;
    }
}