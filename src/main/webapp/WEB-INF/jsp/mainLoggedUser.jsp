<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Advisor</title>

</head>
<body>
<!-- 
	<p>Set Movie Ratings</p>
	<input type="button" onclick="location.href='/movieadvisor/rate'" value="rate movies script">
 -->
	<p>Top Rated Movies: </p>
	<c:forEach var="movie" items="${topRated}">
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
			
			<p>ID: <c:out value="${movie.movieDb.id}"/></p>
			<p>Rating: <c:out value="${movie.movieDb.voteAverage}"/></p>
			<p>Release Date: <c:out value="${movie.movieDb.releaseDate}"/></p>
			<p>Your rating: <span class="rating"><c:out value="${movie.rating}"/></span></p>
			<p>Is in Watchlist <span class="watchlist"><c:out value="${movie.isInWatchlist}"/></span></p>
			
			<c:set var="isInWatchlist" scope="session" value="${movie.isInWatchlist}"/>
			<c:choose>
      			<c:when test="${isInWatchlist==true}"> 
					<input type="button" onclick="removeFromWatchlist('/movieadvisor/removefromwatchlist/${movie.movieDb.id}')" value="Remove From Watchlist"></input>
      				<br/>
      			</c:when>

      			<c:otherwise>
      				<input type="button" onclick="addToWatchlist('/movieadvisor/addtowatchlist/${movie.movieDb.id}')" value="Add To Watchlist"></input>
      				<br/>
      			</c:otherwise>
			</c:choose>
			
			<!-- 
			<form:form method="POST" modelAttribute="ratedMovie" action="/movieadvisor/ratemovie/${movie.movieDb.id}">
			</form:form>
			 -->
			 
			<form:form class="rateMovieForm" method="POST" modelAttribute="ratedMovie" data-id="/movieadvisor/ratemovie/${movie.movieDb.id}">
			<fieldset>
			<table cellspacing="0">
			<tr>
					<th><label for="movie_rating">rate movie:</label></th>
					<td><form:input path="rating" size="30" class="movie_rating"/>						
						
					</td>
			</tr>
			<tr>
					<th></th>
					<td>
						<!--
						<c:set var="ratedUrl" scope="session" value="/movieadvisor/ratemovie/${movie.movieDb.id}"/>
						-->
						<input id="rateId" name="commit" type="submit" value="Rate"/>
						
					</td>
			</tr>
			<tr><td colspan="2"><div id="info" style="color: green;"></div></td></tr>
			
			</table>
			</fieldset>
		</form:form>
			
		</li>
	</c:forEach>
	
	<p>Watchlist: </p>
	
	<c:forEach var="movieW" items="${watchlist}">
		<s:url value="/movies/{movieId}"
				var="movie_url">
			<s:param name="movieId"
					value="${movieW.movieDb.id}"/>
		</s:url>
		<br>
		<li>
			<img src="<c:url value="http://image.tmdb.org/t/p/w500${movieW.movieDb.posterPath}"/>"
				width="80"
				border="0"
				align="middle"/>
			<br>	
			<a href="${movie_url}">
				<c:out value="${movieW.movieDb.title}"/>
			</a>
			
			<p>ID: <c:out value="${movieW.movieDb.id}"/><p>
			<p>Rating: <c:out value="${movieW.movieDb.voteAverage}"/><p>
			<p>Release Date: <c:out value="${movieW.movieDb.releaseDate}"/></p>
			
			<!-- 
				<input type="button" onclick="location.href='/movieadvisor/addtowatchlist/${movie.id}'" value="Add To Watchlist">
			 -->
			
		</li>
	</c:forEach>
	
</body>
</html>