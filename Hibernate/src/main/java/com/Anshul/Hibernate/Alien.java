package com.Anshul.Hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

/*
 * ENTITY CLASS (Alien)
 * ---------------------
 * This class is mapped to a database table.
 * Annotations tell Hibernate/JPA how to create the table and its columns.
 *
 * @Entity        --> Marks this class as a database table.
 * @Table(name)   --> (Optional) Allows you to give a custom table name instead of using the class name.
 * @Id            --> Marks a field as the PRIMARY KEY.
 * @GeneratedValue--> (Optional) Auto-generates primary key values. Strategies include:
 *                      - GenerationType.AUTO    → Hibernate chooses the strategy
 *                      - GenerationType.IDENTITY→ Uses auto-increment column in DB
 *                      - GenerationType.SEQUENCE→ Uses a database sequence
 *                      - GenerationType.TABLE   → Uses a separate table to generate IDs
 * @Column        --> (Optional) Customize a column’s name, size, nullable, unique constraints, etc.
 *
 * Other Important Annotations you may use in the future:
 * -------------------------------------------------------
 * @Transient    --> Field is ignored (not stored in DB).
 * @Lob          --> Used for large objects (CLOB/BLOB like text, images, etc).
 * @Temporal     --> Used for Date/Time fields (DATE, TIME, TIMESTAMP).
 * @OneToOne, @OneToMany, @ManyToOne, @ManyToMany
 *                --> Relationship annotations (important when dealing with multiple tables).
 */

@Entity
@Table(name = "Alien_Table") // 👈 custom table name (default would be "Alien")
public class Alien {

    @Id
    private int aid;

    @Column(name = "alien_name", nullable = false, length = 100)
    // 👆 Custom column name, cannot be NULL, max length = 100 chars
    private String aname;

    @Column(name = "alien_color", unique = false)
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
