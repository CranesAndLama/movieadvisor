		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
		<li class="friend_item">
        	<s:url value="/resources/img/{userId}.jpg" var="background_image">
						<s:param name="userId" value="${user.userId}"/>
			</s:url>
			<s:url value="/user/{username}" var="user_url">
						<s:param name="username" value="${user.username}"/>
			</s:url>
            <a href="${user_url}" class="f_wrap">
                <span class="front" style="background: url('${background_image}')"></span>
                <span class="back"><span>${user.fullName}</span></span>
            </a>
             <s:url value="/addfriend/{userId}" var="addfriend_url">
				<s:param name="userId" value="${user.userId}"/>
			</s:url>
			<s:url value="/removefriend/{userId}" var="removefriend_url">
				<s:param name="userId" value="${user.userId}"/>
			</s:url>
            <c:set var="isFriend" scope="session" value="${user.isFriendWithLogin}"/>
            <c:choose>
      			<c:when test="${isFriend==true}"> 
      				<span class="friend_btn remove_friend" data-addUrl="${addfriend_url}" data-removeUrl="${removefriend_url}">Remove</span>			
      			</c:when>
				<c:otherwise>
					<span class="friend_btn add_friend" data-addUrl="${addfriend_url}" data-removeUrl="${removefriend_url}">Add</span>	
      			</c:otherwise>
			</c:choose>
        </li>