package dao;

import models.ClassesType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ClassesTypeDao extends AbstractDao<ClassesType> {
    public ClassesTypeDao(Session session) {
        super(session);
    }

    public List<ClassesType> findByName(String name) {
        Criteria criteria = getCurrentSession().createCriteria(ClassesType.class);
        criteria.add(Restrictions.like("name", name));
        return criteria.list();
    }

    public List<ClassesType> findByDuration(Long duration) {
        Criteria criteria = getCurrentSession().createCriteria(ClassesType.class);
        criteria.add(Restrictions.like("duration", duration));
        return criteria.list();
    }
}
