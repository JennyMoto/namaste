import gui.MainWindow;
import models.Persons;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Created by Jenny on 27.01.2018.
 */
public class Main {
    public static void main (String args[]){
         //new MainWindow();

        Persons person = new Persons();
        //person.setId(7);
        person.setName("Zuzanna");
        person.setSurname("Tralalala");
        person.setMobile("22254545");

        SessionFactory sessionFactory =
               new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();





    }


}
