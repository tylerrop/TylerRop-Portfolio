$(document).ready(function()
{
	// make the active Content Area visible is the user has JS enabled
	$(".invisible").removeClass('invisible');
  $('form[name="searchBox"]').attr('method', "GET");

	
	// once an input is changed (Program Name, Term) then they are updated
	$(":input").change(function()
	{
 
	      programName = $('input[name="programName"]').val();
  		  term = $('select[name="fct"]').val();

  		  $(".enteredInfo > div").empty();
  		  $(".enteredInfo > div").append(programName + " " + term); 
	});
    
 
 
 	
	// ensure that all form fields are filled out...
	$('#createRequestForm :submit[name="submitProgram"]').on("click", function() 
	{
  		$('.required').each(function() 
  		{
    		if ( ($(this).val()) == "" ) 
    		{ 
      			$(this).addClass("highlight");
      			$(this).css('border', '1px solid #f0ad4e');
      			$(this).css('background-color', 'rgb(255, 238, 214)');
    		}
    		else
    		{
    			$(this).removeClass("highlight");
    			$(this).css('border', '1px solid #cccccc');
    			$(this).css('background-color', '#FFF');
    		}
  		});

  		if ($('.required').hasClass('highlight')) 
  		{
    		alert("Please fill in all fields to submit your Program Request.");
    		return false;
  		}
	}); 




  var currentPage = ($(location).attr('href'));
  var typingTimer;                //timer identifier
  var doneTypingInterval = 750;  //time in ms, 5 second for example

  if (currentPage.search("searchResultsASYNC.php") > -1 )
  {

        /* When the user enters a value such as "j" in the search box
         * we want to run the .get() function. */
        $('input[name="query"]').keyup(function() 
        { 

          clearTimeout(typingTimer);

            /* Get the value of the search input each time the keyup() method fires so we
             * can pass the value to our .get() method to retrieve the data from the database */
            var searchVal = $(this).val();

            /* If the searchVal var is NOT empty then check the database for possible results
             * else display message to user */
            if(searchVal !== '') 
            {
              $("#results").fadeOut(2000);
              
              typingTimer = setTimeout(function()
              {

                /* Fire the .get() method for and pass the searchVal data to the
                 * search-data.php file for retrieval */
                  $.get('search-data.php',{query:searchVal}, 
                    function(returnData) 
                    {
                      /* If the returnData is empty then display message to user
                       * else our returned data results in the table.  */
                      if (!returnData) 
                      {
                        $('#results').html('=Search term entered does not return any data.');
                      } 
                      
                      else 
                      {
                        $("#results").html($("#results").load("async.txt"));

                        $('#results').html(returnData);
                      }

                      // $("#results").fadeIn(2000);
                  
                    });
                  $("#results").fadeIn(2000);
              }, doneTypingInterval);

            } 

            else 
            {
                // $('#results').html('No Results found');
            }

          // $("#results").fadeIn(2000);            

        });
  
  $("div:first").css('display','none');
  // $("#results").fadeIn(2000);

  }

});


 
    
