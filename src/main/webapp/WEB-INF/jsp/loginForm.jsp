<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
		<sf:form method="POST" modelAttribute="user">
			<fieldset>
			<table cellspacing="0">
			<tr>
					<th><label for="user_email">Email Address:</label></th>
					<td><sf:input path="email" size="30" id="user_email"/>						
						<sf:errors path="email" cssClass="error"/>
					</td>
			</tr>
			<tr>
					<th><label for="user_password">Password:</label></th>
					<td><sf:password path="password" size="30" showPassword="true" id="user_password"/>
						<sf:errors path="password" cssClass="error"/>
					</td>
			</tr>
			<tr>
					<th></th>
					<td>
						<input name="commit" type="submit" value="Login"/>
					</td>
			</tr>
			</table>
			</fieldset>
		</sf:form>
</body>
</html>