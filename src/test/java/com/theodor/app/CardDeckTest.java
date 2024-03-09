package com.theodor.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardDeckTest {
    @Test
    public void deckShuffleTest() {
        CardDeck unshuffledDeck = new CardDeck();
        CardDeck shuffledDeck = new CardDeck();
        shuffledDeck.shuffle();
        assertNotEquals(unshuffledDeck, shuffledDeck);
    }

    @Test
    public void randomShuffleTest(){
        CardDeck shuffledDeck1 = new CardDeck();
        CardDeck shuffledDeck2 = new CardDeck();
        shuffledDeck1.shuffle();
        shuffledDeck2.shuffle();

        assertNotEquals(shuffledDeck1, shuffledDeck2);
    }
}

