import gameUtil.*;
import java.util.Stack;
/**
 * stores card objects in a Foundation
 * 
 * @author (Tyler Rop) 
 * @version (2)
 */
public class Foundation
{
    //stores cards for the foundation so that we can access them in a FIFO order
    Stack<Card> foundation = new Stack<Card>();

    //keeps track of if the stack is finished from ace - king and alternating between red and black
    private boolean completed = false;

    /**
     * Constructor for objects of class Foundation
     */
    public Foundation()
    {

    }

    /**
     * addCardToFoundation
     * 
     * takes in a card object and adds it to the stack in the foundation
     * 
     * @param Card aCard - the card to be added to the foundation
     */
    public boolean addCardToFoundation(Card aCard)
    {
        //checks to determine if the card has been added to the stack or not
        boolean added = false;

        //checking to see if the stacks have cards in them
        //if the stack has no card in it and the card is an ace we push it onto the stack
        if(foundation.isEmpty() && aCard.getValue() == Card.ACE)
        {
            //the checker is set to true because we push/add the card onto the stack
            added = true;

            //the card is put onto the stack
            foundation.push(aCard);
        }

        //if the stack is not empty and the card is the same suit as the cards in the stack it is added and 
        //the card's value is 1 larger than the top card on the stack it will be added 
        else if(aCard.getSuit() == foundation.peek().getSuit() && 
                foundation.peek().isSmallerThan(aCard)
               )
        {
            //the checker is set to true because we push/add the card onto the stack
            added = true;

            //the card is put onto the stack
            foundation.push(aCard);
        }

        //the boolean that signifies if the card was added is returned
        return added;
    }

    /**
     * removeCard()
     * 
     * removes a card from a stack
     * 
     * @param no parameters
     */
    public Card removeCard()
    {
        //variable for the card that we want to remove from the stack
        Card removedCard=null;

        //empty faceUp stack, we take a cardfrom facedown, move it to faceup and then remove it from facedown
        if(foundation.isEmpty() )
        {
            //temp card variable
            Card moveCard;

            //getting the top facedown card
            moveCard = foundation.peek();

            //coppying the top facedown card onto the faceup stack to have 1 faceup card now
            foundation.push(moveCard);

            //removing the facedown top card that is on the faceup stack so that we dont have a duplicate card
            foundation.pop();

        }

        //not empty faceup stack
        else if(!foundation.isEmpty() )
        {
            foundation.peek();

            foundation.pop();
        }

        return removedCard;
    }

    /**
     * getTopFoundationCard
     * 
     * peeks at the face up stack and returns the value of the top card as a String
     * 
     * @param no parameters
     */
    public Card getTopFoundationCard()
    {
        //temp card variable
        Card topFace = null;
        
        if( foundation.empty() )
        {
            //we do nothing...
        }
        else
        {
            //we copy the value of the top card
            topFace = foundation.peek();
        }
        
        return topFace;
    }
    
    /**
     * isItEmpty
     * 
     * returns if the foundation is empty or not
     * 
     * @param no param
     */
    public boolean isItEmpty()
    {
        //we get a boolean that determinesif the foundation has cards in it or not
        boolean empty = foundation.empty();
        
        //we return the boolean to be used in conjuction with the board class
        return empty;
        
    }

    public String toString()
    {
        String string = "";
 
        //we checck to see if theres anythig in the foundation
        if(foundation.empty())
        {
            //we print that the foundation is empty
            string+= " Empty";
        }
        else
        {
            //we print the top card of the foundation
            string+= foundation.peek() + " ";
        }

        return string;

    }
}
