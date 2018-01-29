package dao;

import org.hibernate.criterion.Criterion;

import java.util.List;

public interface GenericDao<T> {
    T findById(Integer id);

    List<T> findAll();

    List<T> findByExample(T exampleInstance, String[] excludeProperty);

    List<T> findByCriteria(Criterion... criterion);

    Long save(T entity);

    void persist(T entity);

    void merge(T entity);

    void update(T entity);

    void saveOrUpdate(T entity);

    void delete(T entity);

    
}
