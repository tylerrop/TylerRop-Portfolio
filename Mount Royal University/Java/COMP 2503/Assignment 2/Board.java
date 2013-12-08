import gameUtil.*;
import java.util.ArrayList;
/**
 * Stores piles and foundations to use them in the game. The board class uses information from the driver (Solitaire) to take in info about where to move card to and from.
 * 
 * 
 * @author (Tyler Rop) 
 * @version (3)
 */
public class Board
{
    //stores the foundations in an array list
    private ArrayList<Foundation> fList = new ArrayList<Foundation>();

    //stores the piles in an array list
    private ArrayList<Pile> pList = new ArrayList<Pile>();

    //keeps track of the number of completed foundations.
    //once this equals 4 the user will win the game
    private int numCompletedFoundations = 0;

    //reference for a card that can be dealt from the deck
    private Card dCard = null;

    /**
     * Constructor for objects of class Board
     * 
     * no parameters
     */
    public Board()
    {

    }

    /**
     * @fillBoard
     * 
     * fills up the piles with the approriate amount of faceup and facedown cards as according to the game's rules upon start
     * 
     * @param Deck
     */
    public void fillBoard(Deck deck)
    {
        //there will always be 7 piles unless the rules change to have more or less
        int numPiles = 7;

        //here we create all of the piles by instantiating them in individual indexes in the arraylist pList
        for(int index = 0; index < numPiles; index++)
        {
            //create all the new piles
            pList.add( new Pile() );
        }

        //there will always be 4 foundations unless the rules change to have more or less
        int numFoundations = 4;

        //here we create all of the foundations by instantiating them in individual indexes in the arraylist fList
        for(int index = 0; index < numFoundations; index++)
        {
            //create all the new piles
            fList.add( new Foundation() );
        }

        //here we fill up the piles with the appropriate cards
        for(int pileToAddTo = 0; pileToAddTo < pList.size(); pileToAddTo++)
        {
            //we deal the face up cards
            pList.get(pileToAddTo).addCardToFUp( deck.dealSingleCard() , false );
            for(int numFUp = pileToAddTo + 1; numFUp < pList.size(); numFUp++ )
            {
                //we deal the facedown cards
                pList.get(numFUp).addCardToFDown( deck.dealSingleCard() );
            }
        }
    }

    /**
     * dealCard
     * 
     * deals a card to the board
     * 
     * @param Deck
     */
    public Card dealCard(Deck deck)
    {
        //a card is assigned to the dCard memory reference
        dCard = deck.dealSingleCard();

        //the card is returned
        return dCard;

        //the card is not printed here because the default toString method for Board displays the dealt card
    }

    /**
     * getFList
     * 
     * returns the foundation array list so that it can be accessed through other classes
     */
    public ArrayList getFList()
    {
        return fList; 
    }

    /**
     * getPList
     * 
     * returns the foundation arra list so that it can be accessed through other classes
     */
    public ArrayList getPList()
    {
        return pList; 
    }

    /**
     * getDealtCard
     * 
     * returns the dealt card
     * 
     * @param none
     */
    public Card getDealtCard()
    {
        //the dealt card is returned
        return dCard;
    }

    /**
     * setDealtCardToNull
     * 
     * sets the dealt card to null
     * 
     * @param none
     */
    public void setDealtCardToNull(Card card)
    {
        dCard = null;
    }

    /**
     * setDealtCard
     * 
     * sets the dealt card to a specified card calue that is passed in
     * 
     * @param Card card - the value that the dealt card will have
     */
    public Card setDealtCard(Card card)
    {
        //the dealt card is set with the new value
        dCard = card;
        
        return dCard;
    }
    
    /**
     * addDealtCardBackToDeck
     *
     * takes the currentlly dealt card and adds it back into the deck
     * 
     * @param Deck deck - the deck that is passed in from the driver
     *
     */
    public Card addDealtCardbackToDeck(Deck deck)
    {
        //the dealt card is added back into the deck
        deck.addCard(dCard);

        return dCard;
    }

    /**
     * addToSpecificPile
     * 
     * takes a card and adds it to a pile
     * 
     * @param int index represents which pile in the array list that we will be adding the card to
     */
    //public Card addToSpecificPile(int index)

    public boolean addDealtCardToSpecificPile(int to)
    {
        //represents if the card was added or not
        boolean result = false;

        //we check if there is a dealt card that we can put in a pile
        if(dCard != null)
        {
            //we get the dealt card and add it to the specified pile
            if(pList.get(to).addCardToFUp(dCard, false))
            {
                //the card was added
                result = true;
            }
        }

        //the dealt card is set to null because there is no dealt card now
        dCard = null;

        return result;
    }

