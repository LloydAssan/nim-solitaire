package com.tlglearning.nim.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Game {
    // fields
    private List<Pile> piles;
    private State state;

    // constructor
    public Game(State state, int[] pileSizes) throws IllegalArgumentException {
        if(state.isTerminal()){
            throw new IllegalArgumentException("Game must start in non-terminal state");
        }
        List<Pile> piles = new LinkedList<>();
        for (int size : pileSizes){
            piles.add(new Pile(size));
        }
        this.piles = piles;
        if(isFinished()) {
            this.state = state.nextWinState();    // TODO: 10/27/22 Explore whether this should even be allowed.

        }
    }

    // methods
    public void play(Pile pile, int quantity)throws IllegalArgumentException {

        throw new UnsupportedOperationException("Not implemented yet");  
        // TODO: 10/25/22  Implement the play method by delegating the action to the remove method of the
        //  specified pile, then checking to see if all piles are depleted; if so, the state field
        //  should be updated to the value returned by state.nextWinState(); otherwise, the value returned
        //  by state.nextMoveState() should be used.
    }

    public boolean isFinished() {
        return piles
                .stream()
                .allMatch((pile) -> pile.isEmpty());

        // OR BELOW APPROACH
        //    boolean finished = true;
//              for (Pile pile : piles)
//                if (!pile.isEmpty()) {
//                  finished() = false;
//                    break;
//                 }
//                }
//                 return finished;

        // TODO: 10/25/22 Implement the isFinished() method. This method must return true if no piles
        //  have any remaining, and false otherwise. (If you do this correctly, then you can invoke
        //  it from the implementation of the play method, to help with the logic of the latter.)
    }

    // getters for Piles and State
    public List<Pile> getPiles() {
        return piles;
    }

    public State getState() {
        return state;
    }
}