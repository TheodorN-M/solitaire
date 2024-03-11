package com.theodor.app;

import com.theodor.app.algorithm.BruteSolver;

public class Main {
    public static void main( String[] args ){
        SolitaireGame game = new SolitaireGame();
        BruteSolver solver = new BruteSolver(game);
        solver.run();
    }
}
