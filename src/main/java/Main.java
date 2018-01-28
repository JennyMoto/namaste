import models.*;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Jenny on 27.01.2018.
 */
public class Main {
    public static void main (String args[]){
         //new MainWindow();

        Persons person1 = new Persons();
        person1.setName("Stephen");
        person1.setSurname("Strange");
        person1.setMobile("23894728");

        Persons person2 = new Persons();
        person2.setName("Mike");
        person2.setSurname("Peterson");
        person2.setMobile("2349082904");

        Instructors instructor = new Instructors();
        instructor.setPerson(person1);

        Members members = new Members();
        members.setPerson(person2);

        ClassesType classesType = new ClassesType();
        classesType.setName("nicnierobienie");

        ClassesRooms classesRoom = new ClassesRooms();
        classesRoom.setRoomName("zielona");
        classesRoom.setMembersLimit(17);

        Classes classes = new Classes();
        classes.setClassesRoom(classesRoom);
        classes.setClassesType(classesType);
        classes.setInstructor(instructor);

        ClassesReservations classesReservations = new ClassesReservations();
        classesReservations.setClasses(classes);
        classesReservations.setMembers(members);

        Session session = HibernateUtil.openSession();

        session.beginTransaction();
//        session.persist(person1);
//        session.persist(person2);
//        session.persist(members);
//        session.persist(instructor);
//        session.persist(classesType);
//        session.persist(classesRoom);
//        session.persist(classes);
//        session.persist(classesReservations);

        Query q = session.createQuery(
                "SELECT i FROM Instructors i JOIN i.person p WHERE p.name = :n");
        q.setParameter("n", "Stephen");
        List<Instructors> r = q.getResultList();
        for (Instructors i: r) {
            Persons p = i.getPerson();
//            p.setSurname(p.getSurname() + "dupek");
//            session.merge(p);
            System.out.printf("%d %d %s %s %s %s\n",
                    i.getId(), p.getId(), p.getName(), p.getSurname(), p.getEmail(), p.getMobile());
        }
        System.out.println(((List) r).size());
        session.getTransaction().commit();
        session.close();
        HibernateUtil.closeSessionFactory();

    }


}
