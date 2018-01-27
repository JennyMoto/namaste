package models;

import javax.persistence.*;

@Entity
public class Persons {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "Name", nullable = true)
    private String name;

    @Column(name = "Surname", nullable = true)
    private String surname;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Mobile", nullable = true)
    private String mobile;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persons persons = (Persons) o;

        if (id != persons.id) return false;
        if (name != null ? !name.equals(persons.name) : persons.name != null) return false;
        if (surname != null ? !surname.equals(persons.surname) : persons.surname != null) return false;
        if (email != null ? !email.equals(persons.email) : persons.email != null) return false;
        if (mobile != null ? !mobile.equals(persons.mobile) : persons.mobile != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        return result;
    }
}
