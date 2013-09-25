import java.util.Scanner;
import java.io.*;
import java.awt.Color;
import display.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
/**
 * Runs Troll Hunter so that the user can try to become the ultimate troll slaying badass
 * 
 * @author (Tyler Rop) 
 * @version (version 3)
 */

public class Main
{   
    public static void main(String[] args)throws IOException
    {
        //checks to see if the file is legit 
        boolean check = false;
        
        //the file is tried to be read
        //the user is asked to enter a file for Troll Hunter until there is a perfect file selected
        do
        { 
            //the program tries to read the whole file and see if its perfect
            try
            {
                //instance to read in the file
                control gameControl = new control();

                //the file is read in
                gameControl.start();

                check = true;
            }
            
            //catches all of the exceptions that the system throws when reading the file
            //a terminal window pops up to tell the user that they file is invalid
            catch(Exception ex)
            {
                ex.printStackTrace();

                System.out.println("Please enter a valid file for Troll Hunter, the file you just selected was invalid.");

            }
        }
        while(!check);    

        /*

        //if any of the exceptions below are cought then th loop simply asks
        catch (FileNotFoundException e) 
        {
        }
        catch(InputMismatchException i)
        {
        }

        catch(NoSuchElementException n)
        {
        }
        catch (NullPointerException p)
        {
        }
        catch(Throwable t)
        {
        }
         */

    }
}