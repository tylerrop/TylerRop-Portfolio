import java.util.Scanner;
import parser.*;
/**
 * Opens the game text file and runs the game
 * 
 * @author (Tyler Rop) 
 * @version (version 2)
 */
public class Main
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean end = false;
        Main obj = new Main();

        while(!end)
        {
            //the program is actually run (this method callds the one method in the Main here
            obj.play();

            System.out.println("If you would like to use another file" +
                " to see cellular automata again please press Y");

            String choice = in.nextLine().trim().toUpperCase();

            if(choice.compareTo("Y") != 0)
            {
                System.out.println("Goodbye.");
                end = true; 
            }

        }
    }

    /**
     * - asks the user to enter a file (they can specify a directory if they want to)
     * - if the file is not found then the user will be asked again for a file 
     * - this repeats until the user enters an acceptable file
     */
    public void play() 
    {
        Scanner scan = new Scanner(System.in);
        boolean   legitName = false;
        
        //the user is asked to enter the file they want to play the game with
        System.out.print("\fCellular Automata\n\n" 
            + "Please enter the name of the file you wish to see the demonstration with.\n" 
            +"(You will need to add .txt on the end of the file name)\n"
        );

        //the user is asked to enter a file until an actual file is actually entered
        while(!legitName)
        {
            //the name of the file is scanned in
            String fileName = scan.nextLine();

            //if the file exists then it is passed into the FileInformation stream, a 2d array of Cell objects is made with the info from the file
            try
            {
                //the file name is passed in as a variable to a FileInformation stream 
                FileInformation info = new FileInformation(fileName);

                //gets the entire grid array and returns it and passes it into the constructor
                CellStorage world = new CellStorage(info.getGrid()); 

                //the boolean flag is set to true so that the loop ends and the user is not asked for another file (because a real file has been found)
                legitName = true;

                //the file is printed out for the user to see generation 0
                System.out.println("\fCellular Automata\n\nGeneration: 0\n");
                System.out.print(world);

                //the user is asked to continue
                System.out.println("Press any key to continue");
                scan.nextLine();

                //here the autonoma is displayed for the user showing every generation.
                for(int genCount = 1; genCount <= info.getNumGenerations() ; genCount++)
                {
                    //every cell in the 2d array has it's # of neighbors counted and applied
                    world.neighborCellCount();

                    //the rules that apply to every cell are applied
                    world.applyRules( info.getRule() );

                    //the user is told which generation that they are currently viewing
                    System.out.println("\fCellular Automata\n\nGeneration: " + genCount + "\n");
                    System.out.print(world);

                    //the user is asked to enter a key to see the next generation until their is only 1 generation left
                    if(genCount < info.getNumGenerations())
                    {
                        System.out.println("Press any key to continue");
                        scan.nextLine();
                    }

                    if(genCount == info.getNumGenerations())
                    {
                          System.out.println("This is the last generation.\n");
                    }
                }
             
            }
            //if the file is not found then the thrown exception is caught and the user will be asked again to enter a file name
            catch(Exception e)
            {
                System.out.println("\fCellular Automata\n\nSorry, but we were unable to open the file.\nPlease enter a new file name with '.txt' on the end.");

                legitName = false;
            }
        }
    }
}
