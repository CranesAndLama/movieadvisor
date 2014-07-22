<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
<section class="maincontent catalog s-color1">
<div class="wrap">
<div class="leftcontent">
<div class="tabs_wrap main_section">
    <h3><a href="">Search Results:</a></h3>
    <ul class="movies-list">
    	<c:forEach var="movie" items="${movies}">
 			<%@ include file="movieItem.jsp" %>
 		</c:forEach>
    </ul>



    <ul class="pager">
    	<c:if test="${currentPage != 1}">
			<li class="prev pager_nav pager_item"><a href="search?page=${currentPage - 1}">Prev</a></li>
	    </c:if>
	
		<c:forEach begin="1" end="${noOfPages}" var="i">
			 <c:choose>
			  	<c:when test="${currentPage eq i}">
			  		<li class="pager_item"><a>${i}</a></li>
			  	</c:when>
			  	<c:otherwise>
			  		<li class="pager_item"><a href="search?page=${i}">${i}</a></li>
			  	</c:otherwise>
			 </c:choose>
	      </c:forEach>
		<c:if test="${currentPage lt noOfPages}">
			<li class="next pager_nav pager_item"><a href="search?page=${currentPage + 1}">Next</a></li>
	    </c:if>

    </ul>
    <h3>Users found:</h3>
    <ul class="friend_list with_btns full_width">
    	<c:forEach var="user" items="${users}">
        	<%@ include file="userItem.jsp" %>
        </c:forEach>
     </ul>
     
</div>
</div>
</div>
</section>
</body>