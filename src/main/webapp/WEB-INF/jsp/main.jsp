<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>


<body class="notLogg">
<section class="maincontent s-color1">
    <div class="wrap">
        <div class="leftcontent">
            <div class="tabs_wrap main_section">
                <ul class="tabs">
                    <li class="tab-item active"><a href="#newMovies">New Movies</a></li>
                    <li class="tab-item"><a href="#top250">Top 250</a></li>
                </ul>
                <div class="tab-content" id="newMovies">
                <ul class="movies-list">
                
                <c:forEach var="movie" items="${newMovies}">
                    <%@ include file="movieItem.jsp" %>
                </c:forEach>
                </ul>
                <div class="aligncenter">
                <span class="loadmore">
                    Load More
                </span>
                    </div>
                </div>
                
                <div class="tab-content" id="top250">
                    <ul class="movies-list">
                    <c:forEach var="movie" items="${topRated}">
                         <%@ include file="movieItem.jsp" %>
                    </c:forEach>
                        </ul>
                    <div class="aligncenter">
                <span class="loadmore">
                    Load More
                </span>
                    </div>
                </div>
            </div>
        </div>
     </div>
</section> 
</body>