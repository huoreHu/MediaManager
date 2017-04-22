package com.huorehu.manager.controller.commands;

import com.huorehu.manager.ui.CommandsCatcher;
import com.huorehu.manager.ui.MessageShower;

public class GetList implements UserCommand {

    public GetList(MessageShower shower) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void executeCommand(CommandsCatcher catcher) {
        System.out.println(catcher.getFileName() + "@GET_LIST");

    }

}
