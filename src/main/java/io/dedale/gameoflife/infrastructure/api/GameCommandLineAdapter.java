package io.dedale.gameoflife.infrastructure.api;

public class GameCommandLineAdapter {

    private static final String DISPLAY_ALIVE = "*";
    private static final String DISPLAY_DEAD = ".";

    private String cell = DISPLAY_ALIVE;

    public String displayGame() {
        return cell;
    }

    public void update() {
        cell = DISPLAY_DEAD;
    }
}
