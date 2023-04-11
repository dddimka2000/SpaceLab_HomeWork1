package org.example.dao.hibernate;

import org.hibernate.SessionFactory;

public class UserHibernateDao {
    private final SessionFactory factory;

    public UserHibernateDao(final SessionFactory factory) {
        this.factory = factory;
    }

}
