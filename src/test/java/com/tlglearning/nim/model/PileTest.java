package com.tlglearning.nim.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class PileTest {

    // TODO: 10/20/22  Implement tests (with expected return values of true and false) for isEmplty method of Pile class
    @Test
    void isEmpty() {
        fail("Test not yet implemented");
    }

    @Test
    void remove_valid() {
        Pile pile = new Pile(10);
        assertEquals(7, pile.remove(3));
        assertEquals(3, pile.getRemoved());
        assertEquals(7, pile.getRemaining());
    }

    @Test
    void remove_invalid() {
        Pile pile = new Pile(10);
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                pile.remove(11);
            }
        });
    }
}