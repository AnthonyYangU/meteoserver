package com.example.demo.entity;

public class Rosa extends Meteo {
    private Double stemp;
    private Double gstemp;
    private Integer surfsta;
    private String alarm_status;
    private String rain_status;
    private String surface_status;

    public Double getStemp() {
        return stemp;
    }

    public void setStemp(Double stemp) {
        this.stemp = stemp;
    }

    public Double getGstemp() {
        return gstemp;
    }

    public void setGstemp(Double gstemp) {
        this.gstemp = gstemp;
    }

    public Integer getSurfsta() {
        return surfsta;
    }

    public void setSurfsta(Integer surfsta) {
        this.surfsta = surfsta;
    }

    public String getAlarm_status() {
        return alarm_status;
    }

    public void setAlarm_status(String alarm_status) {
        this.alarm_status = alarm_status;
    }

    public String getRain_status() {
        return rain_status;
    }

    public void setRain_status(String rain_status) {
        this.rain_status = rain_status;
    }

    public String getSurface_status() {
        return surface_status;
    }

    public void setSurface_status(String surface_status) {
        this.surface_status = surface_status;
    }
}
