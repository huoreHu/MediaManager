package com.huorehu.manager.controller.commands;

import java.util.HashMap;
import java.util.Map;

import com.huorehu.manager.ui.CommandsCatcher;
import com.huorehu.manager.ui.ConsoleMessageShower;
import com.huorehu.manager.ui.MessageShower;

public class UserCommandsBank implements CommandsBank {

    private static int mediaCount = 0;

    private CommandsCatcher catcher;

    private Map<String, UserCommand> commandsList = new HashMap<>();

    public UserCommandsBank(CommandsCatcher catcher) {
        this.catcher = catcher;
        inicializeCommandsList();
    }

    @Override
    public void executeCommand() {
        getCommand(catcher.getCommandName()).executeCommand(catcher);
    }

    private UserCommand getCommand(String command) throws IllegalArgumentException {
        if (null == validateCommand(command)) {
            throw new IllegalArgumentException("Illegal inputs!");
        }
        return commandsList.get(command);
    }

    private String validateCommand(String command) {
        if (null != command) {
            for (FateCommand fateCommand : FateCommand.values()) {
                if (command.equals(fateCommand.toString())) {
                    return command;
                }
            }
        }
        return null;

    }

    private void inicializeCommandsList() {
        MessageShower shower = new ConsoleMessageShower();
        commandsList.put(FateCommand.ADD.toString(), new Add(shower));
        commandsList.put(FateCommand.STATUS.toString(), new Status(shower));
        commandsList.put(FateCommand.GETLIST.toString(), new GetList(shower));
        commandsList.put(FateCommand.DELETE.toString(), new Delete(shower));

    }

    public static int getMediaCount() {
        return mediaCount;
    }

    public static void increaseMediaCount() {
        mediaCount++;
    }

}
