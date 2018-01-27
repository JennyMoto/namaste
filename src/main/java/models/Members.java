package models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Members {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "ID")
    Persons person;

    @OneToMany(mappedBy = "members")
    Set<ClassesReservations> classesReservations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Members that = (Members) o;
        return id == that.id;
    }
    
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result;
        return result;
    }
}
