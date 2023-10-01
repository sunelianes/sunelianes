package no.uib.inf101.sem2.minesweeper.view;

import no.uib.inf101.sem2.grid.GridCell;
import no.uib.inf101.sem2.grid.GridDimension;
import no.uib.inf101.sem2.minesweeper.model.GameState;

public interface ViewableMineSweeperModel {
  /**
   * checks the GridDimension
   * 
   * @return A GridDimension object
   */
  GridDimension getDimension();


  /**
   * Iterates over all the tiles on the board.
   * Gives all the positions on the board with their matching symbol
   * 
   * @return an Iterable object with Gridcells containing characters
   */
  Iterable<GridCell<Character>> getTilesOnBoard();

  /**
   * Iterates over all the so-called hidden tiles on the board.
   * @return an Iterable object with GridCells containing characters.
   */
  Iterable<GridCell<Character>> getHiddenTilesOnBoard();

  /** @return the gamestate */
  GameState getGameState();

}
