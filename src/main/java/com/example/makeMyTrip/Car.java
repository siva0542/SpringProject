package com.example.makeMyTrip;

public class Car implements Vehicle{
    private String car_speed;

    public String getCar_speed() {
        return car_speed;
    }

    public void setCar_speed(String car_speed) {
        this.car_speed = car_speed;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    private String car_type;
    private String car_number;

}
