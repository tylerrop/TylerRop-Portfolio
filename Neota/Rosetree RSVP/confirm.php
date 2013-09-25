<?php 
	if(isset($_POST['rsvp_submit'])){
		
		$fp = fopen('./data/invite_list.csv', 'a');
		fputcsv($fp, $_POST);
		fclose($fp);
		
		if(strlen($_POST['email']) > 0){
			$to = $_POST['email'];
			$subject =	 'AUTO RESPONDER - Rosetree Developments Office Opening Party - Thursday, June 7th, 2012';
			$bound_text =	"jimmyP123";
			$content_id = md5('img');
			$bound =	"--".$bound_text."\r\n";
			$bound_last =	"--".$bound_text."--\r\n";
			
			$headers =	"From: noreply@rosetreedevelopments.com\r\n";
			$headers .=	"MIME-Version: 1.0\r\n"
			."Content-Type: multipart/mixed; boundary=\"$bound_text\"";
			
			$message .=	"If you can see this MIME than your client doesn't accept MIME types!\r\n"
			.$bound;
			
			$message .=	"Content-Type: text/html; charset=\"iso-8859-1\"\r\n"
			."Content-Transfer-Encoding: 7bit\r\n\r\n".
			"<head>
			
			<link href='http://fonts.googleapis.com/css?family=Amatic+SC:400,700' rel='stylesheet' type='text/css'>
			<style type='text/css'>
			
			
			body {margin:0; padding:0;
				font-family: Gotham, Helvetica, Arial, sans-serif;
				font-weight:100;
				font-size:19px;
			color:#FFF;
			}
			#rsvp{
		left:100px;
		}
		
		#rsvp input{
		font-family:  Gotham, “Helvetica Neue”, Helvetica, Arial, sans-serif;
		font-size: 16px;
		font-weight:100;
	color: #000;
	}
	#rsvp img{
	padding-top:3.5px;
	padding-bottom:3.5px;
	}
	
	#we{
	margin-right:5px;
	}
	
	input#name{
border:0px;
background:url(img/bar_name.png) no-repeat;
width:363px;
height:24px;
	padding-left:60px;
margin:10px 0px 0px 10px;
	}
	
	input#company{
border:0px;
background:url(img/bar_company.png) no-repeat;
width:338px;
height:24px;
	padding-left:85px;
margin:10px 0px 0px 10px;
	}
	
	
	input#diet{
border:0px;
background:url(img/bar_diet.png) no-repeat;
width:266px;
height:24px;
	padding-left:157px;
margin:10px 0px 0px 10px;
	}
	
	input#email{
border:0px;
background:url(img/bar_email.png) no-repeat;
width:363px;
height:24px;
	padding-left:60px;
margin:10px 0px 0px 10px;
	}
	
	input#submit{
border:0px;
background:url(img/submit.png) no-repeat;
width:67px;
cursor:pointer;
	margin-top:5px;
	}
	
a:link {color:#fff; text-decoration:none;}      /* unvisited link */
a:visited {color:#fff; text-decoration:none;}  /* visited link */
a:hover {color:#fff; text-decoration:underline;}  /* mouse over link */
a:active {color:#fff; text-decoration:none;}  /* selected link */
	
	#page-background {position:fixed; top:0; left:0; width:100%; height:100%; z-index:0;}
	.content {position:relative; z-index:1; padding:10px;}
	</style>
	
	<!-- The above code doesn't work in Internet Explorer 6. To address this, we use a conditional comment to specify an alternative style sheet for IE 6 -->
	<!--[if IE 6]>
	<style type='text/css'>
	html {overflow-y:hidden;}
	body {overflow-y:auto;}
	#page-background {position:absolute; z-index:-1;}
	#content {position:static;padding:10px;}
	</style>
	
	<![endif]-->
	
	
	
	
	</head>
	
	<body style='text-align:center;'>
    
	<a href='index.html' ><img src='http://rosetreedevelopments.com/img/logo.png' alt='Rosetree Developments' style='position: absolute; z-index:10; left:50%; margin-left:-94px;' /></a>	
	<center style='position:absolute;z-index:7;top:10%;'>
	This email indicates that we have received your RSVP.<br />
	<br />
	Thursday, June 7, 2012<br />
	235 - 366 Aspen Glen Landing SW<br />
	Party starts at 8pm.<br /><br />
	If you require any further information, please feel free to email<br />
	<a href='mailto:EmailUs@neota.net?Subject=RSVP%20Party'>groseboom@rosetreedevelopments.com</a> or call George Roseboom at 403-453-5530.</center>
	<div style='width:729px; height:55px; position:absolute; left:50%; margin-left:-364px; bottom:0px; z-index:7;'>
	<img src='http://rosetreedevelopments.com/img/bottombar.png' width='729' alt='' style='position:absolute; bottom:0px; left:0px;opacity:0.8;'/>
	<a href='mailto:groseboom@orchestrateinc.com' style='width:230px;height:20px;z-index:9; position:absolute; left:5px; bottom:0px;' alt='email George Roseboom at groseboom@orchestrateinc.com'></a>          
	</div>

	<div id='page-background' style='z-index:0;'><img src='http://rosetreedevelopments.com/img/bg-2.jpg' width='100%' height='100%'></div>
	</body>
	"."					
			\r\n"
			.$bound;
			
			$file =	file_get_contents("http://rosetreedevelopments.com/img/logo.png");
			
			$message .=	"Content-Type: image/png; name=\"logo.png\"\r\n"
			."Content-ID: <".$content_id.">\n"
			."Content-Transfer-Encoding: base64\r\n"
			."Content-disposition: inline; filename=\"logo.png\"\r\n"
			."\r\n"
			.$bound_last;
			
			mail($to, $subject, $message, $headers);	
		}
	}
	else{
		header('location:rsvp.html');
	}
	?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Rosetree Developments | Thank you! </title>

<link href='http://fonts.googleapis.com/css?family=Amatic+SC:400,700' rel='stylesheet' type='text/css'>
<style type="text/css">


body {margin:0; padding:0;
	font-family: 'Amatic SC', Helvetica, Arial, cursive;
	font-weight:700;
	font-size:19px;
color:#f26522;
}
#rsvp{
left:100px;
}

#rsvp input{
font-family:  Gotham, “Helvetica Neue”, Helvetica, Arial, sans-serif;
font-size: 16px;
font-weight:100;
color: #FFF;
}
#rsvp img{
padding-top:2.5px;
padding-bottom:2.5px;
}

