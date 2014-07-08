



/*function removeFromWatchlist(a, url) {
	 //var watchlistResponce =  $(this).closest('li').find('.watchlist');
	 //console.log('0: ', watchlistResponce.html());
	var watchlistResponce = $(a).parents('.movie-item').find('.watchlist.inWatchlist');
	console.log('0: ', watchlistResponce.html());
	$.ajax({
		 url:url,
		 type: "GET"
	 }).done (function(responce) {
		 watchlistResponce.removeClass('inWatchlist');
		 
	 }).fail (function(err) {
		console.error(err);
	});
}

function addToWatchlist(a, url){
	var watchlistResponce = $(a).parents('.movie-item').find('.watchlist');
	       console.log('0: ', watchlistResponce.html());
	      $.ajax({
	               url:url,
	               type: "GET"
	       }).done (function(responce) {
	               watchlistResponce.addClass('inWatchlist');
	       }).fail (function(err) {
	              console.error(err);
	      });
	}
*/
/*$(document).ready(function() {
	$('.watchlist.inWatchlist').click(function(){
		var watchlistResponce = $(this).parents('.movie-item').find('.watchlist');
		console.log('0: ', watchlistResponce.html());
		var url = $(this).data("removeurl");
		console.log('1: ', url);
			$.ajax({
	               url:url,
	               type: "GET"
	       }).done (function(responce) {
	               watchlistResponce.removeClass('inWatchlist');
	       }).fail (function(err) {
	              console.error(err);
	      });
	});
});*/

$(document).ready(function() {
	$('.watchlist').click(function(){
		if($('.watchlist').hasClass('inWatchlist')){
			var watchlistResponce = $(this).parents('.movie-item').find('.watchlist');
			console.log('0: ', watchlistResponce.html());
			var url = $(this).data("removeurl");
			console.log('1: ', url);
				$.ajax({
		               url:url,
		               type: "GET"
		       }).done (function(responce) {
		               watchlistResponce.removeClass('inWatchlist');
		       }).fail (function(err) {
		              console.error(err);
		      });
		}
		else {
			var watchlistResponce = $(this).parents('.movie-item').find('.watchlist');
			console.log('0: ', watchlistResponce.html());
			var url = $(this).data("addurl");
			console.log('1: ', url);
			$.ajax({
				url:url,	
				type: "GET"
		    }).done (function(responce) {
		    	watchlistResponce.addClass('inWatchlist');
		    }).fail (function(err) {
		    	console.error(err);
		    });
		}
	    
	});
});