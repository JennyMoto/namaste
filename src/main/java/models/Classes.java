package models;

import javax.persistence.*;

@Entity
public class Classes {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID")
    ClassesType classesType;

    @ManyToOne
    @JoinColumn(name = "ID")
    ClassesRooms classesRoom;
    
    @ManyToOne
    @JoinColumn(name = "ID")
    Instructors instructor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classes that = (Classes) o;
        return id == that.id;
    }
    
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result;
        return result;
    }
}
