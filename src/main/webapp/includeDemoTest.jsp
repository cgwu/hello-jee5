<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Include Demo Test</title>
</head>
<body>
	<my:includeDemo />
	<hr>
	<hr>
	<my:include/>
	<hr>
	<hr>
	<my:encode input="<br/>这里是input属性的内容"/>
</body>
</html>