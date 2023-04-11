package org.example.dao.hibernate;
import org.example.dao.interf.DaoJdbc;
import org.example.model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class ProductDaoHibernate implements DaoJdbc<Product, SessionFactory> {
    Transaction transaction;
    private static SessionFactory factory ;
    private ProductDaoHibernate productDaoHibernate;
    private ProductDaoHibernate(final SessionFactory factory) {
        this.factory = factory;
    }

    public ProductDaoHibernate() {
    }

    @Override
    public ProductDaoHibernate getSingleton(SessionFactory connection) {
        if (productDaoHibernate==null){
            productDaoHibernate=new ProductDaoHibernate(connection);
            return productDaoHibernate;
        }
        return productDaoHibernate;
    }

    @Override
    public void create(Product table) {
        try(Session session= factory.openSession(); ) {
            transaction= session.beginTransaction();
            session.beginTransaction();
            session.saveOrUpdate(table);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Product table) {

    }

    @Override
    public void delete(Product table) {

    }

    @Override
    public void read() throws SQLException {

    }
}


