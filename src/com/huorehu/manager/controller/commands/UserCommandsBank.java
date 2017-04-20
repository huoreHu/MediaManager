package com.huorehu.manager.controller.commands;

import java.util.HashMap;
import java.util.Map;

public class UserCommandsBank implements CommandsBank {

    private Map<String, UserCommand> commandsList = new HashMap<>();

    public UserCommandsBank() {
        inicializeCommandsList();
    }

    @Override
    public void executeCommand(String commandName, String fileName) {
        getCommand(commandName).executeCommand(fileName);
    }

    private UserCommand getCommand(String command) throws IllegalArgumentException {
        if (null == validateCommand(command)) {
            throw new IllegalArgumentException("Command not found!");
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
        commandsList.put(FateCommand.ADD.toString(), new Add());
        commandsList.put(FateCommand.STATUS.toString(), new Status());
        commandsList.put(FateCommand.GETLIST.toString(), new GetList());
        commandsList.put(FateCommand.DELETE.toString(), new Delete());

    }

}
