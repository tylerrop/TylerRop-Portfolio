<?php 

	require_once('checkLogIn.php');
	require_once('config.php');
	require_once('search-data.php');

	$title = 'Search Results ASYNC' . TITLEADDON; 
	
	if (isset($_SESSION["postQuery"]))
	{
		$query = $_SESSION["postQuery"];
	}
	else if (isset($_GET['query']))
	{
		$query = $_GET['query'];
	}
	else
	{
		$query ="No defined Search terms.";
	}


	// if (isset($_POST["query"])) 
	// {
	// 	// user submitted query
	// 	$query = $_POST["query"];
	// }
	// else 


	function printSearchResults($query)
	{
		$tableRows = "";

		$connection = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME);

	    // check connection
	    if (mysqli_connect_errno()) 
	    {
	        printf("Connect failed: %s\n", mysqli_connect_error());
	        exit();
	    }

	    // always use SQL protection. sanitize the user's provided query string and then perform an SQL query of the db with it as a var for Program Request Name
	    $sanitizedQuery = mysqli_real_escape_string($connection, $query);
	    $sanitizedQuery = strip_tags($sanitizedQuery);
	    $sanitizedQuery = htmlspecialchars($sanitizedQuery);

	    $sqlStatement = "SELECT request.*, createprogramrequest.*, users.* 
	    				 FROM `request`, `createprogramrequest`, `users` 
	    				 WHERE (
	    				 	    	createprogramrequest.programName LIKE '%$sanitizedQuery%'
	    				 			OR createprogramrequest.id LIKE '%$sanitizedQuery%'
	    				 			OR CONCAT(users.firstname, ' ', users.lastname) LIKE '%$sanitizedQuery%'
	    				 			OR users.username LIKE '%$sanitizedQuery%'
	    				 			OR request.creationDate LIKE '%$sanitizedQuery%'
	    				 			OR request.state LIKE '%$sanitizedQuery%'
	    				       )
	    			
	    				 
	    				 AND request.id = createprogramrequest.id 
	    				 AND request.userId = users.userID
	    				 GROUP BY request.id  
	    				 ORDER BY request.id
	    				 ";

	    $result = mysqli_query($connection, $sqlStatement);

	    mysqli_num_rows($result); 

	    if (mysqli_num_rows($result) == 0) 
    	{
           $tableRows .= '<span class="orangeText">There were no results that matched your search. Please try searching a bit differently.</span>';
    	   $query ="No defined Search terms.";
    	}

    	// there is a search result(s)
    	else
    	{
    		$tableRows .= '<div id="results">

    					<p><small>Click the ID or Title to view the request individually.</small></p>
    					<p><small>Press a <span class="searchColour">Header</span> once to sort by category descending, again to sort in ascending.</small></p>
    					<p><small>Search again for quick results.</small></p>
    						<div class="panel panel-default noMargins">
						    	<small>
						    	<!-- Table -->
							    <table class="tableSorter table noMargins">
							        <thead>
							     	    <tr  style="background-color: #428BCA; color: #FFF;">
							        		<th>
							        			ID
							        		</th>

							           		<th id="requestTitle">
							           			Title
							           		</th>

							            	<th id="requestName">
							            		Submitted By
							            	</th>

							            	<th>
							            		Email
							            	</th>

							            	<th id="requestCreation">
							            		Creation Date
							            	</th>

							            	<th id="requestState">
							            		State
							            	</th>
							            </tr>
							        </thead>
							        
							        <tbody id="results">
    								';
    	
	    	//reading through table rows to create opton values for the table
	    	while ($row = mysqli_fetch_array($result)) 
		    {

		    	$tableRows .= '<tr>
					            <td><a href="singleProgram.php?programRequestID='.$row["id"].'&type='.$row["type"].'">'.$row["id"].'</a></td>
					            <td><a href="singleProgram.php?programRequestID='.$row["id"].'&type='.$row["type"].'">'.$row["programName"].'</a></td>
					            <td class="requestName">'.$row["firstname"].' '.$row["lastname"].'</td>
					            <td><a href="mailto:'.$row["username"].'?Subject='.$row["programName"].'">'.$row["username"].'</a></td>
					            <td class="requestCreation">'.$row["creationDate"].'</td>
					            <td class="requestState">'.$row["state"].'</td>
					          </tr>
					          ';
		    }


		    $tableRows .= '
		    				</tbody>
				        </table>    		
				    </small>		
   				</div>

   				</div>
   				<!-- end of panel-->
		    			  ';

		}

	    // clode db connection
	    mysqli_close($connection);

	    return $tableRows;

	}




	$content = '

	<div class="container roundCorners">
		<div class="jumbotron roundCorners medPadding">
			<h1 class="noPadding noMargins bold">Search Results for: <span class="orangeText">'.$query.'</span></h1>  
	    	 		
				        '.printSearchResults($query).'
				        				       
	    </div>
	</div>

	'; 

	
	require_once('master.php');

?>