package com.theodor.app.cards;

import java.util.Random;
import java.util.ArrayList;

public class CardDeck extends ArrayList<Card> {
    private Random rnd;
    private final static int CARD_AMOUNT = 52;
    private int cardsInDeck = this.size();

    public CardDeck(){
        super(CARD_AMOUNT);
        this.rnd = new Random();
        generateDeck();
    }

    private void generateDeck() {
        for (CardSuit color : CardSuit.values()) {
            for (int i = 1; i <= 13; i++) {
                this.add(new Card(color, i));
                
            }
        }
    }
    /**
     * Shuffles the deck randomly
     * @param nTimes how many shuffles to give
     */
    public void shuffle(int nTimes){
        for (int i = 0; i < nTimes; i++) {
            for (Card card : this) {
                set(rnd.nextInt(CARD_AMOUNT), card);
            }
            
        }
    }

    public void printDeck(){
        for (Card card : this) {
            System.out.println(card.toString());
        }
    }
}
