package com.theodor.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.theodor.app.cards.Card;
import com.theodor.app.cards.CardDeck;
import com.theodor.app.cards.CardSuit;
import com.theodor.app.grid.CellPosition;
import com.theodor.app.grid.Grid;

public class SolitaireTable extends Grid<Card> {

    private CardDeck toDrawFrom;
    private HashMap<CardSuit, LinkedList<Card>> completed;

    public SolitaireTable() {
        super(20, 7);
        this.completed = new HashMap<>();
    }

    public void putAway(Card card){
        CardSuit thisSuit = card.getSuit();
        LinkedList<Card> pile = completed.getOrDefault(thisSuit, new LinkedList<Card>());
        // If the pile is empty and the card to stow is an ace
        if (pile.isEmpty() && card.getValue() == 1){ 
            pile.add(card);
            completed.put(thisSuit, pile);
            return;
        } 
        // If top card is one less than the card in question's value
        if (!pile.isEmpty() && pile.getLast().getValue() +1 == card.getValue()){
            pile.add(card);
            completed.put(thisSuit, pile);
            return;
        }
        
    }

    public boolean emptyCol(int col) {
        return getCardsInCol(col).isEmpty();
    }

    private ArrayList<Card> getCardsInCol(int col) {
        ArrayList<Card> cardsInCol = new ArrayList<>();
        for (int i = 0; i < rows(); i++) {
            Card card = get(new CellPosition(i, col));
            if (card != null)
                cardsInCol.add(card);
        }
        return cardsInCol;
    }

    public void printCol(int col) {
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
                } else
                    System.out.print("\t\t"); // Print extra spaces if this column is shorter

            }
            System.out.println(); // Move to the next line after printing all columns in this row
        }
    }

}
