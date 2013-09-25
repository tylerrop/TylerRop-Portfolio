import gameUtil.*;
import java.util.Stack;
/**
 * Creates stacks of card objects in a pile format. This is used to represent a pile in the game of solitaire.
 * 
 * @author (Tyler Rop) 
 * @version (3)
 */
public class Pile
{
    //stores face up cards that are in the pile
    Stack<Card> faceUp = new Stack<Card>();

    //stores face down card that are in the pile
    Stack<Card> faceDown = new Stack<Card>();

    /**
     * Constructor for objects of class Pile
     * 
     * no parameters
     * 
     */
    public Pile()
    {

    }

    /**
     * addCardToFUp
     * 
     * takes in a card object and adds it to the stack in the pile that stores the face up cards
     * 
     * @param Card aCard - the card that will be added
     * @param boolean settingUpBoard - determines if the board has be dealt out or not yet
     */
    public boolean addCardToFUp(Card aCard, boolean settingUpBoard)
    {
        //checks to determine if the card has been added to the face up stack or not
        boolean added = false;

        //if the faceUp stack is empty then we will add the card to it
        if(faceUp.isEmpty())
        {
            //the checker is set to true because we push/add the card onto the stack
            added = true;

            //the card is put onto the face up stack
            faceUp.push(aCard);
        }

        //this is when we add a card after the board has been dealt out. the card has to be a king to be placed on an empty pile
        else if(faceUp.isEmpty() && aCard.getValue() == Card.KING && settingUpBoard == false)
        {
            //the checker is set to true because we push/add the card onto the stack
            added = true;

            //the card is put onto the face up stack
            faceUp.push(aCard);
        }

        //here we add a faceUp card to the faceup stack (when the stack is not empty)
        //we check to see is the card has the opposite suit of the top card on the face up stack.
        //if the card has the opposite suit and is 1 smaller then we add it to the faceup stack
        else if(aCard.isOppositeSuit(faceUp.peek()) && aCard.isSmallerThanByOne(faceUp.peek()))
        {
            //the checker is set to true because we push/add the card onto the stack
            added = true;

            //the card is put onto the face up stack
            faceUp.push(aCard);
        }

        //the boolean that signifies if the card was added is returned
        return added;
    }

    /**
     * addCardToFaceDown
     * 
     * takes in a card object and adds it to the stack in the pile that stores the face down cards
     * 
     * @param Card aCard - the card to be added to the facedown stack
     */
    public Card addCardToFDown(Card aCard)
    {
        //the card is simply added to the face down stack, checking of card values or suits isnt required
        faceDown.push(aCard);

        //the card is returned
        return aCard;
    }

    /**
     * removeCard()
     * 
     * removes a card from a stack
     */
    public Card removeCard()
    {
        //variable for the card that we want to remove from the stack
        Card removedCard=null;

        //if the faceUp stack is empty we take a cardfrom facedown, 
        //move it to faceup and then remove it from facedown so that a card can be removed
        if(faceUp.isEmpty() && !faceDown.isEmpty() )
        {
            //coppying the top facedown card onto the faceup stack to have 1 faceup card now
            faceUp.push(faceDown.pop());
        }

        //if the faceUp stack has a card in it then we remove that card
        //(or simply the top card that is faceup if there is more than 1 faceup card)
        else if(!faceUp.isEmpty() )
        {
            //removedCard = faceDown.pop();
            removedCard = faceUp.pop();
        }

        //the card that we removed from one of the stacks is retunred
        return removedCard;
    }

    /**
     * getTopFaceUpValue
     * 
     * peeks at the face up stack and returns the value of the top card
     * 
     * @param no parameters
     */
    public Card getTopFaceUpValue()
    {
        //temp. variable for a card
        Card topFace = null;

        //we check to see if there is a card to peek at in the stack
        if(faceUp.empty() == false)
        {
            //we copy the cards value by peeking on the stack
            topFace = faceUp.peek();

        }

        //there is no card in the stack, so we return null
        else
        {
            topFace = null;
        }
        
        //the top card's values are returned
        return topFace;
    }

    /**
     * isTheFaceUpStackEmpty
     * 
     * checks to see if the facce up stack in the pile is empty
     * @param no param
     */
    public boolean isTheFaceUpStackEmpty()
    {
        //stack is empty or not
        boolean empty = false;

        //we check to see if the face up stack is empty
        if(faceUp.empty() == true)
        {
            //its empty 
            empty = true;
        }
        else
        {
            //its not empty
            empty = false;
        }

        return empty;
    }

    /**
     * isTheFaceDownStackEmpty
     * 
     * checks to see if the face down stack in the pile is empty
     * @param no param
     */
    public boolean isTheFaceDownStackEmpty()
    {
        //is the stack empty or not?
        boolean empty = false;

        //we check to see if the face down stack is empty
        if(faceDown.empty() == true)
        {
            //its empty
            empty = true;
        }
        else
        {
            //its not empty
            empty = false;
        }

        return empty;
    }

    /**
     * toString
     * 
     * overides default Pile toString method and displays the top upturned card and the # of facedown cards
     * 
     * @param no parameters
     */
    public String toString()
    {
        //the string to be returned that displays the top fUp card and the # of facedown cards in the pile

        String string = "";

        //check if there is anything in the stack
        if(faceUp.empty() == true)
        {

            string += " No Face Up Card(s) ";

            //ceck the face down stack to see if theres cards
            if(faceDown.empty() == false)
            {
                //if there are cards we print out how many there are
                string += "(" + faceDown.size() + ")";
            }
            else
            {
                //there aint no damn face down cards
                string+= "  No Face Down Card(s)"; 
            }
        }
        
        //there are cards in both stack so we print them out
        else
        {
            string+= faceUp.peek() + "(" + faceDown.size() + ")";
        }

        //the string is returned
        return string;
    }
}