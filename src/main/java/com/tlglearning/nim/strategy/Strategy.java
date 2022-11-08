package com.tlglearning.nim.strategy;

import com.tlglearning.nim.model.Game;

interface Strategy {


    // method
    public default int[] selectMove(Game game) {
        return new int[]{0};
    }

}