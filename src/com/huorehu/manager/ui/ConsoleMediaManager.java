package com.huorehu.manager.ui;

import com.huorehu.manager.controller.commands.CommandsBank;
import com.huorehu.manager.controller.commands.UserCommandsBank;

public class ConsoleMediaManager {

    private MessageShower shower = new ConsoleMessageShower();
    private CommandsCatcher catcher = new ConsoleCommandsCatcher();
    private CommandsBank commandsBank = new UserCommandsBank(catcher);

    public void manage() {
        shower.showMainMenu();
        commandsBank.executeCommand();

    }

    public static void main(String[] args) {
        ConsoleMediaManager manager = new ConsoleMediaManager();
        manager.manage();
    }

}
