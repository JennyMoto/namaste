package dao;

import models.ClassesRooms;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ClassesRoomsDao extends AbstractDao<ClassesRooms> {
    public ClassesRoomsDao(Session session) {
        super(session);
    }

    public List<ClassesRooms> findByRoomName(String name) {
        Criteria criteria = getCurrentSession().createCriteria(ClassesRooms.class);
        criteria.add(Restrictions.like("roomName", name));
        return criteria.list();
    }

    public List<ClassesRooms> findByMembersLimit(Long membersLimit) {
        Criteria criteria = getCurrentSession().createCriteria(ClassesRooms.class);
        criteria.add(Restrictions.like("membersLimit", membersLimit));
        return criteria.list();
    }
}
