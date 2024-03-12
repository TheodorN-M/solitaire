package com.theodor.app;

import com.theodor.app.cards.Card;
import com.theodor.app.cards.CardDeck;
import com.theodor.app.grid.CellPosition;

public class SolitaireGame {
    private CardDeck deck;
    private SolitaireTable table;
    private boolean isFinished;

    public SolitaireGame() {
        this.deck = new CardDeck();
        this.table = new SolitaireTable();
        deck.shuffle(10);
        initDeal();
        this.isFinished = false;
    }

    public boolean isLegalPlacement(Card baseCard, Card cardToPlace) {
        if (baseCard.getValue() == cardToPlace.getValue() - 1
                &&
                baseCard.getColor() != cardToPlace.getColor())
            return true;

        return cardToPlace.getValue() == 13 && baseCard == null;

    }

    public boolean isFinished() {
        return isFinished;
    }

    public CardDeck getDeck() {
        return deck;
    }

    public SolitaireTable getTable() {
        return table;
    }

    private void initDeal() {
        for (int col = 0; col < table.cols(); col++) {
            for (int row = 0; row < col + 1; row++) {
                Card drawn = deck.draw();
                if (col == row) {
                    drawn.flip();
                    table.set(new CellPosition(row, col), drawn);
                    break;

                }
                table.set(new CellPosition(row, col), drawn);

            }
        }
    }

    public void print() {
        table.print();
    }

}
