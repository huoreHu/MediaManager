package com.huorehu.manager.controller.commands;

import java.io.IOException;
import java.util.List;

import com.huorehu.manager.model.StatusMedia;
import com.huorehu.manager.ui.CommandsCatcher;
import com.huorehu.manager.ui.ConsoleCommandsCatcher;
import com.huorehu.manager.ui.MessageShower;

public class Status implements UserCommand {

    private int tryCount = 0;

    public Status(MessageShower shower) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void executeCommand(CommandsCatcher catcher) {
        int mediaNumber = 0;
        List<MediaFile> mediaForChanges = UserCommand.persistence.getMediaByName(catcher.getFileName());
        if (mediaForChanges.size() > 1) {
            System.out.println("What kind of media change status?");
            for (MediaFile media : mediaForChanges) {
                System.out.printf("%d. %s: '%s'", mediaNumber + 1, media.getCategory(), media.getName());
            }
            choiceNumberMedia(catcher, mediaNumber);
        }

        MediaFile media = mediaForChanges.get(mediaNumber);
        System.out.printf("What status set for the %s: '%s'\n", media.getCategory(), media.getName());
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
        System.out.printf("Status for media %s: %s was changed to %s", mediaForChanges.get(mediaNumber).getCategory(), mediaForChanges.get(mediaNumber).getName(), mediaForChanges.get(mediaNumber).getStatus());

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

    private void choiceNumberMedia(CommandsCatcher catcher, int mediaNumber) {
        switch (((ConsoleCommandsCatcher) catcher).getReader().nextInt()) {
        case 1:
            mediaNumber = 0;
            break;
        case 2:
            mediaNumber = 1;
            break;
        case 3:
            mediaNumber = 2;
            break;
        default:
            System.out.println("Command not found. Try again.");
            if (tryCount < 2) {
                tryCount++;
                choiceNumberMedia(catcher, mediaNumber);
            }
            if (tryCount == 2) {
                System.out.println("Exceeded try limit!");
            }
        }
        tryCount = 0;
    }

}
