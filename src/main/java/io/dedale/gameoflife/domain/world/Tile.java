package io.dedale.gameoflife.domain.world;

import io.dedale.gameoflife.domain.Cell;

public class Tile {
    private Cell cell;

    public Tile(Cell cell) {
        this.cell = cell;
    }

    public Tile() {
        this(Cell.dead());
    }

    public boolean containsAliveCell() {
        return cell.isAlive();
    }

    public Cell getCell() {
        return cell;
    }
}
