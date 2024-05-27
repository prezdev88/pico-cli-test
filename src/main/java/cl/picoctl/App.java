package cl.picoctl;

import cl.picoctl.config.AppCommands;
import cl.picoctl.config.PicocliCompleter;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
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
            String input = reader.readLine(">> ");
            String[] inputArgs = input.split(" ");

            int exitCode = commandLine.execute(inputArgs);
            System.out.println("Exit code: " + exitCode);
        }
    }

}
