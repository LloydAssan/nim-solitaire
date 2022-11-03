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
        this.state = isFinished() ? state.nextMoveState().nextWinState() : state;
    }

    // methods
    public void play(Pile pile, int quantity)throws IllegalArgumentException {
        if(state.isTerminal()){
            throw new IllegalStateException("Game already finished");
        }
        pile.remove(quantity);
        // tenary option -> boolean - boolean condition if true and 3rd is otherwise
        state = isFinished() ? state.nextWinState() : state.nextMoveState();
//        if(isFinished()){
//            state = state.nextWinState();
//        }
//        else{
//            state = state.nextMoveState();
//        }
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