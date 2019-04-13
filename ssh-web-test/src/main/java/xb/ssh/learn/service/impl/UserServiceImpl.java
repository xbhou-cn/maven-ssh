package xb.ssh.learn.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.ssh.learn.dao.IUserDao;
import xb.ssh.learn.modle.UserBean;
import xb.ssh.learn.modle.driven.DataGrid;
import xb.ssh.learn.modle.driven.User;
import xb.ssh.learn.service.IUserService;
import xb.ssh.learn.util.MD5;

@Service("userService")
public class UserServiceImpl implements IUserService {
    private IUserDao userDao;
    private MD5 md5 = MD5.getInstance();

    public IUserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public boolean saveUser(User user) {
        UserBean target = new UserBean();
        BeanUtils.copyProperties(user, target, new String[] { "password" });
        target.setUserID(UUID.randomUUID().toString());
        target.setCreateDateTime(new Date());
        target.setPassword(md5.getMD5(user.getPassword()));
        Serializable register = userDao.save(target);
        if (register != null)
            return true;
        return false;
    }

    public User addUser(User user) {
        UserBean target = new UserBean();
        BeanUtils.copyProperties(user, target, new String[] { "password" });
        target.setUserID(UUID.randomUUID().toString());
        target.setCreateDateTime(new Date());
        target.setPassword(md5.getMD5(user.getPassword()));
        Serializable register = userDao.save(target);
        if (register != null) {
            User u = new User();
            BeanUtils.copyProperties(target, u);
            return u;
        }
        return null;
    }

    public boolean login(User user) {
        UserBean target = new UserBean();
        BeanUtils.copyProperties(user, target, new String[] { "password" });
        target.setPassword(md5.getMD5(user.getPassword()));
        return userDao.login(target);
    }

    public DataGrid<User> getDataGrid(User user) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        String hql = "from UserBean u";
        String countHql = "select count(*) ";
        // 用户名过滤（模糊查询），sql文拼接
        if (user.getUserName() != null && !"".equals(user.getUserName().trim())) {
            paraMap.put("userName", "%" + user.getUserName() + "%");
            hql += " where u.userName like :userName";
        }
        Long count = this.userDao.count(countHql + hql, paraMap);
        // 升序降序sql文拼接
        hql = this.checkIsOrder(user, hql);
        List<UserBean> list = this.userDao.find(hql, paraMap, user.getPage(), user.getRows());
        // 返回值处理
        return this.findDataGrid(list, count);
    }

    /**
     * 升序降序sql文拼接
     * 
     * @param  user
     * @param  hql
     * @return
     */
    private String checkIsOrder(User user, String hql) {
        if (user.getSort() != null && user.getSort() != "") {
            hql += " order by ";
            String[] sort = user.getSort().split(",");
            String[] order = user.getOrder().split(",");
            for (int i = 0; i < sort.length; i++) {
                hql += sort[i] + " " + order[i];
                if (i != sort.length - 1) {
                    hql += " , ";
                }
            }
        }
        return hql;
    }

    /**
     * 返回值处理
     * 
     * @param  list
     * @param  count
     * @return
     */
    private DataGrid<User> findDataGrid(List<UserBean> list, Long count) {
        DataGrid<User> dataGrid = new DataGrid<User>();
        List<User> nu = new ArrayList<User>();
        for (UserBean s : list) {
            User t = new User();
            BeanUtils.copyProperties(s, t);
            nu.add(t);
        }
        dataGrid.setTotal(count);
        dataGrid.setRows(nu);
        return dataGrid;
    }

    /*
     * (non-Javadoc)
     * 
     * @see xb.ssh.learn.service.IUserService#removeUser(java.lang.String)
     */
    public void removeUser(String ids) {
        String[] idS = ids.split(",");
        String hql = "from UserBean u where u.userID in( ";
        for (int i = 0; i < idS.length; i++) {
            hql += "'" + idS[i] + "',";
            if (i == idS.length - 1) {
                hql += "'" + idS[i] + "')";
            }
        }
        List<UserBean> userbeans = this.userDao.get(hql);
        if (userbeans == null || userbeans.size() == 0) {
            throw new NullPointerException("不存在该用户或用户已删除");
        }
        for (UserBean user : userbeans) {
            this.userDao.delete(user);
        }
    }
}
