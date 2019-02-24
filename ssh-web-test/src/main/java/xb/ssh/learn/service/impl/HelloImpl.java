package xb.ssh.learn.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.ssh.learn.dao.ITestDao;
import xb.ssh.learn.modle.TestBean;
import xb.ssh.learn.service.IHello;

@Service("hello")

public class HelloImpl implements IHello {
	private ITestDao testDao;

	public Serializable save(String name) {
		TestBean bean = new TestBean();
		bean.setName(name);
		return testDao.save(bean);
	}

	public ITestDao getTestDao() {
		return testDao;
	}

	@Autowired
	public void setTestDao(ITestDao testDao) {
		this.testDao = testDao;
	}

}
