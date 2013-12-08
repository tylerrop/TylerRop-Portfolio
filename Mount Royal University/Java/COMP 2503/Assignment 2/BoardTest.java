import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import gameUtil.*;
import java.util.*;

/**
 * The test class BoardTest.
 *
 * @author  (Tyler Rop)
 * @version (1)
 */
public class BoardTest
{
    private Deck deck = new Deck();

    private Board board = new Board();

    private Pile pile1 = new Pile();

    private Pile pile2 = new Pile();
    
    private Pile pile3 = new Pile();
    
    private Foundation foundation1 = new Foundation();
    
    //stores the piles in an array list
    private ArrayList<Pile> pList = new ArrayList<Pile>();
    
    private ArrayList<Foundation> fList = new ArrayList<Foundation>();
        
 

    /**
     * Default constructor for test class BoardTest
     */
    public BoardTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void add_dealt_card_to_a_pile()
    {
        //we deal a card and store it in a variable
        Card c1 = deck.dealSingleCard();

        //we add that variable vard to the pile
        pile1.addCardToFUp(c1, false);

        //we see if the card added is added and is the same card as our variable card
        assertEquals(pile1.getTopFaceUpValue(), c1);

    }

    @Test
    public void move_card_from_one_pile_to_another()
    {   
        //card 1 is the card that we will be moving from one pile to another
        //originally we get the card from pile 1
        Card c1 = new Card(Card.Suit.SPADES, 4);

        //this card gets put in pile 2, we will be putting the c1 card on top of it
        Card c2 = new Card (Card.Suit.HEARTS, 5);

        //we add the piles to the board
        board.accessPList().add(0, pile1);
        board.accessPList().add(1, pile2);
        
        //we add c1 to pile 1 
        board.accessPList().get(0).addCardToFUp(c1,false);
        //pile1.addCardToFUp(c1, false);

        //we add c2 to pile 2
        board.accessPList().get(1).addCardToFUp(c2,false);
        //pile2.addCardToFUp(c2, false);
  
        //the card is moved
        board.moveTopCard(0, 1);

        //we see if the card added is added and is the same card as our variable card
        //assertEquals(pList.get(1).getTopFaceUpValue(), c1 );
        assertEquals(board.accessPList().get(1).getTopFaceUpValue(), c1);

    }

    @Test
    public void move_card_from_a_pile_to_a_foundation()
    {
        //card 1 is the card that we will be moving from the pile
        //originally we get the card from pile 1
        Card ace = new Card(Card.Suit.HEARTS, Card.ACE);


        //we add the piles to the board
        board.accessPList().add(0, pile3);
        board.accessFList().add(0, foundation1);
        
        //we add the  to pile 1 
        board.accessPList().get(0).addCardToFUp(ace,true);
        //this might not work because the card needs to be a king to be added 
  
        //the card is moved
        board.moveFromPileToFoundation( 0, 0);

        //we see if the card added is added and is the same card as our variable card
        //assertEquals(pList.get(1).getTopFaceUpValue(), c1 );
        assertEquals(board.accessFList().get(0).getTopFoundationCard(), ace);

    }
}
