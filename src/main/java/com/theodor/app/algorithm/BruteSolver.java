package com.theodor.app.algorithm;

import com.theodor.app.SolitaireGame;
import com.theodor.app.SolitaireTable;
import com.theodor.app.cards.Card;
import com.theodor.app.grid.CellPosition;
import com.theodor.app.grid.GridCell;

public class BruteSolver {
    private SolitaireGame game;
    private SolitaireTable table;
    private long timeElapsed;

    public BruteSolver(SolitaireGame game) {
        this.game = game;
        this.table = game.getTable();
        this.timeElapsed = 0;
    }

    public boolean run() {
        long startTime = System.currentTimeMillis();
        while (!game.isFinished()) {
            for (GridCell<Card> gridCell : table) {
                Card currentCard = gridCell.getValue();
                CellPosition currentPos = gridCell.getPos();

                if (currentCard == null || !currentCard.faceUp())
                    continue;
                if (table.stowAway(currentCard)) {
                    table.set(currentPos, null);
                    flipCardBelow(currentPos);

                }

                for (GridCell<Card> gridCell2 : table) {
                    Card other = gridCell2.getValue();

                    

                    if (other == null && currentCard.getValue() == 13){
                        table.moveKing(gridCell, gridCell2.getPos());
                        flipCardBelow(currentPos);
                        break;
                    }

                    if (other == null || currentCard.equals(other))
                        continue;

                    if (game.isLegalPlacement(other, currentCard)){
                        if (table.move(gridCell2, gridCell))
                            flipCardBelow(currentPos);
                    }

                    
                }

                table.print();
            }

            timeElapsed = System.currentTimeMillis() - startTime;
            if (timeElapsed > 20)
                break;
        }
        System.out.println("Time elapsed: " + timeElapsed + " ms");
        return false;
    }

    private void flipCardBelow(CellPosition currentPos){
        int currentRow = currentPos.getRow() - 1;
        if (currentRow < 0)
            return;     // Nothing to flip

        Card cardBeneath = table.get(new CellPosition(currentRow, currentPos.getCol()));
        if (cardBeneath == null)
            return;
        if (!cardBeneath.faceUp()) 
            cardBeneath.flip();
        
    }
}
