package com.huorehu.manager.controller.commands;

import com.huorehu.manager.model.Persistence;
import com.huorehu.manager.model.PersistenceMediaData;
import com.huorehu.manager.ui.CommandsCatcher;

public interface UserCommand {

    public static Persistence persistence = new PersistenceMediaData();

    void executeCommand(CommandsCatcher catcher);

}
