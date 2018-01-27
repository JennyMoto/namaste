package models;

import javax.persistence.*;

@Entity
public class ClassesRooms {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "RoomName", nullable = true, length = 10)
    private String roomName;

    @Column(name = "MembersLimit", nullable = true)
    private Integer membersLimit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassesRooms that = (ClassesRooms) o;

        if (id != that.id) return false;
        if (roomName != null ? !roomName.equals(that.roomName) : that.roomName != null) return false;
        if (membersLimit != null ? !membersLimit.equals(that.membersLimit) : that.membersLimit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roomName != null ? roomName.hashCode() : 0);
        result = 31 * result + (membersLimit != null ? membersLimit.hashCode() : 0);
        return result;
    }
}
