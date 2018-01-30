package dao;

import models.Classes;
import models.Persons;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
}
