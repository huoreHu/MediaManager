package com.huorehu.manager.controller.commands;

public class Add implements UserCommand {

    @Override
    public void executeCommand(String media) {
        System.out.println(media + "@ADD");

    }

}
