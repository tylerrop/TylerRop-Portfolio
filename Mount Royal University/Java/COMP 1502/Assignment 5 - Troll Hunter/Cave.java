import java.awt.Color;
import display.*;

/**
 * Base class for all caves in the game, you can change and add to this class as you see fit
 * @author jkidney
 * @version March 21, 2012
 */


public abstract class Cave 
{

    //row that the cave is in
    private int row;

    //collumn that the cave is in
    private int collumn;
    
    /**
     * Cave Contructor
     * reads in the caves row and collimn information
     */

    public Cave(int row, int collumn)
    {
        this.row = row;
        
        this.collumn = collumn;
    }
    
    /**
     * Method - setUser
     * sets a hero object in a cave (when used by the child cave classes)
     */
    public abstract void setUser(hero hero);
    
    /**
     * Method - getMapCaveColor();
     * sets the color that the cave will be displayed as on the map
     */
    public abstract Color getMapCaveColor();

    /**
     * Method - drawCave
     * draws the contents of the cave for the user to see
     */
    public abstract void drawCave(DisplayGraphics graphics);

    /**
     * Method - executeUserInteraction
     * 
     * handles the actions that the user selects
     */
    public void executeUserInteraction(GuiInterface display)
    {
    }
}
