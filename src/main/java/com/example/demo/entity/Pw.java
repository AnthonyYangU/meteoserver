package com.example.demo.entity;

import java.lang.reflect.Field;

//天气现象
public class Pw extends Meteo {
    private String pw;
    private String rw;
    private String wxnws;
    private Integer wmoins;
    private Integer wmo15a;
    private Integer wmo60a;
    private String prw1a;
    private String prws;
    private String prss;
    private String tbins;

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public String getWxnws() {
        return wxnws;
    }

    public void setWxnws(String wxnws) {
        this.wxnws = wxnws;
    }

    public Integer getWmoins() {
        return wmoins;
    }

    public void setWmoins(Integer wmoins) {
        this.wmoins = wmoins;
    }

    public Integer getWmo15a() {
        return wmo15a;
    }

    public void setWmo15a(Integer wmo15a) {
        this.wmo15a = wmo15a;
    }

    public Integer getWmo60a() {
        return wmo60a;
    }

    public void setWmo60a(Integer wmo60a) {
        this.wmo60a = wmo60a;
    }

    public String getPrw1a() {
        return prw1a;
    }

    public void setPrw1a(String prw1a) {
        this.prw1a = prw1a;
    }

    public String getPrws() {
        return prws;
    }

    public void setPrws(String prws) {
        this.prws = prws;
    }

    public String getPrss() {
        return prss;
    }

    public void setPrss(String prss) {
        this.prss = prss;
    }

    public String getTbins() {
        return tbins;
    }

    public void setTbins(String tbins) {
        this.tbins = tbins;
    }
}
