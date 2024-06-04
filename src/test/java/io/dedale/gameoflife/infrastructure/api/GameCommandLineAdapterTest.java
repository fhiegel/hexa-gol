package io.dedale.gameoflife.infrastructure.api;

import io.dedale.gameoflife.domain.Cell;
import io.dedale.gameoflife.domain.Game;
import io.dedale.gameoflife.domain.world.World;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameCommandLineAdapterTest {

    @Test
    void initialize_game_with_default_size() {
        GameCommandLineAdapter gameCommandLineAdapter = new GameCommandLineAdapter();

        assertThat(gameCommandLineAdapter.displayGame())
                .isEqualToIgnoringNewLines(
                        """
                                *
                                """);
    }

    @Test
    void initialize_custom_2x1_game() {
        Game game = new Game(new World(2, 1));
        GameCommandLineAdapter gameCommandLineAdapter = new GameCommandLineAdapter(game);

        assertThat(gameCommandLineAdapter.displayGame())
                .isEqualToIgnoringNewLines(
                        """
                                ..
                                """);
    }

    @Test
    void initialize_custom_2x2_game() {
        Game game = new Game(new World(2, 2));
        GameCommandLineAdapter gameCommandLineAdapter = new GameCommandLineAdapter(game);

        assertThat(gameCommandLineAdapter.displayGame())
                .isEqualTo(
                        """
                                ..
                                ..
                                """);
    }

    @Test
    void initialize_custom_2x2_game_with_alive_cell() {
        World world = new World(2, 2)
                .put(0, 0, Cell.alive());
        Game game = new Game(world);
        GameCommandLineAdapter gameCommandLineAdapter = new GameCommandLineAdapter(game);

        assertThat(gameCommandLineAdapter.displayGame())
                .isEqualTo(
                        """
                                *.
                                ..
                                """);
    }

    @Test
    void update_custom_3x3_game_with_oscillator() {
        World world = new World(3, 3)
                .put(1, 0, Cell.alive())
                .put(1, 1, Cell.alive())
                .put(1, 2, Cell.alive());
        GameCommandLineAdapter adapter = new GameCommandLineAdapter(new Game(world));

        assertThat(adapter.displayGame())
                .isEqualTo("""
                        ...
                        ***
                        ...
                        """);

        adapter.update();

        assertThat(adapter.displayGame())
                .isEqualTo("""
                        .*.
                        .*.
                        .*.
                        """);
    }

    @Test
    void update_game_once() {
        World world = new World(2, 2)
                .put(0, 0, Cell.alive());
        Game game = new Game(world);
        GameCommandLineAdapter gameAdapter = new GameCommandLineAdapter(game);

        gameAdapter.update();

        assertThat(gameAdapter.displayGame())
                .isEqualToIgnoringNewLines(
                        """
                                ..
                                ..
                                """);
    }
}