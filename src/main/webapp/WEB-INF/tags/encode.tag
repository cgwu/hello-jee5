<%@ tag language="java" pageEncoding="UTF-8" import="org.apache.commons.lang.StringEscapeUtils" %>
<%@ attribute name="input" required="true" %>
<div style="color: blue">
	<%=StringEscapeUtils.escapeHtml(input)%>
</div>
