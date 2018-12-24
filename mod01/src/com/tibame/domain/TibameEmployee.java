package com.tibame.domain;

public class TibameEmployee {
	private String id;
	private String name;
    public TibameEmployee(){}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TibameEmployee [id=" + id + ", name=" + name + "]";
	}

	public TibameEmployee(String id,String name) {
		this.id = id;
		this.name = name;

	}
}
