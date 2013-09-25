

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-GB">
<head>
<title>Rosetree Developments | Home</title>

<link rel="icon" type="image/png" href="img/favicon.png">

<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=utf-8" />
<meta name="description" content="The Perfect 3 Column Liquid Layout: No CSS hacks. SEO friendly. iPhone compatible." />
<meta name="keywords" content="The Perfect 3 Column Liquid Layout: No CSS hacks. SEO friendly. iPhone compatible." />
<meta name="robots" content="index, follow" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link href='http://fonts.googleapis.com/css?family=Lato:300,400' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/screen.css" media="screen" />
<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript">
var totalSlides = 0;
var currentSlide = 1;
var contentSlides = "";

$(document).ready(function(){
				  $("#slideshow-previous").click(showPreviousSlide);
				  $("#slideshow-next").click(showNextSlide);
				  
				  var totalWidth = 0;
				  contentSlides = $(".slideshow-content");
				  contentSlides.each(function(i){
									 totalWidth += this.clientWidth;
									 totalSlides++;
									 });
				  $("#slideshow-holder").width(totalWidth);
				  $("#slideshow-scroller").attr({scrollLeft: 0});
				  updateButtons();
				  });

function showPreviousSlide()
{
	currentSlide--;
	updateContentHolder();
	updateButtons();
}

function showNextSlide()
{
	currentSlide++;
	updateContentHolder();
	updateButtons();
}

function updateContentHolder()
{
	var scrollAmount = 0;
	contentSlides.each(function(i){
					   if(currentSlide - 1 > i) {
					   scrollAmount += this.clientWidth;
					   }
					   });
	$("#slideshow-scroller").animate({scrollLeft: scrollAmount}, 1000);
}

function updateButtons()
{
	if(currentSlide < totalSlides) {
		$("#slideshow-next").show();
	} else {
		$("#slideshow-next").hide();
	}
	if(currentSlide > 1) {
		$("#slideshow-previous").show();
	} else {
		$("#slideshow-previous").hide();
	}
}
</script>



<style>


.homeTextBox
{
position:absolute;
	z-index:999;
width:40%;
height:auto;
right:0;
color:#FFF;
	text-align:right;
	margin-right:11%;
	
	font-family:'Lato',Arial, Helvetica, sans-serif;
	line-height:180%;
	
padding:1.5%;
	padding-top:0;
	margin-top:7%;
	
}
.homeTextBox h2
{
color:#FFF;
	font-size:500%;
	text-align:right;
	font-weight:300;
	margin-bottom:3%;
	
}




</style>    


</head>
<body>

<div id="header">	
<a href="index.php"><img src="img/Logo.png" id="logo" /></a>

<ul>
<li><a href="contact.php">CONTACT US</a></li>
<li><a href="about.php">ABOUT US</a></li>
<li><a href="investors.php">INVESTORS</a></li>
<li><a href="communities.php">COMMUNITES</a></li>		
</ul>	
</div>
<div class="colmask fullpage">
<div class="col1" id="communities">
<!-- Column 1 start -->


	<div id="slideshow-area">
		<div id="slideshow-scroller">
			<div id="slideshow-holder">
				<div class="slideshow-content">
					<h1>Blackmud Creek</h1>
					<p id="loc">EDMONTON, ALBERTA, CANADA</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut lacinia lacus ac metus feugiat dignissim. Integer eu massa non velit laoreet faucibus at et ipsum. Cras laoreet porta lorem quis facilisis. Nulla magna sapien, tincidunt vel vestibulum at, fermentum a lacus. Etiam nec erat ac est accumsan accumsan eu sit amet tortor. Sed quis ligula at ipsum sodales lobortis. Vestibulum ut commodo nisl. Nullam vehicula, ligula ut consequat euismod, tellus lectus tincidunt ante, sed dictum elit velit ut purus.</p>
					<img src="img/Logo-BlackMud.png" />
				</div>
				<div class="slideshow-content">
<h1>Canterbury</h1>
<p id="loc">EDMONTON, ALBERTA, CANADA</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut lacinia lacus ac metus feugiat dignissim. Integer eu massa non velit laoreet faucibus at et ipsum. Cras laoreet porta lorem quis facilisis. Nulla magna sapien, tincidunt vel vestibulum at, fermentum a lacus. Etiam nec erat ac est accumsan accumsan eu sit amet tortor. Sed quis ligula at ipsum sodales lobortis. Vestibulum ut commodo nisl. Nullam vehicula, ligula ut consequat euismod, tellus lectus tincidunt ante, sed dictum elit velit ut purus.</p>

					<img src="img/Logo-Canterbury.png" />
				</div>
				<div class="slideshow-content">
<h1>Jumping Pound Ridge</h1>
<p id="loc">COCHRANE, ALBERTA, CANADA</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut lacinia lacus ac metus feugiat dignissim. Integer eu massa non velit laoreet faucibus at et ipsum. Cras laoreet porta lorem quis facilisis. Nulla magna sapien, tincidunt vel vestibulum at, fermentum a lacus. Etiam nec erat ac est accumsan accumsan eu sit amet tortor. Sed quis ligula at ipsum sodales lobortis. Vestibulum ut commodo nisl. Nullam vehicula, ligula ut consequat euismod, tellus lectus tincidunt ante, sed dictum elit velit ut purus.</p>
					<img src="img/Logo-JPR.png" />
				</div>
			</div>
		</div>
	<div id="slideshow-previous"></div>
	<div id="slideshow-next"></div>
	</div>
</div>



<!-- Column 1 end -->
<!--img src="img/BG-Communities.jpg" style="position:relative;z-index:998;height:100%;width:100%;"/-->

</div>
</div>
<div id="footer">


<ul id="navlist">

<li><a href="http://goo.gl/maps/MDZt1">#235 366 ASPEN GLEN LANDING SW</a></li>
<li>/</li>
<li>1 (403) 453 5530</li>
<li>/</li>
<li><a href="http://goo.gl/maps/MDZt1">CALGARY ALBERTA CANADA T3H 0N5</a></li>
</ul>

<p>&copy; ROSETREE DEVELOPMENTS</p>

</div>

</body>
</html>
