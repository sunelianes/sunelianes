package no.uib.inf101.sem2.minesweeper.view;

import no.uib.inf101.sem2.grid.GridCell;
import no.uib.inf101.sem2.minesweeper.model.GameState;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.Font;


public class MineSweeperView extends JPanel{
  
  private ColorTheme colorTheme;
  private ViewableMineSweeperModel model;
  private static final int MARGIN = 2;
  private int cellSize = 25;
  private int heigth;
  private int width;
  // constructor
  public MineSweeperView(ViewableMineSweeperModel model) {
    this.colorTheme = new DefaultColorTheme();
    this.setBackground(colorTheme.getBackgroundColor());
    this.model = model;
    this.setFocusable(true);
    this.width = (cellSize + MARGIN) * (model.getDimension().cols() + MARGIN);
    this.heigth =  (cellSize+MARGIN) * (model.getDimension().rows() + MARGIN);
    this.setPreferredSize(new Dimension(width, heigth));
  }

  // The paintComponent method is called by the Java Swing framework every time
  // either the window opens or resizes, or we call .repaint() on this object. 
  // Note: NEVER call paintComponent directly yourself
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    drawGame(g2);
  }

  /**
   * actually paints the whole game with correct dimensions and colors
   * calls drawCells to draw specific values 
   * 
   * @param g2 a Graphics2D-object
   */
  private void drawGame(Graphics2D g2) {

    // how to make a set distance to the edges
    // from course-notes/grafikk/adaptiv-tegning
    double x = MARGIN; 
    double y = MARGIN;
    double width = this.getWidth() - (2 * MARGIN);
    double height = this.getHeight() - (2 * MARGIN);
    
    // creating the frame and measurements for the board
    Rectangle2D rectangle = new Rectangle2D.Double(x, y, width, height);
    g2.setColor(colorTheme.getFrameColor()); 
    g2.fill(rectangle);

    CellPositionToPixelConverter celPosToPixConverter = 
    new CellPositionToPixelConverter(rectangle, model.getDimension(), MARGIN);
    
    drawCells(g2, model.getTilesOnBoard(), celPosToPixConverter, colorTheme);
    drawCells(g2, model.getHiddenTilesOnBoard(), celPosToPixConverter, colorTheme);

    if (model.getGameState() == GameState.START_GAME) {
      setStartScreen(g2, rectangle);
    }

    if (model.getGameState() == GameState.PAUSE_GAME) {
      setPauseScreen(g2, rectangle);
    }

    if (model.getGameState() == GameState.GAME_OVER) {
      setGameOver(g2, rectangle);
    }

    if (model.getGameState() == GameState.GAME_WON) {
      setGameWon(g2, rectangle);
    }
  }
  /**
   * draws single cells onto the board
   * 
   * @param g2 a Graphics2D-object
   * @param iteratorList a list of GridCells we can iterate over
   * @param celPosToPixConverter converts the CellPostion to Pixels
   * @param colorTheme refers to which picture should be painted
   */
  private static void drawCells (Graphics2D g2, Iterable<GridCell<Character>> iteratorList,
    CellPositionToPixelConverter celPosToPixConverter, ColorTheme colorTheme ) {
    for (GridCell<Character> gridCell : iteratorList) {
      Rectangle2D tempRectangle = celPosToPixConverter.getBoundsForCell(gridCell.pos());
      BufferedImage image = colorTheme.getCellImage(gridCell.value());
      int w = tempRectangle.getBounds().width;
      int h = tempRectangle.getBounds().height;
      Image newImage = image.getScaledInstance(w, h, Image.SCALE_FAST);
      
      Inf101Graphics.drawImage(g2, newImage, 
      tempRectangle.getX(), tempRectangle.getY(), 1);
    }
  }
  private void setStartScreen(Graphics2D g2, Rectangle2D rectangle) {
    g2.setColor(colorTheme.startGame());
    g2.fill(rectangle);
    g2.setFont(new Font("Arial", Font.BOLD, 30));
    g2.setColor(colorTheme.fontColor());
    Inf101Graphics.drawCenteredString(g2, "MINESWEEPER!", rectangle);

    g2.setColor(colorTheme.fontColor());
    g2.setFont(new Font("Arial", Font.CENTER_BASELINE, 15)); 
    Inf101Graphics.drawCenteredString(g2, "PRESS THE SCREEN TO PLAY", 
    rectangle.getCenterX(), rectangle.getMaxY() - (rectangle.getCenterY() / 2));
  }

  private void setPauseScreen(Graphics2D g2, Rectangle2D rectangle) {
    g2.setColor(colorTheme.pauseGame());
    g2.fill(rectangle);
    g2.setFont(new Font("Arial", Font.BOLD, 30));
    g2.setColor(colorTheme.fontColor()); 
    Inf101Graphics.drawCenteredString(g2, "PAUSED GAME", rectangle);

    g2.setColor(colorTheme.fontColor());
    g2.setFont(new Font("Arial", Font.CENTER_BASELINE, 15)); 
    Inf101Graphics.drawCenteredString(g2, "PRESS THE 'P' to continue", 
    rectangle.getCenterX(), rectangle.getMaxY() - (rectangle.getCenterY()/2));
  }
  
  private void setGameOver(Graphics2D g2, Rectangle2D rectangle) {
    g2.setColor(colorTheme.gameOver());
    g2.fill(rectangle);
    g2.setFont(new Font("Arial", Font.BOLD, 30));
    g2.setColor(colorTheme.fontColor());
    Inf101Graphics.drawCenteredString(g2, "GAME OVER", rectangle);
  }

  private void setGameWon(Graphics2D g2, Rectangle2D rectangle) {
    g2.setColor(colorTheme.gameWon());
    g2.fill(rectangle);
    g2.setFont(new Font("Arial", Font.BOLD, 30));
    g2.setColor(colorTheme.fontColor());
    Inf101Graphics.drawCenteredString(g2, "YOU WON!", rectangle);
  }
}
