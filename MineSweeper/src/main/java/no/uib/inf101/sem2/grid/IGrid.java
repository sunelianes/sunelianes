package no.uib.inf101.sem2.grid;

public interface IGrid<E> extends GridDimension, Iterable<GridCell<E>> {
    /**
     * Sets the value of a position on the grid.
     * 
     * @param pos the cellposition to store the value in
     * @param value the new value
     * @throws IndexOutOfBoundsException if the position is not on the grid
     */
    void set(CellPosition pos, E value);

    /**
     *  Gets the current value at the given coordinate
     * 
     * @param pos the CellPosition to get the value
     * @return the value stored at the position
     * @throws IndexOutOfBoundsException if the position does not exist on the grid
     */
    E get(CellPosition pos);

    /**
     * Checks whether the position is within bounds for the grid
     * 
     * @param pos CellPosition to check
     * @return boolean based on if the pos is within bounds
     */
    boolean positionIsOnGrid(CellPosition pos);
}
