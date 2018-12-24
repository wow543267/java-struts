package mod01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tibame.domain.IHello;
import com.tibame.domain.JPNHello;
import com.tibame.domain.JPNHelloWorld;

public class TestHelloSrpingBean {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		System.out.println(context);
		// 要Hello物件
		IHello hello = context.getBean("hello", IHello.class);
		JPNHello jpnhello = context.getBean("JPNhello",JPNHello.class);
		String msg = hello.helloWorld("eric");
        String jpnmsg = jpnhello.JPNhelloWorld("山本");
		System.out.println(msg);
		System.out.println(jpnmsg);
	}
}
