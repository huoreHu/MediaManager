package com.huorehu.manager.model;

import java.io.IOException;
import java.util.List;

import com.huorehu.manager.controller.commands.MediaFile;

public interface Persistence {

    void addMedia(MediaFile media) throws IOException;

    void deleteMedia(MediaFile media);

    List<MediaFile> getAllMedia();

    void getMediaByStatus(StatusMedia status);

    List<MediaFile> getMediaByName(String name);

}
