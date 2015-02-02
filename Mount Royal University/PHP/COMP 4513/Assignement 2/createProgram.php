<?php 
  require_once('/classes/createProgramObj.php');
	require_once('checkLogIn.php');
	require_once('config.php');

	$title = 'Create Progam Request' . TITLEADDON;

  
  /*
  * connects to database and prints out html option tags based on the query for terms 
  */
  function selectTerms()
  {
    $termOptions = "";

    // table that we'll read from
    $tableName = "term";

    $connection = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME);

    // check connection
    if (mysqli_connect_errno()) 
    {
        printf("Connect failed: %s\n", mysqli_connect_error());
        exit();
    }

    // always use SQL protection.
    $sqlStatement = "SELECT * FROM $tableName";
    $result = mysqli_query($connection, $sqlStatement);

    //reading through table rows to create opton values for the selector
    while ($row = mysqli_fetch_array($result)) 
    {
      $termOptions .= '<option value="'.$row["season"].' '.$row["year"].'"">'.$row["season"].' '.$row["year"].'</option>';
      //echo '<option>'.$row['season'].'</option>';
    }

    // clode db connection
    mysqli_close($connection);

    return $termOptions;
  }  

 


  if($_SERVER["REQUEST_METHOD"] != "POST" || !$tablesCreatedBool)
  {

   if(!isset($tablesCreatedBool))
      {
        $tablesCreatedBool = TRUE;
      }
     

    
    	$content = '    
    	<div class="container roundCorners">
    		<div class="jumbotron roundCorners medPadding">
    			<h1 class="noPadding noMargins bold">Create Program</h1>
          <h2 class="noMargins"><small>Please fill out all fields. <span class="orangeText">Note that all file selectors are currently under development.</span></small></h2>

    			<form action="'.htmlspecialchars("createProgram.php").'" method="post" id="createRequestForm" class="form noTopPadding noPadding" role="form">        
         
            <div>
              
              <article>
                 
                <div class="row relative">
                  <div class="col-md-6">
                    <label for="programName" class="createReqTag">Program Name</label>
                      <input type="text" class="required form-control" name="programName" placeholder="Program Name" required>
                    </div>
                      
                  <div class="col-md-6">
                    <label for="fct" class="createReqTag">First Course Term</label>
                      <select class="form-control" name="fct" placeholder="Select a Term">
                      '.selectTerms().'
                      </select>
                  </div>
                </div>
                        
              </article>



              <article>
                <div class="row">
                    
                    <div class="col-md-6">
                      <label for="rationaleInputFile" class="createReqTag">Rationale</label>
                        <div class="form-group">
                          <input type="file" name="rationaleInputFile" class="inputChoice">
                        </div>
                      <textarea class="required form-control" name="rationaleText" value="Rationale" placeholder="Rationale" rows="5" required></textarea>
                    </div>
                    
                    <div class="col-md-6">
                        <label for="crossInputFile" class="createReqTag">Cross Impact</label>
                          <div class="form-group">
                            <input type="file" id="crossInputFile" class="inputChoice">
                          </div>
                        <textarea class="required form-control" name="crossText" placeholder="Cross Impact" rows="5" required></textarea>
                    </div>
                </div>

              </article>
             


              <article>
                
                <div class="row">

                    <div class="col-md-6">
                      <label for="studentInputFile" class="createReqTag">Student Impact</label>
                      <div class="form-group">
                        <input type="file" name="studentInputFile" class="inputChoice">
                      </div>
                      <textarea class="required form-control" name="studentText" student="Student Impact" rows="5" required></textarea>
                    </div>
            
                    <div class="col-md-6">
                      <label for="generalInputFile" class="createReqTag">General Comments</label>
                        <div class="form-group">
                          <input type="file" name="generalInputFile" class="inputChoice">
                        </div>
                        <textarea class="required form-control" name="generalText" placeholder="General Comments" rows="5" required></textarea>
                    </div>
                </div>

              </article>



              <article>

                <div class="row">
                
                  <div class="col-md-6">
                    <label for="studentInputFile" class="createReqTag">Proposed Calendar</label>
                      <div class="form-group">
                        <input type="file" name="studentInputFile" class="inputChoice">
                      </div>
                      <textarea class="required form-control" name="calendarText" placeholder="Proposed Calendar" rows="5" required></textarea>
                  </div>

                  <div class="col-md-6">
                    <label for="libraryInputFile" class="createReqTag">Library Impact</label>
                      <div class="form-group">
                        <input type="file" name="libraryInputFile" class="inputChoice">
                      </div>
                      <textarea class="required form-control" name="libraryText" placeholder="Library Impact" rows="5" required></textarea>
                  </div>
      
                </div>

              </article>



              <article>

                <div class="row">
                
                  <div class="col-md-6">
                    <label for="itsIputFile" class="createReqTag">ITS Impact</label>
                    <div class="form-group">
                      <input type="file" name="itsIputFile" class="inputChoice">
                    </div>
                    <textarea class="required form-control" name="itsText" placeholder="ITS Impact" rows="5" required></textarea>
                  </div>
                
                </div>

                <button class="btn btn-lg btn-primary formPagingButtonPadding" name="submitProgram" id="submitProgram" type="submit">Request this Program <span class="glyphicon glyphicon-send"></span></button>

              </article>

            </div>

          </form>






          <!-- This is where Contextual Info goes if JS in enabled-->
          <div class="invisible enteredInfo col-md-12">
            
                 <div></div>     
          </div>


          </div>


             
    	    </div>
    	</div>
    	'; 

      if($tablesCreatedBool == FALSE)
      { 
        $content .= '<div class="alert alert-danger alertBox" role="alert"  style="text-align:center;">
                      <strong>Program Name already exists </strong><span class="glyphicon glyphicon-asterisk"></span>
                    </div>';
     }


    }



  // form validation
  if ($_SERVER["REQUEST_METHOD"] == "POST") 
  {
    // create tables in database
    $createProgram = new CreateProgramRequest();
    $createProgram->createNewRequestFromPost($user, "in-progress");
    $tablesCreatedBool = $createProgram->createTableEntries();

    if($tablesCreatedBool == TRUE)
    {
      header("location: cpSuccess.php");
    }
    else 
    {
      $tablesCreatedBool = FALSE;
      header("location: cpFailure.php");
    }
    
  }


	require_once('master.php');

?>