<?php

    // header code
    require_once 'header.php';
    
    // IF LOGIN == TRUE...
    // top nav code
    if(basename($_SERVER['PHP_SELF']) != "logIn.php")
    {
    	require_once 'topNav.php';
        require_once 'topMenu.php';
	}

	// content for each page
	echo $content;

    require_once 'footer.php';

?>