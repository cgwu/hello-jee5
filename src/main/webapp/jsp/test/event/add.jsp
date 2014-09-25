<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

</body>
</html>