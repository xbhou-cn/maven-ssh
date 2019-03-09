package xb.ssh.learn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xb.ssh.learn.dao.IMenuDao;
import xb.ssh.learn.modle.TMenu;
import xb.ssh.learn.modle.driven.Menu;
import xb.ssh.learn.service.IMenuService;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {
    private IMenuDao menuDao;

    public IMenuDao getMenuDao() {
        return menuDao;
    }

    @Autowired
    public void setMenuDao(IMenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public void repair() {
        TMenu root = new TMenu();
        root.setId("root");
        root.setText("首页");
        root.setUrl("0");
        this.menuDao.saveOrUpdate(root);

        TMenu sjlgl = new TMenu();
        sjlgl.setId("sjlgl");
        sjlgl.setText("数据库管理");
        sjlgl.setPid(root);
        this.menuDao.saveOrUpdate(sjlgl);
        TMenu druid = new TMenu();
        druid.setId("druid");
        druid.setText("druid监控");
        druid.setPid(sjlgl);
        this.menuDao.saveOrUpdate(druid);

        TMenu xtgl = new TMenu();
        xtgl.setId("xtgl");
        xtgl.setText("系统管理");
        xtgl.setPid(root);
        this.menuDao.saveOrUpdate(xtgl);

        TMenu yhgl = new TMenu();
        yhgl.setId("yhgl");
        yhgl.setText("用户管理");
        yhgl.setPid(xtgl);
        yhgl.setUrl("userM/userManage.jsp");
        this.menuDao.saveOrUpdate(yhgl);
        TMenu jsgl = new TMenu();
        jsgl.setId("jsgl");
        jsgl.setText("角色管理");
        jsgl.setPid(xtgl);
        this.menuDao.saveOrUpdate(jsgl);
        TMenu qxgl = new TMenu();
        qxgl.setId("qxgl");
        qxgl.setText("权限管理");
        qxgl.setPid(xtgl);
        this.menuDao.saveOrUpdate(qxgl);
        TMenu cagl = new TMenu();
        cagl.setId("cagl");
        cagl.setText("菜单管理");
        cagl.setPid(xtgl);
        this.menuDao.saveOrUpdate(cagl);
        TMenu buggl = new TMenu();
        buggl.setId("buggl");
        buggl.setText("BUG管理");
        buggl.setPid(xtgl);
        this.menuDao.saveOrUpdate(buggl);

        TMenu rzgl = new TMenu();
        rzgl.setId("rzgl");
        rzgl.setText("日志管理");
        rzgl.setPid(root);
        this.menuDao.saveOrUpdate(rzgl);
        TMenu loginLog = new TMenu();
        loginLog.setId("loginLog");
        loginLog.setText("用户登陆日志");
        loginLog.setPid(rzgl);
        this.menuDao.saveOrUpdate(loginLog);
        TMenu logoutLog = new TMenu();
        logoutLog.setId("logoutLog");
        logoutLog.setText("用户注销日志");
        logoutLog.setPid(rzgl);
        this.menuDao.saveOrUpdate(logoutLog);
        TMenu yhLog = new TMenu();
        yhLog.setId("yhtLog");
        yhLog.setText("用户管理日志");
        yhLog.setPid(rzgl);
        this.menuDao.saveOrUpdate(yhLog);
        TMenu jsLog = new TMenu();
        jsLog.setId("jsLog");
        jsLog.setText("角色管理日志");
        jsLog.setPid(rzgl);
        this.menuDao.saveOrUpdate(jsLog);
        TMenu qxLog = new TMenu();
        qxLog.setId("qxLog");
        qxLog.setText("权限管理日志");
        qxLog.setPid(rzgl);
        this.menuDao.saveOrUpdate(qxLog);
        TMenu cdLog = new TMenu();
        cdLog.setId("cdLog");
        cdLog.setText("菜单管理日志");
        cdLog.setPid(rzgl);
        this.menuDao.saveOrUpdate(cdLog);

    }

    public List<Menu> getTree(String id) {
        List<Menu> menuList = new ArrayList<Menu>();
        String hql = null;
        Map<String, Object> map = new HashMap<String, Object>();
        if (id == null || id == "") {
            hql = "from TMenu t where t.pid is null";
        } else {
            map.put("id", id);
            hql = "from TMenu t where t.pid.id =:id";
        }
        List<TMenu> list = this.menuDao.get(hql, map);
        if (list != null) {
            for (TMenu t : list) {
                List<TMenu> childerList = this.menuDao.get("from TMenu t where t.pid.id ='" + t.getId() + "'");
                Menu m = new Menu();
                BeanUtils.copyProperties(t, m, new String[] { "pid" });
                Map<String, Object> attributes = new HashMap<String, Object>();
                attributes.put("url", t.getUrl());
                m.setAttributes(attributes);
                if (childerList != null && childerList.size() > 0) {
                    m.setState("closed");
                } else {
                    m.setState("open");
                }
                menuList.add(m);
            }
        }
        return menuList;
    }
}
