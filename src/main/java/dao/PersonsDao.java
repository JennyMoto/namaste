package dao;

import models.Persons;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class PersonsDao extends AbstractDao<Persons> {
    public PersonsDao(Session session) {
        super(session);
    }

    public List<Persons> findByName(String name) {
        Criteria criteria = getCurrentSession().createCriteria(Persons.class);
        criteria.add(Restrictions.like("name", name));
        return criteria.list();
    }

    public List<Persons> findBySurname(String surname) {
        Criteria criteria = getCurrentSession().createCriteria(Persons.class);
        criteria.add(Restrictions.like("surname", surname));
        return criteria.list();
    }

    public List<Persons> findByEmail(String email) {
        Criteria criteria = getCurrentSession().createCriteria(Persons.class);
        criteria.add(Restrictions.like("email", email));
        return criteria.list();
    }

    public List<Persons> findByMobile(String mobile) {
        Criteria criteria = getCurrentSession().createCriteria(Persons.class);
        criteria.add(Restrictions.like("mobile", mobile));
        return criteria.list();
    }
}
