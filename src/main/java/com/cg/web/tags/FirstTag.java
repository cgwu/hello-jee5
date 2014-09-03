package com.cg.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class FirstTag implements SimpleTag {
	private JspContext jspContext;
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag");
		jspContext.getOut().print("This is my first tag.");
	}

	@Override
	public JspTag getParent() {
		System.out.println("getParent");
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");
	}

	@Override
	public void setJspContext(JspContext ctx) {
		System.out.println("setJspContext");
		this.jspContext = ctx;
	}

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");
	}
}
