package org.example;

import org.example.hibernate.Dao;
import org.example.hibernate.user_details.User_details;
import org.example.hibernate.user_details.User_details_DAO;
import org.example.hibernate.users.Users;
import org.example.hibernate.users.Users_Dao;
import org.example.jbdc.Products_Dao_jdbc;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<Users, Integer> object_dao1 = new Users_Dao(factory);
        Dao<User_details, Integer> object_dao2 = new User_details_DAO(factory);

        Users user1 = new Users(1, "Name_Hibernate");
        User_details user_details1 = new User_details(10,"car1",user1);

        object_dao1.create(user1);

        object_dao2.create(user_details1);

        if (factory != null) {
            factory.close();
        }
    }
}


//               Data data=new JBDC_DATABASE();
//        try {
//            data.getDataBase();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

//            Session session = factory.openSession();
//            session.beginTransaction();
//            session.createQuery("delete from Users").executeUpdate();
//            session.createNativeQuery("ALTER TABLE Users AUTO_INCREMENT = 1").executeUpdate();
//            session.getTransaction().commit();
//            factory.close();




















