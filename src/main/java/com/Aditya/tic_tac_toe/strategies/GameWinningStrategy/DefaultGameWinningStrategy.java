package com.Aditya.tic_tac_toe.strategies.GameWinningStrategy;

import com.Aditya.tic_tac_toe.models.Board;
import com.Aditya.tic_tac_toe.models.Move;
import com.Aditya.tic_tac_toe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DefaultGameWinningStrategy implements GameWinningStrategy{

    List<HashMap<Character,Integer>>rowSymbols = new ArrayList<>();
    List<HashMap<Character,Integer>>colSymbols = new ArrayList<>();
    HashMap<Character,Integer>topLeftDiagonalSymbols = new HashMap<>();
    HashMap<Character,Integer>topRightDiagonalSymbols = new HashMap<>();
    public DefaultGameWinningStrategy(int dimension) {
        for (int i = 0; i < dimension; i++) {
            rowSymbols.add(new HashMap<>());
            colSymbols.add(new HashMap<>());
        }
    }

    private boolean isCellOnTopLeftDiagonal(int row, int col) {
        return row == col;
    }

    private boolean isCellOnTopRightDiagonal(int row, int col, int dimension) {
        return row + col == dimension - 1;
    }


    @Override
    public Boolean checkWinner(Board board, Move move) {
        Character symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        int dimension = board.getBoard().size();

        if(!rowSymbols.get(row).containsKey(symbol))
        {
            rowSymbols.get(row).put(symbol,0);
        }
        rowSymbols.get(row).put(symbol,rowSymbols.get(row).get(symbol)+1);

        if(!colSymbols.get(col).containsKey(symbol))
        {
            colSymbols.get(col).put(symbol,0);
        }
        colSymbols.get(col).put(symbol,colSymbols.get(col).get(symbol)+1);

        if(isCellOnTopLeftDiagonal(row,col))
        {
            if (!topLeftDiagonalSymbols.containsKey(symbol)) {
                topLeftDiagonalSymbols.put(symbol, 0);
            }
            topLeftDiagonalSymbols.put(symbol, topLeftDiagonalSymbols.get(symbol) + 1);
        }

        if(isCellOnTopRightDiagonal(row,col,dimension))
        {
            if (!topRightDiagonalSymbols.containsKey(symbol)) {
                topRightDiagonalSymbols.put(symbol, 0);
            }
            topRightDiagonalSymbols.put(symbol, topRightDiagonalSymbols.get(symbol) + 1);
        }

        if(rowSymbols.get(row).get(symbol) == dimension)return true;

        if(colSymbols.get(col).get(symbol) == dimension)return true;

        if(isCellOnTopLeftDiagonal(row,col) &&
                topLeftDiagonalSymbols.get(symbol)==dimension)return true;

        if(isCellOnTopRightDiagonal(row,col,dimension) &&
                topRightDiagonalSymbols.get(symbol)==dimension)return true;

        return false;
    }
}
