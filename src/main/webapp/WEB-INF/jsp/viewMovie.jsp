<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie ${movie.movieDb.id}</title>
</head>
<body>
	<img src="<c:url value="http://image.tmdb.org/t/p/w500${movie.movieDb.posterPath}"/>"	
		width="80"
		border="0"
		align="middle"/>
	<c:out value="${movie.movieDb.title}"/><br> 
	<c:out value="${movie.movieDb.voteAverage}"/><br>
	<c:out value="${movie.movieDb.releaseDate}"/> 
</body>
</html>