<?php 

	require_once('checkLogIn.php');
	require_once('config.php');

	$title = 'Successful Course Submission' . TITLEADDON;



	$content = '
	<div class="container roundCorners">
		<div class="jumbotron roundCorners medPadding">
			<h1 class="noPadding noMargins bold">Successful Course Submission.</h1>
			<h3>Thank you for your  Course Submission</h3> 
	    	<p class="orangeText">You will be directed momemtarily to the Home page.</p>
	    </div>
	</div>
	';

	require_once('master.php');

	//sleep(5);

	$url = "index.php";
	header('Refresh: 5; URL=index.php');
	//header('Refresh: 5; location: index.php');
	//header("location: index.php");
?>