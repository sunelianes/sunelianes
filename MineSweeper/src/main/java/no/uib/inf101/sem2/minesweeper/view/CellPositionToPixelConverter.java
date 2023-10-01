package no.uib.inf101.sem2.minesweeper.view;

import java.awt.geom.Rectangle2D;

import no.uib.inf101.sem2.grid.CellPosition;
import no.uib.inf101.sem2.grid.GridDimension;

public class CellPositionToPixelConverter {
  // copied from my own lab4
  private Rectangle2D box;
  private GridDimension gd;
  private double margin;

  // constructor
  public CellPositionToPixelConverter(Rectangle2D box, GridDimension gd, double margin) {
    this.box = box;
    this.gd = gd;
    this.margin = margin;
  }

  /**
   * calculate width, heigth and cellPositions
   * to make a rectangle 
   * 
   * @param cp cellposition
   * @return a rectangle to be painted on the board
   */
  public Rectangle2D getBoundsForCell(CellPosition cp) {
    
    double cellWidth = (box.getWidth() - ((gd.cols() + 1) * margin)) / gd.cols();
    double cellX = box.getX() + (margin * (cp.col() + 1)) + (cellWidth * cp.col());

    double cellHeight = (box.getHeight() - ((gd.rows() + 1) * margin)) / (gd.rows());
    double cellY = box.getY() + (margin * (cp.row() + 1)) + (cellHeight * cp.row());

    // creates a rectangle with all the values just calculated
    Rectangle2D rectangle = new Rectangle2D.Double(cellX, cellY, cellWidth, cellHeight);

    return rectangle;
  }

}
