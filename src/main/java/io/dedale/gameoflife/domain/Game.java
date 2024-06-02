package io.dedale.gameoflife.domain;

import io.dedale.gameoflife.domain.world.World;

public class Game {
    private final World world;

    public Game(World world) {
        this.world = world;
    }

    public World world() {
        return world;
    }

}
