package Anshul.RelationalMappingHibernate2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class laptop {
	
	// Quesry of laptop will always fetch laptop
	
		@Id
		private int lid;
		private String lname;
		
		@ManyToOne
		// a Laptop can have one Student
		private student student;
		
		// This will not create a extra table,,,student_laptop, because mapping is done in laptop only
		
		
		public student getStudent() {
			return student;
		}
		public void setStudent(student student) {
			this.student = student;
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
