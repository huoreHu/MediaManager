package com.huorehu.manager.ui;

public class ConsoleMessageShower implements MessageShower {

    @Override
    public void showMessage(String message) {
        System.out.println(message);

    }

    @Override
    public void showMainMenu() {
        System.out.println("**************");
        System.out.println("* Main menu: *");
        System.out.println("**************");
        System.out.println("*  1. Manage *");
        System.out.println("*  2. Info   *");
        System.out.println("*  3. Exit   *");
        System.out.println("**************");
    }

    @Override
    public void info() {
        System.out.println("Info about programm commands:");
        System.out.println("<add> <Media Name> - adding new media with name 'Media Name' in base. Command and Media Name type without '<>'.");
        System.out.println("<changestatus> <Media Name> - changing status for media with name 'Media Name'.");
        System.out.println("<getallmedia> - show all media wich saved in base.");
        System.out.println("<delete> <Media Name> - delete media with name 'Media Name'.");
    }

}
