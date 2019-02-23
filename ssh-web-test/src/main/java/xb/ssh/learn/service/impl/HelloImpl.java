package xb.ssh.learn.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import xb.ssh.learn.service.IHello;

@Service("hello")
public class HelloImpl implements IHello {

	public String say(String name) {
		return new SimpleDateFormat("yyyy年MM月dd日  hh:mm:ss").format(new Date()) + "  " + name + "say:Hello SSH";
	}

}
