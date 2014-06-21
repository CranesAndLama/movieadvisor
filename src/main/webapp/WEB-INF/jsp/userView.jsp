<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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