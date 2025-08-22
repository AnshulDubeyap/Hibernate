package Anshul.HibernateCaching;

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
		con.setProperty("hibernate.hbm2ddl.auto", "update");
		con.setProperty("hibernate.show_sql", "true");
		con.setProperty("hibernate.format_sql", "true");

		con.addAnnotatedClass(Alien.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		// 2️⃣ Begin transaction
		Transaction tx = session.beginTransaction();

		// 3️⃣ Fetch an existing Alien by ID
		Alien alien1 = session.find(Alien.class, 101); // Fetch from DB
		System.out.println("First fetch: " + alien1);

		// 4️⃣ Fetch the same Alien again in the same session to demonstrate Level 1
		// cache
		Alien alien2 = session.find(Alien.class, 101); // Comes from L1 cache
		System.out.println("Second fetch (from L1 cache): " + alien2);

		tx.commit();

		session.close();
		sf.close();
	}
}
