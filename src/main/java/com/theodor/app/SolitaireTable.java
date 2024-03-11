package com.theodor.app;

import java.util.ArrayList;

import com.theodor.app.cards.Card;
import com.theodor.app.grid.CellPosition;
import com.theodor.app.grid.Grid;

public class SolitaireTable extends Grid<Card>{

    public SolitaireTable() {
        super(20, 7);

    }
    
    public boolean emptyCol(int col){
        return getCardsInCol(col).isEmpty();
    }
    
    private ArrayList<Card> getCardsInCol(int col){
        ArrayList<Card> cardsInCol = new ArrayList<>();
        for (int i = 0; i < rows(); i++) {
            Card card = get(new CellPosition(i, col));
            if (card != null)
                cardsInCol.add(card);
        }
        return cardsInCol;
    }

    public void printCol(int col){
        for (Card card : getCardsInCol(col)) {
            System.out.println(card.toString());
        }
    }

    public void print() {
        int maxRows = 7;
    
        // Iterate over each row
        for (int row = 0; row < maxRows; row++) {
            // Then iterate over each column in that row
            for (int col = 0; col < cols(); col++) {
                ArrayList<Card> columnCards = getCardsInCol(col);
                if (row < columnCards.size()) {
                    Card card = columnCards.get(row);
                    if (card.faceUp())
                        System.out.print(card.toString() + "\t"); // Use tab for spacing
                    else
                        System.out.print("----------\t");
                } 
                else 
                    System.out.print("\t\t"); // Print extra spaces if this column is shorter
                
            }
            System.out.println(); // Move to the next line after printing all columns in this row
        }
    }
    

}
