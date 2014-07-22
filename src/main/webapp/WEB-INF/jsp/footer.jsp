<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<footer>
    <div class="wrap">
        <a class="logo logo_mini" href="">Logo</a>

        <div class="copy">&copy; CranesAndLama</div>
    </div>
</footer>
<div class="morph-button morph-button-modal morph-button-modal-2 morph-button-fixed signup-modal">
    <div class="form_content">
        <div class="morph-content">
            <div>
                <div class="content-style-form content-style-form-1">
                    <span class="icon-close"></span>
                    <!-- 
                    <form>
                        <label>Email</label><input type="text">
                        <label>Username</label><input type="text">
                        <label>Password</label><input type="password">
                        <div class="btn1" onclick="location.href='/movieadvisor/user/signup'">SignUp</div>
                    </form>
                     -->
		            <%@ include file="signupForm.jsp" %>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="morph-button morph-button-modal morph-button-modal-2 morph-button-fixed signin-modal">
    <div class="form_content">
        <div class="morph-content">
            <div>
                <div class="content-style-form content-style-form-1">
                    <span class="icon-close"></span>
                    <!--<h2>Login</h2>
                    <form>
                        <label>Email</label><input type="text">
                        <label>Password</label><input type="password">
                        <div class="btn1">SignIn</div>
                    </form>
                    -->
			        <%@ include file="loginForm.jsp" %>
                </div>
            </div>
        </div>
    </div>
</div>

</html>