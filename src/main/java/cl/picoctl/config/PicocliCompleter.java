package cl.picoctl.config;

import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;
import picocli.CommandLine;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PicocliCompleter implements Completer {

    private final Set<String> commands;

    public PicocliCompleter(Class<?> commandClass) {
        CommandLine commandLine = new CommandLine(commandClass);
        this.commands = commandLine.getSubcommands().values().stream()
                .map(CommandLine::getCommandName)
                .collect(Collectors.toSet());
    }

    @Override
    public void complete(LineReader lineReader, ParsedLine parsedLine, List<Candidate> list) {
        StringsCompleter stringsCompleter = new StringsCompleter(commands);
        stringsCompleter.complete(lineReader, parsedLine, list);
    }
}
