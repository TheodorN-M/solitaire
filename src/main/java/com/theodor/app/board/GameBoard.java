package com.theodor.app.board;

import java.util.ArrayList;

public class GameBoard {
    private GameBoard successor;
    private ArrayList<GameBoard> predecessors;

    public GameBoard(GameBoard current){
        this.successor = current;
    }
    

}
