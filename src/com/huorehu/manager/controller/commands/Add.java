package com.huorehu.manager.controller.commands;

import java.io.IOException;

import com.huorehu.manager.model.StatusMedia;
import com.huorehu.manager.ui.CommandsCatcher;
import com.huorehu.manager.ui.ConsoleCommandsCatcher;
import com.huorehu.manager.ui.MessageShower;

public class Add implements UserCommand {

    private int tryCount = 0;

    private MessageShower shower;

    public Add(MessageShower shower) {
        this.shower = shower;
    }

    @Override
    public void executeCommand(CommandsCatcher catcher) {
        String name = catcher.getFileName();
        MediaFile media = new MediaFile(name);

        System.out.printf("What is '%s'?\n", name);
        System.out.println("");
        System.out.println("1. Book");
        System.out.println("2. Film");
        System.out.println("3. Music");

        choiceCategory(catcher, media);

        System.out.printf("What status set for the %s: '%s'\n", media.getCategory(), name);
        System.out.println("");
        System.out.println("1. " + StatusMedia.PROCESSED.getStatus(media.getCategory()));
        System.out.println("2. " + StatusMedia.PROCESSING.getStatus(media.getCategory()));
        System.out.println("3. " + StatusMedia.PROCESS.getStatus(media.getCategory()));

        choiceStatus(catcher, media);

        try {
            UserCommand.persistence.addMedia(media);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void choiceCategory(CommandsCatcher catcher, MediaFile media) {
        switch (((ConsoleCommandsCatcher) catcher).getReader().nextInt()) {
        case 1:
            media.setCategory("Book");
            break;
        case 2:
            media.setCategory("Film");
            break;
        case 3:
            media.setCategory("Music");
            break;
        default:
            System.out.println("Command not found. Try again.");
        }
    }

    private void choiceStatus(CommandsCatcher catcher, MediaFile media) {
        switch (((ConsoleCommandsCatcher) catcher).getReader().nextInt()) {
        case 1:
            media.setStatus(StatusMedia.PROCESSED.getStatus(media.getCategory()));
            break;
        case 2:
            media.setStatus(StatusMedia.PROCESSING.getStatus(media.getCategory()));
            break;
        case 3:
            media.setStatus(StatusMedia.PROCESS.getStatus(media.getCategory()));
            break;
        default:
            System.out.println("Command not found. Try again.");
            if (tryCount < 2) {
                tryCount++;
                choiceStatus(catcher, media);
            }
            if (tryCount == 2) {
                System.out.println("Exceeded try limit!");
            }
        }
        tryCount = 0;
    }

}
