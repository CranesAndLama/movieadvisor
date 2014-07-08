                   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
                   <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
                    <li class="movie-item">
                            <s:url value="/movies/{movieId}" var="movie_url">
								<s:param name="movieId" value="${movie.movieDb.id}"/>
							</s:url>
                            <a style="background: url(${movie.poster}) no-repeat center center" href="${movie_url}">
                             
                                <span class="movie-hover">
                                     <div class="desc">
                                         <h2><c:out value="${movie.movieDb.title}"/></h2>

                                         <p>Average rating: <c:out value="${movie.movieDb.voteAverage}"/></p>
										 <p>Release Date: <c:out value="${movie.movieDb.releaseDate}"/></p>
										 
                                     </div>
                                   <%@ include file="movieMenu.jsp" %>
                                </span>

                                <h2 class="movie-title">
                                    <span><c:out value="${movie.movieDb.title}"/></span>
                                </h2>
                            </a>
                        </li>