<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Account</title>
</head>
<body>
	<div>
		<h2>Create new user account:</h2>
		<sf:form method="POST" modelAttribute="newUser" enctype="multipart/form-data">
			<fieldset>
			<table cellspacing="0">
				<tr>
					<th><label for="user_full_name">Full name:</label></th>
					<td><sf:input path="fullName" size="15" id="user_full_name"/>
						<br/>
						<sf:errors path="fullName" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><label for="user_screen_name">Username:</label></th>
					<td><sf:input path="username" size="15" maxlength="15" id="user_screen_name"/>			
						<small id="username_msg">No spaces,please.</small><br>
						<sf:errors path="username" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><label for="user_password">Password:</label></th>
					<td><sf:password path="password" size="30" showPassword="true" id="user_password"/>
						<small>6 characters or more(be tricky!)</small><br>
						<sf:errors path="password" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><label for="user_email">Email Address:</label></th>
					<td><sf:input path="email" size="30" id="user_email"/>						
						<sf:errors path="email" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><label for="image">Profile image:</label></th>
					<td><input name="image" type="file"/>
				</tr>
				<tr>
					<th></th>
					<td>
						<input name="commit" type="submit" value="Create my account."/>
					</td>
				</tr>
			</table>
			</fieldset>
		</sf:form>
	</div>
</body>
</html>