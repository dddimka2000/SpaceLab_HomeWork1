package org.example.jbdc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Products_Dao_jdbc implements Dao_jdbc {
    Connection connection;

    public Products_Dao_jdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void read() throws SQLException {
        Statement statement = connection.createStatement();
        System.out.println("--------------------Products--------------------");
        ResultSet resultSet = statement.executeQuery("select * FROM Products");
        while (resultSet.next()) {
            System.out.print("id: " + resultSet.getInt("id"));
            System.out.print(" Productscol: " + resultSet.getString("Productscol"));
            System.out.println(" Price: " + resultSet.getInt("Price"));
        }
    }

    @Override
    public void create(String name) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Products (Productscol) values ('" + name + "')");
    }
    public void create(String name, int price) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Products (Productscol,Price) values ('" + name + "'," + price + ")");
    }
    public void create(int price) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Products (Price) values (" + price + ")");
    }



    @Override
    public <T> void update(T new_name, T name) throws SQLException {
        Statement statement = connection.createStatement();
        if (name instanceof String) {
            statement.executeUpdate("UPDATE Users set Productscol=" + new_name + "WHERE name=" + name + "");
        } else {
            statement.executeUpdate("UPDATE Users set Price=" + new_name + "WHERE name=" + name + "");
        }
    }


    @Override
    public void delete(String name) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("Delete From Products Where Productscol=" + name);
        statement.execute("ALTER TABLE Products AUTO_INCREMENT = 1");
    }
    public void delete(int name) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("Delete From Products Where Price=" + name);
        statement.execute("ALTER TABLE Products AUTO_INCREMENT = 1");
    }
    public void deleteId(int name) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("Delete From Products Where id=" + name);
        statement.execute("ALTER TABLE Products AUTO_INCREMENT = 1");
    }
}
