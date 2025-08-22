package Anshul.RelationalMappingHibernate3;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Laptop {
	@Id
	private int lid;
	private String lname;
	
	@ManyToMany
	// a Laptop can have one Student
	private List<Student> Students = new ArrayList<Student>();
	
	
	public List<Student> getStudents() {
		return Students;
	}
	public void setStudents(List<Student> Students) {
		this.Students = Students;
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
