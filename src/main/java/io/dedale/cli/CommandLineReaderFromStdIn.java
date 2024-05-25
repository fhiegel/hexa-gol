package io.dedale.cli;

import java.util.Scanner;

class CommandLineReaderFromStdIn implements CommandLineReader {
    final Scanner scanner;

    CommandLineReaderFromStdIn() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}