package com.huorehu.manager.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.huorehu.manager.controller.commands.MediaFile;

public class PersistenceMediaData implements Persistence {

    private List<MediaFile> mediaList = new ArrayList<>();
    private Gson json = new Gson();

    private File file = new File("media.txt");
    private BufferedWriter writer;
    private BufferedReader reader;

    public PersistenceMediaData() {
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadDataToList();
    }

    @Override
    public void addMedia(MediaFile mediaAdd) throws IOException {
        for (MediaFile media : mediaList) {
            if (mediaAdd.getName().equals(media.getName()) && mediaAdd.getCategory().equals(media.getCategory())) {
                System.out.printf("Media %s: '%s' has already!\n", mediaAdd.getCategory(), mediaAdd.getName());
                return;
            }
        }
        mediaList.add(mediaAdd);
        writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(json.toJson(mediaAdd) + "\n");
        writer.flush();
        writer.close();
    }

    @Override
    public List<MediaFile> getAllMedia() {
        return mediaList;
    }

    @Override
    public List<MediaFile> getMediaByName(String name) {
        List<MediaFile> mediaForChanges = new ArrayList<>();
        for (MediaFile media : mediaList) {
            if (media.getName().equals(name)) {
                mediaForChanges.add(media);
            }
        }
        return mediaForChanges;
    }

    @Override
    public void getMediaByStatus(StatusMedia status) {

    }

    @Override
    public void deleteMedia(MediaFile mediaDeletable) {
        List<MediaFile> mediaForRewrite = new ArrayList<>();
        for (MediaFile media : mediaList) {
            if (!media.getName().equals(mediaDeletable.getName()) &&
                    !media.getCategory().equals(mediaDeletable.getCategory())) {
                mediaForRewrite.add(media);
            }
        }
        mediaList = mediaForRewrite;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (MediaFile media : mediaList) {
                writer.write(json.toJson(media) + "\n");
                writer.flush();
            }
            writer.close();
        } catch(IOException ie) {
            ie.printStackTrace();
        }

    }

    private void loadDataToList() {
        try {
            reader = new BufferedReader(new FileReader(file));
            while (reader.ready()) {
                mediaList.add(json.fromJson(reader.readLine(), MediaFile.class));
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }

}
