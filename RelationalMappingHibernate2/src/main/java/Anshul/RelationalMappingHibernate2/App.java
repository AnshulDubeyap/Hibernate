package Anshul.RelationalMappingHibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 

{
	
	// If we use @ManyToMany between Student and Laptop, Hibernate will create a third table (student_laptop)
	// to manage the relationship.
	
	// But if we use @OneToOne or @ManyToOne and properly map the relationship (with mappedBy on one side),
	// then Hibernate will simply add a foreign key column (e.g.,  student_rollno in laptop table) 
	// instead of creating a separate join table.
	
	// Two tables are created in this ,,, student and laptop

	
    public static void main( String[] args )
    {
    	// Create Laptop object
        Laptop laptop1 = new Laptop();
        laptop1.setLid(101);
        laptop1.setLname("Dell");

        // Create Student object
        Student anshul = new Student();
        anshul.setRollno(1);
        anshul.setSname("Anshul");
        anshul.setMarks(88);
        // Associate Student with Laptop (Adding the Laptop into ArrayList)
        anshul.getLaptops().add(laptop1);

        // Hibernate Configuration
        Configuration con = new Configuration();

        con.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        con.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/HibernateTest3");
        con.setProperty("hibernate.connection.username", "postgres");
        con.setProperty("hibernate.connection.password", "Anshul@667");

        con.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        con.setProperty("hibernate.hbm2ddl.auto", "create"); // creates tables every run
        con.setProperty("hibernate.show_sql", "true");
        con.setProperty("hibernate.format_sql", "true");

        // Register entity classes
        con.addAnnotatedClass(Student.class);
        con.addAnnotatedClass(Laptop.class);

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
