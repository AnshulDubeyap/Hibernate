package com.Anshul.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    // Hibernate is a framework that helps with ORM (Object Relational Mapping).
    // ORM --> Mapping an object in Java to a relational database table.
    // For example, a Java class becomes a table, and its fields become columns.
    //
    // Hibernate makes it easier to write queries and handle operations with
    // databases.
    // It reduces boilerplate code for CRUD (Create, Read, Update, Delete)
    // operations
    // and allows developers to work with objects instead of SQL statements directly.
    public static void main(String[] args) {

        // Step-5 --> Create an Alien object that we want to save in PostgreSQL
        Alien anshul = new Alien();
        anshul.setAid(101);
        anshul.setAname("Bobby");
        anshul.setAcolor("Orange");
        
        Alien jimmy = new Alien();
        jimmy.setAid(102);
        jimmy.setAname("Jimmy");
        jimmy.setAcolor("Pink");
        
        Alien cambam = new Alien();
        cambam.setAid(103);
        cambam.setAname("Cam");
        cambam.setAcolor("Blue");
        
        Alien joel = new Alien();
        joel.setAid(104);
        joel.setAname("Joel");
        joel.setAcolor("Green");

        // Step-4 --> Create a Configuration object (this class is used to setup Hibernate)
        Configuration con = new Configuration();

        // Step-3 --> Provide PostgreSQL connection details directly using setProperty()
        // No XML file is needed in modern Hibernate (Java-based config is preferred)
        con.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        con.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/HibernateTest");
        con.setProperty("hibernate.connection.username", "postgres");
        con.setProperty("hibernate.connection.password", "Anshul@667");

        // Step-2 --> Provide Hibernate-specific settings
        // hibernate.dialect   --> tells Hibernate which SQL dialect to generate (PostgreSQL here)
        // hbm2ddl.auto        --> tells Hibernate how to handle tables (create, update, etc.)
        // show_sql            --> prints SQL queries on console
        con.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        con.setProperty("hibernate.hbm2ddl.auto", "create"); // creates table in every run
        con.setProperty("hibernate.show_sql", "true");
        con.setProperty("hibernate.format_sql", "true");

        // Step-1 --> Register our Entity class with Hibernate (Alien class is annotated with @Entity)
        con.addAnnotatedClass(Alien.class);

        // Now we build the SessionFactory (a heavy object that manages DB connections)
        SessionFactory sf = con.buildSessionFactory();

        // From SessionFactory, we get a Session (like a connection to the database)
        Session session = sf.openSession();

        // Since DB operations must follow ACID properties,
        // we begin a transaction before saving the object
        Transaction tx = session.beginTransaction();

        // Use persist() to save the Alien object into the PostgreSQL database
        session.persist(anshul);
        session.persist(jimmy);
        session.persist(joel);
        session.persist(cambam);
        // Commit the transaction so that changes are saved permanently
        tx.commit();

        // Close the session and factory to free resources
        session.close();
        sf.close();

        System.out.println("✅ Alien saved successfully in PostgreSQL!");
    }
}
