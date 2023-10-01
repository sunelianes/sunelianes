package no.uib.inf101.sem2.minesweeper.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.Grid;
import no.uib.inf101.sem2.grid.GridCell;

public class MineSweeperBoard extends Grid<Character>{

  private int mineCount;
  // constructor
  public MineSweeperBoard(int rows, int cols, int mineCount) {
    super(rows, cols, '-');
    this.mineCount = mineCount;
    GenerateMines();
    GenerateNumbers();
  }

  private void GenerateMines(){
  // create a temporary to not mess with the mineCount
    int tempMineCount = mineCount;
    while (tempMineCount > 0) {
      Random randomInt = new Random();
      // create random Row and Col 
      int randomRow = randomInt.nextInt(this.rows());
      int randomCol = randomInt.nextInt(this.cols());
      // create cellposition from the randoms
      CellPosition pos = new CellPosition(randomRow, randomCol);

      if (!isPosAMine(pos) && positionIsOnGrid(pos)){
        this.set(pos, '*'); // sets down a mine
        tempMineCount--;
      }  
    }
  }

  // this is tested manually 
  // no need to risk anything else being able to generate the numbers
  private void GenerateNumbers(){
    for (GridCell<Character> gridCell : this) {
      CellPosition pos = gridCell.pos();
      if (!isPosAMine(pos) && positionIsOnGrid(pos)) {
        this.set(pos, countSurroundingMines(pos));
      }
    }
  }

  /** @return the mineCount */
  int getMineCount() {return mineCount;}

  private char countSurroundingMines(CellPosition pos) {
    int minesAroundPos = 0;

    for (CellPosition otherPos : positionsOfSurroundingTiles(pos)) {
      if (positionIsOnGrid(otherPos) && isPosAMine(otherPos)){
        minesAroundPos++;
      }   
    }
    char c = intToCharConverter(minesAroundPos);
    return c;
  }

  private char intToCharConverter(int i) {
    if(i == 1) {return '1';}
    else if (i == 2) {return '2';} 
    else if (i == 3) {return '3';} 
    else if (i == 4) {return '4';} 
    else if (i == 5) {return '5';} 
    else if (i == 6) {return '6';} 
    else if (i == 7) {return '7';} 
    else if (i == 8) {return '8';} 
    else {return '0';}
  }

  /**
   * Calculates all 8 surrounding tiles from the CellPosition.
   * @param pos CellPosition to calculate from
   * @return a list containg all 8 surrounding tiles
   */
  List<CellPosition> positionsOfSurroundingTiles(CellPosition pos) {
    // northwest from the position and so on
    CellPosition northWest = new CellPosition((pos.row() - 1), (pos.col() - 1));
    CellPosition north = new CellPosition((pos.row() - 1), pos.col());
    CellPosition northEast = new CellPosition((pos.row() - 1), (pos.col() + 1));
    CellPosition east = new CellPosition(pos.row(), (pos.col() + 1));
    CellPosition southEast = new CellPosition((pos.row() + 1), (pos.col() + 1));
    CellPosition south = new CellPosition((pos.row() + 1), pos.col());
    CellPosition southWest = new CellPosition((pos.row() + 1), (pos.col() - 1));
    CellPosition west = new CellPosition(pos.row(), (pos.col() - 1));

    List<CellPosition> surroundingCellsList = new ArrayList<>(
      (Arrays.asList(northWest, north, northEast, east, 
      southEast, south, southWest, west)));

    return surroundingCellsList;
  }

  boolean isPosAMine(CellPosition pos) {
    return(this.get(pos) == '*') ;
  }

  /**
   * used for a test
   * changes the boards values into a string
   * 
   * @return the string-representation of the board-values
   */
  String prettyString() {
    String myString = new String();
    for (int i = 0; i < this.rows(); i++) {
      if (i!= 0) {myString += "\n";}
      for (int j = 0; j < this.cols(); j++) {
        myString += (this.get(new CellPosition(i, j)));
      }
    } return myString;
  }  
}
