package com.tibame.domain;

public class EngHelloWorld implements IHello {
	private String companyName;
    //自訂建構子 建構子注入
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String helloWorld(String who) {
		// TODO Auto-generated method stub
		return String.format("Hello World %s", who);
	}

	@Override
	public String getCompanyName() {
		
		return companyName;
	}

}
