package cl.picoctl.command;

import picocli.CommandLine.Command;

@Command(
        name = "quit",
        aliases = {"q"},
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Quit app"
)
public class QuitCommand implements Runnable {

    @Override
    public void run() {
        System.exit(0);
    }
}
