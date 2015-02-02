// // setting up listeners
	// var form1 = document.getElementById('form1');
	// 	var form1BTN = document.getElementById('form1BTN');

	// var form2 = document.getElementById('form2');
	// 	var form2BTN = document.getElementById('form2BTN');
	// 		var form2BTNPrev = document.getElementById('form2BTNPrev');
	
	// var form3 = document.getElementById('form3');
	// 	var form3BTN = document.getElementById('form3BTN');
	// 		var form3BTNPrev = document.getElementById('form3BTNPrev');

	// var form4 = document.getElementById('form4');
	// 	var form4BTN = document.getElementById('form4BTN');
	// 		var form4BTNPrev = document.getElementById('form4BTNPrev');

	// var form5 = document.getElementById('form5');
	// 		var form5BTNPrev = document.getElementById('form5BTNPrev');

				
	
	// calls the appropriate hiding/showing for the first button
	// form1BTN.addEventListener("click",secondHide);
	// form1BTN.addEventListener("click",nextPhaseOne);

	// form2BTNPrev.addEventListener("click",prevPhaseTwo);
	// form2BTN.addEventListener("click",nextPhaseTwo);


	// form3BTNPrev.addEventListener("click",prevPhaseThree);
	// form3BTN.addEventListener("click",nextPhaseThree);

	// form4BTNPrev.addEventListener("click",prevPhaseFour);
	// form4BTN.addEventListener("click",nextPhaseFour);

	// form5BTNPrev.addEventListener("click",prevPhaseFive);
	

	//form1BTNPrev.addEventListener("click",secondPrev);
	//form2BTN.addEventListener("click",thirdHide);

	// form1.attachEvent('onclick', secondHide())
	// form2.addEventListener();
	// form3.addEventListener();
	// form4.addEventListener();
	// form5.addEventListener();

	// always runs to show only the start of the form 
	// first();
  	
 
});

// function first() 
// {
// 	// show first part of form
// 	$("#form1").show();
// 		$("#form1BTN").removeClass('invisible');

// 	// hide everything else
// 	$("#form2").hide();
// 	$("#form3").hide();
// 	$("#form4").hide();
// 	$("#form5").hide();
// 	$("#submitProgram").hide();	
// }

// // -------------------------------------------------------------------------

// // ADD  CHILD SELECTORS FOR EVERYTHING ----> PUT A UNIQUE ID FOR THE PARENT DIV TO EASILY SELECT THE BUTTONS

// // --------------------------------------------------------------------------
// // Hiding phases functions
// function hidePartOne()
// {	
// 	//$("#form1").fadeOut("slow").slideUp(3000);
// 	// $("#createRequestForm").animate({height:'268px'}, "slow");
// 	$("#form1").hide();
// 	//$("#form1BTN").fadeTo( "slow" , 0);
// 	//$("#form1").hide();
// 	$("#form1BTN").hide();
// }

// function hidePartTwo()
// {
// 	$("#form2").hide();
// 	$("#form2BTN").hide();
// 	$("#form2BTNPrev").hide();
// }

// function hidePartThree()
// {
// 	$("#form3").hide();
// 	$("#form3BTN").hide();
// 	$("#form3BTNPrev").hide();
// }

// function hidePartFour()
// {
// 	$("#form4").hide();
// 	$("#form4BTN").hide();
// 	$("#form4BTNPrev").hide();
// }

// function hidePartFive()
// {
// 	$("#form5").hide();
// 	$("#form5BTNPrev").hide();
// 	$("#submitProgram").hide();
// }


// // --------------------------------------------------------------------------
// // Showing phases functions
// function showPartOne()
// {
// 	$("#form1").show();
// 	$("#form1BTN").removeClass('invisible');
// 	$("#form1BTN").show();

// }

// function showPartTwo()
// {
	
// 	$("#form2").show();

// 		$("#form2BTNPrev").removeClass('invisible');	
// 		$("#form2BTN").removeClass('invisible');
// 		$("#form2BTN").show();
// 		$("#form2BTNPrev").show();	
// }

// function showPartThree()
// {
// 	$("#form3").show();

// 		$("#form3BTNPrev").removeClass('invisible');	
// 		$("#form3BTN").removeClass('invisible');
// 		$("#form3BTN").show();
// 		$("#form3BTNPrev").show();	
// }

// function showPartFour()
// {
// 	$("#form4").show();

// 		$("#form4BTNPrev").removeClass('invisible');	
// 		$("#form4BTN").removeClass('invisible');
// 		$("#form4BTN").show();
// 		$("#form4BTNPrev").show();	
// }

// function showPartFive()
// {
// 	$("#form5").show();

// 		$("#form5BTNPrev").removeClass('invisible');
// 		$("#form5BTNPrev").show();			
// 		$("#submitProgram").show();	
// }

// // --------------------------------------------------------------------------
// // Continuing phases functions
// //  go to phase two
// function nextPhaseOne() // good
// {
// 	hidePartOne();
// 	showPartTwo();
// }


// // go to phase one
// function prevPhaseTwo() // good
// {
// 	hidePartTwo();
// 	showPartOne();
// }

// //  go to phase three
// function nextPhaseTwo() // good
// {
// 	hidePartTwo();
// 	showPartThree();
// }


// // go to phase two
// function prevPhaseThree() // good
// {
// 	hidePartThree();
// 	showPartTwo();
// }

// //  go to phase four
// function nextPhaseThree() // good
// {
// 	hidePartThree();
// 	showPartFour();
// }


// // go to phase three
// function prevPhaseFour() // good
// {
// 	hidePartFour();
// 	showPartThree();
// }

// //  go to phase five
// function nextPhaseFour() // good
// {
// 	hidePartFour();
// 	showPartFive();
// }


// // go to phase four
// function prevPhaseFive() // good
// {
// 	hidePartFive();
// 	showPartFour();
// }
