<!-- 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
 
<div class="container" style="width: 300px;">
    <c:url value="/j_spring_security_check" var="loginUrl" />
    <form action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus>
        <input type="password" class="form-control" name="j_password" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </form>
</div>
 
</body>
 -->
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 
<div class="container" style="width: 300px;">
    <c:url value="/j_spring_security_check" var="loginUrl" />
    <form action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus>
        <input type="password" class="form-control" name="j_password" placeholder="Password" required>
        <button class="btn1" type="submit">Login Spring Security</button>
    </form>
</div>
 <div class="soc_login">
                        <h3>SignIn Socials</h3>
                    <div class="soc_login_btns">
                            <a class="soc_login_item fb" href=""></a>
                            <a class="soc_login_item tw" href=""></a>
                            <a class="soc_login_item gp" href=""></a>
                        </div>
                    </div>
                    

                    