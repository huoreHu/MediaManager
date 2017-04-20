package com.huorehu.manager.controller.commands;

public class Status implements UserCommand {

    @Override
    public void executeCommand(String media) {
        System.out.println(media + "@STATUS");

    }

}
