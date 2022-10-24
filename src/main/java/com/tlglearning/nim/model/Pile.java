package com.tlglearning.nim.model;

public class Pile {
    
    // attributes - fields
    private int removed;
    private int remaining;

    // constructor
    public Pile(int remaining){
        removed = 0;
        // this is used here for representing the current instance of this remaining
        this.remaining = remaining;
    }

    // method
    public boolean isEmpty(){
        return true;
    }

    public int remove(int quantity) {
        if (quantity > remaining){
            throw new IllegalArgumentException("Quantity to remove must not exceed quantity remaining.");
        }
        removed = removed + quantity;  // removed += quantity;
        remaining = remaining - quantity; // remaining -= quantity;
        return remaining;
    }

    // getters/setters
    public int getRemoved() {
        return removed;
    }

    public int getRemaining() {
        return remaining;
    }
}