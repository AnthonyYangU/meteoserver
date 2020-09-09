package com.example.demo.entity;

import java.lang.reflect.Field;

public class Pv extends Meteo {
    private Double rawvis;
    private Double vis;
    private Integer vis1a;
    private Integer vis2a;
    private Integer vis10a;
    private Integer vis10m;
    private Integer vis10x;

    private Integer sensor_vis10m;
    private String sensor_vis10m_dir;
    private Integer sensor_vis10x;
    private String sensor_vis10x_dir;

    public Double getRawvis() {
        return rawvis;
    }

    public void setRawvis(Double rawvis) {
        this.rawvis = rawvis;
    }

    public Double getVis() {
        return vis;
    }

    public void setVis(Double vis) {
        this.vis = vis;
    }

    public Integer getVis1a() {
        return vis1a;
    }

    public void setVis1a(Integer vis1a) {
        this.vis1a = vis1a;
    }

    public Integer getVis2a() {
        return vis2a;
    }

    public void setVis2a(Integer vis2a) {
        this.vis2a = vis2a;
    }

    public Integer getVis10a() {
        return vis10a;
    }

    public void setVis10a(Integer vis10a) {
        this.vis10a = vis10a;
    }

    public Integer getVis10m() {
        return vis10m;
    }

    public void setVis10m(Integer vis10m) {
        this.vis10m = vis10m;
    }

    public Integer getVis10x() {
        return vis10x;
    }

    public void setVis10x(Integer vis10x) {
        this.vis10x = vis10x;
    }

    public Integer getSensor_vis10m() {
        return sensor_vis10m;
    }

    public void setSensor_vis10m(Integer sensor_vis10m) {
        this.sensor_vis10m = sensor_vis10m;
    }

    public String getSensor_vis10m_dir() {
        return sensor_vis10m_dir;
    }

    public void setSensor_vis10m_dir(String sensor_vis10m_dir) {
        this.sensor_vis10m_dir = sensor_vis10m_dir;
    }

    public Integer getSensor_vis10x() {
        return sensor_vis10x;
    }

    public void setSensor_vis10x(Integer sensor_vis10x) {
        this.sensor_vis10x = sensor_vis10x;
    }

    public String getSensor_vis10x_dir() {
        return sensor_vis10x_dir;
    }

    public void setSensor_vis10x_dir(String sensor_vis10x_dir) {
        this.sensor_vis10x_dir = sensor_vis10x_dir;
    }

}
