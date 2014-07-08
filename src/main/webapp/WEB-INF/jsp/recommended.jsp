<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
<section class="maincontent catalog s-color1">
<div class="wrap">
<div class="leftcontent">
<div class="tabs_wrap main_section">
    <h3><a href="">Recommended</a></h3>
    <ul class="movies-list">
    	<c:forEach var="movie" items="${recommended}">
 			<%@ include file="movieItem.jsp" %>
 		</c:forEach>
    </ul>



    <ul class="pager">
    	<c:if test="${currentPage != 1}">
			<li class="prev pager_nav pager_item"><a href="recommendations?page=${currentPage - 1}">Prev</a></li>
	    </c:if>
	
		<c:forEach begin="1" end="${noOfPages}" var="i">
			 <c:choose>
			  	<c:when test="${currentPage eq i}">
			  		<li class="pager_item"><a>${i}</a></li>
			  	</c:when>
			  	<c:otherwise>
			  		<li class="pager_item"><a href="recommendations?page=${i}">${i}</a></li>
			  	</c:otherwise>
			 </c:choose>
	      </c:forEach>
		<c:if test="${currentPage lt noOfPages}">
			<li class="next pager_nav pager_item"><a href="recommendations?page=${currentPage + 1}">Next</a></li>
	    </c:if>
    
    
    </ul>
</div>

</div>
<div class="sidebar"></div>
</div>
</section>
</body>