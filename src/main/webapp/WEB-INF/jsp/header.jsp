<!-- 
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="/movieadvisor/resources/js/script.js" type="text/javascript"></script>
	<!-- 
	<script type="text/jasvascript" src="/resources/js/jquery-2.1.1.js"></script>
	
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
 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
    <link rel="stylesheet" type="text/css" href="/movieadvisor/resources/css/sprite.css">
    <link rel="stylesheet" type="text/css" href="/movieadvisor/resources/fonts/fonts.css">
    <link rel="stylesheet" type="text/css" href="/movieadvisor/resources/style.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="/movieadvisor/resources/js/script.js" type="text/javascript"></script>
	<script src="/movieadvisor/resources/js/ajax.js" type="text/javascript"></script>

</head>

<header class="main_head">
    <div class="wrap">
        <a class="logo" href="/movieadvisor/main">Logo</a>
        <ul class="main_nav">
            <li class="color1"><a href="">Watchlist</a></li>
            <li class="color2"><a href="/movieadvisor/recommendations?page=1">Recommendations</a></li>
            
            <li class="color3"><a href="/movieadvisor/user/${loginUser.username}">Account</a></li>
            
        </ul>
        <div class="fl-r">
            <form class="search_wrap">
                <input type="text" placeholder="Search" class="search_inp" id="search_inp"/>
                <button class="search_icon"></button>
            </form>
            
            <c:choose>
      			<c:when test="${loginUser==null}"> 
					<div class="login_zone">
                		<div class="signin" data-hover="SignIn">
                    		<span>SignIn</span>
                		</div>
                		<div class="signup" data-hover="SignUp">
                    		<span>SignUp</span>
                		</div>
            		</div>
      			</c:when>

      			<c:otherwise>
      				<s:url value="/user/{username}" var="user_url">
								<s:param name="username" value="${loginUser.username}"/>
					</s:url>
					<!-- 
      				 <a class="user_av" href="${user_url}">
   						<img src="/movieadvisor/resources/img/${loginUser.userId}.jpg" />
					</a>
					 -->
      				<a class="user_av" style="background: url('/movieadvisor/resources/img/${loginUser.userId}.jpg') no-repeat center center" href="${user_url}"></a>
      			</c:otherwise>
			</c:choose>
            
        </div>
    </div>
</header>