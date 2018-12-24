package com.tibame.domain;

public interface IHello {
	// 規範打招呼的架構 抽象描述 名稱、注入參數 、回應值
	public String helloWorld(String who);
    //強迫存取子getter
	public String getCompanyName();
	
}
