package Anshul.RelationalMappingHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        // Create Laptop object
        laptop laptop1 = new laptop();
        laptop1.setLid(101);
        laptop1.setLname("Dell");

        // Create Student object
        student anshul = new student();
        anshul.setRollno(1);
        anshul.setSname("Anshul");
        anshul.setMarks(88);
        // Associate student with laptop
        anshul.setLaptop(laptop1);

        // Hibernate Configuration
        Configuration con = new Configuration();

        con.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        con.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/HibernateTest2");
        con.setProperty("hibernate.connection.username", "postgres");
        con.setProperty("hibernate.connection.password", "Anshul@667");

        con.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        con.setProperty("hibernate.hbm2ddl.auto", "create"); // creates tables every run
        con.setProperty("hibernate.show_sql", "true");
        con.setProperty("hibernate.format_sql", "true");

        // Register entity classes
        con.addAnnotatedClass(student.class);
        con.addAnnotatedClass(laptop.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Save objects
        session.persist(laptop1);
        session.persist(anshul);

        tx.commit();
        session.close();

        System.out.println("✅ Student and Laptop saved successfully!");
    }
}
