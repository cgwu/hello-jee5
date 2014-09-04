package com.cg.test.utils;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestOperator {

	@Test
	public void test() {
		int[] ary={10,11};
		int i=1;
		ary[i-1]=i=2;
		System.out.println(Arrays.toString(ary));//2,11
		System.out.println(i);//i=2
		
		System.out.println("sizeof(int):"+Integer.SIZE/8);
		System.out.println("sizeof(int):"+Long.SIZE/8);
	}

}
