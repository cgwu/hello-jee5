package com.cg.hellojee5;

public abstract class Constants {
	public static final String HELLO = "Hello,你好!";

	public static String getHello() {
		System.out.println("Constatns.getHello()被调用");
		return HELLO;
	}
}
