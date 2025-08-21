package Anshul.RelationalMappingHibernate2;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class student {

    @Id
    private int rollno;
    private String sname;
    private int marks;

    @OneToMany(mappedBy = "student")
    // One student can own many laptops.
    // The 'mappedBy' tells Hibernate that the relationship is managed 
    // on the 'student' field inside the Laptop entity, so it won't 
    // create a separate join table.
    private List<laptop> laptops = new ArrayList<>();

    public List<laptop> getLaptops() {
        return laptops;
    }
    public void setLaptops(List<laptop> laptops) {
        this.laptops = laptops;
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
