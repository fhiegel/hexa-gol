package io.dedale.cli;

import java.io.PrintStream;

class CommandLinePrinterToStdOut implements CommandLinePrinter {
    private final PrintStream printer;

    CommandLinePrinterToStdOut() {
        this.printer = System.out;
    }

    @Override
    public void print(String string) {
        printer.println(string);
    }
}