package xb.ssh.learn.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import xb.ssh.learn.dao.IUserDao;
import xb.ssh.learn.modle.UserBean;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserBean> implements IUserDao {

    public boolean login(UserBean bean) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", bean.getUserName());
        params.put("password", bean.getPassword());
        final String hql = "from UserBean u where u.userName=:userName and u.password=:password";
        List<UserBean> list = this.get(hql, params);
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }
}
