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

                if (currentCard == null || !currentCard.faceUp() )
                    continue;
                if (table.stowAway(currentCard)){
                    table.set(currentPos, null);
                    int currentRow = currentPos.getRow()-1;
                    if (currentRow < 0)
                        continue;

                    Card cardBeneath = table.get(new CellPosition(currentRow, currentPos.getCol()));
                    if (!cardBeneath.faceUp())
                        cardBeneath.flip();
                    
                    
                }

                table.print();
            }
            break;
        }
        timeElapsed = System.currentTimeMillis() - startTime;
        System.out.println("Time elapsed: " + timeElapsed + " ms");
        return true;
    }
}
