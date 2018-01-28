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
    private ClassesType classesType;

    @ManyToOne
    @JoinColumn(name = "ID")
    private ClassesRooms classesRoom;
    
    @ManyToOne
    @JoinColumn(name = "ID")
    private Instructors instructor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassesType getClassesType() {
        return classesType;
    }

    public void setClassesType(ClassesType classesType) {
        this.classesType = classesType;
    }

    public ClassesRooms getClassesRoom() {
        return classesRoom;
    }

    public void setClassesRoom(ClassesRooms classesRoom) {
        this.classesRoom = classesRoom;
    }

    public Instructors getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructors instructor) {
        this.instructor = instructor;
    }

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
