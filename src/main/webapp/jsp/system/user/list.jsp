<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User list Jsp</title>
</head>
<body>
<h1>user list jsp</h1>
countries:

<hr>
ServletContext中的内容:
<s:property value="#attr['countries']['cn']"/>
<br>
Session中的内容:
<s:property value="#session.startTime"/>
<br>
parameters参数中:
<s:property value="#parameters.name"/><br>
page.index = <s:property value="#parameters['page.index']"/>
<hr>
访问静态字段:
<s:property value="@com.cg.hellojee5.Constants@HELLO" />
<br>
访问静态方法(未成功):
<s:property value="%{@com.cg.hellojee5.Constants@getHello() }" /> 
</body>
</html>