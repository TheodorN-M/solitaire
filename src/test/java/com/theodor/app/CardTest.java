package com.theodor.app;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardTest {
    
    @Test
    public void testEqualsMethod(){
        Card card = new Card(CardColor.CLUBS, 3);
        Card otherCard = new Card(CardColor.CLUBS, 3);

        assertTrue("Cards were not the same", card.equals(otherCard));
    }
    @Test
    public void testEqualsMethod2(){
        Card card = new Card(CardColor.CLUBS, 3);
        Card otherCard = new Card(CardColor.HEARTS, 11);

        assertFalse("Cards were the same", card.equals(otherCard));
    }

    @Test
    public void testEqualsMethod3(){
        Card card = new Card(CardColor.CLUBS, 3);
        Card otherCard = new Card(CardColor.HEARTS, 3);

        assertFalse("Cards were the same", card.equals(otherCard));
    }
}
