package no.uib.inf101.sem2.minesweeper.view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;

public class ColorThemeTest {
  @Test
  public void sanityTestDefaultColorTheme() {
    ColorTheme colors = new DefaultColorTheme();
    assertEquals(Color.WHITE, colors.getBackgroundColor());
    assertEquals(Color.BLACK, colors.getFrameColor());
    assertEquals(new Color(0, 0, 0, 128), colors.gameOver());
    assertEquals(new Color(0, 0, 0, 128), colors.gameWon());
    assertEquals(Color.WHITE, colors.fontColor());
    assertEquals(new Color(0, 0, 0, 128), colors.startGame());
    assertEquals(Color.BLACK, colors.pauseGame());
    assertThrows(IllegalArgumentException.class, () -> colors.getCellImage('\n'));

  }
}
