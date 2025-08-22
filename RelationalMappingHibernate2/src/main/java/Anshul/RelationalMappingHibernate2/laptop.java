package Anshul.RelationalMappingHibernate2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {
	
	// Quesry of Laptop will always fetch Laptop
	
		@Id
		private int lid;
		private String lname;
		
		@ManyToOne
		// a Laptop can have one Student
		private Student Student;
		
		// This will not create a extra table,,,student_laptop, because mapping is done in Laptop only
		
		
		public Student getStudent() {
			return Student;
		}
		public void setStudent(Student Student) {
			this.Student = Student;
		}
		public int getLid() {
			return lid;
		}
		public void setLid(int lid) {
			this.lid = lid;
		}
		public String getLanme() {
			return lname;
		}
		public void setLname(String lanme) {
			this.lname = lanme;
		}
		

}
