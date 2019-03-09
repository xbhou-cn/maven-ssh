package xb.ssh.learn.dao.Impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xb.ssh.learn.dao.IBaseDao;

/**
 * @author 侯效标
 *
 * @param  <T>
 */
@Repository("baseDao")
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements IBaseDao<T> {
    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Serializable save(T o) {
        return this.sessionFactory.getCurrentSession().save(o);
    }

    public List<T> get(String hql, Map<String, Object> params) {
        final Session openSession = this.sessionFactory.openSession();
        Query<T> createQuery = openSession.createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                createQuery.setParameter(key, params.get(key));
            }
        }
        List<T> list = createQuery.list();
        if (openSession != null) {
            openSession.close();
        }
        return list;
    }

    public List<T> get(String hql) {
        final Session openSession = this.sessionFactory.openSession();
        Query<T> createQuery = openSession.createQuery(hql);
        List<T> list = createQuery.list();
        if (openSession != null) {
            openSession.close();
        }
        return list;
    }

    public List<T> find(String hql, int pages, int rows) {
        final Session openSession = this.sessionFactory.openSession();
        Query<T> createQuery = openSession.createQuery(hql);
        createQuery.setFirstResult((pages - 1) * rows).setMaxResults(rows);
        List<T> list = createQuery.list();
        if (openSession != null) {
            openSession.close();
        }
        return list;
    }

    public List<T> find(String hql, Map<String, Object> params, int pages, int rows) {
        final Session openSession = this.sessionFactory.openSession();
        Query<T> createQuery = openSession.createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                createQuery.setParameter(key, params.get(key));
            }
        }
        createQuery.setFirstResult((pages - 1) * rows).setMaxResults(rows);
        List<T> list = createQuery.list();
        if (openSession != null) {
            openSession.close();
        }
        return list;
    }

    public Long count(String hql) {
        final Session openSession = this.sessionFactory.openSession();
        Query<T> createQuery = openSession.createQuery(hql);
        T uniqueResult = createQuery.uniqueResult();
        if (openSession != null) {
            openSession.close();
        }
        return (Long) uniqueResult;
    }

    public Long count(String hql, Map<String, Object> params) {
        final Session openSession = this.sessionFactory.openSession();
        Query<T> createQuery = openSession.createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                createQuery.setParameter(key, params.get(key));
            }
        }
         T uniqueResult = createQuery.uniqueResult();
        if (openSession != null) {
            openSession.close();
        }
        return (Long) uniqueResult;
    }

    public void delete(T t) {
        this.sessionFactory.getCurrentSession().delete(t);
    }

    public void update(T t) {
        this.sessionFactory.getCurrentSession().update(t);
    }

    public void saveOrUpdate(T t) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(t);
    }

}
