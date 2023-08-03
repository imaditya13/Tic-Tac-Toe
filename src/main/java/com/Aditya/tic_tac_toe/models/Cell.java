package com.Aditya.tic_tac_toe.models;

public class Cell {
    private Player player;
    private Integer row;
    private  Integer col;
    private CellState cellState;

    public Cell(Integer row,Integer col)
    {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }
    public CellState getCellState() {
        return cellState;
    }

    public Integer getCol() {
        return col;
    }

    public Integer getRow() {
        return row;
    }

    public Player getPlayer() {
        return player;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setRow(Integer row) {
        this.row = row;
    }
}
