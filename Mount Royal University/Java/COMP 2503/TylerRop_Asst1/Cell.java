
/**
 * Creates a cell object
 * 
 * @author (Tyler Rop) 
 * @version (version 2)
 */
public class Cell
{
    //living or dead boolean
    private boolean alive;
    
    //# of neighbors
    private int numN;
    
    //row number locatation
    private int row;
    
    //collumn location
    private int col;

    /**
     * Constructor for objects of class Cell
     * 
     * Creates a new Cell with specific information
     * 
     * @param boolean, int, int
     */
    public Cell(boolean alive, int row, int col)
    {
        this.alive = alive;
        this.row = row;
        this.col = col;
    }

    //boolean state setter and getter
    public boolean getAlive()
    {
        return alive;
    }
    public boolean setAlive(boolean state)
    {
        alive = state;
        
        return alive;
    }
    
    
    //number of neighbors (numN) setter and getter
    public int getNumN()
    {
        return numN;
    }
    public int setNumN(int neighbors)
    {
        numN = neighbors;
        
        return numN;
    }
    
    //the cells row in the 2d array setter and getter
    public int getRow()
    {
        return row;
    }
    public int setRow(int thisRow)
    {
        row = thisRow;
        
        return row;
    }

    //the cells collumn in the 2d array setter and getter
    public int getCol()
    {
        return col;
    }
    public int setCol(int thisCol)
    {
        col = thisCol;
        
        return col;
    }
}
