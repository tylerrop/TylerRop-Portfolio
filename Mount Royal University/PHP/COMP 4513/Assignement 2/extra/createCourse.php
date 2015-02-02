<?php 

	require_once('checkLogIn.php');
	require_once('config.php');

	$title = 'Create Course' . TITLEADDON;

	// Used to list out credit hours for the select drop down
	$creditHours = "";
	for ($i=0; $i <= 16; $i++) 
    { 
    	$creditHours .= '<option value='.$i.'>'.$i.'</option>';
    } 

  // htmlspecialchars is used with the form action to prevent cross site scripting by converting injected script to html
  // the form redirects back to the same page for validation
	$content = '
	<div class="container roundCorners">
		<div class="jumbotron roundCorners medPadding">
			<h1 class="noPadding noMargins bold">Create a Course</h1>
			<h2 class="noMargins"><small>Please fill out all fields. <span class="orangeText">Note that all file selectors are currently under development.</span></small></h2>

			<form action="'.htmlspecialchars("createCourse.php").'" method="post" id="createRequestForm" class="form noTopPadding noPadding" role="form">        

        		<div class="row">
        			<div class="col-md-6">
                  <label for="cName" class="createReqTag">Course Name</label>
          				<input type="text" class="form-control" name="cName" placeholder="Course Name (ex. COMP 4513)">
        			</div>
        
        			<div class="col-md-6">
          				<label for="progList" class="createReqTag">Program</label>
          				<!-- NEEDS TO BE DYNAMICALLLY FILLED -->
          				<select class="form-control" name="progList" placeholder="Select Program">
          					<option value="volvo">Volvo</option>
      							<option value="saab">Saab</option>
      							<option value="opel">Opel</option>
      							<option value="audi">Audi</option>
          				</select>
        			</div>      			

        		</div>


        		<div class="row">
        			<div class="col-md-6">
                  <label for="cTitle" class="createReqTag">Course Title</label>
                  <input type="text" class="form-control" name="cTitle" placeholder="Course Title (ex. Advanced Web Development )">
        			</div>
              
              <div class="col-md-6">
                  <label for="fct" class="createReqTag">First Course Term</label>
                  <!-- NEEDS TO BE DYNAMICALLLY FILLED -->
                  <select class="form-control" name="fct" placeholder="Select a Term">
                    <option value="volvo">Volvo</option>
                    <option value="saab">Saab</option>
                    <option value="opel">Opel</option>
                    <option value="audi">Audi</option>
                  </select>
              </div>
        			
        		</div>
        		
        	
        		<div class="row">
              

        			<div class="col-md-6">
          				<label for="schedList" class="createReqTag">Schedule Type</label>
          				<select class="form-control" name="schedList" placeholder="Select Program">
          					<option value="Lecture">Lecture</option>
							      <option value="Lab">Lab</option>
							      <option value="Tutorial">Tutorial</option>
							     <option value="Other">Other</option>
          				</select>
        			</div>

           
        			<div class="col-md-6">
          				<label for="transList" class="createReqTag">Transfer Credit</label>
                  <div class="form-group">
    						    <input type="file" name="transInputFile" class="inputChoice">
  						    </div>
          				<select class="form-control" id="transList" placeholder="Select Program">
          					<option value="Required">Required</option>
							      <option value="Preferred">Preferred</option>
							      <option value="Not Required">Not Required</option>
          				</select>
        			</div>
        		</div>
        		
     

        		<div class="row">
        			<div class="col-md-6">
          				<label for="hoursList" class="createReqTag">Credit Hours</label>
          				<select class="form-control" id="hoursList" placeholder="Credit Hours">
          					'.$creditHours.'
          				</select>
        			</div>

        			<div class="col-md-6">
          				<label for="gradeList" class="createReqTag">Grading Mode</label>
          				<select class="form-control" id="gradeList" placeholder="Grading Mode">
          					<option value="Standard">Standard</option>
							<option value="Pass/Fail">Pass/Fail</option>
							<option value="Percentage">Percentage</option>
          				</select>
        			</div>
        			
        		</div>

      

        		<div class="row">
              <div class="col-md-6">
                  <label for="preR" class="createReqTag">Prerequisite(s)</label>
                  <div class="form-group">
                <input type="file" name="preRInputFile" class="inputChoice">
              </div>
                  <textarea class="form-control" name="preR" placeholder="Prerequisite(s)" rows="5"></textarea>
              </div>

        			<div class="col-md-6">
                   		<label for="rat" class="createReqTag">Rationale</label>
                   		 <div class="form-group">
    						<input type="file" id="rationalInputFile" class="inputChoice">
  						</div>
          				<textarea class="form-control" id="rat" placeholder="Rational" rows="5"></textarea>
        			</div>
       
        		</div>

      

        		<div class="row">
        			<div class="col-md-6">
                   		<label for="studImpact" class="createReqTag">Student Impact</label>
                   		<div class="form-group">
    						<input type="file" id="studentInputFile" class="inputChoice">
  						</div>
          				<textarea class="form-control" id="studImpact" placeholder="Student Impact" rows="5"></textarea>
        			</div>
        
        			<div class="col-md-6">
          				<label for="genC" class="createReqTag">General Comments</label>
          				<div class="form-group">
    						<input type="file" id="genC" class="inputChoice">
  						</div>
          				<textarea class="form-control" id="itsI" placeholder="General Comments" rows="5"></textarea>
        			</div>
        		</div>

       

        		<div class="row">
	        		<div class="col-md-6">
	                   	<label for="libImpact" class="createReqTag">Library Impact</label>
	                   	<div class="form-group">
	    					<input type="file" id="libInputFile" class="inputChoice">
	  					</div>
	          			<textarea class="form-control" id="libImpact" placeholder="Library Impact" rows="5"></textarea>
	        		</div>

	        		<div class="col-md-6">
	          			<label for="genC" class="createReqTag">ITS Impact</label>
	          			<div class="form-group">
	    					<input type="file" id="itsIputFile" class="inputChoice">
	  					</div>
	          			<textarea class="form-control" id="itsI" placeholder="ITS Impact" rows="5"></textarea>
	        		</div>

        		</div>



            <div class="row">

              <div class="col-md-6">
                  <label for="crossI" class="createReqTag">Cross Impact</label>
                  <div class="form-group">
                <input type="file" id="crossInputFile" class="inputChoice">
              </div>
                  <textarea class="form-control" id="crossI" placeholder="Cross Impact" rows="5"></textarea>
              </div>
              
              <div class="col-md-6">
                    <label for="studImpact" class="createReqTag">Proposed Calendar</label>
                      <div class="form-group">
                <input type="file" id="studentInputFile" class="inputChoice">
              </div>
                  <textarea class="form-control" id="studImpact" placeholder="Proposed Calendar" rows="5"></textarea>
              </div>
            </div>

            <br/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Create Course Request</button>

      		</form>



	    </div>
	</div>
	'; 
  // end of course form


  // form validation
  if ($_SERVER["REQUEST_METHOD"] == "POST") 
  {
    // echo $courseName = test_input($_POST["cName"]);
    // echo $program = test_input($_POST["progList"]);
    // echo $cTitle = test_input($_POST["cTitle"]);
    // echo $firstTerm = test_input($_POST["fct"]);
    // echo $preRInputFile = test_input($_POST["preRInputFile"]);
    // echo $preR = test_input($_POST["preR"]);
    // echo $sched = test_input($_POST["schedList"]);
    // echo $transInputFile = test_input($_POST["transInputFile"]);
    // echo $transList = test_input($_POST["transList"]);

  }

// cleans input data to be safe from XSS and some injection/other attacks
function test_input($data) 
{
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}




	require_once('master.php');

?>