package com.huorehu.manager.view;

import java.util.HashMap;
import java.util.Map;

public class UserInputsParser implements InputsParser {

    private static final int FIRST_LINE_SYMBOL = 0;
    private static final String SPACE_SYMBOL = " ";

    private int occurrenceSpace;

    @Override
    public Map<String, String> parseLine(String inputs) {
        Map<String, String> userInputs = new HashMap<>();
        userInputs.put("command", inputs.substring(FIRST_LINE_SYMBOL, occurrenceSpace = inputs.indexOf(SPACE_SYMBOL)));
        userInputs.put("fileName", inputs.substring(occurrenceSpace + 1, inputs.length()));
        return userInputs;
    }

}
