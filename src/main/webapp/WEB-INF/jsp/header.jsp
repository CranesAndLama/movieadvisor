<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
    <link rel="stylesheet" type="text/css" href="/movieadvisor/resources/css/sprite.css">
    <link rel="stylesheet" type="text/css" href="/movieadvisor/resources/fonts/fonts.css">
    <link rel="stylesheet" type="text/css" href="/movieadvisor/resources/style.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
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
        	
            <form class="search_wrap" method="POST" action="/movieadvisor/search?page=1">
                <input type="text" placeholder="Search" class="search_inp" name="query" id="query"/>
                <button class="search_icon"></button>
            </form>

             
            
             <!-- 
           		 <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />">Login</a></p>
           	 -->
           		 <div class="login_zone">
           		 <!-- 
                		<a class="signin" href="<c:url value="/login"/>" data-hover="SignIn">
                    		<span>SignIn</span>
                		</a>
               	  -->
                		<a class="signin" data-hover="SignIn">
                    		<span>SignIn</span>
                		</a>
                		<div class="signup" data-hover="SignUp">
                    		<span>SignUp</span>
                		</div>
            		</div>
        	
        	<sec:authorize access="isAuthenticated()">
            	<p>Your login: <sec:authentication property="principal.username" /></p>
            	<p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />">Logout</a></p>
 			</sec:authorize>
        </div>
    </div>
</header>