package org.example.jbdc;

import org.example.other.Data;
import org.example.password.pass;

import java.sql.*;
import java.util.Scanner;

public class JBDC_DATABASE implements Data {
    @Override
    public void getDataBase() throws SQLException, ClassNotFoundException {
        implementation();
    }

    private void implementation() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_schema",
                "root", pass.password); Statement statement = connection.createStatement();) {
//            statement.execute("drop table users");
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Users(id Mediumint NOT NULL AUTO_INCREMENT,name CHAR(30) NOT NULL, PRIMARY KEY (id))");
            clear();

            statement.executeUpdate("INSERT INTO Users (name) values ('dima')");
            //SHOW DELETE
            statement.execute("Delete From Users Where Name='dima'");
            statement.execute("ALTER TABLE Users AUTO_INCREMENT = 1");
            //
            statement.executeUpdate("INSERT INTO Users (name) values ('dima')");
            //SHOW UPDATE!
            statement.executeUpdate("UPDATE Users set name='dima2' WHERE name='dima'");
            statement.executeUpdate("UPDATE Users set name='dima' WHERE name='dima2'");
            //
            statement.executeUpdate("INSERT INTO Users (name) values ('dima2')");
            statement.executeUpdate("INSERT INTO Users (name) values ('dima3')");
            statement.executeUpdate("INSERT INTO Users (name) values ('dima4')");
            statement.executeUpdate("INSERT INTO Users (name) values ('dima5')");
            //SHOW READ
            ResultSet resultSet = statement.executeQuery("select * FROM users");
            System.out.println("--------------------Users---------------------------");
            while (resultSet.next()) {
                System.out.print(" id: " + resultSet.getInt("id"));
                System.out.println(" name: " + resultSet.getString("name"));
            }
            //
//            statement.execute("Delete From user_details Where users_id=1");
//            statement.executeUpdate("UPDATE user_details set car='Car2' WHERE users_id=1");
            statement.executeUpdate("INSERT INTO user_details (age,car,users_id) values (20,'Car1',1)");
            statement.executeUpdate("INSERT INTO user_details (age,car,users_id) values (30,'Car2',2)");
            statement.executeUpdate("INSERT INTO user_details (age,car,users_id) values (40,'Car3',3)");
            statement.executeUpdate("INSERT INTO user_details (age,car,users_id) values (50,'Car4',4)");
            System.out.println("--------------------user_details--------------------");
            resultSet = statement.executeQuery("select * FROM user_details");
            while (resultSet.next()) {
                System.out.print("id: " + resultSet.getInt("id"));
                System.out.print(" age: " + resultSet.getInt("age"));
                System.out.print(" car: " + resultSet.getString("car"));
                System.out.println(" users_id: " + resultSet.getInt("users_id"));
            }

//            statement.execute("Delete From Products Where Productscol='product1'");
//            statement.executeUpdate("UPDATE Products set Productscol='product2' WHERE Productscol='product1'");
            statement.executeUpdate("INSERT INTO Products (Productscol, Price) values ('product1',30)");
            statement.executeUpdate("INSERT INTO Products (Productscol, Price) values ('product2',15)");
            statement.executeUpdate("INSERT INTO Products (Productscol, Price) values ('product3',10)");
            statement.executeUpdate("INSERT INTO Products (Productscol, Price) values ('product4',1)");
            statement.executeUpdate("INSERT INTO Products (Productscol, Price) values ('product5',40)");
            statement.executeUpdate("INSERT INTO Products (Productscol, Price) values ('product6',10)");
            statement.executeUpdate("INSERT INTO Products (Productscol, Price) values ('product7',80)");
            statement.executeUpdate("INSERT INTO Products (Productscol, Price) values ('product8',40)");
            statement.executeUpdate("INSERT INTO Products (Productscol, Price) values ('product9',70)");
            statement.executeUpdate("INSERT INTO Products (Productscol, Price) values ('product10',45)");
            statement.executeUpdate("INSERT INTO Products (Productscol, Price) values ('product11',2)");
            statement.executeUpdate("INSERT INTO Products (Productscol, Price) values ('product12',50)");

            System.out.println("--------------------Products--------------------");
            resultSet = statement.executeQuery("select * FROM Products");
            while (resultSet.next()) {
                System.out.print("id: " + resultSet.getInt("id"));
                System.out.print(" Productscol: " + resultSet.getString("Productscol"));
                System.out.println(" Price: " + resultSet.getInt("Price"));
            }

//            statement.execute("Delete From shopping_cart Where products_id='1'");
//            statement.executeUpdate("UPDATE shopping_cart set Productscol='product2' WHERE Productscol='product1'");
            statement.executeUpdate("INSERT INTO shopping_cart (users_id, products_id) values (1,1)");
            statement.executeUpdate("INSERT INTO shopping_cart (users_id, products_id) values (2,2)");
            statement.executeUpdate("INSERT INTO shopping_cart (users_id, products_id) values (3,1)");
            statement.executeUpdate("INSERT INTO shopping_cart (users_id, products_id) values (3,4)");
            statement.executeUpdate("INSERT INTO shopping_cart (users_id, products_id) values (3,5)");
            statement.executeUpdate("INSERT INTO shopping_cart (users_id, products_id) values (3,6)");
            statement.executeUpdate("INSERT INTO shopping_cart (users_id, products_id) values (3,7)");
            statement.executeUpdate("INSERT INTO shopping_cart (users_id, products_id) values (3,8)");

            System.out.println("--------------------shopping_cart--------------------");
            resultSet = statement.executeQuery("select * FROM shopping_cart");
            while (resultSet.next()) {
                System.out.print("id: " + resultSet.getInt("id"));
                System.out.print(" users_id: " + resultSet.getString("users_id"));
                System.out.println(" products_id: " + resultSet.getInt("products_id"));
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Показать продукты. Лучше ввести 3, а так от 1 до 4 : ");
            int show_num = scanner.nextInt();
            resultSet = statement.executeQuery("SELECT * FROM my_schema.shopping_cart\n" +
                    "CROSS  JOIN products Using (id)\n" +
                    "Where shopping_cart.users_id=" + show_num);
            while (resultSet.next()) {
                System.out.print("id: " + resultSet.getInt("id"));
                System.out.print(" users_id: " + resultSet.getString("users_id"));
                System.out.println(" Productscol: " + resultSet.getString("Productscol"));
            }



            System.out.print("Удалить продукты пользователя. Лучше ввести 3, а так от 1 до 4 : ");
            int delete_num = scanner.nextInt();
            try {
                statement.executeUpdate("DELETE FROM my_schema.shopping_cart Where shopping_cart.users_id=" + delete_num + ";");
                System.out.println("Удалено!");
            } catch (Exception exception) {
                System.out.println("Не удалилось :(");
            }

            System.out.println("--------------------Orders--------------------");
            if (delete_num != 1) statement.executeUpdate("INSERT INTO orders (users_id) values (1)");
            if (delete_num != 2) statement.executeUpdate("INSERT INTO orders (users_id) values (2)");
            if (delete_num != 3) statement.executeUpdate("INSERT INTO orders (users_id) values (3)");
            resultSet = statement.executeQuery("select * FROM orders");
            while (resultSet.next()) {
                System.out.print("id: " + resultSet.getString("id"));
                System.out.println(" Orderscol: " + resultSet.getString("Orderscol"));
            }
            System.out.println("--------------------------------------------");
            System.out.print("Показать продукты пользователя. Лучше ввести 3, а так от 1 до 4 : ");
            int show_num2 = scanner.nextInt();

            resultSet = statement.executeQuery("select * FROM orders where users_id=" + show_num2);
            while (resultSet.next()) {
                System.out.print("Orderscol: " + resultSet.getString("Orderscol"));
            }

        }

    }

    private void clear() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_schema", "root", pass.password); Statement statement = connection.createStatement();) {
            statement.execute("Delete From orders");
            statement.execute("Delete From shopping_cart");
            statement.execute("Delete From user_details");
            statement.execute("Delete From Products");
            statement.execute("Delete From Users");
            statement.execute("ALTER TABLE user_details AUTO_INCREMENT = 1");
            statement.execute("ALTER TABLE Products AUTO_INCREMENT = 1");
            statement.execute("ALTER TABLE Users AUTO_INCREMENT = 1");
            statement.execute("ALTER TABLE orders AUTO_INCREMENT = 1");
            statement.execute("ALTER TABLE shopping_cart AUTO_INCREMENT = 1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

