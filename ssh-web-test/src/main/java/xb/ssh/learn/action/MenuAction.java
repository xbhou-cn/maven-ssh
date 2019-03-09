package xb.ssh.learn.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import xb.ssh.learn.modle.driven.Menu;
import xb.ssh.learn.service.IMenuService;

@Action("menuAction")
@AllowedMethods({ "init", "getTree" })
public class MenuAction extends BaseAction implements ModelDriven<Menu> {
    private Menu menu = new Menu();
    private IMenuService menuService;

    public Menu getModel() {
        return menu;
    }

    public IMenuService getMenuService() {
        return menuService;
    }

    @Autowired
    public void setMenuService(IMenuService menuService) {
        this.menuService = menuService;
    }

    public void init() {
        menuService.repair();
    }

    public void getTree() {
        List<Menu> menuList = menuService.getTree(this.menu.getId());
        this.writeJson(menuList);
    }
}
