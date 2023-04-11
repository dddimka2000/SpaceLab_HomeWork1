package org.example.dao.jdbc;

import org.example.dao.interf.DaoJdbc;
import org.example.model.ManyShoppingCartToManyProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManyShoppingCartToManyProductDaoJdbc implements DaoJdbc<ManyShoppingCartToManyProduct, Connection> {

    public ManyShoppingCartToManyProductDaoJdbc() {
    }
    private static final String create = "Insert into product_has_shopping_cart (id,product_id1,shopping_cart_id1) Values(?,?, ?)";
    private static final String delete = "Delete from product_has_shopping_cart Where id= ?";
    private static final String update = "Update product_has_shopping_cart set shopping_cart_id1=?,product_id1=? Where id= ?";
    private static final String read = "Select * FROM product_has_shopping_cart";
    private static Connection connection;
    private ManyShoppingCartToManyProductDaoJdbc manyShoppingCartToManyProduct=null;

    private ManyShoppingCartToManyProductDaoJdbc(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ManyShoppingCartToManyProductDaoJdbc getSingleton(Connection connection) {
        if (manyShoppingCartToManyProduct == null) {
            manyShoppingCartToManyProduct = new ManyShoppingCartToManyProductDaoJdbc(connection);
        }
        return manyShoppingCartToManyProduct;
    }

    @Override
    public void create(ManyShoppingCartToManyProduct table) {
        try (PreparedStatement statement = connection.prepareStatement(create);) {
            statement.setInt(1, table.getId());
            statement.setInt(2, table.getProduct_id());
            statement.setInt(3, table.getShoppingCart_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(ManyShoppingCartToManyProduct table) {
        try (PreparedStatement statement = connection.prepareStatement(update);) {
            statement.setInt(1, table.getShoppingCart_id());
            statement.setInt(2, table.getProduct_id());
            statement.setInt(3, table.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(ManyShoppingCartToManyProduct table) {
        try (PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setInt(1, table.getId());
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
                System.out.print(" product_id: " + resultSet.getInt("product_id1"));
                System.out.println(" shopping_cart_id: " + resultSet.getInt("shopping_cart_id1"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
