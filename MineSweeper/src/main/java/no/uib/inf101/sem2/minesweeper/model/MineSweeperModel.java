package no.uib.inf101.sem2.minesweeper.model;


import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.GridCell;
import no.uib.inf101.sem2.grid.GridDimension;
import no.uib.inf101.sem2.minesweeper.controller.ControllableMineSweeperModel;
import no.uib.inf101.sem2.minesweeper.utils.ClickSquareException;
import no.uib.inf101.sem2.minesweeper.view.ViewableMineSweeperModel;

public class MineSweeperModel implements ControllableMineSweeperModel, ViewableMineSweeperModel {
    
  private MineSweeperBoard mineSweeperBoard;
  private GameState gameState = GameState.START_GAME;
  private HiddenBoard hiddenBoard;
  private int flagCount;
    
  public MineSweeperModel(MineSweeperBoard mineSweeperBoard, HiddenBoard hiddenBoard) {
    this.mineSweeperBoard = mineSweeperBoard;
    this.hiddenBoard = hiddenBoard;
    // you can only have as many flags as there are bombs
    this.flagCount = hiddenBoard.getHiddenMines();
  }
    
  @Override
  public GridDimension getDimension() {return mineSweeperBoard;}
  
  @Override
  public Iterable<GridCell<Character>> getTilesOnBoard() {return mineSweeperBoard;}
  
  
  @Override
  public Iterable<GridCell<Character>> getHiddenTilesOnBoard() {return hiddenBoard;}
    
    
  @Override
  public boolean openHiddenSquare(CellPosition pos) throws ClickSquareException {
  
    if(hiddenBoard.get(pos) == 'v' || hiddenBoard.get(pos) == 'f') {
      // if already opened or flag on it
      throw new ClickSquareException("You can't open this square");
    }
    if (hiddenBoard.get(pos) == 'h') {
      hiddenBoard.set(pos, 'v');
      if (mineSweeperBoard.get(pos) == '0') {
        // if user hits a empty cell, more opens up
        openSquaresWhenZero(pos);
      } else if (mineSweeperBoard.isPosAMine(pos)) {
        // if user hits a mine, game over
        setGameState(GameState.GAME_OVER);
      }
    }
    if (hiddenBoard.gameWon()) {
      // if all tiles that are not bombs are opened
      setGameState(GameState.GAME_WON);
    } 
    return true;
  }
    
    
  @Override
  public boolean openHiddenSquare(int x, int y, int boardWidth, 
                                  int boardHeigth) throws ClickSquareException{
    CellPosition pos = calculatePosFromCoordinates(x, y, boardWidth, boardHeigth);
    return openHiddenSquare(pos);
  }
    
  @Override
  public boolean setFlag(CellPosition pos) throws ClickSquareException {
    if (hiddenBoard.get(pos) == 'v') {
      // if opened
      throw new ClickSquareException("You can't put a flag on this square");
    }
    
    // check if hidden or flag on it already
    if (hiddenBoard.get(pos) == 'h' && flagCount>0) {
      hiddenBoard.set(pos, 'f');
      flagCount--;  
    } else if (hiddenBoard.get(pos) == 'f') {
      hiddenBoard.set(pos, 'h');
      flagCount++;
    } 
    return true;
  }
    
  @Override
  public boolean setFlag(int x, int y, int boardWidth, 
                         int boardHeight) throws ClickSquareException {
    CellPosition pos = calculatePosFromCoordinates(x, y, boardWidth, boardHeight);
    return setFlag(pos);
  }
    
    
  private CellPosition calculatePosFromCoordinates(int x, int y, 
  int boardWidth, int boardHeigth) {
    int tempCol = x / (boardWidth / getDimension().cols());
    int tempRow = y / (boardHeigth / getDimension().rows());
    CellPosition pos = new CellPosition(tempRow,tempCol);
    return pos;
  }
    
    
  private void openSquaresWhenZero(CellPosition pos) {
    for (CellPosition otherPos : mineSweeperBoard.positionsOfSurroundingTiles(pos)) {
      // checks if it is hidden, then opens it
      if (mineSweeperBoard.positionIsOnGrid(otherPos) && hiddenBoard.get(otherPos) == 'h') {
        hiddenBoard.set(otherPos, 'v');
        
        // if this also is 0, it continues recursively
        if (mineSweeperBoard.get(otherPos) == '0') {
            openSquaresWhenZero(otherPos);
        }
      }
    }
  }
    
    
  @Override
  public GameState getGameState() {return gameState;}
  
  
  @Override
  public void setGameState(GameState gameState) {
    this.gameState = gameState;
  }
}
