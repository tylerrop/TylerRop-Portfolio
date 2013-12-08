import gameUtil.Deck;
import java.util.Scanner;
import java.util.ArrayList;
import gameUtil.*;
import java.util.Stack;

public class Solitaire 
{
    public static void main(String[] args)
    {
        //the stack for cards that have their faces showing
        Stack<Action> actions = new Stack<Action>();

        //deck object used to deal out card objects
        Deck currentDeck = new Deck();

        //keeps the game going until it is false
        boolean keepPlaying = true;

        //the game Board
        Board gameBoard = new Board();

        //scanner to read user input
        Scanner scan = new Scanner(System.in);

        //this boolean tells us that we will be setting up the game Board
        boolean isSettingUp = true;

        //the board is filled with cards from the deck
        gameBoard.fillBoard(currentDeck);

        //the board is printed
        System.out.print(gameBoard);

        //we signal that we are no longer setting up the board any more
        isSettingUp = false;

        //determines if the users input is legit
        boolean inputIsValid = false;

        //determines if a card 
        boolean cardUsed = false;

        //the user is asked to play the game until they signify that they want to exit
        while(keepPlaying == true && gameBoard.gameCompleted() == false)
        {

            System.out.println("\nPlease enter a choice\n");
            System.out.println( "A) Deal a card\n" +
                                "B) Move a dealt card to a pile\n" +
                                "C) Move a dealt card to a foundation\n" +
                                "D) Move a face up card between piles\n" + 
                                "E) Move a card from a pile to a foundation\n" + 
                                "F) Undo previous action\n" +
                                "G) Print out the board\n" +
                                "H) Exit Solitaire\n");

            //we ask the user for input to see what the want to do
            String input = scan.nextLine().trim().toLowerCase(); 

            //we validate the user's input to see if it is useable
            //the user is asked for input until they enter something valid

            //the possible valid inputs are a, b, c, d, e, f, g, h
            String validChoices = "abcdefgh";

            //while the user input is valid
            while(inputIsValid == false)
            {
                //we check if the user has entered a valid choice
                if( validChoices.contains(input) )
                {
                    //input is valid
                    inputIsValid = true;

                }

                //case of non valid input
                else
                {
                    System.out.println("\nIput was not valid. Please enter a valid choice.\n");

                    //we ask the user for input to see what the want to do
                    input = scan.next().trim().toLowerCase();
                }
            }

            //here we call the method that determines what is to be done after the user's input is validated
            switch(input)
            {
                //deal a card
                //finished
                case "a":

                //the card was not used
                cardUsed = false;

                //a card is dealt from the deck
                gameBoard.dealCard(currentDeck);
                //the board is printed for the user to see
                System.out.println("\n" + gameBoard);

                break;

                
                
                
                
                
                //move a delt card to a pile
                //finished
                case "b":

                //the user is asked which pile they want to add the card to
                System.out.println("\n" + gameBoard);

                //if there is a dealt card
                if(gameBoard.getDealtCard() == null)
                {
                    System.out.println("\nThere is no dealt card.\nPlease deal a card first to move a dealt card to a pile.\n");

                }

                //there is a dealt card
                else 
                {
                    //the user is asked which pile they want to move the card to
                    System.out.println("\nEnter the pile number that you would like to add " + gameBoard.getDealtCard() + " to:");

                    //the pile that the card will be added to (we will need to counteract an off by 1 error b/c the pile
                    //numbering starts at 1 instead of 0

                    //counteracting the off by one problem
                    int selectedPile = scan.nextInt() - 1;

                    //if the dealt card can be placed in the users selected pile...
                    if( gameBoard.isPileEmpty(selectedPile) && gameBoard.getDealtCard().getValue() == Card.KING )
                    {
                        //the dealt card is moved to the selected pile
                        gameBoard.addDealtCardToSpecificPile(selectedPile);

                        //thge card is used because we will be putting it in a pile
                        cardUsed = true;

                        //the user 
                        System.out.println("\nThe dealt card was moved to Pile " + (selectedPile+1) + "\n" );

                        //we add the action to the actions stack
                        actions.push( new Action( Action.ActionType.D2P, selectedPile) );

                    }
                    
                    //the pile chosen is not empty and the dealt card can be placed
                    else if( !gameBoard.isPileEmpty(selectedPile) && gameBoard.getDealtCard().isSmallerThanByOne(gameBoard.getTopCardToDisplay(selectedPile)) )
                    {
                        //the dealt card is moved to the selected pile
                        gameBoard.addDealtCardToSpecificPile(selectedPile);

                        //thge card is used because we will be putting it in a pile
                        cardUsed = true;

                        //the user 
                        System.out.println("\nThe dealt card was moved to Pile " + (selectedPile+1) + "\n" );

                        //we add the action to the actions stack
                        actions.push( new Action(Action.ActionType.D2P, selectedPile) );
                    }

                    //the card cant be moved
                    else
                    {
                        System.out.println("\nThat card cannot be placed on that pile legally. Please try something different.\n");

                        cardUsed = false;
                    }
                }

                //the board is printed
                System.out.println(gameBoard);

                break;

                
                
                
                
                
                //move a delt card to a foundation
                //finished
                case "c":

                //the user is asked which pile they want to add the card to
                System.out.println("\n" + gameBoard);

                //check if there is a dealt card
                if(gameBoard.getDealtCard() == null)
                {
                    System.out.println("\nThere is no dealt card.\nPlease deal a card first to move a dealt card to a foundation.\n");

                }
                
                //there is a dealt card
                else 
                {
                    //the user is asked which pile they want to move the card to
                    System.out.println("\nEnter the foundation number that you would like to add " + gameBoard.getDealtCard() + " to:");

                    //the foundation that the card will be added to (we will need to counteract an off by 1 error b/c the pile
                    //numbering starts at 1 instead of 0

                    //counteracting the off by one problem
                    int selected = scan.nextInt() - 1;

                    //if the dealt card can be placed in the users selected foundation...
                    if (gameBoard.isFoundationEmpty(selected) == true && gameBoard.getDealtCard().getValue() == Card.ACE )
                    {
                        //the dealt card is moved to the selected foundation
                        gameBoard.addDealtCardToSpecificFoundation(selected);

                        //thge card is used because we will be putting it in a foundation
                        cardUsed = true;

                        //the user 
                        System.out.println("\nThe dealt card was moved to Foundation " + (selected+1) + "\n" );

                        System.out.println("\n" + gameBoard);

                        //we add the action to the actions stack
                        actions.push( new Action(Action.ActionType.D2F, selected) );
                    }

                    //if the card can be placed while checking all of the placement rules it will be placed there
                    else if( gameBoard.getDealtCard().getValue() == Card.ACE && gameBoard.getDealtCard().getValue() == gameBoard.getFoundationCardToDisplay(selected).getValue()+1
                    && gameBoard.getDealtCard().getSuit() == gameBoard.getFoundationCardToDisplay(selected).getSuit()
                    )
                    {
                        //the dealt card is moved to the selected foundation
                        gameBoard.addDealtCardToSpecificFoundation(selected);

                        //thge card is used because we will be putting it in a foundation
                        cardUsed = true;

                        //the user 
                        System.out.println("\nThe dealt card was moved to Foundation " + (selected+1) + "\n" );

                        System.out.println("\n" + gameBoard);

                        //we add the action to the actions stack
                        actions.push( new Action(Action.ActionType.D2F, selected) );
                    }

                    //if the card cant be moved because of rules
                    else
                    {
                        System.out.println("\nThat card cannot be placed on that foundation legally. Please try something different.\n");

                        //the card was not used
                        cardUsed = false;

                        System.out.println("\n" + gameBoard);
                    }
                }

                break;
                
                
                
                
                

                //move a top card from one pile to another
                //finished
                case "d":

                //user is asked which pile the want to move a top card from
                System.out.println("\nWhich pile would you like to move the top card from?");
                
                //we - 1 because the piles are displayed fo 1 to 7 but are indexed from 0 to 6
                int from = scan.nextInt() - 1;
                
                //the user is shown the card and asked where they want to move it to
                System.out.println("\nWhich pile do you want to move the card " + gameBoard.getTopCardToDisplay(from) + " to?");
                
                //we - 1 because the piles are displayed fo 1 to 7 but are indexed from 0 to 6
                int to = scan.nextInt() - 1;
                
                //the card is moved (if the move is valid)
                gameBoard.moveTopCard(from, to);

                //the dealt card was not used beccause it was not placed anywhere
                cardUsed = false;

                //we add the action to the actions stack
                actions.push( new Action(Action.ActionType.P2P, from, to) );

                //the board is printed out for the user to see the change
                System.out.println(gameBoard);
                
                break;

                
                
                
                
                
                //move a top pile card to a foundation
                //finished
                case "e":

                //user is asked which pile the want to move a top card from
                System.out.println("\nWhich pile would you like to move the top card from?");
                
                //we - 1 because the piles are displayed fo 1 to 7 but are indexed from 0 to 6
                int f = scan.nextInt() - 1;
                
                //the user is shown the card and asked where they want to move it to
                System.out.println("\nWhich foundation do you want to move the card " + gameBoard.getTopCardToDisplay(f) + " to?");
                
                //we - 1 because the piles are displayed fo 1 to 7 but are indexed from 0 to 6
                int t = scan.nextInt() - 1;
                
                //the card is moved (if the move is valid)
                gameBoard.moveFromPileToFoundation(f, t);

                //the dealt card was not used
                cardUsed = false;

                //we add the action to the actions stack
                actions.push( new Action(Action.ActionType.P2F, f, t) );

                //the board is printed out for the user to see the change
                System.out.println(gameBoard);

                break;

                
                
                
                
                //undo
                //finished
                case "f":
                
                //if the user has started to play the game then we continue
                if(!actions.isEmpty())
                {
                    //we get the most recent action and remove it from the stack because we will not need it any more
                    Action undoAction = actions.pop();

                    //we check what type of action that the user perfroemed
                    switch(undoAction.getActionType())
                    {
                        //moved from pile to another pile is reversed
                        case P2P:
                        //move the card back to the stack it came from
                        gameBoard.moveTopCard( undoAction.getTo(), undoAction.getFrom() );
                        
                        //printing the board
                        System.out.println(gameBoard);
                        
                        //informing the user that the card was moved back
                        System.out.println("The card was moved back to the other pile.\n");

                        break;

                        
                        
                        
                        
                        
                        //action dealt card to pile is reversed   
                        case D2P:                        
                        //we get the card from the list and copy it to the temporary varuable
                        Card card = gameBoard.getTopCardToDisplay(undoAction.getTo());

                        //we assign the currently dealt card to a variable
                        Card putBack = gameBoard.getDealtCard();

                        //we add the currently dealt card back to the deck
                        gameBoard.addDealtCardbackToDeck(currentDeck);
                        //gameBoard.addDealtCardbackToDeck(putBack);

                        //we set the dealt card to null now that we have added the copy of it back into the deck
                        gameBoard.setDealtCardToNull(putBack);

                        //we remove the card from the pile
                        gameBoard.removeTopPileCard(undoAction.getTo());
                        //gameBoard.getPList().get(undoAction.getTo()).removeCard(card);
                        
                        //printing out the board
                        System.out.println(gameBoard);

                        //the user is told that the move was undone
                        System.out.println("Your move to the pile was undone.");
                        
                        break;
                        
                        
                        
                        
                        
                        
                        //deck to foundation is reversed    
                        case D2F:
                        //we get the card from the list and copy it to the temporary varuable
                        Card founCard = gameBoard.getFoundationCardToDisplay( undoAction.getTo() );

                        //we assign the currently dealt card to a variable
                        Card founBack = gameBoard.getDealtCard();

                        //we add the currently dealt card back to the deck
                        gameBoard.addDealtCardbackToDeck(currentDeck);
                        //gameBoard.addDealtCardbackToDeck(putBack);

                        //we set the dealt card to null now that we have added the copy of it back into the deck
                        gameBoard.setDealtCardToNull(founBack);

                        //we remove the card from the pile
                        gameBoard.removeTopFoundationCard(undoAction.getTo());
                            
                        //the board is printed
                        System.out.println(gameBoard);

                        //user is told that the move was undone
                        System.out.println("Your move to the foundation was undone");
                        
                        break;
                        
                        
                        
                        
                        
                        
                        //pile to foundation is reversed
                        case P2F:
                        //the card is moved from the foundation back to the pile that it came from originally
                        gameBoard.moveFromFoundationToPile(undoAction.getTo(), undoAction.getFrom() );
                        
                        //the board is printed
                        System.out.println(gameBoard);
                        
                        //the user is told that the undo move happened
                        System.out.println("The card was moved from the foundation back to the pile.\n");
                        
                        break;
                    }
                }
                
                break;

                
                
                
                
                //prints out the board for the user because there is a printing problem with certain methods...
                case "g":
                //print out thge board
                System.out.println(gameBoard);

                break;

                
                
                
                
                //exit game
                case"h":
                System.out.println(gameBoard);

                //exit game by changing the boolean
                keepPlaying = false;
                
                //the user is told that the game hs ended
                System.out.println("\nThank you for playing Klondike Solitaire.\n\nBetter luck next time.");
                
                break;

            }

            
            
            
            
            
            //adding an unused dealt card back to the deck if the card wasnt used
            if(cardUsed == false)
            {
                //if there is a dealt card
                if(gameBoard.getDealtCard() != null)
                {
                    //the card is put back in the deack
                    gameBoard.addDealtCardbackToDeck(currentDeck);
                }
            }
        }

        //if the user has filled all of the foundations up to king then they have won
        if(gameBoard.gameCompleted() == true)
        {
            System.out.println("You won!Congradulations on wasting your time playing this game.\nYou should really stop playing this game...");
        }
    }
}
