package xb.ssh.learn.util.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import xb.ssh.learn.service.IMenuService;

public class RepairListener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener {
    private final static Logger LOGGER = Logger.getLogger(RepairListener.class);
    private ApplicationContext context;

    public void sessionCreated(HttpSessionEvent se) {
        // TODO Auto-generated method stub

    }

    public void sessionDestroyed(HttpSessionEvent se) {
        // TODO Auto-generated method stub

    }

    public void attributeAdded(ServletContextAttributeEvent event) {
        // TODO Auto-generated method stub

    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
        // TODO Auto-generated method stub

    }

    public void attributeReplaced(ServletContextAttributeEvent event) {
        // TODO Auto-generated method stub

    }

    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.info("初始化数据库");
        this.context=WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        IMenuService menuService=(IMenuService)this.context.getBean("menuService");
        menuService.repair();
        LOGGER.info("初始化数据库成功");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }

}
