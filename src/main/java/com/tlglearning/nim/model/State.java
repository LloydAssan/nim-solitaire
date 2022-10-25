package com.tlglearning.nim.model;

import java.util.EnumSet;
import java.util.Set;

public enum State {
    PLAYER 1 MOVE,
    PLAYER 2 MOVE,
    PLAYER 1 WIN,
    PLAYER 2 WIN
}

    //Methods
    public boolean isTerminal(){
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public State nextMoveState(){
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public State nextWinState(){
        throw new UnsupportedOperationException("Not yet implemented");
    }

}

