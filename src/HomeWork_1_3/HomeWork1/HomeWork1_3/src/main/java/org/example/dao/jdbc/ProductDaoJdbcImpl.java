package org.example.dao.jdbc;

import org.example.dao.interf.DaoJdbc;
import org.example.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoJdbcImpl implements DaoJdbc<Product,Connection> {
    public ProductDaoJdbcImpl() {
    }

    private static final String create = "Insert into product (id,product_name,price) Values(?,?, ?)";
    private static final String delete = "Delete from product Where id= ?";
    private static final String update = "Update product set product_name=?,price=? Where id= ?";
    private static final String read = "Select * FROM product";
    private static Connection connection;
    private static ProductDaoJdbcImpl productDaoJdbcImpl;

    private ProductDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ProductDaoJdbcImpl getSingleton(Connection connection) {
        if (productDaoJdbcImpl == null) {
            productDaoJdbcImpl = new ProductDaoJdbcImpl(connection);
        }
        return productDaoJdbcImpl;
    }

    @Override
    public void create(Product table) {
        try (PreparedStatement statement =connection.prepareStatement(create);) {
            statement.setInt(1, table.getProductId());
            statement.setString(2, table.getProductName());
            statement.setInt(3, table.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product table) {
        try (PreparedStatement statement = connection.prepareStatement(update);) {
            statement.setInt(1, table.getProductId());
            statement.setInt(2, table.getPrice());
            statement.setString(3, table.getProductName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Product table) {
        try (PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setInt(1, table.getProductId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void read() throws SQLException {
        try (PreparedStatement statement = productDaoJdbcImpl.connection.prepareStatement(read)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.print("id: " + resultSet.getInt("id"));
                System.out.print(" product_name: " + resultSet.getString("product_name"));
                System.out.println(" price: " + resultSet.getInt("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
