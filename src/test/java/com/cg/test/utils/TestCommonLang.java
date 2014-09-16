package com.cg.test.utils;

import java.util.Date;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

public class TestCommonLang {

	@Test
	public void testFormatDate() {
		String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		System.out.println(date);
		String escape = StringEscapeUtils.escapeHtml4("<br>a中国@#$<h1/>");
		// .escapeHtml("<br>a中国@#$<h1/>");
		System.out.println(escape);

	}

}
