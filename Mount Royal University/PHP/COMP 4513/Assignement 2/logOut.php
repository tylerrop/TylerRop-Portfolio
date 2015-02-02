<?php 
	$title = 'Log Out' . TITLEADDON; 

	$content = ''; 

	// Remove all the session debris to log out the user. 
	// Send them back to the log in page.
	session_unset();
    session_destroy();
    session_write_close();
    setcookie(session_name(),'',0,'/');
    session_regenerate_id(true);

    header("Location: logIn.php");
	

?>