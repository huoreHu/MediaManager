package com.huorehu.manager.ui;

import java.util.InputMismatchException;

import com.huorehu.manager.controller.commands.CommandsBank;
import com.huorehu.manager.controller.commands.UserCommandsBank;

public class ConsoleMediaManager {

    private boolean continueProgramm = true;
    private MessageShower shower = new ConsoleMessageShower();
    private CommandsCatcher catcher = new ConsoleCommandsCatcher();
    private CommandsBank commandsBank = new UserCommandsBank(catcher);

    public void manage() {
        shower.showMessage("Enter command...");
        commandsBank.executeCommand();
    }

    private boolean getContinueProgramm() {
        return continueProgramm;
    }

    private void closeProgramm() {
        this.continueProgramm = false;
    }

    private CommandsCatcher getCatcher() {
        return catcher;
    }

    private MessageShower getShower() {
        return shower;
    }

    public static void main(String[] args) {
        ConsoleMediaManager manager = new ConsoleMediaManager();
        try {
            while (manager.getContinueProgramm()) {
                manager.getShower().showMainMenu();
                switch (((ConsoleCommandsCatcher) manager.getCatcher()).getReader().nextInt()) {
                case 1:
                    manager.manage();
                    break;
                case 2:
                    manager.getShower().info();
                    break;
                case 3:
                    manager.closeProgramm();
                    break;
                default:
                    System.out.println("Command not found. Try again.");
                }
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

}
