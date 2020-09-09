package com.example.demo.entity;

public class Rwylights extends Meteo {
    private String lights;
    private Integer ismanual;
    private String info;
    private Integer leftLightStatus;
    private Integer rightLightStatus;

    public Integer getLeftLightStatus() {
        return leftLightStatus;
    }

    public void setLeftLightStatus(Integer leftLightStatus) {
        this.leftLightStatus = leftLightStatus;
    }

    public Integer getRightLightStatus() {
        return rightLightStatus;
    }

    public void setRightLightStatus(Integer rightLightStatus) {
        this.rightLightStatus = rightLightStatus;
    }

    public String getLights() {
        return lights;
    }

    public void setLights(String lights) {
        this.lights = lights;
    }

    public Integer getIsmanual() {
        return ismanual;
    }

    public void setIsmanual(Integer ismanual) {
        this.ismanual = ismanual;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
