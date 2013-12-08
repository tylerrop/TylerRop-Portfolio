package tests;

import junit.framework.TestCase;
import gameUtil.*;
import gameUtil.Card.Suit;

public class TestCard extends TestCase 
{

	/**
	 * Test to make sure that the display string is proper for
	 * different card configurations
	 */
	public void test_cardDisplayString()
	{
		Card testCard = new Card(Card.Suit.HEARTS,7); 
		assertEquals(" 7H", testCard.toString());
		
		testCard = new Card(Card.Suit.CLUBS,Card.ACE); 
		assertEquals(" AC", testCard.toString());
		
		testCard = new Card(Card.Suit.CLUBS,Card.JACK); 
		assertEquals(" JC", testCard.toString());
		
		testCard = new Card(Card.Suit.CLUBS,Card.QUEEN); 
		assertEquals(" QC", testCard.toString());
		
		testCard = new Card(Card.Suit.CLUBS,Card.KING); 
		assertEquals(" KC", testCard.toString());
	}
	
	public void test_isSmallerThan()
	{
	 Card card1 = new Card(Card.Suit.DIAMONDS, 7);	
	 Card card2 = new Card(Card.Suit.DIAMONDS, Card.JACK);
	 Card card3 = new Card(Card.Suit.DIAMONDS, Card.ACE);
	 
	 assertTrue(card1.isSmallerThan(card2));
	 assertFalse(card1.isSmallerThan(card3));
	}
	
	
	public void test_isSmallerThanByOne()
	{
	 Card card1 = new Card(Card.Suit.DIAMONDS, 7);	
	 Card card2 = new Card(Card.Suit.DIAMONDS, 8);
	 Card card3 = new Card(Card.Suit.DIAMONDS, Card.ACE);
	 
	 assertTrue(card1.isSmallerThanByOne(card2));
	 assertFalse(card1.isSmallerThanByOne(card3));
	}
	
	public void test_isOppositeSuit()
	{
	 Card card1 = new Card(Card.Suit.DIAMONDS, 7);	
	 Card card2 = new Card(Card.Suit.HEARTS, 8);
	 Card card3 = new Card(Card.Suit.CLUBS, 2);
	 Card card4 = new Card(Card.Suit.SPADES, 3);
	 
	 assertFalse(card1.isOppositeSuit(card2));
	 assertTrue(card1.isOppositeSuit(card3));
	 assertTrue(card1.isOppositeSuit(card4));
	
	}
	
}
