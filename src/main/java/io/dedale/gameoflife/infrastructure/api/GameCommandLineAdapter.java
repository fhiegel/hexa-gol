package io.dedale.gameoflife.infrastructure.api;

import io.dedale.gameoflife.domain.Cell;
import io.dedale.gameoflife.domain.Game;
import io.dedale.gameoflife.domain.world.Tile;
import io.dedale.gameoflife.domain.world.World;

public class GameCommandLineAdapter {

    private static final String DISPLAY_ALIVE = "*";
    private static final String DISPLAY_DEAD = ".";
    private Game game;

    private String cell;

    public GameCommandLineAdapter() {
        this(new Game(new World(1, 1).put(0,0, Cell.alive())));
    }

    public GameCommandLineAdapter(Game game) {
        this.game = game;
        cell = DISPLAY_ALIVE;
    }

    public String displayGame() {
        World world = game.world();
        return displayWorld(world);
    }

    private String displayWorld(World world) {
        int width = world.width();
        if (width == 1) {
            return cell;
        }
        StringBuilder row = new StringBuilder();
        for (int x = 0; x < world.width(); x++) {
            for (int y = 0; y < world.height(); y++) {
                String tileDisplayed = world.getTileAt(x, y)
                        .filter(Tile::containsAliveCell)
                        .map(t -> DISPLAY_ALIVE)
                        .orElse(DISPLAY_DEAD);
                row.append(tileDisplayed);
            }
            row.append("\n");
        }
        return row.toString();
    }

    public void update() {
        cell = DISPLAY_DEAD; // TODO
    }
}
