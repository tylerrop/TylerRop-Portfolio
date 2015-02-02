<?php 

	require_once('checkLogIn.php');
	require_once('config.php');

	$title = 'Successful Program Submission' . TITLEADDON;



	$content = '
	<div class="container roundCorners">
		<div class="jumbotron roundCorners medPadding">
			<h1 class="noPadding noMargins bold">Successful Program Submission.</h1>
			<h3>Thank you for your Program Submission</h3> 
	    	<p class="orangeText">You will be directed momemtarily to the Home page.</p>
	    </div>
	</div>
	';

	require_once('master.php');

	$url = "index.php";
	//header('Refresh: 5; URL=index.php');
	// wait 5 seconds and redirect the user back to the home page b/c their request is completed
	echo "<meta http-equiv=\"refresh\" content=\"5;url=$url\"/>";

?>