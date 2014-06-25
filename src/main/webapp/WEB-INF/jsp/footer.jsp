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
		            <sf:form method="POST" modelAttribute="newUser" action="/movieadvisor/user/signup">
						<label for="user_screen_name">Username:</label>
						<sf:input path="username" size="15" maxlength="15" id="user_screen_name"/>			
						<small id="username_msg">No spaces,please.</small><br>
						<sf:errors path="username" cssClass="error"/>
						
						<label for="user_email">Email Address:</label>
						<sf:input path="email" size="30" id="user_email"/>						
						<sf:errors path="email" cssClass="error"/>
						
						<label for="user_password">Password:</label>
						<sf:password path="password" size="30" showPassword="true" id="user_password"/>
						<small>6 characters or more(be tricky!)</small><br>
						<sf:errors path="password" cssClass="error"/>
						
						<input class="btn1" name="commit" type="submit" value="Create my account."/>
				</sf:form>
                    <div class="soc_login">
                        <h3>SignUp Socials</h3>
                        <div class="soc_login_btns">
                            <a class="soc_login_item fb" href=""></a>
                            <a class="soc_login_item tw" href=""></a>
                            <a class="soc_login_item gp" href=""></a>
                        </div>
                    </div>
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
			        <sf:form method="POST" modelAttribute="newUser" action="/movieadvisor/user/login">
						<label for="user_email">Email Address:</label>
						<sf:input path="email" size="30" id="user_email"/>						
						<sf:errors path="email" cssClass="error"/>
								
						<label for="user_password">Password:</label>
						<sf:password path="password" size="30" showPassword="true" id="user_password"/>
						<sf:errors path="password" cssClass="error"/>
							
						<input class="btn1" name="commit" type="submit" value="Login"/>
						
					</sf:form>
                    
                    <div class="soc_login">
                        <h3>SignIn Socials</h3>
                        <div class="soc_login_btns">
                            <a class="soc_login_item fb" href=""></a>
                            <a class="soc_login_item tw" href=""></a>
                            <a class="soc_login_item gp" href=""></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</html>