package mod01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tibame.domain.CustomerBean;
import com.tibame.domain.TibameCustomers;

public class TestBean {

	public static void main(String[] args) {

		// 建構一個JavaBean物件
		//CustomerBean bean = new CustomerBean();
		
		CustomerBean bean = new TibameCustomers();
		
		bean.setCustomerID("487DOG");
		bean.setCountry("水溝");
		bean.setPhone("87");
		bean.setCompanyName("Dog");
		System.out.println(bean.getCompanyName());
		
		// 使用工廠和新架構 配合applicationContext.xml合約書產生我要的物件
		// 1.工廠物件 建議使用介面多型化
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2.透過工廠要一個物件 使用id去要
		
		CustomerBean bean2 = context.getBean("customers", CustomerBean.class);
		CustomerBean bean3 = context.getBean("customers", CustomerBean.class);
		bean2.setCustomerID("DDOG");
		bean2.setCountry("dgf");
		bean2.setPhone("487");
		bean2.setCompanyName("dgfdfs");
		System.out.println(bean2.getIdNumber());
		System.out.println(bean3.getIdNumber());
	}

}
