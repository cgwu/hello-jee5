<%@ tag language="java" pageEncoding="UTF-8" import="java.util.Date" import="java.text.SimpleDateFormat"%>
现在日期时间:<%
	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date = sdf.format(new Date());
	out.write(date);
%>