<?php 
  require_once 'config.php';
  // set session for user log in 

  $title = 'Log In' . TITLEADDON; 

  $content = '
  <!-- Log in form -->
  <div class="container">
    <!-- Main component for a primary marketing message or call to action -->
    <div class="jumbotron noBackground">
      <form action="logIn.php" method="post" id="logInForm" class="form-signin noTopPadding" role="form">        
        <h2 class="form-signin-heading">Hello, please sign in.</h2>
        <input type="email" name="email" class="form-control" placeholder="Email address" required autofocus>
        <input type="password" name="password" class="form-control" placeholder="Password" required> 
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <!--<h4>Forgot your password? Click <a href="passwordReset.php" class="">here</a></h4>-->
      </form>
    </div>    
  </div>';  


  // CREDIT PAUL DEROSE for assistance in reading user log in info from the db
  // table that we'll read from
  $tableName = "Users";

  //user entered login info is checked to make sure there is something before accessing the db
  if (isset($_POST['email']) && isset($_POST['password'])) 
  {
    //database connection, CREDIT TO ANTHONY THOMASSON for the database set up
    // paramaters come from config.php
    $connection = mysqli_connect(DBHOST, DBUSER, DBPASS, DBNAME);

    // check connection
    if (mysqli_connect_errno()) 
    {
        printf("Connect failed: %s\n", mysqli_connect_error());
        exit();
    }

    // always use sql protection
    $email = mysqli_real_escape_string($connection, $_POST['email']);
    $password = mysqli_real_escape_string($connection, $_POST['password']);

    $passwordMD5 = md5($password);  

    // always use SQL protection.
    $sqlStatement = "SELECT * FROM $tableName WHERE username = '$email' AND password = '$passwordMD5'";
    $result = mysqli_query($connection, $sqlStatement);

    // if a row is returned proceed, otherwise we print an error message
    if (mysqli_num_rows($result) == 0) 
    {
      echo '
            <div class="alert alert-danger alertBox" role="alert">
              <strong>Incorrect Username/Password pair </strong><span class="glyphicon glyphicon-asterisk"></span>
            </div>

           ';
    } 
    
    

    //echo $result;

    //counting table rows to look for one matching result
    // IF THERE IS NOT MATCH -> REDIRECT BACK TO logIn.php
    while ($row = mysqli_fetch_array($result)) 
    {
     
      // session to store email/username and password
      // only created if a sucessful match is found
      session_start();
      $_SESSION["email"] = $row["username"];
      $_SESSION["password"] = $row["password"];
      session_write_close();
      print_r($result);
      // redirect because the logIn was sucessful
      header("location: index.php");
     
    }

    // clode db connection
    mysqli_close($connection);
  }
  
  

  require_once('master.php');

?>


