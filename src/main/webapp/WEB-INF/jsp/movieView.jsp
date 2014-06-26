<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!-- 
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
 -->
<body class = "logged">
<section class="maincontent s-color1 single">
		
    <div class="s_movie_header" style="background: url(${movie.backgroundPoster}) no-repeat center center">
        <div class="wrap">

            <div class="movie-item" style="background: url(${movie.poster}/>) no-repeat center center">
                <div class="btns">
                    <span class="del"></span>
                    <span class="rate">
                        <div class="rate_popup_wrap">
					      <div class="raiting-box">
					          <div class="star">1</div>
					          <div class="star">2</div>
					          <div class="star">3</div>
					          <div class="star">4</div>
					          <div class="star">5</div>
					          <div class="star">6</div>
					          <div class="star">7</div>
					          <div class="star">8</div>
					          <div class="star">9</div>
					          <div class="star">10</div>
					       </div>
					     </div>
					     <input type="hidden" name="rating" id="rating1" value="0">                    	
                    </span>
                    
                    <s:url value="/addtowatchlist/{movieId}" var="addtowatchlist_url">
						<s:param name="movieId" value="${movie.movieDb.id}"/>
					</s:url>
					<s:url value="/removefromwatchlist/{movieId}" var="removefromwatchlist_url">
						<s:param name="movieId" value="${movie.movieDb.id}"/>
					</s:url>
					<c:set var="isInWatchlist" scope="session" value="${movie.isInWatchlist}"/>
					<c:choose>
      					<c:when test="${isInWatchlist==true}"> 
      						<span class="watchlist inWatchlist" data-addUrl="${addtowatchlist_url}" data-removeUrl="${removefromwatchlist_url}">
      						</span>
      					
      					</c:when>

      					<c:otherwise>
      						<span class="watchlist" data-addurl="${addtowatchlist_url}" data-removeurl="${removefromwatchlist_url}">      							
      						</span>
      					
      					</c:otherwise>
					</c:choose>
                    
                    
                </div>
            </div>

            <div class="movie_desc">
                <h3><c:out value="${movie.movieDb.title}"/></h3>
				 
				
                	<p><strong><c:out value="${movie.movieDb.credits.crew[0].job}"/> : 
                				<c:out value="${movie.movieDb.credits.crew[0].name}"/></strong><a href=""></a></p>
					<p><strong><c:out value="${movie.movieDb.credits.crew[1].job}"/> : 
								<c:out value="${movie.movieDb.credits.crew[1].name}"/></strong><a href=""></a></p>
				
                <p><strong>Stars:</strong> 
                
                	<strong><c:out value="${movie.movieDb.credits.cast[0].name}"/></strong><a href=""></a>, 
                	<strong><c:out value="${movie.movieDb.credits.cast[1].name}"/></strong><a href=""></a>, 
                	<strong><c:out value="${movie.movieDb.credits.cast[2].name}"/></strong><a href=""></a>
               
                </p>
                <p><strong>Average Rating: <c:out value="${movie.movieDb.voteAverage}"/></strong>
                <p><strong>Release Date: <c:out value="${movie.movieDb.releaseDate}"/></strong>

                <p>${movie.movieDb.overview}</p>
            </div>

        </div>
    </div>
    <div class="wrap">
    <div class="recommend_section main_section">
        <h3><a href="">Similar movies</a></h3>
        <ul class="movies-list">
            <li class="movie-item">
                <a style="background: url('') no-repeat center center" href="">
                     <span class="movie-hover">
                         <div class="desc">
                             <h2></h2>
                             <p> </p>
                             </div>
                                 <div class="btns">
                                      	<span class="del"></span>
                                        <span class="rate">
                                        	<div class="rate_popup_wrap">
					                            <div class="raiting-box">
					                                <div class="star">1</div>
					                                <div class="star">2</div>
					                                <div class="star">3</div>
					                                <div class="star">4</div>
					                                <div class="star">5</div>
					                                <div class="star">6</div>
					                                <div class="star">7</div>
					                                <div class="star">8</div>
					                                <div class="star">9</div>
					                                <div class="star">10</div>
					                            </div>
					                        </div>
					                        <input type="hidden" name="rating" id="rating1" value="0">
                                        </span>
                                        <span class="watchlist"></span>
                                    </div>
                                </span>

                   		<h2 class="movie-title">
                        <span></span>
                    </h2>
                </a>
            </li>
           
        </ul>
        <div class="aligncenter">
                    <span class="loadmore">
                        Load More
                    </span>
        </div>
    </div>
    </div>
</section>
</body>