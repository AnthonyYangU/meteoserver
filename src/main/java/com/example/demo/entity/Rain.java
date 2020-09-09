package com.example.demo.entity;

public class Rain extends Meteo {
    //降水传感器是否探测到降水0，没有，1，有
    private Double rainon;
    //从降水传感器得到的瞬时降水量
    private Double amount_ins;
    //从降水传感器得到的瞬时总降水量
    private Double sum_ins;
    //最近60min内的降水持续时间
    private Double duration_1h;
    //最近60min的总降水量
    private Double sum_1h;

    public Double getRainon() {
        return rainon;
    }

    public void setRainon(Double rainon) {
        this.rainon = rainon;
    }

    public Double getAmount_ins() {
        return amount_ins;
    }

    public void setAmount_ins(Double amount_ins) {
        this.amount_ins = amount_ins;
    }

    public Double getSum_ins() {
        return sum_ins;
    }

    public void setSum_ins(Double sum_ins) {
        this.sum_ins = sum_ins;
    }

    public Double getDuration_1h() {
        return duration_1h;
    }

    public void setDuration_1h(Double duration_1h) {
        this.duration_1h = duration_1h;
    }

    public Double getSum_1h() {
        return sum_1h;
    }

    public void setSum_1h(Double sum_1h) {
        this.sum_1h = sum_1h;
    }
}
