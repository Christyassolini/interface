package br.univille.log;

public class LoggerFactory {

    public static Logger onConsole() {
        return new LoggerConsole();
    }

    public static Logger onFile(String filename) {
        return new LoggerFile(filename);
    }
}