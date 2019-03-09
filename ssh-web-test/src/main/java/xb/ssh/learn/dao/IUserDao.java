package xb.ssh.learn.dao;

import xb.ssh.learn.modle.UserBean;

public interface IUserDao extends IBaseDao<UserBean> {

    boolean login(UserBean bean);
}
