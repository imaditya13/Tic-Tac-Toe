package com.Aditya.tic_tac_toe.models;

import java.util.Scanner;

public class Player {
  private String name;
  private Character symbol;
  private PlayerType playerType;

  public Player(String name, Character symbol,PlayerType playerType)
  {
      this.name = name;
      this.playerType = playerType;
      this.symbol = symbol;
  }
    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Character getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
    public Move decideMove(Board board)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println(this.getName()+" please Select a row");
        int row = scanner.nextInt();
        System.out.println(this.getName()+" please select a col");
        int col = scanner.nextInt();

        return new Move(new Cell(row,col),this);
    }
}
