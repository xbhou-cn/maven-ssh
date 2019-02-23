package xb.ssh.learn.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

@ParentPackage("basePackage")
@Namespace("/")
@Action("helloAction")
@AllowedMethods("say")
public class HelloAction {
	public void say() {
		System.out.println("Hello");
	}
}
