package com.tlglearning.nim.controller;

import com.tlglearning.nim.model.Game;
import com.tlglearning.nim.view.GameView;

class GameController {

    private final Game game;
    private final GameView view;

    // ctor
    public GameController(Game.State state, int[] pileSizes){
        this.game = game;
        this.view = view;
    }

}