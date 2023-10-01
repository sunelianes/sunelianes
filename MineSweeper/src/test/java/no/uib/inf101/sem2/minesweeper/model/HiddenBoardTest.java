package no.uib.inf101.sem2.minesweeper.model;

import org.junit.jupiter.api.Test;

import no.uib.inf101.sem2.grid.GridCell;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HiddenBoardTest {
    MineSweeperBoard mineSweeperBoard = new MineSweeperBoard(3, 3, 8);
    HiddenBoard hiddenBoard = new HiddenBoard(mineSweeperBoard);
    
    @Test
    public void isSameSizeAsMineSweeperBoard() {
      assertEquals(mineSweeperBoard.cols(), hiddenBoard.cols());
      assertEquals(mineSweeperBoard.rows(), hiddenBoard.rows());
    }

    @Test
    public void gameWonTest() {
      int expectedMineCount = mineSweeperBoard.getMineCount();
      int actualMineCount = hiddenBoard.getHiddenMines();
      assertEquals(expectedMineCount, actualMineCount);

      int expectedHiddenTileCount = 9;
      int actualHiddenTileCount = hiddenBoard.getHiddenTiles();
      assertEquals(expectedHiddenTileCount, actualHiddenTileCount);

      assertFalse(hiddenBoard.gameWon());

      for (GridCell<Character> gridCell : hiddenBoard) {
        if (gridCell.value() == 'h' && !mineSweeperBoard.isPosAMine(gridCell.pos())) {
          hiddenBoard.set(gridCell.pos(), 'v');
        }
      }
      assertTrue(hiddenBoard.gameWon());
  
      
  }
}
