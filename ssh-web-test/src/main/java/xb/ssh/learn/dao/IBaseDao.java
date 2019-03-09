package xb.ssh.learn.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IBaseDao<T> {
    public Serializable save(T o);

    List<T> get(String hql);

    List<T> get(String hql, Map<String, Object> params);

    List<T> find(String hql, int pages, int rows);

    List<T> find(String hql, Map<String, Object> params, int pages, int rows);

    Long count(String hql);

    Long count(String hql, Map<String, Object> params);

    void delete(T t);

    void update(T t);

    void saveOrUpdate(T t);

}
