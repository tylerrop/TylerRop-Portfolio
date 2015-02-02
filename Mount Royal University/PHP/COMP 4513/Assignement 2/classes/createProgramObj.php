<?php

// Anthony Thomasson assisted substantially with the creation of this class

require_once("requestObj.php");


class CreateProgramRequest extends Request
{

    // Specific request data
    private $programName;
    private $term;
    private $rationale;
    private $crossImpact;
    private $studentImpact;
    private $comments;
    private $calendar;
    private $libraryImpact;
    private $itsImpact;


	public function createNewRequestFromPost($user, $state)
	{
		// get user info
		$this->userId = $user->getUserId();

		// get general request data
		$this->creationDate = date('Y-m-d H:i:s');
		$this->state = $state;
		$this->currentApprover = 0;
		$this->type = "create-program";

		// specific request data
		if($_SERVER["REQUEST_METHOD"] == "POST")
		{	

			$connection = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME);

			$this->programName = mysqli_real_escape_string($connection, $_POST['programName']);
			$this->term = mysqli_real_escape_string($connection, $_POST['fct']);
			$this->rationale = mysqli_real_escape_string($connection, $_POST['rationaleText']);
			$this->crossImpact = mysqli_real_escape_string($connection, $_POST['crossText']);
			$this->studentImpact = mysqli_real_escape_string($connection, $_POST['studentText']);
			$this->comments = mysqli_real_escape_string($connection, $_POST['generalText']);
			$this->calendar = mysqli_real_escape_string($connection, $_POST['calendarText']);
			$this->libraryImpact = mysqli_real_escape_string($connection, $_POST['libraryText']);
			$this->itsImpact = mysqli_real_escape_string($connection, $_POST['itsText']);
		
		}
	}



	public function loadRequestFromId($id)
	{
		$con = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME);

	    // check connection
	    if (mysqli_connect_errno()) 
	    {
	        printf("Connect failed: %s\n", mysqli_connect_error());
	        exit();
	    }

		$sql = "SELECT * FROM `users`, `request`, `createProgramRequest` 
							WHERE request.id = '$id' 
								AND request.id = createProgramRequest.id";

		$result = mysqli_query($con, $sql);


      	$data = $result->fetch_assoc();


      	// get user info
		$this->userId = $data['userId'];
		$this->firstname = $data['firstname'];
		$this->lastname = $data['lastname'];

		// get general request data
		$this->requestId = $data['id'];
		$this->creationDate = $data['creationDate'];
		$this->state = $data['state'];
		$this->currentApprover = $data['currentApprover'];
		$this->type = $data['type'];

		// specific request data
		$this->programName = $data['programName'];
		$this->term = $data['term'];
		$this->rationale = $data['rationale'];
		$this->crossImpact = $data['crossImpact'];
		$this->studentImpact = $data['studentImpact'];
		$this->comments = $data['comments'];
		$this->calendar = $data['calendar'];
		$this->libraryImpact = $data['libraryImpact'];
		$this->itsImpact = $data['itsImpact'];

		mysqli_close($con);
	}

	// get program name, look for result in database, returns true if the program name is nound in db
	private function validateProgName()
	{
		$con = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME);
		
		// check connection
    	if (mysqli_connect_errno()) 
    	{
        	printf("Connect failed: %s\n", mysqli_connect_error());
        	exit();
    	}


		// check to see if name is already in the database, sanitize the input
		$programName = mysqli_real_escape_string($con, $this->programName);

		$sql = "SELECT createProgramRequest.programName FROM `createProgramRequest` 
		     		WHERE createProgramRequest.programName = '$programName'";

		$result = mysqli_query($con, $sql);
		
		$row = $result->fetch_assoc();
		 
		if(count($row) > 0 || $this->programName == "")
		{
		   return FALSE;
		}
		else
		{
		   return TRUE;
		}
	}


	public function createTableEntries()
	{
		if ($this->validateProgName()) 
		{
			
			// create request table entry
			$this->createRequestEntry();

			// create the createProgramRequest table entry
			$this->createSpecificRequestEntry();

			// create approval table entries
			$this->createApprovalEntries();

			return TRUE;
		}
		else
		{
			return FALSE;
		}
	}



	private function createSpecificRequestEntry()
	{
		$con = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME);
		
		// check connection
    	if (mysqli_connect_errno()) 
    	{
        	printf("Connect failed: %s\n", mysqli_connect_error());
        	exit();
    	}


		$tableName = "createProgramRequest";

		$requestId = $this->requestId;
    	$programName = $this->programName;
    	$term = $this->term;
    	$rationale = $this->rationale;
    	$crossImpact = $this->crossImpact;
    	$studentImpact = $this->studentImpact;
    	$comments = $this->comments;
    	$calendar = $this->calendar;
    	$libraryImpact = $this->libraryImpact;
    	$itsImpact = $this->itsImpact;

    	$insertSql = "INSERT INTO $tableName (id, programName, term, rationale, crossImpact, studentImpact, comments, calendar, libraryImpact, itsImpact) 
	     			  		VALUES ('$requestId', '$programName', '$term', '$rationale', '$crossImpact', '$studentImpact', '$comments', '$calendar', 
	     							'$libraryImpact', '$itsImpact')";

		mysqli_query($con, $insertSql);
		mysqli_close($con);
	}



	public function printRequestContent($user)
	{
		$approval = $this->verifyApprovalAccess($user);

		$requestContent = $this->printRequestInfo($approval);

		return $requestContent;
	}



	private function printRequestInfo($approval)
	{

		$requestContent =
	                    ' <h3 class="noPadding noTopMargin"><span class="bold">Program:</span> '.$this->getProgramName().'</h3> 
						   <p></p>

						   <h3 class="noPadding noTopMargin"><span class="bold">First Course Term:</span> '.$this->getTerm().'</h3> 
						   <p></p>

						   <h3 class="noPadding noTopMargin bold">Rationale</h3> 
						   <p>'.$this->getRationale().'</p>

						   <h3 class="noPadding noTopMargin bold">Cross Impact: </h3> 
						   <p>'.$this->getCrossImpact().'</p>

						   <h3 class="noPadding noTopMargin bold">Student Impact: </h3> 
						   <p>'.$this->getStudentImpact().'</p>

						   <h3 class="noPadding noTopMargin bold">General Comments: </h3> 
						   <p>'.$this->getComments().'</p>

						   <h3 class="noPadding noTopMargin bold">Proposed Calendar: </h3> 
						   <p>'.$this->getCalendar().'</p>

						   <h3 class="noPadding noTopMargin bold">Library Impact: </h3> 
						   <p>'.$this->getCalendar().'</p>

						   <h3 class="noPadding noTopMargin bold">ITS Impact: </h3> 
						   <p>'.$this->getItsImpact().'</p>
						';

						if ($approval) 
						{
							$requestContent .= '
							<a href="singleProgram.php?Submission=Approved&requestId='.$this->getRequestId().'&type='.$this->getType().'" class="btn btn-success btn-lg btn-primary btn-block">Approve &nbsp;<span class="glyphicon glyphicon-ok"></span></a>
				            <a href="singleProgram.php?Submission=Denied&requestId='.$this->getRequestId().'&type='.$this->getType().'" class="btn btn-danger btn-lg btn-primary btn-block">Reject &nbsp;<span class="glyphicon glyphicon-remove"></span></a>
					    	<a href="viewPrograms.php" class="btn btn-lg btn-primary btn-block">View All Program Requests <span class="glyphicon glyphicon-list-alt"></span></a>';
					    }

		return $requestContent;
	}

	

	public function setProgramName($value) 
	{ 
		$this->programName = $value; 
	}

	public function getProgramName() 
	{ 	
		return $this->programName; 
	}

	public function setTerm($value) 
	{ 
		$this->term = $value; 
	}

	public function getTerm() 
	{ 
		return $this->term; 
	}

	public function setRationale($value) 
	{ 
		$this->rationale = $value; 
	}

	public function getRationale() 
	{ 
		return $this->rationale; 
	}

	public function setCrossImpact($value) 
	{ 
		$this->crossImpact = $value; 
	}

	public function getCrossImpact() 
	{ 
		return $this->crossImpact; 
	}

	public function setStudentImpact($value) 
	{ 
		$this->studentImpact = $value; 
	}
	
	public function getStudentImpact() 
	{ 
		return $this->studentImpact; 
	}

	public function setComments($value) 
	{ 
		$this->comments = $value; 
	}
	
	public function getComments() 
	{ 
		return $this->comments; 
	}

	public function setCalendar($value) 
	{ 	
		$this->calendar = $value; 
	}

	public function getCalendar() 
	{ 
		return $this->calendar; 
	}

	public function setLibraryImpact($value) 
	{ 
		$this->libraryImpact = $value; 
	}

	public function getLibraryImpact() 
	{ 
		return $this->libraryImpact; 
	}

	public function setItsImpact($value) 
	{ 
		$this->itsImpact = $value;
	}

	public function getItsImpact() 
	{ 
		return $this->itsImpact; 
	}



}


?>