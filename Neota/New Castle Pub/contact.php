<?php
	//ini_set('display_errors', 1);
	ini_set('allow_url_fopen', '1');
	
	if($_POST['submit'] !== false && $_POST['fName'] != "" && $_POST['lName'] != "" && $_POST['email'] != "" && $_POST['message'] != ""){	
	$fp = fopen('data/contactList.csv', 'a');
	fputcsv($fp, $_POST);
	fclose($fp);
	
	/*THIS EMAIL GOES TO NICK */
	$to = 'hiring@newcastlepub.ca';
	$subject = 'Someone has inquired to Newcastle';
	$bound_text = "jimmyP123";
	$content_id = md5('img');
	$bound =	"--".$bound_text."\r\n";
	$bound_last =	"--".$bound_text."--\r\n";
	
	$headers =	"From: noreply@newcastlepub.ca\r\n";
	$headers .=	"MIME-Version: 1.0\r\n"
	."Content-Type: multipart/mixed; boundary=\"$bound_text\"";
	
	$message .=	"If you can see this MIME than your client doesn't accept MIME types!\r\n".$bound;				
	
	$message .=	"Content-Type: text/html; charset=\"iso-8859-1\"\r\n"
	."Content-Transfer-Encoding: 7bit\r\n\r\n"
	."		
	
	
	This email indicates that the Newcastle Pub form has been filled with information.<br />	
	<br />
	<b>Inquiry Information</b>
	<br/>
	First Name: ".$_POST['fName']."
	<br/>
	Last Name: ".$_POST['lName']."
	<br/>
	Email: ".$_POST['email']."
	<br/>
	Message: <p>".$_POST['message']."</p>
	<br/>
	If there are any issues /concerns, please contact questions@newcastlepub.ca for support.<br />\r\n".$bound_last;
	
	mail($to, $subject, $message, $headers);
	

	if(strlen($_POST['email']) > 0){

		$to = $_POST['email'];
		$subject = 'Ask Newcastle';
		$bound_text = "jimmyP123";
		$content_id = md5('img');
		$bound =	"--".$bound_text."\r\n";
		$bound_last =	"--".$bound_text."--\r\n";
		
		$headers =	"From: noreply@newcastle.com\r\n";
		$headers .=	"MIME-Version: 1.0\r\n"
		."Content-Type: multipart/mixed; boundary=\"$bound_text\"";
		
		$message =	"If you can see this MIME than your client doesn't accept MIME types!\r\n".$bound;				
		
		$message .=	"Content-Type: text/html; charset=\"iso-8859-1\"\r\n"
		."Content-Transfer-Encoding: 7bit\r\n\r\n"
		."		


		This email indicates that Newcastle Pub has received your contact information.<br /><br />
		
		If you require any further information, please feel free to call Newcastle Pub at 403-240-2111. <br /><br />\r\n"
		.$bound;
		
		
		
		$message .=	"Content-Type: image/jpg; name=\"email.jpg\"\r\n"
		."Content-ID: <".$content_id.">\n"
		."Content-Transfer-Encoding: base64\r\n"
		."Content-disposition: inline; filename=\"email.jpg\"\r\n"
		."\r\n"
		.$bound_last;
		
				mail($to, $subject, $message, $headers);
	}
}

?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Newcastle Pub | Contact</title>

<link href="css/reset.css" rel="stylesheet" type="text/css" />
<link href="css/new-castle-styles.css" rel="stylesheet" type="text/css" />

<link rel="icon" 
      type="image/png" 
      href="images/favicon.png">

<style>

body
{
	background-color:#000;
	margin-bottom:-500px;
}

</style>

<script language="javascript">
	   	image1 = new Image
		image1.src="images/Icon-Facebook-1.png"
		
		image2 = new Image
		image2.src="images/Icon-Facebook-2.png" 
		
		image3 = new Image
		image3.src="images/Icon-Twitter-1.png"
		
		image4 = new Image
		image4.src = "images/Icon-Twitter-2.png"
</script>

<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-33311157-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>

</head>


<div class="headerGoldenLineTop"></div>
   
<div class="container">


<div class="headerBox">

<p class="leftParaHeader">Stay in the loop with Newcastle Pub:</p>


 <!-- <a href="https://www.facebook.com/NewcastlePubCalgary" onMouseOver="document.picture.src=image2.src" onMouseOut="document.picture.src=image1.src" style="text-decoration:none" >
                    <img name="picture" src="images/Icon-Facebook-1.png" alt="Like Us On Facebook" class="leftFacebookHeader"  /> 
                    </a>-->
                    
                     <a href="https://www.facebook.com/NewcastlePubCalgary" onMouseOver="document.pictureF.src=image2.src" onMouseOut="document.pictureF.src=image1.src" style="text-decoration:none" >
                    <img name="pictureF" src="images/Icon-Facebook-1.png" alt="Like Us On Facebook" class="leftFacebookHeader"  />
                    </a>
                    
                  

	 <a href="http://twitter.com/#!/NewcastleYYC" onMouseOver="document.picture2.src=image4.src" onMouseOut="document.picture2.src=image3.src" style="text-decoration:none" >
                    <img name="picture2" src="images/Icon-Twitter-1.png" alt="Follow Us On Twitter" class="leftFacebookHeader" />
                    </a>
        

        
 		<!--<p class="leftLineHeader">|</p>-->
        
        
        <p class="rightParaHeader">Come hang out at our new location on the corner of 17 Ave. and 26 St. SW Calgary Ab.</p>
        


