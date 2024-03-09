package com.theodor.app;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main( String[] args ){
        CardDeck deck = new CardDeck();
        deck.printDeck();
        deck.shuffle();
        deck.printDeck();
    }
}
