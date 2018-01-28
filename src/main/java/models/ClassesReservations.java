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
    private Classes classes;

    @Column(name = "CancelDate")
    private Timestamp cancelTimestamp;

    @ManyToOne
    @JoinColumn(name = "ID")
    Members members;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Timestamp getCancelTimestamp() {
        return cancelTimestamp;
    }

    public void setCancelTimestamp(Timestamp cancelTimestamp) {
        this.cancelTimestamp = cancelTimestamp;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

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
