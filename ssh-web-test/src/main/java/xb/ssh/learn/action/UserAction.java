package xb.ssh.learn.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import xb.ssh.learn.modle.driven.DataGrid;
import xb.ssh.learn.modle.driven.Json;
import xb.ssh.learn.modle.driven.User;
import xb.ssh.learn.service.IUserService;

@Action("userAction")
@AllowedMethods({ "saveUser", "login", "getDataGrid", "addUser","removeUser" })
public class UserAction extends BaseAction implements ModelDriven<User> {
    private IUserService userService;
    private User user = new User();

    public User getModel() {
        return user;
    }

    public void saveUser() {
        final Json json = new Json();
        try {
            LOGGER.info("注册处理开始。。");
            userService.saveUser(user);
            json.setSuccess(true);
            json.setMessage("注册成功！");
            LOGGER.info("注册结束。。");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            json.setMessage("注册失败！");
        }
        super.writeJson(json);
    }

    public void login() {
        final Json json = new Json();
        try {
            LOGGER.info("登陆处理开始。。");
            boolean flag = userService.login(user);
            if (flag) {
                json.setSuccess(true);
                json.setMessage("登陆成功！");
            } else {
                json.setMessage("登陆失败，用户名或密码不正确,！");
            }
            LOGGER.info("注册结束。。");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        super.writeJson(json);
    }

    public void addUser() {
        final Json json = new Json();
        try {
            LOGGER.info("添加用户处理开始。。");
            User u = userService.addUser(user);
            if (u != null) {
                json.setSuccess(true);
                json.setMessage("添加成功！");
                json.setObj(u);
            }
            LOGGER.info("添加用户处理结束。。");
        } catch (Exception e) {
            json.setMessage("添加失败！");
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        super.writeJson(json);
    }
    public void removeUser() {
        Json json=new Json();
        try {
            this.userService.removeUser(user.getIds());
            json.setSuccess(true);
            json.setMessage("删除成功！");
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMessage("删除失败："+e.getMessage());
        }
        this.writeJson(json);
    }
    public void getDataGrid() {
        DataGrid<User> dataGrid = this.userService.getDataGrid(user);
        this.writeJson(dataGrid);
    }

    public IUserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

}
