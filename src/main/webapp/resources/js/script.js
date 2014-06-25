jQuery.fn.exists = function () {
    return jQuery(this).length;
};

var Page = {
    tabs: function (a) {
        jQuery(".tab-content").hide().css('opacity', '0');
        jQuery(".tab-item").removeClass("active");
        jQuery(a).addClass("active");

        var id = jQuery(a).find('a').attr('href');
        jQuery(id).show().css({ "height": "100%"}).animate({
            'opacity': '1'
        }, 500);

        return false;
    },
    searchInput: function () {
        jQuery('.search_icon').click(function (e) {
            e.preventDefault();
            jQuery('#search_inp').focus();
            if (jQuery('#search_inp').val()) {
                jQuery('.search_inp').addClass('open_search');
                jQuery('.search_icon').addClass('open_search');
                jQuery('body').addClass('open_search');
                console.log('click');
                jQuery('#search-form').submit();

            }
            else {
                console.log('else');
                jQuery('.search_icon').toggleClass('open_search');
                jQuery('.search_inp').toggleClass('open_search');
                jQuery('body').toggleClass('open_search');
                jQuery('#search_inp').focus();
            }
        });

    },
    closeSearch: function (a) {
        jQuery('body.open_search').click(function (e) {
            if (!jQuery(e.target).parents().hasClass('search_wrap')) {
                jQuery('.search_inp').removeClass('open_search');
                jQuery('.search_icon').removeClass('open_search');
                jQuery('body').removeClass('open_search');
            }
            return false;
        });
    },
    openLoginForm: function (a) {
        jQuery(a).addClass('active').addClass('open');
    },
    closeForm: function (a) {
        jQuery(a).removeClass('open').removeClass('active');
    },
    columns: function () {
        var contentHeight = jQuery('.leftcontent').height();
        var sidebarHeight = jQuery('.sidebar').height();
        jQuery('.sidebar').height(contentHeight);
        var mov_item_amount =  jQuery('.sidebar .movie-item').length;
        console.log(mov_item_amount);
        var tot_items_height = mov_item_amount * 185;

        if(tot_items_height > contentHeight){
            var dif = (tot_items_height - contentHeight)/185;
            console.log('dif = '+dif);
            for (var i=0;dif>=i;i++ ){
                jQuery('.sidebar .movie-item').eq(i).remove();
                console.log(i);
            }
        }

    },
    rating: function(){
        jQuery(".raiting-box .star").click(function(){
            var val = parseInt(jQuery(this).html());
            console.log(val);
            jQuery(".raiting-box .star").removeClass("check");
            jQuery(".raiting-box .star").removeClass("active");
            jQuery(".raiting-box .star").removeClass("active_checked_star");
            jQuery(this).addClass("active");
            jQuery(this).addClass("check");
            var inp_id = jQuery(this).parents('.rate').find('input').attr('id');
            console.log(inp_id);
            jQuery('#' + inp_id).val(val);
            var $lis = jQuery(this).siblings("span").andSelf();
            var id   = jQuery(this).index();

            $lis.removeClass("active_checked_star");
            $lis.slice(0, id+1 ).addClass("active_checked_star");
            jQuery('.rate_popup_wrap').hide();
        });
        jQuery(".raiting-box .star").mouseenter(function(){

            var $lis = jQuery(this).siblings(".star").andSelf();
            var id   = jQuery(this).index();

            $lis.removeClass("active_star");
            $lis.slice(0, id+1 ).addClass("active_star");
        }).mouseout(function(){
            jQuery('.user_rate span').removeClass("active_star");
        });
    }

};


jQuery(document).ready(function () {
    jQuery('#newMovies').show().animate({'opacity': '1'}, 500);
    jQuery(".tab-item").click(function (e) {
        e.preventDefault();
        Page.tabs(this);
    });

    jQuery('.signin').click(function () {
        Page.openLoginForm('.signin-modal');
    });
    jQuery('.signup').click(function () {
        Page.openLoginForm('.signup-modal');
    });
    jQuery(this).keydown(function (eventObject) {
        if (eventObject.which == 27) {
            Page.closeForm('.morph-button');
        }
    });
    jQuery('.icon-close').click(function () {
        Page.closeForm('.morph-button');
    });
    jQuery('.form_content').click(function (e) {
        if (!jQuery(e.target).parents().hasClass('morph-content')) {
            Page.closeForm('.morph-button');
        }
    });

    Page.searchInput();
    Page.closeSearch();
    Page.columns();

    jQuery('.rate').click(function(e){

        jQuery(this).find('.rate_popup_wrap').toggleClass('open');
        jQuery(this).parents('.movie-item').toggleClass('open');
        Page.rating();
        e.preventDefault();
    });



});