package io.dedale.cli;

public class ApplicationCommandLineRunner {

    private final CommandLineReader reader;
    private final CommandLinePrinter printer;

    public ApplicationCommandLineRunner() {
        this(defaultReader(), defaultPrinter());
    }

    ApplicationCommandLineRunner(CommandLineReader reader, CommandLinePrinter printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public void run() {
        printer.print("Hello World!");
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