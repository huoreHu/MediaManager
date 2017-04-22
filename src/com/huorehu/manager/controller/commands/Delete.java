package com.huorehu.manager.controller.commands;

import java.util.List;

import com.huorehu.manager.ui.CommandsCatcher;
import com.huorehu.manager.ui.ConsoleCommandsCatcher;
import com.huorehu.manager.ui.MessageShower;

public class Delete implements UserCommand {

    private int tryCount = 0;

    public Delete(MessageShower shower) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void executeCommand(CommandsCatcher catcher) {
        int mediaNumber = 0;
        List<MediaFile> mediaForChanges = UserCommand.persistence.getMediaByName(catcher.getFileName());
        if (mediaForChanges.size() > 1) {
            System.out.println("What kind of media delete?");
            for (MediaFile media : mediaForChanges) {
                System.out.printf("%d. %s: '%s'", mediaNumber + 1, media.getCategory(), media.getName());
            }
            choiceNumberDelete(catcher, mediaNumber);
        }

        UserCommand.persistence.deleteMedia(mediaForChanges.get(mediaNumber));
        System.out.printf("%s: '%s' was deleted!\n", mediaForChanges.get(mediaNumber).getCategory(),
                mediaForChanges.get(mediaNumber).getName());

    }

    private void choiceNumberDelete(CommandsCatcher catcher, int mediaNumber) {
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
                choiceNumberDelete(catcher, mediaNumber);
            }
            if (tryCount == 2) {
                System.out.println("Exceeded try limit!");
            }
        }
        tryCount = 0;
    }
}
