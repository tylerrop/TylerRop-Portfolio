<?php

$topNav = '<div class="navbar navbar-default navbar-static-top" role="navigation">
  <div class="container">
    
    <div class="navbar-header">
     <!-- Commented out b/c of no JS req
     <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button> 
      -->
      
      <a class="navbar-brand" href="index.php">MRU Curriculum <small><span class="glyphicon glyphicon-home"></span></small></a>
    </div>
    
    <!-- No collapse class on div for no JS -->
    <div class="navbar-collapse">
      <!--<ul class="nav navbar-nav navbar-left">
        <li><a href="index.php">Home</a></li>
        <li><a href="#">Settings</a></li>
      </ul>-->
      
      <form action="searchResults.php" name="searchBox" method="POST" class="navbar-form navbar-right noRightPadding" role="form">
        <div class="form-group">
          <!-- search box -->
          <input type="text" class="form-control" id="maxSearchWidth" name="query" placeholder="Search Programs">
        </div>

        <button type="submit" class="btn btn-primary">Search <span class="glyphicon glyphicon-search"></span></button>
        
        <!-- log out button -->
        <a href="logOut.php" class="btn btn-warning">Log Out <span class="glyphicon glyphicon-user"></span> '.$_SESSION["email"].'</a>
      </form>

    </div>

  </div>
</div>
';

echo $topNav;

?>