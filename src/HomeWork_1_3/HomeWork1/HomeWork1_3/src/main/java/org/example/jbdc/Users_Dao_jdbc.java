package org.example.jbdc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Users_Dao_jdbc implements Dao_jdbc{
    static Connection connection;
    public Users_Dao_jdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(String name) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Users (name) values ('" + name + "')");
    }


    @Override
    public void read() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("select * FROM users");
        System.out.println("--------------------Users---------------------------");
        while (resultSet.next()) {
            System.out.print(" id: " + resultSet.getInt("id"));
            System.out.println(" name: " + resultSet.getString("name"));
        }

    }

    @Override
    public void delete(String name) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("Delete From Users Where Name="+name);
        statement.execute("ALTER TABLE Users AUTO_INCREMENT = 1");
    }

    @Override
    public <T> void update(T new_name, T name) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE Products set name=" + new_name + "WHERE Productscol=" + name + "");
    }
}
