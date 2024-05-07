package com.theodor.app.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.theodor.app.cards.Card;
import com.theodor.app.cards.CardDeck;
import com.theodor.app.cards.CardSuit;
import com.theodor.app.grid.CellPosition;
import com.theodor.app.grid.Grid;
import com.theodor.app.grid.GridCell;

public class SolitaireTable extends Grid<Card> {

    private HashMap<CardSuit, LinkedList<Card>> completed;

    public SolitaireTable() {
        super(20, 7);
        this.completed = new HashMap<>();
    }

    /**
     * Tries to stow a given card away
     * 
     * @param card the Card in question
     * @return true if the card is stowed, false otherwise
     */
    public boolean stowAway(Card card) {
        CardSuit thisSuit = card.getSuit();
        LinkedList<Card> pile = completed.getOrDefault(thisSuit, new LinkedList<Card>());
        // If the pile is empty and the card to stow is an ace
        if (pile.isEmpty() && card.getValue() == 1) {
            pile.add(card);
            completed.put(thisSuit, pile);
            return true;
        }
        // If top card is one less than the card in question's value
        if (!pile.isEmpty() && pile.getLast().getValue() + 1 == card.getValue()) {
            pile.add(card);
            completed.put(thisSuit, pile);
            return true;
        }
        return false;
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
        System.out.println("----------------");
        for (LinkedList<Card> pile : completed.values()) {
            if (pile.isEmpty())
                continue;
            System.out.println(pile.getLast().toString());
        }
        System.out.println("----------------\n");
        int maxRows = rows();

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

    /**
     * Moves a card to the cell below the other card. Does not check game rules for
     * black/red cards!
     * 
     * @see SolitaireGame.isLegalPlacement() method should be asserted before a call
     *      to move()!
     * 
     * @param toMove     Gridcell object with CellPosition and Card to be moved
     * @param underneath Gridcell object with CellPosition of Card underneath
     *                   position
     * @return wether the card was successfully moved
     */
    public boolean move(GridCell<Card> toMove, GridCell<Card> underneath) {
        CellPosition underneathPos = underneath.getPos();
        CellPosition newPos = new CellPosition(underneathPos.getRow() + 1, underneathPos.getCol());
        if (get(newPos) != null)
            return false;

        set(newPos, toMove.getValue());
        set(toMove.getPos(), null);
        return true;
    }

    public void moveKing(GridCell<Card> gridCell, CellPosition cellPosition) {
        set(gridCell.getPos(), null);
        set(cellPosition, gridCell.getValue());
    }

}
