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

</head>
<body class="notLogg">
<header class="main_head">
    <div class="wrap">
        <a class="logo" href="">Logo</a>
        <ul class="main_nav">
            <li class="color1"><a href="">Watchlist</a></li>
            <li class="color2"><a href="">Recommendations</a></li>
            <li class="color3"><a href="">Account</a></li>
        </ul>
        <div class="fl-r">
            <form class="search_wrap">
                <input type="text" placeholder="Search" class="search_inp" id="search_inp"/>
                <button class="search_icon"></button>
            </form>
            <div class="login_zone">
                <div class="signin" data-hover="SignIn">
                    <span>SignIn</span>
                </div>
                <div class="signup" data-hover="SignUp">
                    <span>SignUp</span>
                </div>
            </div>
        </div>
    </div>
</header>