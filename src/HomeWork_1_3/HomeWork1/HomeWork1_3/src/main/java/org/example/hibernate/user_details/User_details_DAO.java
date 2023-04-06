package org.example.hibernate.user_details;

import com.sun.istack.NotNull;
import org.example.hibernate.Dao;
import org.example.hibernate.users.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class User_details_DAO implements Dao<User_details, Integer> {
    private final SessionFactory factory;
    public User_details_DAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull User_details o) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(o.getUsers_id().getUsers_id());
            session.saveOrUpdate(o);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User_details read(@NotNull Integer id) {
        try (final Session session = factory.openSession()) {
            final User_details result = session.get(User_details.class, id);
            if (result != null) {
                return result;
            }
            return new User_details();
        }
    }

    @Override
    public void update(User_details o) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final User_details o) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        }
    }
}
