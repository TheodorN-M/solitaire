package com.theodor.app;

import java.util.Random;
import java.util.ArrayList;

public class CardDeck extends ArrayList<Card> {
    private Random rnd;
    private final int CARD_AMOUNT = 52;
    private int cardsInDeck = this.size();

    public CardDeck(){
        super(52);
        this.rnd = new Random();
        generateDeck();
    }

    private void generateDeck() {
        for (CardColor color : CardColor.values()) {
            for (int i = 1; i <= 13; i++) {
                this.add(new Card(color, i));
                
            }
        }
    }
    
    public void shuffle(){
        for (Card card : this) {
            set(rnd.nextInt(CARD_AMOUNT), card);
        }
    }

    public void printDeck(){
        for (Card card : this) {
            System.out.println(card.toString());
        }
    }
}
