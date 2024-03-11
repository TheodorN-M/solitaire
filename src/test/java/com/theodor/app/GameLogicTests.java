package com.theodor.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.theodor.app.cards.Card;
import com.theodor.app.cards.CardSuit;
import com.theodor.app.grid.CellPosition;

public class GameLogicTests {
    
    @Test
    public void legalPlacementTest(){
        SolitaireGame game = new SolitaireGame();
        Card card1 = new Card(CardSuit.HEARTS, 4);
        Card card2 = new Card(CardSuit.CLUBS, 3);

        assertTrue("Illegal placement", game.isLegalPlacement(card1, card2));
    }

    @Test
    public void illegalPlacementTest(){
        SolitaireGame game = new SolitaireGame();
        Card card1 = new Card(CardSuit.HEARTS, 4);
        Card card2 = new Card(CardSuit.HEARTS, 3);

        assertFalse("Legal placement", game.isLegalPlacement(card1, card2));
    }
    @Test
    public void cardsInColTest(){
        SolitaireTable table = new SolitaireTable();
        table.set(new CellPosition(0, 0), new Card(CardSuit.HEARTS, 4));
        assertFalse("Column was empty", table.emptyCol(0));
    }
    @Test
    public void noCardsInColTest(){
        SolitaireTable table = new SolitaireTable();
        table.set(new CellPosition(0, 1), null);
        assertTrue("Column was not empty", table.emptyCol(0));
    }

    @Test
    public void stowAwayTest(){
        SolitaireTable table = new SolitaireTable();
        assertTrue(table.stowAway(new Card(CardSuit.HEARTS, 1)));
        assertFalse(table.stowAway(new Card(CardSuit.HEARTS, 13)));
        assertTrue(table.stowAway(new Card(CardSuit.HEARTS, 2)));
    }
}
