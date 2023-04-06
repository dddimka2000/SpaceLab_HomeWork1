package org.example.hibernate.products;

import com.sun.istack.NotNull;
import org.example.hibernate.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Products_DAO implements Dao<Products, Integer> {
    private final SessionFactory factory;

    public Products_DAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull Products o) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
        }
    }

    @Override
    public Products read(@NotNull Integer id) {
        try (final Session session = factory.openSession()) {
            final Products result = session.get(Products.class, id);
            if (result != null) {
                return result;
            }
            return new Products();
        }
    }

    @Override
    public void update(@NotNull Products o) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull Products o) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        }
    }
}


