package com.theodor.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.theodor.app.cards.Card;
import com.theodor.app.cards.CardType;

public class GameLogicTests {
    
    @Test
    public void legalPlacementTest(){
        SolitaireGame game = new SolitaireGame();
        Card card1 = new Card(CardType.HEARTS, 4);
        Card card2 = new Card(CardType.CLUBS, 3);

        assertTrue("Illegal placement", game.isLegalPlacement(card1, card2));
    }

    @Test
    public void illegalPlacementTest(){
        SolitaireGame game = new SolitaireGame();
        Card card1 = new Card(CardType.HEARTS, 4);
        Card card2 = new Card(CardType.HEARTS, 3);

        assertFalse("Legal placement", game.isLegalPlacement(card1, card2));
    }
}
