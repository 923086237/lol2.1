package com.lol.domain;

public class Scart {
    private Short id;

    private String no;

    private Short hid;

    private Short sid;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Short getHid() {
        return hid;
    }

    public void setHid(Short hid) {
        this.hid = hid;
    }

    public Short getSid() {
        return sid;
    }

    public void setSid(Short sid) {
        this.sid = sid;
    }
}