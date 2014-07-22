					 <li class="movie-item sidebar_movie-item">
                    	<s:url value="/movies/{movieId}" var="movie_url">
							<s:param name="movieId" value="${movie.movieDb.id}"/>
						</s:url>
                        <a style="background: url('${movie.poster}') no-repeat center center" href="${movie_url}">

                            <h2 class="movie-title">
                                <span><c:out value="${movie.movieDb.title}"/></span>
                            </h2>
                            <div class="btns">

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
                                <s:url value="/removefromwatchlist/{movieId}" var="removefromwatchlist_url">
									<s:param name="movieId" value="${movie.movieDb.id}"/>
								</s:url>
								
                                <span class="watchlist inWatchlist" data-removeUrl="${removefromwatchlist_url}">
                                </span>
                            </div>
                        </a>
                    </li>