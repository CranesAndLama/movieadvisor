



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
	$('.watchlist').click(function(e){
		if($(this).hasClass('inWatchlist')){
			var watchlistResponce = $(this);
			console.log('0: ', watchlistResponce.html());
			var url = $(this).data("removeurl");
			console.log('1: ', url);
            console.log('inWatchlist');
				$.ajax({
		               url:url,
		               type: "GET"
		       }).done (function(responce) {
		               watchlistResponce.removeClass('inWatchlist');
                    var m_item = watchlistResponce.parents('.movie-item');

                    if(m_item.hasClass('sidebar_movie-item')){
                        m_item.remove();
                    }

		       }).fail (function(err) {
		              console.error(err);
		      });
		}
		else {
			var watchlistResponce = $(this);
			console.log('0: ', watchlistResponce.html());
			var url = $(this).data("addurl");
			console.log('1: ', url);
            console.log('Watchlist');
			$.ajax({
				url:url,	
				type: "GET"
		    }).done (function(responce) {
		    	watchlistResponce.addClass('inWatchlist');
		    }).fail (function(err) {
		    	console.error(err);
		    });
		}
        e.preventDefault();
	});
});

$(document).ready(function() {
	$('.friend_btn').click(function(e){
		if($(this).hasClass('remove_friend')){
			var watchlistResponce = $(this);
			console.log('0: ', watchlistResponce.html());
			var url = $(this).data("removeurl");
			console.log('1: ', url);
            console.log('remove friend');
				$.ajax({
		               url:url,
		               type: "GET"
		       }).done (function(responce) {
		               watchlistResponce.removeClass('remove_friend');
		               watchlistResponce.addClass('add_friend');
		       }).fail (function(err) {
		              console.error(err);
		      });
		}
		else {
			var watchlistResponce = $(this);
			console.log('0: ', watchlistResponce.html());
			var url = $(this).data("addurl");
			console.log('1: ', url);
            console.log('add friend');
			$.ajax({
				url:url,	
				type: "GET"
		    }).done (function(responce) {
		    	watchlistResponce.removeClass('add_friend');
		    	watchlistResponce.addClass('remove_friend');
		    }).fail (function(err) {
		    	console.error(err);
		    });
		}
        e.preventDefault();
	});
});