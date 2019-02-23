package xb.ssh.learn.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

@ParentPackage("basePackage")
@Namespace("/")
@Action("helloAction")
@AllowedMethods("say")
public class HelloAction {
	private final Logger LOG = Logger.getLogger(HelloAction.class);

	public void say() {
		LOG.info("Hello Spring-struts");
	}
}
