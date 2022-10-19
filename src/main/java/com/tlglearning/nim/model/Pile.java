package com.tlglearning.nim.model;

public class Pile {
    
    // attributes 
    private int removed;
    private int remaining;

    // TODO: 10/18/22 Define constructor that initializes removed to 0 and sets remaining to a value of a parameter.
    // constructor
    public Pile(int removed, int remaining) {
        this.removed = removed;
        this.remaining = remaining;
    }

    // TODO: 10/18/22 Define methods shown in nim-classes.svg;
    // method
    public boolean isEmpty(){
        return true;
    }

    public int remove() {
        return 0;
    }


    // TODO: 10/18/22 Generate "getters" (assessors) for removed and remaining.
    public int getRemoved() {
        return removed;
    }

    public int getRemaining() {
        return remaining;
    }


    // TODO: 10/18/22 Create a test class for Pile (use option+return after selecting class name)


    // TODO: 10/18/22 Commit and push changes
    
}