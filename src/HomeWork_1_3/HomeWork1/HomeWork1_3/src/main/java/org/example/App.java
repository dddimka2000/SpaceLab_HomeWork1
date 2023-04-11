package org.example;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory= configuration.buildSessionFactory(builder.build());


//        DaoJdbc product = new ProductDaoHibernate().getSingleton(sessionFactory);
//        product.create(new Product("new_product", 22));

//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        Database data = new TestConnectionJdbc();
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

    }
}






















