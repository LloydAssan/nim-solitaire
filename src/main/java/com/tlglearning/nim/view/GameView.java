package com.tlglearning.nim.view;

import com.tlglearning.nim.model.Game;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class GameView {

    private static final String PILE_SEPARATOR = System.lineSeparator().repeat(2);

    public String toString(Game game){
        // TODO: 11/1/22 Include the state of the game in the output
        PileView pileView = new PileView();
        // iterating over two lists
        List<Game.Pile> piles = game.getPiles();
        Iterator<Game.Pile> iterator = piles.iterator();
        return Stream.concat(
                IntStream
                // confirm start and end value
                .rangeClosed(1, piles.size())
                .mapToObj((num) -> String.format("%d: %s", num, pileView.toString(iterator.next()))),
                Stream.of(game.getState().toString())
                )
                .collect(Collectors.joining(PILE_SEPARATOR));
    }

    public static class PileView {

        private static final String REMOVED = "\u2542";
        private static final String REMAINING = "\u2503";

        public String toString(Game.Pile pile) {
            return REMOVED.repeat(pile.getRemoved()) + " " + REMAINING.repeat(pile.getRemaining());
        }

    }
}