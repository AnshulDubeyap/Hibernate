package Anshul.RelationalMappingHibernate3;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
    private int rollno;
    private String sname;
    private int marks;

    @ManyToMany(mappedBy = "Student")
    
    private List<Laptop> Laptops = new ArrayList<>();

    public List<Laptop> getLaptops() {
        return Laptops;
    }
    public void setLaptops(List<Laptop> Laptops) {
        this.Laptops = Laptops;
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
