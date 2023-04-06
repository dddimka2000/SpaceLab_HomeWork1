package org.example.jbdc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

interface  Dao_jdbc {
    void create(String name) throws SQLException;
    <T>void update(T new_name, T name) throws SQLException;
    void read() throws SQLException;
    void delete(String name) throws SQLException ;
}
