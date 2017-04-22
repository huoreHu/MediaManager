package com.huorehu.manager.model;

public enum StatusMedia {
    
    PROCESSED("READED", "VIEWED", "LISTENED"),
    PROCESSING("READING", "VIEWING", "LISTENING"),
    PROCESS("WANT READ", "WANT VIEW", "WANT LISTEN");

    private String statusBook;
    private String statusFilm;
    private String statusMusic;

    private StatusMedia(String statusBook, String statusFilm, String statusMusic) {
        this.statusBook = statusBook;
        this.statusFilm = statusFilm;
        this.statusMusic = statusMusic;
    }
    
    public String getStatus(String category) {
        if (category.equals("Book")) {
            return statusBook;
        }
        if (category.equals("Film")) {
            return statusFilm;
        }
        if (category.equals("Music")) {
            return statusMusic;
        }
        return null;
    }
    
}
