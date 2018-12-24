package com.tibame.domain;

import java.util.ArrayList;
import java.util.List;

public class TibameCollection {
	private List<TibameEmployee> employees = new ArrayList<>();

	// 加入員工
	public int addEmployee(TibameEmployee emp) {

		this.employees.add(emp);
		return this.employees.size() - 1;

	}

	// 問特定員工
	public TibameEmployee getEmployee(int index) {
		TibameEmployee emp = null;
		if (this.employees.get(index) != null) {

			emp = this.employees.get(index);

		}
		return emp;
	}

}
