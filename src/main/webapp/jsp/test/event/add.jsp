<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<html>
<head>
<title>event add</title>
</head>
<body>
<h1>event add</h1>
<h4>${msg}</h4>

<form action="/test/event/add.htm" method="post">
<input name="post" type="hidden" value="true" />
<table>
	<tr>
		<td>Title</td>
		<td><input type="text" name="model.title"></td>
	</tr>
	<tr>
		<td>Date</td>
		<td><input type="text" name="model.date"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="submit"/></td>
	</tr>
</table>
</form>
<hr>
ref:
<br>
http://blog.csdn.net/hanqunfeng/article/details/4879912
<br>
http://blog.csdn.net/kcai678/article/details/5403745
<br>
http://www.journaldev.com/2610/spring-mvc-internationalization-i18n-and-localization-l10n-example

<br>
当前locale:
<b>
<%
java.util.Locale _currentLocale = org.springframework.web.servlet.support.RequestContextUtils.getLocale(request);
String _localeAsString = _currentLocale.toString();
out.println(_localeAsString);
%>
</b>
<br>
<h1>中英文测试</h1>
<h4><spring:message code="lang" /></h4>
<%-- <h4><spring:message code="jsp.common.header" /></h4> --%>
<a href="/test/event/add.htm?locale=en">English</a>
<a href="/test/event/add.htm?locale=zh_CN">中文</a>

</body>
</html>