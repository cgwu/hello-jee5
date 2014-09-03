<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="my" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="easy" 
%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Now</title>
</head>
<body>
Now is: <% 
	DateFormat format = DateFormat.getDateInstance(DateFormat.LONG);
	String s = format.format(new Date());
	out.write(s);
%>
<br>
Session["value"]:<%=session.getAttribute("value") %>
<br>
<a href="<c:url value="/s3?method=set&value=Bill Gatesaaabbb"/>" >set session value </a>
<br>
<a href="<c:url value="set.jsp"/>" >set session value:date.jsp </a>
<hr>
<jsp:useBean id="today" class="java.util.Date"></jsp:useBean>
<%=today %>
<%@ include file="inc.html" %>
EL Demos:<br>
1+2=${1+2 }<br>
${initParam["org.eclipse.jetty.servlet.SessionCookie"] }	<br>
${initParam["org.eclipse.jetty.servlet.SessionIdPathParameterName"] }
<hr>
<c:out value="<Hello>"></c:out>
<hr>
<my:firstTag/>
<hr>
<my:attrTag items="hello,world,china" header="My Header">C#,Java:${1+3}</my:attrTag>
<hr>
reverse Hello World:
${my:reverse("Hello World")}
<hr>

<easy:firstTag />
 
</body>
</html>