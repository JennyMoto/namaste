package dao;

import models.Instructors;
import org.hibernate.Session;

public class InstructorsDao extends AbstractDao<Instructors> {
    public InstructorsDao(Session session) {
        super(session);
    }

//    public List<Persons> findByName(String name) {
//        Criteria criteria = getCurrentSession().createCriteria(Persons.class);
//        criteria.add(Restrictions.like("name", name));
//        return criteria.list();
//    }
//
//    public List<Persons> findBySurname(String surname) {
//        Criteria criteria = getCurrentSession().createCriteria(Persons.class);
//        criteria.add(Restrictions.like("surname", surname));
//        return criteria.list();
//    }
//
//    public List<Persons> findByEmail(String email) {
//        Criteria criteria = getCurrentSession().createCriteria(Persons.class);
//        criteria.add(Restrictions.like("email", email));
//        return criteria.list();
//    }
//
//    public List<Persons> findByMobile(String mobile) {
//        Criteria criteria = getCurrentSession().createCriteria(Persons.class);
//        criteria.add(Restrictions.like("mobile", mobile));
//        return criteria.list();
//    }
}
