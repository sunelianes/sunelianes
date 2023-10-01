package no.uib.inf101.sem2.grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grid<E> implements IGrid<E>{

  private final int rows;
  private final int cols;
  private final ArrayList<ArrayList<E>> grid;

  // Constructor 1
  public Grid(int rows, int cols, E defaultValue) {
    if (rows <= 0 || cols <= 0) {
      throw new IllegalArgumentException("Both rows and cols need to be higher than zero");
    }
    this.rows = rows;
    this.cols = cols;
    this.grid = new ArrayList<>();

    for (int row = 0; row<rows; row++) {
      // adds a list per row
      this.grid.add(new ArrayList<>()); 
      for (int col = 0; col < cols; col++) {
        // adds the defaultValue per column in the row
        this.grid.get(row).add(col, defaultValue); 
      }
    }
  }

  // Constructor 2
  public Grid(int rows, int cols) {
    this(rows, cols, null);
  }

  @Override
  public int rows() {return this.rows;}

  @Override
  public int cols() {return this.cols;}

  @Override
  public Iterator<GridCell<E>> iterator() {
    // make object of type List<GridCell<E>>
    List<GridCell<E>> gridCellList = new ArrayList<>();

    // loop through all coordinates of the grid
    for (int i = 0; i < this.rows(); i++) {
      for (int j = 0; j < this.cols(); j++) {
        CellPosition pos = new CellPosition(i, j);
        // for every position, make a GridCell<E> and add to list
        GridCell<E> gCell = new GridCell<E>(pos, this.grid.get(i).get(j));
        gridCellList.add(gCell);
      }
    } return gridCellList.iterator();
  }

  @Override
  public void set(CellPosition pos, E value) {
    this.grid.get(pos.row()).set(pos.col(), value); 
  }

  @Override
  public E get(CellPosition pos) {
    return this.grid.get(pos.row()).get(pos.col()); 
  }

  @Override
  public boolean positionIsOnGrid(CellPosition pos) {
    if (!((pos.row() < this.rows()) && (pos.col() < this.cols()))){
      return false;
    }
    if (!(pos.row() >= 0 && pos.col() >= 0)) { 
      return false;
    } return true; 
  }
}
