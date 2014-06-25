<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!-- 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
</head>
<body>
	<c:out value="${user.username}"/><br> 
	<c:out value="${user.fullName}"/>
	
	<img src="<c:url value="/resources/img/${user.userId}.jpg"/>"
				width="80"
				border="0"
				align="middle"/>
				<br>
				<br>
				
	<c:forEach var="friend" items="${friends}">
		<img src="<c:url value="/resources/img/${friend.userId}.jpg"/>"
				width="80"
				border="0"
				align="middle"/>
		
		<s:url value="/user/${friend.username}"
				var="friend_url">
			<s:param name="username"
					value="${friend.username}"/>
		</s:url>
		<a href="${friend_url}">
				<c:out value="${friend.username}"/>
		</a>
		<c:out value="${friend.fullName}"/>	
	</c:forEach>
	 
	 <p><input type="button" onclick="location.href='/movieadvisor/user/users'" value="Show all users"></p>
	 
	<c:forEach var="recentlyViewedMovie" items="${recentlyViewedMovies}">
		<s:url value="/movies/{movieId}"
				var="movie_url">
			<s:param name="movieId"
					value="${recentlyViewedMovie.movieDb.id}"/>
		</s:url>
		<br>
		<li>
			<img src="<c:url value="http://image.tmdb.org/t/p/w500${recentlyViewedMovie.movieDb.posterPath}"/>"
				width="80"
				border="0"
				align="middle"/>
			<br>	
			<a href="${movie_url}">
				<c:out value="${recentlyViewedMovie.movieDb.title}"/>
			</a>
			
			<p>Average Users Rating: <c:out value="${recentlyViewedMovie.movieDb.voteAverage}"/><p>
			<p>Release Date: <c:out value="${recentlyViewedMovie.movieDb.releaseDate}"/></p>
			<p>Your Rating: <c:out value="${recentlyViewedMovie.rating}"/></p>
			<p>In Watchlist: <c:out value="${recentlyViewedMovie.isInWatchlist}"/></p>
		</li>
	</c:forEach>
	
	
	<p>Recommendations: </p>
	<c:forEach var="movie" items="${recommended}">
		<s:url value="/movies/{movieId}"
				var="movie_url">
			<s:param name="movieId"
					value="${movie.movieDb.id}"/>
		</s:url>
		<br>
		<li>
			<img src="<c:url value="http://image.tmdb.org/t/p/w500${movie.movieDb.posterPath}"/>"
				width="80"
				border="0"
				align="middle"/>
			<br>	
			<a href="${movie_url}">
				<c:out value="${movie.movieDb.title}"/>
			</a>
			
			<p>ID: <c:out value="${movie.movieDb.id}"/><p>
			<p>Rating: <c:out value="${movie.movieDb.voteAverage}"/><p>
			<p>Release Date: <c:out value="${movie.movieDb.releaseDate}"/></p>
			<p>Your rating: <c:out value="${movie.rating}"/></p>
			<p>Is in Watchlist <c:out value="${movie.isInWatchlist}"/></p>
			
			<c:set var="isInWatchlist" scope="session" value="${movie.isInWatchlist}"/>
			<c:choose>
      			<c:when test="${isInWatchlist==true}">
					<input type="button" onclick="location.href='/movieadvisor/removefromwatchlist/${movie.movieDb.id}'" value="Remove From Watchlist">
      				<br />
      			</c:when>

      			<c:otherwise>
      			<input type="button" onclick="location.href='/movieadvisor/addtowatchlist/${movie.movieDb.id}'" value="Add To Watchlist">
      				<br/>
      			</c:otherwise>
			</c:choose>
			
			<form:form method="POST" modelAttribute="ratedMovie" action="/movieadvisor/ratemovie/${movie.movieDb.id}">
			<fieldset>
			<table cellspacing="0">
			<tr>
					<th><label for="movie_rating">rate movie:</label></th>
					<td><form:input path="rating" size="30" id="movie_rating"/>						
						
					</td>
			</tr>
			
			<tr>
					<th></th>
					<td>
						<input name="commit" type="submit" value="Rate"/>
					</td>
			</tr>
			</table>
			</fieldset>
		</form:form>
			
		</li>
	</c:forEach>
	
