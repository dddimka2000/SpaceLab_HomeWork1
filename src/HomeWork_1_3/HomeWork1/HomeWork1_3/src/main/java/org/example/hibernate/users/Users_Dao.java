package org.example.hibernate.users;
import com.sun.istack.NotNull;
import org.example.hibernate.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class Users_Dao implements Dao<Users, Integer> {
    private final SessionFactory factory;
    public Users_Dao(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(@NotNull Users o) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(o);
            session.getTransaction().commit();
            session.close();
        }
    }
    @Override
    public Users read(@NotNull Integer id) {
        try (final Session session = factory.openSession()) {
            final Users result = session.get(Users.class, id);
            session.close();
            if (result != null) {
                return result;
            }
            return new Users();

        }
    }
    @Override
    public void update(@NotNull Users o) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            session.close();
        }
    }
    @Override
    public void delete(@NotNull final Users o) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            session.close();
        }
    }
}
