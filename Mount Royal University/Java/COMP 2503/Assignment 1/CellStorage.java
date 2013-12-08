import parser.*;
import java.util.*;
/**
 * Stores cell objects in a 2d array
 * 
 * @author (Tyler Rop) 
 * @version (version 3)
 */
public class CellStorage
{
    //2d array that holds Cell objects
    private Cell [][] cellStorage;

    /**
     * Constructor for objects of class CellStorage]
     * 
     * copies the booleans from the 2d boolean array in FileInformation and makes Cell objects and puts them in a new 2d Cell array of the same size
     * 
     * @param boolean grid[][] array from FoleInformation
     * 
     */
    public CellStorage(boolean grid[][])
    {
        //setting up the number of rows and collumns in a new 2d array of cell objects (the same size as the boolean 2d array)
        cellStorage = new Cell[grid.length][grid[0].length];

        //reading though thr boolean Grid array to make the new Cell 2d array
        for(int rowNum = 0; rowNum < grid.length; rowNum++)
        {
            for(int colNum = 0; colNum < grid[rowNum].length; colNum++)
            {
                //creates Cells in in the cell storage array
                cellStorage[rowNum][colNum] = new Cell(grid[rowNum][colNum], rowNum, colNum);
            }
        }
    }

    /**
     * checks the cells position in the 2d array cellStorage
     * if the cell is out of bounds then of the 2d array it is set as dead
     * 
     * @param int int
     */
    public boolean checkLocation(int row, int col)
    {
        //living state of the cell
        boolean ret = true;

        //checking to see if the cell is within the array
        if( (row < 0 || row >= cellStorage.length) || (col < 0 || col >= cellStorage[0].length))
        {
            //the cell is out of the horizontal bounds so it is set as dead
            ret = false;
        }
        else
        {
            //we get the cells pre-defined state because it is in bounds
            ret = cellStorage[row][col].getAlive();
        }

        //we pass on the cell's living state
        return ret;
    }

    /**
     * takes in the current row and collumn of a cell that we're are checking and checks for 
     * living cells around the cell we are checking (depends on the checkLocation method to determine if a cell is in or out of bounds).
     * 
     * @param Cell
     */
    public void neighborCheck(Cell c)
    {
        //# of neighbors around the cell that we are checking
        int count = 0;

        //the row of the cell that we are checking
        int row = c.getRow();

        //the col of the cell that we are checking
        int col = c.getCol();

        //here we check all of the positions around the cell to check for the number of living neighbors

        //above and to the left of the cell
        if(checkLocation(row - 1, col - 1) )
        {
            //# of neighbors is increased by 1
            count++;
        }

        //directly above the cell
        if(checkLocation(row - 1, col))
        {
            //# of neighbors is increased by 1
            count++;
        }

        //above and to the right of the cell
        if(checkLocation(row - 1, col + 1))
        {
            //# of neighbors is increased by 1
            count++;
        }

        //to the right of the cell
        if(checkLocation(row, col + 1))
        {
            //# of neighbors is increased by 1
            count++;
        }

        //to the left of the cell
        if(checkLocation(row, col - 1))
        {
            //# of neighbors is increased by 1
            count++;
        }

        //below and to the right of the cell
        if(checkLocation(row + 1,col + 1))
        {
            //# of neighbors is increased by 1
            count++;
        }

        //below the cell
        if(checkLocation(row + 1, col))
        {
            //# of neighbors is increased by 1
            count++;
        }

        //below and to the left
        if(checkLocation(row + 1,col - 1))
        {
            //# of neighbors is increased by 1
            count++;
        }

        //here we set the number of neighbors that the individual cell c has
        c.setNumN(count);
    }

    /**
     * counts the number of neighbors that a cell has and sets it in the cell
     * relies on the neighborCheck method to work
     * 
     * @param - no parameters
     */
    public void neighborCellCount()
    {
        //number of neighbors that the cell has
        int nCount = 0;

        //we read through the 2d cell array and sets the number of neighbors that the cell has 
        for(int rowNum = 0; rowNum < cellStorage.length; rowNum++)
        {
            for(int colNum = 0; colNum < cellStorage[rowNum].length; colNum++)
            {
                //counds the number of living neighbors and sets it in the cell
                neighborCheck(cellStorage[rowNum][colNum]);  
            }
        }
    }

    /**
     * returns the number of neighbors that a specific cell in a certain location in the cellStorage 2d array has
     * 
     * @param int, int
     */

    public int getCellAtXYNumNeighbors(int row, int col)
    {
        //row #
        int x = row;

        //col #
        int y = col;

        //number of neighbors that a cell has
        int numNeighbors;

        //getting the number of number from a cell in a certain spot in the 2d array
        numNeighbors = cellStorage[x][y].getNumN();  

        return numNeighbors;
    }

    /**
     * reads through the entire cell 2d array and applis the rules that are appropriate for every cell
     * 
     * @param ArrayList of Rules
     * 
     */

    public void applyRules(ArrayList<Rule> rules)

    {
        //reading through the 2d array of cell objects
        for(int rowNum = 0; rowNum < cellStorage.length; rowNum++)
        {
            for(int colNum = 0; colNum < cellStorage[rowNum].length; colNum++)
            {
                //here we loop through the rules array to check for applicable rules
                for(int counter = 0; counter < rules.size(); counter++)
                {
                    //here we see if a cell is living. if it is and the rule
                    Rule r = rules.get(counter);
                    //&& applies to living cell, 1?
                    //checks to see if the cell is alive or dead and if there is a rule that applies to the living or dead cell
                    if (checkLocation(rowNum, colNum) == r.getAppliesTo())
                    {
                        //if the rule applies to the to type of cell (0)
                        if(r.getCompare() == Rule.EQUALS)
                        {
                            //if the # of neighbors for the cell equals the amount that the rule requires, then we set the rules action
                            if(getCellAtXYNumNeighbors(rowNum, colNum) == r.getNumNeighbors())
                            {
                                cellStorage[rowNum][colNum].setAlive( r.getAction()   );
                                break;
                            }
                        }

                        //if the rule applies to the to type of cell (-1)
                        else if(r.getCompare() == Rule.LESS_THEN)
                        {
                            if(getCellAtXYNumNeighbors(rowNum, colNum) < r.getNumNeighbors())
                            {
                                cellStorage[rowNum][colNum].setAlive( r.getAction()   );
                                break;
                            }
                        }

                        //if the rule applies to the to type of cell (+1)
                        else if(r.getCompare() == Rule.GREATER_THEN)
                        {
                            if(getCellAtXYNumNeighbors(rowNum, colNum) > r.getNumNeighbors())
                            {
                                cellStorage[rowNum][colNum].setAlive( r.getAction()   );
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * toString method that prints the cellStorage 2d array in an easey to view format
     */
    public String toString()
    {
        String ret = "";    

        for(int row = 0; row < cellStorage.length; row++)
        {
            //here a left border is printed
            ret +="|";
            for(int col=0; col < cellStorage[row].length; col++)
                //if the cell is alive then a star is printed
                if(cellStorage[row][col].getAlive()) ret+="*";
                
                //dead cells are printed simply as spaces
                else ret += " ";
                
            //the right border is printed and a spacing line to improve readability
            ret += "|\n\n";
        }

        return ret;
    }
}