<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<my:invoke>
		<jsp:attribute name="frag1">
			这是第一个属性 ${12+1 }
		</jsp:attribute>
		<jsp:attribute name="frag2">
			这是第二个属性
		</jsp:attribute>
	</my:invoke>
	
	<hr>
	
<my:precode> 
<jsp:attribute name="preserve"> 
<b>${ code }</b> 
</jsp:attribute>
<jsp:body>
PROGRAM MAIN 
PRINT 'HELLO' 
END 
</jsp:body> 
</my:precode> 
</body>
</html>