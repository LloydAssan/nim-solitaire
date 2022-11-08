package com.tlglearning.nim.controller;

import com.tlglearning.nim.model.Game;
import com.tlglearning.nim.view.GameView;

class GameController {

    private final Game game;
    private final GameView view;

    // ctor
    // int[] is the same as int...(var args)
    public GameController(Game.State initialState, int... pileSizes){
        game = new Game(initialState, pileSizes);
        view = new GameView();
    }

}