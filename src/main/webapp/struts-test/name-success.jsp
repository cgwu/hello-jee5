<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>你的名字</title>
</head>
<body>

<h4>your name </h4>
<h4><s:property value="customGreeting"/></h4>

<a href="<s:url action="nameInput" namespace="/struts/test" />" >输入名字</a>
</body>
</html>