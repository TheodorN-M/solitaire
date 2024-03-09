package com.theodor.app;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.theodor.app.cards.CardDeck;

public class CardDeckTest {

    @Test
    public void deckShuffleTest() {
        CardDeck unshuffledDeck = new CardDeck();
        CardDeck shuffledDeck = new CardDeck();
        shuffledDeck.shuffle(1);
        assertNotEquals(unshuffledDeck, shuffledDeck);
    }

    @Test
    public void randomShuffleTest(){
        CardDeck shuffledDeck1 = new CardDeck();
        CardDeck shuffledDeck2 = new CardDeck();
        shuffledDeck1.shuffle(1);
        shuffledDeck2.shuffle(1);

        assertNotEquals(shuffledDeck1, shuffledDeck2);
    }


}

