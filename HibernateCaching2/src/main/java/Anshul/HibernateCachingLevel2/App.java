package Anshul.HibernateCachingLevel2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        // 1️⃣ Hibernate Configuration
        Configuration con = new Configuration();

        con.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        con.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/HibernateTest");
        con.setProperty("hibernate.connection.username", "postgres");
        con.setProperty("hibernate.connection.password", "Anshul@667");

        con.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        con.setProperty("hibernate.hbm2ddl.auto", "validate"); // do not modify DB
        con.setProperty("hibernate.show_sql", "true");
        con.setProperty("hibernate.format_sql", "true");

        // Enable Level 2 Cache
        con.setProperty("hibernate.cache.use_second_level_cache", "true");
        con.setProperty("hibernate.cache.region.factory_class",
                "org.hibernate.cache.jcache.JCacheRegionFactory");
        con.setProperty("hibernate.cache.jcache.provider", "org.ehcache.jsr107.EhcacheCachingProvider"); // Corrected property name
        con.setProperty("hibernate.cache.use_query_cache", "true");

        con.addAnnotatedClass(Alien.class);

        SessionFactory sf = con.buildSessionFactory();

        // -----------------------------
        // 2️⃣ First Session
        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();

        Alien alien1 = session1.find(Alien.class, 101); // fetch existing Alien
        System.out.println("Session1 fetch: " + alien1);

        tx1.commit();
        session1.close();

        // -----------------------------
        // 3️⃣ Second Session
        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();

        Alien alien2 = session2.find(Alien.class, 101); // fetch same Alien from L2 cache
        System.out.println("Session2 fetch (L2 cache): " + alien2);

        tx2.commit();
        session2.close();

        sf.close();
    }
}
