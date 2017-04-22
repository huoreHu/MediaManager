package com.huorehu.manager.controller.commands;

import com.huorehu.manager.ui.CommandsCatcher;
import com.huorehu.manager.ui.MessageShower;

public class GetList implements UserCommand {

    public GetList(MessageShower shower) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void executeCommand(CommandsCatcher catcher) {
        System.out.println("List of all media in base");
        for (MediaFile media : UserCommand.persistence.getAllMedia()) {
            System.out.printf("%s: '%s' with status '%s'\n", media.getCategory(), media.getName(), media.getStatus());
        }
    }

}
