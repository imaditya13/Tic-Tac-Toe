package com.Aditya.tic_tac_toe.models;

import com.Aditya.tic_tac_toe.exceptions.InvalidGameDimensionException;
import com.Aditya.tic_tac_toe.exceptions.InvalidNumberOfPlayersException;
import com.Aditya.tic_tac_toe.strategies.GameWinningStrategy.DefaultGameWinningStrategy;
import com.Aditya.tic_tac_toe.strategies.GameWinningStrategy.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player>playerList;
    private List<Move>moveList;
    private GameStatus gameStatus;
    private Player Winner;
    private Integer nextPlayerIndex;
    GameWinningStrategy gameWinningStrategy;

    private Game(){}
    public static GameBuilder getBuilder()
    {
        return new GameBuilder();
    }
    public void displayBoard()
    {
        this.board.displayBoard();
    }
    public void undo()
    {

        if(moveList.size()==0)
        {
           // System.out.println(move.getPlayer().getName()+"  You FOOL !");
            System.out.println("this is your first move so You cant UNDO");
        }
        else {
            Move move = moveList.get(moveList.size()-1);

            moveList.remove(moveList.size()-1);
            int row = move.getCell().getRow();
            int col = move.getCell().getCol();
            board.getBoard().get(row).get(col).setCellState(CellState.EMPTY);

            nextPlayerIndex -= 1+ playerList.size();
            nextPlayerIndex %= playerList.size();
        }
    }
    public void makeMove()
    {
        Player playerToMove = playerList.get(nextPlayerIndex);

       Move move =  playerToMove.decideMove(board);

       int row = move.getCell().getRow();
       int col = move.getCell().getCol();

       if(this.board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY))
       {
           this.board.applyMove(move);
           moveList.add(move);

           nextPlayerIndex += 1;
           nextPlayerIndex %= playerList.size();

           // Check Winner
             if(gameWinningStrategy.checkWinner(board,move))
             {
                 this.setGameStatus(GameStatus.FINISHED);
                 this.setWinner(playerToMove);
             }

       }
       else {
           // throws exception
           System.out.println(playerToMove.getName()+"  You Asshole !");
           System.out.println("this place is already filled ");
       }

    }
    public static class GameBuilder
    {
        private Integer dimension;
        private List<Player>playerList;

        private GameBuilder(){}
        public GameBuilder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        public GameBuilder setDimension(Integer dimension) {
            this.dimension = dimension;
            return this;
        }

        private Boolean isVaild() throws InvalidGameDimensionException, InvalidNumberOfPlayersException {
            if(dimension-1 != playerList.size())
            {
                throw  new InvalidNumberOfPlayersException("Number of players should be 1 less than dimension");
            }
            if(dimension<3)
            {
                throw new InvalidGameDimensionException("Dimension can't be less than 3");
            }
            return  true;
        }
        public Game build()
        {
            try {
                isVaild();
            }
            catch (InvalidGameDimensionException e)
            {
                System.out.println(e.getMessage());
                return null;
            }
            catch (InvalidNumberOfPlayersException e)
            {
             System.out.println(e.getMessage());
             return null;
            }
            // Game is valid
            Game game = new Game();
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setBoard(new Board(dimension));
            game.setMoveList(new ArrayList<>());
            game.setNextPlayerIndex(0);
            game.setPlayerList(playerList);
            game.setGameWinningStrategy(new DefaultGameWinningStrategy(dimension));
            return  game;
        }
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public void setNextPlayerIndex(Integer nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void setWinner(Player winner) {
        Winner = winner;
    }

    public Board getBoard() {
        return board;
    }

    public Integer getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public Player getWinner() {
        return Winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }
}
