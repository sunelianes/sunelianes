package no.uib.inf101.sem2.minesweeper.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.GridCell;

public class MineSweeperBoardTest {

  @Test
  public void testMines() {
    MineSweeperBoard board = new MineSweeperBoard(3, 3, 3);
    int expectedMineCount = 3;
    int actualMineCount = board.getMineCount();
    assertEquals(expectedMineCount, actualMineCount);

    int maunalMineCount = 0;
    for (GridCell<Character> gridCell : board) {
      if (board.isPosAMine(gridCell.pos())) {
        maunalMineCount++;
      }
    }
    assertEquals(expectedMineCount, maunalMineCount);
  }

  @Test
  public void testPosOfSurroundingTiles() {
    MineSweeperBoard board = new MineSweeperBoard(3, 3, 0);
    CellPosition pos = new CellPosition(1, 1);
    CellPosition northWest = new CellPosition(0,0);
    CellPosition north = new CellPosition(0,1);
    CellPosition northEast = new CellPosition(0,2);
    CellPosition east = new CellPosition(1,2);
    CellPosition southEast = new CellPosition(2,2);
    CellPosition south = new CellPosition(2,1);
    CellPosition southWest = new CellPosition(2,0);
    CellPosition west = new CellPosition(1,0);

    List<CellPosition> expectedPosList= new ArrayList<>( 
      Arrays.asList(northWest, north, northEast, east, 
      southEast, south, southWest, west));
    List<CellPosition> actualPosList = board.positionsOfSurroundingTiles(pos);

    for (int index = 0; index < actualPosList.size(); index++) {
      assertEquals(expectedPosList.get(index), actualPosList.get(index));
    }
  }

  @Test
  public void testPrettyString() {
    MineSweeperBoard board = new MineSweeperBoard(3, 4, 0);
    board.set(new CellPosition(0, 0), 'g');
    board.set(new CellPosition(0, 3), 'y');
    board.set(new CellPosition(2, 0), 'r');
    board.set(new CellPosition(2, 3), 'b');
    String expected = String.join("\n", new String[] {
      "g00y",
      "0000",
      "r00b"
    });
    assertEquals(expected, board.prettyString());
  }


}
