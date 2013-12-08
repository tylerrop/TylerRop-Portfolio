/**
 * Ceates an object that stores the correct way to spell a word and an incorrect way to spell a word
 * 
 * @author (Tyler Rop) 
 * @version (3)
 */
public class Word
{
    private String right;           //the correct spelling
    private String wrong;           //the incorrect spelling
    private int a;                  //numerical value of a letter

    /**
     * 
     * Constructor for objects of class Word
     * 
     * @param String wrong - the incorrect spelling for a word
     * @param String right - the correct spelling for a word
     */
    public Word(String wrong, String right)
    {
        //the right and wrong spellings for the words are set to lowercase
        this.wrong = wrong.toLowerCase();
        this.right = right.toLowerCase();
        
        //my student id number is divided with integer devision
        int idNumber = 201520315 % 4;
        
        //alphebetical character value that wil be overidden
        a = 0;
        
        //depending on what the modulose of idNUmber results in, 'a' will have 1 of 4 possible results 
        //(this is done just incase the student id was changed from my own)
        switch(idNumber)
        {
            //no remainder
            case 0:
            a = 33;
            break;

            //remainder of 1
            case 1:
            a = 37;
            break;

            //remainder of 2
            case 2:
            a = 39;
            break;

            //remainder of 3
            case 3:
            a = 41;
            break;
        }
    }

    //setters
    public void setRight(String r)
    {
        right = r;
    }
    public void setWrong(String w)
    {
        wrong = w;
    }

    //getters
    public String getRight()
    {
        return right;
    }
    public String getWrong()
    {
        return wrong;
    }

    @Override
    /**
     * hashCode
     * 
     * creates a code based on ther provided hash in the assignment description
     * 
     */
    public int hashCode()
    {   
        //seperating the spring into individual chars
        char chars[] = wrong.toCharArray();

        //the code
        int key = 0;

        //we read through the wrong words length and will apply the hash formula, the hash is added together as each letter is hashed
        for( int i = 0; i < wrong.length(); i++ )
        {
            //all letters that are not the end letter have their hash value claculated
            if (i != wrong.length())
            {
                key += charValue( chars[i] ) * (int)Math.pow(a, wrong.length() - (i + 1) );
            }
            //the last char is always going to be what it is before it is raised to a power because the power in the formula that it is raised to is 0
            else
            {
                 key += charValue( chars[i] );
            }
        }

        return key;
    }

    /**
     * charValue
     * 
     * returns the numerical value of a character
     * 
     * @param char ch - the character that is to be changed to an integer value
     */
    public int charValue(char ch)
    {
        return ch - 'a';
    }

    /**
     * equals
     * 
     * simply compaires the hash code of one object to the hash code of another object
     * 
     * @param Object one - object that is having it's hash value compaired with
     */
    @Override
    public boolean equals(Object one)
    {
        //if the hash codes are the same or not
        boolean equals = false;
        
        //comparing the hash codes
        if( hashCode() == one.hashCode() )
        {
            //they are the same so the compairson is true
            equals = true;
        }
        
        return equals;
    }
}