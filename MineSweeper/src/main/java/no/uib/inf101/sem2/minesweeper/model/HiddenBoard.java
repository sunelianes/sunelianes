package no.uib.inf101.sem2.minesweeper.model;

import no.uib.inf101.sem2.grid.Grid;
import no.uib.inf101.sem2.grid.GridCell;


public class HiddenBoard extends Grid<Character> {

  private int hiddenMines;

  public HiddenBoard(MineSweeperBoard board) {
    super(board.rows(), board.cols(), 'h');
    this.hiddenMines = board.getMineCount();
  }

  /**
   * Iterates through itself and count the hidden tiles
   * @return an int representing the amount of hidden tiles
   */
  int getHiddenTiles() {
    int hiddenTiles = 0;
    for (GridCell<Character> gridCell : this) {
      if (gridCell.value() == 'h' || gridCell.value() == 'f') {
        // if hidden or flag on cell, it counts as a hidden tile
        hiddenTiles++;
      }
    }
    return hiddenTiles;
  }

  /** @return int for amount of hidden mines */
  int getHiddenMines() {return hiddenMines;}

  /**
   * game is won when the hidden mines are as many as the hidden tiles
   * @return boolean if the game is won or not
   */
  boolean gameWon() {
    return (getHiddenMines() == getHiddenTiles());
  }
}
