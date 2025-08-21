package Anshul.RelationalMappingHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class laptop {
	
	// Laptop dont know about Student, any query on laptop will work for laptop only
	
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
