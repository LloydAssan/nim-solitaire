package com.tlglearning.nim.view;

import com.tlglearning.nim.model.Game;
import org.junit.jupiter.api.Test;

import java.util.Random;

class GameViewTest {

    @Test
    void toString_initial() {
        Game game = new Game(Game.State.PLAYER_1_MOVE, new int[]{3,5,7});
        System.out.println(new GameView().toString(game));
    }

    @Test
    void toString_inProgress() {
        Game game = new Game(Game.State.PLAYER_1_MOVE, new int[]{3,5,7});
        Random random = new Random();
        game
                .getPiles()
                .forEach((Game.Pile pile) -> game.play(pile, 1+ random.nextInt(pile.getRemaining())));

        System.out.println(new GameView().toString(game));
    }

    static class PileViewTest {

        @Test
        void testToString() {
            Game.Pile pile = new Game.Pile(15);
            pile.remove(5);
            System.out.println(new GameView.PileView().toString(pile));
        }
    }
}