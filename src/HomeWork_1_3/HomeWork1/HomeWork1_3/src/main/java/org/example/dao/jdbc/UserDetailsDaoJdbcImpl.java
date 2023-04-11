package org.example.dao.jdbc;


import org.example.dao.interf.DaoJdbc;
import org.example.model.UserDetails;

import java.sql.*;

public class UserDetailsDaoJdbcImpl implements DaoJdbc<UserDetails,Connection> {
    private static final String create = "Insert into user_details (id,age,car,user_Id) Values(?,?,?,?)";
    private static final String delete = "Delete from user_details Where user_Id= ?";
    private static final String update = "Update user_details set age=?,car=?,user_Id=? Where id= ?";
    private static final String read = "SELECT* from user_details";


    private static Connection connection;
    private UserDetailsDaoJdbcImpl userDetailsDaoJdbcImpl;

    private UserDetailsDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public UserDetailsDaoJdbcImpl() {
    }

    @Override
    public UserDetailsDaoJdbcImpl getSingleton(Connection connection) {
        if (userDetailsDaoJdbcImpl == null) {
            userDetailsDaoJdbcImpl = new UserDetailsDaoJdbcImpl(connection);
        }
        return userDetailsDaoJdbcImpl;
    }


    @Override
    public void create(UserDetails table) {
        try (PreparedStatement statement =connection.prepareStatement(create)) {
            statement.setInt(2, table.getAge());
            statement.setString(3, table.getCar());
            statement.setInt(1, table.getUserDetailsId());
            statement.setInt(4, table.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(UserDetails table) {
        try (PreparedStatement statement = connection.prepareStatement(update)) {
            statement.setInt(4, table.getUserDetailsId());
            statement.setInt(1, table.getAge());
            statement.setString(2, table.getCar());
            statement.setInt(3, table.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(UserDetails table) {
        try (PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setInt(1, table.getUserId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void read() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(read)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.print("id: " + resultSet.getInt("id"));
                System.out.print(" age: " + resultSet.getInt("age"));
                System.out.print(" car: " + resultSet.getString("car"));
                System.out.println(" users_id: " + resultSet.getInt("user_Id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
