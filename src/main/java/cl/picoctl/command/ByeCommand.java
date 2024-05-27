package cl.picoctl.command;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        name = "bye",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "bye command"
)
public class ByeCommand implements Runnable {

    @Option(names = {"-n", "--name"}, description = "User name")
    private String name = "World";

    @Override
    public void run() {
        System.out.printf("Bye, %s!%n", name);
    }
}
