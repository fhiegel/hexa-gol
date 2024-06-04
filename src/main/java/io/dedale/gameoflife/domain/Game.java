package io.dedale.gameoflife.domain;

import io.dedale.gameoflife.domain.world.Tile;
import io.dedale.gameoflife.domain.world.Tiles;
import io.dedale.gameoflife.domain.world.World;

public class Game {
    private final World world;

    public Game(World world) {
        this.world = world;
    }

    public World world() {
        return world;
    }

    public Game update() {

        World newWorld = new World(world().width(), world().height());
        for (int x = 0; x < world.width(); x++) {
            for (int y = 0; y < world.height(); y++) {
                Tile tile = world.getTileAt(x, y)
                        .orElseGet(Tile::new);

                Tiles neighbors = world.getNeighborsOf(x, y);
                long aliveCells = neighbors.stream().filter(Tile::containsAliveCell).count();
                Cell evolves = tile.getCell().evolves(aliveCells);
                newWorld = newWorld.put(x, y, evolves);
            }
        }

        return new Game(newWorld);
    }
}
