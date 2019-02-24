package xb.ssh.learn.dao.Impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xb.ssh.learn.dao.ITestDao;
import xb.ssh.learn.modle.TestBean;

@Repository("testDao")
public class TestDaoImpl implements ITestDao {
	private SessionFactory sessionFactory;

	public Serializable save(TestBean bean) {

		return sessionFactory.getCurrentSession().save(bean);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
