package com.example.demo.entity;

public class Humitemp extends Meteo {
    //瞬时温度
    private Double tains;
    //瞬时露点值
    private Double tdins;
    //瞬时相对湿度
    private Double rhins;
    //瞬时水汽压
    private Double vpins;
    //经计算得到的数据
    private Double ta10m;
    private Double ta1x;
    private Double ta1ha;
    private Double ta1hx;

    public Double getTa10m() {
        return ta10m;
    }

    public void setTa10m(Double ta10m) {
        this.ta10m = ta10m;
    }

    public Double getTa1x() {
        return ta1x;
    }

    public void setTa1x(Double ta1x) {
        this.ta1x = ta1x;
    }

    public Double getTa1ha() {
        return ta1ha;
    }

    public void setTa1ha(Double ta1ha) {
        this.ta1ha = ta1ha;
    }

    public Double getTa1hx() {
        return ta1hx;
    }

    public void setTa1hx(Double ta1hx) {
        this.ta1hx = ta1hx;
    }

    public Double getTains() {
        return tains;
    }

    public void setTains(Double tains) {
        this.tains = tains;
    }

    public Double getTdins() {
        return tdins;
    }

    public void setTdins(Double tdins) {
        this.tdins = tdins;
    }

    public Double getRhins() {
        return rhins;
    }

    public void setRhins(Double rhins) {
        this.rhins = rhins;
    }

    public Double getVpins() {
        return vpins;
    }

    public void setVpins(Double vpins) {
        this.vpins = vpins;
    }
}
