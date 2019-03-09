package xb.ssh.learn.dao.Impl;

import org.springframework.stereotype.Repository;

import xb.ssh.learn.dao.IMenuDao;
import xb.ssh.learn.modle.TMenu;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<TMenu> implements IMenuDao {

}
