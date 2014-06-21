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
	<p>Set Movie Ratings</p>
	<input type="button" onclick="location.href='/movieadvisor/rate'" value="rate movies script">

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
			
			<!-- Dropdown list 
			<br>
			Rate Movie:
			<form:form method="POST" modelAttribute="ratedMovie" action="/movieadvisor/ratemovie/${movie.movieDb.id}">
				<table>
    				<tbody><tr>
    					<td>
        					<ul>
            					<form:select path="rating">
            						<form:option selected="selected" value=""></form:option>
                					<form:option value="1">1</form:option>
                					<form:option value="2">2</form:option>
                					<form:option value="3">3</form:option>
                					<form:option value="4">4</form:option>
                					<form:option value="5">5</form:option>
                					<form:option value="6">6</form:option>
                					<form:option value="7">7</form:option>
                					<form:option value="8">8</form:option>
                					<form:option value="9">9</form:option>
                					<form:option value="10">10</form:option>
           						 </form:select>
        					</ul>
    					</td>
    				</tr>
    				<tr>
    					<td>
            				<input value="Submit" type="submit">
        				</td>
    				</tr>
				</tbody></table> 
			</form:form>
			-->
			
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