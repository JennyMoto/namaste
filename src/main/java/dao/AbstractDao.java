package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T> implements GenericDao<T> {
    private Session currentSession;
    private Class<T> persistentClass;

    AbstractDao(Session session) {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        this.currentSession = session;
    }

    protected Class<T> getPersistentClass() {
        return persistentClass;
    }

    protected Session getCurrentSession() {
        return currentSession;
    }

    @SuppressWarnings("unchecked")
    public T findById(Integer id) {
        T entity;
        entity = (T) getCurrentSession().load(getPersistentClass(), id);
        return entity;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return findByCriteria();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
        Criteria crit = getCurrentSession().createCriteria(getPersistentClass());
        Example example =  Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
            System.out.println(exclude);
        }
        crit.add(example);
        return crit.list();
    }

    @SuppressWarnings("unchecked")
    public void saveOrUpdate(T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public Long save(T entity) {
        return (Long) getCurrentSession().save(entity);
    }

    @Override
    public void persist(T entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void merge(T entity) {
        getCurrentSession().merge(entity);
    }

    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    public void flush() {
        getCurrentSession().flush();
    }

    public void clear() {
        getCurrentSession().clear();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByCriteria(Criterion... criterion) {
        Criteria crit = getCurrentSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }
}
