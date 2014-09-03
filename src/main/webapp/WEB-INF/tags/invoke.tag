<%@ tag language="java" pageEncoding="UTF-8" %>
<%@attribute name="frag1" fragment="true" %>
<%@attribute name="frag2" fragment="true" %>
<%@attribute name="frag3" fragment="true" required="false" %>
<table border="1">
	<tr>
		<td><b>frag1</b></td>
		<td><jsp:invoke fragment="frag1" /></td>
	</tr>
	<tr>
		<td><b>frag2</b></td>
		<td><jsp:invoke fragment="frag2" /></td>
	</tr>
	<tr>
		<td><b>frag3</b></td>
		<td><jsp:invoke fragment="frag3" /></td>
	</tr>
</table>
