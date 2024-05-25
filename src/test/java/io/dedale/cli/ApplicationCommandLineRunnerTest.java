package io.dedale.cli;

import io.dedale.gameoflife.infrastructure.api.GameCommandLineAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class ApplicationCommandLineRunnerTest {

    private final CommandLineReaderFromStdIn reader = mock(CommandLineReaderFromStdIn.class);
    private final StringBuilder out = new StringBuilder();
    private final CommandLinePrinter printer = (String s) -> out.append(s).append(System.lineSeparator());
    private final GameCommandLineAdapter gameCommandLineAdapter = spy(new GameCommandLineAdapter());

    private ApplicationCommandLineRunner runner;

    @BeforeEach
    void initialize() {
        runner = new ApplicationCommandLineRunner(reader, printer, gameCommandLineAdapter);
    }

    @Test
    void run_application_and_stop_displays_new_world() {
        given(reader.readLine())
                .willReturn("s");

        runner.run();

        assertThat(out.toString()).isEqualToIgnoringNewLines(
                """
                        Hello World!
                        *
                        """);
        verify(gameCommandLineAdapter).displayGame();
        verifyNoMoreInteractions(gameCommandLineAdapter);
    }

    @Test
    void run_application_enter_input_before_stop_displays_new_worldt_then_input() {
        given(reader.readLine())
                .willReturn("input")
                .willReturn("s");

        runner.run();

        assertThat(out.toString()).isEqualToIgnoringNewLines(
                """
                        Hello World!
                        *
                        input
                        """);
        verify(gameCommandLineAdapter).displayGame();
        verifyNoMoreInteractions(gameCommandLineAdapter);
    }

}
