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
        int mediaNumber = 1;
        List<MediaFile> mediaForChanges = UserCommand.persistence.changeStatus(catcher.getFileName());
        if (mediaForChanges.size() > 1) {
            System.out.println("What kind of media change status?");
            for (MediaFile media : mediaForChanges) {
                System.out.printf("%d. %s: '%s'", mediaNumber, media.getCategory(), media.getName());
            }
        }
        
        choiceStatus(catcher, mediaForChanges.get(mediaNumber));
        UserCommand.persistence.deleteMedia(mediaForChanges.get(mediaNumber)); //need to implement
        try {
            UserCommand.persistence.addMedia(mediaForChanges.get(mediaNumber));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Status for media %s: %s was changed to %s", mediaForChanges.get(mediaNumber).getCategory(),
                mediaForChanges.get(mediaNumber).getName(), mediaForChanges.get(mediaNumber).getStatus());
        
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