</body>
</html>
 -->
 
 <body class="logged">
 	<section class="maincontent s-color1">
<div class="wrap">
<div class="leftcontent">
    <div class="user_info">
        <div class="u_photo" style="background: url('/movieadvisor/resources/img/${user.userId}.jpg') no-repeat center center">

        </div>
        <div class="u_desc">
            <div class="name">${user.username}</div>
            <div class="name">${user.fullName}</div>
            <!--<div class="favorite_genres">-->
            <!--<strong>Favorite genres:</strong>-->
            <!--<ul class="tag_list">-->
            <!--<li class="tag_item">-->
            <!--<a href="">Drama</a>-->
            <!--</li>-->
            <!--<li class="tag_item">-->
            <!--<a href="">Crime</a>-->
            <!--</li>-->
            <!--<li class="tag_item">-->
            <!--<a href="">Comedy</a>-->
            <!--</li>-->
            <!--<li class="tag_item">-->
            <!--<a href="">Mystic</a>-->
            <!--</li>-->
            <!--<li class="tag_item">-->
            <!--<a href="">Drama</a>-->
            <!--</li>-->
            <!--<li class="tag_item">-->
            <!--<a href="">Drama</a>-->
            <!--</li>-->
            <!--</ul>-->
            <!--</div>-->
        </div>
    </div>

    <div class="friend_section">
    	
        <h4><a href="">Friends</a></h4>
        <ul class="friend_list">
       		 <c:forEach var="friend" items="${friends}">
       		 
            <li class="friend_item">
            	<s:url value="/user/{username}" var="friend_url">
						<s:param name="username" value="${friend.username}"/>
				</s:url>
                <a href="${friend_url}" class="f_wrap">
                    <span class="front" style="background: url('/movieadvisor/resources/img/${friend.userId}.jpg')"></span>
                    <span class="back"><span>${friend.fullName}</span></span>
                </a>
            </li>
            </c:forEach> 
        </ul>
        <div class="alignright">
            <a href="" class="seemore goto">More</a>
        </div>
    </div>
    <div class="small_section main_section">
        <h4><a href="">Recently viewed</a></h4>
        <ul class="movies-list">
        	<c:forEach var="recentlyViewedMovie" items="${recentlyViewedMovies}">
            <li class="movie-item">
            	<s:url value="/movies/{movieId}" var="movie_url">
					<s:param name="movieId" value="${recentlyViewedMovie.movieDb.id}"/>
				</s:url>
                <a style="background: url('${recentlyViewedMovie.poster}') no-repeat center center" href="${movie_url}">
                                <span class="movie-hover">
                                     <div class="desc">
                                         <h2>${recentlyViewedMovie.movieDb.title}</h2>

                                         <p>Average rating: <c:out value="${recentlyViewedMovie.movieDb.voteAverage}"/></p>
										 <p>Release Date: <c:out value="${recentlyViewedMovie.movieDb.releaseDate}"/></p>
                                     </div>
                                    <div class="btns">

                                        <span class="del"></span>
                                        <span class="rate"></span>
                                        <span class="watchlist"></span>
                                    </div>
                                </span>

                    <h2 class="movie-title">
                        <span>${recentlyViewedMovie.movieDb.title}</span>
                    </h2>
                </a>
            </li>
            </c:forEach>
            
        </ul>
        <div class="alignright">
            <a href="" class="seemore goto">More</a>
        </div>
    </div>

</div>


<div class="sidebar">
    <div class="sidebar_widget sidebar_watchlist">
        <h3><a href="">Watchlist</a></h3>
        <ul class="movies-list">
        <c:forEach var="movie" items="${watchlist}">
            <li class="movie-item">
            <s:url value="/movies/{movieId}" var="movie_url">
				<s:param name="movieId" value="${movie.movieDb.id}"/>
			</s:url>
                <a style="background: url('${movie.poster}') no-repeat center center" href="${movie_url}">

                    <h2 class="movie-title">
                        <span>${movie.movieDb.title}</span>
                    </h2>
                    <div class="btns">

                        <span class="rate"></span>
                        <span class="watchlist inWatchlist"></span>
                    </div>
                </a>
            </li>
        </c:forEach>
        </ul>
        <a class="goto" href="">Go to watchlist</a>
    </div>
</div>
</div>
</section>
 </body>
 