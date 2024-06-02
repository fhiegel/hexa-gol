package io.dedale.gameoflife.domain.world;

import io.dedale.gameoflife.domain.Cell;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public final class World {
    private final int width;
    private final int height;
    private final Map<Coordinates, Tile> tiles = new HashMap<>();

    public World(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public World put(int x, int y, Cell cell) {
        tiles.put(Coordinates.of(x, y), new Tile());
        return this;
    }

    public Optional<Tile> getTileAt(int x, int y) {
        return Optional.ofNullable(tiles.get(Coordinates.of(x, y)));
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (World) obj;
        return this.width == that.width &&
               this.height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "World[" +
               "width=" + width + ", " +
               "height=" + height + ']';
    }

}
