package io.dedale.gameoflife.infrastructure.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameCommandLineAdapterTest {

    @Test
    void initialize_game_with_default_size() {
        GameCommandLineAdapter gameCommandLineAdapter = new GameCommandLineAdapter();

        assertThat(gameCommandLineAdapter.displayGame()).isEqualToIgnoringNewLines(
                """
                        *
                        """);
    }

    @Test
    void update_game_once() {
        GameCommandLineAdapter game = new GameCommandLineAdapter();

        game.update();

        assertThat(game.displayGame()).isEqualToIgnoringNewLines(
                """
                        .
                        """);
    }
}