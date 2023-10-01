package no.uib.inf101.sem2.minesweeper.controller;


import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.minesweeper.model.GameState;
import no.uib.inf101.sem2.minesweeper.utils.ClickSquareException;

public interface ControllableMineSweeperModel {
  /**
   * First calculates what cellposition this will be
   * then calls for the other openHiddenSquare-method
   * this is done to make testing easier
   * @param x the X-coordinate, of for example the mouse
   * @param y the Y-coordinate, of for example the mouse
   * @param boardWidth width of the board
   * @param boardHeight heigth of the board
   * 
   * @return true if no exception is thrown
   * @throws OpenSquareException when it is not possible to open the square
   */
  boolean openHiddenSquare(int x, int y, int boardWidth, int boardHeigth) throws ClickSquareException;

  /**
   * Open up a square from hidden to visible on a board.
   * Should also end game if the opened square is a mine.
   * If the opened square is empty, open the surrounding ones.
   * mutates the hiddenboard
   * @param pos
   * @return true if no exception is thrown
   * @throws ClickSquareException when it is not possible to open the square
   */
  boolean openHiddenSquare(CellPosition pos) throws ClickSquareException;

  /**
   * First calculate what cellposition this will be
   * calls for the other setFlag-method
   * @param x the X-coordinate, of for example the mouse
   * @param y the Y-coordinate, of for example the mouse
   * @param boardWidth width of the board
   * @param boardHeight heigth of the board
   * 
   * @return true if no exception is thrown
   * @throws ClickSquareException when it is not possible to set a flag here
   */
  boolean setFlag(int x, int y, int boardWidth, int boardHeight) throws ClickSquareException;

  /**
   * Sets a flag if the tile is hidden
   * Takes away flag if there is one
   * mutates the hiddenboard
   * @param pos CellPosition to set flag
   * @return true if no exception is thrown
   * @throws ClickSquareException when it is not possible to set a flag there
   */
  boolean setFlag(CellPosition pos) throws ClickSquareException;
  
  /**
   * sets the gamestate of this
   * @param gameState
   */
  void setGameState(GameState gameState);

  /**
   * gets the gamestate
   * @return the gamestate
   */
  GameState getGameState();
}
