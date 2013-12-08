/**
 * Example of how to uses different features of the Interface code
 * @author jkidney
 * @version March 27, 2012
 */

import java.awt.Color;
import java.io.*;

import display.*;

public class TrollHunter_InterfaceExample 
{
	public static void main(String[] args)
	{
		//Get a reference to the main object that represents the graphical 
		//interface. You can not instantiate an object of type GuiInterface.
		//You must always to it in the following way. There will only ever be 
		//one reference/object of this class.
		 GuiInterface displayInterface = GuiInterface.getInstance(); 
		
		 //Get the graphical interface to appear on the screen
		 displayInterface.showWindow();
		 
		 //Brings up the file dialog to ask the user for the file to use
		 File selectedFile = displayInterface.getGameFile();
		 
		 //This is how you display messages to the user
		 //The message will appear at the top of the gui
		 //multiple calls to this method will overwrite the old message that 
		 //was displayed before
		 displayInterface.setUserDisplayMessage("HELLO WORLD!!!!!!!!!!!!!!!!!");
		 
		 //you can uncomment the line below if you want to use html tags
		 //in your output
		 //displayInterface.turnOnHtmlUserMessageDisplay();
		 //displayInterface.setUserDisplayMessage("<b>HELLO WORLD - html</b>!!!!!!!!!!!!!!!!!");
		 
		 //the line below if uncommented is how you clear the user display if you
		 //want nothing to appear
		 //displayInterface.clearUserDisplayMessage();
		 
		 //Below are examples how how to set information for the map on the 
		 //interface

		 //This line gets you access to an object that can be used to do work on
		 //Drawing/setting information for the map and displaying information
		 //on the story display screen. You need this when setting up the map,
		 //drawing the cave background and the monster on the foreground
		 DisplayGraphics graphics = displayInterface.getDisplayGraphics();
	
		 //Set the size of the cave system ( num rows, num cols )
		 graphics.buildMap(10, 10);
		 
		 //set colors for the actual caves on the map, 
		 //colors indicate why type the cave is
		                      // row, col, color ( for color see java.awt.Color )
		 graphics.setCaveColorAt(1,1, Color.GREEN );
		 graphics.setCaveColorAt(1,2, Color.MAGENTA );
		 graphics.setCaveColorAt(2,1, Color.YELLOW.darker() );

		 //at this point nothing will show up until you tell the interface to update
		 //the map that should be drawn. If you make any changes to the map you should 
		 //call this method at the end of the changes to have the displayed map updated
		 graphics.updateDrawnMap();
		 
		 //to see the map on the display the user can click on the "Map" tab at the top of the
		 //interface at any time
		 
		 //set the current cave location of the user in the map (row, col)
		 graphics.setUserLocation(1,1); // the user will appear as a yellow circle on the map
		 graphics.updateDrawnMap();// must call if you change the user location on the map
		                           //to make sure it is drawn again
		
		 
		 
		 //Here is how you can ask the user what direction they want to move in
		                                              
		     /*
		     * Displays the move Options to the user and waits for a response
		     * (up,right,down,left, Screen to display to the user)
		     * up    - true if user is allowed to move up, false otherwise
		     * right - true if user is allowed to move right, false otherwise
		     * down  - true if user is allowed move down, false otherwise
		     * left  - true if user is allowed move left, false otherwise
		     * displayScreen the screen to show to the user ( user either GuiInterface.STORY_SCREEN or GuiInterface.MAP_SCREEN )
		     * return = the Label on the button the user selected ( the text on the button )
		     */
		 
		 displayInterface.setUserDisplayMessage("where do you want to move?");
		 String moveDir = displayInterface.getUserMoveAction(true,true,true,true, GuiInterface.MAP_SCREEN);
		 
		 displayInterface.setUserDisplayMessage("You Selected: " + moveDir + " , Select again");
		 //this time down selection is not allowed
		 moveDir = displayInterface.getUserMoveAction(true,true,false,true, GuiInterface.MAP_SCREEN);
		 displayInterface.setUserDisplayMessage("You Selected: " + moveDir + " , Now make a choice");
		 
		 //here is how you can give a list of choices to the user. Max of 5 choices
		 String[] choices = {"Choice1", "Choice2", "Choice3" }; // these will end up being the actual labels on the
		                                                        // buttons that will be presented to the user
		 
		 
		 String userchoice = displayInterface.getUserChoiceAction(choices, GuiInterface.STORY_SCREEN );
		 
		 displayInterface.setUserDisplayMessage("Your Choice was: " + userchoice + " , Now make a battle action");
		 
		 
		 //here is how you ask the user for what battle action they want to make
		 String battleAction = displayInterface.getUserBattleAction();
		 
		 displayInterface.setUserDisplayMessage("Your battle action was: " + battleAction + " , Now click the continue button");
		 
		 String[] choices2 = {"Click to continue"};
		 displayInterface.getUserChoiceAction(choices2, GuiInterface.STORY_SCREEN );
		 
		 
		 //Here is how you Draw onto the background of the story screen
		 //Note: This image will stay here until you clear it
		 //(You must clear it before you draw anything else onto the screen
		 
		 //Display image is just a 2d array of Color objects, you index can be thought of as a "pixel"
		 //in the image, (0,0) is the top left corner of the image
		
		 DisplayImage backgroundImage = new DisplayImage( graphics.getStoryDisplayDimensions() );
		 
		 //Sets a line of color down the left side of the image
	     //any location you do not set as a color will be considered "transparent" 
         //and show what is below it when drawn
		 for(int row = 0; row < backgroundImage.getHeight(); row++)
		             backgroundImage.setColorAt(row,0,Color.CYAN);
		 
		 //here we actually draw the image we created onto the background of the story display
		 graphics.drawImageInBackground(0,0, backgroundImage);
		 
		 
		 displayInterface.setUserDisplayMessage("To draw the forground click the continue button");
		 String[] choices3 = {"Click to continue"};
		 displayInterface.getUserChoiceAction(choices3, GuiInterface.STORY_SCREEN );
		 
		 //Draw to the foreground ( any color set here will be drawn ontop of the background)
         DisplayImage foregroundImage = new DisplayImage( graphics.getStoryDisplayDimensions() );
		 
		 //Sets a line of color along the top of the image
         //any location you do not set as a color will be considered "transparent" 
         //and show what is below it when drawn
		 for(int col = 0; col < foregroundImage.getWidth(); col++)
			            foregroundImage.setColorAt(1,col,Color.YELLOW);
		 
		 graphics.drawImageInForeground(0,0, foregroundImage);
		 
		 displayInterface.setUserDisplayMessage("Click continue to clear the screen");
		 displayInterface.getUserChoiceAction(choices3, GuiInterface.STORY_SCREEN );
		 
		 //here is how you clear everything on the story display
		 graphics.clearStoryDisplay(); // does both foreground and background
		 
		 //Loops now until the user clicks on the exit button
		 displayInterface.setUserDisplayMessage("Click the exit button to shut things down");
		 while(!displayInterface.diduserClickExit())
		   {
            
			 //you could do work with the game here
			 
		   }
	}
}
