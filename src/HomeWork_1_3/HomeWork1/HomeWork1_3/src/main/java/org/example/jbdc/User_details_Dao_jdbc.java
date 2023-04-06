package org.example.jbdc;

import org.example.hibernate.user_details.User_details;

import javax.swing.tree.RowMapper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User_details_Dao_jdbc implements Dao_jdbc {
    Connection connection;
    User_details_Dao_jdbc(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(String name) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO User_details (Productscol) values ('" + name + "')");
    }
    public void create(String name, int price) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO User_details (Productscol,Price) values ('" + name + "'," + price + ")");
    }
    public void create(int price) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO User_details (Price) values (" + price + ")");
    }
    @Override
    public <T> void update(T new_name, T name) throws SQLException {

    }

    @Override
    public void read() throws SQLException {
        System.out.println("--------------------user_details--------------------");
        ResultSet resultSet = connection.createStatement().executeQuery("select * FROM user_details");
        while (resultSet.next()) {
            System.out.print("id: " + resultSet.getInt("id"));
            System.out.print(" age: " + resultSet.getInt("age"));
            System.out.print(" car: " + resultSet.getString("car"));
            System.out.println(" users_id: " + resultSet.getInt("users_id"));
        }
    }

    @Override
    public void delete(String name) throws SQLException {

    }


}
