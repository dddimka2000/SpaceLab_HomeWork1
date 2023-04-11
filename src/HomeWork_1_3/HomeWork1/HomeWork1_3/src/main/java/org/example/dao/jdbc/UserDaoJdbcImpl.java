package org.example.dao.jdbc;

import org.example.dao.interf.DaoJdbc;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoJdbcImpl implements DaoJdbc<User,Connection> {
    private static final String create = "Insert into user (id, name) Values(?, ?)";
    private static final String delete = "Delete from user Where id= ?";
    private static final String update = "Update user set name=? Where id= ?";
    private static final String read = "Select * FROM user";

    private static Connection connection;
    private static UserDaoJdbcImpl userDaoJdbcImpl = null;

    public UserDaoJdbcImpl() {
    }

    private UserDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public UserDaoJdbcImpl getSingleton(Connection connection) {
        if (userDaoJdbcImpl == null) {
            userDaoJdbcImpl = new UserDaoJdbcImpl(connection);
        }
        return userDaoJdbcImpl;
    }

    @Override
    public void create(User table) {
        try (PreparedStatement statement = connection.prepareStatement(create)) {
            statement.setInt(1, table.getUserId());
            statement.setString(2, table.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User table) {
        try (PreparedStatement statement = connection.prepareStatement(update)) {
            statement.setInt(2, table.getUserId());
            statement.setString(1, table.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(User table) {
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
                System.out.println(" name: " + resultSet.getString("Name"));
            }

        }
    }

}
