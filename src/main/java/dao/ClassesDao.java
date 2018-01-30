package dao;

import models.Classes;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

public class ClassesDao extends AbstractDao<Classes> {
    public ClassesDao(Session session) {
        super(session);
    }

    public List<Classes> findByStartDate(Timestamp startDate) {
        Criteria criteria = getCurrentSession().createCriteria(Classes.class);
        Calendar date2 = Calendar.getInstance();
        date2.setTime(startDate);
        date2.add(Calendar.DATE, 1);
        criteria.add(Restrictions.between("startDate", startDate, date2.getTime()));
        return criteria.list();
    }

    public List<Classes> findByDatesRange(Timestamp startDate, Timestamp endDate) {
        Criteria criteria = getCurrentSession().createCriteria(Classes.class);
        System.out.println(startDate);
        System.out.println(endDate);
        criteria.add(Restrictions.between("startDate", startDate, endDate));
        return criteria.list();
    }

    public List<Classes> findSimilar (Classes classes) {
//        String[] str = {}; //{"startDate"};
//        return findByExample(classes, str);
        Criteria crit = getCurrentSession().createCriteria(getPersistentClass());
        crit.add(Restrictions.eq("classesType", classes.getClassesType()));
        crit.add(Restrictions.eq("classesRoom", classes.getClassesRoom()));
        crit.add(Restrictions.eq("instructor", classes.getInstructor()));
        return crit.list();
    }
}
