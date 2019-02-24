package xb.ssh.learn.dao;

import java.io.Serializable;

import xb.ssh.learn.modle.TestBean;

public interface ITestDao {
	public Serializable save(TestBean bean);
}
