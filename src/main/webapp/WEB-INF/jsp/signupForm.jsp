 					<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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