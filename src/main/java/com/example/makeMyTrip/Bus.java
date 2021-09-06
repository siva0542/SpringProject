package com.example.makeMyTrip;

public class Bus {
    public String getBus_type() {
        return bus_type;
    }

    public void setBus_type(String bus_type) {
        this.bus_type = bus_type;
    }

    public String getBus_number() {
        return bus_number;
    }

    public void setBus_number(String bus_number) {
        this.bus_number = bus_number;
    }

    public String getBus_speed() {
        return bus_speed;
    }

    public void setBus_speed(String bus_speed) {
        this.bus_speed = bus_speed;
    }

    private String bus_type;
    private String bus_number;
    private String bus_speed;
}
