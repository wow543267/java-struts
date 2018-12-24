package mod01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tibame.domain.TibameCollection;
import com.tibame.domain.TibameCompany;
import com.tibame.domain.TibameEmployee;

public class TestIoC {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 要窗口物件 正轉company
		TibameCompany com = context.getBean("company", TibameCompany.class);
		TibameCollection collection = com.getEmployees();
		// 收集員工
		collection.addEmployee(new TibameEmployee("001", "動"));
		collection.addEmployee(new TibameEmployee("002", "Ev"));
		collection.addEmployee(new TibameEmployee("003", "xxx"));
		System.out.println(com.getEmployees().getEmployee(1).getName());

	}

}
