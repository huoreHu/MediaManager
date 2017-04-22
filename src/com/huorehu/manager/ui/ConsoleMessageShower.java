package com.huorehu.manager.ui;

public class ConsoleMessageShower implements MessageShower {

    @Override
    public void showMessage(String message) {
        System.out.println(message);

    }

    @Override
    public void showMainMenu() {
        System.out.println("Main menu:");
        System.out.println("1. Manage");
        System.out.println("2. Info");
        System.out.println("3. Exit");
    }

}