    /**
     * moveTopCard
     * 
     * takes a faceup card from the top of one pile and moves it to another pile
     * 
     * @param Card     - the card being moved
     * @param int from - the original pile index that we will be moving the card from
     * @param int to   - the pile index that we will be moving the card to
     */
    public boolean moveTopCard(int from, int to)
    {
        //represents if the card was added or not
        boolean result = false;

        //we make sure that we can get a face up card from the pile
        if(pList.get(from).isTheFaceUpStackEmpty() == false )
        {
            //we get the top card from the pile and store it in a temporary variable
            Card card = pList.get(from).getTopFaceUpValue();

            //if we got the card
            if(card != null)
            {
                //we put the card into the new pile
                if(pList.get(to).addCardToFUp(card, false))
                {
                    //we remove the card from the pile it was taken from
                    pList.get(from).removeCard();
                    
                    //the card was added
                    result = true;
                }
            }
        }

        return result;
    }

    /**
     * getTopCardToDisplay
     * 
     * gets a top card value from an index's pile and returns it
     * 
     * @param int index - the pile # in the array list that we are going to return the top card from
     */
    public Card getTopCardToDisplay(int index)
    {
        //we copy the top card from the pile and return it
        Card card = pList.get(index).getTopFaceUpValue();

        return card;
    }

    /**
     * isPileEmpty
     * 
     * returns true if the pile's face up stack is empty
     * 
     * @param int num - the pile that we are checking
     */
    public boolean isPileEmpty(int num)
    {
        //empty variable
        boolean empty = true;

        //we get the boolean for the foundation
        empty = pList.get(num).isTheFaceUpStackEmpty();   

        //we return the boolean to use in the main
        return empty;

    }
    
    /**
     * removeTopPileCard
     * 
     * removes the top card from a pile
     * 
     * @param int i - the pile that we are removing the top card from
     */
    public Card removeTopPileCard(int i)
    {
        //removing the card
        Card card = pList.get(i).removeCard();
        
        return card;
        
    }

    
    
    
    //foundation methods below
    
    
    
    
    /**
     * addToSpecificFoundation
     * 
     * takes a card and adds it to a foundation
     * 
     * @param Card
     * @param int index represents which foundation in the array list that we will be adding the card to
     */
    public boolean addDealtCardToSpecificFoundation(int to)
    {
        //if the card will be added or not
        boolean result = false;

        //we made sure that there is a dealt card
        if(dCard != null)
        {
            //adding the dealt card to the foundation
            if( fList.get(to).addCardToFoundation(dCard) )
            {
                //if the card was added (by fitting the rule requirements) this is true
                result = true;
            }
        }

        //the dealt card is blanked out
        dCard = null;

        return result;
    }

    /**
     * getFoundationCardToDisplay
     * 
     * gets a top card value from an index's foundation and returns it
     * 
     * @param int index - the foundation in the array list that we are getting the top card from
     */
    public Card getFoundationCardToDisplay(int index)
    {
        //we get the to card so that we can display it   
        Card fCard = fList.get(index).getTopFoundationCard();

        return fCard;
    }

    /**
     * isFoundationEmpty
     * 
     * returns if the foundation is empty or not
     * 
     * @param int num - the foundation that we are checking
     */
    public boolean isFoundationEmpty(int num)
    {
        //empty variable
        boolean empty = true;

        //we get the boolean for the foundation
        empty = fList.get(num).isItEmpty();   

        //we return the boolean to use in the main
        return empty;
    }
    
    /**
     * removeTopFoundationCard
     * 
     * removes the top card from a foundation
     * 
     * @param int i - the foundation that we are removing the top card from
     */
    public Card removeTopFoundationCard(int i)
    {
        //removing the card from the specified foundation
        Card card = fList.get(i).removeCard();
        
        return card;
    }

    
    
    
    //pile + foundation methods
    
    
    
    
    /**
     * moveFromPileToFoundation
     * 
     * takes the top card from a nubered pile and moves it to a foundation if the rule is valid
     * 
     * @param int from - the pile # that we will take the card from
     * @param int to   - the foundation # that we will add the card to 
     */
    public boolean moveFromPileToFoundation(int from, int to)
    {
        //if the card was moved or not
        boolean moved = false;

        //check to seee if there is a card that we can move from the pile that the user selected
        if( pList.get(from).isTheFaceUpStackEmpty() == false )
        {
            //the card is copied to a temp variable and removed from the pile
            Card c1 = pList.get(from).getTopFaceUpValue();

            //we add the card to the foundation if the rules allow us to
            //if the foundation is emty and the card is an ace we add it
            if( fList.get(to).isItEmpty() == true && c1.getValue() == Card.ACE 
            )
            {
                //the card was moved
                moved = true;

                //the card is deleted from the pile it came from
                pList.get(from).removeCard();

                //the card is actually added to the foundation
                fList.get(to).addCardToFoundation(c1);
            }

            //if the foundation is not empty but the cards suit is the same as that of the foundation 
            //and the vaue of the card is +1 than the top foundation card we add it to the foundation 
            else if( fList.get(to).isItEmpty() == false && 
            c1.getSuit() == fList.get(to).getTopFoundationCard().getSuit() && 
            c1.getValue() == fList.get(to).getTopFoundationCard().getValue()+1  
            )
            {
                //the card was moved
                moved = true;

                //the card is deleted from the pile it came from
                pList.get(from).removeCard();
 
                //the card is actually added to the foundation
                fList.get(to).addCardToFoundation(c1);   
            }
            
            //the card is not movable
            else
            {
                //the card was not moved
                moved = false;
            }
        }

        return moved;
    }

