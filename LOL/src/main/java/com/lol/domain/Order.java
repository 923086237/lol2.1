package com.lol.domain;

import java.util.Date;

public class Order {
    private Short id;

    private String no;

    private String onumber;

    private String ocontent;

    private Date date;

    private Byte flag;

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

    public String getOnumber() {
        return onumber;
    }

    public void setOnumber(String onumber) {
        this.onumber = onumber == null ? null : onumber.trim();
    }

    public String getOcontent() {
        return ocontent;
    }

    public void setOcontent(String ocontent) {
        this.ocontent = ocontent == null ? null : ocontent.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }
}