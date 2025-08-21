package Anshul.RelationalMappingHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class student {
	
	@Id
	private int rollno;
	private String sname;
	private int marks;
	
	@OneToOne
	// Every student must have a laptop (one student have obe laptop)
	private laptop laptop;
	
	
	public laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(laptop laptop) {
		this.laptop = laptop;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	

}
