package com.Aditya.tic_tac_toe.strategies.BotPlayingStrategy;

import com.Aditya.tic_tac_toe.models.Board;
import com.Aditya.tic_tac_toe.models.Move;
import com.Aditya.tic_tac_toe.models.Player;

public interface BotPlayingStrategy {
    Move decideMove(Player player, Board board);
}
