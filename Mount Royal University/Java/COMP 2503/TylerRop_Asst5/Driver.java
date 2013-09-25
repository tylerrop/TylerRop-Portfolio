import java.util.ArrayList;
import java.io.*;

public class Driver 
{
	public static void main(String[] args) 
	{
		try
		{
		  SpellChecker checker = new SpellChecker("Sample_Test_Data/WrongWords1.txt");
		  
		  ArrayList<WrongWordFound> result = checker.checkFile("Sample_Test_Data/TestInput1A.txt");
		  
		  for(WrongWordFound found : result)
		  {
			 System.out.println(found);
		  }
		}
		catch(FileNotFoundException fileExcep)
		{
		   System.out.println("Unable to open File: " +  fileExcep.getMessage() );
		   System.out.println("The program will shutdown");
		}
		catch(IOException ioExcep)
		{
		   System.out.println("An unknown I/O error has occurred and the program will shutdown");
		}
		catch(Exception e)
		{
		    System.out.println("An unknown error has occurred and the program will shutdown");
			e.printStackTrace();
		}
	}
}