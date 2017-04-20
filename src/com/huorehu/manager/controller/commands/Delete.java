package com.huorehu.manager.controller.commands;

public class Delete implements UserCommand {

    @Override
    public void executeCommand(String media) {
        System.out.println(media + "@DELETE");

    }

}
