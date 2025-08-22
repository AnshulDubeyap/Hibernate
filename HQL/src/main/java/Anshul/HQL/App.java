package Anshul.HQL;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Configuration con = new Configuration();
    	
    	con.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        con.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/hql");
        con.setProperty("hibernate.connection.username", "postgres");
        con.setProperty("hibernate.connection.password", "Anshul@667");
        
        con.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        con.setProperty("hibernate.hbm2ddl.auto", "create"); // creates table in every run
        con.setProperty("hibernate.show_sql", "true");
        con.setProperty("hibernate.format_sql", "true");
        
        con.addAnnotatedClass(Student.class);
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        // Creating 50 entries for student
        
        Random r = new Random();
        
        for(int i = 0; i< 50; i++) {
        	
        	Student s = new Student();
        	s.setRollno(i);
        	s.setName("name" + i);
        	s.setMarks(r.nextInt(100));
        	
        	session.persist(s);
        }
        
        tx.commit();
        session.close();
        sf.close();
        
        
    }
}
