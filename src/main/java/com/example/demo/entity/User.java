package com.example.demo.entity;

public class User extends Meteo {
    private String name;
    private String address;

    public User(){

    }

    public User(String name,String address){
        this.setName(name);
        this.setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
