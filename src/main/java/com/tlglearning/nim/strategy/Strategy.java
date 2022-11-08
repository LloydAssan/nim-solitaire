package com.tlglearning.nim.strategy;

import com.tlglearning.nim.model.Game;

interface Strategy {


    // method
    int[] selectMove(Game game);

}