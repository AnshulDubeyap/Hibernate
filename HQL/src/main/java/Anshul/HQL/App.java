package Anshul.HQL;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {

	// HQL --> Hibernate Query Language. It's an object-oriented query language, similar to SQL,
	// but it operates on Java classes and their properties, not database tables and columns.
	// In HQL, the class name is used instead of the table name, and property names are used
	// instead of column names.

	// Fetch all data using HQL
	// -> from classname
	public static void main(String[] args) {

		Configuration con = new Configuration();

		con.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
		con.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5433/hql");
		con.setProperty("hibernate.connection.username", "postgres");
		con.setProperty("hibernate.connection.password", "Anshul@667");

		con.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		con.setProperty("hibernate.hbm2ddl.auto", "update"); // Updates the table schema without dropping existing data.
		con.setProperty("hibernate.show_sql", "true");
		con.setProperty("hibernate.format_sql", "true");

		con.addAnnotatedClass(Student.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		// Creating 50 entries for student
		Random r = new Random();

		for (int i = 0; i < 50; i++) {

			Student s = new Student();
			s.setRollno(i);
			s.setName("name" + i);
			s.setMarks(r.nextInt(100));

			session.persist(s);
		}

		tx.commit();
		session.close();

		System.out.println("✅ Data inserted successfully.");

		// --- HQL QUERIES ---

		// Reopen the session for queries
		session = sf.openSession();
		tx = session.beginTransaction();

		System.out.println("\n--- Query 1: Fetching all students ---");
		// Fix for the deprecated method: use `createQuery(String, Class)` for type-safety.
		Query<Student> query1 = session.createQuery("from Student", Student.class);
		List<Student> students = query1.list();
		for (Student s : students) {
			System.out.println(s);
		}

		System.out.println("\n--- Query 2: Fetching students with marks > 50 ---");
		// Fix for the deprecated method: use `createQuery(String, Class)` for type-safety.
		Query<Student> query2 = session.createQuery("from Student where marks > 50", Student.class);
		List<Student> highScorers = query2.list();
		for (Student s : highScorers) {
			System.out.println(s);
		}

		System.out.println("\n--- Query 3: Fetching a single student by roll number ---");
		// Fix for the deprecated method: use `createQuery(String, Class)` for type-safety.
		Query<Student> query3 = session.createQuery("from Student where rollno = 25", Student.class);
		Student student25 = query3.uniqueResult();
		if (student25 != null) {
			System.out.println(student25);
		}

		tx.commit();
		session.close();
		sf.close();

	}
}