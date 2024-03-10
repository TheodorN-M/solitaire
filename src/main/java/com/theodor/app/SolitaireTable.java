package com.theodor.app;

import java.util.ArrayList;

import com.theodor.app.cards.Card;
import com.theodor.app.grid.CellPosition;
import com.theodor.app.grid.Grid;

public class SolitaireTable extends Grid<Card>{

    public SolitaireTable() {
        super(13, 7);

    }
    
    public boolean emptyCol(int col){
        return getCol(col).isEmpty();
    }
    
    private ArrayList<Card> getCol(int col){
        ArrayList<Card> cardsInCol = new ArrayList<>();
        for (int i = 0; i < rows(); i++) {
            Card card = get(new CellPosition(i, col));
            if (card != null)
                cardsInCol.add(card);
        }
        return cardsInCol;
    }

    public void printCol(int col){
        for (Card card : getCol(col)) {
            System.out.println(card.toString());
        }
    }
}
