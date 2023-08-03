package com.Aditya.tic_tac_toe;

import com.Aditya.tic_tac_toe.controllers.GameController;
import com.Aditya.tic_tac_toe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TicTacToeGame {
    public static void main(String[] args) {
        System.out.println("Game is Starting....");
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the dimension of the game");
        Integer dimension = scanner.nextInt();

        //Take player information in the input.
        List<Player>players = new ArrayList<>();

        System.out.println("Will there be any bot [y/n]");
        String isBot = scanner.next();

        Integer noOfHumanPlayers = dimension-1;
        if(isBot.equals("y"))
        {
            noOfHumanPlayers = dimension-2;
            players.add(new Bot("Bot",'b', BotDifficultyLevel.EASY));
        }

        for(int i=0;i<noOfHumanPlayers;i++)
        {
            System.out.println("What is the name of the player: " + (i+1));
            String name = scanner.next();

            System.out.println("What is the symbol for player: " + (i+1));
            String symbol = scanner.next(); //Assumption : Single character.

            Player player = new Player(name,symbol.charAt(0), PlayerType.Human);
            players.add(player);
        }
        GameController gameController = new GameController();
        Game game = gameController.createGame(dimension,players);

          while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS))
          {
              //Players will the play the game.
              System.out.println("This is the current Board: ");
               gameController.displayBoard(game);

              System.out.println("Do you want to undo?[y/n]");
              String input = scanner.next();
              if(input.equals("y"))
              {
                  gameController.undo(game);
              }
              else
              {
                  gameController.executeNextMove(game);
              }
          }
          if(gameController.getGameStatus(game).equals(GameStatus.DRAW))
          {
              System.out.println("GAME HAS DRAWN");
          }
          if(gameController.getGameStatus(game).equals(GameStatus.FINISHED))
          {
              System.out.println("GAME ENDED");
              System.out.println("This is the current Board: ");
              gameController.displayBoard(game);
              System.out.println("Winner is "+gameController.getWinner(game).getName());
          }
    }
}