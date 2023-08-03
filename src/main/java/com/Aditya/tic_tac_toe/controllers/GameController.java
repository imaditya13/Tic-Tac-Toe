package com.Aditya.tic_tac_toe.controllers;

import com.Aditya.tic_tac_toe.models.Game;
import com.Aditya.tic_tac_toe.models.GameStatus;
import com.Aditya.tic_tac_toe.models.Player;

import java.util.List;

public class GameController {
    public Game createGame(Integer dimension, List<Player>players)
    {
        Game game = Game.getBuilder()
                .setDimension(dimension)
                .setPlayerList(players)
                .build();
        return game;
    }
    public GameStatus getGameStatus(Game game)
    {
        return game.getGameStatus();
    }
    public void undo(Game game)
    {
        game.undo();
    }
    public Player getWinner(Game game)
    {
        return game.getWinner();
    }
    public void executeNextMove(Game game)
    {
        game.makeMove();
    }
    public void displayBoard(Game game) {
        game.displayBoard();
    }
}
