package com.huorehu.manager.controller.commands;

import java.io.Serializable;

public class MediaFile implements Serializable {

    private final String name;
    private String category;
    private String status;

    public MediaFile(final String name, final String category, final String status) {
        this.name = name;
        this.category = category;
        this.status = status;
    }

    public MediaFile(final String name) {
        this(name, "not inicialized", "not inicialized");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;

    }

}
