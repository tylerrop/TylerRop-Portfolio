<?php 

	require_once('checkLogIn.php');
	require_once('config.php');
	require_once('/classes/createProgramObj.php');

	$title = 'Single Program' . TITLEADDON; 

	$content = ''; 

	
	 // loads request
 	if(isset($_GET['programRequestID']) && isset($_GET['type']))
 	{
  		if($_GET['type'] = "create-program")
 		{
		   // loads request data
		   $requestId = $_GET['programRequestID'];
		   $createProgramRequest = new createProgramRequest();
		   $createProgramRequest->loadRequestFromId($requestId);
		   $content .= '
						<div class="container roundCorners">
							<div class="jumbotron roundCorners medPadding">	
							'.$createProgramRequest->printRequestContent($user).'
						    </div>
						</div>
					   ';
  		}
 	}



 	// handling the approval or rejection of a program request
 	if(isset($_GET['Submission']))
 	{
 		if($_GET['type'] == 'create-program')
 		{
 			$requestId = $_GET['requestId'];
 			$submission = $_GET['Submission'];
 			$userId = $user->getUserId();

 			$createProgramRequest = new createProgramRequest();

		    $createProgramRequest->loadRequestFromId($requestId);

		    $createProgramRequest->submitApprovalSettings($user, $submission);

		    // redirect for approval/rejection
		    header("location: judgementProgramSuccess.php");
 		}

 	}

	require_once('master.php');

?>