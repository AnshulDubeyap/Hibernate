package Anshul.HibernateCaching1;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Create a Properties object to hold your configuration
        Properties settings = new Properties();
        settings.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        settings.put("hibernate.connection.url", "jdbc:postgresql://localhost:5433/HibernateTest");
        settings.put("hibernate.connection.username", "postgres");
        settings.put("hibernate.connection.password", "Anshul@667");
        settings.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        settings.put("hibernate.hbm2ddl.auto", "update");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.format_sql", "true");

        // Use the modern API to set the properties on the Configuration object
        Configuration con = new Configuration();
        con.setProperties(settings);
        con.addAnnotatedClass(Alien.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        // 3️⃣ Begin transaction
        Transaction tx = session.beginTransaction();

        // Your code from here on is fine
        Alien alien1 = session.find(Alien.class, 101);
        System.out.println("First fetch: " + alien1);

        Alien alien2 = session.find(Alien.class, 101);
        System.out.println("Second fetch (from L1 cache): " + alien2);

        tx.commit();

        session.close();
        sf.close();
    }
}