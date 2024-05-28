package br.univille.log;

public class Main {
    public static void main(String[] args) {
        Logger consoleLogger = LoggerFactory.onConsole();

        Logger fileLogger = LoggerFactory.onFile("log.txt");

        consoleLogger.log(Level.DEBUG, "This is a debug message.");
        consoleLogger.log(Level.WARNING, "This is a warning message.");
        consoleLogger.log(Level.ERROR, "This is an error message.");

        fileLogger.log(Level.DEBUG, "This is a debug message.");
        fileLogger.log(Level.WARNING, "This is a warning message.");
        fileLogger.log(Level.ERROR, "This is an error message.");
    }
}