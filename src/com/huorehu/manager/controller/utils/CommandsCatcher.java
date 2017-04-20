package com.huorehu.manager.controller.utils;

import java.util.Map;

import com.huorehu.manager.view.InputsParser;

public class CommandsCatcher {

    private String commandName;
    private String fileName;

    private InputsParser inputsParser;

    public CommandsCatcher(InputsParser inputsParser) {
        this.inputsParser = inputsParser;
    }

    public void catchCommand(String inputs) {
        Map<String, String> userInputs = inputsParser.parseLine(inputs);
        commandName = userInputs.get("command");
        fileName = userInputs.get("fileName");
    }

    public String getCommandName() {
        return commandName;
    }

    public String getFileName() {
        return fileName;
    }

}
