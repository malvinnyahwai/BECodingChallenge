package com.malvin.becodingchallenge.console;

import com.malvin.becodingchallenge.handler.ConsoleHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Console implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(Console.class);
    private final ConsoleHandler consoleHandler;

    public Console(ConsoleHandler consoleHandler) {
        this.consoleHandler = consoleHandler;
    }

    @Override
    public void run(String... args) {
        while(true) {
            System.out.println("Enter full file path: ");
            Scanner scanner = new Scanner(System.in);
            String source = scanner.nextLine();
            if(source.equalsIgnoreCase("exit") || source.equalsIgnoreCase("quit")) {
                logger.info("Exiting...");
                break;
            }
            System.out.println(consoleHandler.handle(source));
        }
    }
}
