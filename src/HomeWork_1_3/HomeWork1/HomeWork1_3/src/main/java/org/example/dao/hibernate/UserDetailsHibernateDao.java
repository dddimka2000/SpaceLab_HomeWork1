package org.example.dao.hibernate;

import org.hibernate.SessionFactory;

public class UserDetailsHibernateDao {
    private final SessionFactory factory;
    public UserDetailsHibernateDao(final SessionFactory factory) {
        this.factory = factory;
    }

}
