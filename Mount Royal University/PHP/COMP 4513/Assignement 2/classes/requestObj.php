<?php

// Anthony Thomasson assisted substantially with the creation of this class

class Request
{
	// Request data
    protected $requestId;
    protected $creationDate;
    protected $state;
    protected $currentApprover;
    protected $type;

    // UserId
    protected $userId;
    protected $firstname;
    protected $lastname;



    // create a request table 
    protected function createRequestEntry() 
    {
        $con = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME);

        // check connection
        if (mysqli_connect_errno()) 
        {
            printf("Connect failed: %s\n", mysqli_connect_error());
            exit();
        }

    	$tableName = "request";
    	$userId = $this->userId;
    	$creationDate = $this->creationDate;
    	$state = $this->state;
        $currentApprover = $this->currentApprover;
    	$type = $this->type;

    	$insertSql = "INSERT INTO $tableName (userId, creationDate, state, currentApprover, type)"
	     			. "VALUES ('$userId', '$creationDate', '$state', '$currentApprover', '$type')";

		mysqli_query($con, $insertSql);


		// set requestId
		$idSql = "SELECT id FROM $tableName ORDER BY id DESC LIMIT 1";
		$result = mysqli_query($con, $idSql);
		$data = $result->fetch_assoc();

		$this->requestId = $data['id'];

