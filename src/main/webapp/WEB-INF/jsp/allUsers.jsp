<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All registered users:</title>
</head>
<body>
	<c:forEach var="user" items="${allUsers}">
		<c:out value="${user.username}"/><br> 
		<c:out value="${user.fullName}"/>
		
		<img src="<c:url value="/resources/img/${user.userId}.jpg"/>"
					width="80"
					border="0"
					align="middle"/>
					
		<p><input type="button" onclick="location.href='/movieadvisor/addfriend/${user.userId}'" value="Add Friend"></p>
		
	</c:forEach>
</body>
</html>