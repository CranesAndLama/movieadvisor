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
                            <a id="fb_log" class="soc_login_item fb" href="#"></a>
                            <a class="soc_login_item tw" href=""></a>
                            <a class="soc_login_item gp" href=""></a>
                        </div>
                      <div id="fb-root"></div>
  <script src="http://connect.facebook.net/en_US/all.js"></script>
  <script>
    // initialize the library with the API key
    FB.init({ appId  : '1450671295187324' });

    // fetch the status on load
    FB.getLoginStatus(handleSessionResponse);

    jQuery('#fb_log').bind('click', function() {
      FB.login(handleSessionResponse);
    });

  
    // no user, clear display
    function clearDisplay() {
    	jQuery('.user_av').hide('fast');
    }

    // handle a session response from any of the auth related calls
    function handleSessionResponse(response) {
      // if we dont have a session, just hide the user info
      if (!response.session) {
        clearDisplay();
        return;
      }

      // if we have a session, query for the user's profile picture and name
      FB.api(
        {
          method: 'fql.query',
          query: 'SELECT name, pic FROM profile WHERE id=' + FB.getSession().uid
        },
        function(response) {
          var user = response[0];
         jQuery('.notLogg').addClass('logged').removeClass('notLogg');
         jQuery('.user_av').html('<img src="' + user.pic + '">' + user.name).show('fast');
        }
      );
    }
  </script>
                    </div>







			        <%@ include file="loginForm.jsp" %>
                </div>
            </div>
        </div>
    </div>
</div>

</html>