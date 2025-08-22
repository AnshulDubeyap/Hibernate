package Anshul.RelationalMappingHibernate3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
	// Three tables will be created , one Student, then Laptop, then student_laptop join table
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop();
        laptop1.setLid(101);
        laptop1.setLname("Dell");

        Student anshul = new Student();
        anshul.setRollno(1);
        anshul.setSname("Anshul");
        anshul.setMarks(88);

        // Associate
        anshul.getLaptops().add(laptop1);
        laptop1.getStudents().add(anshul);

        Configuration con = new Configuration();

        con.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        con.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/HibernateTest2");
        con.setProperty("hibernate.connection.username", "postgres");
        con.setProperty("hibernate.connection.password", "Anshul@667");

        con.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        con.setProperty("hibernate.hbm2ddl.auto", "create");
        con.setProperty("hibernate.show_sql", "true");
        con.setProperty("hibernate.format_sql", "true");

        con.addAnnotatedClass(Student.class);
        con.addAnnotatedClass(Laptop.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(anshul);
        session.persist(laptop1);

        tx.commit();
        session.close();

        System.out.println("✅ Student and Laptop saved successfully!");
    }
}
