package cl.picoctl;

import cl.picoctl.config.AppCommands;
import cl.picoctl.config.PicocliCompleter;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import picocli.CommandLine;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        CommandLine commandLine = new CommandLine(new AppCommands());

        Terminal terminal = TerminalBuilder.terminal();

        LineReader reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(new PicocliCompleter(AppCommands.class))
                .build();

        while (true) {
            String prompt = buildPrompt();
            String input = reader.readLine(prompt);

            String response = processInput(input, commandLine);

            terminal.writer().println(response);
            terminal.flush();
        }
    }

    private static String buildPrompt() {
        AttributedStringBuilder promptBuilder = new AttributedStringBuilder()
                .style(AttributedStyle.DEFAULT.background(AttributedStyle.GREEN).foreground(AttributedStyle.BLACK))
                .append(" my-cli ")
                .style(AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN))
                .append("\uE0B0 ");// 

        return promptBuilder.toAnsi();
    }

    private static String processInput(String input, CommandLine commandLine) {
        String[] inputArgs = input.split(" ");

        int exitCode = commandLine.execute(inputArgs);
        return "Exit code: " + exitCode;
    }

}
