package no.uib.inf101.sem2.minesweeper.view;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class DefaultColorTheme implements ColorTheme {

  @Override 
  public BufferedImage getCellImage(Character c) {
    BufferedImage image = switch(c) {
      case 'h' -> Inf101Graphics.loadImageFromResources("/minesweeper_covered_tile.png");
      case 'v' -> Inf101Graphics.loadImageFromResources("minesweeper_visible_tile.png");
      case '*' -> Inf101Graphics.loadImageFromResources("/minesweeper_bomb.png");
      case 'f' -> Inf101Graphics.loadImageFromResources("minesweeper_flag.png");
      case '0' -> Inf101Graphics.loadImageFromResources("/minesweeper_0.png");
      case '1' -> Inf101Graphics.loadImageFromResources("/minesweeper_1.png");
      case '2' -> Inf101Graphics.loadImageFromResources("/minesweeper_2.png");
      case '3' -> Inf101Graphics.loadImageFromResources("/minesweeper_3.png");
      case '4' -> Inf101Graphics.loadImageFromResources("/minesweeper_4.png");
      case '5' -> Inf101Graphics.loadImageFromResources("/minesweeper_5.png");
      case '6' -> Inf101Graphics.loadImageFromResources("/minesweeper_6.png");
      case '7' -> Inf101Graphics.loadImageFromResources("/minesweeper_7.png");
      case '8' -> Inf101Graphics.loadImageFromResources("/minesweeper_8.png");
      default -> throw new IllegalArgumentException("Unexpected value: " + c);
    };
    return image;
  }

  @Override
  public Color getFrameColor() {
    return Color.BLACK;
  }

  @Override
  public Color getBackgroundColor() {
    return Color.WHITE;
  }

  @Override
  public Color gameOver() {
    return new Color(0, 0, 0, 128);
  }

  @Override
  public Color fontColor() {
    return Color.WHITE;
  }

  @Override
  public Color gameWon() {
    return new Color(0, 0, 0, 128);
  }

  @Override
  public Color pauseGame() {
    return Color.BLACK;
  }

  @Override
  public Color startGame() {
    return new Color(0, 0, 0, 128);
  }
}
