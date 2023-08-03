package com.Aditya.tic_tac_toe.strategies.BotPlayingStrategy;

import com.Aditya.tic_tac_toe.models.*;

public class EasyBotPlaingStrategy implements BotPlayingStrategy{
    @Override
    public Move decideMove(Player player, Board board) {
        for(int i=0;i<board.getBoard().size();i++)
        {
            for(int j=0;j<board.getBoard().size();j++)
            {
                if(board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY))
                {
                    return new Move(new Cell(i,j),player);
                }
            }
        }
        return null;
    }
}
