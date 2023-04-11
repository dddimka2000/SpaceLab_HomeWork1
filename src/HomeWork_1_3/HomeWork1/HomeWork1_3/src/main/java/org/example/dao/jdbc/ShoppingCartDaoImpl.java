package org.example.dao.jdbc;

import org.example.dao.interf.DaoJdbcShoppingCart;
import org.example.model.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingCartDaoImpl implements DaoJdbcShoppingCart<ShoppingCart> {
    private static final String create = "Insert into shopping_cart (id,user_id) Values(?, ?)";
    private static final String deleteAll = "Delete from shopping_cart";
    private static final String delete = "Delete from shopping_cart Where id= ?";
    private static final String read = "Select * FROM shopping_cart";
    private static Connection connection;
    private static ShoppingCartDaoImpl shoppingCartDaoImpl = null;
    @Override
    public ShoppingCartDaoImpl getSingleton(Connection connection) {
        if (shoppingCartDaoImpl == null) {
            shoppingCartDaoImpl = new ShoppingCartDaoImpl(connection);
        }
        return shoppingCartDaoImpl;
    }
    public ShoppingCartDaoImpl() {
    }

    private ShoppingCartDaoImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(ShoppingCart table) {
        try (PreparedStatement statement = connection.prepareStatement(create);) {
            statement.setInt(1, table.getId());
            statement.setInt(2, table.getUser_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void delete(ShoppingCart table) {
        try (PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setInt(1, table.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteAll(ShoppingCart table) {
        try (PreparedStatement statement = connection.prepareStatement(deleteAll)) {
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
                System.out.println(" user_id: " + resultSet.getInt("user_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
