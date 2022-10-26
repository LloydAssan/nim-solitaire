package com.tlglearning.nim.model;

import java.util.List;
import java.util.Stack;

public class Game {
    // fields
    private List<Pile> piles;
    private State state;

    // constructor
    public Game(State state, int[] pileSizes) throws IllegalArgumentException {
        throw new UnsupportedOperationException(); 
        // TODO: 10/25/22  Implement to create the list of piles, with a size given by the pileSizes array. 
    }

    // methods
    public void play(Pile pile, int quantity)throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not implemented yet");  
        // TODO: 10/25/22  Implement to remove the specified pile, and to update the state accordingly. 
    }

    public boolean isFinished(){
        throw new UnsupportedOperationException("NIY");
        // TODO: 10/25/22 Check all the piles and to  
    }

    // TODO: 10/25/22 Create getters for pile and state. 

    // TODO: 10/25/22 Create test class for Game, with methods to test construction, play and isFinished.  

}