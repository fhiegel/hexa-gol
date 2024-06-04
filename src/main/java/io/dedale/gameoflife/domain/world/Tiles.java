package io.dedale.gameoflife.domain.world;

import java.util.List;
import java.util.stream.Stream;

public class Tiles {
    private final List<Tile> tiles;

    public Tiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public Stream<Tile> stream() {
        return tiles.stream();
    }

}
