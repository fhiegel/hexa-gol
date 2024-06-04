package io.dedale.gameoflife.domain.world;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public final class Coordinates {
    private final int x;
    private final int y;

    private Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates of(int x, int y) {
        return new Coordinates(x, y);
    }

    public Collection<Coordinates> neighbors() {
        return IntStream.rangeClosed(x - 1, x + 1)
                .boxed()
                .flatMap(xx -> IntStream.rangeClosed(y - 1, y + 1).mapToObj(yy -> new Coordinates(xx, yy)))
                .filter(not(this::equals))
                .toList();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Coordinates) obj;
        return this.x == that.x &&
               this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates[" +
               "x=" + x + ", " +
               "y=" + y + ']';
    }
}
