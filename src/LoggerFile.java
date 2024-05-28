package br.univille.log;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LoggerFile implements Logger {

    private final String filename;

    public LoggerFile(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(Level level, String message) {
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(currentTime + " - " + level + ": " + message + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}