        mysqli_close($con);
    }

   


    // ----------------------------------------------------------------

    protected function createApprovalEntries() 
    {
        $con = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME);

        // check connection
        if (mysqli_connect_errno()) 
        {
            printf("Connect failed: %s\n", mysqli_connect_error());
            exit();
        }

        // table names
        $groupTable = "group";
        $goupMemeberTable = "groupMember";

        // find all users in the approving group
        $requestId = $this->requestId;
        $groupName = unserialize(MAJOR_CHANGE_STACK)[$this->getCurrentApprover()];
        $groupId;

        // get the ID of the group from the group name
        $sql = "SELECT `groupId` 
                    FROM `$groupTable` 
                        WHERE groupName = '$groupName'";

        $result = mysqli_query($con, $sql);
        $data = $result->fetch_assoc();
        $groupId = $data['groupId'];

        // query to get users of the selected group
        $sql = "SELECT groupMember.userId 
                    FROM `groupMember`, `request`, `group` 
                        WHERE group.groupId = '$groupId' 
                            AND request.id = '$requestId' 
                            AND groupMember.groupId = group.groupId 
                            AND groupMember.userId != request.userId";  //   NEED CHANGE

        $result = mysqli_query($con, $sql);

        while($row = $result->fetch_assoc())
        {
            // create entries for the users in the approval table linked with the requestId
            $userId = $row['userId'];
            $insertSql = "INSERT INTO `approval`(`requestId`,`userId`, `approved`) 
                                VALUES ($requestId, $userId, 'Unset')";
            mysqli_query($con, $insertSql);
        }

        // create email object that sends emails users that need to make and approvals NON FUNCTIONAL
        //$subject = "Request Waiting for Approval";
        //$body = "There is a new request for a program waiting for your approval";
        //$email = new Email(APPROVAL_NOTIFIER_EMAIL, $subject, $body);
        //$email-> sendEmailToApprovers($groupId);
        mysqli_close($con);

    }



    public function submitApprovalSettings($user, $submission)
    {
        $requestId = $this->getRequestId();
        // check if user has access
        $access = $this->verifyApprovalAccess($user);

        if($access)
        {
            $this->updateApprovalTable($user->getUserId(), $submission);

            $this->checkApprovalStatus();
        }
    }



    private function updateApprovalTable($userId, $submission)
    {
        // echo $submission;

        $requestId = $this->getRequestId();
        // update approval table
        $con = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME) or die('Failed to connect to database');

        $sql  = "UPDATE `approval` 
                            SET approved = '$submission' 
                        WHERE userId = '$userId' AND requestId = '$requestId'";
        mysqli_query($con, $sql);
        mysqli_close($con);   
    }




    private function checkApprovalStatus()
    {
        $requestId = $this->getRequestId();

        // update approval table
        $con = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME) or die('Failed to connect to database');

        $sql  = "SELECT
                    SUM(approved = 'Approved') as approve,
                    SUM(approved = 'Denied') as denied,
                    SUM(approved = 'Unset') as unset
                        FROM `approval`
                            WHERE approved in ('Approved', 'Denied', 'Unset')
                                AND requestId = '$requestId'";

        $result = mysqli_query($con, $sql);
        $data = $result->fetch_assoc();

        if($data['unset'] == 0)
        {
            // echo "ALL USERS CHOICE MADE"."<br />";

            if($data['approve'] >= $data['denied'])
            {
                // echo "approved"."<br />";

                $sql  = "SELECT currentApprover FROM request WHERE id = '$requestId'";
                $result = mysqli_query($con, $sql);
                $data = $result->fetch_assoc();
                $currentApprover = $data['currentApprover'];

                // echo"Count of stack: ". count(unserialize(MAJOR_CHANGE_STACK)). "<br />";
                // echo"Current Approver: ". $currentApprover. "<br />";

                if(count(unserialize(MAJOR_CHANGE_STACK)) <= ($currentApprover +1))
                {
                    // echo"Approving Done: <br/>";
                    // echo"Current Approver: ", $currentApprover. "<br />";
                    // set state to complete
                    $sql = "UPDATE request SET state = 'Complete' WHERE id = '$requestId'";
                    mysqli_query($con, $sql);
                    
                    // delete the old group of approvers
                    $sql = "DELETE FROM approval WHERE requestId = '$requestId'";
                    mysqli_query($con, $sql);
                }
                else
                {
                    // echo"Set new approver: <br/>";

                    // set new current approver
                    $currentApprover++;
                    $sql = "UPDATE request SET currentApprover = '$currentApprover' WHERE request.id = '$requestId'";
                    mysqli_query($con, $sql);
                    $this->setCurrentApprover($currentApprover);

                    // delete the old group of approvers
                    $sql = "DELETE FROM approval WHERE requestId = '$requestId'";
                    mysqli_query($con, $sql);

                    // create new approval entries
                    $this->createApprovalEntries();
                }

            }

            else
            {
                // failed
                $sql = "UPDATE request SET state = 'Failed' WHERE id = '$requestId'";
                mysqli_query($con, $sql);

                // delete the old group of approvers
                $sql = "DELETE FROM approval WHERE requestId = '$requestId'";
                mysqli_query($con, $sql);
            }
            
            mysqli_close($con);

        }

    }



    public function verifyApprovalAccess($user)
    {
        // look to see if the user needs to approve the request
        $userId = $user->getUserId();

        $requestId = $this->getRequestId();
        
        $con = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME) or die('Failed to connect to database');
        
        $sql = "SELECT * FROM `users`, `approval`, `request`
                            WHERE users.userId = '$userId' 
                                AND approval.userId = users.userId
                                AND approval.requestId = '$requestId'
                                AND approval.requestId = request.id
                                AND request.userId != '$userId'
                                AND approval.approved = 'Unset'";

        $result = mysqli_query($con, $sql);
        
        $data = $result->fetch_assoc();
        
        mysqli_close($con);

        if(count($data) > 0)
        {
            return TRUE;
        }
        else
        {   
            return FALSE;
        }

    }



    //-----------------------------------------------------------------

    public function setRequestId($value) 
    { 
        $this->requestId = $value; 
    }

	public function getRequestId() 
    { 
        return $this->requestId; 
    }

	public function setCreationDate($value) 
    { 
        $this->creationDate = $value; 
    }

	public function getCreationDate() 
    { 
        return $this->creationDate; 
    }

	public function setState($value) 
    {   
        $this->state = $value; 
    }

	public function getState() 
    { 
        return $this->state; 
    }

    public function setCurrentApprover($value) 
    { 
        $this->currentApprover = $value; 
    }

    public function getCurrentApprover() 
    { 
        return $this->currentApprover; 
    }

	public function setType($value) 
    { 
        $this->type = $value; 
    }

	public function getType() 
    { 
        return $this->type; 
    }

	public function setUserId($value) 
    { 
        $this->userId = $value; 
    }
	
    public function getUserId() 
    { 
        return $this->userId; 
    }

    public function setFirstname($value) 
    { 
        $this->firstname = $value; 
    }

    public function getFirstname() 
    { 
        return $this->firstname; 
    }

    public function setLastname($value) 
    { 
        $this->lastname = $value; 
    }

    public function getLastname() 
    { 
        return $this->lastname; 
    }


}


?>