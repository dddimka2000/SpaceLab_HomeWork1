package org.example.dao.interf;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoJdbc<T,Y>{
    <F> F getSingleton(Y connection);
    void create(T table);
    void update(T table);
    void delete(T table);
    void read() throws SQLException;
}
