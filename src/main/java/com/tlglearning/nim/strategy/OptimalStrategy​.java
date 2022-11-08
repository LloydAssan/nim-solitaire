package com.tlglearning.nim.strategy;

import com.tlglearning.nim.model.Game;
import com.tlglearning.nim.model.Game.Pile;

class OptimalStrategy implements Strategy {

    @Override
    public int[] selectMove(Game game){
      int nimSum = game
              .getPiles()
              .stream()
              // replacing each pile with an int
              .mapToInt(Pile::getRemaining)
              .reduce(0, (a,b) -> a ^ b);
      if (nimSum != 0) {
          int[] candidateMoves = game
                  .getPiles()
                  .stream()
                  // replacing each pile with an int
                  .mapToInt((pile) -> {
                      int remaining = pile.getRemaining();
                      int temp = nimSum ^ remaining;
                      return (temp < remaining) ?  (remaining - temp) : 0;
                  })
                  .toArray();
          // TODO: 11/8/22 Pick a non-xero element in candate moves, and return an array
          //  made up the position of the element and the value in that position of the array.
      } else {
          // TODO: 11/8/22 Pick a move at random
      }
    }

}