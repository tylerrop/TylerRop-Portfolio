<?php

require_once('/classes/user.class.php');

session_start(); 

/*
 This is included on all pages to ensure that a user is logged in to access anything but logIn.php
*/

if ( isset($_SESSION["email"]) == TRUE && isset($_SESSION['password']) ) 
{
	// user can proceed to page...
	// load user object with ogged in user data
	$email = $_SESSION["email"];
	$password = $_SESSION['password'];

	$user = new user();
	$user->getCurrentUser( $email, $password );

	// echo $user->getUserEmail();
	// echo $user->getFaculty();

} 
else 
{	
	//user log in is not stored in a session so they are redirected to the login page
	header("location: logIn.php");
}

?>