label#name{
border:0px;
background:url(img/bar_name.png) no-repeat;
width:423px;
height:24px;
margin:10px 0px 0px 10px;
}

label#company{
border:0px;
background:url(img/bar_company.png) no-repeat;
width:423px;
height:24px;
margin:10px 0px 0px 10px;
}


label#diet{
border:0px;
background:url(img/bar_diet.png) no-repeat;
width:423px;
height:24px;
margin:10px 0px 0px 10px;
}


input#name{
border:0px;
background:url(img/bar_name.png) no-repeat;
width:353px;
height:24px;
padding-left:70px;
margin:10px 0px 0px 10px;
}

input#company{
border:0px;
background:url(img/bar_company.png) no-repeat;
width:318px;
height:24px;
padding-left:105px;
margin:10px 0px 0px 10px;
}


input#diet{
border:0px;
background:url(img/bar_diet.png) no-repeat;
width:246px;
height:24px;
padding-left:177px;
margin:10px 0px 0px 10px;
}

input#submit{
border:0px;
background:url(img/submit.png) no-repeat;
width:67px;
height:18px;
cursor:pointer;
margin-top:5px;
}
a:link {color:#f26522; text-decoration:none;}      /* unvisited link */
a:visited {color:#f26522; text-decoration:none;}  /* visited link */
a:hover {color:#f26522; text-decoration:underline;}  /* mouse over link */
a:active {color:#f26522; text-decoration:none;}  /* selected link */
	
	#page-background {position:fixed; top:0; left:0; width:100%; height:100%; z-index:0;}
	.content {position:relative; z-index:1; padding:10px;}
	
	</style>
	
	<!-- The above code doesn't work in Internet Explorer 6. To address this, we use a conditional comment to specify an alternative style sheet for IE 6 -->
	<!--[if IE 6]>
	<style type="text/css">
	html {overflow-y:hidden;}
	body {overflow-y:auto;}
	#page-background {position:absolute; z-index:-1;}
	#content {position:static;padding:10px;}
	</style>
	
	<![endif]-->
	
	
	
	
	</head>
	
	<body style="text-align:center;">
    
	<a href="index.html" ><img src="img/logo.png" alt="Rosetree Developments" style=" position: absolute; z-index:10; left:50%; margin-left:-94px;" /></a>
	<div id="rsvp" style="position:absolute; top:50%; margin-top:-237px; left:50%; margin-left:-269px; z-index:4;">
	<div style="float:left;margin-top:100px;margin-left:-200px;">
	<a href="https://maps.google.ca/maps?q=235+-+366+Aspen+Glen+Landing+SW&ie=UTF-8&hl=en" target="_blank"><img src="img/map.png" /></a>
	</div>
	<div style="float:right;margin-top:250px;margin-left:50px;">
	<img src="img/header_seesoon.png" />
	</div>
	</div>
	
	<div style="width:729px; height:55px; position:absolute; left:50%; margin-left:-364px; bottom:0px; z-index:7;">
	<img src="img/bottombar.png" width="729" alt="" style="position:absolute; bottom:0px; left:0px;opacity:0.8;"/>
	<a href="mailto:groseboom@orchestrateinc.com" style="width:230px;height:20px;z-index:9; position:absolute; left:5px; bottom:0px;" alt="email George Roseboom at groseboom@orchestrateinc.com"></a>          
	</div>
	
	<div id="page-background" style="z-index:0;"><img src="img/bg-2.jpg" width="100%" height="100%"></div>
	</body>
	</html>
