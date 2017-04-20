package com.huorehu.manager.controller.commands;

public class GetList implements UserCommand {

    @Override
    public void executeCommand(String media) {
        System.out.println(media + "@GET_LIST");

    }

}
