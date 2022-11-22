<%@page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8"%>
<%@include file="./header.jsp"%>
	Hello, ${sessionScope.user.name} 
	<form action="">
		<input type="submit" value="logout" name="logout"/>
	</form>
<%@include file="./footer.jsp"%>