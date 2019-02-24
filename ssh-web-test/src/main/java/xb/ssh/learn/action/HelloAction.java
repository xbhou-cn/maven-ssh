package xb.ssh.learn.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import xb.ssh.learn.service.IHello;

@ParentPackage("basePackage")
@Namespace("/")
@Action("helloAction")
@AllowedMethods("say")
public class HelloAction {
	private final Logger LOG = Logger.getLogger(HelloAction.class);
	private IHello hello;

	public void say() {
		LOG.info(hello.save("赵玉琴"));
	}

	public IHello getHello() {
		return hello;
	}

	@Autowired
	public void setHello(IHello hello) {
		this.hello = hello;
	}

}
