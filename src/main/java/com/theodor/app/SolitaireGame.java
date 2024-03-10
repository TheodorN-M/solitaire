package com.theodor.app;

import com.theodor.app.cards.Card;
import com.theodor.app.cards.CardDeck;

public class SolitaireGame {
    private CardDeck deck;

    public SolitaireGame() {
        this.deck = new CardDeck();
        deck.shuffle(10);
    }

    public boolean isLegalPlacement(Card baseCard, Card cardToPlace) {
        return baseCard.getValue() == cardToPlace.getValue() + 1
                &&
                baseCard.getColor() != cardToPlace.getColor();

    }

    public void initDeal(){
        
    }
}
