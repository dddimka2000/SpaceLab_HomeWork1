package org.example.dao.interf;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoJdbcShoppingCart<T>{
    <F> F getSingleton(Connection connection);
    void create(T table);
    void delete(T table);
    void deleteAll(T table);
    void read() throws SQLException;
}
