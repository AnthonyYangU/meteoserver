package com.example.demo.entity;

import java.lang.reflect.Field;

public class Press extends Meteo {
    //瞬时气压
    private Double pains;
    //瞬时场面气压
    private Double qfe;
    //瞬时QFF
    private Double qff;
    //瞬时修正海平面气压
    private Double qnh;
    //*********计算后得到的参数

    private Double qfem;
    private Double qfex;
    private Double qfesynop;
    private Integer qfesynopt;
    private Double qfesynop3h;
    private Double fl;
    private Double alt;

    public Press() {
        super();
    }

    public Double getPains() {
        return pains;
    }

    public void setPains(Double pains) {
        this.pains = pains;
    }

    public Double getQfe() {
        return qfe;
    }

    public void setQfe(Double qfe) {
        this.qfe = qfe;
    }

    public Double getQff() {
        return qff;
    }

    public void setQff(Double qff) {
        this.qff = qff;
    }

    public Double getQnh() {
        return qnh;
    }

    public void setQnh(Double qnh) {
        this.qnh = qnh;
    }

    public Double getQfem() {
        return qfem;
    }

    public void setQfem(Double qfem) {
        this.qfem = qfem;
    }

    public Double getQfex() {
        return qfex;
    }

    public void setQfex(Double qfex) {
        this.qfex = qfex;
    }

    public Double getQfesynop() {
        return qfesynop;
    }

    public void setQfesynop(Double qfesynop) {
        this.qfesynop = qfesynop;
    }

    public Integer getQfesynopt() {
        return qfesynopt;
    }

    public void setQfesynopt(Integer qfesynopt) {
        this.qfesynopt = qfesynopt;
    }

    public Double getQfesynop3h() {
        return qfesynop3h;
    }

    public void setQfesynop3h(Double qfesynop3h) {
        this.qfesynop3h = qfesynop3h;
    }

    public Double getFl() {
        return fl;
    }

    public void setFl(Double fl) {
        this.fl = fl;
    }

    public Double getAlt() {
        return alt;
    }

    public void setAlt(Double alt) {
        this.alt = alt;
    }
}
