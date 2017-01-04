package lab.io.rush.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//Springπ§æﬂ¿‡
public class UtilSpring {
	private static final ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
}
