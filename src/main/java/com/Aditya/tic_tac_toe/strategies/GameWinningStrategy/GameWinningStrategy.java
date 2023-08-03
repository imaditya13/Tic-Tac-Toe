package com.Aditya.tic_tac_toe.strategies.GameWinningStrategy;

import com.Aditya.tic_tac_toe.models.Board;
import com.Aditya.tic_tac_toe.models.Move;

public interface GameWinningStrategy {
    Boolean checkWinner(Board board, Move move);
}
