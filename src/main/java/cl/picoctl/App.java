package cl.picoctl;

import cl.picoctl.command.AppCommands;
import picocli.CommandLine;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new AppCommands());

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(">> ");

            String input = scanner.nextLine();
            String[] inputArgs = input.split(" ");

            int exitCode = commandLine.execute(inputArgs);
            System.out.println("Exit code: " + exitCode);
        }
    }
}
