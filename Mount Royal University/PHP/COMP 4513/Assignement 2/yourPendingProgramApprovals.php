<?php 

	require_once('checkLogIn.php');
	require_once('config.php');

	$title = 'Pending Your Approval' . TITLEADDON; 


	function printPendingProgramApprovals()
	{
		$tableRows = "";
	    // table that we'll read from

		$email = $_SESSION["email"];
		$password = $_SESSION['password'];

		$user = new user();
		$user->getCurrentUser( $email, $password );
	    
	    $currUser = $user->getUserId(); 
	  

	    $connection = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME);

	    // check connection
	    if (mysqli_connect_errno()) 
	    {
	        printf("Connect failed: %s\n", mysqli_connect_error());
	        exit();
	    }

        $sqlStatement = "SELECT users.firstname, users.lastname, users.username, request.id, request.state, request.creationDate, request.type, createProgramRequest.programName " 
                      ."FROM `request`, `createProgramRequest`, `approval`, `users` "
                        ."WHERE approval.userId = '$currUser' "
                          ."AND approval.requestId = request.id "
                          ."AND request.id = createProgramRequest.id "
                          ."AND request.userId = users.userId "
                          ."AND approval.userId != request.userId "
                          ."AND approval.approved = 'Unset' ORDER BY request.id ASC";

	    $result = mysqli_query($connection, $sqlStatement);

	    //reading through table rows to create opton values for the selector
	    while ($row = mysqli_fetch_array($result)) 
	    {

	    	$tableRows .= '<tr>
				            <td><a href="singleProgram.php?programRequestID='.$row["id"].'&type='.$row["type"].'">'.$row["id"].'</a></td>
				            <td class="requestTitle"><a href="singleProgram.php?programRequestID='.$row["id"].'&type='.$row["type"].'">'.$row["programName"].'</a></td>
				            <td class="requestName">'.$row["firstname"].' '.$row["lastname"].'</td>
				            <td><a href="mailto:'.$row["username"].'?Subject='.$row["programName"].'">'.$row["username"].'</a></td>
				            <td class="requestCreation">'.$row["creationDate"].'</td>
				            <td class="requestState">'.$row["state"].'</td>
				          </tr>
				          ';
	    }

	    // clode db connection
	    mysqli_close($connection);

	    return $tableRows;

	}


	$content = '
	<div class="container roundCorners">
		<div class="jumbotron roundCorners medPadding">
			<h1 class="noPadding noMargins bold">Pending Your Approval</h1>  
	    	<p><small>Click the ID or Title to view the request individually.</small></p>

	    		<div class="panel panel-default noMargins">
			    	<small>
			    	<!-- Table -->
				    <table class="table noMargins">
				        <thead>
				     	    <tr>
				        		<th>ID</th>
				           		<th class="requestTitle">Title</th>
				            	<th class="requestName">Submitted By</th>
				            	<th>Email</th>
				            	<th class="requestCreation">Creation Date</th>
				            	<th class="requestState">State</th>
				            </tr>
				        </thead>
				        
				        <tbody>
				        '.printPendingProgramApprovals().'
				        </tbody>
				      </table>    		
				      </small>		
   				</div>
   				<!-- end of panel-->
	    </div>
	</div>
	'; 

	require_once('master.php');

?>