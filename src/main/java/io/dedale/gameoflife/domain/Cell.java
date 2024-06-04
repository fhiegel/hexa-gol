package io.dedale.gameoflife.domain;

public class Cell {
    private final LivingStatus livingStatus;

    private Cell(LivingStatus livingStatus) {
        this.livingStatus = livingStatus;
    }

    enum LivingStatus {
        ALIVE, DEAD
    }

    public static Cell alive() {
        return new Cell(LivingStatus.ALIVE);
    }

    public static Cell dead() {
        return new Cell(LivingStatus.DEAD);
    }

    public Cell evolves(long aliveCells) {
        if (aliveCells == 3) {
            return alive();
        }
        if (isAlive() && aliveCells == 2) {
            return alive();
        }
        return dead();
    }

    public boolean isAlive() {
        return LivingStatus.ALIVE.equals(livingStatus);
    }
}
