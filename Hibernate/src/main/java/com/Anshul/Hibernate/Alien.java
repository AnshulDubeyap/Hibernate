package com.Anshul.Hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


// @Table(name = "Alien_Table") // 👈 custom table name (default would be "Alien")
@Entity
public class Alien {

    @Id
    private int aid;

    // @Column(name = "alien_name", nullable = false, length = 100)
    // 👆 Custom column name, cannot be NULL, max length = 100 chars
    private String aname;

    // @Column(name = "alien_color", unique = false)
    // 👆 Custom column name. Not marked unique, so duplicates allowed.
    private String acolor;

    // --- Getter and Setter methods ---
    // Hibernate uses these methods to read and write values from/to the DB.

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAcolor() {
        return acolor;
    }

    public void setAcolor(String acolor) {
        this.acolor = acolor;
    }
}
