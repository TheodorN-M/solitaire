package com.theodor.app.cards;

import java.util.Random;
import java.util.ArrayList;

public class CardDeck extends ArrayList<Card> {
    private Random rnd;
    private final static int CARD_AMOUNT = 52;

    public CardDeck(){
        super(CARD_AMOUNT);
        this.rnd = new Random();
        generateDeck();
    }

    private void generateDeck() {
        for (CardSuit suit : CardSuit.values()) {
            for (int i = 1; i <= 13; i++) {
                this.add(new Card(suit, i, false));
                
            }
        }
    }
   /**
     * Shuffles the deck randomly using the Fisher-Yates shuffle algorithm
     * @param nTimes how many shuffles to give
     */
    public void shuffle(int nTimes){
        for (int i = 0; i < nTimes; i++) {
            for (int j = this.size() - 1; j > 0; j--) {
                int index = rnd.nextInt(j + 1);
                // Simple swap
                Card a = this.get(index);
                this.set(index, this.get(j));
                this.set(j, a);
            }
        }
    }

    public void printDeck(){
        for (Card card : this) {
            System.out.println(card.toString());
        }
    }

    public Card draw(){
        if (size() <= 0){
            System.out.println("No cards left in deck");
            return null;
        }

        return this.remove(size()-1);
    }

    public Card drawRandom(){
        if (size() > 0)
            return this.remove(rnd.nextInt(size()));
        else {
            System.out.println("No cards left in deck");
            return null;
        }
    }
}
