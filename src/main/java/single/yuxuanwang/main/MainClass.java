package single.yuxuanwang.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import single.yuxuanwang.jedisui.FrameInitail;

public class MainClass {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "jedis-ui.xml" })) {
			context.registerShutdownHook();
			context.getBean(FrameInitail.class).showMainFrame();
		}
	}

}
