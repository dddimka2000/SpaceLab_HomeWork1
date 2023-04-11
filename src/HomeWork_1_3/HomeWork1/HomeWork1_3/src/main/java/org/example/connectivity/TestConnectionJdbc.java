package org.example.connectivity;

import org.example.dao.jdbc.*;
import org.example.dao.interf.DaoJdbc;
import org.example.dao.interf.DaoJdbcOrder;
import org.example.dao.interf.DaoJdbcShoppingCart;
import org.example.model.Order;
import org.example.model.Product;
import org.example.model.User;
import org.example.model.UserDetails;
import org.example.password.pass;

import java.sql.*;

public class TestConnectionJdbc implements Database{
    @Override
    public void getDataBase() throws SQLException, ClassNotFoundException {
        implementation();
    }

    private void implementation() throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",
                    "root", pass.getPassword())) {
//                clear(connection);
                DaoJdbc userDaoJdbc = new UserDaoJdbcImpl().getSingleton(connection);
                DaoJdbc userDetailsDaoJdbc = new UserDetailsDaoJdbcImpl().getSingleton(connection);
                DaoJdbc productDaoJdbc = new ProductDaoJdbcImpl().getSingleton(connection);
                DaoJdbc manyShoppingCartToManyProductDaoJdbc=new ManyShoppingCartToManyProductDaoJdbc().getSingleton(connection);
                DaoJdbcOrder orderDaoJdbc=new OrderDaoJdbcImpl().getSingleton(connection);
                DaoJdbcShoppingCart shoppingCart=new ShoppingCartDaoImpl().getSingleton(connection);
                User userModel = new User(100, "Name7");
                UserDetails userDetailsModel = new UserDetails(10, "car 10", userModel);
                Product productModel = new Product("new_product", 10);
                userDetailsDaoJdbc.delete(userDetailsModel);
                userDaoJdbc.delete(userModel);
                userDetailsModel.setUserDetailsId(6);
                userDaoJdbc.create(userModel);
                userDetailsDaoJdbc.create(userDetailsModel);
                productDaoJdbc.create(productModel);
                userDetailsModel.setAge(20);
                userDetailsDaoJdbc.update(userDetailsModel);
                orderDaoJdbc.create(new Order(new User(3,"Dima")));
                System.out.println("-----------------userModel-----------------");
                userDaoJdbc.read();
                System.out.println("-----------------userDetailsModel-----------------");
                userDetailsDaoJdbc.read();
                System.out.println("-----------------product-----------------");
                productDaoJdbc.read();
                System.out.println("-----------------ManyShoppingCartToManyProductDaoJdbc-----------------");
                manyShoppingCartToManyProductDaoJdbc.read();
                System.out.println("-----------------Shopping_cart-----------------");
                shoppingCart.read();
                System.out.println("-----------------order-----------------");
                orderDaoJdbc.readAll();
                System.out.println("-----------------order-user-----------------");
                orderDaoJdbc.readUser(new Order(new User(3,"Dima")));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
    private void clear(Connection connection) {
        try (Statement statement = connection.createStatement();) {
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

