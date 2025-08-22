package Anshul.RelationalMappingHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	private int rollno;
	private String sname;
	private int marks;
	
	@OneToOne
	// Every Student must have a Laptop (one Student have obe Laptop)
	private Laptop Laptop;
	
	
	public Laptop getLaptop() {
		return Laptop;
	}
	public void setLaptop(Laptop Laptop) {
		this.Laptop = Laptop;
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
