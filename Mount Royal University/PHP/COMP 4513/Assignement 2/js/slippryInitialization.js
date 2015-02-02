$(document).ready(function()
{
	// initilize setting for jQuery Slippry slider in the form
	jQuery('#createRequestForm > div').slippry({
	  // general elements & wrapper
	  slippryWrapper: '<div class="sy-box news-slider" />', // wrapper to wrap everything, including pager
	  elements: 'article', // elments cointaining slide content

		// options
		adaptiveHeight: true, // height of the sliders adapts to current 
		captions: false,
		loop: false,
		continuous: false,
		responsive: true,
		useCSS: true,	
		pause: 0,
		auto: false,
		preload: 'visible',
		pagerClass: 'news-pager',
		transition: 'horizontal', // fade, horizontal, kenburns, false
		speed: 1200,
		slideMargin: 9
	});
 
});