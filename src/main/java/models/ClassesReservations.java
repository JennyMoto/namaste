package models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ClassesReservations {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "ID")
    Classes classes;

    @Column(name = "CancelDate")
    Timestamp cancelTimestamp;

    @ManyToOne
    @JoinColumn(name = "ID")
    Members members;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassesReservations that = (ClassesReservations) o;
        return id == that.id;
    }
    
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result;
        return result;
    }
}
