package com.tlglearning.nim.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class GameTest {

    @Test
        // starting a game from anythign other than player1 or player 2 move
    void constructor_badState() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Game(Game.State.PLAYER_1_WIN, new int[]{3, 5, 7});
            }
        });

    }

    @Test
    void constructor_badPileSizes() {
        // can change executable to a lambda
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Game(Game.State.PLAYER_1_MOVE, new int[]{-3, 5, 7});
            }
        });
    }

    @Test
    void play_valid() {
        Game game = new Game(Game.State.PLAYER_1_MOVE, new int[]{1, 2, 3});
        Game.Pile pile = game.getPiles().get(0);
        game.play(pile, pile.getRemaining());
        assertTrue(pile.isEmpty());
    }

    @Test
    void play_invalid() {
        Game game = new Game(Game.State.PLAYER_1_MOVE, new int[]{1, 2, 3});
        Game.Pile pile = game.getPiles().get(0);
        assertThrows(IllegalArgumentException.class, () -> game.play(pile, pile.getRemaining() + 1));
    }

    @Test
    void play_whenGameAlreadyFinished() {
        Game game = new Game(Game.State.PLAYER_1_MOVE, new int[]{3, 5, 7});
        for (Game.Pile pile : game.getPiles()) {
            game.play(pile, pile.getRemaining());
        }
        assertThrows(IllegalStateException.class, () -> game.play(game.getPiles().get(0), 1));
    }

    @Test
    void isFinished_some() {
        Game game = new Game(Game.State.PLAYER_1_MOVE, new int[]{3, 5, 7});
        for (Game.Pile pile : game.getPiles()) {

            game.play(pile, pile.getRemaining() - 1);
        }
        assertFalse(game.isFinished());
    }

    @Test
    void isFinished_none() {
        Game game = new Game(Game.State.PLAYER_1_MOVE, new int[]{3, 5, 7});
        for (Game.Pile pile : game.getPiles()) {
            pile.remove(pile.getRemaining());
        }
        assertTrue(game.isFinished());
    }

    static class PileTest {
        private static final int PILE_SIZE = 10;

        @Test
        void constructor_invalid() {
            assertThrows(IllegalArgumentException.class, () -> new Game.Pile(-1));
        }

        @Test
        void remove_valid() {
            Game.Pile pile = new Game.Pile(PILE_SIZE);
            int quantity = 3;
            int expectedRemaining = PILE_SIZE - quantity;
            assertEquals(expectedRemaining, pile.remove(quantity));
            assertEquals(quantity, pile.getRemoved());
            assertEquals(expectedRemaining, pile.getRemaining());
        }

        @Test
        void remove_invalid() {
            Game.Pile pile = new Game.Pile(PILE_SIZE);
            assertThrows(IllegalArgumentException.class, () -> pile.remove(PILE_SIZE + 1));
        }

        @Test
        void isEmpty_some() {
            Game.Pile pile = new Game.Pile(PILE_SIZE);
            pile.remove(PILE_SIZE - 1);
            assertFalse(pile.isEmpty());
        }

        @Test
        void isEmpty_none() {
            Game.Pile pile = new Game.Pile(PILE_SIZE);
            pile.remove(PILE_SIZE);
            assertTrue(pile.isEmpty());
        }
    }
}