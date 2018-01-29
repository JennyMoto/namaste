package models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class ClassesReservations {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "Classes_ID")
    private Classes classes;

    @Column(name = "CancelDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar cancelDate;

    @ManyToOne
    @JoinColumn(name = "Members_ID")
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

    public Calendar getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Calendar cancelDate) {
        this.cancelDate = cancelDate;
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
