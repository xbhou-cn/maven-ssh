package xb.ssh.learn.service;

import java.util.List;

import xb.ssh.learn.modle.driven.Menu;

public interface IMenuService {
    List<Menu> getTree(String id);

    void repair();
}
