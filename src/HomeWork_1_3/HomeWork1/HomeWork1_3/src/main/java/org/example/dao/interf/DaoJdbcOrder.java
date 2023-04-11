package org.example.dao.interf;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoJdbcOrder <T>{
    <F> F getSingleton(Connection connection);
    void create(T table);
    void readUser(T table) throws SQLException;
    void readAll() throws SQLException;
}
