<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery.min.js"></script>
        <script>
        var urlLocale = '<c:url value="/setLocale"/>?type=json&locale=';
        $(document).ready(function(){
        	$("#language").change(function(){
        		var newLocale = $(this).val();
        		 $.ajax({
        		        url: urlLocale+newLocale,
        		        type: "GET",
        		        dataType: "json",
        		        success: function (rsp) {
        		            if(rsp.code==0){
        		            	window.location.reload(); 
        		            }
        		            else {
        		            	alert(rsp.message);
        		            }
        		        }
        		    });
        	});
        });
        </script>
    </head>
    <body>
        <h1>Hello World!这是我的SSH测试项目.</h1>
        当前语言: ${requestScope.currentLocale }
        <br>
        
        <spring:message code="lang" />:
        <select id="language">
        <c:forEach var="locale" items="${supportLocales}">
        	<option value="${locale }" <c:if test="${locale eq requestScope.currentLocale.toString()}">selected="selected"</c:if> >
        		<spring:message code="${locale }"/></option>
        </c:forEach>
        </select>
        
        <spring:message code="jsp.fmt.test" arguments="张三,李四" />
    </body>
</html>
