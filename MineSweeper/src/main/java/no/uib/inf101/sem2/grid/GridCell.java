package no.uib.inf101.sem2.grid;

/**
 * A GridCell consists of a CellPosition and a value
 * 
 * @param pos the CellPosition of a cell (row and column)
 * @param value the value placed in the cell
 */
public record GridCell<E>(CellPosition pos, E value) {
    
}
