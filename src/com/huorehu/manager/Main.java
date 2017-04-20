package com.huorehu.manager;

import java.util.Scanner;

import com.huorehu.manager.controller.commands.CommandsBank;
import com.huorehu.manager.controller.commands.UserCommandsBank;
import com.huorehu.manager.controller.utils.CommandsCatcher;
import com.huorehu.manager.view.UserInputsParser;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserInputsParser inputsParser = new UserInputsParser();
        CommandsCatcher catcher = new CommandsCatcher(inputsParser);
        CommandsBank commandsBank = new UserCommandsBank();

        catcher.catchCommand(sc.nextLine());
        try {
            commandsBank.executeCommand(catcher.getCommandName(), catcher.getFileName());
        } catch (IllegalArgumentException ie) {
            System.out.println("Command not found!");
        }

    }

}
