/**
 * Used to hold information about a wrong word that was found in the given document
 * 
 * @author Jordan Kidney
 * @version Oct 31, 2011
 */
public class WrongWordFound
{
  /** The line number the wrong word was found on */
  private int line = 0;
  /** the word location in the line of the wrong word */
  private int wordLocation = 0;
  /** the original wrong word that was found */
  private String originalWord = "";
  /** the correct word found in the lookup */
  private String correctWord = "";

  /**
   * Basic constructor to set all information in one step
   * 
   * @param line the line number
   * @param wordLocation the location in the lin of the wrong word
   * @param originalWord the wrong word found
   * @param correctWord the found correct word from the BST lookup
   */
  public WrongWordFound(int line, int wordLocation, String originalWord,
        String correctWord) {
    super();
    this.line = line;
    this.wordLocation = wordLocation;
    this.originalWord = originalWord;
    this.correctWord = correctWord;
   }

  //basic access methods
  public int getLine() { return line; }
  public void setLine(int line) { this.line = line; }
  public int getWordLocation() { return wordLocation; }
  public void setWordLocation(int wordLocation) { this.wordLocation = wordLocation; }
  public String getOriginalWord() { return originalWord; }
  public void setOriginalWord(String originalWord) { this.originalWord = originalWord;}
  public String getCorrectWord() { return correctWord; }
  public void setCorrectWord(String correctWord) { this.correctWord = correctWord; }

  /**
   * Returns a string representation of the object for use to output to the console
   * Example return string: <br>
   * WrongWordFound [line=1, wordLocation=5, originalWord=acheive, correctWord=achieve]
   *
   * @return a string representation of the object
   */
  public String toString() 
  {
    return "WrongWordFound [line=" + line + ", wordLocation=" + wordLocation
            + ", originalWord=" + originalWord + ", correctWord=" + correctWord
            + "]"; 
  }
   /**
    * @return true if the two objects are exactly the same
    */
  public boolean equals(Object arg0) 
  {
    boolean result = false;
    
    if(arg0 instanceof WrongWordFound)
    {
        WrongWordFound comp = (WrongWordFound) arg0;
        
        result = (line == comp.line) &&
                 (wordLocation == comp.wordLocation) && 
                 (originalWord.compareToIgnoreCase(comp.originalWord.trim()) == 0) && 
                 (correctWord.compareToIgnoreCase(comp.correctWord.trim()) == 0);
    }
      
    return result;
  }
}
