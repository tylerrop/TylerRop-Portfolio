package tests;



import junit.framework.TestCase;
import gameUtil.*;
import gameUtil.Card.Suit;

public class TestDeck extends TestCase 
{

	public void test_drawCard_fullDeck()
	{
		Deck cards = new Deck();
		assertNotNull( cards.dealSingleCard()  ); 
	}

	public void test_drawCard_emptyDeck()
	{
		Deck cards = new Deck();

		//deal 52 cards, we should have noe left after this point 
		//in the deck
		for(int count=0; count < 52; count++)
			cards.dealSingleCard();

		assertNull( cards.dealSingleCard()  ); 
	}


	public void test_addCard()
	{
		Deck cards = new Deck();
		Card currentCard = null;

		//deal 52 cards, we should have noe left after this point 
		//in the deck
		for(int count=0; count < 52; count++)
			currentCard = cards.dealSingleCard();

		assertTrue( cards.isEmpty()  ); 

		//add card and verify that the deck is now not empty
		cards.addCard(currentCard);
		assertFalse(cards.isEmpty());
	}

	public void test_isEmpty()
	{
		Deck cards = new Deck();

		assertFalse(cards.isEmpty());
		
		//deal 52 cards, we should have noe left after this point 
		//in the deck
		for(int count=0; count < 52; count++)
			cards.dealSingleCard();

		assertTrue(cards.isEmpty());
	}
	
	public void test_for_noDuplicate_cards_after_create()
	{
		Deck cards = new Deck();
        java.util.Hashtable<String, Card> seenCards = new java.util.Hashtable<String, Card>();
        
        while(!cards.isEmpty())
        {
           Card current = cards.dealSingleCard();
           
           if(seenCards.containsKey(current.toString()))
        	   fail("Duplicate card: " + current);
           else
        	   seenCards.put(current.toString(), current);   
        }	
        
        
	}
}
