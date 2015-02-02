<?php

// Anthony Thomasson assisted substantially with the creation of this class

require_once('config.php'); 

/**
* Stores user information as an object
*/

class User
{
  	private $userId;
	private $email;
	private $password;
	private $fName;
	private $lName;
	private $facaulty;
	private $discipline;
	private $phone;
	private $director;
	private $title;

	/*
	* loads the user using the site (logged it). Used for access specific pages based off of this info.
	* returns False if there is no logged in user
	*/
	public function getCurrentUser($email, $password)
	{
		// if user was found load user data
    	if(isset($email) && isset($password))
	    {
	      $connection = mysqli_connect(DBHOST, DBUSER, DBPASS, 'curriculum') or die('Failed to connect to database');

	      // querry for user email
	      $result = mysqli_query($connection, "SELECT * FROM Users WHERE username = '$email'");
	      //  we know there is only return 1 row to return so a loop is not used
	      $rowOne = mysqli_fetch_assoc($result);

	      // validate username and password in session/cookie
	      if($email == $rowOne["username"] && $password == $rowOne["password"])
	      {
	        // set all user data
          $this->userId = $rowOne["userID"];
	        $this->email = $rowOne["username"];
	        $this->password = $rowOne["password"];
	        $this->fName = $rowOne["firstname"];
	        $this->lName = $rowOne["lastname"];
	        $this->faculty = $rowOne["faculty"];
	        $this->discipline = $rowOne["discipline"];
	        $this->phone = $rowOne["phone"];
	        $this->director = $rowOne["director"];
	        $this->title = $rowOne["title"];

	        mysqli_close($connection);

	        // user was found
	        return TRUE;
	      }
	      else
	        // password in session is wrong
	        return FALSE;
	    }

	    // user was not found
	    return FALSE;
	}



  public function setUserId($userId) 
  { 
    $this->userId = $userId; 
  }

  public function getUserId() 
  { 
    return $this->userId; 
  }

	public function setUserEmail($email) 
	{ 
		$this->email = $email; 
	}

  public function getUserEmail() 
  { 
  	return $this->email; 
  }

  public function setPassword($password) 
	{ 
		$this->password = $password; 
	}
	
	public function getPassword() 
	{ 
		return $this->password; 
	}

	public function setFirstName($firstname) 
	{ 	
		$this->fName = $firstname; 
	}
	
	public function getFirstName() 
	{ 
		return $this->fName; 
	}

	public function setLastName($lastname) 
	{ 
		$this->lName = $lastname; 
	}
	
	public function getLastName() 
	{ 
		return $this->lName; 
	}

	public function setFaculty($faculty) 
	{ 	
		$this->faculty = $faculty; 
	}
	
	public function getFaculty() 
	{ 
		return $this->faculty; 
	}

	public function setDiscipline($discipline) 
	{ 
		$this->discipline = $discipline; 
	}
	
	public function getDiscipline() 
	{ 
		return $this->discipline; 
	}

	public function setPhone($phone) 
	{ 	
		$this->phone = $phone; 
	}
	
	public function getPhone() 
	{ 
		return $this->phone; 
	}

	public function setDirector($director) 
	{ 	
		$this->director = $director; 
	}

	public function getDirector() 
	{ 	
		return $this->director; 
	}

	public function setTitle($title) 
	{ 
		$this->title = $title; 
	}

	public function getTitle() 
	{ 
		return $this->title;
	}


}
	
?>