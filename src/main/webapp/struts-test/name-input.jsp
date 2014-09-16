<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输入你的名字</title>
</head>
<body>

<h4>Enter your name </h4>
<s:form action="nameSuccess" namespace="/struts/test">
<s:textfield name="name" label="你的名字"/>
<s:submit/>
</s:form>

</body>
</html>