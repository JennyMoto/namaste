package dao;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import util.HibernateUtil;

import java.util.List;

public interface GenericDao<T> {
    T findById(Long id);

    List<T> findAll();

    List<T> findByExample(T exampleInstance);

    List<T> findByCriteria(Criterion... criterion);

    T makePersistent(T entity);

    void makeTransient(T entity);
}
