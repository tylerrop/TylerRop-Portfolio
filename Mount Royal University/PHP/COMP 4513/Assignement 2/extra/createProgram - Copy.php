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



	$content = '


	<div class="container roundCorners">
		<div class="jumbotron roundCorners medPadding">
			<h1 class="noPadding noMargins bold">Create Program</h1>
      <h2 class="noMargins"><small>Please fill out all fields. <span class="orangeText">Note that all file selectors are currently under development.</span></small></h2>
			
			<form action="'.htmlspecialchars("createProgram.php").'" method="post" id="createRequestForm" class="form noTopPadding noPadding" role="form">        

          <section class="demo_wrapper">
            <article class="demo_block">
              <h1>Simple demo with default setups</h1>
              
      <ul id="demo1">
        <!--Part 1-->
        <li> 
              <div class="row relative" id="form1">
                <div class="col-md-6">
                    <label for="programName" class="createReqTag">Program Name</label>
                    <input type="text" class="form-control" name="programName" placeholder="Program Name" required>
                </div>
          
                <div class="col-md-6">
                    <label for="fct" class="createReqTag">First Course Term</label>
                    <select class="form-control" name="fct" placeholder="Select a Term">
                      '.selectTerms().'
                    </select>
                </div>
              </div>
        </li>

        <li><a href="#slide2"><img src="img/image-2.jpg"  alt="This is caption 2"></a></li>
        <li><a href="#slide3"><img src="img/image-4.jpg" alt="And this is some very long caption for slide 3. Yes, really long."></a></li>
      </ul>
      </article>
    </section>               

        		<div class="row relative" id="form1">
        			<div class="col-md-6">
                  <label for="programName" class="createReqTag">Program Name</label>
          				<input type="text" class="form-control" name="programName" placeholder="Program Name" required>
        			</div>
        
        			<div class="col-md-6">
          				<label for="fct" class="createReqTag">First Course Term</label>
          				<select class="form-control" name="fct" placeholder="Select a Term">
          					'.selectTerms().'
          				</select>
        			</div>

              <div class="col-md-12">
                   <button class="btn btn-primary formPagingButtonPadding rightButton invisible" id="form1BTN">Continue to Part 2 <span class="glyphicon glyphicon-arrow-right"></span></button>
              </div>

        		</div>

        



        		<div class="row" id="form2">
        			<div class="col-md-6">
                <label for="rationaleInputFile" class="createReqTag">Rationale</label>
                <div class="form-group">
    						  <input type="file" name="rationaleInputFile" class="inputChoice">
  						  </div>
          			<textarea class="form-control" name="rationaleText" placeholder="Rationale" rows="5" required></textarea>
        			</div>
        
        			<div class="col-md-6">
          				<label for="crossInputFile" class="createReqTag">Cross Impact</label>
          				<div class="form-group">
    						<input type="file" id="crossInputFile" class="inputChoice">
  						</div>
          				<textarea class="form-control" name="crossText" placeholder="Cross Impact" rows="5" required></textarea>
        			</div>

              <div class="col-md-12">
                <button class="btn btn-primary formPagingButtonPadding leftButton invisible" id="form2BTNPrev"><span class="glyphicon glyphicon-arrow-left"></span> Back to Part 1</button>
                <button class="btn btn-primary formPagingButtonPadding rightButton invisible" id="form2BTN">Continue to Part 3 <span class="glyphicon glyphicon-arrow-right"></span></button>
              </div>

        		</div>




        	

        		<div class="row" id="form3">
        			<div class="col-md-6">
                <label for="studentInputFile" class="createReqTag">Student Impact</label>
                <div class="form-group">
    						  <input type="file" name="studentInputFile" class="inputChoice">
  						  </div>
          			<textarea class="form-control" name="studentText" student="Student Impact" rows="5" required></textarea>
        			</div>
        
        			<div class="col-md-6">
          				<label for="generalInputFile" class="createReqTag">General Comments</label>
          				<div class="form-group">
    						    <input type="file" name="generalInputFile" class="inputChoice">
  						    </div>
          				<textarea class="form-control" name="generalText" placeholder="General Comments" rows="5" required></textarea>
        			</div>

               <div class="col-md-12">
                <button class="btn btn-primary formPagingButtonPadding leftButton invisible" id="form3BTNPrev"><span class="glyphicon glyphicon-arrow-left"></span> Back to Part 2</button>
                <button class="btn btn-primary formPagingButtonPadding rightButton invisible" id="form3BTN">Continue to Part 4 <span class="glyphicon glyphicon-arrow-right"></span></button>
              </div>

        		</div>
        	

        		<div class="row" id="form4">
        		  <div class="col-md-6">
              	<label for="studentInputFile" class="createReqTag">Proposed Calendar</label>
              	<div class="form-group">
    						  <input type="file" name="studentInputFile" class="inputChoice">
  						  </div>
          			<textarea class="form-control" name="calendarText" placeholder="Proposed Calendar" rows="5" required></textarea>
        			</div>

        			<div class="col-md-6">
                <label for="libraryInputFile" class="createReqTag">Library Impact</label>
                <div class="form-group">
    						  <input type="file" name="libraryInputFile" class="inputChoice">
  						  </div>
          			<textarea class="form-control" name="libraryText" placeholder="Library Impact" rows="5" required></textarea>
        			</div>

              <div class="col-md-12">
                <button class="btn btn-primary formPagingButtonPadding leftButton invisible" id="form4BTNPrev"><span class="glyphicon glyphicon-arrow-left"></span> Back to Part 3</button>
                <button class="btn btn-primary formPagingButtonPadding rightButton invisible" id="form4BTN">Continue to Part 5 <span class="glyphicon glyphicon-arrow-right"></span></button>
              </div>
        			
        		</div>

      

            <div class="row" id="form5">
              <div class="col-md-6">
                <label for="itsIputFile" class="createReqTag">ITS Impact</label>
                <div class="form-group">
                  <input type="file" name="itsIputFile" class="inputChoice">
                </div>
                <textarea class="form-control" name="itsText" placeholder="ITS Impact" rows="5" required></textarea>
              </div>

               <div class="col-md-12">
                <button class="btn btn-primary formPagingButtonPadding leftButton invisible clearAll" id="form5BTNPrev"><span class="glyphicon glyphicon-arrow-left"></span> Back to Part 4</button>
              </div>

            </div>

            


            <button class="btn btn-lg btn-primary btn-block formPagingButtonPadding" name="submitProgram" id="submitProgram" type="submit">Request this Program <span class="glyphicon glyphicon-send"></span></button>


      		</form>


         
	    </div>
	</div>
	'; 


  // form validation
  if ($_SERVER["REQUEST_METHOD"] == "POST") 
  {
    // create tables in database
    $createProgram = new CreateProgramRequest();
    $createProgram->createNewRequestFromPost($user, "in-progress");
    $tablesCreated = $createProgram->createTableEntries();
    header("location: cpSuccess.php");
  }


	require_once('master.php');

?>