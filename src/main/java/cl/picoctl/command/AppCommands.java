package cl.picoctl.command;

import picocli.CommandLine.Command;

@Command(
        name = "app",
        mixinStandardHelpOptions = true,
        version = "app 1.0",
        description = "Command app description",
        subcommands = {HelloCommand.class, ByeCommand.class})
public class AppCommands {
}
