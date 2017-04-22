package com.huorehu.manager.ui;

import java.util.Scanner;

public class ConsoleCommandsCatcher implements CommandsCatcher {

    private Scanner sc = new Scanner(System.in);

    private String commandName;
    private String fileName;

    @Override
    public String getCommandName() {
        commandName = sc.next();
        fileName = sc.nextLine().trim();
        return commandName;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    public Scanner getReader() {
        return sc;
    }

}
