package no.uib.inf101.sem2.minesweeper.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.minesweeper.utils.ClickSquareException;

public class MineSweeperModelTest {


    @Test
    public void openHiddenSquareTest() throws ClickSquareException {
      MineSweeperBoard board = new MineSweeperBoard(5, 5, 0);
      HiddenBoard hiddenBoard = new HiddenBoard(board);
      MineSweeperModel model = new MineSweeperModel(board, hiddenBoard);
      CellPosition zeroPos = new CellPosition(0, 0);

      assertTrue(hiddenBoard.get(zeroPos) == 'h');
      model.openHiddenSquare(zeroPos);
      assertTrue(hiddenBoard.get(zeroPos) == 'v');
      assertThrows(ClickSquareException.class, () -> model.openHiddenSquare(zeroPos));
      hiddenBoard.set(zeroPos, 'f');
      assertThrows(ClickSquareException.class, () -> model.openHiddenSquare(zeroPos));
    }

    @Test
    public void setFlagTest() throws ClickSquareException {
      MineSweeperBoard board = new MineSweeperBoard(5, 5, 1);
      HiddenBoard hiddenBoard = new HiddenBoard(board);
      MineSweeperModel model = new MineSweeperModel(board, hiddenBoard);
      CellPosition zeroPos = new CellPosition(0, 0);

      assertTrue(hiddenBoard.get(zeroPos) == 'h');
      model.setFlag(zeroPos);
      assertTrue(hiddenBoard.get(zeroPos) == 'f');
      assertFalse(hiddenBoard.get(zeroPos) == 'h');
      model.setFlag(zeroPos);
      assertTrue(hiddenBoard.get(zeroPos) == 'h');
      hiddenBoard.set(zeroPos, 'v');
      assertThrows(ClickSquareException.class, () -> model.setFlag(zeroPos));
    }
}
