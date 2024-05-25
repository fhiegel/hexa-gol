package io.dedale.cli;

import io.dedale.gameoflife.infrastructure.api.GameCommandLineAdapter;

public class ApplicationCommandLineRunner {

    private final CommandLineReader reader;
    private final CommandLinePrinter printer;
    private final GameCommandLineAdapter game;

    public ApplicationCommandLineRunner() {
        this(defaultReader(), defaultPrinter(), new GameCommandLineAdapter());
    }

    ApplicationCommandLineRunner(CommandLineReader reader,
                                 CommandLinePrinter printer,
                                 GameCommandLineAdapter game) {
        this.reader = reader;
        this.printer = printer;
        this.game = game;
    }

    public void run() {
        printer.print("Hello World!");
        printer.print(game.displayGame());
        while (true) {
            String line = reader.readLine();
            if (line.equals("s")) {
                return;
            }
            printer.print(line);
        }
    }

    private static CommandLineReaderFromStdIn defaultReader() {
        return new CommandLineReaderFromStdIn();
    }

    private static CommandLinePrinter defaultPrinter() {
        return new CommandLinePrinterToStdOut();
    }

}