    /**
     * moveFromFoundationToPile
     * 
     * takes the top card from a nubered pile and moves it to a foundation if the rule is valid.
     * used to undo moving a card from a pile to a foundation.
     * 
     * @param int from - the foundation that we will take the card from
     * @param int to   - the pile that we will move the pile to
     */
    public boolean moveFromFoundationToPile(int from, int to)
    {
        //card moved variable
        boolean moved = false;

        //check to seee if there is a card that we can move from the foundation that the user selected
        //if the foundation is not empty then we go into the next if
        if( fList.get(from).isItEmpty() == false )
        {
            //the card is copied to a temp variable from the foundation
            Card c1 = fList.get(from).getTopFoundationCard();

            //we add the card to the foundation if the rules allow us to
            //if the foundation is emty and the card is an king we add it

            //if the pile is not compltely empty but the cards suit is the oppossite as that of the foundation 
            //and the vaue of the card is +1 than the top foundation card we add it to the foundation 
            if( pList.get(to).isTheFaceUpStackEmpty() == false &&
                c1.isOppositeSuit( pList.get(to).getTopFaceUpValue() ) &&
                c1.isSmallerThanByOne( pList.get(to).getTopFaceUpValue() )    
              )
            {
                //the card was moved
                moved = true;

                //the card is removed from the foundation
                fList.get(from).removeCard();

                //the card is actually added to the faceup stack in the pile
                pList.get(to).addCardToFUp(c1, false);   
            }
            
            //if the face up stack is empty, the card has to be a king to be placed
            else if( pList.get(to).isTheFaceUpStackEmpty() == true && 
                     c1.getValue() == Card.KING 
                   )
            {
                //the card was moved
                moved = true;

                //the card is removed from the foundation
                fList.get(from).removeCard();

                //the card is actually added to the faceup stack in the pile
                pList.get(to).addCardToFUp(c1, false);

            }

            //the card was not moved
            else
            {
                moved = false;
            }
        }

        return moved;
    }

    /**
     * wonGame
     * 
     * counts the number of finished foundations. if there are 4 then te user wins the game!
     * 
     * @param no parameters
     */
    public boolean gameCompleted()
    {
        //has the user won the game
        boolean gameWon = false;

        //we read throough all of the foundations
        for(int i = 0; i < fList.size(); i++)
        {
            //if there is a card on the foundation
            if(fList.get(i).getTopFoundationCard() != null)
            {
                //if the card is a king (then the foundation is completed)
                if(fList.get(i).getTopFoundationCard().getValue() == Card.KING)
                {
                    //the # of completed foundations
                    numCompletedFoundations = numCompletedFoundations + 1;

                    //if all of the foundations are completed the user wins
                    if(numCompletedFoundations == 4)
                    {
                        gameWon = true;
                    }
                }
            }
        }

        return gameWon;
    }
    
    
    
    
    
    //testing related methods

    
    
    
    
    /**
     * accessPlIST
     * 
     * allows the array list plist to accessed
     * 
     * @param no parameters
     */
    public ArrayList<Pile> accessPList()
    {
        return pList;
    }

    /**
     * accessFlIST
     * 
     * allows the array list fList to accessed
     * 
     * @param no parameters
     */
    public ArrayList<Foundation> accessFList()
    {
        return fList;
    }
    
    public String toString()
    {
        //the string that we will use to print our the board

        String string ="\n--------------------------------------------------\n";
        string += "Foundations\n";

        //we loop through the foundation array list to access the elements at each index and print them out
        for(int i = 0; i < fList.size(); i++)
        {
            //we add the element to the total string to be printed
            string+= (i + 1) + ")" + fList.get(i) + "   ";
        }

        string+="\n--------------------------------------------------\n";

        //we loop through the pile array list to access the elements at each index and print them out
        for(int i = 0; i < pList.size(); i++)
        {
            //we add the element to the total string to be printed
            string+= "Pile: " + (i + 1) + ") " + pList.get(i) + "\n\n";
        }

        string+="--------------------------------------------------\n";

        string+= "Dealt Card: ";

        //we print the dealt card
        if(dCard == null)
        {
            string+= "None";
        }

        else
        {
            string+= dCard;
        }

        string+="\n--------------------------------------------------\n";

        //the string is returned
        return string;
    }
}

