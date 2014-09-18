package com.cg.test.introspector;

import java.util.Date;

public class Car {

	private String color;
	private int number;// 轮胎个数
	private Date birthday = new Date();// 为了测试 设置级联属性

	public Car(String color, int number) {
		super();
		this.color = color;
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
