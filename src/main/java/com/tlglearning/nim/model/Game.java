package com.tlglearning.nim.model;

import java.util.LinkedList;
import java.util.List;

public class Game {
    // fields
    private List<Pile> piles;
    private State state;

    // constructor
    // int[] is the same as int...(var args)
    public Game(State state, int... pileSizes) throws IllegalArgumentException {
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

    public static class Pile {

        // fields
        private static final String BAD_SIZE_FORMAT = "Invalid size: %d; must be non-negative.";
        private static final String BAD_REMOVE_QUANTITY_FORMAT =
                "Invalid quantity: %d; must not exceed number remaining (%d).";
        private static final String TO_STRING_FORMAT = "Pile{removed=%d, remaining=%d}";

        private int removed;
        private int remaining;

        // constructor
        public Pile(int size) throws IllegalArgumentException {
            if (size < 0) {
                throw new IllegalArgumentException(String.format(BAD_SIZE_FORMAT, size));
            }
            removed = 0;
            remaining = size;
        }

        // methods
        public int remove(int quantity){
            if (quantity > remaining) {
                throw new IllegalArgumentException(
                        String.format(BAD_REMOVE_QUANTITY_FORMAT, quantity, remaining));
            }
            removed += quantity;
            return (remaining -= quantity);
        }

        public boolean isEmpty() {
            return remaining == 0;
        }

        // getters and setters
        public int getRemoved() {
            return removed;
        }

        public int getRemaining() {
            return remaining;
        }



        @Override
        public String toString() {
            return String.format(TO_STRING_FORMAT, removed, remaining);
        }
    }

    public enum State {

        PLAYER_1_MOVE {
            // anonymous subclass to override other 3 methods
            @Override
            public boolean isTerminal() {
                return false;
            }

            @Override
            public State nextMoveState() {
                return PLAYER_2_MOVE;
            }

            @Override
            public State nextWinState() {
                return PLAYER_1_WIN;
            }
        },

        PLAYER_2_MOVE {
            @Override
            public boolean isTerminal() {
                return false;
            }

            @Override
            public State nextMoveState() {
                return PLAYER_1_MOVE;
            }

            @Override
            public State nextWinState() {
                return PLAYER_2_WIN;
            }
        },

        PLAYER_1_WIN,

        PLAYER_2_WIN;

        public boolean isTerminal() {
            return true;
        }

        public State nextMoveState() {
            return this;
        }

        public State nextWinState() {
            return this;
        }



    }
}