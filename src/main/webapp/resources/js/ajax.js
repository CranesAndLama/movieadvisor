	$(document).ready(function() {
 		
 		$('.rateMovieForm').submit(function(event) {
 		event.preventDefault();
 		console.log(this);
 		 var rating = $(this).find(".movie_rating").val();
 		 var urlValue = $(this).data("id");
 		 
 		var ratingResponce =  $(this).closest('li').find('.rating');
 		
 		console.log('0: ', ratingResponce.html());
 		 //var urlValue = $("#ratedUrl").val();
 		 $.ajax({
 			url: urlValue,
 			//url: $("#rateMovieForm").attr("action"),
 			data: {rating: rating},
 			type: "POST",
 	        }).done (function(responce) {
 	    	   ratingResponce.html(responce);
 	    	}).fail (function(err) {
 	    	   console.error(err);
 	    	});
 		});
 	});

function removeFromWatchlist(url) {
	 var watchlistResponce =  $(this).closest('li').find('.watchlist');
	 console.log('0: ', watchlistResponce.html());
	$.ajax({
		 url:url,
		 type: "GET"
	 }).done (function(responce) {
		 watchlistResponce.html(responce);
	 }).fail (function(err) {
		console.error(err);
	});
}
function addToWatchlist(url) {
	 var watchlistResponce =  $(this).closest('li').find('.watchlist');
	 console.log('0: ', watchlistResponce.html());
	$.ajax({
		 url:url,
		 type: "GET"
	 }).done (function(responce) {
		 watchlistResponce.html(responce);
	 }).fail (function(err) {
		console.error(err);
	});
}	