<!-- end of headerBox"-->
</div>


  <div class="middleLine"><img src="images/1px-line.jpg" width="1" height="22" alt="Line" /></div>

<!--<div class="headerLine"></div>-->


  	<div class="menuContainer">
    
            <div class="menuLeft">
            
            <a href="index.html"><div class="menuItemLeft-Home"></div></a>
            
            <!--<a href="index.html"><img src="images/Link-Home-1.png" width="58" height="18" alt="Home" /></a>-->
            
            <img src="images/Star-2.png" width="13" height="13" alt="Star" class="menuItem-LeftStar3"/> 
            
            <!--<a href="about.html"><div class="menuItemLeft-About"></div></a>-->
            
           
            
            <a href="about.html"><div class="menuItemLeft-About"></div></a>
            
            
            <!-- end of menuLeft -->
            </div>
    
    
    
    
        
       	  <a href="index.html"><div class="logo"><img src="images/Logo-2.png" width="262" height="194" alt="New Castle Pub" /></div></a>
          
          
          
      <div class="menuRight">
          
          <a href="menu.html"><div class="menuItemRight-Menu"></div></a>
          
          <img src="images/Star-2.png" width="13" height="13" alt="Star" class="menuItem-Rightstar"/>
          
          <a href="contact.php"><div class="menuItemRight-Here-ContactV2"></div></a>
          
          
          <!-- end of menuRight -->
      </div>
          
    <!-- end of menuContainer -->
    </div>      
          
          <br clear="all"/>
   
   
   <div class="line"></div>       
        
         <div class="blueBlurTop"></div>
         
          
          
          
          <div class="tenderBlur"></div>
    
<br clear="all"/>



	<div class="contactContainer">
    
   <img src="images/Heading-Contact.png" class="contactLogo"/>
      
      <br clear="all"/>
      
      <br clear="all"/>
      
      <p class="contactText"><span class="redText">Address</span> <a href="http://goo.gl/maps/VKo7">2703 17th Avenue SW, Calgary Alberta Canada, T3E 0A7</a></p>
      
      <br clear="all"/>
      
      <p class="contactText"><span class="redText">Phone</span> (403) 240 2111</p>
      
          
<br clear="all"/>
    
<br clear="all"/>


	<img src="images/AskUs.png" width="223" height="27" alt="Ask Us Anything"  class="askAnything"/>	
    
    
    <form method="POST" action="contact.php">
    
    	<table class="contactTable">
        
        	<tr class="trSpacing"></tr>
        	
            <tr>
            	<td class="tableLeft"><p>First Name</p></td>
                <td><input name="fName" type="text" size="62"  style="width:406px" /></td>
            </tr>
            
            	<tr class="trSpacing"></tr>
            
   		         <tr>
                 	 <td class="tableLeft"><p>Last Name</p></td>
                	 <td><input name="lName" type="text" size="62" style="width:406px" /></td>
                 </tr>
                 
                 	
                    <tr class="trSpacing"></tr>
            
            			<tr>
                        	<td class="tableLeft"><p>Email</p></td>
                            <td><input name="email" type="text" size="62" style="width:406px" /></td>
                        </tr>
            
            
            			<tr class="trSpacing"></tr>
                        
            				<tr>
                            	<td class="tableLeft"><p>Message</p></td>
                                <td><textarea name="message" cols="48" rows="4" style="width:406px" ></textarea></td>
                            </tr>
        
        </table>
    				
                   <!-- <input type="submit" title="" name="submit" class="submit" value="" /> -->
                    
                    <input type="submit"  title="" name="submit" class="submit" value="" border="none"/>

    
    </form>
    
    
    <!-- end of aboutContainer-->
    </div>
    






	
     <div class="blueBlurBottom2"></div>

		
<div class="footerBox">
 
 
<p class="footerGoldTextLeft">Call us for a reservation at (403) 240 2111</p> 
 
 
 
<div class="footerEmblem"><img src="images/bottomLogo.png" width="67" height="90" alt="Newcastle Ale" /></div>

 
 

 
 
 <p class="footerGoldTextRight">Newcastle Pub Proudly Serves Newcastle Brown Ale</p>


 <!--end of footerBox -->
 </div>
 
 
        
 

<!-- end of container-->
</div>


    



<div class="footer">
<!-- end of footer div -->
</div>

<div id="preloaded-images">

<img src="images/Link-About-2.png" width="1" height="1" />

<img src="images/Link-Contact-2.png" width="1" height="1" />

<img src="images/Link-Home-2.png" width="1" height="1" />

<img src="images/Link-Menu-2.png" width="1" height="1"/>

</div>

</body>
</html>