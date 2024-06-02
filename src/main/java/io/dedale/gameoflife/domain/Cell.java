package io.dedale.gameoflife.domain;

public class Cell {
    private Cell() {
    }

    public static Cell alive() {
        return new Cell();
    }
}
