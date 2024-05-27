package cl.picoctl.config;

import cl.picoctl.command.ByeCommand;
import cl.picoctl.command.HelloCommand;
import cl.picoctl.command.QuitCommand;
import picocli.CommandLine.Command;

@Command(
        name = "app",
        mixinStandardHelpOptions = true,
        version = "app 1.0",
        description = "Command app description",
        subcommands = {HelloCommand.class, ByeCommand.class, QuitCommand.class}
)
public class AppCommands {
}
