import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

class Logger {
    public enum Level {
        DEBUG, WARNING, ERROR
    }

    private static boolean consoleMode = true;
    private static String logFileName = "log.txt";

    public static void setFileMode() {
        consoleMode = false;
    }

    public static void setConsoleMode() {
        consoleMode = true;
    }

    public static void setLogFileName(String fileName) {
        logFileName = fileName;
    }

    public static void log(Level level, String message) {
        String formattedMessage = formatMessage(level, message);

        if (consoleMode) {
            printToConsole(level, formattedMessage);
        } else {
            writeToFile(formattedMessage);
        }
    }

    private static String formatMessage(Level level, String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(new Date());
        return "[" + currentTime + "] [" + level.toString() + "] " + message;
    }

    private static void printToConsole(Level level, String formattedMessage) {
        switch (level) {
            case DEBUG:
                System.out.println("\u001B[32m" + formattedMessage + "\u001B[0m");
                break;
            case WARNING:
                System.out.println("\u001B[33m" + formattedMessage + "\u001B[0m");
                break;
            case ERROR:
                System.out.println("\u001B[31m" + formattedMessage + "\u001B[0m");
                break;
        }
    }

    private static void writeToFile(String formattedMessage) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFileName, true))) {
            writer.println(formattedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Logger.setFileMode();

        Logger.log(Level.DEBUG, "Mensagem de debug");
        Logger.log(Level.WARNING, "Aviso: Algo pode estar errado");
        Logger.log(Level.ERROR, "Erro: Algo deu errado");

        Logger.setConsoleMode();

        Logger.log(Level.DEBUG, "Outra mensagem de debug");
        Logger.log(Level.WARNING, "Outro aviso");
        Logger.log(Level.ERROR, "Outro erro");
    }
}
