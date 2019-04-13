package xb.ssh.learn.service;

import xb.ssh.learn.modle.driven.DataGrid;
import xb.ssh.learn.modle.driven.User;

public interface IUserService {
    public boolean saveUser(User user);

    public boolean login(User user);

    public DataGrid<User> getDataGrid(User user);

    /**
         * 添加用户
     * 
     * @param  user
     * @return
     */
    public User addUser(User user);

    /**
     * @param  ids
     * @return
     */
    public void removeUser(String ids);
}
