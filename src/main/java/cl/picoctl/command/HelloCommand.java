package cl.picoctl.command;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        name = "hello",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Hello world command"
)
public class HelloCommand implements Runnable {

    @Option(names = {"-n", "--name"}, description = "User name")
    private String name = "World";

    @Override
    public void run() {
        System.out.printf("¡Hello, %s!%n", name);
    }
}
