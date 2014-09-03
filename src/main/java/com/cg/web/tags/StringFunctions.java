package com.cg.web.tags;

public class StringFunctions {
	public static String reverse(String origin) {
		return new StringBuilder(origin).reverse().toString();
	}
}
