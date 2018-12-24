package mod01;

import com.tibame.domain.TibameCollection;
import com.tibame.domain.TibameCompany;
import com.tibame.domain.TibameEmployee;

public class TestTibameCollection {

	public static void main(String[] args) {
		TibameCollection collection = new TibameCollection();
		// 收集員工
		collection.addEmployee(new TibameEmployee("001", "動"));
		collection.addEmployee(new TibameEmployee("002", "Ev"));
		collection.addEmployee(new TibameEmployee("003", "xxx"));
		
		// 公司物件
		TibameCompany com = new TibameCompany();
		// 透過屬性注入依存關係
		com.setEmployees(collection);
		collection = null;
		System.out.println(com.getEmployees().getEmployee(1).getName());
	}

}
