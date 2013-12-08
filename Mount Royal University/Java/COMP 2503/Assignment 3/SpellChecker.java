import java.util.*;
import java.io.*;
/**
 * SpellChecker
 * 
 * reads through a file to compare correct and the incorret spelling of words. 
 * takes another file and checks the spelling in it with the compaired spellings.
 * 
 * @author (Tyler Rop)
 * 
 * Version (5)
 */

public class SpellChecker 
{
    private Hashtable <Word, ArrayList<Word>> table = new Hashtable <Word, ArrayList<Word>>();         //hastable used to store Word objects
    
    public SpellChecker(String fileName) throws Exception
    {
        //scanner for reading in the .txt file
        Scanner inFile = new Scanner(new File(fileName) );
        
        //stores Word objects
        String words[];

        //reads through 
        readThroughFile(inFile);
    }

    /**
     * readThroughFile
     * 
     * goes through the input file with the provided scanner for the file
     * 
     * @param Scanner inFile - reads through the provided txt file that contains the correct and incorrect spelling for words
     */
    public void readThroughFile(Scanner inFile)
    {
        String readLine;                                //line that is currently being read in by the scanner
        Word pairWord;                                  //word that will be added to the words arraylist as we read through the txt file
        
        //until there is nothing else to read in we go through the entire .txt file
        while( inFile.hasNext() )
        {
            //reading the next line of the file in the right and wrong spelling guide file
            readLine = inFile.nextLine();

            //cutting out all of the individual words from the read in line string and storing them in an array
            String[] cut = readLine.split(" ");

            //getting the incorrect spelling word
            String wrongSpell = cut[0];

            //getting the correct spelling word
            String rightSpell = cut[1];

            //addiong the word to the individual arraylist        
            Word wrongCurr = new Word(wrongSpell, "");

            //arraylist that stores Word objects
            ArrayList<Word> words = new ArrayList<Word>();
            
            //creating a new word that contains the wrong spelling of the word (first) and then the correct spelling of the word
            pairWord = new Word(wrongSpell, rightSpell);

            //adding the Word object to the arraylist
            words.add(pairWord);

            //adding the hashtable
            table.put( wrongCurr, words );
        }
    }

    /**
     * checkFile
     * 
     * adds found wrong words into an arraylist for storage from a txt file
     * 
     * @param String file - the file that is being read through
     */
    public ArrayList<WrongWordFound> checkFile(String file) throws Exception
    {
        //an arraylist that stores all of the found wrong words
        ArrayList<WrongWordFound> foundWrongWords = new ArrayList<WrongWordFound>();
        
        //scanner for reading through the file
        Scanner fScan = new Scanner( new File(file) );
        
        //line number counter
        int lineNum = 1;

        //while theres more in the file to be read
        while( fScan.hasNext() )
        {
            //scanning in the next line and cutting up the seperate words and putting them into an array for easy use
            String line = fScan.nextLine();
            
            //seperating the words in the line/string by spaces and storing them in array
            String words[] = line.split(" ");

            //here we read through the array to go through all of the seperate words 
            for(int i = 0; i < words.length; i++)
            {
                //new word object
                Word newGuy = new Word( words[i], "" );

                //we check to see if this word has been spelt in this incorrect way already
                if( table.containsKey(newGuy)  )
                {
                    //arraylist of all the the incorrect spellings that are the same as this one
                    ArrayList<Word> var = table.get(newGuy);

                    //reading through the var Word arraylist 
                    for(Word curr : var)
                    {
                        //if the wronf word spelling is already in the list we create a new WrongWordFOund and add it the the array list for those objects
                        if( curr.getWrong().equals(words[i]) )
                        {
                            WrongWordFound wrong = new WrongWordFound( lineNum, (i + 1), words[i], curr.getRight() );
                            foundWrongWords.add(wrong);
                        }
                    }
                }               
            }
            
            //line number is increased because we will be reading the next line now because this line has been read
             lineNum++;
        }

        return foundWrongWords;
    }

    public String toString(  ) 
    {
        return "";
    }
}