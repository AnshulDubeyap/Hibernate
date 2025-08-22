package Anshul.RelationalMappingHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {
	
	// Laptop dont know about Student, any query on Laptop will work for Laptop only
	
	@Id
	private int lid;
	private String lname;
	
	
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
