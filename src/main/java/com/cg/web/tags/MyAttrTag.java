package com.cg.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyAttrTag extends SimpleTagSupport {
	
	private String header;
	private String items;
	

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		out.print("<div style='border:solid 1px red;'>");
		out.print("header:"+header);
		
		out.print("<div style='border:solid 1px blue;'>");
		this.getJspBody().invoke(null);
		out.print("</div>");
		
		out.print("items:"+items);
		out.print("</div>");
	}


	public void setHeader(String header) {
		this.header = header;
	}


	public void setItems(String items) {
		this.items = items;
	}
}
