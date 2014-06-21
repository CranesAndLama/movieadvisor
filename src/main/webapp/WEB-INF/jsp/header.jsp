<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
	<body>
	<h1>Header</h1>
	<input type="button" onclick="location.href='/movieadvisor/user/login'" value="Log In">
	<br>
	<input type="button" onclick="location.href='/movieadvisor/user/signup'" value="Sign Up">
	</body>
	<p>${greeting} </p>
	<input type="button" onclick="location.href='/movieadvisor/user/${loginUser.username}'" value="My Account">
</html>