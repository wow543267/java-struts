package mod01;

import com.tibame.domain.EngHelloWorld;
import com.tibame.domain.IHello;
import com.tibame.domain.JPNHelloWorld;

public class TestHello {

	// 程式進入點
	public static void main(String[] args) {
    //定義介面 介面多型
	//IHello hello = new EngHelloWorld();//A版
	JPNHelloWorld hello = new JPNHelloWorld();
	//功能呼叫
	String msg=hello.JPNhelloWorld("安安安");
	System.out.println(msg);
	
	}

}
