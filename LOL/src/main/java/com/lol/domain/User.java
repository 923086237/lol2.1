package com.lol.domain;

public class User {
    private Short id;

    private String no;

    private String name;

    private String pwd;

    private Byte isStaff;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Byte getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(Byte isStaff) {
        this.isStaff = isStaff;
    }
}