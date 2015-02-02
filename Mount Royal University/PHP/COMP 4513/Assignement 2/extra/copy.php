<?php 

	require_once('checkLogIn.php');
	require_once('config.php');

	$title = '' . TITLEADDON; 

	$content = '
	<div class="container roundCorners">
		<div class="jumbotron roundCorners medPadding">
			<h1 class="noPadding noMargins bold">Title</h1> 
      		<h2 class="noMargins"><small>Please fill out all fields. <span class="orangeText">Note.</span></small></h2>
	    	<p>Some static text</p>
	    </div>
	</div>
	'; 

	require_once('master.php');

?>