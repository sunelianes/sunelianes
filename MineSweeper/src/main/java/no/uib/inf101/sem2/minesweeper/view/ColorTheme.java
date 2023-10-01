package no.uib.inf101.sem2.minesweeper.view;

import java.awt.Color;
import java.awt.image.BufferedImage;

public interface ColorTheme {

  /**
   * loads an image from the resourcres, based on the character
   * @param c character
   * @return a buffered image to draw on the board
   */
  BufferedImage getCellImage(Character c);
  
  /**
   * gets the color that you want for the frame
   * 
   * @return the frame-color
   */
  Color getFrameColor();

  /**
   * gets the color that you want for the background
   * 
   * @return the background-color
   */
  Color getBackgroundColor();

  /**
   * gets the color that goes over the screen
   * when it is game over
   * 
   * @return the color for game over
   */
  Color gameOver();

  /**
   * gets the color that goes over the screen
   * when its paused
   * @return the color fro paused game
   */
  Color pauseGame();

  /**
   * gets the color that goes over the screen
   * at the start of the game
   * @return the color for unstarted game
   */
  Color startGame();
  /**
   * gets the color of winning-screen
   * 
   * @return the color of game won
   */
  Color gameWon();

  /**
   * gets the fontcolor for start/pause/gameover-screen
   * @return
   */
  Color fontColor();
}
