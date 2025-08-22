package Anshul.RelationalMappingHibernate2;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {

    @Id
    private int rollno;
    private String sname;
    private int marks;

    @OneToMany(mappedBy = "Student")
    // One Student can own many Laptops.
    // The 'mappedBy' tells Hibernate that the relationship is managed 
    // on the 'Student' field inside the Laptop entity, so it won't 
    // create a separate join table.
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
