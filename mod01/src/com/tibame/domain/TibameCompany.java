package com.tibame.domain;

public class TibameCompany {
	// 依存關係
	private String companyName;
	private TibameCollection employees;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public TibameCollection getEmployees() {
		return employees;
	}

	public void setEmployees(TibameCollection employees) {
		this.employees = employees;
	}

}
