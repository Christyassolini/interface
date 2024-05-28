package br.univille.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LoggerConsole implements Logger {

    private static final String RESET = "\033[0m";
    private static final String GREEN = "\033[0;32m";
    private static final String YELLOW = "\033[0;33m";
    private static final String RED = "\033[0;31m";

    @Override
    public void log(Level level, String message) {
        String color;
        switch (level) {
            case DEBUG:
                color = GREEN;
                break;
            case WARNING:
                color = YELLOW;
                break;
            case ERROR:
                color = RED;
                break;
            default:
                color = RESET;
        }

        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(color + currentTime + " - " + level + ": " + message + RESET);
    }
}
