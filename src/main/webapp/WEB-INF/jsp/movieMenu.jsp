				<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
                <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
                <div class="btns">
                    <span class="del"></span>
                    
                    <s:url value="/ratemovie/{movieId}" var="ratemovie_url">
						<s:param name="movieId" value="${movie.movieDb.id}"/>
					</s:url>
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
					     <input class="rate_movie" type="hidden" name="rating" id="${movie.movieDb.id}" value="${movie.rating}" data-url="${ratemovie_url}">                    	
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

