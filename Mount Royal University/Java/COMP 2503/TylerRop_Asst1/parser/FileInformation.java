/**
 * This class is used to store and build all information form the starting input file
 * for the basic Cellular Automata simulator
 * @author jkidney
 * @version Sept 14, 2012
 */
package parser;

import java.io.*;
import java.util.*;

public class FileInformation 
{
    private boolean[][] grid; // used to hold alive/empty cells information
    // true = alive, false = dead 

    private ArrayList<Rule> rules = new ArrayList<Rule>(); 
    // stores all rules loaded from the file

    private int numGenerations; // the number of generations to run
    // the simulator for

    /**
     * Basic constructor used to build the input file information
     * @param filename the full path and name of the file to open
     * @throws IOException if any input or output error occurs
     */
    public FileInformation(String filename) throws IOException
    {
        buildInformation(filename);
    }

    /**
     * gets the grid array and passes info from it
     */
    public boolean [][] getGrid()
    {
        return grid;
    }

    /**
     * gets the array list and passes it
     */
    public ArrayList<Rule> getRule()
    {
        return rules;
    }
    
    /**
     * build the input file information
     * @param filename the full path and name of the file to open
     * @throws IOException
     */
    private void buildInformation(String filename) throws IOException
    {
        String line = null;
        int rowSize = 0;
        int colSize = 0;

        Scanner fileIn = new Scanner(new File(filename));

        buildRules(fileIn);

        numGenerations = fileIn.nextInt();
        rowSize = fileIn.nextInt();
        colSize = fileIn.nextInt();
        fileIn.nextLine(); 

        grid = new boolean[rowSize][colSize];

        //need to make new Cell objects here and add them to the grid array as they are read in

        for(int row =0; row < rowSize; row++)
        {
            line = fileIn.nextLine().trim();

            for(int index=0; index < line.length(); index++)
            {
                if(line.charAt(index) == '.') grid[row][index] = false;
                else  grid[row][index] = true;
            }

        }

        fileIn.close();
    }

    public int getNumGenerations()
    {   
        return numGenerations;
    }
    
    /**
     * Builds all the rules based upon the file input
     * @param fileIn the scanner class that is attached to the file
     */
    private void buildRules(Scanner fileIn)
    {
        Rule temp; 
        String line = fileIn.nextLine().trim().toLowerCase();

        while(line.compareTo("#") != 0)
        {
            String[] tokens = line.split(",");

            temp = new Rule();

            //applies to
            if(tokens[0].compareTo("a")==0) temp.setAppliesTo_Alive();
            else  temp.setAppliesTo_Empty();

            //Comparison
            if(tokens[1].compareTo("l")==0) temp.setCompare(Rule.LESS_THEN);
            else if(tokens[1].compareTo("e")==0) temp.setCompare(Rule.EQUALS);
            else if(tokens[1].compareTo("g")==0) temp.setCompare(Rule.GREATER_THEN);

            temp.setNumNeighbors(Integer.parseInt(tokens[2]));
            if(tokens[3].compareTo("a")==0) temp.setAction_Alive();
            else  temp.setAction_Dead();

            rules.add(temp);
            line = fileIn.nextLine().trim().toLowerCase();
        }   
    }

    @Override
    public String toString() 
    {
        String ret = "";    

        for(int row = 0; row < grid.length; row++)
        {
            ret +="|";
            for(int col=0; col < grid[row].length; col++)
                if(grid[row][col]) ret+="*";
                else ret += " ";
            ret += "|\n";
        }

        for(Rule r : rules)
        {
            ret += r + "\n";
        }

        ret += "Num Gen: " + numGenerations + "\n";

        return ret;
    }
}

