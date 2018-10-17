package com.lol.domain;

public class Authority {
    private Short id;

    private String aurl;

    private Byte parentId;

    private String title;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getAurl() {
        return aurl;
    }

    public void setAurl(String aurl) {
        this.aurl = aurl == null ? null : aurl.trim();
    }

    public Byte getParentId() {
        return parentId;
    }

    public void setParentId(Byte parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}