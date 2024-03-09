package com.theodor.app;

import com.theodor.app.cards.CardDeck;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main( String[] args ){
        CardDeck deck = new CardDeck();
        deck.printDeck();
        deck.shuffle(1);
        deck.printDeck();
    }
}
