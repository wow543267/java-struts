package com.tibame.domain;

public class JPNHelloWorld implements JPNHello {
	private String companyName;

	// 自訂建構子 建構子注入
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String JPNhelloWorld(String who) {
		// TODO Auto-generated method stub
		return String.format("おはよう %s", who);
	}

	@Override
	public String getCompanyName() {
		// TODO Auto-generated method stub
		return companyName;
	}

}
