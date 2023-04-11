package org.example.dao.jdbc;

import org.example.dao.interf.DaoJdbcOrder;
import org.example.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoJdbcImpl implements DaoJdbcOrder<Order> {
    private static final String create = "Insert into new_schema.order (id,user_id) Values(?,?)";
    private static final String readUser = "Select * FROM new_schema.order Where user_id=?";
    private static final String readAll = "Select * FROM new_schema.order";

    public OrderDaoJdbcImpl() {
    }

    private static Connection connection;
    private OrderDaoJdbcImpl orderDaoJdbc=null;
    private OrderDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public OrderDaoJdbcImpl getSingleton(Connection connection) {
        if (orderDaoJdbc == null) {
            orderDaoJdbc = new OrderDaoJdbcImpl(connection);
        }
        return orderDaoJdbc;
    }

    @Override
    public void create(Order table) {
        try (PreparedStatement statement = connection.prepareStatement(create);) {
            statement.setInt(1,table.getId());
            statement.setInt(2,table.getUser_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readUser(Order order) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(readUser)) {
            statement.setInt(1,order.getUser_id());
            read(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readAll() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(readAll)) {
            read(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void read(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.print("id: " + resultSet.getInt("id"));
            System.out.print(" product: " + resultSet.getString("products"));
            System.out.print(" total_price: " + resultSet.getInt("total_price"));
            System.out.println(" user_id: " + resultSet.getInt("user_id"));
        }
    }
}
